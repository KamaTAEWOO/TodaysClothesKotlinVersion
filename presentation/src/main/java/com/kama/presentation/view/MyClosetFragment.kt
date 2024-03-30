package com.kama.presentation.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.presentation.adapter.MyClosetAlbumAddAdapter
import com.kama.presentation.databinding.FragmentMyClosetBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 내 옷장 만들기 (상의, 하의, 아우터)
 * */

@AndroidEntryPoint
class MyClosetFragment : BaseFragment<FragmentMyClosetBinding>(), MyClosetAlbumAddAdapter.OnItemClickListener  {

    private val TAG = "MyClosetFragment::"

    private lateinit var adapter: MyClosetAlbumAddAdapter

    override fun getFragmentBinding(): FragmentMyClosetBinding =
        FragmentMyClosetBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Timber.i("$TAG::init()")

        binding.rvMyCloset.layoutManager = GridLayoutManager(requireContext(), 3)
        val initDrawable: MutableList<Uri> = mutableListOf()
        initDrawable.add(WeatherUtil.getResourceUri(requireContext(), com.kama.design.R.drawable.ic_buttonplus))
        adapter = MyClosetAlbumAddAdapter(initDrawable) // 리스트에 하나만 추가
        adapter.setOnItemClickListener(this)
        binding.rvMyCloset.adapter = adapter

        binding.addButton.setOnClickListener {
            openAlbum()
        }
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
        openAlbum()
    }

}