package courseRequisites;

import java.util.*;

/**
 *
 * @author jameselder
 */
public class testCourses {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Courses EECSCourses = new Courses();
		Course course;

		// Test Case 1
		System.out.println("Test Case 1:");
		try {
			EECSCourses.putCourse(new CourseNumber(2011), "Fundamentals of Data Structures ");
		} catch (Exception x) {
			System.out.println("Failed");
		}
		System.out.println(EECSCourses.toString());

		// Test Case 2
		System.out.println("Test Case 2:");
		try {
			course = EECSCourses.getCourse(new CourseNumber(2011));
			System.out.println(course.toString() + "\n");
		} catch (Exception x) {
			System.out.println("Failed");
		}

		// Test Case 3
		System.out.println("Test Case 3:");
		try {
			course = EECSCourses.putCourse(new CourseNumber(3101), "Design and Analysis of Algorithms");
		} catch (Exception x) {
			System.out.println("Failed");
		}
		System.out.println(EECSCourses.toString());

		// Test Case 4
		System.out.println("Test Case 4:");
		Edge<CourseRequisite> edge;
		CourseRequisite courseRequisite = new CourseRequisite(CourseRequisiteType.PREREQUISITE);
		try {
			edge = EECSCourses.putRequisite(new CourseNumber(2011), new CourseNumber(3101),
					new CourseRequisite(CourseRequisiteType.PREREQUISITE));
		} catch (Exception x) {
			System.out.println("Failed");
		}
		System.out.println(EECSCourses.toString());

		// Test Case 5
		System.out.println("Test Case 5:");
		try {
			edge = EECSCourses.putRequisite(new CourseNumber(3101), new CourseNumber(2011),
					new CourseRequisite(CourseRequisiteType.PREREQUISITE));
		} catch (Exception x) {
			if (x instanceof CircularPreRequisiteException) {
				System.out.println("Passed - Circular Prerequisite");
			}
		}
		System.out.println(EECSCourses.toString());
	}
}
