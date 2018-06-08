package courseRequisites;

import java.security.InvalidKeyException;
import java.util.*;

import javax.annotation.Generated;

/**
 * Represents courses and prerequisites. A binary search tree sorted by course
 * number is used for fast access. This links out to a directed graph
 * representing course dependencies (prerequisites). The graph uses a hash table
 * to represent incoming and outgoing edges. Incoming edges represent courses
 * that are prerequisites for a course. Outgoing edges represent courses for
 * which the course is a prerequisite.
 * 
 * @author jameselder
 */
public class Courses {

	private TreeMap<CourseNumber, Course> courseMap; // for fast access
	private AdjacencyMapGraph<CourseNumber, CourseRequisite> courseGraph;// to represent dependencies

	public Courses() {
		courseMap = new TreeMap<>();
		courseGraph = new AdjacencyMapGraph<>(true); // Directed graph
	}

	// Returns course associated with course number
	public Course getCourse(CourseNumber courseNum) {
		return courseMap.get(courseNum);
	}

	/**
	 * Returns edge representing dependency of course2 on course 1, null if no
	 * dependency exists.
	 * @return Edge the edge representing dependency of course2 on course 1, null if no
	 * dependency exists.
	 */
	public Edge<CourseRequisite> getRequisite(CourseNumber course1, CourseNumber course2) {
		return courseGraph.getEdge(courseMap.get(course1).getCourseVertex(), courseMap.get(course2).getCourseVertex());
	}

	/**
	 * Adds course to database. If course number already exists, updates course
	 * name.
	 * 
	 */
	public Course putCourse(CourseNumber courseNum, String courseName) {
		Course course = courseMap.get(courseNum);
		if (course == null) { // add course
			Vertex<CourseNumber> vertex = courseGraph.insertVertex(courseNum); // add to graph
			course = new Course(courseNum, courseName, vertex);
			courseMap.put(courseNum, course); // add to map
		} else {
			course.setCourseName(courseName); // course exists - update name
		}
		return course;
	}

	/**
	 * Pint an existing requisite course to another existing course. For example, if
	 * both EECS2011 and EECS3311 courses exist in the map, one may try to set
	 * EECS2011 as the pre-requisite for EECS3311.
	 * 
	 * @author Arian Seyedi
	 * @param higherCourse
	 *            higher level course to have a new requisite course
	 * @param requisiteOf
	 *            the requisite of the higher level course (higherCourse)
	 * @param requisite
	 *            the type of requisite which requisiteOf is going to be of the
	 *            higherCourse.
	 * @return the edge where the requisiteOf course points to the higherCourse.
	 * @throws InvalidCourseNumberException
	 *             If course number is not valid
	 * @throws CircularPreRequisiteException
	 *             If higherCourse is to be set as the requisiteOf, thus introducing
	 *             a cycle.
	 */
	public Edge<CourseRequisite> putRequisite(CourseNumber higherCourse, CourseNumber requisiteOf,
			CourseRequisite requisite) throws InvalidCourseNumberException, CircularPreRequisiteException {

		Course course1 = courseMap.get(higherCourse);
		if (course1 == null) {
			throw new InvalidCourseNumberException("Argument CourseNum1: " + higherCourse + " does not exist!");
		}
		Course course2 = courseMap.get(requisiteOf);
		if (course2 == null) {
			throw new InvalidCourseNumberException("Argument CourseNum2: " + requisiteOf + " does not exist!");
		}
		// two known graph vertices will be put separately in following sets to be
		// searched independently
		Set<Vertex<CourseNumber>> known1 = new HashSet<Vertex<CourseNumber>>();
		Set<Vertex<CourseNumber>> known2 = new HashSet<Vertex<CourseNumber>>();
		// since the two vertices definitely exist at this point, get them
		Vertex<CourseNumber> vertex1 = getCourse(higherCourse).getCourseVertex();
		Vertex<CourseNumber> vertex2 = getCourse(requisiteOf).getCourseVertex();
		DFS(courseGraph, vertex1, known1); // to see if course 1 already requisite for course 2
		DFS(courseGraph, vertex2, known2); // to check for potential cyclic path (bad)
		if (searchCourse(requisiteOf, known1)) // if already exists
			return getRequisite(requisiteOf, higherCourse);
		if (searchCourse(higherCourse, known2)) // if loop
			throw new CircularPreRequisiteException(
					"course " + vertex2.getElement() + " is already requisite for course " + vertex1.getElement());
		return courseGraph.insertEdge(vertex1, vertex2, requisite); // exhusted all
	}

	/**
	 * Search for a course vertex in a known set of vertices.
	 * 
	 * @author Arian Seyedi
	 * @param courseNum
	 *            the course number to search.
	 * @param known
	 *            set of known vertices containing course numbers
	 * @return true if course vertext exists in the set of vertices containing
	 *         courses, false otherwise.
	 */
	private boolean searchCourse(CourseNumber courseNum, Set<Vertex<CourseNumber>> known) {
		Iterator<Vertex<CourseNumber>> knownIt = known.iterator();
		while (knownIt.hasNext()) {
			Vertex<CourseNumber> item = knownIt.next();
			if (item.getElement().compareTo(courseNum) == 0)
				return true;
		}
		return false;
	}

	/**
	 * Performs depth-first search of the unknown portion of Graph g starting at
	 * Vertex u.
	 *
	 * @param g
	 *            Graph instance
	 * @param u
	 *            Vertex of graph g that will be the source of the search
	 * @param known
	 *            is a set of previously discovered vertices
	 * @param forest
	 *            is a map from nonroot vertex to its discovery edge in DFS forest
	 *
	 *            As an outcome, this method adds newly discovered vertices
	 *            (including u) to the known set, and adds discovery graph edges to
	 *            the forest.
	 */
	private static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known) {
		known.add(u); // u has been discovered
		for (Edge<E> e : g.outgoingEdges(u)) { // for every outgoing edge from u
			Vertex<V> v = g.opposite(u, e);
			System.out.println("v is : " + v.getElement());
			if (!known.contains(v)) {
				DFS(g, v, known); // recursively explore from v
			}
		}
	}

	/**
	 * Returns a string representation of the courses.
	 */
	public String toString() {
		Iterable<Entry<CourseNumber, Course>> courses = courseMap.entrySet();
		String courseMapEntries = new String("Courses: \n");
		for (Entry<CourseNumber, Course> course : courses) {
			courseMapEntries = courseMapEntries + course.getValue().toString() + "\n";
		}
		return (courseMapEntries + courseGraph.toString() + "\n");
	}
}
