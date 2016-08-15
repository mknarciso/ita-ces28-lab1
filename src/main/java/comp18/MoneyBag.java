package comp18;
import java.util.*; 

public class MoneyBag {
    private List<Money> _wallet;  //MoneyBag contém uma lista de "Money"s
    
    //Esta função é o construtor da classe MoneyBag, inicializando a lista
    public MoneyBag ()
    {
    	_wallet = new ArrayList<Money>();
    }
    
    //Esta função checa se a MoneyBag contém algum dinheiro da moeda cuja sigla é a string "currencyCode"
    //Retorna "true" em caso afirmativo, e "false", caso contrário. 
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
    
    
    //Esta função retorna a posição na lista em que se encontra a moeda cuja sigla é a string "currencyCode"
    //A primeira posição na lista é 0, e a última é (n-1), onde n é o tamanho da lista.
    //Retorna -1, caso não haja a moeda cuja sigla é a string "currencyCode".
    public int currencyPosition(String currencyCode){
        for(int i=0;i < _wallet.size();i++){
        	if(_wallet.get(i).getCurrencyCode().compareTo(currencyCode) == 0)
                return i;
        }
        return -1;
    }

    //Esta função adiciona um "Money" em MoneyBag. Ela verifica se já existe a moeda de "newMoney"
    //na MoneyBag. Em caso afirmativo, soma-se a quantidade de "newMoney" à já existente.
    //Caso contrário, adicionamos a nova moeda à MoneyBag.
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
    
 	//Esta função retorna o valor contido na MoneyBag da moeda cuja sigla é a string "currencyCode"
 	
    public int getAmount(String currencyCode){
        if(this.hasCurrency(currencyCode)){
            int total = 0;
            for(int i=0;i < _wallet.size();i++){
            	if(_wallet.get(i).getCurrencyCode().compareTo(currencyCode) == 0)
                    total = total + _wallet.get(i).getAmount();
            }
            return total;
        } else {
            return 0;
        }

    }

    //Esta função retorna o valor total, de todas as moedas, contido na MoneyBag.
    //A taxa de câmbio está predeterminada, inserida na implementação da função.
    
    public int totalValueInBRL ()
    {
    	int total = 0;
    	for(int i=0;i < _wallet.size();i++)
    	{
        	if(_wallet.get(i).getCurrencyCode().compareTo("BRL") == 0)
                total = total + _wallet.get(i).getAmount();
        	else if (_wallet.get(i).getCurrencyCode().compareTo("USD") == 0)
        		total = total + 3*_wallet.get(i).getAmount();
        	else if (_wallet.get(i).getCurrencyCode().compareTo("CHF") == 0)
        		total = total + 2*_wallet.get(i).getAmount();
        }
    	return total;
	}

    
    //Esta função escreve na tela o conteúdo de MoneyBag.
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

