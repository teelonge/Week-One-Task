import org.junit.Test

import org.junit.Assert.*

class PrincipalTest {

    private val principal = Principal(4, "James", "Adams", 34, "male")
    private val teacher = Teacher(345, "Bolanle", "Shade", 45, "female")
    private val course = Course("English", 5)
    private val student = Student(467, "Segun", "James", 34, "male")
    private val applicant = Applicant("Mamoud", "Ishaq", 34, "male")
    private val nonAcademic = NonAcademic(485, "Adanma", "Fathai", 34, "female")


    @Test
    fun should_return_a_string_with_the_principal_car_details() {
        val toyota = Car("Toyota", 2020)
        val actual = principal.drivesACar(toyota)
        val expected = "Principal James Adams drives a Toyota 2020 model"
        assertEquals(expected, actual)
    }

    @Test
    fun test_discipline_students_should_return_true() {
        assertTrue(principal.disciplineStudent())
    }

    @Test
    fun test_checks_if_applicant_is_successfully_in_applcants_list() {

        val applicant = Applicant("Tolu", "fade", 23, "male")
        principal.addAnApplicant(applicant)


        val fromApplicantList = principal.getApplicants()[0]
        assertEquals(applicant, fromApplicantList)

    }

    @Test
    fun checks_if_course_is_in_list_of_courses() {
        val course = Course("Mathematics", 5)
        val expected = "Mathematics"
        principal.addACourse(course)

        val actual = principal.getCourses()[0].name
        assertEquals(expected, actual)

    }

    @Test
    fun checks_if_teacher_is_in_list_of_teachers() {
        principal.addTeacher(teacher, course)

        val actual = principal.getTeachers()[teacher]
        assertEquals(course, actual)
    }

    @Test
    fun should_remove_teacher_from_teacher_list() {
        principal.addTeacher(teacher, course)

        principal.sackTeacher(345)
        assertFalse(principal.getTeachers().containsKey(teacher))
    }

    @Test
    fun should_set_teachers_duty_to_true() {
        principal.addTeacher(teacher, course)
        principal.setTeacherDuty(345)
        val actual: MutableSet<Teacher> = principal.getTeachers().keys
        var duty = false
        for (i in actual) {
            if (i.getIdNo() == 345) {
                duty = i.getDuty()
                break
            }
        }
        assertEquals(true, duty)

    }

    @Test
    fun should_return_a_list_of_all_teachers_details() {
        principal.addTeacher(teacher, course)
        val actual = principal.getAllTeachers()
        val expected = "\nIDNO: 345\tNAME: Bolanle Shade\tAGE: 45 years\tSEX: female" +
                "\tSALARY: #75000\tIDCARDCOLOR: Green\tON DUTY STATUS: false" + "\tCOURSE NAME: English" +
                "\tCOURSE UNITS: 5\n"
        assertEquals(expected, actual)
    }

    @Test
    fun should_add_student_to_a_specified_class() {
        principal.addStudentToClass(student, Classes.JSS3)
        val actual = principal.getStudents()[student]
        val expected = Classes.JSS3
        assertSame(expected, actual)
    }

    @Test
    fun should_set_students_fee_based_on_class_been_added_to() {
        principal.addStudentToClass(student, Classes.SS1)
        principal.setStudentsSchoolFee(student, Classes.SS1)
        val actual: MutableSet<Student> = principal.getStudents().keys
        var schFees = 0
        for (i in actual) {
            if (i.getIdNo() == 467) {
                schFees = i.getSchoolFees()
                break
            }
        }
        assertEquals(60000, schFees)
    }

    @Test
    fun test_to_check_the_class_student_is_in() {
        principal.addStudentToClass(student, Classes.JSS3)
        val actual = principal.getClass(student).toString()
        assertEquals("JSS3", actual)
    }

    @Test
    fun should_add_applicant_to_the_students_map() {
        principal.getStudents()[applicant] = Classes.JSS2
        val actual = principal.getStudents().getValue(applicant)
        assertEquals(Classes.JSS2, actual)
    }

    @Test
    fun should_return_a_list_of_all_students_detail() {
        principal.addStudentToClass(student, Classes.SS2)
        principal.setStudentsSchoolFee(student, Classes.SS2)
        student.addCourse(course)
        val expected = "\nIDNO: 467\tNAME: Segun James\tAGE: 34 years\tSEX: male" +
                "\tSCHOOL FEES: #60000\tIDCARD COLOR: Orange\nCOURSES ENROLLED:\n\tCOURSE NAME: English" +
                "\tCOURSE UNITS: 5\n\tCLASS: SS2\n"
        val actual = principal.getAllStudents()
        assertEquals(expected, actual)
    }

    @Test
    fun should_remove_student_from_the_students_database() {
        principal.addStudentToClass(student, Classes.SS1)
        principal.expelStudent(467)
        assertFalse(principal.getStudents().containsKey(student))
    }

    @Test
    fun should_add_newly_created_applicant_to_applicants_list() {
        principal.addAnApplicant(applicant)
        val actual = principal.getAllApplicants()
        val expected = "Applicant's Name: Mamoud Ishaq \nAge: 34\nSex: male\n"
        assertEquals(expected, actual)
    }


    @Test
    fun test_should_return_a_list_of_all_course() {
        principal.addACourse(course)
        val actual = principal.listAllCourses()
        val expected = "\tCOURSE NAME: English" +
                "\tCOURSE UNITS: 5\n"
        assertEquals(expected, actual)
    }


    @Test
    fun test_should_return_a_list_of_all_non_academic_staff() {
        principal.addNonAcademic(nonAcademic)
        val actual = principal.getNonAcademicDetails()
        val expected = "\nNAME: Adanma Fathai\tAGE: 34\tSEX: female\tSALARY: #30000\tIDCARD COLOR: Brown\n"
        assertEquals(expected, actual)
    }

}