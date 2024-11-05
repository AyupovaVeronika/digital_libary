package com.example.digitallibrary.offline

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.digitallibrary.R
import com.example.digitallibrary.databinding.FragmentMainMenuOfflineBinding


class MainMenuOfflineFragment : Fragment() {
    private lateinit var binding: FragmentMainMenuOfflineBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
// Создание экземпляра класса Fragment1Binding и связывание его с разметкой фрагмента
        binding = FragmentMainMenuOfflineBinding.inflate(inflater, container, false)
// Возвращение корневого View разметки фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentMainMenuOfflineToFragmentManual.setOnClickListener {
            Log.d("RRR","234")
// Навигация к другому фрагменту с помощью NavController и указанием ID действия
            findNavController().navigate(R.id.action_mainMenuOfflineFragment_to_manualFragment)
        }
    }


}