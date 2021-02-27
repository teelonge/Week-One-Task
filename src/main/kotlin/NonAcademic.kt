class NonAcademic(idNo: Int, firstName: String,
                  lastName: String, age: Int, sex: String,
                  idCardColor: String = "Brown", salary: Int = 30000,
                  onDuty: Boolean = true) : Staff(idNo, firstName, lastName, age, sex, idCardColor, salary, onDuty)
{
    override fun drivesACar(car: Car): String {
        return "${getFirstName()} doesn't drive a car"
    }

    override fun disciplineStudent(): Boolean {
        return false
    }

    fun getDetails() = "\nNAME: ${getFullName()}\tAGE: ${getAge()}\tSEX: ${getSex()}\tSALARY: #${getSalary()}\tIDCARD COLOR: ${getIdCardColor()}\n"

}


