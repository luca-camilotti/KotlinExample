import java.time.LocalDate
/*
* Example of Student class:
* the following example is incomplete and
* it's meant to be just a starting point
* to work with.
* */
class Student(name: String, surname: String,
              var classe: String, var spec: String, var dob: LocalDate) {

    var name: String = name
        set(value) {
            if(value!=null && !value.isEmpty() )
                field = value
            else
                throw Exception("invalid name: "+value)
        }
    var surname: String = surname
        set(value) {
            if(value!=null && !value.isEmpty() )
                field = value
            else
                throw Exception("invalid surname: "+value)
        }
    init {  // init (optional) performs additional instructions when primary constructor in called
        this.name = name  // setter di name
        this.surname = surname  // setter di surname
    }
    override fun toString(): String {
        return this.name+" "+this.surname+" ("+this.dob+"), classe "+this.classe+this.spec
    }
}

//--------------------------------------------
fun main() {
    var pippo: Student;
    pippo = Student("Pippo", "VanWoof", "", "", LocalDate.now())
    println("Studente: "+pippo)
}