package de.affinitas.test.kotlinbook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello Kotlin!"

        toast("hello")
        toast("Hello", Toast.LENGTH_LONG)
        niceToast("Hello", "MyTag")
        niceToast("Hello", "MyTag", Toast.LENGTH_LONG)
        toast(message = "Hello", length = Toast.LENGTH_LONG)
    }



    /**
     *  default constructor
     */
//    class Person(name: String, surname: String) {
//        init {
//
//        }
//    }

// class inheritance
    open class Animal(name: String)
    class Person(name: String, surname: String) : Animal(name) {

        // functions
//    fun add(x: Int, y: Int) : Int{
//        return  x + y
//    }
        fun add(x: Int, y: Int) : Int = x + y

    }
// constructor functional parameters
    /**
     * length specifies a default value
     */

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message, length).show()
    }
//    toast("Hello")
//    toast("Hello", Toast.LENGTH_LONG)
    fun niceToast(message: String, tag: String = MainActivity::class.java.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this,"[$tag] $message", length).show()
    }

    /**
     *   String Templates
     *   you can use string expressions directly like "\[$className] $message"
     *   "Your name is ${user.name}"
     */


}
