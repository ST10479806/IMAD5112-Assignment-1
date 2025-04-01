package vcmsa.ci.crunchtime

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView.FindListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private val String.text: Any
    get() = Unit



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

       val edtDay = findViewById<EditText>(R.id.edtDay)
        var txtMeal = findViewById<TextView>(R.id.txtMeal)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnSuggestion = findViewById<Button>(R.id.btnSuggestion)

        btnSuggestion.setOnClickListener {
            val input = edtDay.text.toString().trim().lowercase()
            var foodOfDay = "Empty"
            var txtMeal = edtDay.text.toString()
            btnSuggestion {

                if (txtMeal == "morning") {
                    foodOfDay = "oats"
                } else if ( txtMeal =="mid-morning") {
                    foodOfDay = "fruit"
                } else if (txtMeal == "afternoon"){
                    foodOfDay = " burger with chips"
                } else if (txtMeal == "mid-afternoon") {
                    foodOfDay = "biscuit and yogurt"
                } else if (txtMeal == "Dinner") {
                    foodOfDay = "rice with beef stew"
                } else if ( txtMeal == "dessert") {
                    foodOfDay = "ice cream with cake"
                }
                txtMeal.text.also { foodOfDay = it.toString() }
            }
        }
        btnReset.setOnClickListener {
            txtMeal.text.clear()
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun btnSuggestion(value: () -> Unit) {

    }
}

private fun CharSequence.clear() {
    TODO("Not yet implemented")
}
