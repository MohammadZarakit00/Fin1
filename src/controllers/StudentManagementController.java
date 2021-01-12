package controllers;

import application.Main;
import javafx.scene.control.TextField;
import model.Course;
import model.CourseRegister;
import model.Result;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;
import model.WrittenExamRegister;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;


public class StudentManagementController implements Initializable {

    private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
    private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();
    private WrittenExamRegister examRegister = WrittenExamRegister.getExamRegInstance();

    @FXML
    Button btnAddStudent = new Button();
    @FXML
    Button btnFindStudent = new Button();
    @FXML
    Button btnDeleteStudent = new Button();
    @FXML
    Button btnAddCourse = new Button();
    @FXML
    Button btnFindCourse = new Button();
    @FXML
    Button btnRemoveCourse = new Button();
    @FXML
    Button btnAddExam = new Button();
    @FXML
    TextArea ta = new TextArea();
    @FXML
    Button btnRegisterResult = new Button();
    @FXML
    Button btnGetLetterGrade = new Button();

    @FXML
    TextField tfId = new TextField();
    @FXML
    TextField tfIdExam = new TextField();
    @FXML
    TextField tfName = new TextField();
    @FXML
    TextField tfCredits = new TextField();
    @FXML
    TextField tfDate = new TextField();
    @FXML
    TextField tfLocation = new TextField();
    @FXML
    TextField tfTime = new TextField();
    @FXML
    TextField tfScore = new TextField();
    @FXML
    TextArea taErrorText = new TextArea();
    @FXML
    Button btnScene2;
    @FXML
    Button btnGenerateStudentId = new Button();
    @FXML
    ComboBox examBox = new ComboBox();

