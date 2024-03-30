package com.kama.presentation.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.kama.core.base.BaseFragment
import com.kama.presentation.R
import com.kama.presentation.databinding.FragmentMyClosetBinding
import com.kama.presentation.databinding.FragmentRecommendClothesBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 내 옷장 만들기 (상의, 하의, 아우터)
 * */

@AndroidEntryPoint
class MyClosetFragment : BaseFragment<FragmentMyClosetBinding>() {

    private val TAG = "MyClosetFragment::"

    override fun getFragmentBinding(): FragmentMyClosetBinding =
        FragmentMyClosetBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")

        binding.addButton.setOnClickListener {
            openAlbum()
        }
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageUri = result.data?.data ?: return@registerForActivityResult
            binding.addButton.setImageURI(imageUri)

            // 이미지뷰의 스케일 타입 설정
            binding.addButton.scaleType = ImageView.ScaleType.CENTER_CROP
            // 이미지뷰의 배경색 설정 화이트
            binding.addButton.setBackgroundColor(resources.getColor(com.kama.design.R.color.white, null))
        }
    }

    private fun openAlbum() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        pickImage.launch(intent)
    }
}