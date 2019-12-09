package pe.com.bcp.demo.project.typechange.service.impl;

import lombok.Builder;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;
import pe.com.bcp.demo.project.typechange.repository.TypeChangeRepository;
import pe.com.bcp.demo.project.typechange.service.TypeChangeService;

import java.util.List;

@Builder
public class TypeChangeServiceImpl implements TypeChangeService {
    private TypeChangeRepository typeChangeRepository;

    @Override
    public List<TypeChange> retrieveList() {
        return typeChangeRepository.findAll();
    }

    @Override
    public TypeChange findBySourceAndTarget(final Integer sourceId, final Integer targetId) {
        return typeChangeRepository.findBySourceMoneyAndTargetMoney(sourceId, targetId);
    }

    @Override
    public void updateTypeChange(final TypeChange typeChange) {
        typeChangeRepository.save(typeChange);
    }
}
