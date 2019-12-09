package pe.com.bcp.demo.project.money.service.impl;

import lombok.Builder;
import pe.com.bcp.demo.project.money.entity.Money;
import pe.com.bcp.demo.project.money.repository.MoneyRepository;
import pe.com.bcp.demo.project.money.service.MoneyService;

import java.util.List;
import java.util.Optional;

@Builder
public class MoneyServiceImpl implements MoneyService {
    private MoneyRepository moneyRepository;


    @Override
    public Money findById(final Integer id) {
        Optional<Money> optinalEntity = moneyRepository.findById(id);
        return optinalEntity.get();
    }

    @Override
    public Money findByShortDescription(final String sourceMoney) {
        return moneyRepository.findByShortDescription(sourceMoney);
    }

    @Override
    public List<Money> retrieveList() {
        return moneyRepository.findAll();
    }

}
