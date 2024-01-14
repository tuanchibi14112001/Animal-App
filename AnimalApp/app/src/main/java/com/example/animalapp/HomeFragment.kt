package com.example.animalapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.animalapp.databinding.ActivityMainBinding
import com.example.animalapp.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnInfo.setOnClickListener{
           it.findNavController().navigate(R.id.action_homeFragment_to_animalTypeFragment)
        }

        binding.btnGame.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_blankFragment)
        }

    }

    override fun onStop() {
        super.onStop()
        Log.d("CHECK", "H Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CHECK", "H Destroy")
    }



}