package ir.homework.bankaccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextShow.setOnClickListener {
            vModel.nextClicked()
        }

        binding.btnPrevShow.setOnClickListener {
            vModel.prevClicked()
        }

        val accountObserver = Observer<Account> {
            binding.tvCardNumber.text = it.cardNumber
            binding.tvBalance.text =it.balance.toString()
            binding.tvAccountType.text = it.type.toString()
        }

        val nextButtonEnabledObserver = Observer<Boolean>{  enabled ->
            binding.btnNextShow.isEnabled = enabled
        }

        val prevButtonEnabledObserver = Observer<Boolean>{  enabled ->
            binding.btnPrevShow.isEnabled = enabled
        }

        vModel.account.observe(requireActivity(), accountObserver)
        vModel.nextEnabledLiveData.observe(requireActivity() , nextButtonEnabledObserver)
        vModel.prevEnabledLiveData.observe(requireActivity() , prevButtonEnabledObserver)
    }
}