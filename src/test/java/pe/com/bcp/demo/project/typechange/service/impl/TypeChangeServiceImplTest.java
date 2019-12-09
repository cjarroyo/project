package pe.com.bcp.demo.project.typechange.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pe.com.bcp.demo.project.typechange.entity.TypeChange;
import pe.com.bcp.demo.project.typechange.repository.TypeChangeRepository;

@RunWith(MockitoJUnitRunner.class)
public class TypeChangeServiceImplTest {
    private Integer sourceMoney;
    private Integer targetMoney;
    private TypeChange typeChangeSuccess;
    private TypeChange typeChangeReturn;
    @Mock
    private TypeChangeRepository typeChangeRepository;

    public TypeChangeServiceImpl target;

    @Before
    public void setUp() {
        target = TypeChangeServiceImpl.builder().
                typeChangeRepository(typeChangeRepository).
                build();
    }

    @Test
    public void findSourceTargetSuccessTest(){
        givenSourceAndTarget();
        givenTypeChangeSuccess();
        givenSouceTargetRepository();
        whenSouceTarget();
        thenSourceTarget();
    }

    private void thenSourceTarget() {
        Assert.assertEquals(typeChangeReturn.getSourceMoney(), typeChangeSuccess.getSourceMoney());
    }

    private void whenSouceTarget() {
        typeChangeReturn = target.findBySourceAndTarget(sourceMoney, targetMoney);
    }

    private void givenTypeChangeSuccess() {
        typeChangeSuccess = new TypeChange();
        typeChangeSuccess.setSourceMoney(1);
        typeChangeSuccess.setTargetMoney(2);
        typeChangeSuccess.setChange(3.35);
    }

    private void givenSouceTargetRepository() {
        Mockito.when(typeChangeRepository.findBySourceMoneyAndTargetMoney(sourceMoney, targetMoney)).thenReturn(typeChangeSuccess);
    }

    private void givenSourceAndTarget() {
        sourceMoney = 1;
        targetMoney = 2;
    }
}
