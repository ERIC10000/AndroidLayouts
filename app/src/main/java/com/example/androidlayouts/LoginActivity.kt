package com.example.androidlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // codes are executed here
        // functions are called here..
        // objects are created here

        // Find Views Based on Id
        // Add Event Listener
        // get username and password from EditText

        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)

        val buttonLogin : Button = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            // Intent -> message in android
            // Intent to move from LoginActivity(applicationContext) to MainActivity

            // Implement post request
            val api = "http://erickapi.pythonanywhere.com/login"
            val body = JSONObject()
            body.put("username", username.text.toString())
            body.put("password", password.text.toString())

            val helper = ApiHelper(applicationContext)
            helper.post(api, body, object : ApiHelper.CallBack{
                override fun onSuccess(result: JSONArray?) {

                }

                override fun onSuccess(result: JSONObject?) {
                    if(result!!.has("granted")){
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    }


                    else{
                        Toast.makeText(applicationContext,
                            "${result.toString()}", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(result: String?) {
                    Toast.makeText(applicationContext, "${result.toString()}", Toast.LENGTH_SHORT).show()
                }
            })

        }

        val tvLogin : TextView = findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {
            // Intent -> message in android
            // Intent to move from LoginActivity(applicationContext) to MainActivity
            val intentMain = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intentMain)
        }


    } // end onCreate() -> main

    // outside onCreate()
    // create functions and classes
}

// 1pm. - 2pm
// Intents
// Toast