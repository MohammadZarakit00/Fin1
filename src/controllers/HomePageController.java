package controllers;

import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class HomePageController {


	private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();
	private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();

	@FXML
	BorderPane bp = new BorderPane();


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
		
		



