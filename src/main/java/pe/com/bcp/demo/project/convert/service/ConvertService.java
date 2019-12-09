package pe.com.bcp.demo.project.convert.service;

import pe.com.bcp.demo.project.convert.dto.ConvertRequest;
import pe.com.bcp.demo.project.convert.dto.ConvertResponse;
import pe.com.bcp.demo.project.convert.dto.GetDataDto;

public interface ConvertService {

    ConvertResponse convert(GetDataDto getDataDto);

}
