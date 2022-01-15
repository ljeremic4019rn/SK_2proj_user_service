package app.controller;

import app.dto.ClientCreateDto;
import app.dto.ClientDto;
import app.dto.ClientUpdateDto;
import app.dto.notificationDtos.UserPasswordDto;
import app.security.CheckSecurity;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.service.ClientService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {


    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @ApiOperation(value = "Get all clients")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<Page<ClientDto>> findAll(@RequestHeader("Authorization") String authorization, @ApiIgnore Pageable pageable){
        return new ResponseEntity<>(clientService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ClientDto> add(@RequestBody @Valid ClientCreateDto clientCreateDto){
        return new ResponseEntity<>(clientService.add(clientCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientDto> findById(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id){
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Update profile")
    @PutMapping (value = "/{id}/updateProfile")
    @CheckSecurity(roles = {"ROLE_CLIENT"})
    public ResponseEntity<?> updateProfile(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id, @RequestBody @Valid ClientUpdateDto clientUpdateDto){
        clientService.updateCLientProfile(id, clientUpdateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

