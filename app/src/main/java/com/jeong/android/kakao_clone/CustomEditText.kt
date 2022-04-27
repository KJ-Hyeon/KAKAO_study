//package com.jeong.android.kakao_clone
//
//import android.content.Context
//import android.graphics.drawable.Drawable
//import android.text.TextWatcher
//import android.util.AttributeSet
//import android.view.MotionEvent
//import android.view.View
//import androidx.appcompat.widget.AppCompatEditText
//
//class CustomEditText: AppCompatEditText, TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {
//
//        private lateinit var clearDrawable: Drawable
//        private lateinit var onFocusChangelistener: OnFocusChangeListener
//        private lateinit var onTouchlistener: OnTouchListener
//        private var count: Int = 0
//
//        constructor(context: Context?):super(context!!) {
//
//        }
//
//        constructor(context: Context?, attrs: AttributeSet):super(context!!, attrs) {
//
//        }
//
//        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context!!, attrs, defStyleAttr) {
//
//        }
//
//        override fun setOnFocusChangeListener(l: OnFocusChangeListener) {
//                onFocusChangelistener = l
//                count = 1
//        }
//
//        override fun setOnTouchListener(l: OnTouchListener) {
//                onTouchlistener = l
//        }
//
//        override fun onFocusChange(p0: View?, p1: Boolean) {
//                if (p1 && text != null) {
//
//                }
//                if (count == 1) onFocusChangelistener.onFocusChange(p0, p1)
//        }
//
//        override fun onTouch(p0: View?, p1: MotionEvent): Boolean {
//                val x = p1.x.toInt()
//                if (clearDrawable.isVisible && x > width - paddingRight - clearDrawable.intrinsicWidth) {
//                        if(p1.action == MotionEvent.ACTION_UP) {
//                                error = null
//                                text = null
//                        }
//                }
//        }
//
//
//}