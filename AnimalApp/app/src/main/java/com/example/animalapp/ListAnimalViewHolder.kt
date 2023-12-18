package com.example.animalapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.animalapp.databinding.ItemBinding
import com.example.animalapp.model.Animal

class ListAnimalViewHolder(private val itemBinding: ItemBinding, val itemClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bindAnimal(animal: Animal) {
        itemBinding.txtAnimalItem.text = animal.name
        itemBinding.txtAnimalItem.setBackgroundResource(animal.imgRs)
        itemBinding.mCardView.setOnClickListener{
            itemClickListener.animalOnClick(animal)
        }
    }

}