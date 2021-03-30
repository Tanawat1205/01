package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Write a message to the database
//
//        // Write a message to the database
//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("message")
//
//        myRef.setValue("Hello, World!")

        btc2.setOnClickListener{
            ename.setText("")
            surname.setText("")
        }
        btsend.setOnClickListener{

            val fname = ename.text.toString()
            val sur =surname.text.toString()


            val fb = FirebaseDatabase.getInstance()
            val ref = fb.getReference("Employee")
            val id:String? = ref.push().key

            val Employee =  Employee(id.toString(),fname,sur)

            ref.child(id.toString()).setValue(Employee).addOnCompleteListener{
                Toast.makeText(applicationContext,"Complete",Toast.LENGTH_LONG).show()
                ename.setText("")
                surname.setText("")
            }

        }

    }
}