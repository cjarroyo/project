package pe.com.bcp.demo.project.typechange.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "type_changed")
@Getter
@Setter
public class TypeChange {
    @Id
    private Integer id;
    @Column(name = "source_money")
    private int sourceMoney;
    @Column(name = "target_money")
    private int targetMoney;
    private Double change;
}
