package app.mapper;

import app.domain.Client;
import app.domain.User;
import app.dto.ClientCreateDto;
import app.dto.ClientDto;
import app.exception.NotFoundException;
import app.repository.RankRepository;
import app.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * Created on 10.01.2022. by Andrija inside package app.mapper.
 */
@Component
public class ClientMapper {
    private UserMapper userMapper;
    private UserRepository userRepository;
    private RankRepository rankRepository;

    public ClientMapper(UserMapper userMapper, UserRepository userRepository, RankRepository rankRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.rankRepository = rankRepository;
    }

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setPassportNo(client.getPassportNo());
        clientDto.setReservationNo(client.getReservationNo());
        clientDto.setUserDto(userMapper.userToUserDto(client.getUser()));
        return clientDto;
    }

    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        User user = new User();
        user.setEmail(clientCreateDto.getEmail());
        user.setFirstName(clientCreateDto.getFirstName());
        user.setLastName(clientCreateDto.getLastName());
        user.setUsername(clientCreateDto.getUsername());
        user.setPassword(clientCreateDto.getPassword());
        user.setPhoneNumber(clientCreateDto.getPhoneNumber());
        user.setBirthDate(clientCreateDto.getBirthDate());
        user.setAccessEnabled(Boolean.TRUE);
        user.setRank(rankRepository.findRankByName("BRONZE")
                .orElseThrow(() -> new NotFoundException(String
                        .format("Rank with name: %s does not exists.","BRONZE"))));
        user.setRole("ROLE_CLIENT");
        userRepository.save(user);

        Client client = new Client();
        client.setPassportNo(clientCreateDto.getPassportNo());
        client.setReservationNo(clientCreateDto.getReservationNo());
//        client.setUser(userRepository.findById(clientCreateDto.getUserId())
//                .orElseThrow(() -> new NotFoundException(String
//                        .format("User with id: %d does not exists.", clientCreateDto.getUserId()))));
        client.setUser(user);
        return client;
    }
}
