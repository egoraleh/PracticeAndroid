package ru.itis.summerpractice24

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summerpractice24.databinding.FragmentExpandedBinding

class ExpandedFragment() : Fragment(R.layout.fragment_expanded) {
    private var binding: FragmentExpandedBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pref = requireActivity().getSharedPreferences("Default", Context.MODE_PRIVATE)
        val index = pref.getInt("ARG_INDEX", -1)
        val book : Book? = BookRepository.books.find { it.id == index }
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExpandedBinding.bind(view)
        binding?.run {
            tvBook.text = book?.name
            tvAuthor.text = book?.author
            tvStory.text = book?.story
            Glide.with(this.root).load(book?.url).error(R.mipmap.ic_launcher).into(ivImage)
            buttonReturn.setOnClickListener {
                findNavController().navigate(R.id.action_expandedFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}