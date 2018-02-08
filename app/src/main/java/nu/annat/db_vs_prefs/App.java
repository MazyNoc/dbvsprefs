package nu.annat.db_vs_prefs;

import android.app.Application;
import android.util.Log;

public class App extends Application {

    public static Database database;

    @Override
    public void onCreate() {
        Log.d("App", "create");
        super.onCreate();
        database = new Database(this);
    }

}
