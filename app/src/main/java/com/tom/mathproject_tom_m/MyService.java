package com.tom.mathproject_tom_m;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.io.IOException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {//פעולה המפעילה את המוזיקה
        Log.d("testService","start");
        creatMusic();;
        return START_STICKY;
    }

    @Override
    public void onDestroy() {//פעולה שפועלת כאשר המוזיקה מפסיקה לםעול
        Log.d("testService","end");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startForegroundService();
    }
    private void startForegroundService() {

        String channelId;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            channelId = createNotificationChannel();

        } else {

// If earlier version channel ID is not used

// https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)

            channelId = "";

        }
        //NotificationCompat

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channelId);

        Notification notification = notificationBuilder.setOngoing(true).setSmallIcon(R.mipmap.ic_launcher).setPriority(NotificationCompat.PRIORITY_MIN).setCategory(Notification.CATEGORY_SERVICE).build();

        startForeground(101, notification);
    }

    private String createNotificationChannel() {

        String channelId = "my_service";

        String channelName = "My Background Service";

        NotificationChannel chan = new NotificationChannel(channelId,

                channelName, NotificationManager.IMPORTANCE_HIGH);

        chan.setLightColor(Color.BLUE);

        chan.setImportance(NotificationManager.IMPORTANCE_NONE);

        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        NotificationManager service = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        service.createNotificationChannel(chan);

        return channelId;

    }
   public  void creatMusic() {//פעולה היוצרת מוזיקה על מנת שהמערכת תוכל לנגן אותה
       MediaPlayer mp = new MediaPlayer();
       mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
           @Override
           public void onPrepared(MediaPlayer mediaPlayer) {
               if (!mp.isPlaying())
                   mp.start();
           }
       });
       mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
           @Override
           public void onCompletion(MediaPlayer mediaPlayer) {
               MyService.this.stopSelf();
           }
       });
       mp.reset();

       try {

           // AssertionError afd = getResources().openRawResourceFd(R.raw.backgroundmusic);
           AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.backgroundmusic);
           mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());

           afd.close();

           mp.prepareAsync();

       } catch (IOException e) {

           Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
       }
   }
}