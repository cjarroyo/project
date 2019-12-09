package pe.com.bcp.demo.project.typechange.business;


import lombok.Builder;
import pe.com.bcp.demo.project.money.entity.Money;
import pe.com.bcp.demo.project.money.service.MoneyService;
import pe.com.bcp.demo.project.typechange.dto.TypeChangeRequest;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;
import pe.com.bcp.demo.project.typechange.service.TypeChangeService;

@Builder
public class TypeChangeGetData {
    private MoneyService moneyService;
    private TypeChangeService typeChangeService;

    public TypeChange preparedUpdateTypeChange(final TypeChangeRequest typeChangeRequest) {
        Money sourceMoney = moneyService.findByShortDescription(typeChangeRequest.getSourceMoney());
        Money targetMoney = moneyService.findByShortDescription(typeChangeRequest.getTargetMoney());
        TypeChange typeChange = typeChangeService.findBySourceAndTarget(sourceMoney.getId(), targetMoney.getId());
        typeChange.setChange(typeChangeRequest.getChange());
        return typeChange;
    }
}
