import org.junit.Test

import org.junit.Assert.*

class TeacherTest {
    private val teacher = Teacher(6789,"Ranson","Fela",34,"male")
    @Test
    fun should_return_teacher_details() {
        val expected = "\nIDNO: 6789\tNAME: Ranson Fela\tAGE: 34 years\tSEX: male" +
                "\tSALARY: #75000\tIDCARDCOLOR: Green\tON DUTY STATUS: false"
        val actual = teacher.teacherDetails()
        assertEquals(expected,actual)

    }

    @Test
    fun test_shows_that_teacher_drives_a_car() {
        val car = Car("Honda",2019)
        val expected = "Teacher Ranson Fela drives a Honda 2019 model"
        val actual = teacher.drivesACar(car)
        assertEquals(expected,actual)

    }

    @Test
    fun should_tell_that_a_teacher_can_discipline_a_student() {
        assertTrue(teacher.disciplineStudent())
    }

    @Test
    fun should_retun_salary_of_teacher() {
        val actual = teacher.getSalary()
        assertEquals(75000,actual)
    }

    @Test
    fun should_return_dutyStaus_of_the_teacher() {
        assertFalse(teacher.getDuty())
    }

    @Test
    fun should_return_the_full_name_of_the_teacher() {
        assertEquals("Ranson Fela",teacher.getFullName())
    }

    @Test
    fun should_return_the_idNo_of_the_teacher() {
        assertEquals(6789,teacher.getIdNo())
    }

    @Test
    fun should_return_the_id_Card_Color_of_the_teacher() {
        assertEquals("Green",teacher.getIdCardColor())
    }

    @Test
    fun should_return_the_first_name_of_the_teacher() {
        assertEquals("Ranson",teacher.getFirstName())
    }

    @Test
    fun should_return_the_last_name_of_the_teacher() {
        assertEquals("Fela",teacher.getLastName())
    }

    @Test
    fun should_return_the_age_of_the_teacher() {
        assertEquals(34,teacher.getAge())
    }

    @Test
    fun should_return_the_sex_of_the_teacher() {
        assertEquals("male",teacher.getSex())
    }
}