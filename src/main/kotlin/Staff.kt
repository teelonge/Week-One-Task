abstract class Staff(idNo: Int, firstName: String, lastName: String, age: Int,
                     sex: String, idCardColor: String,
                     private var salary : Int, private var onDuty: Boolean
) : Person(idNo, firstName, lastName, age,
    sex,
    idCardColor
) {
    abstract fun drivesACar(car: Car): String

    abstract fun disciplineStudent() : Boolean

    fun getSalary() : Int{
        return salary
    }
    fun setDuty(onDuty: Boolean){
        this.onDuty = onDuty
    }
    fun getDuty(): Boolean{
        return onDuty
    }

}