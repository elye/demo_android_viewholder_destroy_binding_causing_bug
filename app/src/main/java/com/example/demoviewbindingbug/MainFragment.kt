package com.example.demoviewbindingbug

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoviewbindingbug.databinding.FragmentMainBinding
import java.lang.IllegalStateException

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val adapter = ItemsAdaptor()

    private val imageComp1 = CustomImageComponent()
    private val imageComp2 = CustomImageComponent()
    private val imageComp3 = CustomImageComponent()
    private val imageComp4 = CustomImageComponent()
    private val imageComp5 = CustomImageComponent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding?.root ?: throw IllegalStateException("Binding is Null!")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {

            imageComp1.initView(imageFrame1)
            imageComp1.bindView(R.drawable.penguin)
            imageComp2.initView(imageFrame2)
            imageComp2.bindView(R.drawable.rhinoceros)
            imageComp3.initView(imageFrame3)
            imageComp3.bindView(R.drawable.hippopotamus)
            imageComp4.initView(imageFrame4)
            imageComp4.bindView(R.drawable.eagle)
            imageComp5.initView(imageFrame5)
            imageComp5.bindView(R.drawable.crocodile)

            recyclerView.apply {
                adapter = this@MainFragment.adapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        imageComp1.destroyView()
        imageComp2.destroyView()
        imageComp3.destroyView()
        imageComp4.destroyView()
        imageComp5.destroyView()
    }
}
