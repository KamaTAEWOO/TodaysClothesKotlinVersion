package com.kama.presentation.view

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kama.presentation.R

class FullScreenImageDialog(context: Context, private val imageUrl: String) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        setContentView(R.layout.dialog_full_screen_image)

        val imageView = findViewById<ImageView>(R.id.iv_full_screen_image)
        Glide.with(context)
            .load(imageUrl)
            .into(imageView)

        // 전체 화면으로 설정
        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )

        imageView.setOnClickListener {
            dismiss() // 이미지를 클릭하면 다이얼로그를 닫습니다.
        }
    }
}
