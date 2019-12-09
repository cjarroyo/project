package pe.com.bcp.demo.project.typechange.service;

import pe.com.bcp.demo.project.typechange.entity.TypeChange;

import java.util.List;

public interface TypeChangeService {
    List<TypeChange> retrieveList();

    TypeChange findBySourceAndTarget(Integer id, Integer id1);

    void updateTypeChange(TypeChange typeChange);
}
