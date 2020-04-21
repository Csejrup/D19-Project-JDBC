package Domain.Accounts;

import DataBase.DB;


public class EccoEmploy extends Account
{
    private int _EMPLOYEEID;
    private int _EMPLOYEENAME;
    private String _EMAIL;

    public void addBalance(float balance, int CustomerID){
        DB.insertSQL("INSERT INTO tblCard WHERE fldCustomerId = "+ CustomerID+" VALUES('"+balance+"')");

    }

    public void UpdateBalance(int balance){
        DB.insertSQL("INSERT INTO tblCardID(fldBalance) VALUES = '"+balance+"'");
    }




}
