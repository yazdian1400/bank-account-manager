package ir.homework.bankaccount

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import ir.homework.bankaccount.databinding.FragmentCreateAccountsBinding

class CreateAccountsFragment : Fragment() {
    lateinit var binding: FragmentCreateAccountsBinding
    val vModel: MainViewModel by activityViewModels()
    lateinit var sharedPreferences: SharedPreferences

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextCreate.setOnClickListener{
            val num = sharedPreferences.getString("numAccounts", "0")?.toInt()
            if (num == 0) {
                Toast.makeText(requireContext(), "please enter number of accounts in profile.",Toast.LENGTH_SHORT ).show()
                }
            else if (validateInputs()) {
                val cardNum = binding.etCardNumberCreate.text.toString()
                val balance = binding.etBalanceCreate.text.toString().toInt()
                val hasFinished = vModel.nextInCreate(num!!, cardNum, balance)

                if (hasFinished)
                    binding.btnNextCreate.isEnabled = false
            }
        }
    }

    private fun validateInputs(): Boolean {
        if (binding.etCardNumberCreate.text.isNullOrBlank()) {
            binding.etCardNumberCreate.error = "Please enter your card number."
            return false
        } else if (binding.etBalanceCreate.text.isNullOrBlank()) {
            binding.etBalanceCreate.error = "Please enter your balance."
            return false
        }
        return true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}