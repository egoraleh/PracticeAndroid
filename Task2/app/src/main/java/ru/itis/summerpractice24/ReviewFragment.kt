package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.databinding.FragmentReviewBinding

class ReviewFragment: Fragment(R.layout.fragment_review) {
    private var binding: FragmentReviewBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReviewBinding.bind(view)

        binding?.run{
            button.setOnClickListener {
                val text = editText.text
                if (text.isNotEmpty()) {
                    val bundle = Bundle()
                    bundle.putString("ARG_TEXT", text.toString())
                    findNavController().navigate(R.id.action_reviewFragment_to_writedFragment,
                        args = bundle)
                } else {
                    binding?.mainContainer?.let { it1 -> Snackbar.make(it1, "Напишите отзыв!", Snackbar.LENGTH_LONG).show() }
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}