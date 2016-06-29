package ch.berufsbildungscenter.timolucajoel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EmailActivity extends AppCompatActivity {

    EditText title;
    EditText email;
    EditText betreff;
    EditText text;

    String Title;
    String Email;
    String Betreff;
    String Text;

    Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        Intent intent = getIntent();

        title = (EditText) findViewById(R.id.editText);
        email = (EditText) findViewById(R.id.editText2);
        betreff = (EditText) findViewById(R.id.editText3);
        text = (EditText) findViewById(R.id.editText4);


        sendButton = (Button) findViewById(R.id.button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Title = title.getText().toString();
                Email = email.getText().toString();
                Betreff = betreff.getText().toString();
                Text = text.getText().toString();

                Log.w("title", Title);
                Log.w("mail", Email);
                Log.w("betreff", Betreff);
                Log.w("text", Text);

                try {
                    FileOutputStream fou = openFileOutput("text.txt", MODE_WORLD_WRITEABLE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // Perform action on click
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                EmailActivity.this.startActivity(intent);
                //startActivity(new Intent(MainActivity.this, EmailActivity.class));
            }
        });

    }

}
