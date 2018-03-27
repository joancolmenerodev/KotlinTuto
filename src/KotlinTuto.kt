import java.util.*

fun main(args : Array<String>){
    println("Hello, world")



    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    //How to print?
    println("Biggest INT :" + bigInt)
    println("Smallest INT : $smallInt")

    //Short  16 bites Byte 8 bites


    var dblNum1: Double = 1.1111111111111111
    var dblNum2: Double = 1.1111111111111111
    //Will output 2.2222222222223 because Double only permits 15 digits
    println("Sum : " + (dblNum1 + dblNum2))


    //Booleans
    if(true is Boolean){
        print("true is boolean\n")
    }

    //Create a character
    var letterGrade: Char = 'A'
    println("A is a Char : ${letterGrade is Char}")


    //Casting
    println("3.14 to Int: " + (3.14.toInt()))
    println("A to Int : " + (letterGrade.toInt()))
    println("65 to Char : " + 65.toChar())

    //Strings
    //read var not going to change (immutable string)
    val name = "Joan"
    val longStr = """This is a long string"""
    //Gonna change
    var fName: String = "Colmenero"
    var lName: String = "Orús"

    fName = "sally"
    var fullName = fName + " " + lName;
    println(fullName)
    println("1 + 2 = ${1 + 2}") // result 1 + 2 = 3

    //Comparing String
    var str1 = "A random string"
    var str2 = "a random string"

    println("String Equal : ${str1.equals(str2)}")
    /*
    TRUE --> 1
    FALSE --> -1
    EQUALS --> 0
     */
    println("Compare A to B : ${"A".compareTo("B")}")

    //Getting index from String
    println("2nd Inted : ${str1[2]}")

    //SubSequence
    println("Contains random : ${str1.subSequence(2,8)}") //return random


    //If String contains other string
    println("Contains random : ${str1.contains("random")}") //return true


    //Arrays
    var myArray = arrayOf(1,1.23,"Colmenero")
    //Acces to them
    println(myArray[2])

    //Change value
    myArray[1] = 3.14
    //Lenght
    println("Array Length : ${myArray.size}")
    //Check if contains
    println("Colmenero in Array : ${myArray.contains("Colmenero")}")

    var partArray = myArray.copyOfRange(0,1)
    //Get the first element from array
    println("First element : ${myArray.first()}") //Last is available too

    //Get index from value
    println("Colmenero index: ${myArray.indexOf("Colmenero")}")

    //Collections (Array of squares)
    //for each index value will multiply by its index
    var sqArray = Array(5,{x->x*x})
    print(sqArray[2])

    //Int array
    var arr2: Array<Int> = arrayOf(1,2,3)

    //Ranges

    val oneTo10 = 1..10
    val alpha = "A".."Z"

    //In to search a range
    println("R in Alpha ${"R" in alpha}")

    //10 to 1
    val tenTo1 = 10.downTo(1)

    //a number to another one
    val twoTo20 = 2.rangeTo(20)

    //Adding 3 each time
    val rng3 = oneTo10.step(3)

    //Cycle through a range and print information
    for (x in rng3) println("rng3 : $x")

    //Reverse a range
    for(x in tenTo1.reversed())println("Reverse : $x")

    val age = 8

    //if .. else if .. else
    if(age <5){
        println("Go to Preschool")
    }else if (age ==5){
        println("Go to Kindergarten")
    }else if ((age>5)&&(age<=17)){
        val grade = age-5
        println("Go to Grade $grade")
    }else{
        println("Go to College")
    }

    //While
    when(age){
        0,1,2,3,4-> println("Go to Preschool")
        5-> println("Go to Kindergarten")
        in 6..17->{
            val grade = age -5
            println("Go Grade $grade")
        }
        else -> println("Go to College")
    }

    //For
    for (x in 1..10){
        println("Loop : $x")
    }

    //Random utilities
    val rand = Random()
    val magicNum = rand.nextInt(50)+1

    var guess = 0
    while (magicNum != guess){
        guess+=1
    }
    println("Magic Number was $guess")

    //Check if it's even or odd
    for(x in 1..20){
        if (x%2==0){
            continue
        }
        println("Odd : $x")
        if(x==15)break
    }


    var arr3: Array<Int> = arrayOf(3,6,9)
    for(i in arr3.indices){
        println("Mult 3 : ${arr3[i]}")
    }

    for ((index,value)in arr3.withIndex()){
        println("Index : $index Value : $value")
    }

    //Create functions doesn't need a return if it's on single line
    fun add(num1: Int, num2: Int) : Int = num1+num2
    println("5 + 4 = ${add(5,4)}")

    //Setting default values to parameters
    fun subtract(num1: Int = 1, num2: Int = 1) : Int = num1-num2
    println("5 - 4 = ${subtract(5,4)}")

    println("5 - 4 = ${subtract(num2 = 5,num1 =4)}")

    //Void == : Unit
    fun sayHello(name: String) = println("Hello $name")
    sayHello("Joan")

    //Declaring two values at once
    val (two,three) = nextTwo(1)
    println("1 $two $three")

    //Calling getSum using varargs to send variable numbers
    println("Sum = ${getSum(1,2,3,4,5)}")

    //That acts like a function
    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("5 * 3 = ${multiply(5,3)}")

    //Factorial
    println("5! = ${fact(5)}")

    //Higher order functions either Accepts or returns another function

    val numList = 1..20

    //To find even List
    //If a function has only 1 parameter you don't have to declare it'
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach{n -> println(n)}

    //Important
    val mult3  = makeMathFunc(3)
    println("5 * 3 = ${mult3(5)}")

    //Important as well
    val multiply2 = {num1: Int -> num1 * 2}
    val numList2 = arrayOf(1,2,3,4,5)
    mathOnList(numList2,multiply2) //Return 2,4,6,8,10

    //Collection operators gonna work on every collection (Maps,List,Arrays,etc...)
    val numList5 = 1..20
    //Reduce : summ all numbers on a list
    val listSum = numList5.reduce{x,y->x+y}
    println("Reduce Sum : $listSum")
    //fold start off with an initial value of X and then it is going to continuing adding the values to the list
    val listSum2 = numList5.fold(5){x,y->x+y}
    println("Reduce Fold : $listSum")

    //Check if there are values even in a list
    println("Evens : ${numList5.any {it % 2 == 0}}")
    //Check if ALL of the values are even
    println("Evens : ${numList5.all {it % 2 == 0}}")
    //Filter
    val big3 = numList5.filter { it > 3 }
    big3.forEach { n -> println(">3 : $n") }
    //You can do operations with map
    val times7 = numList5.map { it * 7 }
    times7.forEach { n -> println("*7 : $n") }

    //Try catch
    val divisor = 0
    try{
        if(divisor == 0){
            throw IllegalArgumentException("Cant Divide By Zero")
        }else{
            println("5 / $divisor = ${5/divisor}")
        }
    }catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    //Mutable list and Immutable list
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5)

    //Immutable list not changing
    val list2: List<Int> = listOf(1,2,3,4,5)
    /*
    Basic functions with list
    list1.add(6)
    println("1st : ${list1.first()}")
    println("2nd : ${list1[2]}")
    println("Last : ${list1.last()}")
    //Clear list
    list1.clear()
    //Remove a number
    list1.remove(1)
    list1[2] = 10
    list1.forEach{n-> println("Mutable List: $n")}
     */


    //Map
    //Key,value
    val map = mutableMapOf<Int,Any?>()
    val map2 = mutableMapOf(1 to "Joan", 2 to 25)

    map[1] = "Joan"
    map[2] = 23
    println("Map Size : ${map.size}")
    map.put(3,"Pittsburgh")
    map.remove(2)
    for((x,y)in map){
        println("Key : $x Value : $y")
    }


    //How to create objects
    val bowser = Animal("Bowser",20.0,13.5)
    bowser.getInfo()

    val spot = Dog("Spot", 20.0,14.5,"Paul Smith")
    spot.getInfo()

    //Testing Interface
    val tweety = Bird("Tweety",true)
    tweety.fly(10.0)

    //Null safety
    //You can not add null to a var if you want to do that you do this way
    var nullVal : String? = null
    fun returnNull():String?{
        return null
    }

    var nullVall3 = returnNull()
    //Smart cast
    if(nullVall3!=null){
        println("${nullVall3.length}")
    }
    //Force an all assigment
    var nullVall2 = nullVall3!!.length

    //Elvis operation
    var nullval4:String = returnNull() ?: "No Name"




}

