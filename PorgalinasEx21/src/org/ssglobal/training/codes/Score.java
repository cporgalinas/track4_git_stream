package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Score {

//	private static Score score = new Score();

	ScoreInfo si;
	private List<ScoreInfo> scoresList = new ArrayList<>();
	private Stream<ScoreInfo> scoresStream;

	public Score() {
		scoresList.add(new ScoreInfo("Smith", "John", 70));
		scoresList.add(new ScoreInfo("Doe", "Mary", 85));
		scoresList.add(new ScoreInfo("Page", "Alice", 82));
		scoresList.add(new ScoreInfo("Cooper", "Jill", 97));
		scoresList.add(new ScoreInfo("Flintstone", "Fred", 66));
		scoresList.add(new ScoreInfo("Rubble", "Barney", 80));
		scoresList.add(new ScoreInfo("Smith", "Judy", 48));
		scoresList.add(new ScoreInfo("Dean", "James", 90));
		scoresList.add(new ScoreInfo("Russ", "Joe", 55));
		scoresList.add(new ScoreInfo("Wolfe", "Bill", 73));
		scoresList.add(new ScoreInfo("Dart", "Mary", 54));
		scoresList.add(new ScoreInfo("Rogers", "Chris", 78));
		scoresList.add(new ScoreInfo("Toole", "Pat", 51));
		scoresList.add(new ScoreInfo("Khan", "Omar", 93));
		scoresList.add(new ScoreInfo("Smith", "Ann", 95));
		scoresStream = scoresList.stream();
	}

	public int getNumScores() {
		scoresStream = scoresList.stream();
		Function<ScoreInfo, Integer> countNumScores = (p) -> {
			return 1;
		};

		int num = scoresStream.map(countNumScores).mapToInt(Integer::intValue).sum();

		return num;
	}

	public double getAverage() {
		scoresStream = scoresList.stream();
		Function<ScoreInfo, Integer> mapScore = (s) -> {
			return s.getScore();
		};
		double avgScore = scoresStream.map(mapScore).mapToInt(Integer::intValue).average().orElse(0);
		return avgScore;
	}

	public List<String> getNumberAListers() {
		scoresStream = scoresList.stream();
		Predicate<ScoreInfo> filterScoreGreater90 = (s) -> {

			if (s.getScore() >= 90) {
				return true;
			}
			return false;
		};

		Comparator<ScoreInfo> sortedAscFirstName = (o1, o2) -> {
			if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
				return 0;
			} else if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			} else {
				return -2;
			}
		};

		Function<ScoreInfo, String> mapStudentNames = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName());
		};

		List<String> aListers = scoresStream.filter(filterScoreGreater90).sorted(sortedAscFirstName)
				.map(mapStudentNames).collect(Collectors.toList());
		return aListers;

	}

	public List<String> getFailingStudentList() {
		scoresStream = scoresList.stream();
		Predicate<ScoreInfo> filterFailing = (s) -> {

			if (s.getScore() < 70) {
				return true;
			}
			return false;
		};

		Comparator<ScoreInfo> sortedAscFirstName = (o1, o2) -> {
			if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
				return 0;
			} else if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			} else {
				return -2;
			}
		};

		Function<ScoreInfo, String> mapStudentNames = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName());
		};

		List<String> failing = scoresStream.filter(filterFailing).sorted(sortedAscFirstName).map(mapStudentNames)
				.collect(Collectors.toList());
		return failing;
	}

	public void printPassingStudents() {
		scoresStream = scoresList.stream();

		Predicate<ScoreInfo> filterPassing = (s) -> {

			if (s.getScore() >= 70) {
				return true;
			}
			return false;
		};

		Comparator<ScoreInfo> sortedAscFirstName = (o1, o2) -> {
			if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
				return 0;
			} else if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			} else {
				return -2;
			}
		};

		Function<ScoreInfo, String> mapStudentNames = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName());
		};

		List<String> passing = scoresStream.filter(filterPassing).sorted(sortedAscFirstName).map(mapStudentNames)
				.collect(Collectors.toList());
		System.out.println(passing);

	}

	public void displayAllSudents() {
		scoresStream = scoresList.stream();
		Comparator<ScoreInfo> sortedAscFirstName = (o1, o2) -> {
			if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
				return 0;
			} else if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
				return 2;
			} else {
				return -2;
			}
		};

		Function<ScoreInfo, String> mapStudentNames = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName());
		};

		List<String> namesStr = scoresStream.sorted(sortedAscFirstName).map(mapStudentNames)
				.collect(Collectors.toList());
		System.out.println(namesStr);
	}

	public List<String> getStudentRecords() {
		scoresStream = scoresList.stream();
		Comparator<ScoreInfo> sortedDescScore = (o1, o2) -> {
			if (o1.getScore() == (o2.getScore())) {
				return 0;
			} else if (o1.getScore() > (o2.getScore())) {
				return -2;
			} else {
				return 2;
			}
		};

		Function<ScoreInfo, String> mapStudentNames = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore()));
		};

		List<String> namesStr = scoresStream.sorted(sortedDescScore).map(mapStudentNames).collect(Collectors.toList());
		return namesStr;
	}

}
