package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    //total time of our music
    private var totalTime:Int=0//as primitive type cannot be lateinit they have to be initialises then and there only
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val btnplay=findViewById<ImageView>(R.id.play)
        val btnpause=findViewById<ImageView>(R.id.pause)
        val btnstop=findViewById<ImageView>(R.id.stop)
        val seekBarMusic=findViewById<SeekBar>(R.id.seekBar)

        mediaPlayer=MediaPlayer.create(this,R.raw.music)
        mediaPlayer.isLooping=true
        mediaPlayer.setVolume(1f,1f)
        totalTime=mediaPlayer.duration



        btnplay.setOnClickListener{
            mediaPlayer.start()
        }
        btnpause.setOnClickListener{
            mediaPlayer.pause()
        }
        btnstop.setOnClickListener{
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        //when user changes the time stamp of music ,reflect that change
        seekBarMusic.max=totalTime

        //agar seekbar m koi badlav aate h toh usko kon sunega ye method sunega
        seekBarMusic.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){//ie kya user seekbar ko ched rha hai agr haan then seek to that progress wali location tak
                    //ie jahan tak ham seek bar le jaye toh usi time par jo gana hai vo bje
                    mediaPlayer.seekTo(progress)

                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
        //change the seekbar positon based on the music
        val handler= Handler()
        handler.postDelayed(object :Runnable{
            //agar iss code ko try aur kuch gadbad hogya toh uski vajah se hamra app crash nhi krna chahiye so we will catch that error
            override fun run() {
                try {
                    //jo seekbar h uski progress should match current position of the music
                    seekBarMusic.progress=mediaPlayer.currentPosition
//ab runnable m vhi upar wala dalna hai so this can be used
                    handler.postDelayed(this,1000)
                    //iska matlab 1sec m change hota rhega position
                }catch (exception : java.lang.Exception){
                    seekBarMusic.progress=0
                }

            }

        },0)







    }
}