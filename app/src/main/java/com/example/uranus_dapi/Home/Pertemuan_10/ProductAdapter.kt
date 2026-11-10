package com.example.uranus_dapi.Home.pertemuan_10

import android.util.Log // <-- Import Log di sini
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uranus_dapi.databinding.ItemProductBinding

class ProductAdapter(
    private val productList: List<ProductModel>,
    private val onItemClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        with(holder.binding) {
            tvProductName.text = item.name
            tvProductPrice.text = item.price

            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgProduct)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
        // Perbaikan format panggilan Log.e
        Log.e("RV-TEST", item.name)
    }

    override fun getItemCount(): Int = productList.size
}