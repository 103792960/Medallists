package au.edu.swin.sdmd.TheMedallists

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description)

        val sharedpref = this.getSharedPreferences("data", Context.MODE_PRIVATE)
        val country = sharedpref.getString("name", "Australia").toString()
        val ioccode = sharedpref.getString("code", "IOC").toString()

        val result = findViewById<TextView>(R.id.lastresult)
        result.text = "The last country clicked was $country ($ioccode)"
    }
}