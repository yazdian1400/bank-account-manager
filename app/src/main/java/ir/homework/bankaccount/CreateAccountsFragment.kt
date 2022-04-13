package ir.homework.bankaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.homework.bankaccount.databinding.FragmentCreateAccountsBinding

class CreateAccountsFragment : Fragment() {
    lateinit var binding: FragmentCreateAccountsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateAccountsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}