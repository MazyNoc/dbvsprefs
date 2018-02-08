package nu.annat.db_vs_prefs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class PrefsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long start = System.nanoTime();
        SharedPreferences phonenumbers = context.getSharedPreferences("phonenumbers", Context.MODE_PRIVATE);
        String name = phonenumbers.getString(intent.getStringExtra("incoming_number"),null);
        System.out.println("time" + (System.nanoTime() - start)/1_000_000d + ":  "+ name);
    }
}
