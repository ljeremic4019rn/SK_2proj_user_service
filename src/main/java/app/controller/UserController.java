package app.controller;

import app.dto.*;
import app.dto.notificationDtos.UserPasswordDto;
import app.security.CheckSecurity;
import app.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on 10.01.2022. by Andrija inside package app.controller.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //todo stavi authorization role user svuda isto za sotale stavi

    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("Authorization") String authorization, Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
//        ResponseEntity<?> responseEntity = new ResponseEntity(userService.login(tokenRequestDto), HttpStatus.OK);
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
//        return responseEntity;
    }

    @ApiOperation(value = "edit user access")
    @PutMapping("/{id}/ban_unban")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> updateAccess(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id, boolean hasAccess){
        userService.editAccess(id,hasAccess);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Change user password")
    @PutMapping (value = "/{id}/changePassword")
    @CheckSecurity(roles = {"ROLE_ADMIN","ROLE_MANAGER","ROLE_CLIENT"})
    public ResponseEntity<?> changePassword(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id, @RequestBody @Valid UserPasswordDto userPasswordDto){
        userPasswordDto.setId(id);//da bi bio isti id kao ukucani
        userService.changePassword(id, userPasswordDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "save new user passwrod")
    @GetMapping(value = "/{id}/saveNewPassword")
    public ResponseEntity<?> savePassword(@PathVariable("id") Long id){
        userService.saveNewPassword(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation(value = "Verify email")
    @GetMapping (value = "verifyMail/{email}")
    public ResponseEntity<?> setVerifiedMail(@PathVariable("email") String email ){
        userService.verifyMail(email); //tmp comment
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
