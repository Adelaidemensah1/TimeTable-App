package com.simplemobiletools.calendar.pro.views.auth


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.simplemobiletools.calendar.pro.HomeActivity
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.databinding.ActivitySignInBinding
import com.simplemobiletools.calendar.pro.extensions.Extensions.toast
import com.simplemobiletools.calendar.pro.utils.FirebaseUtils.firebaseAuth


class SignInActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    private lateinit var signInEmail: String
    private lateinit var signInPassword: String
    private lateinit var signInInputsArray: Array<EditText>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)


        signInInputsArray = arrayOf(binding.etEmail, binding.etPassword)
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        binding.signInBtn.setOnClickListener {
            signInUser()
        }


    }

    private fun notEmpty(): Boolean = signInEmail.isNotEmpty() && signInPassword.isNotEmpty()

    private fun signInUser() {
        binding.pbLoading.visibility = View.VISIBLE;

        signInEmail = binding.etEmail.text.toString().trim()
        signInPassword = binding.etPassword.text.toString().trim()

        if (notEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(signInEmail, signInPassword)
                .addOnCompleteListener { signIn ->
                    if (signIn.isSuccessful) {
                        binding.pbLoading.visibility = View.GONE;

                        startActivity(Intent(this, HomeActivity::class.java))
                        toast("signed in successfully")
                        finish()
                    } else {
                        binding.pbLoading.visibility = View.GONE;

                        toast("sign in failed")
                    }
                }
        } else {
            signInInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth != null) {
            // if the user is not null then we are
            // opening a main activity on below line.
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()
        }
    }

}





