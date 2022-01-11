package app.controller;

import app.domain.User;
import app.dto.TokenRequestDto;
import app.dto.TokenResponseDto;
import app.dto.UserDto;
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
    @PutMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> editAccessPremission(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id, boolean hasAccess){
        userService.editAccess(id,hasAccess);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
