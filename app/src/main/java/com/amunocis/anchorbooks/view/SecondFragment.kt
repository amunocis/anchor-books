package com.amunocis.anchorbooks.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.amunocis.anchorbooks.R
import com.amunocis.anchorbooks.databinding.FragmentSecondBinding
import com.amunocis.anchorbooks.viewModel.BookViewModel
import com.bumptech.glide.Glide

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: BookViewModel by activityViewModels()
    private var idBook: Int = -1
    private var phTitle = ""
    private var phId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idBook = it.getInt("id", -1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBookById(idBook).observe(viewLifecycleOwner, Observer {
            it?.let {
                val deliveryCheck: String
                if (it.delivery) {
                    deliveryCheck = "Con Despacho"
                } else {
                    deliveryCheck = "Sin Despacho"
                }

                binding.pagesTextView.text = resources.getString(R.string.pages_ph, it.pages)
                binding.titleDetailTextView.setText(it.title)
                binding.autorDetailTextView.setText(it.author)
                binding.priceDetailTextView.text = resources.getString(R.string.price_ph, it.price)
                binding.deliveryTextView.text = resources.getString(R.string.delivery_ph, deliveryCheck)
                Glide.with(this)
                        .load(it.imageLink)
                        .into(binding.coverDetailImageView)

                phTitle = it.title
                phId = it.id

                binding.buyItButton.setOnClickListener {
                    sendEmail()
                }
            }
        })
    }
    private fun sendEmail() {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, "ventas@anchorBooks.cl")
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta por libro ${phTitle} id ${phId}")
        mIntent.putExtra(Intent.EXTRA_TEXT, "Hola\n" +
                "Vi el libro ${phTitle} de código ${phId} y me gustaría que me contactaran a este correo o al\n" +
                "siguiente número _________\n" +
                "Quedo atento.")

        try {
            startActivity(mIntent)
        }
        catch (e: Exception) {
            Toast.makeText(context, "Debe instalar una aplicación de correo", Toast.LENGTH_LONG).show()
        }
    }

}