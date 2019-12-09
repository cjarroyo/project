package pe.com.bcp.demo.project.convert.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ConvertRequest {
    private String sourceMoney;
    private String targetMoney;
    private Double amount;
}
