package com.test.introduceapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity: AppCompatActivity() {

    lateinit var intentManager : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val idText = findViewById<EditText>(R.id.inputId)
        val pwText = findViewById<EditText>(R.id.inputPw)
        val signInBtn = findViewById<TextView>(R.id.goSignIn)
        val signUpBtn = findViewById<TextView>(R.id.goSignUp)
        var nameText = ""
        intentManager = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode== RESULT_OK){
                val userId = it.data?.getStringExtra("id")?:""
                val userPw = it.data?.getStringExtra("pw")?:""
                val userName = it.data?.getStringExtra("name")?:""
                idText.setText(userId)
                pwText.setText(userPw)
                nameText = userName
            }
        }

        signInBtn.setOnClickListener{
            if(idText.text.toString().trim().isEmpty()||pwText.text.toString().trim().isEmpty()){
                Toast.makeText(this,"아아디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("id",idText.text.toString())
            intent.putExtra("pw",pwText.text.toString())
            intent.putExtra("name",nameText)
            startActivity(intent)
        }
        signUpBtn.setOnClickListener{
//            첨에 이렇게 했었는데 강의보고 바꿈
//            val intent = Intent(this,SignUpActivity::class.java)
//            startActivity(intent)
            val intent = Intent(this,SignUpActivity::class.java)
            intentManager.launch(intent)
        }
    }
}