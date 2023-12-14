package com.example.introducemyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idtext = findViewById<EditText>(R.id.idText)
        val passtext = findViewById<EditText>(R.id.passText)
        val btn_home = findViewById<Button>(R.id.login)

        // 로그인 버튼 눌렀을 때, HomeActivity 창이 실행
        // 아이디 및 비빌번호 창(edittext)에 빈칸 상태로 로그인 버튼을 눌렀을때, 입력확인 메세지 출력
        btn_home.setOnClickListener {
            if (idtext.text.isEmpty() || passtext.text.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                // 아이디 입력창에서 작성한 정보
                // HomeActivity로 넘어갈시 입력한 아이디 정보가 putExtra 함수에 의해 넘겨짐ㅁㄴ
                val strData = idtext.text.toString()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataFromSignInActivity", strData)
                startActivity(intent)
                // 로그인 되었을 때 로그인 성공 메세지 출력
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
            }

        }

        // 회원가입 버튼 눌렀을 때, SignUpActivity 창 실행
        val btn_signup = findViewById<Button>(R.id.signup)
        btn_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"회원가입 창으로 이동합니다.",Toast.LENGTH_SHORT).show()
        }
    }
}