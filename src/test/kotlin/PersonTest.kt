import org.junit.Test

import org.junit.Assert.*

class PersonTest {
    private val person = Person(506,"Bello","Ahmed",45,"male","Purple")

    @Test
    fun should_return_the_fullname_of_a_person() {
        assertEquals("Bello Ahmed",person.getFullName())
    }

    @Test
    fun should_return_the_idNo_of_a_person() {
        assertEquals(506,person.getIdNo())
    }

    @Test
    fun should_return_the_idColor_of_a_person() {
        assertEquals("Purple",person.getIdCardColor())
    }

    @Test
    fun should_return_the_first_name_of_a_person() {
        assertEquals("Bello",person.getFirstName())
    }

    @Test
    fun should_return_the_last_name_of_a_person() {
        assertEquals("Ahmed",person.getLastName())
    }

    @Test
    fun should_return_the_age_of_a_person() {
        assertEquals(45,person.getAge())
    }

    @Test
    fun should_return_the_sex_of_a_person() {
        assertEquals("male",person.getSex())
    }

}