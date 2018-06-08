package courseRequisites;

import java.util.*;

/**
 * Course Requisite. Designed to support multiple types of requisites. Currently
 * supports only prerequisites.
 *
 * @author James Elder
 */
public class CourseRequisite {

	private CourseRequisiteType courseRequisite;

	public CourseRequisite(CourseRequisiteType req) {
		courseRequisite = req;
	}

	/**
	 * Returns a string representation of a course.
	 */
	public String toString() {
		return "Prerequisite";
	}
}
