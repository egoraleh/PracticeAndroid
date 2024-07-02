package ru.itis.summerpractice24

import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice24.databinding.ItemBookBinding

class BookHoder(private val binding: ItemBookBinding,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
    private val pref: SharedPreferences
) : ViewHolder(binding.root) {

    fun onBind(book: Book) {
        binding.run {
            tvBook.text = book.name
            tvAuthor.text = book.author
            glide.load(book.url).error(R.mipmap.ic_launcher).into(ivImage)

            root.setOnClickListener {
                pref.edit().putInt("ARG_INDEX", book.id).apply()
                onClick.invoke(R.id.action_mainFragment_to_expandedFragment)
            }
        }
    }
}