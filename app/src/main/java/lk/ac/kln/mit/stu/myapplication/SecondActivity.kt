package lk.ac.kln.mit.stu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //now we have to get the user name using the intent
        //have to give the id we used on the main activity
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)

        //this is the message we want to display
        val message =   "$userName, you will get access for pro features for one month!"
        textView.text = message
    }
}