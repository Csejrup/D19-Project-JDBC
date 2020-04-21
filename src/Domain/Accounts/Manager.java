package Domain.Accounts;


import DataBase.DB;
import javafx.scene.control.Alert;

import java.sql.Statement;

public class Manager extends Account
{
    private String _NAME;
    private String _EMAIL;

    public void setBorder(int border, int productID){
        DB.insertSQL("INSERT INTO tblStorage(fldMinQuantity) WHERE fldProductID = '"+productID+"' VALUES('"+border+"')");
    }

    public boolean login(String WorkerID, String Password){
        DB.selectSQL("Select fldEmployeeID FROM tblEmployee WHERE fldEmployeeID = '"+WorkerID+"'");
        String LoginID = DB.getDisplayData();
        DB.selectSQL("Select fldPassword FROM tblEmployee WHERE fldEmployeeID = '"+WorkerID+"'");
        String password = DB.getDisplayData();

        if(LoginID.equals(WorkerID)&& password.equals(Password)){
            return true;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("WRONG USER NAME OR PASSWORD");
            alert.show();
            return false;
        }


    }
}
