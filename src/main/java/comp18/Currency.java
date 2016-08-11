package comp18;

public class Currency {
    private String _code;
    public String getCode(){
        return _code;
    }
    public void setCode(String code){
        // Truncate the string to 3 characters
        code = code.substring(0,3);
        // Capitalize them
        code = code.toUpperCase();
        // Save them
        this._code = code;
    }
    
}
