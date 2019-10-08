package tvsample.com.architecturecomponentwithkotlin.registration

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Registration::class] ,version = 1)
abstract class RegistrationRoomDatabase : RoomDatabase()
{
    //abstarct method of DAO class
    abstract fun RegistrationDAO(): RegistrationDAO

    companion object {
        var instance: RegistrationRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RegistrationRoomDatabase {
            if (instance == null) {
                // initialize instance of database
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegistrationRoomDatabase::class.java,
                    "User_database"
                )
                    .fallbackToDestructiveMigration()
                    //.addCallback(roomDatabase)
                    .build()
            }
            return instance as RegistrationRoomDatabase
        }
    }
}

