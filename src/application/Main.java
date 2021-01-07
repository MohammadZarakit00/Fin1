package application;

import javafx.application.Application;
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
import model.Student;

import java.util.ArrayList;

public class Main extends Application {

	private ArrayList<Course> courseRegister = new ArrayList<>();
	private ArrayList<Student> studentRegister = new ArrayList<>();

	public ArrayList<Course> getCourseRegister() {
		return courseRegister;
	}

	public void setCourseRegister(ArrayList<Course> courseRegister) {
		this.courseRegister = courseRegister;
	}

	public ArrayList<Student> getStudentRegister() {
		return studentRegister;
	}

	public void setStudentRegister(ArrayList<Student> studentRegister) {
		this.studentRegister = studentRegister;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Loader loader = new Loader();
			//Parent root = FXMLLoader.load(this.getClass().getResource("/view/Homepage.fxml"));
			Parent root = loader.setPage("/view/Homepage.fxml");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Contoso University");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}