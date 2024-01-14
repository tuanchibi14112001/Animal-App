package com.example.animalapp.model

import com.example.animalapp.R

class AnimalUseCase {


    companion object

    fun createPetAnimal(): MutableList<Animal> {
        val myList = mutableListOf<Animal>(
            Animal(
                1,
                "Dog",
                "A dog is a domestic mammal of the family Canidae and the order Carnivora. Its scientific name is Canis lupus familiaris. Dogs are a subspecies of the gray wolf, and they are also related to foxes and jackals. Dogs are one of the two most ubiquitous and most popular domestic animals in the world. (Cats are the other.)",
                0,
                R.drawable.dog_list,
                R.drawable.dog_detail
            ),
            Animal(
                2,
                "Cat",
                "Cat, (Felis catus), domesticated member of the family Felidae, order Carnivora, and the smallest member of that family. Like all felids, domestic cats are characterized by supple low-slung bodies, finely molded heads, long tails that aid in balance, and specialized teeth and claws that adapt them admirably to a life of active hunting. Cats possess other features of their wild relatives in being basically carnivorous, remarkably agile and powerful, and finely coordinated in movement."
                        + "Cat, (Felis catus), domesticated member of the family Felidae, order Carnivora, and the smallest member of that family. Like all felids, domestic cats are characterized by supple low-slung bodies, finely molded heads, long tails that aid in balance, and specialized teeth and claws that adapt them admirably to a life of active hunting. Cats possess other features of their wild relatives in being basically carnivorous, remarkably agile and powerful, and finely coordinated in movement."
                        + "Cat, (Felis catus), domesticated member of the family Felidae, order Carnivora, and the smallest member of that family. Like all felids, domestic cats are characterized by supple low-slung bodies, finely molded heads, long tails that aid in balance, and specialized teeth and claws that adapt them admirably to a life of active hunting. Cats possess other features of their wild relatives in being basically carnivorous, remarkably agile and powerful, and finely coordinated in movement.",

                0,
                R.drawable.cat_list,
                R.drawable.cat_detail
            ),
            Animal(
                3,
                "Hamster",
                "Hamster, (subfamily Cricetinae), any of 18 Eurasian species of rodents possessing internal cheek pouches. The golden hamster (Mesocricetus auratus) of Syria is commonly kept as a pet. Hamsters are stout-bodied, with a tail much shorter than their body length, and have small furry ears, short stocky legs, and wide feet. Their thick long fur ranges from grayish to reddish brown, depending upon the species; underparts range from white to shades of gray and black. The Dzhungarian hamster (Phodopus sungorus) and the striped dwarf hamster (Cricetulus barabensis) have a dark stripe down the middle of the back. Dwarf desert hamsters (genus Phodopus) are the smallest, with a body 5 to 10 cm (about 2 to 4 inches) long. The largest is the common hamster (Cricetus cricetus), measuring up to 34 cm long, not including a short tail of up to 6 cm.",
                0,
                R.drawable.hamster,
                R.drawable.hamster_detail
            ),
            Animal(
                4,
                "Dog",
                "A dog is a domestic mammal of the family Canidae and the order Carnivora. Its scientific name is Canis lupus familiaris. Dogs are a subspecies of the gray wolf, and they are also related to foxes and jackals. Dogs are one of the two most ubiquitous and most popular domestic animals in the world. (Cats are the other.)",
                0,
                R.drawable.dog_list,
                R.drawable.dog_detail
            ),
            Animal(
                5,
                "Dog",
                "A dog is a domestic mammal of the family Canidae and the order Carnivora. Its scientific name is Canis lupus familiaris. Dogs are a subspecies of the gray wolf, and they are also related to foxes and jackals. Dogs are one of the two most ubiquitous and most popular domestic animals in the world. (Cats are the other.)",
                0,
                R.drawable.dog_list,
                R.drawable.dog_detail
            ),
            Animal(
                6,
                "Dog",
                "A dog is a domestic mammal of the family Canidae and the order Carnivora. Its scientific name is Canis lupus familiaris. Dogs are a subspecies of the gray wolf, and they are also related to foxes and jackals. Dogs are one of the two most ubiquitous and most popular domestic animals in the world. (Cats are the other.)",
                0,
                R.drawable.dog_list,
                R.drawable.dog_detail
            ),
            Animal(
                7,
                "Dog",
                "A dog is a domestic mammal of the family Canidae and the order Carnivora. Its scientific name is Canis lupus familiaris. Dogs are a subspecies of the gray wolf, and they are also related to foxes and jackals. Dogs are one of the two most ubiquitous and most popular domestic animals in the world. (Cats are the other.)",
                0,
                R.drawable.dog_list,
                R.drawable.dog_detail
            ),

            )
        return myList
    }

    fun findAnimalById(id: Int): Animal {
        val myList = this.createPetAnimal()
        for (animal in myList) {
            if (animal.id == id)
                return animal
        }
        return myList[0]
    }
}

