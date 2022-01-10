package app.mapper;

import app.domain.Client;
import app.dto.ClientCreateDto;
import app.dto.ClientDto;
import app.exception.NotFoundException;
import app.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * Created on 10.01.2022. by Andrija inside package app.mapper.
 */
@Component
public class ClientMapper {
    private UserMapper userMapper;
    private UserRepository userRepository;

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setPassportNo(client.getPassportNo());
        clientDto.setReservationNo(client.getReservationNo());
        clientDto.setUserDto(userMapper.userToUserDto(client.getUser()));
        return clientDto;
    }

    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        Client client = new Client();
      //  client.setId(clientCreateDto.getId());
        client.setPassportNo(clientCreateDto.getPassportNo());
        client.setReservationNo(clientCreateDto.getReservationNo());
        client.setUser(userRepository.findById(clientCreateDto.getUserId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d does not exists.", clientCreateDto.getUserId()))));
        return client;
    }
}
