package `in`.co.ngcapp.ngc.activity


import `in`.co.ngcapp.ngc.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var sign_up  = findViewById<Button>(R.id.sign_up)
        sign_up.setOnClickListener {
            startActivity(Intent(this@LoginActivity,MainHandlingActivity::class.java))
        }
    }
}
