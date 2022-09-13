package com.jogom.myappsensorproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Sensor sensor;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define la activacion y uso de un snsor a futuro
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //define el tipo de sensor que se va a utilizar
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        accionDelSensorProximidad();
        iniciarSensor();
    }

    private void accionDelSensorProximidad(){
        if(sensor != null){
            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    if(sensorEvent.values[0] < sensor.getMaximumRange()){
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                    }else{
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
        }
        else{
            Toast.makeText(this, "No cunetas con el sensor", Toast.LENGTH_SHORT).show();
        }
    }

    //metdos para iniciar y detener la accion y escucha del sensor
    private void iniciarSensor(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void detenerSensor(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    //metodos que se encargaran del comportamiento  de la actividad para el sensor
    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}