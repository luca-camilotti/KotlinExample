
/*
    Try Kotlin online:
    https://play.kotlinlang.org
* */

// Ref: https://www.tutorialspoint.com/kotlin
// https://play.kotlinlang.org/byExample/01_introduction/01_Hello%20world
// https://www.davideaversa.it/blog/kotlin-development-in-vscode/
// https://developer.ibm.com/tutorials/learn-kotlin-6/
/*
    Following are the different scenarios where Kotlin compiler will work differently.
    Compile Kotlin into bytecode which can run on JVM. This bytecode is exactly equal to the byte code generated by the Java .class file.
    Whenever Kotlin targets JavaScript, the Kotlin compiler converts the .kt file into ES5.1 and generates a compatible code for JavaScript.
    Kotlin compiler is capable of creating platform basis compatible codes via LLVM.
    Kotlin Multiplatform Mobile (KMM) is used to create multiplatform mobile applications with code shared between Android and iOS.

 */

/*
   Semicolon: optional
   ___________________

   new keyword: not used
   _____________________


   Functions (= Java methods)
   ___________________________

   Defined with fun keyword:

   fun foo(pamam1: Int, param2: String): Unit {
      // Unit as the return type means "void"
   }
   Entry point for a kotlin application: main function

   fun main(args: Array<String>) {
   ...
   }

   You can omit {} for functions with only one instruction in the body.
   Example:

   fun distance(point: Punto2D) = sqrt((point.x - this.x).pow(2) + (point.y - this.y).pow(2))

   Lambda Functions
   ________________

   Example:
   val sum = { x: Int, y: Int -> x + y }

   The last expression inside the body is considered as the return statement.

   Overriding
   __________
   Use override keyword in front of the function:
   override fun pippo(): Int { ... }

   Exceptions
   __________
   Like Java (throw, try, catch..).
   Exception subclasses are the same as in Java.

   Null Safety
   ___________

   As everything is an object in Kotlin (even Java primitive types),
   everything can be null.
   The way to specify that a variable can be null is by adding
   a question mark to the end of its type:
   val a: Int? = null

   Using the safe call operator (?.), the following line will
   only be executed if the variable is not null.
   Otherwise, it will do nothing:
   val myString = a?.toString()

   We can even provide an alternative for the null case using
   the Elvis operator (?:):
   val myString = a?.toString() ?: ""

   Non-null safety (!!)
   ____________________
   The !! operator converts a nullable type to a non-null type.
   val nullableName: String? = null
   nullableName!!.toUpperCase() // Results in NullPointerException

   Throws NullPointerException if object a is null:
   val myString = a!!.toString()

   Variables
   _________
   var is a variable (mutable)
   val is a constant (immutable)

   Data Type:
   Byte, Short (16 bit), Int, Long, Float, Double, Boolean

   Note that everything is an object in Kotlin (even Java primitive types)!

   Encapsulation/Information Hiding
   ________________________________

   In Kotlin, everything inside a class is public by default.
   So, writing "public" in front of an attribute or a function (method)
   is redundant.

   Getters and Setters
   ___________________

   In Kotlin, a property (attribute) doesn’t require explicit getter or setter methods.
   When you define an attribute inside a class, default getter and setter methods are
   automatically generated.
   For example, writing:

   var name: String = "Pippo"

   generates default getter and setter, and it's exactly the same as writing:

   var name: String = "Pippo"
   get() {
      return field
   }
   set(value) {
      field = value
   }

   With getter and setter you will be able to read and assign a value to the attribute
   outside the class:

   myobj.name="Pluto"  // using setter
   println(myobj.name) // using getter

   Of course, you can modify the default getter and setter behaviour:

   var name: String = "Pippo"
   get() {
      return "Mr."+ field
   }
   set(value) {
      if(value.equals(""))
          field = "unknown"
      else
          field = value
   }

   If an attribute is declared with val keyword, it is immutable (you can't use the setter on it).

   Static methods in Kotlin
   ________________________

   In order to declare a method as static, you will use the "companion object" block.

   // In Java:
   class Foo {
        public static int a() { return 1; }
   }

   // In Kotlin:
   class Foo {
        companion object {
            fun a() : Int = 1
        }
   }

   Inheritance and final keyword
   _____________________________

   Classes marked as final cannot be extended (by default all classes are final in Kotlin).

   Methods marked as final cannot be overridden (by default all methods are final default in Kotlin).

   To make a class a base class, mark it with "open" keyword.
   To make a method overridable, mark it with "open" keyword.


 */
