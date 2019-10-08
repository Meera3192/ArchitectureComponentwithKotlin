package tvsample.com.architecturecomponentwithkotlin.registration

import androidx.room.Entity
import androidx.room.PrimaryKey

/*@Entity(tableName = "registration",indices = {@Index(value = {"userId"},unique = true)})*/
@Entity(tableName = "registration")
data class Registration(
    var fristName:String?,
    var lastName: String?,
    var address: String?,
    var emailId: String?,
    var userName: String?,
    var password: String?,
    var currentLocation: String?
)
{
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}




