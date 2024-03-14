import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(
            "create table tarifarios (" +
                    "nombreTarifa text PRIMARY KEY," +
                    "precioTarifa real," +
                    "descripcionTarifa text," +
                    "restriccionTarifa text)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}