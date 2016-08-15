package comp18;

public class Currency {
    
    private String _code;  //Classe currency é composta de uma string _code
    
    //Construtores de currency.
    public Currency(){}    
    public Currency(String code){
        _code = code;
    }
    
    //Esta função retorna o código da string de Currency.
    public String getCode(){
        return _code;
    }
    
    //Esta função é um "setter": seta "code" como a sigla de Currency.
    public void setCode(String code){
        //Truncar para 3 caracteres
        code = code.substring(0,3);
        //Colocar como letras maiúsculas (evitar erros devidos à diferenciação entre maiúsuclas e minúsculas)
        code = code.toUpperCase();
        //Salvar
        this._code = code;
    }
    
}
