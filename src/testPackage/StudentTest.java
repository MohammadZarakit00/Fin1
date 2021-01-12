package testPackage;

import model.Course;
import model.CourseRegister;
import model.Result;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;
import model.WrittenExamRegister;

public class StudentTest {

    public static void main(String[] args) {

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
        GITKunskap.addExam(LaTenta); //Duplicate check later

        //Skapar och lägger till studenter i register
        Student student1 = new Student("S10000", "Filip");
        Student student2 = new Student("S10001", "John");
        Student student3 = new Student("S10002", "Simon");
        Student student4 = new Student("S10003", "Mohammad");
        Student student5 = new Student("S10004", "Burt Reynolds");


        //Kopplar studenter till Exams samt ger dem ett result
        student1.addExam(JavaTenta, new Result(90));
        student2.addExam(JavaTenta, new Result(95));
        student3.addExam(JavaTenta, new Result(51));
        student4.addExam(JavaTenta, new Result(77));

        student1.addExam(AgilUtveckling, new Result(40));
        student1.addExam(LaTenta, new Result(75));
        student2.addExam(LaTenta, new Result(40));
        student3.addExam(GitForceGodkant, new Result(0));
        student4.addExam(AgilUtveckling, new Result(100));


        //Tests if students exist on said exam
        System.out.println("Student S10000 " + JavaTenta.containsStudent("S10000").toString() + " ------ should be == true" + "\n");
        System.out.println("Student S10000 " + GitForceGodkant.containsStudent("S10000").toString() + " ------ should be == false \n");
        System.out.println("Student S10001 " + JavaTenta.containsStudent("S10001").toString() + " ------ should be == true \n");

        //tests Letter-grade methods
        System.out.println("Grade: " + student1.getResult(JavaTenta).getLetterGrade() + " ------  should be " + "A \n");
        System.out.println("Grade: " + student1.getResult(AgilUtveckling).getLetterGrade() + " ------  should be " + "Fail \n");
        System.out.println("Grade: " + student3.getResult(JavaTenta).getLetterGrade() + " ------ should be " + "E \n");


        //Prints false if the course already exists in the system
        System.out.println("ExamID E10003 is not already registered to a Course: " + courseRegister.checkExamUnique( "E10003").toString() + " ---- should be false \n");
        System.out.println("ExamID E10007 is not already registered to a Course: " + courseRegister.checkExamUnique( "E10007").toString() + " ---- should be true \n");


        //Checks the findExam-method in course
        System.out.println("Course Programmering contains exam JavaTenta: " + Programmering.containsExam(JavaTenta.getExamID()) + " ---- should be true \n");
        System.out.println("Course Programmering contains exam LaTenta: " + Programmering.containsExam(LaTenta.getExamID()) + " ---- should be false \n");

        //Checks the deleteCourse
        //courseRegister.deleteCourse("C10000");
        System.out.println("C10000 exists in courseregister: " + courseRegister.containsCourse("C10000") + " ------ should be false \n");
        System.out.println("E10001 exists in examregister: " + writtenExamRegister.containsExam("E10001") + " ------ should be false \n");
        System.out.println("E10001 exists in student HashMap: " + student1.getExamResultMap().containsKey(JavaTenta) + " ------ should be true \n");
        System.out.println("S10001 exists on exam E10001: " + JavaTenta.containsStudent("S10001") + " ------ should be true \n");


















    }

}
