package com.example.introducemyself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher

class SignInActivity : AppCompatActivity() {
    //registerForActivityResult 사용하기 위한 1번째
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idtext = findViewById<EditText>(R.id.idText)
        val passtext = findViewById<EditText>(R.id.passText)
        val btn_home = findViewById<Button>(R.id.login)

        // 로그인 버튼 눌렀을 때, HomeActivity 창이 실행
        // 아이디 및 비빌번호 창(edittext)에 빈칸 상태로 로그인 버튼을 눌렀을때, 입력확인 메세지 출력
        btn_home.setOnClickListener {
            if (idtext.text.trim().isEmpty() || passtext.text.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.id_passerr), Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
                //else 문을 쓰게 되면 위의 return이 필요없다.
                // 위의 return의 의미는 현재 클릭리스너 구문을 아래 남은 코드를 무시하고 빠져나가겠다는 의미 그래서 실행 안되게 막는것
                // else로 연결되어 있다면 없어도 무방
            } else {
                // 아이디 입력창에서 작성한 정보를 버튼을 클릭했을 때, strData 변수에 할당(저장,담음)
                val strData = idtext.text.toString()
                val intent = Intent(this, HomeActivity::class.java)
                // HomeActivity로 이동할 시 입력한 아이디 정보가 putExtra 함수에 의해 넘겨짐
                intent.putExtra(getString(R.string.signin_info), strData)
                startActivity(intent)
                // 로그인 되었을 때 로그인 성공 메세지 출력
                Toast.makeText(this, getString(R.string.signin), Toast.LENGTH_SHORT).show()
            }

        }
        // registerForActivity 를 활용하여 회원가입 페이지에서 작성한 아이디 비번 내용을 그대로 받으려고 했으나 안됨
        // 아래 주석처리된것 처럼 회원가입 창에서 인텐트로 보내준 데이터 값을 받을 때 동일하게 intent로 하였으나
        // 전혀 기능이 실행되지 않았고, it의 data로 받게끔 할때 자동입력이 되었음
        // resultcode 인텐트가 실행된 곳에서 돌려받은 결과 코드
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){it ->
            if(it.resultCode == RESULT_OK) {
//                val idreturn = intent.getStringExtra("id") ?:""
//                val passreturn = intent.getStringExtra("pass") ?:""
                val idreturn = it.data?.getStringExtra("id")
                val passreturn = it.data?.getStringExtra("pass")
                    idtext.setText(idreturn)
                    passtext.setText(passreturn)
            }
        }

        // 회원가입 버튼 눌렀을 때, SignUpActivity 창 실행
        val btn_signup = findViewById<Button>(R.id.signup)
        btn_signup.setOnClickListener {
            //this는 현재 액티비티를 지칭, 뒤에는 넘어가고자 하는 액티비티를 작성
            val intent = Intent(this, SignUpActivity::class.java)
            //registerForActivity를 사용할 경우 화면전환후 다시 돌아와서 데이터를 받는 과정이기때문에
            //startActivity(intent)를 쓰지 않고, 아래의 코드를 사용하여 화면 이동
            activityResultLauncher.launch(intent)
            Toast.makeText(this,getString(R.string.signup),Toast.LENGTH_SHORT).show()
        }
    }
}