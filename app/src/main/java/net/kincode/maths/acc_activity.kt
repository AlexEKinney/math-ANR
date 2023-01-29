package net.kincode.maths

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import net.kincode.maths.R
import net.kincode.maths.databinding.ActivityAccBinding

class acc_activity : AppCompatActivity() {

    private lateinit var imageView : ImageView
    private lateinit var auth : FirebaseAuth
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAccBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_acc)
        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")
        val user = FirebaseAuth.getInstance().currentUser
        val photo = user?.photoUrl
        val uid = user?.uid
        imageView = findViewById(R.id.pfp)
        Picasso.get()
            .load(photo)
            .placeholder(R.drawable.math)
            .error(R.drawable.baseline_signal_wifi_connected_no_internet_4_24_777)
            .into(imageView);
        findViewById<TextView>(R.id.acc_text).text = "Name: "+displayName+"\nEmail: "+email+"\nUID: "+uid
        super.onCreate(savedInstanceState)

        binding = ActivityAccBinding.inflate(layoutInflater)
        findViewById<Button>(R.id.home_btn).setOnClickListener {
            val intent : Intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name" , displayName)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        findViewById<Button>(R.id.signout_btn).setOnClickListener {
            val intent : Intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            auth.signOut()
        }



    }

}