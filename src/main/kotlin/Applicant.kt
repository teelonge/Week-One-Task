/**
 * An applicant class that is used to generate a list of applicants waiting to be admitted into the school by the principal
 * It extends the student class
 */
class Applicant(firstName: String,
                lastName: String, age: Int, sex: String, idNo: Int = 0, idCardColor: String = "") : Student(idNo, firstName, lastName, age, sex, idCardColor) {

    /**
     * Applicant companion object used to create only one instance
     * of the applicant which upon creation is added into the applicants list
     * returns the applicant object
     */
    companion object {
        fun createAnApplicant(): Applicant {
            println("Enter the applicant's details")
            println("\tEnter the first name")
            val firstName = readLine().toString()
            println("\tEnter the last name")
            val lastName = readLine().toString()
            println("Enter the applicant's age")
            val age = readLine()?.toInt()
            println("Enter the applicant's sex")
            val sex = readLine().toString()

            return Applicant(firstName = firstName, lastName = lastName, age = age!!, sex = sex)
        }
    }

    // Returns the applicants details
    fun getApplicantDetails(): String {
        return "Applicant's Name: ${getFullName()} \nAge: ${getAge()}\nSex: ${getSex()}\n"
    }


}