import java.time.LocalDate

// Example 1
// Simple empty class (no attributes, no methods):
class Pippo


// Example 2
// Class with primary constructor (generate automatically attributes and getters):
class Person(val givenName: String, val familyName: String, val dateOfBirth: LocalDate)
// you can put extra code for constructor inside init{} block
// val attribute: cannot be modified, so you cannot use the setter

// Example 3
// A data class is a class for holding data: it has automatically generated methods
// (toString, copy, equals, componentN(), ..)
data class User(val name: String, val age: Int)

// Example 4
// In this class we define custom getter and setter for attribute "type".
// We also define the init{} block to provide further operations to be executed
// by the primary constructor.
// var attribute: generate getter and setter
class Animal(type: String, var breed: String) {

    init {  // init (optional) performs additional instructions when primary constructor in called
        if(breed.equals(""))
            breed = "unknown"
    }
    // Getter and setter declaration for field "type" in primary constructor.
    // Note that, in this case, the attribute is not defined inside the primary
    // contructor (var/val keyword is missing for "type"), since it is defined here.
    // Also note that getter and setter behaviours are the default, so their definition may be
    // omitted (they are redundant).
    var type: String = type  // an attribute is public by default
    get() = field
    set(value) {
        field = value
    }

    // Define additional "age" attribute with custom setter (when you don't define a getter, the default
    // one is generated).
    private var age: Int = 0  // if private, you can't use getter and setter outside the class..
    set(value) {  // setter for age
        if(value > 0)
            field = value
        else
            field = 0
    }

    // Define a method:
    fun getAge(): Int {
        return this.age; // return the value of the private attribute
    }

    // Define a secondary constructor:
    // Note that this secondary constructor uses the primary constructor
    // to set type and breed attributes: this(type, breed).
    // Calling the primary contructor in a secondary constructor is mandatory.
    constructor(type : String , breed :String, age :Int):this(type,breed) {
        if(age > 0)
            this.age = age
    }

    // Define another secondary constructor:
    constructor(type : String) : this(type, "") {
        if(age > 0)
            this.age = age
    }

}

fun main(args: Array<String>) {
    println("Hello World!")

    // Variable declaration examples:
    var msg: String = "Hello, World!" // defining a variable
    var msgAlt = "CheSuperSbomballo!"  // type inference
    var bool: Boolean = true  // a Boolean
    var boolNull: Boolean? = null  // a Boolean that can have null value

    // Printing output examples:
    println("$msg")  // print variable with $ sign
    println("message: "+msg)  // print variable in Java-like style

    // Null Safety example:
    var myString: String? = "Pippo" // declare a string that can be null
    myString = boolNull?.toString() // assign a value only if it's not null
    println("myString is: "+myString)

    // Elvis operator example:
    myString = boolNull?.toString() ?: "Boolean was null"  // assign the boolean value if it's non null, otherwise assign the other string
    println("myString is: "+myString)


    // Data types:
    val x: Int = 10000    // Integer (val = const)
    println("Int value is: "+x)

    val y: Long = x.toLong()   // Casting

    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)   // Array (val = const)
    println("Value at 3rd position : " + numbers[2])
    numbers.set(2, 15)  // set a value
    // numbers.set(5, 25)  // Error! Out of bounds
    println("Value at 3rd position : " + numbers[2])

    // Classes:

    val u = User("Pippo", 18)
    println("User Class Example: "+u.name+" "+u.age);
    // u.name = "Pluto";  // Error: val cannot be reassigned


    val p = Person("Joe", "Doe", LocalDate.now())

    println(p.dateOfBirth.toString()+" "+p.givenName+" "+p.familyName)

    val animal = Animal("dog", "")

    println("Breed: "+animal.breed)
    animal.type = "monkey";  // setter
    animal.breed = "macaco";
    // animal.age = 5;  // Error! age attribute is private
    println("This "+animal.type+" is "+animal.getAge()+" years old.")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    // Input
    println("write something: ")
    var input = readLine()
    println("input: "+input)
    println("input to Int: "+input?.toInt())  // possibly throws NumberFormatException
}