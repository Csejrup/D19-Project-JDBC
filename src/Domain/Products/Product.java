package Domain.Products;

import DataBase.DB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product
{
    private int _PRODUCTID;
    private int _QUANTITY;
    private int _MINQUANTITY;
    private float _PRICE;

    private String _PRODUCTNAME;
    private String _PRODUCTTYPE;
    private String _EXPIRATIONDATE;



    /////////////////////////////
    ////////////GETTERS/////////
    ////////////////////////////
    public int get_PRODUCTID(int productID) {
        DB.selectSQL("SELECT fldproductID FROM tblStorage WHERE fldProductID = '"+productID+"'");
        _PRODUCTID = Integer.parseInt(DB.getDisplayData());
        return _PRODUCTID;
    }

    public int get_QUANTITY(int productID) {
            DB.selectSQL("SELECT fldQuantity FROM tblStorage Where fldProductID = '"+productID+"'");
        return _QUANTITY;
    }

    public int get_MINQUANTITY(int productID) {
            DB.selectSQL("SELECT fldMinQuantity FROM tblStorage WHERE fldProductID = '"+productID+"'");
            _MINQUANTITY = Integer.parseInt(DB.getDisplayData());
        return _MINQUANTITY;
    }

    public float get_PRICE(int productID) {
        DB.selectSQL("SELECT fldPrice FROM tblStorage WHERE fldProductID = '"+productID+"'");
        _PRICE = Integer.parseInt(DB.getDisplayData());
        return _PRICE;
    }

    public String get_PRODUCTNAME(int productID) {
        DB.selectSQL("SELECT fldProductName FROM tblStorage WHERE fldProductID = '"+productID+"'");
        return _PRODUCTNAME;
    }

    public String get_PRODUCTTYPE(int productID) {
        DB.selectSQL("SELECT fldProductType FROM tblStorage WHERE fldProductID = '"+productID+"'");
        return _PRODUCTTYPE;
    }

    public String get_EXPIRATIONDATE(int productID) {
        DB.selectSQL("SELECT fldMinQuantity FROM tblStorage WHERE fldProductID = '"+productID+"'");
        return _EXPIRATIONDATE;
    }
    /////////////////////////////
    ////////////SETTERS/////////
    ////////////////////////////

    public void set_PRODUCTID(int _PRODUCTID) {
        DB.insertSQL("INSERT INTO tblStorage(fldProductID) VALUES('"+_PRODUCTID+"'");
        //IDK if we need this.
        this._PRODUCTID = _PRODUCTID;
    }

    public void set_QUANTITY(int _QUANTITY) {
        DB.insertSQL("INSERT INTO tblStorage(fldQuantity) VALUES('"+_QUANTITY+"'");
        //IDK if we need this.
        this._QUANTITY = _QUANTITY;
    }

    public void set_MINQUANTITY(int _MINQUANTITY) {
        DB.insertSQL("INSERT INTO tblStorage(fldMinQuantity) VALUES('"+_MINQUANTITY+"'");
        //IDK if we need this.
        this._MINQUANTITY = _MINQUANTITY;
    }

    public void set_PRICE(float _PRICE) {
        DB.insertSQL("INSERT INTO tblStorage(fldPrice) VALUES('"+_PRICE+"'");
        //IDK if we need this.
        this._PRICE = _PRICE;
    }

    public void set_PRODUCTNAME(String _PRODUCTNAME) {
        DB.insertSQL("INSERT INTO tblStorage(fldProductName) VALUES('"+_PRODUCTNAME+"'");
        //IDK if we need this.
        this._PRODUCTNAME = _PRODUCTNAME;
    }

    public void set_PRODUCTTYPE(String _PRODUCTTYPE) {
        DB.insertSQL("INSERT INTO tblStorage(fldProductType) VALUES('"+_PRODUCTTYPE+"'");
        //IDK if we need this.
        this._PRODUCTTYPE = _PRODUCTTYPE;
    }

    public void set_EXPIRATIONDATE(String _EXPIRATIONDATE) {
        DB.insertSQL("INSERT INTO tblStorage(fldExpirationDay) VALUES('"+_EXPIRATIONDATE+"'");
        //IDK if we need this.
        this._EXPIRATIONDATE = _EXPIRATIONDATE;
    }
}
