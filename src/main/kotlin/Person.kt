open class Person(private var idNo: Int, private val firstName: String, private val lastName: String,
                  private val age: Int, private val sex: String, private var idCardColor: String)
{
    private val fullName = "$firstName $lastName"

    fun getFullName() = fullName
    fun getIdNo() = idNo
    fun getIdCardColor() = idCardColor
    fun getFirstName() = firstName
    fun getLastName() = lastName
    fun getAge() = age
    fun getSex() = sex

    fun setIDNo(idNo: Int){
        this.idNo = idNo
    }

    fun setIdCardColor(idCardColor: String){
        this.idCardColor = idCardColor
    }
}