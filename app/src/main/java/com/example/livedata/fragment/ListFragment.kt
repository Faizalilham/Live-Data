package com.example.livedata.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedata.R
import com.example.livedata.adapter.ProductAdapter
import com.example.livedata.databinding.FragmentListBinding
import com.example.livedata.model.Product
import com.example.livedata.viewmodel.ProductLiveData


class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productLiveData: ProductLiveData
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        productLiveData = ViewModelProvider(requireActivity())[ProductLiveData::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
        productLiveData.getData()
        productLiveData.userData.observe(requireActivity()){
            productAdapter.setDatas(it)
        }
    }


    private fun setRecycler(){
        productAdapter = ProductAdapter(mutableListOf(),object : ProductAdapter.Clicked{
            override fun onClicked(product: Product) {
                val datas = ListFragmentDirections.actionListFragment2ToDetailFragment2(product)
                findNavController().navigate(datas)
            }

        })
        binding.productRecycler.apply{
            adapter = productAdapter
            layoutManager = GridLayoutManager(requireActivity(),2)
        }
    }


}