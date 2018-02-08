package nu.annat.db_vs_prefs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database database = new Database(this);
        Map<String, ?> all = database.prefs.getAll();
        for (String s : all.keySet()) {
            Log.d("test", s);
        }

    }
}
