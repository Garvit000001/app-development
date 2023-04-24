package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path

class PaintView: View {

    var params : ViewGroup.LayoutParams?=null
    //params is basically responsible for height ans width wrt the parent layout



    //we also need somethings to access in mainactivity
    companion object{
        //it will store all the paths that we have created in screen
        var pathList= ArrayList<Path>()
        //we need colorlist as we have multiple colors in this project
        var colorList=ArrayList<Int>()//bcoz colors type will be int
        var currentBrush= Color.BLACK //it stores current brush which is of int type
    }
    constructor(context: Context) : this(context, null){
        init()

    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
    private fun init(){//whenver the construcetor is initialised we have to call this init method
        paintBrush.isAntiAlias=true//setting texture of our stroke
        paintBrush.color= currentBrush
        paintBrush.style= Paint.Style.STROKE
        paintBrush.strokeJoin=Paint.Join.ROUND//strokejoin is the end of any path it makes end round ie smooth
        paintBrush.strokeWidth=8f

        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)


    }

    //now we have to register how user is drawing things on screen
    override fun onTouchEvent(event: MotionEvent?): Boolean {//om touchevent will register that moment when finger touch screen so we get x,y coordinates
        var x=event?.x
        var y=event?.y

        //so now according to action of event we have to do different functions we an do using switch statement( in kotlin when)
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                x?.let { y?.let { it1 -> path.moveTo(it, it1) } }
                return true
            }
            MotionEvent.ACTION_MOVE->{
                x?.let { y?.let { it1 -> path.lineTo(it, it1) } }
                pathList.add(path)
                colorList.add(currentBrush)

            }
            else-> return false

        }
        postInvalidate()
        //it is used to inform the non ui that somechanges have been done to ui
        //it is very to add after this when scope is over
        return false
    }
    //till now using above method we have registered the touch of the user but not made any drawing till now
    //so for it we have onDraw method

    override fun onDraw(canvas: Canvas) {
        //we have arraylist of path so we can draw one by one on screen from pathlist
        for(i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()//similar to postinvalidate
        }

    }

}