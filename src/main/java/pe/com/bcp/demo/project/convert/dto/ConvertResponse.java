package pe.com.bcp.demo.project.convert.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ConvertResponse {
    private Double changedAmount;
}
