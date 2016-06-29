package eu.gafner.timo.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    public NotificationReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationID = intent.getIntExtra("notificationId", 0);

        //TODO
        

        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
