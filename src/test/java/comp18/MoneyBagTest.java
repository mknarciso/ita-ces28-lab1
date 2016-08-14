package comp18;

import static org.junit.Assert.*;
import org.junit.*;

public class MoneyBagTest {
    
    private MoneyBag myWallet = new MoneyBag();
    
    @Test
    public void convertCurrenciesToBRL(){
        
        
    }
    
    @Test
    public void addDifferentCurrencyReturnsABag(){
        Money myMoney1 = new Money("BRL",50);
        Money myMoney2 = new Money("USD",70);
        Money myMoney3 = new Money("CHF",30);
        myWallet = myMoney1.add(myMoney2);
        myWallet.add(myMoney3);
        assertEquals(320,myWallet.totalValueInBRL());
    }
    
    @Test
    public void addSameCurrencyReturnsAMoney(){
        Money myMoney1 = new Money("BRL",50);
        Money myMoney2 = new Money("BRL",70);
        Money myMoneyOut = myMoney1.add(myMoney2);
        assertEquals("BRL",myMoneyOut.getCurrencyCode());
        assertEquals(120,myMoneyOut.getAmount());
    }
    
    @Test
    public void allCurrencies(){
        myWallet.add(new Money("USD",50));
        myWallet.add(new Money("BRL",70));
        myWallet.add(new Money("USD",30));
        myWallet.add(new Money("EUR",20));
        assertEquals("USD",myWallet.allCurrencies().get(0).getCode());
        assertEquals("BRL",myWallet.allCurrencies().get(1).getCode());
        assertEquals("EUR",myWallet.allCurrencies().get(2).getCode());
    }

    @Test
    public void addOneCurrenyMoney(){
        Money myBrlMoney1 = new Money("BRL",100);
        //Money myBrlMoney2 = new Money("BRL",50);
        myWallet.add(myBrlMoney1);
        assertEquals(100,myWallet.getAmount("BRL"));
    }
    
    @Test
    public void addThreeMoneyOfSameCurreny(){
        Money myBrlMoney1 = new Money("BRL",100);
        Money myBrlMoney2 = new Money("BRL",50);
        Money myBrlMoney3 = new Money("BRL",70);
        myWallet.add(myBrlMoney1);
        myWallet.add(myBrlMoney2);
        myWallet.add(myBrlMoney3);
        assertEquals(220,myWallet.getAmount("BRL"));
    }
    @Test
    public void addDifferentCurreny(){
        Money myBrlMoney1 = new Money("BRL",100);
        Money myBrlMoney2 = new Money("BRL",50);
        Money myBrlMoney3 = new Money("USD",70);
        Money myBrlMoney4 = new Money("USD",90);
        Money myBrlMoney5 = new Money("EUR",20);
        myWallet.add(myBrlMoney1);
        myWallet.add(myBrlMoney2);
        myWallet.add(myBrlMoney3);
        myWallet.add(myBrlMoney4);
        myWallet.add(myBrlMoney5);
        myWallet.add(myBrlMoney5); // Adding same amount again
        assertEquals(150,myWallet.getAmount("BRL"));
        assertEquals(160,myWallet.getAmount("USD"));
        assertEquals(40,myWallet.getAmount("EUR"));
    }
    
    @Test
    public void currencyPosition(){
        myWallet.add(new Money("USD",50));
        myWallet.add(new Money("BRL",70));
        myWallet.add(new Money("USD",30));
        myWallet.add(new Money("EUR",20));
        assertEquals(0,myWallet.currencyPosition("USD"));
        assertEquals(1,myWallet.currencyPosition("BRL"));
        assertEquals(2,myWallet.currencyPosition("EUR"));
    }
    
    @Test
    public void hasCurrency(){
        myWallet.add(new Money("USD",50));
        assertTrue(myWallet.hasCurrency("USD"));
    }
    
}
