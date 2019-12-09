package pe.com.bcp.demo.project.convert.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pe.com.bcp.demo.project.money.entity.Money;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;

@Getter
@Setter
@Builder
public class GetDataDto {
    private TypeChange typeChange;
    private double amount;
}
