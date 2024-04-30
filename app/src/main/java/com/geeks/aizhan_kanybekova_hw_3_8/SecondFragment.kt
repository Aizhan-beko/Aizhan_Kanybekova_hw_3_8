package com.geeks.aizhan_kanybekova_hw_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.geeks.aizhan_kanybekova_hw_3_8.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cartoon = arguments?.getSerializable("cartoon") as Cartoon
        binding.tvName2.text = cartoon.name
        binding.tvGenre2.text = cartoon.genre
        Glide.with(requireContext())
            .load(cartoon.imageUri)
            .into(binding.imgCartoon2)
    }
}
