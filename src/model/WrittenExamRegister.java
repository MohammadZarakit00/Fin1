package model;

import java.util.ArrayList;

public class WrittenExamRegister {
	
	private static WrittenExamRegister examRegInstance;
	private ArrayList<WrittenExam> examRegister = new ArrayList<>();
	
	public static WrittenExamRegister getExamRegInstance() {
		if(examRegInstance == null) {
			examRegInstance = new WrittenExamRegister();
		}
		return examRegInstance;
	}
	
	public ArrayList<WrittenExam> getExamRegister() {
		return examRegister;
	}
	
	public void setExamRegister(ArrayList<WrittenExam> examRegister) {
		this.examRegister = examRegister;
	}
	
	public void add(WrittenExam exam) {
		if (exam != null) {
			examRegister.add(exam);
		}
	}

	public void remove(String exam) {
		examRegister.remove(findExam(exam));
	}
	
	public WrittenExam findExam(String exam) {
		for(WrittenExam e : examRegister) {
			if(e.getExamID().equals(exam) ) {
				return e;
			}
		}
		return null;
	}
	
	public Boolean containsExam(String exam) {
		return findExam(exam) != null;
	}
}
