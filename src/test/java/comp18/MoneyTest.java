package comp18;

import static org.junit.Assert.*;
import org.junit.*;

//Esta é uma classe de testes da classe MoneyTest

public class MoneyTest {
    
    Money myMoney = new Money();   //Criamos um objeto da classe Money
    
    //Utilizamos um método @Before para "setar" a moeda para BRL e o valor para 3.
    @Before
    public void initialize(){
        myMoney.setAmount(3);
        myMoney.setCurrency("BRL");
    }
    
    //Este teste verifica as funções "setters"
    @Test
    public void checkInitialMoney(){
        assertEquals(3,myMoney.getAmount());
        assertEquals("BRL",myMoney.getCurrencyCode());
    }
    
    //Este teste verfica o método add de Money
    @Test
    public void addingAmountToMoney(){
        Money newAmount = new Money("BRL",5);
        //newAmount.setCurrency("BRL");
        //newAmount.setAmount(5);
        myMoney = myMoney.add(newAmount);
        assertEquals(8,myMoney.getAmount());
    }
    
    //Este teste verifica o "setter" do campo currency de Money.
    @Test
    public void hasCurrency(){
        boolean hasCurrency = false;
        if(myMoney.getCurrency() != null)
            hasCurrency = true;
        assertTrue(hasCurrency);
    }
    
}
