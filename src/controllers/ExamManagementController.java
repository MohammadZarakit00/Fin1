package controllers;

import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import model.Course;
import model.CourseRegister;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;
import model.WrittenExamRegister;


public class ExamManagementController implements Initializable {

    private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
    private WrittenExamRegister examRegister = WrittenExamRegister.getExamRegInstance();
    private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();
    private ArrayList<String> acceptedLocations = new ArrayList<>
            (Arrays.asList("Room A123", "Room A167", "Room B198", "Room B067"));


    @FXML
    ComboBox courseChoiceBox = new ComboBox();
    @FXML
    ComboBox studentChoiceBox = new ComboBox();
    @FXML
    Button btnGenerateExamId = new Button();


    @FXML
    Button btnAddExam = new Button();
    @FXML
    Button btnRemoveExam = new Button();
    @FXML
    Button btnMeanResult = new Button();
    @FXML
    Button btnMedianResult = new Button();
    @FXML
    Button btnNbrPassedExam = new Button();
    @FXML
    Button btnAddStudentToExam = new Button();


    @FXML
    TextField tfId = new TextField();
    @FXML
    TextField tfDate = new TextField();
    @FXML
    TextField tfLocation = new TextField();
    @FXML
    TextField tfTime = new TextField();
    @FXML
    TextField tfScore = new TextField();
    @FXML
    TextArea outPutArea = new TextArea();
    @FXML
    TextArea taErrorText = new TextArea();

    //Fills out drop down menus with courses and students respectively, to choose when adding exam to courses or registering results for students.
    public void initialize(URL location, ResourceBundle resources) {
        taErrorText.setText("");
        taErrorText.setStyle("-fx-text-fill: red ;");

        ArrayList<String> tmpCourseList = new ArrayList<>();
        for (Course c : courseRegister.getCourseRegister()) {
            tmpCourseList.add(c.getCourseCode() + ": " + c.getName());
        }
        courseChoiceBox.setItems(FXCollections.observableArrayList(tmpCourseList));

    }


