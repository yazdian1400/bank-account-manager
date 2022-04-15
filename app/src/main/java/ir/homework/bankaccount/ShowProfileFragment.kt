package ir.homework.bankaccount

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ir.homework.bankaccount.databinding.FragmentShowProfileBinding

class ShowProfileFragment : Fragment() {
    lateinit var binding: FragmentShowProfileBinding
    val vModel: MainViewModel by activityViewModels()
    lateinit var sharedPreferences: SharedPreferences

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getProfileFromSharedPref()
    }

    private fun getProfileFromSharedPref() {
        binding.tvFirstName.text = sharedPreferences.getString("firstName", "")
        binding.tvLastName.text = sharedPreferences.getString("lastName", "")
        binding.tvFatherName.text = sharedPreferences.getString("fatherName", "")
        binding.tvPostalCode.text = sharedPreferences.getString("postalCode", "")
        binding.tvPhoneNumber.text = sharedPreferences.getString("phoneNumber", "")
        binding.tvNumberOfAccounts.text = sharedPreferences.getString("numAccounts", "")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }
}