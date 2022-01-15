package app.service.impl;

import app.domain.Client;
import app.domain.Manager;
import app.domain.User;
import app.dto.ManagerCreateDto;
import app.dto.ManagerDto;
import app.dto.ManagerUpdateDto;
import app.dto.notificationDtos.VerifyMailDto;
import app.exception.NotFoundException;
import app.mapper.ManagerMapper;
import app.messageHelper.MessageHelper;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import app.repository.ManagerRepository;
import app.service.ManagerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10.01.2022. by Andrija inside package app.service.impl.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;
    private ManagerMapper managerMapper;
    private UserRepository userRepository;
    private JmsTemplate jmsTemplate;
    private String destinationVerifyMail;
    private MessageHelper messageHelper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper, UserRepository userRepository,
                 JmsTemplate jmsTemplate, @Value("${destination.verifyMail}") String  destinationVerifyMail,MessageHelper messageHelper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
        this.userRepository = userRepository;
        this.destinationVerifyMail = destinationVerifyMail;
        this.messageHelper = messageHelper;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Page<ManagerDto> findAll(Pageable pageable) {
        return managerRepository.findAll(pageable)
                .map(managerMapper::managerToManagerDto);
    }

    @Override
    public ManagerDto add(ManagerCreateDto managerCreateDto) {
        Manager manager = managerMapper.managerCreateDtoToManager(managerCreateDto);

        VerifyMailDto verifyMailDto = new VerifyMailDto(managerCreateDto.getFirstName(), managerCreateDto.getLastName(), managerCreateDto.getEmail());
        jmsTemplate.convertAndSend(destinationVerifyMail, messageHelper.createTextMessage(verifyMailDto));

        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public ManagerDto findById(Long id) {
        return managerRepository.findById((id))
                .map(managerMapper::managerToManagerDto)
                .orElseThrow(() -> new NotFoundException(String.format("Manager with id: %d not found.", id)));
    }

    @Override
    public void deleteById(Long id) {
        managerRepository.deleteById((id));
    }

    @Override
    public void updateManagerProfile(Long id, ManagerUpdateDto managerUpdateDto) {
        Manager manager = managerRepository.findByUser_Id(id)
                .orElseThrow(() -> new NotFoundException(String.format("Manager with id: %d not found.", id)));
        User user = manager.getUser();
        user.setFirstName(managerUpdateDto.getFirstName());
        user.setLastName(managerUpdateDto.getLastName());
        user.setUsername(managerUpdateDto.getUsername());
        user.setPhoneNumber(managerUpdateDto.getPhoneNumber());
        user.setBirthDate(managerUpdateDto.getBirthDate());

        userRepository.save(user);
        manager.setHotel(managerUpdateDto.getHotel());
        managerRepository.save(manager);
    }

}