//Returining 2 values out of class
fun nextTwo(num: Int): Pair<Int,Int>{
    return Pair(num+1,num+2)
}
//Sum of 2 numbers
fun getSum(vararg nums: Int): Int {
    var sum=0
    nums.forEach { n -> sum += n }
    return sum
}

//Recursive function factorial number
fun fact(x:Int):Int{
    tailrec fun factTail(y: Int, z: Int):Int{
        if(y==0)return z
        else return factTail(y-1,y*z)
    }
    return factTail(x,1)
}

//Function that generetaes functions
fun makeMathFunc(num1: Int):(Int)-> Int={num2->num1*num2}

fun mathOnList(numList: Array<Int>, myFunc:(num : Int) -> Int){
    for(num in numList){
        println("MathOnList ${myFunc(num)}")
    }
}

/*
    There are no static methods classes are marked as final unless user mark them as open
 */

open class Animal(val name: String,
                  var height: Double,
                  var weight: Double){
    //Init function to initiazlie
    init {
        //Check if there's a decimal value
        val regex = Regex(".*\\d+.*")

        require(!name.matches(regex)) {"Animal name can't contain Number"}
        require(height>0) {"Height must be Greater than 0"}
        require(weight>0) {"Height must be Greater than 0"}
    }

    open fun getInfo():Unit{
        println("$name is $height tall and weighs $weight")
    }
}

class Dog(name:String,
          height: Double,
          weight:Double,
          var owner: String) : Animal (name, height,weight){
    override fun getInfo() {
        println("$name is $height tall and weighs $weight and is owned by $owner")

    }
}


//Interface
interface Flyable{
    var flies: Boolean
    fun fly(distMile:Double):Unit
}

class Bird constructor(val name:String, override var flies: Boolean = true): Flyable{
    override fun fly(distMile: Double) {
        if(flies){
            println("$name flies $distMile")
        }
    }

}