package courseRequisites;

import java.util.*;

/**
 * Course number ranging from 1 to 9999
 * 
 * @author James Elder
 */
public class Course {

	private CourseNumber courseNumber;
	private String courseName;
	private Vertex<CourseNumber> courseVertex;

	public Course(CourseNumber num, String name, Vertex<CourseNumber> vertex) {
		setCourseNumber(num);
		setCourseName(name);
		setCourseVertex(vertex);
	}

	public CourseNumber getCourseNumber() {
		return courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public Vertex<CourseNumber> getCourseVertex() {
		return courseVertex;
	}

	public void setCourseNumber(CourseNumber num) {
		courseNumber = num;
	}

	/**
	 * Returns a string representation of a course.
	 */
	public String toString() {
		return this.getCourseNumber().toString() + " " + this.getCourseName();
	}

	public void setCourseName(String name) {
		courseName = name;
	}

	public void setCourseVertex(Vertex<CourseNumber> vertex) {
		courseVertex = vertex;
	}
}
