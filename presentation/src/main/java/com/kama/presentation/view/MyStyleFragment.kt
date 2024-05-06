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
import com.kama.core.util.SharedPreferenceHelper
import com.kama.core.util.WeatherUtil
import com.kama.design.R
import com.kama.presentation.adapter.AlbumAddAdapter
import com.kama.presentation.databinding.FragmentMyStyleBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 나만에 스타일 앨범 만들기 - 캡쳐 사진 모아서 올릴 수 있는 공간
 * */

@AndroidEntryPoint
class MyStyleFragment : BaseFragment<FragmentMyStyleBinding>(), AlbumAddAdapter.OnItemClickListener {

    private val TAG = "MyStyleFragment::"
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: AlbumAddAdapter
    private val sharedPreferenceFile = "my_style_shared_prefs"

    override fun getFragmentBinding(): FragmentMyStyleBinding =
        FragmentMyStyleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initAppBar()
        init()
    }

    private fun initViewModel() {
        Timber.i("$TAG::initViewModel()")
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    private fun initAppBar() {
        Timber.i("$TAG::initAppBar()")
        binding.layoutAppbar.tvTitle.text = getString(R.string.my_style_fragment)
    }

    private fun init() {
        Timber.i("$TAG::init()")
        swipeRefresh()
        imageLoadInit()
    }

    private fun imageLoadInit() {
        binding.rvMyAlbums.layoutManager = GridLayoutManager(requireContext(), 3)
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
        adapter = AlbumAddAdapter(requireContext(), sharedPreferenceFile, initDrawable)
        adapter.setOnItemClickListener(this)
        binding.rvMyAlbums.adapter = adapter
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
    private fun swipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.detach(this).attach(this).commitAllowingStateLoss() // 새로 고침
            Toast.makeText(requireContext(), "스와이프 완료", Toast.LENGTH_SHORT).show()
            binding.swipeRefreshLayout.isRefreshing = false // 새로고침 완료
        }
    }
}