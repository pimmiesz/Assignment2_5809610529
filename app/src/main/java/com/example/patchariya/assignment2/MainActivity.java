package com.example.patchariya.assignment2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
//    Context context;
    ImageView img;

    static final int POLL_INTERVAL = 3000;
    SensorManager sensorManager;
    Sensor accelerometerSensor;
    Handler hdr = new Handler();

    private Runnable pollTask = new Runnable() {
        @Override
        public void run() {
            hdr.postDelayed(pollTask, POLL_INTERVAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        context = this;

        img = (ImageView)findViewById(R.id.imageView);
        img.setImageResource(R.drawable.cc);

    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
        hdr.postDelayed(pollTask, POLL_INTERVAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int type = event.sensor.getType();
        Stick stick = new Stick();

        if(type == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];


            if(x > 20 || y > 20 || z > 20){
                Random rand = new Random();
                int fate = rand.nextInt(4);
                int index = rand.nextInt(4);

                String foretell;
                if(fate == 0){
                    foretell=stick.getStick(index,fate);

                }
                else if(fate == 1){
                    foretell=stick.getStick(index,fate);
                }
                else{
                    foretell=stick.getStick(index,fate);
                }

                TextView text=(TextView)findViewById(R.id.textView);
                text.setText(foretell);

            }
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
