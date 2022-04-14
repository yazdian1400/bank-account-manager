package ir.homework.bankaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ir.homework.bankaccount.databinding.FragmentShowAccountsBinding

class ShowAccountsFragment : Fragment() {
    lateinit var binding: FragmentShowAccountsBinding
    val vModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowAccountsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}