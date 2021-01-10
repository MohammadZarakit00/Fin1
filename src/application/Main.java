package application;

import controllers.*;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Course;
import model.CourseRegister;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

	private CourseRegister courseRegister = new CourseRegister();

	public HashMap<String, String> getPages() {
		return pages;
	}

	public void setPages(HashMap<String, String> pages) {
		this.pages = pages;
	}

	//Hashmap to simplify filepath specification.
	private HashMap<String, String> pages = new HashMap<>();
	
	private Pane view;
	private Stage primaryStage;

	public Main(){
		pages.put("Homepage", "/view/Homepage.fxml");
		pages.put("CourseManagement", "/view/CourseManagement.fxml");
		pages.put("ExamManagement", "/view/ExamManagement.fxml");
		pages.put("StudentManagement", "/view/StudentManagement.fxml");
		pages.put("ReturnHomePage", "/view/ReturnHomePage.fxml");


	}


	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(pages.get("Homepage")));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.show();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Contoso University");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* public void setPage(String path) throws IOException {
		try {
			URL url = this.getClass().getResource(pages.get(path));
			FXMLLoader loader = new FXMLLoader(url);
			Pane view = loader.load();

			//Parent root = loader.load();
			//Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);

			System.out.println("Kör primarystage");

			switch (path) {
				case "Homepage":
					System.out.println("Når homepage-case");
					HomePageController homePageController = loader.getController();
					homePageController.setCourseRegister(courseRegister);
					homePageController.setMain(this);
				case "CourseManagement":
					System.out.println("Når course-case");
					CourseManagementController courseManagementController = loader.getController();
					courseManagementController.setCourseRegister(courseRegister);
					courseManagementController.setMain(this);
					break;
				case "ExamManagement":
					System.out.println("Når exam-case");
					ExamManagementController examManagementController = loader.getController();
					examManagementController.setCourseRegister(courseRegister);
					examManagementController.setMain(this);
					break;
				case "StudentManagement":
					System.out.println("Når student-case");
					StudentManagementController studentManagementController = loader.getController();
					studentManagementController.setMain(this);
					studentManagementController.setCourseRegister(courseRegister);
					break;
				case "ReturnHomePage":
					System.out.println("Når return-case");

					break;

			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
	*/


	public static void main(String[] args) {
		launch(args);
	}
}