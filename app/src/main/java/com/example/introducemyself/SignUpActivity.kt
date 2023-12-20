package com.example.introducemyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

       // 각 뷰들의 아이디를 참조하여 변수에 할당
        val nametext = findViewById<EditText>(R.id.sign_nametext)
        val agetext = findViewById<EditText>(R.id.sign_agetext)
        val idtext = findViewById<EditText>(R.id.sign_idtext)
        val passtext = findViewById<EditText>(R.id.sign_passtext)
        val btn = findViewById<Button>(R.id.btn_signup)

        btn.setOnClickListener { // 이름, 나이, 아이디, 비번 중 하나라도 입력되지 않을시, 토스트 메세지 출력
            // getString 활용하여 토스트 메세지 출력
            // 각 빈칸에 대한 메세지 출력
            if (nametext.text.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.nameerr), Toast.LENGTH_SHORT).show()
            } else if(agetext.text.trim().isEmpty()){
                Toast.makeText(this, getString(R.string.ageerr), Toast.LENGTH_SHORT).show()
            } else if(idtext.text.trim().isEmpty()){
                Toast.makeText(this, getString(R.string.iderr), Toast.LENGTH_SHORT).show()
            } else if(passtext.text.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.passerr), Toast.LENGTH_SHORT).show()
            } else {
                // 입력된 아이디와 비밀번호 데이터를 메인 화면에 자동입력되도록 데이터 전달(콜백?)
                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra("id", idtext.text.toString())
                    putExtra("pass", passtext.text.toString())
                }
                setResult(RESULT_OK,intent)
                Toast.makeText(this,getString(R.string.signup_sc),Toast.LENGTH_SHORT).show()
                finish()
            }
            // 회원가입 버튼 클릭시 메인인 signinActivity로 이동
            // signupActivity는 onPause, Stop, Destroy 순으로 진행되며 사라짐

        }

    }
}