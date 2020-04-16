package Domain.Products;

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
    public int get_PRODUCTID() {
        return _PRODUCTID;
    }

    public int get_QUANTITY() {
        return _QUANTITY;
    }

    public int get_MINQUANTITY() {
        return _MINQUANTITY;
    }

    public float get_PRICE() {
        return _PRICE;
    }

    public String get_PRODUCTNAME() {
        return _PRODUCTNAME;
    }

    public String get_PRODUCTTYPE() {
        return _PRODUCTTYPE;
    }

    public String get_EXPIRATIONDATE() {
        return _EXPIRATIONDATE;
    }
    /////////////////////////////
    ////////////SETTERS/////////
    ////////////////////////////

    public void set_PRODUCTID(int _PRODUCTID) {
        this._PRODUCTID = _PRODUCTID;
    }

    public void set_QUANTITY(int _QUANTITY) {
        this._QUANTITY = _QUANTITY;
    }

    public void set_MINQUANTITY(int _MINQUANTITY) {
        this._MINQUANTITY = _MINQUANTITY;
    }

    public void set_PRICE(float _PRICE) {
        this._PRICE = _PRICE;
    }

    public void set_PRODUCTNAME(String _PRODUCTNAME) {
        this._PRODUCTNAME = _PRODUCTNAME;
    }

    public void set_PRODUCTTYPE(String _PRODUCTTYPE) {
        this._PRODUCTTYPE = _PRODUCTTYPE;
    }

    public void set_EXPIRATIONDATE(String _EXPIRATIONDATE) {
        this._EXPIRATIONDATE = _EXPIRATIONDATE;
    }
}
