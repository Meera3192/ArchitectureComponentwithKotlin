package tvsample.com.architecturecomponentwithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tvsample.com.architecturecomponentwithkotlin.registration.RegistrationActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this@MainActivity,RegistrationActivity::class.java)
        startActivity(intent)
    }
}
