package controller;


import dto.AdminCreateDto;
import dto.AdminDto;
import dto.ClientDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AdminService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
    public ResponseEntity<Page<AdminDto>> findAll(@ApiIgnore Pageable pageable){
        return new ResponseEntity<>(adminService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdminDto> add(@RequestBody @Valid AdminCreateDto adminCreateDto){
        return new ResponseEntity<>(adminService.add(adminCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(adminService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        adminService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
