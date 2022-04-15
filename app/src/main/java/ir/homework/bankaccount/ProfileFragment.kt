package ir.homework.bankaccount

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ir.homework.bankaccount.databinding.FragmentProfileBinding
import kotlin.properties.Delegates

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    val vModel: MainViewModel by activityViewModels()
    lateinit var sharedPreferences: SharedPreferences
    var flag by Delegates.notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flag = true
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

        showProfileIfExist()

        binding.btnSubmitProfile.setOnClickListener{
            if (validateProfile())  {
                saveProfileInSharePref()
                findNavController().navigate(R.id.action_nav_profile_to_showProfileFragment)
            }
        }
    }

    private fun showProfileIfExist() {
        val firstName = sharedPreferences.getString("firstName", "")
        if (!firstName.isNullOrBlank() and flag) {
            flag = false
            findNavController().navigate(R.id.action_nav_profile_to_showProfileFragment)
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