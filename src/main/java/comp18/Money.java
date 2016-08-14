package comp18;

class Money {
    public Money(){
        _currency = new Currency();
    }
    // Quick constructor
    public Money(String currencyCode, int amount) {
        _amount = amount;
        _currency = new Currency(currencyCode);
    }
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