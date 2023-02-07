package net.kincode.maths

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.chip.Chip
import com.google.firebase.auth.FirebaseAuth

class TaskActivity : AppCompatActivity() {
    private var Ans: String? = null
    private var progressBar: ProgressBar? = null
    private var Chip: Chip? = null
    private var progressBarStatus = 0
    var dummy:Int = 0
    private val que:String = ""

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val quiz_name = intent.getStringExtra("quiz_name")
        findViewById<TextView>(R.id.quiz_title).text = quiz_name
        val quetions = intent.getStringExtra("questions_no")
        progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        if (quetions != null) {
            progressBar!!.max = quetions.toInt()
        }
        progressBar!!.progress = 1
        Chip = findViewById<Chip>(R.id.chip5) as Chip
        Chip!!.setText("1")
        val temp1 = intent.getStringExtra("temp1")
        val temp2 = intent.getStringExtra("temp2")
        val temp3 = intent.getStringExtra("temp3")
        findViewById<TextView>(R.id.quesiton).text = temp1
        findViewById<Button>(R.id.check_ans_btn).setOnClickListener {
            val editText = findViewById(R.id.editTextNumber) as EditText
            if (editText != null) {
                if(editText.length() < 1){
                    return@setOnClickListener editText.setError("Please Enter Your Answer! There currently isn't anything in the box.")
                }

                val que = findViewById<TextView>(R.id.quesiton).text
                val showString = editText.text.toString()
                if(que.toString() == "1+3"){
                    if(showString == "4"){
                        Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "Incorrect, the answer was 4", Toast.LENGTH_SHORT).show()
                    }
                    findViewById<TextView>(R.id.quesiton).text = temp2
                    findViewById<TextView>(R.id.editTextNumber).text = ""
                    Chip!!.setText("2")
                    progressBar!!.progress = 2
                } else if (que.toString() == "5+4"){
                    if(showString == "9"){
                        Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "Incorrect, the answer was 9", Toast.LENGTH_SHORT).show()
                    }
                    findViewById<TextView>(R.id.quesiton).text = temp3
                    findViewById<TextView>(R.id.editTextNumber).text = ""
                    Chip!!.setText("3")
                    progressBar!!.progress = 3
                } else if (que.toString() == "6+3"){
                    if(showString == "9"){
                        Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "Incorrect, the answer was 9", Toast.LENGTH_SHORT).show()
                    }
                    findViewById<TextView>(R.id.quesiton).text = ""
                    findViewById<TextView>(R.id.editTextNumber).text = ""
                    Chip!!.setText("Finished! Well Done!")
                    val i = Intent(this, HomeworkActivity::class.java)
                    MaterialDialog(this).show {
                        title(R.string.app_name)
                        message(text = "Well Done! You just completed the quiz "+quiz_name+"!")
                        icon(R.drawable.math)
                        cancelable(false)
                        cancelOnTouchOutside(false)
                        cornerRadius(32f)
                        positiveButton(text = "Go Back Home") { dialog ->
                            startActivity(i)
                            super.onDestroy();
                        }
                    }
                }


            }
        }
        }


}





