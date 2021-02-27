/**
 *  open student class which serves as a super class for the applicant class
 *  and also a sub-class for the person class
 */
open class Student(idNo: Int, firstName: String,
                   lastName: String, age: Int, sex: String, idCardColor: String = "Orange",
                   private var courses: MutableList<Course> = mutableListOf(),
                   private var noOfCourses: Int = 0, private var schoolFees: Int = 0
) : Person(idNo, firstName,
        lastName, age, sex, idCardColor) {


    fun getCourses() = courses

    fun setSchoolFees(schoolFees: Int) {
        this.schoolFees = schoolFees
    }
    fun getSchoolFees() = schoolFees

    fun getNoOfCourses() = noOfCourses

    /**
     * Student can add course to their parameter mutableList
     * of courses
     * @param course course to be added to the mutableList
     */
    fun addCourse(course: Course) {
        if (noOfCourses < 3) {
            courses.add(course)
            noOfCourses++
        } else {
            println("You cannot take more than $noOfCourses courses")
        }
    }

    // Returns the details of all courses in the student list of courses
    private fun getCourse(): String {
        var x = ""
        for (i in courses) {
            x += i.toString()
        }
        return x
    }
    //===================================================================

    // Returns a composition of student details
    fun studentsDetails(): String {
        return "\nIDNO: ${getIdNo()}\tNAME: ${getFullName()}\tAGE: ${getAge()} years\tSEX: ${getSex()}" +
                "\tSCHOOL FEES: #${getSchoolFees()}\tIDCARD COLOR: ${getIdCardColor()}\nCOURSES ENROLLED:\n${getCourse()}"
    }
}