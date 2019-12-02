import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author htson
 *
 */
public class TestPart2 {

	private Subject subject1;
	private Subject subject2;
	private Course course1;
	private Student student1;
	private Student student2;
	private Student student3;
	private Student student4;
	
	@BeforeEach
	public void setup() {
		subject1 = new Subject(1, 2, 3);
		subject2 = new Subject(2, 3, 4);
		course1 = new Course(subject1, 2);
		student1 = new Student("Alice", 'F', 25);
		student2 = new Student("Bob", 'M', 30);
		student3 = new Student("Charlie", 'M', 35);
		student4 = new Student("Donna", 'F', 40);
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
		assertEquals(1, subject1.getID(), "Incorrect ID for Subject(1, 2, 3)");
	}

	/**
	 * Test {@link Subject#getSpecialism()}.
	 */
	@Test
	@DisplayName("Test Subject's Get Specialism")
	public void testSubject_GetSpecialism() {
		assertEquals(2, subject1.getSpecialism(), "Incorrect specialism for Subject(1, 2, 3)");
	}

	/**
	 * Test {@link Subject#getDuration()}.
	 */
	@Test
	@DisplayName("Test Subject's Get Duration")
	public void testSubject_GetDuration() {
		assertEquals(3, subject1.getDuration(), "Incorrect duration for Subject(1, 2, 3)");
	}

	/**
	 * Test {@link Subject#setDescription(String) and Subject#getDescription()}.
	 */
	@Test
	@DisplayName("Test Subject's Set/Get Desription")
	public void testSubject_SetGetDesription() {
		subject1.setDescription("Course description");
		assertEquals("Course description", subject1.getDescription(), "Incorrect course description");
		subject1.setDescription("New description");
		assertEquals("New description", subject1.getDescription(), "Incorrect course description");
	}

	/*
	 * Tests for Student class.
	 */

	/**
	 * Test {@link Student()} is instance of {@link Person}.
	 */
	@Test
	@DisplayName("Test Student is instance of Person")
	public void testStudent_InstanceOfPerson() {
		assertTrue(student1 instanceof Person, "Student(\"Alice\", 'F', 25) should be an instance of Person");
	}

	/**
	 * Test {@link Student#getName()}.
	 */
	@Test
	@DisplayName("Test Student's Get Name")
	public void testStudent_GetName() {
		assertEquals("Alice", student1.getName(), "Incorrect name for Student(\"Alice\", 'F', 25)");
		assertEquals("Bob", student2.getName(), "Incorrect name for Student(\"Bob\", 'M', 30)");
	}

	/**
	 * Test {@link Student#getGender()}.
	 */
	@Test
	@DisplayName("Test Student's Get Gender")
	public void testStudent_GetGender() {
		assertEquals('F', student1.getGender(), "Incorrect gender for Student(\"Alice\", 'F', 25)");
		assertEquals('M', student2.getGender(), "Incorrect gender for Student(\"Bob\", 'M', 30)");
	}

	/**
	 * Test {@link Student#getAge()}.
	 */
	@Test
	@DisplayName("Test Student's Get Age")
	public void testStudent_GetAge() {
		assertEquals(25, student1.getAge(), "Incorrect age for Student(\"Alice\", 'F', 25)");
		assertEquals(30, student2.getAge(), "Incorrect age for Student(\"Bob\", 'M', 30)");
	}

	/**
	 * Test {@link Student#setAge(int)}.
	 */
	@Test
	@DisplayName("Test Student's Set Age")
	public void testStudent_SetAge() {
		student1.setAge(26);
		student2.setAge(31);
		assertEquals(26, student1.getAge(), "Incorrect age for Student(\"Alice\", 'F', 26)");
		assertEquals(31, student2.getAge(), "Incorrect age for Student(\"Bob\", 'M', 31)");
	}

