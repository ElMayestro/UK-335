package eu.gafner.timo.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View view) {
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        Intent sendintent = new Intent(this, SendActivity.class);

        int nid = (int) System.currentTimeMillis();
        PendingIntent pIntent = PendingIntent.getActivity(this, nid, intent, 0);
        PendingIntent sendIntent = PendingIntent.getActivity(this, nid, sendintent, 0);
        //SET LONG NOTIFICATION TEXT
        String longText = "Sind sie auf dem weg oder nicht? \nWenn Sie zu spät sind, können Sie direkt eine Mail senden...";

        //build notification
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Alarm ausgelöst")
                .setContentText("Sind sie schon auf dem Weg?")
                .setSmallIcon(R.drawable.icon)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setStyle(new Notification.BigTextStyle().bigText(longText))
                .addAction(R.drawable.send, "Send E-Mail", sendIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //hide Notification after selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        //notify
        notificationManager.notify(nid, noti);
    }
}
