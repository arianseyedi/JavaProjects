package courseRequisites;

/**
 *
 * @author jameselder
 */
public class InvalidCourseNumberException extends Exception {

	/**
	 * Creates a new instance of <code>InvalidCourseNumberException</code> without
	 * detail message.
	 */
	public InvalidCourseNumberException() {
	}

	/**
	 * Constructs an instance of <code>InvalidCourseNumberException</code> with the
	 * specified detail message.
	 * 
	 * @param msg
	 *            the detail message.
	 */
	public InvalidCourseNumberException(String msg) {
		super(msg);
	}
}
