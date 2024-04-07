package com.kama.presentation.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.kama.core.base.BaseFragment
import com.kama.core.util.SharedPreferenceHelper
import com.kama.core.util.WeatherUtil
import com.kama.presentation.adapter.MyClosetAlbumAddAdapter
import com.kama.presentation.databinding.FragmentMyClosetBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 내 옷장 만들기 (상의, 하의, 아우터)
 * */

@AndroidEntryPoint
class MyClosetFragment : BaseFragment<FragmentMyClosetBinding>(), MyClosetAlbumAddAdapter.OnItemClickListener {

    private val TAG = "MyClosetFragment::"

    private lateinit var adapter: MyClosetAlbumAddAdapter
    private val sharedPreferenceFile = "my_closet_shared_prefs"

    override fun getFragmentBinding(): FragmentMyClosetBinding =
        FragmentMyClosetBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")
        imageLoadInit()
    }

    /**
     * TODO : 이미지 로드 시 현재 없는 이미지나 흰색 이미지로 뜨는 경우 자동 삭제 처리
     * */
    private fun imageLoadInit() {
        binding.rvMyCloset.layoutManager = GridLayoutManager(requireContext(), 3)
        val initDrawable: MutableList<Uri> = mutableListOf()
        initDrawable.add(WeatherUtil.getResourceUri(requireContext(), com.kama.design.R.drawable.ic_buttonplus))
        // 데이터 있을 시 데이터 로드
        val sharedPreferenceHelper = SharedPreferenceHelper(requireContext(), sharedPreferenceFile)
        sharedPreferenceHelper.getImageList(sharedPreferenceFile).let {
            initDrawable.addAll(it)
        }
        // 로드 후 삭제된 데이터는 리스트에도 삭제하기
        val iterator = initDrawable.iterator()
        while (iterator.hasNext()) {
            val uri = iterator.next()
            if (!sharedPreferenceHelper.isImageLoadable(uri)) {
                iterator.remove()
            }
        }
        adapter = MyClosetAlbumAddAdapter(requireContext(), sharedPreferenceFile, initDrawable)
        adapter.setOnItemClickListener(this)
        binding.rvMyCloset.adapter = adapter
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageUri = result.data?.data ?: return@registerForActivityResult
            adapter.addItem(imageUri)
        }
    }

    private fun openAlbum() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        pickImage.launch(intent)
    }

    override fun onItemClick(position: Int) {
        if(position == 0) openAlbum()
    }

    // 자동 화면 리프레쉬
    private fun refreshFragment() {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.detach(this).attach(this).commit()
    }
}