package comp18;
import java.util.*;

public class MoneyBag {
    private List<Money> _wallet = new ArrayList<Money>();
    
    public boolean hasCurrency(String currencyCode){
        for(int i=0;i < _wallet.size();i++){
            if(_wallet.get(i).getCurrency().getCode()==currencyCode)
                return true;
        }
        return false;
    }
    
    public int currencyPosition(String currencyCode){
        for(int i=0;i < _wallet.size();i++){
            if(_wallet.get(i).getCurrency().getCode()==currencyCode)
                return i;
        }
        return -1;
    }

    
    public void add(Money newMoney){
        String currencyCode = newMoney.getCurrency().getCode();
        if(this.hasCurrency(currencyCode)){
            int position = currencyPosition(currencyCode);
            _wallet.set(position,_wallet.get(position).add(newMoney));
        } else {
            _wallet.add(newMoney);
        }

    }
    
    public int getAmount(String currencyCode){
        if(this.hasCurrency(currencyCode)){
            int total = 0;
            for(int i=0;i < _wallet.size();i++){
                if(_wallet.get(i).getCurrency().getCode()==currencyCode)
                    total = total + _wallet.get(i).getAmount();
            }
            return total;
        } else{
            return 0;
        }
    }

}
