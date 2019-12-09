package pe.com.bcp.demo.project.money.service;

import pe.com.bcp.demo.project.money.entity.Money;

import java.util.List;

public interface MoneyService {

    Money findById(Integer id);

    Money findByShortDescription(String sourceMoney);

    List<Money> retrieveList();
}
