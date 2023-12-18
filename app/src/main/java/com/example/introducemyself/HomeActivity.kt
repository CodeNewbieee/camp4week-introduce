package com.example.introducemyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val imageArray = listOf(R.drawable.linefreinds1,R.drawable.linefreinds2,R.drawable.linefreinds3,R.drawable.linefreinds4,R.drawable.linefreinds5)
        // 랜덤하게 이미지 구현할 수 있도록 image 변수에 이미지 뷰 담기
        // 랜덤기능 사용하기 위해 랜덤객체 생성
        // 랜덤객체의 숫자가 랜덤하게 나오도로고 하고, num 변수에 그 값이 할당되도록 함
        val image = findViewById<ImageView>(R.id.imageView2)
        var ram = Random
        var num = ram.nextInt(imageArray.size)
        image.setImageResource(imageArray[num])
        // when 구문을 통해서 num에 랜덤하게 숫자가 할당될 때, 그 숫자에 맞춰 지정한 이미지가 출력되도록 함
//        when(num) {
//            0 -> image.setImageResource(R.drawable.linefreinds1)
//            1 -> image.setImageResource(R.drawable.linefreinds2)
//            2 -> image.setImageResource(R.drawable.linefreinds3)
//            3 -> image.setImageResource(R.drawable.linefreinds4)
//            4 -> image.setImageResource(R.drawable.linefreinds5)
//        }

        //메인화면의 아이디 창에서 입력한 정보를 받을 수 있도록 변수 지정
        val strData =intent.getStringExtra("dataFromSignInActivity")
        val editText = findViewById<TextView>(R.id.edittext)
//        editText.text=strData, 아래 코드와 동일
        editText.setText(strData)

        //종료 버튼 클릭시 SignInActivity로 이동
        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}