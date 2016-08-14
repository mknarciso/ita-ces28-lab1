package comp18;
import java.util.*; 

public class MoneyBag {
    private List<Money> _wallet;
    
    public MoneyBag ()
    {
    	_wallet = new ArrayList<Money>();
    }
    
    public boolean hasCurrency(String currencyCode)
    {
    	boolean result = false;
    	int i;
        for(i=0; i < _wallet.size(); i++)
        { 
        	if(_wallet.get(i).getCurrencyCode().compareTo(currencyCode) == 0)
                result = true;
        }
        return result;
    }
    
    public int currencyPosition(String currencyCode){
        for(int i=0;i < _wallet.size();i++){
        	if(_wallet.get(i).getCurrencyCode().compareTo(currencyCode) == 0)
                return i;
        }
        return -1;
    }

    //Até funciona - um pouco bronco (melhor retornar o ponteiro para o Money com a Currency desejada).
    public void add(Money newMoney)
    {
        if( hasCurrency(newMoney.getCurrencyCode()) )
        {
        	int position = currencyPosition(newMoney.getCurrencyCode() );       	
            _wallet.set(position,(Money)_wallet.get(position).add(newMoney));
        }
        else
        {
            _wallet.add(newMoney);
        }
    }
    
    public int getAmount(String currencyCode){
        if(this.hasCurrency(currencyCode)){
            int total = 0;
            for(int i=0;i < _wallet.size();i++){
            	if(_wallet.get(i).getCurrencyCode().compareTo(currencyCode) == 0)
                    total = total + _wallet.get(i).getAmount();
            }
            return total;
        } else
            return 0;
    }
    
    public List<Currency> allCurrencies(){
        List<Currency> currencyList = new ArrayList<Currency>();
        System.out.println("The money in our bag:");
        for(int i=0; i<_wallet.size();i++){
            currencyList.add(_wallet.get(i).getCurrency());
            System.out.println("["+i+"] ["+_wallet.get(i).getCurrency().getCode()+"] => [$"+_wallet.get(i).getAmount()+"]");
        }
        System.out.println("-----------------------");
        return currencyList;
    }

}
