package com.example.introducemyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val imageArray = listOf(R.drawable.linefreinds1,R.drawable.linefreinds2,R.drawable.linefreinds3,R.drawable.linefreinds4,R.drawable.linefreinds5)
        val image = findViewById<ImageView>(R.id.imageView2)
//        var ram = Random
//        var num = ram.nextInt(imageArray.size)
//        위 코드처럼 random 객체 생성해서 랜덤의 함수 사용해도 되지만, 콜렉션 함수를 통해서 아래처럼 바로 랜덤 가능
        image.setImageResource(imageArray.random())

        // (아래) 제일 처음에 작성한 랜덤 이미지 코드
        // when 구문을 통해서 num에 랜덤하게 숫자가 할당될 때, 그 숫자에 맞춰 지정한 이미지가 출력되도록 함
//        when(num) {
//            0 -> image.setImageResource(R.drawable.linefreinds1)
//            1 -> image.setImageResource(R.drawable.linefreinds2)
//            2 -> image.setImageResource(R.drawable.linefreinds3)
//            3 -> image.setImageResource(R.drawable.linefreinds4)
//            4 -> image.setImageResource(R.drawable.linefreinds5)
//        }

        //메인화면의 아이디 창에서 입력한 정보를 받을 수 있도록 변수 지정
        val strData =intent.getStringExtra(getString(R.string.signin_info))
        val editText = findViewById<TextView>(R.id.textView)
//        editText.text=strData, 아래 코드와 동일
        editText.setText("아이디 : ${strData}")

        //종료 버튼 클릭시 SignInActivity로 이동
        val btn_close = findViewById<ConstraintLayout>(R.id.btn_c)
        btn_close.setOnClickListener {
            finish()
        }
    }
}