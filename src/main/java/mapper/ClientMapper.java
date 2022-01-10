package mapper;

import domain.Client;
import dto.ClientCreateDto;
import dto.ClientDto;
import exception.NotFoundException;
import repository.UserRepository;

/**
 * Created on 10.01.2022. by Andrija inside package mapper.
 */
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

    public Client clientDtoToClient(ClientCreateDto clientCreateDto){
        Client client = new Client();
        client.setId(clientCreateDto.getId());
        client.setPassportNo(clientCreateDto.getPassportNo());
        client.setReservationNo(clientCreateDto.getReservationNo());
        client.setUser(userRepository.findById(clientCreateDto.getUserId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d does not exists.", clientCreateDto.getUserId()))));
        return client;
    }
}
