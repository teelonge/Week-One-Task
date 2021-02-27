import java.util.*

fun main() {
    /**
     * A school project that models a secondary school using object-oriented programming in which the principal has admin
     * roles and authority over employing teachers, admitting students, expelling students e.t.c
     */
    val scanner = Scanner(System.`in`)

    // Creates an instance of the principal
    val principal = Principal(10000, "Olusola", "Adegbite", 42, "Male", onDuty = true)

    // Creates various instances of teachers
    val teacherAde = Teacher(20001, "Bukunmi", "Ogunseye", 32, "Female")
    val teacherIbrahim = Teacher(20002, "Ibrahim", "Muhammed", 39, "Male")
    val teacherShade = Teacher(20003, "Olutosin", "Folarin", 31, "Female")
    val teacherAbass = Teacher(20004, "Abbass", "Akintunde", 34, "Male")

    // Creates instances of courses in the school
    val mathematics = Course("Mathematics", 5)
    val english = Course("English", 5)
    val science = Course("Science", 3)
    val geography = Course("Geography", 3)
    val chemistry = Course("Chemistry", 5)
    val history = Course("History", 3)
    // Principal adds the courses to the list of courses in the school
    principal.addACourse(mathematics)
    principal.addACourse(english)
    principal.addACourse(science)
    principal.addACourse(geography)
    principal.addACourse(chemistry)
    principal.addACourse(history)


    // Principal adds teachers to the teachers database and assigns a course to each one
    principal.addTeacher(teacherAde, mathematics)
    principal.addTeacher(teacherIbrahim, english)
    principal.addTeacher(teacherShade, geography)
    principal.addTeacher(teacherAbass, chemistry)

    // Instances of non-academic staff created
    val julius = NonAcademic(30001, "Julius", "Festus", 38, "Male")
    val adelabu = NonAcademic(3002, "Wasiu", "Adelabu", 45, "Male")
    val gloria = NonAcademic(3003, "Gloria", "Owen", 34, "Female")

    // Principal adds non academic staff to the non-academic staff database
    principal.addNonAcademic(julius)
    principal.addNonAcademic(adelabu)
    principal.addNonAcademic(gloria)

    // Creates various objects of the student class
    val oyinkan = Student(40001, "Oyinkansola", "Fakorede", 17, "Female")
    val stephen = Student(40002, "Stephen", "Adegoke", 18, "Male")
    val kehinde = Student(40003, "Kehinde", "Oyekanmi", 13, "Male")
    val salmat = Student(40004, "Salmat", "Adenike", 15, "Female")
    val chioma = Student(40005, "Chioma", "Ijezie", 16, "Female")
    val jacob = Student(40006, "Jacob", "Olowu", 12, "Male")

    // Car instances to check the overridden abstract method in the staff class
    val toyota = Car("Toyota", 2020)
    val honda = Car("Honda", 2019)

    // Principal adds student to the student database and assigns classes to each of them
    principal.addStudentToClass(oyinkan, Classes.SS1)
    principal.addStudentToClass(stephen, Classes.SS3)
    principal.addStudentToClass(kehinde, Classes.JSS1)
    principal.addStudentToClass(salmat, Classes.JSS2)
    principal.addStudentToClass(chioma, Classes.SS1)
    principal.addStudentToClass(jacob, Classes.JSS1)

    // Each student can take a course upto a maximum of three courses
    oyinkan.addCourse(english)
    oyinkan.addCourse(mathematics)

    stephen.addCourse(history)
    stephen.addCourse(mathematics)
    salmat.addCourse(chemistry)
    salmat.addCourse(english)

    kehinde.addCourse(english)
    kehinde.addCourse(history)
    kehinde.addCourse(mathematics)

    chioma.addCourse(science)
    chioma.addCourse(mathematics)
    chioma.addCourse(chemistry)

    jacob.addCourse(geography)
    jacob.addCourse(history)

    // Sets teacher duty with corresponding IDNO to true
    principal.setTeacherDuty(20002)
    principal.setTeacherDuty(20003)

    principal.drivesACar(toyota)
    //Loop for the console output
    var isRunning = true
    while(isRunning){
        println("Welcome To MySchool\n\t1. View all persons in the school\n\t" +
                "2. List all courses in the school\n\t3. Create an applicant\n\t4. " +
                "Admit applicants based on age to the school\n\t5. Expel a student\n\t6. Quit")
        when(scanner.nextInt()){
            1->{
                println("\t1. List all teachers\n\t2. List all students\n\t3. List all applicants\n\t4. List all non-academic staff\n\t5. List all persons in the school\n\t6. Go back to main menu")
                when(scanner.nextInt()){
                    1-> println(principal.getAllTeachers())
                    2-> println(principal.getAllStudents())
                    3-> println(principal.getAllApplicants())
                    4-> println(principal.getNonAcademicDetails())
                    5-> println(principal.getAllPerson())
                    6-> continue
                }

            }
            2->{
                println(principal.listAllCourses())
            }
            3->{
                    val initApplicantSize = principal.getApplicants().size
                    val applicant = Applicant.createAnApplicant()
                    principal.addAnApplicant(applicant)
                    if (principal.getApplicants().size > initApplicantSize) {
                        println(applicant.getApplicantDetails() + "has been added to the applicants list")
                    }
            }
            4-> {
                principal.addStudents()
                println("Applicants above age 12 have been admitted to the school successfully")
            }
            5->{
                println("Enter the idNumber of the student you want to expel")
                val id = scanner.nextInt()
                principal.expelStudent(id)
            }
            6->{
                isRunning = false
            }
        }
    }

}
