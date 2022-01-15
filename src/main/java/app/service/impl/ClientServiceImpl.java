package app.service.impl;

import app.domain.Client;
import app.domain.User;
import app.dto.ClientCreateDto;
import app.dto.ClientDto;
import app.dto.ClientUpdateDto;
import app.dto.notificationDtos.VerifyMailDto;
import app.exception.NotFoundException;
import app.mapper.ClientMapper;
import app.messageHelper.MessageHelper;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import app.repository.ClientRepository;
import app.service.ClientService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10.01.2022. by Andrija inside package app.service.impl.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    private UserRepository userRepository;

    private String destinationVerifyMail;
    private MessageHelper messageHelper;
    private JmsTemplate jmsTemplate;


    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper, UserRepository userRepository,
                             @Value("${destination.verifyMail}") String  destinationVerifyMail, MessageHelper messageHelper, JmsTemplate jmsTemplate) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.userRepository = userRepository;
        this.destinationVerifyMail = destinationVerifyMail;
        this.messageHelper = messageHelper;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Page<ClientDto> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(clientMapper::clientToClientDto);
    }

    @Override
    public ClientDto add(ClientCreateDto clientCreateDto) {
        Client client = clientMapper.clientCreateDtoToClient(clientCreateDto);

        VerifyMailDto verifyMailDto = new VerifyMailDto(clientCreateDto.getFirstName(), clientCreateDto.getLastName(), clientCreateDto.getEmail());
        jmsTemplate.convertAndSend(destinationVerifyMail, messageHelper.createTextMessage(verifyMailDto));

        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ClientDto findById(Long id) {
        return clientRepository.findById((id))
                .map(clientMapper::clientToClientDto)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d not found.", id)));
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById((id));
    }

    @Override
    public void updateCLientProfile(Long id, ClientUpdateDto clientUpdateDto) {
        Client client = clientRepository.findById((id))
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d not found.", id)));
        User user = client.getUser();
        user.setFirstName(clientUpdateDto.getFirstName());
        user.setLastName(clientUpdateDto.getLastName());
        user.setUsername(clientUpdateDto.getUsername());
        user.setPhoneNumber(clientUpdateDto.getPhoneNumber());
        user.setBirthDate(clientUpdateDto.getBirthDate());
        userRepository.save(user);
        client.setPassportNo(clientUpdateDto.getPassportNumber());
        clientRepository.save(client);
    }
}
