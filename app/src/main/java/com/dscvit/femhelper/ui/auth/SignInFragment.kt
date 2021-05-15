package com.dscvit.femhelper.ui.auth


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.dscvit.femhelper.R
import com.dscvit.femhelper.model.Result
import com.dscvit.femhelper.model.login.LoginRequest
import com.dscvit.femhelper.ui.PostAuthActivity
import com.dscvit.femhelper.utils.*
import com.dscvit.femhelper.utils.PreferenceHelper.set
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class SignInFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = PreferenceHelper.customPrefs(requireContext(), Constants.PREF_NAME)

        signInProgressBar.visibility = View.GONE

        val authViewModel by sharedViewModel<AuthViewModel>()

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val loginRequest = LoginRequest(email = email, password = password, username = null)

            if (isEmailValid(email)) {
                if (password.isNotEmpty()) {

                    authViewModel.signInUser(loginRequest).observe(viewLifecycleOwner, Observer {
                        when (it.status) {
                            Result.Status.LOADING -> {
                                signInProgressBar.show()

                                signInButton.hide()
                                emailEditText.disable()
                                passwordEditText.disable()
                            }
                            Result.Status.SUCCESS -> {
                                if (it.data?.message == "User Logged In") {
                                    sharedPreferences[Constants.PREF_IS_LOGGED_IN] = true
                                    sharedPreferences[Constants.PREF_AUTH_KEY] = it.data.user.token
                                    sharedPreferences[Constants.PREF_USER_ID] = it.data.user.id

                                    signInProgressBar.hide()

                                    val intent =
                                        Intent(requireContext(), PostAuthActivity::class.java)
                                    startActivity(intent)
                                    requireActivity().finish()
                                }
                            }
                            Result.Status.ERROR -> {
                                signInProgressBar.hide()

                                signInButton.show()
                                emailEditText.enable()
                                passwordEditText.enable()

                                if (it.message == "400 Bad Request") {
                                    requireContext().shortToast("Email or Password is wrong")
                                } else {
                                    requireContext().shortToast("No Internet")
                                }

                                Log.d("esh", it.message)
                            }
                        }
                    })
                } else {
                    requireContext().shortToast("Password cannot be empty")
                }
            } else {
                requireContext().shortToast("Enter a valid Email")
            }
        }
    }

    private fun isEmailValid(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
