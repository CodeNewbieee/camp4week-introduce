package com.example.introducemyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val strData =intent.getStringExtra("dataFromSignInActivity")
        val editText = findViewById<EditText>(R.id.edittext)
        editText.setText(strData)

        //종료 버튼 클릭시 SignInActivity로 이동
        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}