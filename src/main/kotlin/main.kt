import logic.DataSource
import java.util.*

fun main() {
    /**
     * A school project that models a secondary school using object-oriented programming in which the principal has admin
     * roles and authority over employing teachers, admitting students, expelling students e.t.c
     */
    val scanner = Scanner(System.`in`)

    val principal = DataSource.createSchool()
    DataSource.generateConsoleDetails(principal,scanner)
}

