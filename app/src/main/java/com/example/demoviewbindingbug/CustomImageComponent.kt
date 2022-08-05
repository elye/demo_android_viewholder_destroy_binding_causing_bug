package com.example.demoviewbindingbug

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demoviewbindingbug.databinding.ImageViewBinding

class CustomImageComponent {
    private var viewBinding: ImageViewBinding? = null

    fun initView(container: ViewGroup) {
        viewBinding = ImageViewBinding.inflate(
            LayoutInflater.from(container.context), container, true
        )
    }

    fun bindView(imageId: Int, container: ViewGroup? = null) {
        container?.let {
            Log.d("Track","Binding $it with $viewBinding")
        }
        viewBinding?.image?.setImageResource(imageId)
    }

    fun destroyView() {
        viewBinding = null
    }
}
