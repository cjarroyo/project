package pe.com.bcp.demo.project.convert.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.demo.project.convert.business.ConvertBusiness;
import pe.com.bcp.demo.project.convert.dto.ConvertRequest;
import pe.com.bcp.demo.project.convert.dto.ConvertResponse;

@RestController
@Api("Service to convert the moneys")
@RequestMapping("/convert")
public class ConvertController {
    private ConvertBusiness convertBusiness;

    public ConvertController(final ConvertBusiness convertBusiness) {
        this.convertBusiness = convertBusiness;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "converter money", notes = "converter money")
    public ConvertResponse convertMoney(@RequestBody final ConvertRequest request) {
        return convertBusiness.convertMoney(request);
    }

}
