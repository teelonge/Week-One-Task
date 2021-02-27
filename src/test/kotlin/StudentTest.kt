import org.junit.Test

import org.junit.Assert.*
import kotlin.test.asserter

class StudentTest {

    private val student = Student(5678,"Bello","Kreb",22,"male")
    private val course = Course("Geography",4)
    private val principal = Principal(4, "Bode", "Thomas", 34, "male")


    @Test
    fun should_set_the_student_school_fee_based_on_the_class() {
        principal.setStudentsSchoolFee(student,Classes.SS3)
        assertEquals(60000,student.getSchoolFees())
    }

    @Test
    fun test_returns_number_of_courses_in_the_student() {
        student.addCourse(course)
        assertEquals(1,student.getNoOfCourses())
    }

    @Test
    fun test_should_add_course_to_the_student_course() {
        student.addCourse(course)
        val actual = student.getCourses()[0].name
        assertEquals("Geography",actual)

    }

    @Test
    fun should_return_the_details_of_the_student() {
        student.addCourse(course)
        principal.setStudentsSchoolFee(student,Classes.SS3)
        val expected = "\nIDNO: 5678\tNAME: Bello Kreb\tAGE: 22 years\tSEX: male" +
                "\tSCHOOL FEES: #60000\tIDCARD COLOR: Orange\nCOURSES ENROLLED:\n\tCOURSE NAME: Geography\tCOURSE UNITS: 4\n"
        val actual = student.studentsDetails()
        assertEquals(expected,actual)
    }

    @Test
    fun test_should_return_the_mutable_list_of_courses() {
        student.addCourse(course)
        assertEquals(course,student.getCourses()[0])
    }


}