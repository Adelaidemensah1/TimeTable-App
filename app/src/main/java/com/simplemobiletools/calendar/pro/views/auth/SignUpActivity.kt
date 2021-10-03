package com.simplemobiletools.calendar.pro.views.auth


import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseUser
import com.simplemobiletools.calendar.pro.HomeActivity
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.databinding.ActivitySignUpBinding
import com.simplemobiletools.calendar.pro.extensions.Extensions.toast
import com.simplemobiletools.calendar.pro.utils.FirebaseUtils.firebaseAuth
import com.simplemobiletools.calendar.pro.utils.FirebaseUtils.firebaseUser


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
     private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var createAccountInputsArray: Array<EditText>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)





        createAccountInputsArray =
            arrayOf(binding.etPassword, binding.etPassword, binding.etConfirmPassword)

        binding.createAccount.setOnClickListener {
            signIn()
        }

        //handle sign in
        binding.tvLogIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            toast("please sign into your account")
            finish()
        }


    }


    /* check if there's a signed-in user*/

    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = firebaseAuth.currentUser
        user?.let {
            startActivity(Intent(this, HomeActivity::class.java))
            toast("welcome back")
        }
    }


    private fun notEmpty(): Boolean = binding.edtUserName.text.toString().trim().isNotEmpty() &&
            binding.etPassword.text.toString().trim().isNotEmpty() &&
            binding.etConfirmPassword.text.toString().trim().isNotEmpty()

    private fun identicalPassword(): Boolean {
        var identical = false
        if (notEmpty() &&
            binding.etPassword.text.toString().trim() == binding.etConfirmPassword.text.toString()
                .trim()
        ) {
            identical = true
        } else if (!notEmpty()) {
            createAccountInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        } else {
            toast("passwords are not matching !")
        }
        return identical
    }

    private fun signIn() {
        if (identicalPassword()) {
            binding.pbLoading.visibility = View.VISIBLE;

            // identicalPassword() returns true only  when inputs are not empty and passwords are identical
            userEmail = binding.edtUserName.text.toString().trim()
            userPassword = binding.etPassword.text.toString().trim()

            /*create a user*/
            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        binding.pbLoading.visibility = View.GONE;

                        toast("created account successfully !")

                        sendEmailVerification()
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                    } else {
                        binding.pbLoading.visibility = View.GONE;

                        toast("failed to Authenticate !")
                    }
                }
        }
    }

/* send verification email to the new user. This will only
*  work if the firebase user is not null.
    */

    private fun sendEmailVerification() {
        firebaseUser?.let {
            it.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    toast("email sent to $userEmail")
                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

