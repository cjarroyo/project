package pe.com.bcp.demo.project.convert.service.impl;

import lombok.Builder;
import pe.com.bcp.demo.project.convert.dto.ConvertResponse;
import pe.com.bcp.demo.project.convert.dto.GetDataDto;
import pe.com.bcp.demo.project.convert.service.ConvertService;

@Builder
public class ConvertServiceImpl implements ConvertService {

    @Override
    public ConvertResponse convert(final GetDataDto getDataDto) {
        return ConvertResponse.builder().
                changedAmount(getDataDto.getAmount() * getDataDto.getTypeChange().getChange()).
                build();
    }
}
