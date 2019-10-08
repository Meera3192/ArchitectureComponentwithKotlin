package tvsample.com.architecturecomponentwithkotlin.registration

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RegistrationDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(registration :Registration)

    @Query("SELECT * from registration")
    fun getAllData() : LiveData<List<Registration>>

}

