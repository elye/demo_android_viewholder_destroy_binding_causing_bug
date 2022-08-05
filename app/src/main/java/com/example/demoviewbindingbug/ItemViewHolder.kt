package com.example.demoviewbindingbug

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoviewbindingbug.databinding.ImageViewBinding
import com.example.demoviewbindingbug.databinding.ItemLayoutBinding

class ItemViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    private val imageComponent = CustomImageComponent().apply {
        with(binding.imageFrame) {
            initView(this)

            // This piece is the cause of bug  where
            // it detached the ViewBinding of the CustomImageComponent
            // even thought the ViewHolder is not releasing the view at all
            // The attached is not helping, as it happens after binding.
            // (check the Log Track)

            addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                    initView(this@with)
                    Log.d("Track","Attached $v")
                }
                override fun onViewDetachedFromWindow(v: View) {
                    destroyView()
                    Log.d("Track","Detached $v")
                }
            })
        }

    }

    fun bind(model: ItemModel) {
        binding.name.text = model.name
        imageComponent.bindView(model.imageId, binding.imageFrame)
    }
}

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
