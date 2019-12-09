package pe.com.bcp.demo.project.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bcp.demo.project.money.entity.Money;

public interface MoneyRepository extends JpaRepository<Money, Integer> {
    Money findByShortDescription(String sourceMoney);
}
