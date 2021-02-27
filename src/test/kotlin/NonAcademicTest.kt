import org.junit.Test

import org.junit.Assert.*

class NonAcademicTest {
    private val nonAcademic = NonAcademic(4555,"Yakub","Gowon",34,"male")
    @Test
    fun should_show_that_non_academic_doesnt_drive_a_car() {
        val toyota = Car("Toyota",2020)
        val expected =  "Yakub doesn't drive a car"
        assertEquals(expected,nonAcademic.drivesACar(toyota))
    }

    @Test
    fun test_to_show_that_a_nonacademic_cannot_discipline_students() {
        assertFalse(nonAcademic.disciplineStudent())
    }

    @Test
    fun should_return_details_of_the_non_academic_staff() {
        val expected = "\nNAME: Yakub Gowon\tAGE: 34\tSEX: male\tSALARY: #30000\tIDCARD COLOR: Brown\n"
        val actual = nonAcademic.getDetails()
        assertEquals(expected, actual)
    }


}