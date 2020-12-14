package model;

public class Result {
	
	private int result;
	
	private String letterGrade;

	public Result(int result){
		if(result >= 0 && result <= 100){
			this.result = result;
			this.letterGrade = letterGradeFromResult(result);
		}
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}


	public String letterGradeFromResult(int result){
		if(result < 50){
			return "Fail";
		} else if(result < 55){
			return "E";
		} else if(result < 65){
			return "D";
		} else if(result < 75){
			return "C";
		} else if(result <85){
			return "B";
		} else {
			return "A"; //Behöver inte kollas då det görs i konstruktorn.
		}
	}
}
