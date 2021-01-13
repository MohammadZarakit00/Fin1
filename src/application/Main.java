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
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    private Pane view;
    private Stage primaryStage;


    //Hashmap to simplify filepath specification.

    private HashMap<String, String> pages = new HashMap<>();

    public Main() {
        //Kopplar en String till en FXML-filadress
        pages.put("Homepage", "/view/Homepage.fxml");
        pages.put("CourseManagement", "/view/CourseManagement.fxml");
        pages.put("ExamManagement", "/view/ExamManagement.fxml");
        pages.put("StudentManagement", "/view/StudentManagement.fxml");
        pages.put("ReturnHomePage", "/view/ReturnHomePage.fxml");

        //Skapar tomma register
        StudentRegister studentRegister = StudentRegister.getStudentRegInstance();
        CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
        WrittenExamRegister writtenExamRegister = WrittenExamRegister.getExamRegInstance();

        //Skapar och lägger till Kurser i kursregister
        Course Programmering = new Course("C10000", "Programmering", 7.5);
        Course Projektledning = new Course("C10001", "Projektledning", 5);
        Course Spanska = new Course("C10002", "Spanska", 3);
        Course GITKunskap = new Course("C10003", "GIT-knawledge", 15);

        courseRegister.add(Programmering);
        courseRegister.add(Projektledning);
        courseRegister.add(Spanska);
        courseRegister.add(GITKunskap);

        //Skapar och lägger till Exams
        WrittenExam JavaTenta = new WrittenExam("E10001", "010121", "Room A123", "08:00", Programmering);
        WrittenExam AgilUtveckling = new WrittenExam("E10002", "070721", "Room A167", "13:00", Projektledning);
        WrittenExam LaTenta = new WrittenExam("E10003", "040521", "Room B198", "08:00", Spanska);
        WrittenExam GitForceGodkant = new WrittenExam("E10004", "050830", "Room B067", "13:00", GITKunskap);

        Programmering.addExam(JavaTenta);
        Projektledning.addExam(AgilUtveckling);
        Spanska.addExam(LaTenta);
        GITKunskap.addExam(GitForceGodkant);

        //Skapar och lägger till studenter i register
        Student student1 = new Student("S10000", "Filip");
        Student student2 = new Student("S10001", "John");
        Student student3 = new Student("S10002", "Simon");
        Student student4 = new Student("S10003", "Mohammad");
        Student student5 = new Student("S10004", "Eva");


        //Kopplar studenter till Exams samt ger dem ett result
        student1.addExam(JavaTenta, new Result(90));
        student2.addExam(JavaTenta, new Result(95));
        student1.addExam(AgilUtveckling, new Result(40));
        student1.addExam(LaTenta, new Result(75));
        student2.addExam(LaTenta, new Result(40));
        student3.addExam(GitForceGodkant, new Result(0));
        student4.addExam(AgilUtveckling, new Result(100));

    }

    public HashMap<String, String> getPages() {
        return pages;
    }

    public void setPages(HashMap<String, String> pages) {
        this.pages = pages;
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(pages.get("Homepage")));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1100, 800);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.show();
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Contoso University");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}