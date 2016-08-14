package comp18;

class Money extends Container{
    public Money() {
        _currency = new Currency();
    }
    // Quick constructor
    public Money(String currencyCode, int amount) {
        _amount = amount;
        _currency = new Currency(currencyCode);
    }
    public <T> T add(Money m) {
        if(m.getCurrencyCode()==this.getCurrencyCode()){
            Money money = new Money();
            money.setAmount(this.getAmount() + m.getAmount());
            money.setCurrency(this.getCurrencyCode());
            //T result = (T)money;
            return (T)money;
        } else{
            MoneyBag newBag = new MoneyBag();
            newBag.add(this);
            newBag.add(m);            
            return (T)newBag;
        }

    }
    public int getAmount() {
        return _amount;
    }
    public void setAmount(int amount) {
        this._amount = amount;
    }
    public Currency getCurrency() {
        return _currency;
    }
    public String getCurrencyCode() {
        return _currency.getCode();
    }
    public void setCurrency(String code) {
        Currency myCurrency = new Currency();
        myCurrency.setCode(code);
        this._currency = myCurrency;
    }
    private int _amount;
    private Currency _currency;
}