package pe.com.bcp.demo.project.convert.business;

import lombok.Builder;
import pe.com.bcp.demo.project.convert.dto.ConvertRequest;
import pe.com.bcp.demo.project.convert.dto.GetDataDto;
import pe.com.bcp.demo.project.money.entity.Money;
import pe.com.bcp.demo.project.money.service.MoneyService;
import pe.com.bcp.demo.project.typechange.service.TypeChangeService;

@Builder
public class ConvertGetData {
    private MoneyService moneyService;
    private TypeChangeService typeChangeService;

    public GetDataDto preparedData(final ConvertRequest request) {
        Money sourceMoney = moneyService.findByShortDescription(request.getSourceMoney());
        Money targetMoney = moneyService.findByShortDescription(request.getTargetMoney());
        return GetDataDto.builder().
                typeChange(typeChangeService.findBySourceAndTarget(sourceMoney.getId(), targetMoney.getId())).
                amount(request.getAmount()).
                build();
    }


}
