package ua.nure.matyash.practice7.util;

import java.util.Collections;
import java.util.Comparator;


import ua.nure.matyash.practice7.controller.DOMController;
import ua.nure.matyash.practice7.entity.Plane;
import ua.nure.matyash.practice7.entity.Planes;


public class Sorter {

	// //////////////////////////////////////////////////////////
	// these are comparators
	// //////////////////////////////////////////////////////////

	/**
	 * Sorts questions by question text
	 */
	public static final Comparator<Plane> SORT_QUESTIONS_BY_QUESTION_TEXT =
			(o1, o2) -> o1.getModel().compareTo(o2.getModel());

	/**
	 * Sorts questions by answers number.
	 */
	public static final Comparator<Plane> SORT_QUESTIONS_BY_QUESTION =
			(o1, o2) -> o1.getPrise().getValue().compareTo(o2.getPrise().getValue());

	/**
	 * Sorts answers.
	 */
	public static final Comparator<Plane> SORT_QUESTIONS_BY = (o1, o2) -> o1.getModel().compareTo(o2.getModel());

	/**
	 * Sorts answers by correct.
	 */
	

	// //////////////////////////////////////////////////////////
	// these methods take Test object and sort it
	// with according comparator
	// //////////////////////////////////////////////////////////

	public static final void sortQuestionsByQuestionText(Planes test) {
		Collections.sort(test.getPlane(), SORT_QUESTIONS_BY_QUESTION_TEXT);
	}

	public static final void sortQuestionsByAnswersNumber(Planes test) {
		Collections.sort(test.getPlane(), SORT_QUESTIONS_BY_QUESTION);
	}

	private static void sortAnswersByContent(Planes test) {
		Collections.sort(test.getPlane(), SORT_QUESTIONS_BY);
		
	}
	



	public static void main(String[] args) throws Exception {
		final String local = "====================================";
		// Test.xml --> Test object
		DOMController domController = new DOMController(
			"input.xml"	);
		domController.parse(false);
		Planes test = domController.getPlanest();

		System.out.println(local);
		System.out.println(test);
		System.out.println(local);

		System.out.println(local);
		Sorter.sortQuestionsByQuestionText(test);
		System.out.println(test);
		System.out.println(local);

		System.out.println(local);
		Sorter.sortAnswersByContent(test);
		System.out.println(test);
	}


}