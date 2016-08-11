package comp18;

class Money {
    public Money() {
        //Default money
        //_amount=0;
        //_currency="BRL";
    }
    public Money add(Money m) {
        Money money = new Money();
        money.setAmount(this.getAmount() + m.getAmount());
        money.setCurrency(this.getCurrency());
        return money;
    }
    public int getAmount() {
        return _amount;
    }
    public void setAmount(int amount) {
        this._amount = amount;
    }
    public String getCurrency() {
        return _currency;
    }
    public void setCurrency(String currency) {
        this._currency = currency;
    }
    private int _amount;
    private String _currency;
}