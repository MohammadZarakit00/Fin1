package application;

import java.awt.TextField;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SampleController {
	
	@FXML
	Button btn1 = new Button();
	@FXML
	TextArea ta = new TextArea();
	@FXML
	TextField tf1 = new TextField();
	
	@FXML
	public void btn1(ActionEvent event) {
		ta.appendText("Hej hopp" + "\n");
	}
	
}

