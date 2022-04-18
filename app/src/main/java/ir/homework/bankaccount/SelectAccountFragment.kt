package ir.homework.bankaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import ir.homework.bankaccount.databinding.FragmentSelectAccountBinding

class SelectAccountFragment : Fragment() {
    lateinit var binding: FragmentSelectAccountBinding
    val vModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFind.setOnClickListener {
            val cardNum = binding.etCardNumberSelect.text.toString()
            vModel.findAccount(cardNum)
        }

        val foundAccountObserver = Observer<Account?>{  account ->
            account?.let {
                binding.tvBalanceSelect.text = it.balance.toString()
                binding.tvAccountTypeSelect.text = it.type.toString()
            }
        }

        vModel.foundAccountLiveData.observe(requireActivity(), foundAccountObserver)
    }
}