package pe.com.bcp.demo.project.money.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import pe.com.bcp.demo.project.money.entity.Money;
import pe.com.bcp.demo.project.money.repository.MoneyRepository;

@RunWith(MockitoJUnitRunner.class)
public class MoneyServiceImplTest {
    private String shorDescriptionSuccess;
    private Money moneyResponse;
    @Mock
    private MoneyRepository moneyRepository;
    private MoneyServiceImpl target;


    @Before
    public void setUp() {
        target = MoneyServiceImpl.builder().
                moneyRepository(moneyRepository).
                build();
    }

    @Test
    public void findShortDecriptionSuccessTest() {
        givenShortDescription();
        givenShortDescriptionResponse();
        givenFindByShort();
        whenShortDescription();
        thenShortDEscription();
    }

    private void thenShortDEscription() {
        Assert.assertEquals(moneyResponse.getShortDescription(), shorDescriptionSuccess);
    }

    private void givenFindByShort() {
        Mockito.when(moneyRepository.findByShortDescription(shorDescriptionSuccess)).thenReturn(moneyResponse);
    }

    private void givenShortDescriptionResponse() {
        moneyResponse = new Money();
        moneyResponse.setId(1);
        moneyResponse.setShortDescription("SOL");
        moneyResponse.setLongDescription("SOLES");
    }

    private void givenShortDescription() {
        shorDescriptionSuccess = "SOL";
    }

    private void whenShortDescription() {
        target.findByShortDescription(shorDescriptionSuccess);
    }
}
