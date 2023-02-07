package net.kincode.maths

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class HomeworkActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework)
        findViewById<Button>(R.id.doTaskBtn).setOnClickListener {
            val intent : Intent = Intent(this , TaskActivity::class.java)
            intent.putExtra("quiz_name", "Simple Addition")
            intent.putExtra("questions_no", 3)
            intent.putExtra("temp1", "1+3")
            intent.putExtra("temp2", "5+4")
            intent.putExtra("temp3", "6+3")
            startActivity(intent)
        }
        }
    }

