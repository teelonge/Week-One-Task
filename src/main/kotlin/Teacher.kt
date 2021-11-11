class Teacher(idNo: Int, firstName: String, lastName: String,
                  age: Int, sex: String,
                  salary: Int = 75000,
                  onDuty: Boolean =false,
                  idCardColor: String = "Green"
    ) : Staff(idNo, firstName, lastName, age,
        sex,
        idCardColor,
        salary, onDuty
    ) {

        // Returns the details of the teacher
        fun teacherDetails() : String{
            return "\nIDNO: ${getIdNo()}\tNAME: ${getFullName()}\tAGE: ${getAge()} years\tSEX: ${getSex()}" +
                    "\tSALARY: #${getSalary()}\tIDCARDCOLOR: ${getIdCardColor()}\tON DUTY STATUS: ${getDuty()}"
        }

        override fun drivesACar(car: Car): String {
            return "Teacher ${getFullName()} drives a ${car.carName} ${car.carModel} model"
        }

        override fun disciplineStudent(): Boolean {
            return true
        }

        fun teachACourse() : String{
            return "I am teaching"
        }


        /*
            Companion object to create one instance of a teacher and add it to the teachers list
         */
        companion object{
            fun createATeacher() : Teacher{
            println("Enter the teacher's details\n\tEnter the teacher's id Number")
            val idNo = readLine()?.toInt()
            println("\tEnter the first name")
            val firstName = readLine().toString()
            println("\tEnter the last name")
            val lastName = readLine().toString()
            println("Enter the teacher's age")
            val age = readLine()?.toInt()
            println("Enter the teacher's sex")
            val sex = readLine().toString()

            return Teacher(idNo!!,firstName,lastName,age!!,sex)
        }


        }


    }