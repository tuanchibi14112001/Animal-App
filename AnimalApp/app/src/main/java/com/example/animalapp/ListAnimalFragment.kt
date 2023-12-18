package com.example.animalapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animalapp.databinding.FragmentAnimalDetail2Binding
import com.example.animalapp.databinding.FragmentListAnimalBinding
import com.example.animalapp.model.Animal
import com.example.animalapp.model.AnimalUseCase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListAnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListAnimalFragment : Fragment(), ItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentListAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListAnimalBinding.inflate(inflater, container, false)
        val animalList = AnimalUseCase().createPetAnimal()
        val animalAdapter = ListAnimalAdapter(this)
        animalAdapter.submitList(animalList)

        binding.mRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animalAdapter
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStop() {
        super.onStop()
        Log.d("CHECK", "LisF Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CHECK", "LisF Destroy")
    }

    override fun animalOnClick(animal: Animal) {
        val action = ListAnimalFragmentDirections.actionListAnimalFragmentToAnimalDetail2(animal.id)
        findNavController().navigate(action)

    }
}