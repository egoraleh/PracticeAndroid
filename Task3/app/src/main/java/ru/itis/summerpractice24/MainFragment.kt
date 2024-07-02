package ru.itis.summerpractice24

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    private var adapter: BookAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        val pref = requireActivity().getSharedPreferences("Default", Context.MODE_PRIVATE)
        binding?.run {
            adapter = BookAdapter(
                list = BookRepository.books,
                glide = Glide.with(this@MainFragment),
                onClick = {
                    findNavController().navigate(it, null)
                },
                pref = pref
            )

            rvMain.adapter = adapter
            rvMain.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}