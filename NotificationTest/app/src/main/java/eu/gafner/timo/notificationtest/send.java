package eu.gafner.timo.notificationtest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.MainThread;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by bgafnt on 29.06.2016.
 */
public class send {

    public static void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            //startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //finish();
            Log.i("TEST", "Email sent...");
        } catch (android.content.ActivityNotFoundException ex) {
            Log.i("TEST", "No client found");
        }
    }
}
