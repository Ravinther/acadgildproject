package com.example.ravi.broadcast.BroaccastReceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;

import com.example.ravi.broadcast.R;

/**
 * Created by Ravi on 5/17/2016.
 */
public class MyBroadcastmessage extends BroadcastReceiver {
   private  static final int notify_message_id=101;
    @Override
    public void onReceive(Context context, Intent intent) {
        int num=12;
       // Bitmap largeicon=BitmapFactory.decodeResource(context.getResources(), R.drawable.mail);
        NotificationCompat.Builder mbuilder=(Builder) new Builder(
                context.getApplicationContext()).setSmallIcon(R.drawable.mailmsg)
                .setContentTitle("5 new Message")
                .setContentText("m.ravinther@yahoo.com");
        mbuilder.setAutoCancel(true);
        Intent resultintent=new Intent(context,NotifyMessage.class);
        PendingIntent result=PendingIntent.getActivity(context,0,resultintent,0);
        mbuilder.setContentIntent(result);
       // mbuilder.setWhen(System.currentTimeMillis());
       // mbuilder.setNumber(num);
       // mbuilder.setSmallIcon(R.drawable.mailmsg);

        NotificationManager notificationManager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(notify_message_id,mbuilder.build());

    }
}
