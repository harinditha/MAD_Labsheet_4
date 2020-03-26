package com.example.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.androidnotifications.App.CHANNEL_1_ID;
//import static com.example.androidnotifications.App.CHANNEL_2_ID;

public class signup extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

    }

    public void sendOnChannel1(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent resultintent = new Intent(this, registerForm.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 1, resultintent, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText("Hello" + "\t" +message + "\tWelcome to the MAD team")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true)
                .build();
//        editTextMessage.setText("Hello" + "" +message + "Welcome to the MAD team");

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


        notificationManager.notify(1, notification);

    }

//    public void sendOnChannel2(View v) {
//        String title = editTextTitle.getText().toString();
//        String message = editTextMessage.getText().toString();
//
//        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
//                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setPriority(NotificationCompat.PRIORITY_LOW)
//                .build();
//
//        notificationManager.notify(2, notification);
//    }

}
