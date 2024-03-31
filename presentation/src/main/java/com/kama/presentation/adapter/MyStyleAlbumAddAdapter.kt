package com.kama.presentation.adapter

import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kama.presentation.R
import timber.log.Timber

class MyStyleAlbumAddAdapter(private val albumImageList: MutableList<Uri>) :
    RecyclerView.Adapter<MyStyleAlbumAddAdapter.ImageButtonViewHolder>() {

    class ImageButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageButton: ImageButton = itemView.findViewById(R.id.ib_image_add)
    }

    private val TAG = "ImageButtonAdapter::"
    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageButtonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_button, parent, false)
        return ImageButtonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageButtonViewHolder, position: Int) {
        val currentItem = albumImageList[position]

        holder.imageButton.setOnClickListener {
            Timber.d("$TAG::onBindViewHolder() position: $position")
            listener?.onItemClick(position)
        }

        holder.imageButton.setImageURI(currentItem)

        // 이미지뷰의 스케일 타입 설정
        holder.imageButton.scaleType = ImageView.ScaleType.CENTER_CROP
        // 이미지뷰의 배경색 설정 화이트
        holder.imageButton.setBackgroundColor(Color.WHITE)
    }

    override fun getItemCount() = albumImageList.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun addItem(imageResource: Uri) {
        albumImageList.add(0, imageResource) // 맨 앞에 아이템 추가
        notifyItemInserted(0)
    }
}
