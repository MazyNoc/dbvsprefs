package nu.annat.db_vs_prefs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DBReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long start = System.nanoTime();
        if(App.database==null){
            App.database = new Database(context);
        }
        String name = ReadDatabase.find(App.database.getReadableDatabase(), intent.getStringExtra("incoming_number"));
        System.out.println("time" + (System.nanoTime() - start)/1_000_000d + ":  "+ name);
    }
}
