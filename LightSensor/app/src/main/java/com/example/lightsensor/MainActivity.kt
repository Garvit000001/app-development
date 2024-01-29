package com.example.lightsensor

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity : AppCompatActivity() , SensorEventListener{
    private var cameraManager: CameraManager? = null
    private var getCameraID: String? = null
    private var sensor :Sensor? = null
    private var sensorManager: SensorManager?= null
    lateinit var image:ImageView
    lateinit var background:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCompass=findViewById<Button>(R.id.btncompass)
        btnCompass.setOnClickListener {
            //open a new activity
            val intent= Intent(applicationContext,Compass::class.java)
            toggleFlashlight(false)
            startActivity(intent)

        }
        val btnSteps=findViewById<Button>(R.id.btnsteps)
        btnSteps.setOnClickListener {
            //open a new activity
            val intent= Intent(applicationContext,Stepscounter::class.java)
            toggleFlashlight(false)
            startActivity(intent)

        }
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        // Exception is handled, because to check whether
        // the camera resource is being used by another
        // service or not.

        // Exception is handled, because to check whether
        // the camera resource is being used by another
        // service or not.
        try {
            // O means back camera unit,
            // 1 means front camera unit
            getCameraID = cameraManager!!.getCameraIdList()[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        image=findViewById(R.id.flashlight)
        background=findViewById(R.id.backgroundMain)
        image.visibility=View.INVISIBLE

        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor= sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)




    }
    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onSensorChanged(event: SensorEvent?) {

        try{
            if (event != null) {
                Log.d(TAG,"on sensor Changed "+ event.values[0])
            }
            if(event!!.values[0]<30){//light is dim
                // true sets the torch in ON mode
                getCameraID?.let { cameraManager?.setTorchMode(it, true) };

                // Inform the user about the flashlight
                // status using Toast message
                Toast.makeText(this, "Flashlight is turned ON", Toast.LENGTH_SHORT).show();
                image.visibility= View.VISIBLE
//                background.setBackgroundColor(R.color.yellow)

            }else{//if light intensity is high
                // true sets the torch in OFF mode
                getCameraID?.let { cameraManager?.setTorchMode(it, false) };

                // Inform the user about the flashlight
                // status using Toast message
                Toast.makeText(this, "Flashlight is turned OFF", Toast.LENGTH_SHORT).show();
                image.visibility=View.INVISIBLE

            }
        }catch(e: IOException){
            Log.d( TAG, "onSensorChanged: ${e.message}" )
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
    private fun toggleFlashlight(enable: Boolean) {
        try {
            if (getCameraID != null && cameraManager!!.getCameraCharacteristics(getCameraID!!)
                    .get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
            ) {
                cameraManager!!.setTorchMode(getCameraID!!, enable)
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    // when you click on button and torch open and
    // you do not close the torch again this code
    // will off the torch automatically
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun finish() {
        super.finish()
        try {
            // true sets the torch in OFF mode
            cameraManager!!.setTorchMode(getCameraID!!, false)

            // Inform the user about the flashlight
            // status using Toast message
            Toast.makeText(this, "Flashlight is turned OFF", Toast.LENGTH_SHORT).show()
        } catch (e: CameraAccessException) {
            // prints stack trace on standard error
            // output error stream
            e.printStackTrace()
        }
    }
}