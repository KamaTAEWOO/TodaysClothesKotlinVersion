package com.kama.presentation.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kama.core.base.BaseFragment
import com.kama.core.util.WeatherUtil
import com.kama.presentation.adapter.MyClosetAlbumAddAdapter
import com.kama.presentation.adapter.MyStyleAlbumAddAdapter
import com.kama.presentation.databinding.FragmentMyStyleBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 나만에 스타일 앨범 만들기 - 캡쳐 사진 모아서 올릴 수 있는 공간
 * */

@AndroidEntryPoint
class MyStyleFragment : BaseFragment<FragmentMyStyleBinding>(), MyStyleAlbumAddAdapter.OnItemClickListener {

    private val TAG = "MyStyleFragment::"
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MyStyleAlbumAddAdapter

    override fun getFragmentBinding(): FragmentMyStyleBinding =
        FragmentMyStyleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        init()
    }

    private fun initViewModel() {
        Timber.i("$TAG::initViewModel()")
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    private fun init() {
        Timber.i("$TAG::init()")

        binding.rvMyCloset.layoutManager = GridLayoutManager(requireContext(), 3)
        val initDrawable: MutableList<Uri> = mutableListOf()
        initDrawable.add(WeatherUtil.getResourceUri(requireContext(), com.kama.design.R.drawable.ic_buttonplus))
        adapter = MyStyleAlbumAddAdapter(initDrawable) // 리스트에 하나만 추가
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
        openAlbum()
    }
}