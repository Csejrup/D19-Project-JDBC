package Domain.Accounts;

import DataBase.DB;

public class CanteenEmploy extends Account {
    private String _NAME;
    private String _Password;

    public boolean login(String username, String password){
        DB.selectSQL("SELECT fldEmployeeID from tblEmployee WHERE fldEmployeeID = '"+username+"'");
        String _Name = DB.getDisplayData();
        DB.selectSQL("SELECT fldPassword FROM tblEmployee WHERE fldEmployeeID = '"+username+"'");
        String _Password = DB.getDisplayData();
        if(username.equals(_Name)&&password.equals(_Password)){
            return true;
        }
        else{
            return false;
        }
    }
}
