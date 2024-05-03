package com.example.androidgeminiapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.MSEC.androidgeminiapp.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTPrompt=findViewById<EditText>(R.id.eTPrompt)
        val btn=findViewById<Button>(R.id.btn)
        val tVAns=findViewById<TextView>(R.id.tVAns)

        btn.setOnClickListener {
            val prompt =eTPrompt.text.toString()


            val generativeModel = GenerativeModel(
                    modelName = "gemini-pro",
                    apiKey = "AIzaSyAv5ZDn5-iq5LCa7XkfijNEskqQcSJd3ic"
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt = prompt)
                tVAns.text=response.text
            }
        }
    }
}
