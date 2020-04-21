package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LogIn extends Main{

    Stage Window;
    @Override
    public void start(Stage stage) throws Exception {
    Window = stage;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label Username = new Label("Username");
        GridPane.setConstraints(Username,0,0);
        TextField NameInput = new TextField();
        NameInput.setPromptText("Username");
        GridPane.setConstraints(NameInput,1,0);
        Label PassLabel = new Label("Password");
        GridPane.setConstraints(PassLabel,0,1);
        TextField PassInput = new TextField();
        PassInput.setPromptText("*******");
        GridPane.setConstraints(PassInput,1,1);
        Button LoginButton = new Button("Log in");
        GridPane.setConstraints(LoginButton,1,2);
        Image Logojpg = new Image("Pictures/pasted image 0.png");
        ImageView LogoView = new ImageView(Logojpg);
        LogoView.setFitHeight(150);
        LogoView.setFitWidth(70);
        GridPane.setConstraints(LogoView,3,0);
        BorderPane MainView = new BorderPane();
        MainView.setLeft(grid);
        MainView.setRight(LogoView);
        grid.getChildren().addAll(Username,NameInput,PassInput,PassLabel,LoginButton);
        Scene scene = new Scene(MainView,350,300);
        Window.setScene(scene);
        Window.setTitle("Log in");
        Window.show();
    }

}
