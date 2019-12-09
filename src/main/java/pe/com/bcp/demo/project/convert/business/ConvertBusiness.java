package pe.com.bcp.demo.project.convert.business;

import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.com.bcp.demo.project.convert.dto.ConvertRequest;
import pe.com.bcp.demo.project.convert.dto.ConvertResponse;
import pe.com.bcp.demo.project.convert.dto.GetDataDto;
import pe.com.bcp.demo.project.convert.service.ConvertService;

@Builder
public class ConvertBusiness {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConvertBusiness.class);
    private ConvertGetData convertGetData;
    private ConvertService convertService;

    public ConvertResponse convertMoney(final ConvertRequest request) {
        GetDataDto getDataDto = convertGetData.preparedData(request);
        return convertService.convert(getDataDto);
    }

}
