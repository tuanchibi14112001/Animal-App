package com.example.animalapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animalapp.databinding.ItemBinding
import com.example.animalapp.model.Animal

class ListAnimalAdapter(val itemClickListener: ItemClickListener) : ListAdapter<Animal, ListAnimalViewHolder>(AnimalDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ListAnimalViewHolder(binding, itemClickListener)

    }

    override fun onBindViewHolder(holder: ListAnimalViewHolder, position: Int) {
        return holder.bindAnimal(getItem(position))
    }
    class AnimalDiffUtilCallBack : DiffUtil.ItemCallback<Animal>(){
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.name === newItem.name
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }

    }

}