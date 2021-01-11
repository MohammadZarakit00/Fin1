package testPackage;

import model.Course;
import model.CourseRegister;
import model.Result;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;
import model.WrittenExamRegister;

public class StudentTest {

        public static void main(String[] args){

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
    		Student student5 = new Student("S10004", "Burt Reynolds");

    		studentRegister.add(student1);
    		studentRegister.add(student2);
    		studentRegister.add(student3);
    		studentRegister.add(student4);
    		studentRegister.add(student5);

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


    	}
        
}
