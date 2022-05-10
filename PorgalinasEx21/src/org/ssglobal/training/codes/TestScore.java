package org.ssglobal.training.codes;

import java.util.List;

public class TestScore {
	
	public static void main(String[] args) {
		
		Score scores = new Score();
	
		System.out.println(scores.getNumScores());
		System.out.println(scores.getAverage());
		System.out.println(scores.getNumberAListers());
		System.out.println(scores.getFailingStudentList());
		scores.printPassingStudents();
		scores.displayAllSudents();
		System.out.println(scores.getStudentRecords());

	}

}
