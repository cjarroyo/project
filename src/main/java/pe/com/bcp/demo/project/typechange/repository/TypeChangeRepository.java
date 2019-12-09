package pe.com.bcp.demo.project.typechange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;

public interface TypeChangeRepository extends JpaRepository<TypeChange, Integer> {
    TypeChange findBySourceMoneyAndTargetMoney(Integer sourceId, Integer targetId);
}
