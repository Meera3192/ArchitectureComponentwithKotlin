package tvsample.com.architecturecomponentwithkotlin.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
     var mList: LiveData<List<Registration>>
     var registrationRepository:RegistrationRepository

    // get all data
    init {
        val registrationDao = RegistrationRoomDatabase.getInstance(application).RegistrationDAO()
        registrationRepository = RegistrationRepository(registrationDao)
        mList = registrationRepository.AllData
    }

    fun getAllData(): LiveData<List<Registration>> {
        return mList
    }

    // insert data
    fun insertRegistrationData(registartion: Registration) {
        registrationRepository.insert(registartion)
    }

}

