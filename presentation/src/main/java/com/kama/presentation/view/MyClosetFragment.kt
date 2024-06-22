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
import com.kama.presentation.databinding.FragmentMyClosetBinding
import com.kama.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * TODO : 내 옷장 만들기 (상의, 하의, 아우터)
 * TODO : 추후에 상의, 하의 아우터 나눌 때 Fragment에서 분리하기
 * TODO : 1. 상의 Fragment / 2. 하의 Fragment / 3. 아우터 Fragment
 * */

@AndroidEntryPoint
class MyClosetFragment : BaseFragment<FragmentMyClosetBinding>(), AlbumAddAdapter.OnItemClickListener {

    private val TAG = "MyClosetFragment::"

    private lateinit var adapter: AlbumAddAdapter
    private val sharedPreferenceFile = "my_closet_shared_prefs"
    private lateinit var mainViewModel: MainViewModel

    override fun getFragmentBinding(): FragmentMyClosetBinding =
        FragmentMyClosetBinding.inflate(layoutInflater)

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
        binding.layoutAppbar.tvTitle.text = getString(R.string.my_closet_fragment)
    }

    private fun init() {
        Timber.i("$TAG::init()")
        swipeRefresh()
        imageLoadInit()
    }

    /**
     * TODO : 이미지 로드 시 현재 없는 이미지나 흰색 이미지로 뜨는 경우 자동 삭제 처리
     * */
    private fun imageLoadInit() {
        binding.rvMyAlbums.layoutManager = GridLayoutManager(requireContext(), 2)
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

    override fun onItemClick(imageUri: Uri, position: Int) {
        if(position == 0) openAlbum()
        else {
            // 이미지 full 화면으로 보기
            val dialog = FullScreenImageDialog(requireContext(), imageUri.toString())
            dialog.show()
        }
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