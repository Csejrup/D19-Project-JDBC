package Domain.Accounts;

import DataBase.DB;

public class IDCard
{
    private int _IDCARD;
    private float _BALANCE;


    private float GetBalance(int CustomerID){
        CustomerID = _IDCARD;
        DB.selectSQL("SELECT fldBalance FROM tblCardID WHERE fldCustomerID = '"+CustomerID+"'");
        _BALANCE = Float.parseFloat(DB.getDisplayData());
        return _BALANCE;
    }
}
