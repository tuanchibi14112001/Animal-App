package com.example.animalapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.animalapp.databinding.FragmentAnimalDetail2Binding
import com.example.animalapp.model.Animal
import com.example.animalapp.model.AnimalUseCase
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalDetail2.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalDetail2 : Fragment(), TextToSpeech.OnInitListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var tts: TextToSpeech? = null
    private lateinit var binding: FragmentAnimalDetail2Binding
    private lateinit var speakableText: String
    private val args: AnimalDetail2Args by navArgs()
    var isPlaying = false

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
        tts = TextToSpeech(requireContext(), this)
        binding = FragmentAnimalDetail2Binding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animal = AnimalUseCase().findAnimalById(args.animalId)

        binding.txtName.text = animal.name
        binding.imgAnimal.setBackgroundResource(animal.imgDetail)
        binding.txtDes.text = animal.description
        binding.btnPlay.setOnClickListener{
            playAnimalInfo(animal)
        }

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.ENGLISH)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Not supported")
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
    }

    private fun speakOut(text: String) {
        tts?.speak(text.trim(), TextToSpeech.QUEUE_ADD, null, null)
    }

    private fun playAnimalInfo(animal: Animal) {
        if (!isPlaying) {
            Log.d("CHECK", tts.toString())
            Log.d("CHECK", requireContext().toString())
            isPlaying = true
            tts?.speak("Description",TextToSpeech.QUEUE_ADD, null, "" )
            speakOut(animal.description)
            binding.btnPlay.setBackgroundResource(R.drawable.img_stop)
        } else {
            isPlaying = false
            tts?.stop()
            binding.btnPlay.setBackgroundResource(R.drawable.img_play)
        }
    }

    override fun onStop() {
        super.onStop()
        tts?.stop()
        tts?.shutdown()
        isPlaying = false
    }


    override fun onDestroy() {
        super.onDestroy()

        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
        }
    }


}