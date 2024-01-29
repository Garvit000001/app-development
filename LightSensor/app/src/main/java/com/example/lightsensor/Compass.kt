package com.example.lightsensor

import android.content.ContentValues
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException

class Compass : AppCompatActivity(),SensorEventListener {
    lateinit var degreetxt:TextView
    lateinit var compassing:ImageView
    private var sensor :Sensor? = null
    private var sensorManager: SensorManager?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compass)

        degreetxt=findViewById(R.id.tVdegree)
        compassing=findViewById(R.id.compassimage)

        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)

    }
    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
    override fun onSensorChanged(event: SensorEvent?) {
        try {
            val rotationMatrix = FloatArray(9)
            SensorManager.getRotationMatrixFromVector(
                rotationMatrix,
                event!!.values
            )
            val orientationValues = FloatArray(3)
            SensorManager.getOrientation(rotationMatrix, orientationValues)

            var degree = Math.toDegrees(orientationValues[0].toDouble()).toFloat().toInt()

            if (degree < 0) {
                degree += 360
            }

            degreetxt.text = "Degree: $degree"
            compassing.rotation = (-degree).toFloat()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Leave it empty if you don't need to handle accuracy changes.
    }
}