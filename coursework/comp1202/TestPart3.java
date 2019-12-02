import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
public class TestPart3 {

	private Subject subject1;
	private Subject subject2;
	private Subject subject3;
	private Subject subject4;
	private Course course1;
	private Course course2;
	private Student student1;
	private Student student2;
	private Student student3;
	private Student student4;
	private Teacher teacher1;
	private Demonstrator demonstrator1;
	private OOTrainer ootrainer1;
	private GUITrainer guitrainer1;
	
	@BeforeEach
	public void setup() {
		subject1 = new Subject(1, 2, 3);
		subject2 = new Subject(2, 3, 4);
		subject3 = new Subject(3, 4, 5);
		subject4 = new Subject(4, 1, 6);
		course1 = new Course(subject1, 2);
		course2 = new Course(subject2, 3);
		student1 = new Student("Alice", 'F', 25);
		student2 = new Student("Bob", 'M', 30);
		student3 = new Student("Charlie", 'M', 35);
		student4 = new Student("Donna", 'F', 40);
		teacher1 = new Teacher("Teacher1", 'F', 25);
		demonstrator1 = new Demonstrator("Demonstrator1", 'F', 25);
		ootrainer1 = new OOTrainer("OOTrainer1", 'F', 25);
		guitrainer1 = new GUITrainer("GUITrainer1", 'F', 25);
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
	 * Test {@link Student} instance of {@link Person}.
	 */
	@Test
	@DisplayName("Test Student is instance of Person")
	public void testStudent_InstanceOf() {
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
	 * Tests for Teacher class.
	 */

	/**
	 * Test {@link Teacher} instance of {@link Instructor} and {@link Person}.
	 */
	@Test
	@DisplayName("Test Teacher is instance of Person and Instructor")
	public void testTeacher_InstanceOf() {
		assertTrue(teacher1 instanceof Person, "Teacher(\"Teacher1\", 'F', 25) should be an instance of Person");
		assertTrue(teacher1 instanceof Instructor, "Teacher(\"Teacher1\", 'F', 25) should be an instance of Instructor");
	}

	/**
	 * Test {@link Teacher#getName()}.
	 */
	@Test
	@DisplayName("Test Teacher's Get Name")
	public void testTeacher_GetName() {
		assertEquals("Teacher1", teacher1.getName(), "Incorrect name for Teacher(\"Teacher1\", 'F', 25)");
	}

	/**
	 * Test {@link Teacher#getGender()}.
	 */
	@Test
	@DisplayName("Test Teacher's Get Gender")
	public void testTeacher_GetGender() {
		assertEquals('F', teacher1.getGender(), "Incorrect gender for Teacher(\"Teacher1\", 'F', 25)");
	}

	/**
	 * Test {@link Teacher#getAge()}.
	 */
	@Test
	@DisplayName("Test Teacher's Get Age")
	public void testTeacher_GetAge() {
		assertEquals(25, teacher1.getAge(), "Incorrect age for Teacher(\"Teacher1\", 'F', 25)");
	}

	/**
	 * Test {@link Teacher#setAge(int)}.
	 */
	@Test
	@DisplayName("Test Teacher's Set Age")
	public void testTeacher_SetAge() {
		teacher1.setAge(26);
		assertEquals(26, teacher1.getAge(), "Incorrect age for Teacher(\"Teacher1\", 'F', 26)");
	}

	/**
	 * Test {@link Teacher#assignCourse(Course) and Teacher#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test Teacher's Assign Course")
	public void testTeacher_AssignCourse() {
		teacher1.assignCourse(course1);
		assertEquals(course1, teacher1.getAssignedCourse(),
				"Incorrect assigned course for Teacher(\"Teacher1\", 'F', 25)");
	}
	
	/**
	 * Test {@link Teacher#unassignCourse(Course) and Teacher#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test Teacher's Unassign Course")
	public void testTeacher_UnassignCourse() {
		teacher1.assignCourse(course1);
		teacher1.unassignCourse();
		assertNull(teacher1.getAssignedCourse(),
				"There should not be an assigned course for Teacher(\"Teacher1\", 'F', 25)");
	}

	/**
	 * Test {@link Teacher#canTeach(Subject)}.
	 */
	@Test
	@DisplayName("Test Teacher's Can Teach Subject")
	public void testTeacher_CanTeach() {
		assertTrue(teacher1.canTeach(subject1),
				"Teacher(\"Teacher1\", 'F', 25) can teach subject area 2");
		assertFalse(teacher1.canTeach(subject2),
				"Teacher(\"Teacher1\", 'F', 25) cannnot teach subject area 3");
		assertFalse(teacher1.canTeach(subject3),
				"Teacher(\"Teacher1\", 'F', 25) cannot teach subject area 4");
		assertTrue(teacher1.canTeach(subject4),
				"Teacher(\"Teacher1\", 'F', 25) can teach subject area 1");
	}

	/*
	 * Tests for Demonstrator class.
	 */

	/**
	 * Test {@link Demonstrator} instance of {@link Instructor} and {@link Person}.
	 */
	@Test
	@DisplayName("Test Demonstrator is instance of Person and Instructor")
	public void testDemonstrator_InstanceOf() {
		assertTrue(demonstrator1 instanceof Person, "Demonstrator(\"Demonstrator1\", 'F', 25) should be an instance of Person");
		assertTrue(demonstrator1 instanceof Instructor, "Demonstrator(\"Demonstrator1\", 'F', 25) should be an instance of Instructor");
	}

	/**
	 * Test {@link Demonstrator#getName()}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Get Name")
	public void testDemonstrator_GetName() {
		assertEquals("Demonstrator1", demonstrator1.getName(), "Incorrect name for Demonstrator(\"Demonstrator1\", 'F', 25)");
	}

	/**
	 * Test {@link Demonstrator#getGender()}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Get Gender")
	public void testDemonstrator_GetGender() {
		assertEquals('F', demonstrator1.getGender(), "Incorrect gender for Demonstrator(\"Demonstrator1\", 'F', 25)");
	}

	/**
	 * Test {@link Demonstrator#getAge()}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Get Age")
	public void testDemonstrator_GetAge() {
		assertEquals(25, demonstrator1.getAge(), "Incorrect age for Demonstrator(\"Demonstrator1\", 'F', 25)");
	}

	/**
	 * Test {@link Demonstrator#setAge(int)}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Set Age")
	public void testDemonstrator_SetAge() {
		demonstrator1.setAge(26);
		assertEquals(26, demonstrator1.getAge(), "Incorrect age for Demonstrator(\"Demonstrator1\", 'F', 26)");
	}

	/**
	 * Test {@link Demonstrator#assignCourse(Course) and Demonstrator#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Assign Course")
	public void testDemonstrator_AssignCourse() {
		demonstrator1.assignCourse(course1);
		assertEquals(course1, demonstrator1.getAssignedCourse(),
				"Incorrect assigned course for Demonstrator(\"Demonstrator1\", 'F', 25)");
	}

	/**
	 * Test {@link Demonstrator#unassignCourse(Course) and Demonstrator#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Unassign Course")
	public void testDemonstrator_UnassignCourse() {
		demonstrator1.assignCourse(course1);
		demonstrator1.unassignCourse();
		assertNull(demonstrator1.getAssignedCourse(),
				"There should not be an assigned course for Demonstrator(\"Demonstrator1\", 'F', 25)");
	}

	/**
	 * Test {@link Demonstrator#canTeach(Subject)}.
	 */
	@Test
	@DisplayName("Test Demonstrator's Can Teach Subject")
	public void testDemonstrator_CanTeach() {
		assertTrue(demonstrator1.canTeach(subject1),
				"Demonstrator(\"Demonstrator1\", 'F', 25) can teach subject area 2");
		assertFalse(demonstrator1.canTeach(subject2),
				"Demonstrator(\"Demonstrator1\", 'F', 25) cannnot teach subject area 3");
		assertFalse(demonstrator1.canTeach(subject3),
				"Demonstrator(\"Demonstrator1\", 'F', 25) cannot teach subject area 4");
		assertFalse(demonstrator1.canTeach(subject4),
				"Demonstrator(\"Demonstrator1\", 'F', 25) can teach subject area 1");
	}

	/*
	 * Tests for OOTrainer class.
	 */

	/**
	 * Test {@link OOTrainer} instance of {@link Instructor}, {@link Person}, and {@link Teacher}.
	 */
	@Test
	@DisplayName("Test OOTrainer is instance of Person, Instructor, and Teacher")
	public void testOOTrainer_InstanceOf() {
		assertTrue(ootrainer1 instanceof Person, "OOTrainer(\"OOTrainer1\", 'F', 25) should be an instance of Person");
		assertTrue(ootrainer1 instanceof Instructor, "OOTrainer(\"OOTrainer1\", 'F', 25) should be an instance of Instructor");
		assertTrue(ootrainer1 instanceof Teacher, "OOTrainer(\"OOTrainer1\", 'F', 25) should be an instance of Teacher");
	}

	/**
	 * Test {@link OOTrainer#getName()}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Get Name")
	public void testOOTrainer_GetName() {
		assertEquals("OOTrainer1", ootrainer1.getName(), "Incorrect name for OOTrainer(\"OOTrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link OOTrainer#getGender()}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Get Gender")
	public void testOOTrainer_GetGender() {
		assertEquals('F', ootrainer1.getGender(), "Incorrect gender for OOTrainer(\"OOTrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link OOTrainer#getAge()}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Get Age")
	public void testOOTrainer_GetAge() {
		assertEquals(25, ootrainer1.getAge(), "Incorrect age for OOTrainer(\"OOTrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link OOTrainer#setAge(int)}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Set Age")
	public void testOOTrainer_SetAge() {
		ootrainer1.setAge(26);
		assertEquals(26, ootrainer1.getAge(), "Incorrect age for OOTrainer(\"OOTrainer1\", 'F', 26)");
	}

	/**
	 * Test {@link OOTrainer#assignCourse(Course) and OOTrainer#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Assign Course")
	public void testOOTrainer_AssignCourse() {
		ootrainer1.assignCourse(course1);
		assertEquals(course1, ootrainer1.getAssignedCourse(),
				"Incorrect assigned course for OOTrainer(\"OOTrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link OOTrainer#unassignCourse(Course) and OOTrainer#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Unassign Course")
	public void testOOTrainer_UnassignCourse() {
		ootrainer1.assignCourse(course1);
		ootrainer1.unassignCourse();
		assertNull(ootrainer1.getAssignedCourse(),
				"There should not be an assigned course for OOTrainer(\"OOTrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link OOTrainer#canTeach(Subject)}.
	 */
	@Test
	@DisplayName("Test OOTrainer's Can Teach Subject")
	public void testOOTrainer_CanTeach() {
		assertTrue(ootrainer1.canTeach(subject1),
				"OOTrainer(\"OOTrainer1\", 'F', 25) can teach subject area 2");
		assertTrue(ootrainer1.canTeach(subject2),
				"OOTrainer(\"OOTrainer1\", 'F', 25) cannnot teach subject area 3");
		assertFalse(ootrainer1.canTeach(subject3),
				"OOTrainer(\"OOTrainer1\", 'F', 25) cannot teach subject area 4");
		assertTrue(ootrainer1.canTeach(subject4),
				"OOTrainer(\"OOTrainer1\", 'F', 25) can teach subject area 1");
	}

	/*
	 * Tests for GUITrainer class.
	 */

	/**
	 * Test {@link GUITrainer} instance of {@link Instructor}, {@link Person}, and {@link Teacher}.
	 */
	@Test
	@DisplayName("Test GUITrainer is instance of Person, Instructor, and Teacher")
	public void testGUITrainer_InstanceOf() {
		assertTrue(guitrainer1 instanceof Person, "GUITrainer(\"GUITrainer1\", 'F', 25) should be an instance of Person");
		assertTrue(guitrainer1 instanceof Instructor, "GUITrainer(\"GUITrainer1\", 'F', 25) should be an instance of Instructor");
		assertTrue(guitrainer1 instanceof Teacher, "GUITrainer(\"GUITrainer1\", 'F', 25) should be an instance of Teacher");
	}

	/**
	 * Test {@link GUITrainer#getName()}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Get Name")
	public void testGUITrainer_GetName() {
		assertEquals("GUITrainer1", guitrainer1.getName(), "Incorrect name for GUITrainer(\"GUITrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link GUITrainer#getGender()}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Get Gender")
	public void testGUITrainer_GetGender() {
		assertEquals('F', guitrainer1.getGender(), "Incorrect gender for GUITrainer(\"GUITrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link GUITrainer#getAge()}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Get Age")
	public void testGUITrainer_GetAge() {
		assertEquals(25, guitrainer1.getAge(), "Incorrect age for GUITrainer(\"GUITrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link GUITrainer#setAge(int)}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Set Age")
	public void testGUITrainer_SetAge() {
		guitrainer1.setAge(26);
		assertEquals(26, guitrainer1.getAge(), "Incorrect age for GUITrainer(\"GUITrainer1\", 'F', 26)");
	}

	/**
	 * Test {@link GUITrainer#assignCourse(Course) and GUITrainer#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Assign Course")
	public void testGUITrainer_AssignCourse() {
		guitrainer1.assignCourse(course1);
		assertEquals(course1, guitrainer1.getAssignedCourse(),
				"Incorrect assigned course for GUITrainer(\"GUITrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link GUITrainer#unassignCourse(Course) and GUITrainer#getAssignedCourse()}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Unassign Course")
	public void testGUITrainer_UnassignCourse() {
		guitrainer1.assignCourse(course1);
		guitrainer1.unassignCourse();
		assertNull(guitrainer1.getAssignedCourse(),
				"There should not be an assigned course for GUITrainer(\"GUITrainer1\", 'F', 25)");
	}

	/**
	 * Test {@link GUITrainer#canTeach(Subject)}.
	 */
	@Test
	@DisplayName("Test GUITrainer's Can Teach Subject")
	public void testGUITrainer_CanTeach() {
		assertTrue(guitrainer1.canTeach(subject1),
				"GUITrainer(\"GUITrainer1\", 'F', 25) can teach subject area 2");
		assertFalse(guitrainer1.canTeach(subject2),
				"GUITrainer(\"GUITrainer1\", 'F', 25) cannnot teach subject area 3");
		assertTrue(guitrainer1.canTeach(subject3),
				"GUITrainer(\"GUITrainer1\", 'F', 25) cannot teach subject area 4");
		assertTrue(guitrainer1.canTeach(subject4),
				"GUITrainer(\"GUITrainer1\", 'F', 25) can teach subject area 1");
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
		course1.enrolStudent(student1);
		course1.setInstructor(teacher1);
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
		course1.setInstructor(teacher1);

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
		course1.setInstructor(teacher1);
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
	
	
	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor Teacher Area 2")
	public void testCourse_setInstructorTeacherArea2() {
		boolean success = course1.setInstructor(teacher1);
		assertTrue(success, "Teacher(\"Teacher1\", 'F', 25) can teach Course1 (Subject area 2)");
	}

	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor Teacher Area 3")
	public void testCourse_setInstructorTeacherArea3() {
		boolean success = course2.setInstructor(teacher1);
		assertFalse(success, "Teacher(\"Teacher1\", 'F', 25) can teach Course2 (Subject area 3)");
	}


	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor Demonstrator Area 2")
	public void testCourse_setInstructorDemonstratorArea2() {
		boolean success = course1.setInstructor(demonstrator1);
		assertTrue(success, "Demonstrator(\"Demonstrator1\", 'F', 25) can teach Course1 (Subject area 2)");
	}

	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor Demonstrator Area 3")
	public void testCourse_setInstructorDemonstratorArea3() {
		boolean success = course2.setInstructor(demonstrator1);
		assertFalse(success, "Demonstrator(\"Demonstrator1\", 'F', 25) can teach Course2 (Subject area 3)");
	}

	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor OOTrainer Area 2")
	public void testCourse_setInstructorOOTrainerArea2() {
		boolean success = course1.setInstructor(ootrainer1);
		assertTrue(success, "OOTrainer(\"OOTrainer1\", 'F', 25) can teach Course1 (Subject area 2)");
	}

	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor OOTrainer Area 3")
	public void testCourse_setInstructorOOTrainerArea3() {
		boolean success = course2.setInstructor(ootrainer1);
		assertTrue(success, "OOTrainer(\"OOTrainer1\", 'F', 25) can teach Course2 (Subject area 3)");
	}

	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor GUITrainer Area 2")
	public void testCourse_setInstructorGUITrainerArea2() {
		boolean success = course1.setInstructor(guitrainer1);
		assertTrue(success, "GUITrainer(\"GUITrainer1\", 'F', 25) can teach Course1 (Subject area 2)");
	}

	/**
	 * Test {@link Course#setInstructor(Instructor)}.
	 */
	@Test
	@DisplayName("Test Course's Set Instructor GUITrainer Area 3")
	public void testCourse_setInstructorGUITrainerArea3() {
		boolean success = course2.setInstructor(guitrainer1);
		assertFalse(success, "GUITrainer(\"GUITrainer1\", 'F', 25) can teach Course2 (Subject area 3)");
	}

	/**
	 * Test {@link Course#hasInstructor()}.
	 */
	@Test
	@DisplayName("Test Course's Has Instructor")
	public void testCourse_hasInstructor() {
		assertFalse(course1.hasInstructor(), "Course1 should not have any instructor");
		course1.setInstructor(teacher1);
		assertTrue(course1.hasInstructor(), "Course1 should now have instructor");

		assertFalse(course2.hasInstructor(), "Course2 should not have any instructor");
		course2.setInstructor(demonstrator1);
		assertFalse(course2.hasInstructor(), "Course2 should still not have instructor");
	}

	/**
	 * Test {@link Course#isCancelled()}.
	 */
	@Test
	@DisplayName("Test Course's Cancel (no instructor)")
	public void testCourse_cancelNoInstructor() {
		course1.enrolStudent(student1);
		assertFalse(course1.isCancelled(), "Course1 should not have been cancelled (Day -2)");
		course1.aDayPasses();
		assertFalse(course1.isCancelled(), "Course1 should not have been cancelled (Day -1)");
		course1.aDayPasses();
		assertTrue(course1.isCancelled(), "Course1 should now have been cancelled");
		assertCollection("Course is cancelled should not have any students", course1.getStudents());
	}

	/**
	 * Test {@link Course#isCancelled()}.
	 */
	@Test
	@DisplayName("Test Course's Cancel (no students)")
	public void testCourse_cancelNoStudents() {
		course1.setInstructor(teacher1);
		assertFalse(course1.isCancelled(), "Course1 should not have been cancelled (Day -2)");
		course1.aDayPasses();
		assertFalse(course1.isCancelled(), "Course1 should not have been cancelled (Day -1)");
		course1.aDayPasses();
		assertTrue(course1.isCancelled(), "Course1 should now have been cancelled");
		assertNull(teacher1.getAssignedCourse(), "Teacher1 should now be unassigned");
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
