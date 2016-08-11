package comp18;
import java.util.*;

public class MoneyBag {
    private List<Money> _wallet = new ArrayList<Money>();
    
    public boolean hasCurrency(Currency currency){
        for(int i=0;i < _wallet.size();i++){
            if(_wallet.get(i).getCurrency()==currency)
                return true;
        }
        return false;
    }
    
    /*public int currencyPosition(Currency currency){
        for(int i=0;i < _types.size();i++){
            if(_types.get(i).getCurrency()==currency)
                return i;
        }
        return -1;
    }*/

    
    public void add(Money newMoney){
        this._wallet.add(newMoney);
    }
    
    public int getAmount(String currencyCode){
        _t
        return 0;
    }
}