	/**
	 * Test {@link Student#graduate(Subject)} and {@link Student#getCertificates()}.
	 */
	@Test
	@DisplayName("Test Student's Get Certificates")
	public void testStudent_GetCertificates() {
		student1.graduate(subject1);
		ArrayList<Integer> certificates = student1.getCertificates();
		assertCollection("Incorrect certificates for Student1", certificates, 1);
		student1.graduate(subject2);
		certificates = student1.getCertificates();
		assertCollection("Incorrect certificates for Student1", certificates, 1, 2);

		student2.graduate(subject2);
		certificates = student2.getCertificates();
		assertCollection("Incorrect certificates for Student2", certificates, 2);
		student2.graduate(subject1);
		certificates = student2.getCertificates();
		assertCollection("Incorrect certificates for Student2", certificates, 1, 2);
	}

	/**
	 * Test {@link Student#graduate(Subject)} and {@link Student#hasCertificate()}.
	 */
	@Test
	@DisplayName("Test Student's Has Certificate")
	public void testStudent_HasCertificate() {
		student1.graduate(subject1);
		assertTrue(student1.hasCertificate(subject1),
				"Student1 should have certificate for Subject1");
		student1.graduate(subject2);
		assertTrue(student1.hasCertificate(subject1),
				"Student1 should still have certificate for Subject1");
		assertTrue(student1.hasCertificate(subject2),
				"Student1 should have certificate for Subject2");

		student2.graduate(subject2);
		assertTrue(student2.hasCertificate(subject2),
				"Student2 should have certificate for Subject2");
		student2.graduate(subject1);
		assertTrue(student2.hasCertificate(subject2),
				"Student2 should still have certificate for Subject2");
		assertTrue(student2.hasCertificate(subject1),
				"Student2 should have certificate for Subject1");
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
		assertEquals(subject1, course1.getSubject(), "Incorrect subject for Course(subject, 2)");
	}

	/**
	 * Test {@link Course#getStatus() and Course#aDayPasses()}.
	 */
	@Test
	@DisplayName("Test Course's Get Status")
	public void testCourse_GetStatus() {
		assertEquals(-2, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 0");
		course1.aDayPasses();
		assertEquals(-1, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 1");
		course1.aDayPasses();
		assertEquals(3, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 2");
		course1.aDayPasses();
		assertEquals(2, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 3");
		course1.aDayPasses();
		assertEquals(1, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 4");
		course1.aDayPasses();
		assertEquals(0, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 5");
		course1.aDayPasses();
		assertEquals(0, course1.getStatus(), "Incorrect status for Course(subject, 2) @ Day 6");
	}


	/**
	 * Test {@link Course#enrolStudent(Student)}.
	 */
	@Test
	@DisplayName("Test Course's Enrol Student")
	public void testCourse_enrolStudent() {
		boolean enrolled;
		enrolled = course1.enrolStudent(student1);
		assertTrue(enrolled, "Must be able to enrol Student1");
		enrolled = course1.enrolStudent(student2);
		assertTrue(enrolled, "Must be able to enrol Student2");
		enrolled = course1.enrolStudent(student3);
		assertTrue(enrolled, "Must be able to enrol Student3");
	}

	/**
	 * Test {@link Course#getStudents()}.
	 */
	@Test
	@DisplayName("Test Course's Get Students")
	public void testCourse_getStudents() {
		Student[] students;
		students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students);
		course1.enrolStudent(student1);
		students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students, student1);
		course1.enrolStudent(student2);
		students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students, student1, student2);
		course1.enrolStudent(student3);
		students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students, student1, student2, student3);
	}
	
	/**
	 * Test {@link Course#getSize()}.
	 */
	@Test
	@DisplayName("Test Course's Get Size")
	public void testCourse_getSize() {
		assertEquals(0, course1.getSize(), "Incorrect size for Course1");
		course1.enrolStudent(student1);
		assertEquals(1, course1.getSize(), "Incorrect size for Course1");
		course1.enrolStudent(student2);
		assertEquals(2, course1.getSize(), "Incorrect size for Course1");
		course1.enrolStudent(student3);
		assertEquals(3, course1.getSize(), "Incorrect size for Course1");
	}

	/**
	 * Test {@link Course#enrolStudent(Student)}.
	 */
	@Test
	@DisplayName("Test Course's Enrol Student (Class oversize)")
	public void testCourse_enrolStudentOverSize() {
		course1.enrolStudent(student1);
		course1.enrolStudent(student2);
		course1.enrolStudent(student3);
		boolean enrolled = course1.enrolStudent(student4);
		assertFalse(enrolled, "Must not be able to enrol Student4");
		Student[] students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students, student1, student2, student3);
		assertEquals(3, course1.getSize(), "Incorrect size for Course1");
	}
	
	/**
	 * Test {@link Course#enrolStudent(Student)}.
	 */
	@Test
	@DisplayName("Test Course's Enrol Student (Course started)")
	public void testCourse_enrolStudentCourseStarted() {
		boolean enrolled;
		Student[] students;
		course1.enrolStudent(student1);

		course1.aDayPasses();
		enrolled = course1.enrolStudent(student2);
		assertTrue(enrolled, "Must be able to enrol Student2");
		students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students, student1, student2);
		assertEquals(2, course1.getSize(), "Incorrect size for Course1");
		
		course1.aDayPasses();
		enrolled = course1.enrolStudent(student3);
		assertFalse(enrolled, "Must not be able to enrol Student2");
		students = course1.getStudents();
		assertCollection("Incorrect students for Course1", students, student1, student2);
		assertEquals(2, course1.getSize(), "Incorrect size for Course1");
	}
	
