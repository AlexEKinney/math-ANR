package net.kincode.maths

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import net.kincode.maths.R
import net.kincode.maths.databinding.ActivityAccBinding

class acc_activity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAccBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_acc)
        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")

        findViewById<TextView>(R.id.acc_text).text = "Name: "+displayName+"\nEmail: "+email
        super.onCreate(savedInstanceState)

        binding = ActivityAccBinding.inflate(layoutInflater)





    }

}