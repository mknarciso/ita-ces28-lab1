package comp18;

import static org.junit.Assert.*;
import org.junit.*;

//Esta é uma classe de testes para a classe MoneyBag.

public class MoneyBagTest {
    
    //Criamos uma MoneyBag para ser usada nos testes.
    private MoneyBag myWallet = new MoneyBag();
    
    //Neste teste colocamos várias moedas em uma MoneyBag, e calculamos o valor em BRL. Conferimos o valor total em BRL,
    //para verificar o funcionamento da função totalValueInBRL
    @Test
    public void convertCurrenciesToBRL(){
        Money myMoney1 = new Money("BRL",50); // = 50
        Money myMoney2 = new Money("USD",70); // 50 + 3x70 = 260
        Money myMoney3 = new Money("CHF",30); // 260 + 2x30 = 320
        myWallet = myMoney1.add(myMoney2);
        myWallet.add(myMoney3);
        assertEquals(320,myWallet.totalValueInBRL());
    }
    
    //Neste teste testamos a função add da classe Money, criando um Money com BRL e adicionando USD. Deve retornar um MoneyBag.
    @Test
    public void addDifferentCurrencyReturnsABag(){
        Money myMoney1 = new Money("BRL",50);
        Money myMoney2 = new Money("USD",70);
        //Return MoneyBag
        myWallet = myMoney1.add(myMoney2);
        assertEquals("BRL",myWallet.allCurrencies().get(0).getCode());
        assertEquals("USD",myWallet.allCurrencies().get(1).getCode());
        assertEquals(50,myWallet.getAmount("BRL"));
        assertEquals(70,myWallet.getAmount("USD"));
    }
    
    //Neste teste testamos a função add da classe Money, criando um Money com BRL e adicionando BRL. Deve retornar um Money.
    @Test
    public void addSameCurrencyReturnsAMoney(){
        Money myMoney1 = new Money("BRL",50);
        Money myMoney2 = new Money("BRL",70);
        //Return Money
        Money myMoneyOut = myMoney1.add(myMoney2);
        assertEquals("BRL",myMoneyOut.getCurrencyCode());
        assertEquals(120,myMoneyOut.getAmount());
    }
    
    //Neste teste adicionamos várias moedas a um MoneyBag, e verificamos quais as moedas resultantes dessa operação.
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

    //Neste teste adicionamos BRL a um MoneyBag.
    @Test
    public void addOneCurrenyMoney(){
        Money myBrlMoney1 = new Money("BRL",100);
        //Money myBrlMoney2 = new Money("BRL",50);
        myWallet.add(myBrlMoney1);
        assertEquals(100,myWallet.getAmount("BRL"));
    }
    
    //Neste teste adicionamos 3 vezes BRL a uma MoneyBag, e verificamos o resultado final.
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
    
    //Neste teste adicionamos 5 vezes diferentes moedas, e verificamos o resultado final.
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
    
    //Neste teste adicionamos várias moedas a uma MoneyBag, e testamos a função "currencyPosition"
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
    
    //Neste teste adicionamos USD a uma MoneyBag e testamos a função hasCurrency.
    @Test
    public void hasCurrency(){
        myWallet.add(new Money("USD",50));
        assertTrue(myWallet.hasCurrency("USD"));
    }
    
}
