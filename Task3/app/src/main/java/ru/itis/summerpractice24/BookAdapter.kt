package ru.itis.summerpractice24

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice24.databinding.ItemBookBinding

class BookAdapter(private val list: List<Book>,
                  private val glide: RequestManager,
                  private val onClick: (Int) -> Unit,
                  private val pref: SharedPreferences
    ) : RecyclerView.Adapter<BookHoder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookHoder {
        return BookHoder(
            binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false
            ), glide = glide, onClick = onClick, pref = pref
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BookHoder, position: Int) {
        holder.onBind(list[position])
    }
}