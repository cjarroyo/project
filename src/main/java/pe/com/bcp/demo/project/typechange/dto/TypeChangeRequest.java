package pe.com.bcp.demo.project.typechange.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TypeChangeRequest {
    private String sourceMoney;
    private String targetMoney;
    private Double change;
}