    @FXML
    public void btnAddExam(ActionEvent event) {
        outPutArea.clear();
        String tmpIdExam = tfId.getText();
        String tmpIdDate = tfDate.getText();
        String tmpIdLocation = tfLocation.getText();
        String tmpIdTime = tfTime.getText();
        if (courseChoiceBox.getValue() == null) {
            taErrorText.setText("Please choose a course in the drop-down menu.");
        } else {
            if (tmpIdDate.isEmpty() || tmpIdLocation.isEmpty() || tmpIdDate.isEmpty()) {
                taErrorText.setText("Please fill in all of fields before adding an exam");
            } else {
                String tmpCourseId = courseChoiceBox.getValue().toString().substring(0, 6);
                Course currentCourse = courseRegister.findCourse(tmpCourseId);
                WrittenExam tmpExam = new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, currentCourse);

                if (!tmpExam.checkExamIdInput(tmpIdExam)) {
                    taErrorText.setText("Exam-ID is not valid, it should start with E and be followed by 5 numbers between 10000 and 99999," +
                            ", example E12345, E10009");
                } else if (currentCourse.containsExam(tmpIdExam)) {
                    taErrorText.setText("An Exam with that ID is already registered on course " + tmpCourseId);
                } else if (!(tmpIdTime.charAt(2) == ':')) {
                    taErrorText.setText("Time is not a valid time, examples on valid times are: 08:00, 14:00, 13:37 etc.");
                } else if (!acceptedLocations.contains(tmpIdLocation)) {
                    taErrorText.setText("Location is not valid, valid locations are Room A123, Room A167, Room B198, Room B067.");
                } else if (!courseRegister.checkExamUnique(tmpIdExam)) {
                    taErrorText.setText("An exam with the Exam-ID: " + tmpIdExam + " is already registered on a course.");
                } else {
                    currentCourse.addExam(tmpExam);
                    outPutArea.setText("Exam " + tmpIdExam + " was added to the course " + currentCourse.getName() + ". ");
                    taErrorText.clear();
                }
            }
        }
    }

    //Same as above. Remove FROM a course.
    @FXML
    public void btnRemoveExam(ActionEvent event) {
        String tmpId = tfId.getText();
        if (tmpId.isEmpty() || courseChoiceBox.getValue() == null) {
            taErrorText.setText("Please enter an Exam-ID and select a course");
        } else {
            Course currentCourse = courseRegister.findCourse(courseChoiceBox.getValue().toString().substring(0, 6));
            WrittenExam tmpExam = currentCourse.findExam(tmpId);
            if (tmpExam == null) {
                taErrorText.setText("Exam doesnt exist on course, please enter an existing exam");
            } else {
                taErrorText.clear();
                currentCourse.removeExam(tmpId);
                outPutArea.setText("Exam " + tmpId + " was removed from course: " + currentCourse.getName());
            }
        }
    }

    @FXML
    public void btnMeanResult(ActionEvent event) {
        String tmpExamId = tfId.getText();
        try {
            if (tmpExamId.isEmpty()) {
                taErrorText.setText("Please enter an Exam-ID");
            } else {
                Course currentCourse = courseRegister.findCourse(courseChoiceBox.getValue().toString().substring(0, 6));
                if (currentCourse.containsExam(tmpExamId)) {
                    WrittenExam exam = examRegister.findExam(tmpExamId);
                    if (exam != null) {
                        outPutArea.setText("Mean result for this exam is " + exam.getMeanResult());
                    } else {
                        taErrorText.setText("No exam exists with this ID. Please try another. ");
                    }
                } else {
                    taErrorText.setText("Exam doesnt exist on course, please enter an existing exam");
                }
            }
        } catch (NullPointerException e){
            taErrorText.setText("Please choose a course");
        }
    }


    @FXML
    public void btnMedianResult(ActionEvent event) {
        String tmpExamId = tfId.getText();
        try {
            if (tmpExamId.isEmpty()) {
                taErrorText.setText("Please enter an Exam-ID");
            } else {
                Course currentCourse = courseRegister.findCourse(courseChoiceBox.getValue().toString().substring(0, 6));
                if (currentCourse.containsExam(tmpExamId)) {
                    WrittenExam exam = examRegister.findExam(tmpExamId);
                    if (exam != null) {
                        outPutArea.setText("Median result for this exam is " + exam.getMedianResult());
                        taErrorText.setText("");
                    } else {
                        taErrorText.setText("No exam exists with this ID. Please try another. ");
                    }
                } else {
                    taErrorText.setText("Exam doesnt exist on course, please enter an existing exam");
                }
            }
        } catch(NullPointerException e ){
            taErrorText.setText("Please choose a course");
        }
    }

    //Null pointer if no exam is chosen.
    @FXML
    public void btnNbrPassedExam(ActionEvent event) {
        String tmpExamId = tfId.getText();
        try {
            if (tmpExamId.isEmpty()) {
                taErrorText.setText("Please enter an Exam-ID");
            } else {
                Course currentCourse = courseRegister.findCourse(courseChoiceBox.getValue().toString().substring(0, 6));
                if (currentCourse.containsExam(tmpExamId)) {
                    WrittenExam exam = examRegister.findExam(tmpExamId);
                    if (exam != null) {
                        outPutArea.setText(exam.nbrPassedExam() + " student(s) passed this course.");
                        taErrorText.setText("");
                    } else {
                        taErrorText.setText("No exam exists with this ID. Please try another. ");
                    }
                } else {
                    taErrorText.setText("Exam doesnt exist on course, please enter an existing exam");

                }
            }
        } catch (NullPointerException e){
            taErrorText.setText("Please choose a course");
        }
    }

    @FXML
    public void btnGenerateExamId(ActionEvent event) {
        Random examGen = new Random();
        int examId = examGen.nextInt(99999 + 1 - 10000) + 10000;
        tfId.setText("E" + examId);
    }


}
