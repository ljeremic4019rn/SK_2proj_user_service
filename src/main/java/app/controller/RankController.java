package app.controller;

import app.domain.Rank;
import app.dto.AdminDto;
import app.dto.ClientDto;
import app.dto.RankCreateDto;
import app.dto.RankDto;
import app.security.CheckSecurity;
import app.service.RankService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/rank")
public class RankController {

    private RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @ApiOperation(value = "Get all ranks")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping
    public ResponseEntity<Page<RankDto>> findAll(@ApiIgnore Pageable pageable){
        return new ResponseEntity<>(rankService.findAll(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "edit rank")
    @PutMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<?> editAccessPremission(@RequestHeader("Authorization") String authorization, String name, @RequestBody @Valid RankCreateDto rankCreateDto){
        rankService.editRankByName(name, rankCreateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
