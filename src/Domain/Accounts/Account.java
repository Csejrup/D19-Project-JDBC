package Domain.Accounts;

import DataBase.DB;

public class Account {
    private String _USERNAME;
    private String _PASSWORD;
    private boolean _LOGINSTATUS;

Manager manager = new Manager();
CanteenEmploy CE = new CanteenEmploy();
    public boolean verifyLogin(String employeeID, String password ){
        if(manager.login(employeeID,password)||CE.login(employeeID,password)){
            _LOGINSTATUS = true;
        }

        else{
            _LOGINSTATUS = false;
        }
        return _LOGINSTATUS;
    }

}
