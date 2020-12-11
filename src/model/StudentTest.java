package model;

public class StudentTest {

        public static void main(String[] args){
            Student s1 = new Student("S12345","Filip");
            Student s2 = new Student("345667", "John");

            WrittenExam e1 = new WrittenExam("E12345");
            WrittenExam e2 = new WrittenExam("S123456");

            System.out.println("En student är snäll");
        }
}
