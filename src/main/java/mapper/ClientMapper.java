package mapper;

import domain.Client;
import dto.ClientCreateDto;
import dto.ClientDto;
import exception.NotFoundException;
import repository.UserHolderRepository;

/**
 * Created on 10.01.2022. by Andrija inside package mapper.
 */
public class ClientMapper {
    private UserHolderMapper userHolderMapper;
    private UserHolderRepository userHolderRepository;

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setPassportNo(client.getPassportNo());
        clientDto.setReservationNo(client.getReservationNo());
        clientDto.setUserHolderDto(userHolderMapper.userHolderToUserHolderDto(client.getUserHolder()));
        return clientDto;
    }

    public Client clientDtoToClient(ClientCreateDto clientCreateDto){
        Client client = new Client();
        client.setId(clientCreateDto.getId());
        client.setPassportNo(clientCreateDto.getPassportNo());
        client.setReservationNo(clientCreateDto.getReservationNo());
        client.setUserHolder(userHolderRepository.findById(clientCreateDto.getUserHolderId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("UserHolder with id: %d does not exists.", clientCreateDto.getUserHolderId()))));
        return client;
    }
}
