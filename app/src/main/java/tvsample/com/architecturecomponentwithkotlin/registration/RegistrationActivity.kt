package tvsample.com.architecturecomponentwithkotlin.registration

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.registration.*
import tvsample.com.architecturecomponentwithkotlin.R

class RegistrationActivity : AppCompatActivity() {
    private lateinit var registrationViewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        registrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel::class.java)

        btnRegistration.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val registartion = Registration(
                    edtFirstName.text.toString(),
                    edtLastName.text.toString(),
                    edtAddress.text.toString(),
                    edtEmailId.text.toString(),
                    edtUserName.text.toString(),
                    edtPassWord.text.toString(),
                    edtCurrentLocation.text.toString()
                )

                registrationViewModel.insertRegistrationData(registartion)

                registrationViewModel.getAllData()
                    .observe(this@RegistrationActivity, object : Observer<List<Registration>> {
                        override fun onChanged(t: List<Registration>?) {
                            if (t != null) {
                                Toast.makeText(this@RegistrationActivity, t[0].fristName.toString(), Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    })
            }
        })
    }
}