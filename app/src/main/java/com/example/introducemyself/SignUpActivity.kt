package com.example.introducemyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged

class SignUpActivity : AppCompatActivity() {
    // 초기화 지연 ,
    val tv_blank1 : TextView by lazy { findViewById(R.id.tv_blank1) }
    val tv_blank2 : TextView by lazy { findViewById(R.id.tv_blank2) }
    val tv_blank3 : TextView by lazy { findViewById(R.id.tv_blank3) }
    val tv_blank4 : TextView by lazy { findViewById(R.id.tv_blank4) }

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

        // 빨간 경고 글씨 실시간 빈칸여부 체크 후 보여지기
        nametext.doAfterTextChanged {
            tv_blank1.isVisible = nametext.text.isEmpty()  // isvisible을 통해서 true, false 확인 true라면 tv_black1의 텍스트가 보이고, false면 안보임
        }
        // 아래 if문을 통해서도 가능하지만 위 구문 처럼 한줄로도 가능
        agetext.doAfterTextChanged {
            if(agetext.text.isNotEmpty()) {
                tv_blank2.visibility = View.INVISIBLE
            } else if(agetext.text.isEmpty()) {
                tv_blank2.visibility = View.VISIBLE
            }
        }
        idtext.doAfterTextChanged {
            tv_blank3.isVisible = idtext.text.isEmpty()
        }
        passtext.doAfterTextChanged {
            tv_blank4.isVisible = passtext.text.isEmpty()
        }

    }
}