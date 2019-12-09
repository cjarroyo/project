package pe.com.bcp.demo.project.money.business;

import lombok.Builder;
import pe.com.bcp.demo.project.money.entity.Money;
import pe.com.bcp.demo.project.money.service.MoneyService;

import java.util.List;

@Builder
public class MoneyBusiness {
    private MoneyService moneyService;

    public List<Money> retrieveList() {
        return moneyService.retrieveList();
    }
}
