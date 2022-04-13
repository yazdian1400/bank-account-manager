package ir.homework.bankaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.homework.bankaccount.databinding.FragmentShowProfileBinding

class ShowProfileFragment : Fragment() {
    lateinit var binding: FragmentShowProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}