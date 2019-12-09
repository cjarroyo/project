package pe.com.bcp.demo.project.money.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.demo.project.money.business.MoneyBusiness;
import pe.com.bcp.demo.project.money.entity.Money;

import java.util.List;

@RestController
@RequestMapping("/money")
public class MoneyController {
    private MoneyBusiness MoneyBusiness;

    public MoneyController(final MoneyBusiness moneyBusiness) {
        MoneyBusiness = moneyBusiness;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "list money", notes = "money")
    public List<Money> retrieveList() {
        return MoneyBusiness.retrieveList();
    }
}
