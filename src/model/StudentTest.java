package model;

public class StudentTest {

        public static void main(String[] args){
            Student s1 = new Student("S12345","Filip");
            Student s2 = new Student("S45667", "John");
            Student s3 = new Student("S00001", "Anders");
            Student s4 = new Student("S00002", "Berra");
            Course c1 = new Course("SYSA21", "Informationssystem som ämne", 7.5);
            WrittenExam e1 = new WrittenExam("E12345", "010120", "Viktoriastadion", "8:00", c1);
            WrittenExam e2 = new WrittenExam("S123456", "010120", "Viktoriastadion", "8:00", c1);

            Result r1 = new Result(0);
            Result r2 = new Result(50);
            Result r3 = new Result(100);
            Result r4 = new Result(1337);
            Result r5 = new Result(-1);

            /*System.out.println("r1: " + r1.getLetterGrade());
            System.out.println("r2 " + r2.getLetterGrade());
            System.out.println("r3 " + r3.getLetterGrade());
            System.out.println("r4 " + r4.getLetterGrade());
            System.out.println("r5 " + r5.getLetterGrade());

             */

            e1.addStudent(s1);
            e1.addStudent(s2);
            e1.addStudent(s3);
            e1.addStudent(s4);

            e1.setStudentResult("S12345", 0);
            e1.setStudentResult("S45667", 50);
            e1.setStudentResult("S00001", 100);
            e1.setStudentResult("S00002", 75);

            System.out.println("Medianen är " + e1.getMedianResult());
            System.out.println("Medelvärdet är " + e1.getMeanResult());

        }
}
