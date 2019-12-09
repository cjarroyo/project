package pe.com.bcp.demo.project.typechange.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.demo.project.typechange.business.TypeChangeBusiness;
import pe.com.bcp.demo.project.typechange.dto.TypeChangeRequest;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;

import java.util.List;

@RestController
@RequestMapping("/typechange")
public class TypeChangeController {
    private TypeChangeBusiness typeChangeBusiness;

    public TypeChangeController(final TypeChangeBusiness typeChangeBusiness){
       this.typeChangeBusiness = typeChangeBusiness;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "list type change", notes = "type change")
    public List<TypeChange> retrieveList() {
        return typeChangeBusiness.retrieveList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "update type change", notes = "type change")
    public void updateTypeChange(@RequestBody TypeChangeRequest typeChangeRequest) {
        typeChangeBusiness.updateTypeChange(typeChangeRequest);
    }
}
