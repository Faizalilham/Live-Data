package com.example.livedata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livedata.databinding.ListItemBinding
import com.example.livedata.model.Product

class ProductAdapter(var data : MutableList<Product>,val listener : Clicked):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(x : Product){
            binding.apply {
                product = x
                cardProduct.setOnClickListener {
                    listener.onClicked(x)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun setDatas(y : MutableList<Product>){
        this.data = y
    }

    interface Clicked{
        fun onClicked(product: Product)
    }


}