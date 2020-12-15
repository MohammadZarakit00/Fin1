package application;

import javafx.scene.control.TextField;
import model.Course;
import model.Result;
import model.Student;
import model.WrittenExam;
import model.StudentTest;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Window;
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

public class HomePageController {

		@FXML
		Button btnScene1;
		
		public void handleBtn1() throws Exception {
			
		Parent root = FXMLLoader.load(this.getClass().getResource("/Sample.fxml"));
		
		Stage window = (Stage) btnScene1.getScene().getWindow();
		
		window.setScene(new Scene(root, 800, 600));
		}
		
		@FXML
		Button btnScene2;
		
		public void handleBtn2() throws Exception {
			
		Parent root = FXMLLoader.load(this.getClass().getResource("/CourseManagement.fxml"));
		
		Stage window = (Stage) btnScene1.getScene().getWindow();
		
		window.setScene(new Scene(root, 800, 600));
		}

	}


