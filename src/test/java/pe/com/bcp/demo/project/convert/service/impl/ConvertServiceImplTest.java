package pe.com.bcp.demo.project.convert.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pe.com.bcp.demo.project.convert.dto.ConvertResponse;
import pe.com.bcp.demo.project.convert.dto.GetDataDto;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;

@RunWith(MockitoJUnitRunner.class)
public class ConvertServiceImplTest {

    private static final Double AMOUNT_EXPECTED = 167.5;
    private GetDataDto getDataDtoSuccess;
    private TypeChange typeChangeSuccess;
    private ConvertResponse convertResponse;
    private ConvertServiceImpl target;

    @Before
    public void setUp() {
        target = ConvertServiceImpl.builder().build();
    }

    @Test
    public void convertSuccessTest() {
        giveTypeChangeSuccess();
        givenDataDtoSuccess();
        whenConvertSuccess();
        thenConvertSuccess();
    }

    private void thenConvertSuccess() {
        Assert.assertEquals(convertResponse.getChangedAmount(), AMOUNT_EXPECTED);
    }

    private void whenConvertSuccess() {
        convertResponse = target.convert(getDataDtoSuccess);
    }

    private void giveTypeChangeSuccess() {
        typeChangeSuccess = new TypeChange();
        typeChangeSuccess.setChange(3.35);
        typeChangeSuccess.setSourceMoney(1);
        typeChangeSuccess.setTargetMoney(2);
    }

    private void givenDataDtoSuccess() {
        getDataDtoSuccess = GetDataDto.builder().
                amount(50.0).
                typeChange(typeChangeSuccess).
                build();
    }
}
