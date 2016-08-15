package comp18;

class Money {
    private int _amount;
    private Currency _currency;
    
    public Money(){
        _currency = new Currency();
    }
    //Construtor de Money: constroi um objeto da classe Money, de moeda com sigla dada pela string "currencyCode" e quantidade Amount.
    public Money(String currencyCode, int amount) {
        _amount = amount;
        _currency = new Currency(currencyCode);
    }
    
    //Esta função implementa o item 10: adiciona um Money. Se for de moeda iguais, retorna um Money. Se forem moedas diferentes,
    //retorna uma MoneyBag.
    public <T> T add(Money m) {
        if(m.getCurrencyCode().compareTo(this.getCurrencyCode())==0){
            Money money = new Money();
            money.setAmount(this.getAmount() + m.getAmount());
            money.setCurrency(this.getCurrencyCode());
            return (T)money;
        } else {
            MoneyBag bag = new MoneyBag();
            bag.add(this);
            bag.add(m);
            return (T)bag;
        }

    }
    
    //Esta função retorna a quantidade em Money.
    public int getAmount() {
        return _amount;
    }
    
    //Esta função é um setter: "seta" a quantidade em Money
    public void setAmount(int amount) {
        this._amount = amount;
    }
    
    //Esta função retorna o objeto Currency em Money.
    public Currency getCurrency() {
        return _currency;
    }
    
    //Esta função retorna a sigla da moeda em Money.
    public String getCurrencyCode() {
        return _currency.getCode();
    }
    
    //Esta função é um setter: "seta" a sigla da moeda em Money.
    public void setCurrency(String code) {
        Currency myCurrency = new Currency();
        myCurrency.setCode(code);
        this._currency = myCurrency;
    }

    public static void main(String[] args){
        System.out.println("Hello user! Please check the tests to learn how to use our methods and classes!");
    }
}
