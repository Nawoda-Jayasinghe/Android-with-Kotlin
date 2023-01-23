package lk.ac.kln.mit.stu.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//this is the layout controller class of the activity main layout
class MainActivity : AppCompatActivity() {
    //this oncreate function is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //provides us  a bundle of activities
        setContentView(R.layout.activity_main) //this is used to connect with the appropiate xxml file
    // here we have to include all the main work such as creating views and binding data
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        var enteredName = " "

        val offersButton = findViewById<Button>(R.id.btnOffers)

        //on click listner
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()

            // check if the input field is empty
            if (enteredName==""){

                offersButton.visibility = INVISIBLE

                greetingTextView.text = " "
                //context, msg and the duration should give as parameters.
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name!",
                    Toast.LENGTH_SHORT
                ).show()

            }else{
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()

                offersButton.visibility = VISIBLE
            }


        }

        offersButton.setOnClickListener{
            //we use intend to navigate form one activity to another
            // we have to give 2 arguments here. (current view, the pace we want to naigated)
            val intent = Intent(this, SecondActivity ::class.java) // this is an intent object

            intent.putExtra("USER",enteredName) //we have to give a name and the value here

            //intent is a class in android libraries. here we have created an object from the class
            //mostly in android we create objects from andoird classes and invoke the functions.
            //but sometimes we have to create own classes and objects
            startActivity(intent) //now we navigate from one activity to another
        }
    }
}