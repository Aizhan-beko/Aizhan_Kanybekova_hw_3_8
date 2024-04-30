package com.geeks.aizhan_kanybekova_hw_3_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.aizhan_kanybekova_hw_3_8.databinding.ItemCartoonBinding

class CartoonAdapter(private val cartoonList: List<Cartoon>, private val itemClick: CartoonItemClick):
    RecyclerView.Adapter<CartoonAdapter.CartoonViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartoonViewHolder {
        val binding = ItemCartoonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartoonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartoonAdapter.CartoonViewHolder, position: Int) {
        val cartoon = cartoonList[position]
        holder.itemView.setOnClickListener { itemClick.onItemClick(cartoon) }

    }

    override fun getItemCount(): Int = cartoonList.size


    class CartoonViewHolder(private val binding: ItemCartoonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartoon: Cartoon, ) {
            binding.tvName.text = cartoon.name
            binding.tvGenre.text = cartoon.genre
            Glide.with(binding.root)
                .load(cartoon.imageUri)
                .into(binding.imgCartoon)


        }
    }

}