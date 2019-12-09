package pe.com.bcp.demo.project.typechange.business;

import lombok.Builder;
import pe.com.bcp.demo.project.typechange.dto.TypeChangeRequest;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;
import pe.com.bcp.demo.project.typechange.service.TypeChangeService;

import java.util.List;

@Builder
public class TypeChangeBusiness {
    private TypeChangeGetData typeChangeGetData;
    private TypeChangeService typeChangeService;

    public List<TypeChange> retrieveList() {
        return typeChangeService.retrieveList();
    }


    public void updateTypeChange(final TypeChangeRequest typeChangeRequest) {
        TypeChange typeChange = typeChangeGetData.preparedUpdateTypeChange(typeChangeRequest);
        typeChangeService.updateTypeChange(typeChange);
    }
}
