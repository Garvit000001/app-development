package com.example.lightsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math.abs
import java.lang.Math.sqrt
import kotlin.math.sqrt

class Stepscounter : AppCompatActivity(), SensorEventListener {
    private lateinit var stepstxt: TextView
    private lateinit var stepsing: ImageView
    private var accelerometer: Sensor? = null
    private var gyroscope: Sensor? = null
    private var sensorManager: SensorManager? = null

    private val ACCELEROMETER_THRESHOLD = 1.2f
    private val GYROSCOPE_THRESHOLD = 0.3f

    private var previousAccelValues = FloatArray(3)
    private var previousGyroValues = FloatArray(3)

    private var stepCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stepscounter)

        stepsing = findViewById(R.id.stepsimg)
        stepstxt = findViewById(R.id.tvsteps)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroscope = sensorManager!!.getDefaultSensor(Sensor.TYPE_GYROSCOPE)


    }

    override fun onResume() {
        super.onResume()
        if (accelerometer != null) {
            sensorManager?.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        }
        if (gyroscope != null) {
            sensorManager?.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            when (event.sensor.type) {
                Sensor.TYPE_ACCELEROMETER -> processAccelerometerData(event.values)
                Sensor.TYPE_GYROSCOPE -> processGyroscopeData(event.values)
            }
        }
    }

    private fun processAccelerometerData(values: FloatArray) {
        val magnitude = sqrt(values[0] * values[0] + values[1] * values[1] + values[2] * values[2])

        if (isStepDetected(magnitude - SensorManager.GRAVITY_EARTH, ACCELEROMETER_THRESHOLD)) {
            countStep()
        }
    }

    private fun processGyroscopeData(values: FloatArray) {
        if (isStepDetected(values[2], GYROSCOPE_THRESHOLD)) {
            countStep()
        }
    }

    private fun isStepDetected(value: Float, threshold: Float): Boolean {
        val delta = abs(value - previousAccelValues[0])
        previousAccelValues[0] = value
        return delta > threshold
    }

    private fun countStep() {
        stepCount++
        stepstxt.text = "Steps: $stepCount"
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Handle accuracy changes if needed.
    }
}