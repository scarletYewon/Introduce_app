package com.test.introduceapp


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val idText = findViewById<EditText>(R.id.inputId)
        val pwText = findViewById<EditText>(R.id.inputPw)
        val nameText = findViewById<EditText>(R.id.inputName)
        val signUpBtn = findViewById<TextView>(R.id.goSignIn)

        signUpBtn.setOnClickListener{
            if(idText.text.toString().trim().isEmpty()||pwText.text.toString().trim().isEmpty()||nameText.text.toString().trim().isEmpty()){
                Toast.makeText(this,"입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this,SignInActivity::class.java).apply {
                putExtra("id",idText.text.toString())
                putExtra("pw",pwText.text.toString())
                putExtra("name",nameText.text.toString())
            }
            setResult(RESULT_OK, intent)
            if (!isFinishing) finish()
        }
    }
}