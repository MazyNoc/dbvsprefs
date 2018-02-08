package nu.annat.db_vs_prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

public class Database extends SQLiteOpenHelper {

    public final SharedPreferences prefs;

    public Database(Context context) {
        super(context, "phonenumbers", null, 1);
        prefs = context.getSharedPreferences("phonenumbers", Context.MODE_PRIVATE);
        getWritableDatabase();
//        File databasePath = context.getDatabasePath("phonenumbers");
//        databasePath.delete();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table numbers (number VARCHAR(20) primary key, name VARCHAR(255))");
        int i = 0;
        Random random = new Random();

        SharedPreferences.Editor edit = prefs.edit();
        edit.clear();

        while (i < 10000) {
            try {
                Long i1 = random.nextInt(10000000) + 70000000000L;
                String name = "test_" + i1.toString();
                db.execSQL("insert into numbers values (\"" + i1.toString() + "\", \"" + name + "\");");
                edit.putString(i1.toString(), name);
                i++;
            } catch (Throwable t) {

            }
        }
        edit.apply();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
