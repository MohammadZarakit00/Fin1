package controllers;

import application.Loader;
import application.Main;
import javafx.scene.control.TextField;
import model.*;

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


	private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();
	private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();

	@FXML
	BorderPane bp = new BorderPane();
	@FXML
	Pane view;



	public BorderPane getBp(){
		return bp;
	}

	public void setBp(BorderPane borderPane){
		this.bp = borderPane;
	}

	public void initialize(URL url, ResourceBundle resourceBundle){
		
	}

	@FXML
	private void studentManagementButton(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/StudentManagement.fxml"));
		Pane view = loader.load();
		bp.setCenter(view);
	}

	@FXML
	private void courseManagementButton(ActionEvent event) throws IOException { //Course and exam management have for some reason disappeared in scenebuilder, but the code is still here in .fxml
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/CourseManagement.fxml"));
		Pane view = loader.load();
		bp.setCenter(view);
	}

	@FXML
	private void returnHomePageButton(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/ReturnHomePage.fxml"));
		Pane view = loader.load();
		bp.setCenter(view);
	}

	@FXML
	private void examManagementButton(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/ExamManagement.fxml"));
		Pane view = loader.load();
		bp.setCenter(view);
	}
}
		
		



