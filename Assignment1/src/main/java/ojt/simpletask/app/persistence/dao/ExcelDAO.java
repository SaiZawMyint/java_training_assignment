package ojt.simpletask.app.persistence.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import ojt.simpletask.app.persistence.entity.course.Course;

/**
 * <h2> ExcelDAO Class</h2>
 * <p>
 * Process for Displaying ExcelDAO
 * </p>
 * 
 * @author SaiZawMyint
 *
 */
public interface ExcelDAO {
	/**
	 * <h2> dbDownloadCourse</h2>
	 * <p>
	 * Download course.
	 * </p>
	 *
	 * @param courses List<Course>
	 * @return
	 * @throws IOException
	 * @return ByteArrayInputStream
	 */
	public ByteArrayInputStream dbDownloadCourse(List<Course> courses) throws IOException;
}
