package comp18;

import static org.junit.Assert.*;
import org.junit.*;

public class MoneyBagTest {
    
    private MoneyBag myWallet = new MoneyBag();

    @Test
    public void addOneCurrenyMoney(){
        Money myBrlMoney1 = new Money("BRL",100);
        //Money myBrlMoney2 = new Money("BRL",50);
        myWallet.add(myBrlMoney1);
        assertEquals(myWallet.getAmount("BRL"),100);
    }
    
}
