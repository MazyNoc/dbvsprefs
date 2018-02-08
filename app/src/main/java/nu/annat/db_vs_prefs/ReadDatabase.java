package nu.annat.db_vs_prefs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReadDatabase extends SQLiteOpenHelper {


    public ReadDatabase(Context context) {
        super(context, "phonenumbers", null, 1);
    }

    public static String find(SQLiteDatabase db, String number) {
        Cursor rawQuery = db.rawQuery("select * from numbers where number = ?", new String[]{number});
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getString(1);
            } else {
                return null;
            }
        } finally {
            rawQuery.close();
        }

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
