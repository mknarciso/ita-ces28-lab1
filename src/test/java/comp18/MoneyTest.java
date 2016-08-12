package comp18;

import static org.junit.Assert.*;
import org.junit.*;

public class MoneyTest {
    Money myMoney = new Money();
    @Before
    public void initialize(){
        myMoney.setAmount(3);
        myMoney.setCurrency("BRL");
    }
    @Test
    public void checkInitialMoney(){
        assertEquals(3,myMoney.getAmount());
        assertEquals("BRL",myMoney.getCurrencyCode());
    }
    @Test
    public void addingAmountToMoney(){
        Money newAmount = new Money("BRL",5);
        //newAmount.setCurrency("BRL");
        //newAmount.setAmount(5);
        myMoney = myMoney.add(newAmount);
        assertEquals(8,myMoney.getAmount());
    }
    @Test
    public void hasCurrency(){
        boolean hasCurrency = false;
        if(myMoney.getCurrency() != null)
            hasCurrency = true;
        assertTrue(hasCurrency);
    }
    
}
