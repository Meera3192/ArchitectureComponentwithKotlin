package tvsample.com.architecturecomponentwithkotlin.registration

import android.os.AsyncTask
import androidx.lifecycle.LiveData

class RegistrationRepository(registrationDao: RegistrationDAO) {
    var registrationDAO: RegistrationDAO

    init {
        this.registrationDAO = registrationDao
    }

    var AllData: LiveData<List<Registration>> = registrationDAO!!.getAllData()


    fun insert(registartion: Registration) {
        InsertData(registrationDAO).execute(registartion)
    }

    class InsertData(registrationDAO: RegistrationDAO?) : AsyncTask<Registration, Void, Void>() {
        var registrationDAO: RegistrationDAO?

        init {
            this.registrationDAO = registrationDAO
        }


        override fun doInBackground(vararg registration: Registration?): Void? {
            registrationDAO?.insert(registration[0]!!)
            return null
        }
    }

}