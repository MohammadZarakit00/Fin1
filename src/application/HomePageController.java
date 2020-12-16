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
		BorderPane bp = new BorderPane();
		@FXML
		AnchorPane ap = new AnchorPane();
	
	
		
		private void loadPage(String page) {
			
		try {				
				FXMLLoader.load(getClass().getResource(page));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bp.setCenter(ap);
		}
	
		@FXML
		Button btnScene1;
		
		public void btnScene1(ActionEvent event) {
			
		String page = "/Sample.fxml";
			
		loadPage(page); //something be fucky, gotta declare page somehow
		
		System.out.println("something is working at least");
		
		bp.setCenter(ap);
		}
		
		@FXML
		Button btnScene2;
		
		public void btnScene2(ActionEvent event) {
			
		String page = "/CourseManagement.fxml";
			
		loadPage(page);		
		bp.setCenter(ap);
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		
	}
		



