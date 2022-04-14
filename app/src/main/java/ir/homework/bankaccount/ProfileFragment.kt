package ir.homework.bankaccount

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ir.homework.bankaccount.databinding.FragmentProfileBinding
import ir.homework.bankaccount.databinding.FragmentShowProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    val vModel: MainViewModel by activityViewModels()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitProfile.setOnClickListener{
            if (validateProfile())  {
                saveProfileInSharePref()
            }
        }
    }

    private fun saveProfileInSharePref() {
        val editor = sharedPreferences.edit()
        editor.putString("firstName", binding.etFirstName.text.toString())
        editor.putString("lastName", binding.etLastName.text.toString())
        editor.putString("fatherName", binding.etFatherName.text.toString())
        editor.putString("postalCode", binding.etPostalCode.text.toString())
        editor.putString("phoneNumber", binding.etPhoneNumber.text.toString())
        editor.putString("numAccounts", binding.etNumberOfAccounts.text.toString())
        editor.apply()
    }

    private fun validateProfile(): Boolean {
        if (binding.etFirstName.text.isNullOrBlank()) {
            binding.etFirstName.error = "Please enter your first name."
            return false
        } else if (binding.etLastName.text.isNullOrBlank()) {
            binding.etLastName.error = "Please enter your last name."
            return false
        } else if (binding.etFatherName.text.isNullOrBlank()) {
            binding.etFatherName.error = "Please enter your father's name."
            return false
        } else if (binding.etPostalCode.text.isNullOrBlank()) {
            binding.etPostalCode.error = "Please enter your postal code."
            return false
        } else if (binding.etPhoneNumber.text.isNullOrBlank()) {
            binding.etPhoneNumber.error = "Please enter your phone number."
            return false
        } else if (binding.etNumberOfAccounts.text.isNullOrBlank()) {
            binding.etNumberOfAccounts.error = "Please enter the number of accounts."
            return false
        }
        return true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }

}