package application;

import javafx.scene.control.TextField;
import model.Course;
import model.Result;
import model.Student;
import model.WrittenExam;
import model.StudentTest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HomePageController implements Initializable {
	

		@FXML
		Button btnScene1;
		@FXML
		BorderPane bp = new BorderPane();
		
		@FXML
		private void handleButton1Action(ActionEvent event) {
			System.out.println("click");
			Loader object = new Loader();
			Pane view = object.getPage("/Sample");
			bp.setCenter(view);
			
		}
		
		@FXML
		private void handleButton2Action(ActionEvent event) {
			System.out.println("click2");
			Loader object = new Loader();
			Pane view = object.getPage("/CourseManagement");
			bp.setCenter(view);
			
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	
			
		}
				
	}
		
		



