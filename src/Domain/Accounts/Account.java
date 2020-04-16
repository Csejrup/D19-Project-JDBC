package Domain.Accounts;

public class Account {
    private String _USERNAME;
    private String _PASSWORD;
    private boolean _LOGINSTATUS;



    public boolean verifyLogin(){

        return _LOGINSTATUS;
    }

}
