package com.example.digitallibrary.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.digitallibrary.R
import com.example.digitallibrary.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupFragment : Fragment() {
    //private var _binding: FragmentSignupBinding? = null
    private lateinit var binding: FragmentSignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize FirebaseAuth instance
        firebaseAuth = FirebaseAuth.getInstance()

        // Set up sign-up button click listener
        binding.SingUpButton.setOnClickListener {
            val login = binding.loginSingUpText.text.toString().trim()
            val password = binding.passwordSingUpText.text.toString()
            val passwordAgain = binding.passwordAgainSingUpText.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty() && passwordAgain.isNotEmpty()) {
                if (password == passwordAgain) {
                    firebaseAuth.createUserWithEmailAndPassword(login, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Navigate to VhodFragment on successful signup
                                findNavController().navigate(R.id.to_vhod_button)
                            } else {
                                // Show error message if signup fails
                                Toast.makeText(activity, task.exception?.message ?: "Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(activity, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Все поля обязательны для заполнения", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up button to switch to login (Vhod) fragment
        binding.toVhodButton.setOnClickListener {
            // Navigate to VhodFragment
            findNavController().navigate(R.id.to_vhod_button)
        }
    }
}