	/**
	 * Test {@link Course#aDayPasses()}.
	 */
	@Test
	@DisplayName("Test Course's Graduate Students")
	public void testCourse_StudentGraduate() {
		course1.enrolStudent(student1);
		course1.enrolStudent(student2);
		// Day -2
		assertFalse(student1.hasCertificate(subject1),
				"Student1 should not have certificate for Subject1");
		assertFalse(student2.hasCertificate(subject1),
				"Student2 should not have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");
		course1.aDayPasses();

		// Day -1
		assertFalse(student1.hasCertificate(subject1),
				"Student1 should not have certificate for Subject1");
		assertFalse(student2.hasCertificate(subject1),
				"Student2 should not have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");
		course1.aDayPasses();

		// Day 1
		assertFalse(student1.hasCertificate(subject1),
				"Student1 should not have certificate for Subject1");
		assertFalse(student2.hasCertificate(subject1),
				"Student2 should not have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");
		course1.aDayPasses();

		// Day 2
		assertFalse(student1.hasCertificate(subject1),
				"Student1 should not have certificate for Subject1");
		assertFalse(student2.hasCertificate(subject1),
				"Student2 should not have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");
		course1.aDayPasses();

		// Day 3
		assertFalse(student1.hasCertificate(subject1),
				"Student1 should not have certificate for Subject1");
		assertFalse(student2.hasCertificate(subject1),
				"Student2 should not have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");
		course1.aDayPasses();

		// Day 4
		assertTrue(student1.hasCertificate(subject1),
				"Student1 should have certificate for Subject1");
		assertTrue(student2.hasCertificate(subject1),
				"Student2 should have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");
		course1.aDayPasses();

		// Day 5
		assertTrue(student1.hasCertificate(subject1),
				"Student1 should have certificate for Subject1");
		assertTrue(student2.hasCertificate(subject1),
				"Student2 should have certificate for Subject1");
		assertFalse(student3.hasCertificate(subject1),
				"Student3 should not have certificate for Subject1");
		assertFalse(student4.hasCertificate(subject1),
				"Student4 should not have certificate for Subject1");

	}
	
	
	/*
	 * Utility methods.
	 */
	
	private void assertCollection(String message, Collection<Integer> actual,
			Integer... expected) {
		assertEquals(expected.length, actual.size(),
				message + " (size incorrect)");
		for (int value : expected) {
			assertTrue(actual.contains(value),
					message + " (cannot find expected value) " + value);
		}
	}
	
	private void assertCollection(String message, Object[] actual,
			Object... expected) {
		assertEquals(expected.length, actual.length,
				message + " (size incorrect)");
		for (Object expectedValue : expected) {
			boolean found = false;
			for (Object actualValue : actual) {
				if (expectedValue.equals(actualValue)) {
					found = true;
					break;
				}
			}
			if (!found) {
				fail(message + " (cannot find expected value) " + expectedValue);
			}
		}
	}
}
