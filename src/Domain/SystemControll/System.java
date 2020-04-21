package Domain.SystemControll;
import Domain.Products.*;
import javafx.scene.control.Alert;

public class System {
//Object of Product Class
    Product product = new Product();

    public void checkBorders(int ProductID){
      int minquantity = product.get_MINQUANTITY(ProductID);
      int quantity = product.get_QUANTITY(ProductID);

      if(quantity<=minquantity){
          sendEmail();
      }
      else{
          checkBorders(ProductID);
      }
    }

    public void sendEmail(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Email with order has been send!");
        alert.show();
    }

    public void checkAccount(){

    }

    public void checkProducts(){

    }


}
