package com.example.introducemyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 이름, 아이디, 비번 중 하나라도 입력되지 않을시, 토스트 메세지 출력
        val nametext = findViewById<EditText>(R.id.sign_nametext)
        val idtext = findViewById<EditText>(R.id.sign_idtext)
        val passtext = findViewById<EditText>(R.id.sign_passtext)
        val btn = findViewById<Button>(R.id.btn_signup)


        btn.setOnClickListener {
            if (nametext.text.isEmpty()||idtext.text.isEmpty() || passtext.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // 빈칸이 있을 경우 토스트 메세지 출력
            } else {
                Toast.makeText(this,"회원가입이 완료되었습니다.",Toast.LENGTH_SHORT).show()
                finish()
            } // 회원가입 버튼 클릭시 메인인 signinActivity로 이동

        }

    }
}