    //i have no idea what this does.
    public void handleBtn1() throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getResource("/Homepage.fxml"));

        Stage window = (Stage) btnScene2.getScene().getWindow();

        window.setScene(new Scene(root, 800, 600));
    }


    //Fills out the combobox with students on page load. Also makes the error box look nice.
    public void initialize(URL location, ResourceBundle resources) {
        taErrorText.setStyle("-fx-text-fill: red ;");

        ArrayList<String> tmpList = new ArrayList<>();
        tmpList.add("No exam");
        for (WrittenExam e : examRegister.getExamRegister()) {
            tmpList.add(e.getExamID() + " on the course " + e.getCurrentCourse().getName());
        }
        examBox.setItems(FXCollections.observableArrayList(tmpList));
    }


    @FXML
    public void btnUpdateStudent(ActionEvent event) {
        String tmpId = tfId.getText();
        String tmpName = tfName.getText();
        if (tmpId.isEmpty() || tmpName.isEmpty()) {
            taErrorText.setText("Please fill out both the Student-ID and the updated name");
        } else {
            studentRegister.findStudent(tmpId).setName(tmpName);
            ta.setText("Student with ID: " + tmpId + " has had their name updated and is now called " + tmpName + ".");
            taErrorText.setText("");
        }
    }

    //Checks validity of entered data, then adds a student to the register if it doesn't exist already.
    @FXML
    public void btnAddStudent(ActionEvent event) {
        ta.clear();
        if (examBox.getValue() == null) {
            taErrorText.setText("Please choose an exam.");
        } else {
            String tmpExamId = examBox.getValue().toString().substring(0, 6);
            String tmpId = tfId.getText();
            String tmpName = tfName.getText();
            String tmpResult = tfScore.getText();
            if (tmpId.isEmpty() || tmpName.isEmpty()) {
                taErrorText.setText("Please fill out both a name and a student ID. ");
            } else {
                Student student = new Student(tmpId, tmpName);
                WrittenExam tmpExam = examRegister.findExam(tmpExamId);
                if (!student.studentValidCheck(tmpId)) {
                    taErrorText.setText("You must enter a valid Student ID. A student ID starts with a capital 'S' and is followed by 5 letters. E.g: S41526, S19648, et cetera. ");
                } else if (tmpName.isEmpty()) {
                    taErrorText.setText("You must also enter the name of the student you would like to register. ");
                } else if(examBox.getValue().equals("No exam")){
                    ta.setText("Student " + tmpName + " with Student-ID: " + tmpId + " was added to to the register.");
                    taErrorText.setText("");
                } else if (tmpExam.containsStudent(tmpId)) {
                    taErrorText.setText("A student with the ID: " + tmpId + " already exists on the exam");
                } else if (tmpResult.isEmpty()) {
                    taErrorText.setText("Please enter a valid result");
                } else if (Integer.parseInt(tmpResult) < 0 || Integer.parseInt(tmpResult) > 100) {
                    taErrorText.setText("Please enter a result between 0 and 100.");
                } else {
                    student.addExam(tmpExam, new Result(Integer.parseInt(tmpResult)));
                    ta.setText("Student " + tmpName + " with Student-ID: " + tmpId + " was added to exam " + tmpExamId);
                    taErrorText.setText("");
                }
            }
        }
    }

    //Generates a student ID in accordance to the constructor rules, i.e. capital 's' and 5 numbers.
    @FXML
    public void btnGenerateStudentId(ActionEvent event) {
        Random studentGen = new Random();
        int studentId = studentGen.nextInt(99999 + 1 - 10000) + 10000;
        tfId.clear();
        tfId.setText("S" + studentId);

        String tmpId = tfId.getText();
        if (studentRegister.containsStudent(tmpId)) {
            tfId.clear();
            tfId.setText("S" + studentGen.nextInt(studentId));
        }
    }

    //Finds a student
    @FXML
    public void btnFindStudent(ActionEvent event) {
        String tmpId = tfId.getText();
        System.out.println("tmpid: " + tmpId);
        StringBuilder sb = new StringBuilder();
        Student tmpStudent = studentRegister.findStudent(tmpId);
        if (tmpId.isEmpty()) {
            taErrorText.setText("Please enter a student-ID");
        } else if (!studentRegister.containsStudent(tmpId)) {
            taErrorText.setText("A student with ID: " + tmpId + " is not registered in the system.");
        } else if (!tmpStudent.studentValidCheck(tmpId)) {
            taErrorText.setText("Student-ID is not valid, it should start with S and be followed by 5 numbers between 10000 and 99999, " +
                    "example S12345, S10009");
        } else if (tmpStudent.getExamResultMap().isEmpty()) {
            ta.setText("The student " + tmpStudent.getName() + " with the Student-ID:" + tmpId + " is not registered on any" +
                    " exams");
        } else {
            for (WrittenExam tmpExam : tmpStudent.getExamResultMap().keySet()) {
                sb.append(tmpExam.getExamID() + ", ");
            }
            ta.setText("The student " + tmpStudent.getName() + " with the Student-ID:" + tmpId + " is registered " +
                    "on the following exams: " + sb.substring(0, sb.length() - 2) + ".");
            taErrorText.setText("");
        }
    }

    //Deletes a student from the system
    @FXML
    public void btnDeleteStudent(ActionEvent event) {
        String tmpId = tfId.getText();
        if (examBox.getValue() == null) {
            taErrorText.setText("Please choose an exam.");
        } else {
            String examId = examBox.getValue().toString().substring(0, 6);
            Student tmpStudent = studentRegister.findStudent(tmpId);
            if (tmpId.isEmpty()) {
                taErrorText.setText("Please enter a student-ID");
            } else if (examBox.getValue() == null) {
                taErrorText.setText("Please choose an exam to remove the student from");
            } else if (!studentRegister.containsStudent(tmpId)) {
                taErrorText.setText("A student with ID: " + tmpId + " is not registered in the system.");
            } else if (!tmpStudent.studentValidCheck(tmpId)) {
                taErrorText.setText("Student-ID is not valid, it should start with S and be followed by 5 numbers between 10000 and 99999, " +
                        "example S12345, S10009");
            } else {
                examRegister.findExam(examId).deleteStudent(tmpId);
                ta.setText("The student " + tmpStudent.getName() + " with the Student-ID: " + tmpId + "" +
                        " was removed from " + examId + ".");
                taErrorText.setText("");
            }
        }
    }

    //Registers a result for a student on a given exam.
    @FXML
    public void btnRegisterResult(ActionEvent event) {
        String tmpStudentId = tfId.getText();
        String tmpScore = tfScore.getText();

        if (examBox.getValue() == null) {
            taErrorText.setText("Please choose an exam to register the result on.");
        } else if (tmpScore.isEmpty() || tmpStudentId.isEmpty()) {
            taErrorText.setText("Please fill out both the Result and Student-ID");
        } else {
            String tmpExamId = examBox.getValue().toString();
            String tmpOnlyId = tmpExamId.substring(0, 6);
            WrittenExam exam = examRegister.findExam(tmpOnlyId);
            int score = Integer.parseInt(tmpScore);
            if (exam == null) {
                taErrorText.setText("Exam doesnt exist in register, please try again.");
            } else if (!exam.containsStudent(tmpStudentId)) {
                taErrorText.setText("Student is not registered on this exam, please register the student and try again.");
            } else if (score < 0 || score > 100) {
                taErrorText.setText("Please enter a result between 0 and 100.");
            } else {
                studentRegister.findStudent(tmpStudentId).getExamResultMap().replace(exam, new Result(score));
                ta.setText("The result " + score + " was registered for student: " + tmpStudentId + " on exam " + exam.getExamID());
                taErrorText.setText("");
            }
        }
    }

    @FXML
    public void btnGetLetterGrade(ActionEvent event) {
        String tmpId = tfId.getText();
        if (examBox.getValue() == null) {
            taErrorText.setText("Please choose an exam to get the result from.");
        } else if (tmpId.isEmpty()) {
            taErrorText.setText("Please enter a student-ID");
        } else {
            String tmpExamId = examBox.getValue().toString();
            String tmpOnlyId = tmpExamId.substring(0, 6);
            WrittenExam exam = examRegister.findExam(tmpOnlyId);
            if (!studentRegister.containsStudent(tmpId) || !exam.containsStudent(tmpId)) {
                taErrorText.setText("Student is not registered on the exam, please register the student and try again.");
            } else {
                String tmpLetterGrade = exam.findStudent(tmpId).getExamResultMap().get(exam).getLetterGrade();
                ta.setText("Student " + tmpId + " received an " + "'" + tmpLetterGrade + "' on this exam. ");
                taErrorText.setText("");
            }
        }
    }
}



