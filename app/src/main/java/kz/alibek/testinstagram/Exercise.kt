package kz.alibek.testinstagram

fun main() {

    //EX 1  Kotlin Syntax Basics
    val int1 = 1
    val double1 = 1.0
    val string1 = "Some string"
    val boolean1 = false

    println("Variables: $int1, $double1, $string1, $boolean1")
    println("Value of Conditional Statement: ${checksNumber(int1)}")
    printLoop()

    //EX 2  Kotlin OOP (Object-Oriented Programming)
    println("Person details: ${Person.exampleOfPerson.displayInfo()}")
    println("Employee details: ${Employee.exampleOfEmployee.displayInfo()}")

    val account = BankAccount() //Initial value of balance is 15
    account.deposit(15) // add money
    account.deposit(-13) // try to add negative number
    account.withdraw(5) // withdraw number
    account.withdraw(-5) // try to withdraw negative number
    account.withdraw(26) // try to withdraw more money than have in account
    println("Account value: $account") //print data about account and balance

    //EX 3 Kotlin Functions
    println(twoIntegers(5, 6))
    val lambdaFunc: (Int, Int) -> Int = { first, second -> first*second }
    println("Result of lambda: ${lambdaFunc(8, 5)}")
    println("Result of lambda2: ${secondLambda(8, 5) { first, second -> first - second }}")
}

private fun checksNumber(integer: Int): String {
    return when {
        integer > 0 -> "positive"
        integer < 0 -> "negative"
        else -> "zero"
    }
}

private fun printLoop() {
    var counter = 0
    while (counter != 10) {
        println(++counter)
    }
}

private fun twoIntegers(first: Int, second: Int) = first + second

private fun secondLambda(first: Int, second: Int, lambda: (Int, Int) -> Int): Int {
    return lambda(first, second)
}

//Data about the classes is here!

open class Person(
    open val name: String,
    open val age: Int,
    open val email: String,
) {
    companion object {
        val exampleOfPerson = Person(
            name = "Alibek",
            age = 22,
            email = "alibek321321@gmail.com"
        )
    }

    open fun displayInfo() = "Name: $name, age: $age, email: $email"
}

class Employee(
    override val name: String,
    override val age: Int,
    override val email: String,
    val salary: String
) : Person(
    name = name,
    age = age,
    email = email,
) {
    companion object {
        val exampleOfEmployee = Employee(
            name = "Alibek",
            age = 22,
            email = "alibek321321@gmail.com",
            salary = "321321321321",
        )
    }

    override fun displayInfo(): String {
        return "${super.displayInfo()}, salary: $salary"
    }
}

data class BankAccount(
    private var balance: Int = 15,
) {

    fun deposit(money: Int) {
        if (money < 0) {
            println("can not deposit negative number")
            return
        }
        balance += money
    }

    fun withdraw(money: Int) {
        if (money < 0) {
            println("can not withdraw negative number")
            return
        }
        if ((balance-money) < 0) {
            println("insufficient funds in the bank")
            return
        }
        balance -= money
    }
}