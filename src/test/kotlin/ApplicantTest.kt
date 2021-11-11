import org.junit.Test

import org.junit.Assert.*


class ApplicantTest {

    @Test
    fun should_return_applicant_details() {
        val applicant = Applicant("Kayode","Adeyemi",23,"male")
        val expected = "Applicant's Name: Kayode Adeyemi \nAge: 23\nSex: male\n"
        val actual = applicant.getApplicantDetails()
        assertEquals(expected, actual)
    }
}