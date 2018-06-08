package courseRequisites;

import java.util.*;

/**
 * Course number ranging from 1 to 9999
 *
 * @author James Elder
 */
public class CourseNumber implements Comparable<CourseNumber> {

	private int courseNumber;

	public CourseNumber(int courseNum) throws InvalidCourseNumberException {
		setCourseNumber(courseNum);
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	/**
	 * @param courseNum
	 * @throws InvalidCourseNumberException
	 *             if courseNum out of range
	 */
	public void setCourseNumber(int courseNum) throws InvalidCourseNumberException {
		if (courseNum < 1 || courseNum > 9999) {
			throw new InvalidCourseNumberException();
		}
		this.courseNumber = courseNum;
	}

	public int compareTo(CourseNumber courseNum) {
		int num1 = this.getCourseNumber(), num2 = courseNum.getCourseNumber();
		if (num1 < num2) {
			return -1;
		} else if (num1 > num2) {
			return +1;
		}
		return 0;
	}

	public String toString() {
		return "Course: " + getCourseNumber();
	}
}
