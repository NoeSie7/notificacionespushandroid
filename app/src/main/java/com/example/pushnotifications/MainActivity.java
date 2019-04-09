package com.example.pushnotifications;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String ID_CHANNEL = "001";
    private int notificationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void showNotification(View view) {
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ID_CHANNEL);
//        builder.setSmallIcon(R.drawable.ic_sms_notification);
//        builder.setContentTitle("Notificacion");
//        builder.setContentText("Esto es una notificacion");
////        builder.build();
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(MainActivity.class);
//        //stackBuilder.addNextIntent(intent);
//        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(pendingIntent);
//        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        NM.notify(0, builder.build());
//    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showNotification(View view) {
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ID_CHANNEL);
//        builder.setSmallIcon(R.drawable.ic_sms_notification);
//        builder.setContentTitle("Notificacion");
//        builder.setContentText("Esto es una notificacion");
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        // notificationId is a unique int for each notification that you must define
//        notificationManager.notify(notificationId, builder.build());

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "tutorialspoint_01";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Mis notificaciones", NotificationManager.IMPORTANCE_MAX);
            // Configure the notification channel.
            notificationChannel.setDescription("Sample Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(R.color.colorAccent);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_sms_notification)
                //.setTicker("Tutorialspoint")
                //.setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Notificacion")
                .setContentText("Esto es una notificacion")
                .setContentInfo("Informacion");
        notificationManager.notify(1, notificationBuilder.build());
    }
}
