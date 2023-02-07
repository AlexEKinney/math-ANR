package net.kincode.maths

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")

        findViewById<TextView>(R.id.textView).text = "Welcome, "+displayName
//auth.signOut()
        findViewById<Button>(R.id.homework_btn).setOnClickListener{
            val intent : Intent = Intent(this, HomeworkActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.acc_btn).setOnClickListener {
            val intent : Intent = Intent(this , acc_activity::class.java)
            intent.putExtra("name" , displayName)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}