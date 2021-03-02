package com.amunocis.anchorbooks.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.amunocis.anchorbooks.databinding.BookItemBinding
import com.amunocis.anchorbooks.model.local.entities.Book
import com.amunocis.anchorbooks.model.local.entities.Detail
import com.amunocis.anchorbooks.model.remote.RetrofitInstance
import com.bumptech.glide.Glide

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookVH>() {
    private var bookList = listOf<Book>()
    private val selectedBook = MutableLiveData<Book>()

    fun update(list: List<Book>) {
        bookList = list
        notifyDataSetChanged()
    }

    inner class BookVH(private val binding: BookItemBinding):
            RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(book: Book) {
            Glide.with(binding.root)
                    .load("${book.imageLink}")
                    .into(binding.frontImageView)
            binding.titleTextView.text = book.title
            binding.authorTextView.text = book.author
            binding.languageTextView.text = book.language
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            selectedBook.value = bookList[adapterPosition]
        }
    }

    fun selectedBook(): LiveData<Book> = selectedBook

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
        return BookVH(BookItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BookVH, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount() = bookList.size
}