package courseRequisites;

import java.util.*;

/**
 * Grader
 * TODO Arian to transfer to JUnit
 * @author jameselder
 */
public class gradeCourses {

	public static void main(String[] args) throws InvalidCourseNumberException {
		Courses EECSCourses = new Courses();
		Course course;

		int[] marks = new int[13];
		int testNum = 0;
		int nCorrect = 0;

		EECSCourses.putCourse(new CourseNumber(4491), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(4481), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(2011), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(3431), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(3221), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(3214), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(2031), "Fundamentals of Data Structures ");
		EECSCourses.putCourse(new CourseNumber(2021), "Fundamentals of Data Structures ");
		System.out.println(EECSCourses.toString());

		CourseRequisite req = new CourseRequisite(CourseRequisiteType.PREREQUISITE);
		// Test Case 1
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2011), course2 = new CourseNumber(4491);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 2
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(3431), course2 = new CourseNumber(4491);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 3
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(3221), course2 = new CourseNumber(4481);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 4
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(3214), course2 = new CourseNumber(4481);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 5
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2011), course2 = new CourseNumber(4481);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 6
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2031), course2 = new CourseNumber(3431);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 7
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2011), course2 = new CourseNumber(3431);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 8
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2021), course2 = new CourseNumber(3221);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 9
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2031), course2 = new CourseNumber(3221);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 10
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2011), course2 = new CourseNumber(3221);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 11
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(2011), course2 = new CourseNumber(3214);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				marks[testNum] = 1;
				System.out.println("Test Case " + testNum + " passed");
			}
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		// Test Case 12
		testNum++;
		try {
			CourseNumber course1 = new CourseNumber(4491), course2 = new CourseNumber(2011);
			EECSCourses.putRequisite(course1, course2, req);
			if (EECSCourses.getRequisite(course1, course2).getElement().equals(req)) {
				System.out.println("Test Case " + testNum + " failed");
			}
		} catch (CircularPreRequisiteException x) {
			marks[testNum] = 1;
			System.out.println("Circular prerequisite successfully detected.");
			System.out.println("Test Case " + testNum + " passed");
		} catch (Exception x) {
			System.out.println("Test Case " + testNum + " failed");
		}

		System.out.println(EECSCourses.toString());

		System.out.print("Test Case Summary: ");
		for (int i = 1; i < marks.length; i++) {
			System.out.print(marks[i] + " ");
			nCorrect += marks[i];
		}
		System.out.println();
		System.out.println("Test Case Grade: " + (double) nCorrect / (marks.length - 1));
	}
}
