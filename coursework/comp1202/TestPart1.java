import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author htson
 *
 */
public class TestPart1 {

	private Subject subject;
	private Course course;
	
	@BeforeEach
	public void setup() {
		subject = new Subject(1, 2, 3);
		course = new Course(subject, 2);
	}

	/*
	 * Tests for Subject class.
	 */
	
	/**
	 * Test {@link Subject#getID()}.
	 */
	@Test
	@DisplayName("Test Subject's Get ID")
	public void testSubject_GetID() {
		assertEquals(1, subject.getID(), "Incorrect ID for Subject(1, 2, 3)");
	}

	/**
	 * Test {@link Subject#getSpecialism()}.
	 */
	@Test
	@DisplayName("Test Subject's Get Specialism")
	public void testSubject_GetSpecialism() {
		assertEquals(2, subject.getSpecialism(), "Incorrect specialism for Subject(1, 2, 3)");
	}

	/**
	 * Test {@link Subject#getDuration()}.
	 */
	@Test
	@DisplayName("Test Subject's Get Duration")
	public void testSubject_GetDuration() {
		assertEquals(3, subject.getDuration(), "Incorrect duration for Subject(1, 2, 3)");
	}

	/**
	 * Test {@link Subject#setDescription(String) and Subject#getDescription()}.
	 */
	@Test
	@DisplayName("Test Subject's Set/Get Desription")
	public void testSubject_SetGetDesription() {
		subject.setDescription("Course description");
		assertEquals("Course description", subject.getDescription(), "Incorrect course description");
		subject.setDescription("New description");
		assertEquals("New description", subject.getDescription(), "Incorrect course description");
	}

	/*
	 * Tests for Course class.
	 */

	/**
	 * Test {@link Course#getSubject()}.
	 */
	@Test
	@DisplayName("Test Course's Get Subject")
	public void testCourse_GetSubject() {
		assertEquals(subject, course.getSubject(), "Incorrect subject for Course(subject, 2)");
	}

	/**
	 * Test {@link Course#getStatus() and Course#aDayPasses()}.
	 */
	@Test
	@DisplayName("Test Course's Get Status")
	public void testCourse_GetStatus() {
		assertEquals(-2, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 0");
		course.aDayPasses();
		assertEquals(-1, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 1");
		course.aDayPasses();
		assertEquals(3, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 2");
		course.aDayPasses();
		assertEquals(2, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 3");
		course.aDayPasses();
		assertEquals(1, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 4");
		course.aDayPasses();
		assertEquals(0, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 5");
		course.aDayPasses();
		assertEquals(0, course.getStatus(), "Incorrect status for Course(subject, 2) @ Day 6");
	}
	
}
