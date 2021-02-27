data class Course(val name: String, val units: Int) {
    override fun toString(): String {
        return "\tCOURSE NAME: $name" +
                "\tCOURSE UNITS: $units\n"
    }


}


object Courses{
    fun listOfCourses():List<Course>{
        return arrayListOf(
            Course("Mathematics", 50),
            Course("Mathematics", 50),
            Course("Mathematics", 50),
            Course("Mathematics", 50),
            Course("Mathematics", 50)
        )
    }
}