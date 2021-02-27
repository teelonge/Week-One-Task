/**
 * Principal class to create the principal instance for governing things in the school,
 * It is a subclass of the staff class and in turn a subclass of the person class
 */

class Principal(idNo: Int, firstName: String, lastName: String,
                age: Int, sex: String,
                salary: Int = 100000, onDuty: Boolean = true, idCardColor: String = "Yellow") : Staff(idNo, firstName, lastName,
        age, sex, idCardColor, salary, onDuty) {


    private val teachers: HashMap<Teacher, Course> = hashMapOf()
    private val students: HashMap<Student, Classes> = hashMapOf()
    private val nonAcademics: MutableList<NonAcademic> = mutableListOf()
    private val courses = mutableListOf<Course>()
    private val applicants: MutableList<Applicant> = mutableListOf()


    fun getTeachers() = teachers
    fun getCourses() = courses
    fun getApplicants() = applicants
    fun getStudents() = students

    /**
     * overrides the drivesAcar abstract method from the staff class to check if the principal drives a car and and the car model
     * @param car an association relationship between the car and principal class, that provides the car name and model from the car class
     */
    override fun drivesACar(car: Car): String {
        return "Principal ${getFullName()} drives a ${car.carName} ${car.carModel} model"
    }

    /**
     * overrides the disciplineStudent abstract method from the staff class and returns a boolean
     */
    override fun disciplineStudent(): Boolean {
        return true
    }

    /**
     * @param course gets added to the course list
     */
    fun addACourse(course: Course) {
        courses.add(course)
    }

    fun listAllCourses(): String {
        var allCourses = ""
        for (i in courses) {
            allCourses += i.toString()
        }
        return allCourses
    }

    /**
     * Maps a teacher to a course already in the course list and adds them to an hashMap
     * @param course: present courses in the school
     * @param teacher: teacher object from the Teacher class
     */
    fun addTeacher(teacher: Teacher, course: Course) {
        teachers[teacher] = course
    }

    /**
     * Removes a teacher from the teacher HashMap using the id of the teacher
     * @param idNo id of the teacher to be removed
     */
    fun sackTeacher(idNo: Int) {
        for (i in teachers.keys) {
            if (i.getIdNo() == idNo) {
                teachers.remove(i)
                println("${i.getFirstName()} successfully sacked")
                break
            }
        }
    }

    /**
     * The teachers duty status is by default false, the principal can set the duty of the teacher to true
     * @param idNo id of the teacher whose duty status is to be set to true
     */
    fun setTeacherDuty(idNo: Int) {
        for (i in teachers.keys) {
            if (i.getIdNo() == idNo) {
                i.setDuty(true)
                break
            }
        }
    }

    /**
     * Returns a list of all the teacher in the school
     */
    fun getAllTeachers(): String {
        var details = ""
        for (i in teachers.keys) {
            details += (i.teacherDetails() + teachers[i])
        }
        return details
    }

    /**
     * Creates a new applicant with its details and adds the applicant to the applicant list
     * @param applicant new applicant created from the applicant class
     */
    fun addAnApplicant(applicant: Applicant) {
        applicants.add(applicant)
    }

    /**
     * returns a list of the applicants created
     */
    fun getAllApplicants(): String {
        var applicantsDetails = ""
        for (i in applicants) {
            applicantsDetails += i.getApplicantDetails()
        }
        if (applicants.size == 0){
            println("No applicants yet, choose 3 from the main menu to create an applicant")
        }
        return applicantsDetails
    }

    /**
     * Adds a student to a class and also sets the student school fees based on the class the student is being added to
     * @param student student to be added to the class
     * @param classes class in which the student is being added to
     */
    fun addStudentToClass(student: Student, classes: Classes) {
        setStudentsSchoolFee(student, classes)
        students[student] = classes
    }

    /**
     * Set students fees based on the class he/she is added to
     */
    fun setStudentsSchoolFee(student: Student, classes: Classes) {
        when (classes.name) {
            "SS1", "SS2", "SS3" -> student.setSchoolFees(60_000)
            "JSS1", "JSS2", "JSS3" -> student.setSchoolFees(40_000)
            else -> println("Class of student not applicable")
        }

    }

    /**
     * returns the class of a particular student
     * @param student: student in which the class is to be found
     */
    fun getClass(student: Student): Classes {
        return Classes.valueOf(students[student].toString())
    }

    /**
     * The principal for each item in the applicants list, checks if the applicant meets the required
     * age and registers the applicant as a student, if he or she passes the condition, then courses are assigned to the
     * new student and is added to a class
     */
    fun addStudents(idCardColor: String = "Orange") {

        for (applicant in applicants) {
            if (applicant.getAge() > 12) {
                println("Enter new student(${applicant.getFullName()}) idNumber")
                val idNo = readLine()!!.toInt()
                applicant.setIDNo(idNo)
                applicant.setIdCardColor(idCardColor)


                while (applicant.getNoOfCourses() < 3) {
                    println("Enter the new student courses")
                    val courseName = readLine().toString()
                    println("Enter the course unit")
                    val courseUnits = readLine()!!.toInt()
                    if (courses.contains(Course(courseName, courseUnits))) {
                        val i = courses.indexOf(Course(courseName, courseUnits))
                        applicant.addCourse(courses[i])
                    } else {
                        println("Course not found, enter the course again")
                    }

                }


                println("Enter new student class")
                val className = readLine().toString()
                val classes = Classes.valueOf(className)
                addStudentToClass(applicant, classes)

            } else {
                val yearsToWait = 12 - applicant.getAge()
                println("Underage wait for $yearsToWait years")
            }

        }
        applicants.clear()
    }

    /**
     * returns a list of all the students in the school
     */
    fun getAllStudents(): String {
        var allStudents = ""
        for (i in students.keys) {
            allStudents += "${i.studentsDetails()}\tCLASS: ${getClass(i)}\n"
        }
        return allStudents
    }

    /**
     * The principal can expel a student using the idNo of the particular student
     * @param idNo idNumber of the student to be removed
     */
    fun expelStudent(idNo: Int) {
        for (i in students.keys) {
            if (i.getIdNo() == idNo) {
                students.remove(i)
                println(i.getFullName() + " has been expelled from the school")
                break
            }
        }
    }

    /**
     * Adds nonacademic objects to the nonAcademic List
     */
    fun addNonAcademic(nonAcademic: NonAcademic) {
        nonAcademics.add(nonAcademic)
    }

     // Returns a list of nonAcademic staff in the school
    fun getNonAcademicDetails(): String {
        var allNonTeaching = ""
        for (i in nonAcademics) {
            allNonTeaching += i.getDetails()
        }
        return allNonTeaching
    }

    // Returns the details of the principal
    private fun getPrincipalDetails() = "PRINCIPAL:\nThe name of the principal is ${getFullName()}\tAge: ${getAge()}\tSex: ${getSex()}" +
            "\tSalary: #${getSalary()}\tIdCard Color: ${getIdCardColor()}"

    // Returns a list of all person in the school
    fun getAllPerson() = getPrincipalDetails() + "\n\nTEACHERS:" + getAllTeachers() + "\n\nNON-ACADEMIC STAFF:" + getNonAcademicDetails() + "\n" + getAllStudents()


}