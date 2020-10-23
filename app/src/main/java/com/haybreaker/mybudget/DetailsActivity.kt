package com.haybreaker.mybudget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        submitButton.setOnClickListener() {
            //Toast to be present until the features work correctly
            Toast.makeText(this, "Function not supported yet", Toast.LENGTH_SHORT).show()

            var hourlyRateVal = hourlyPayText.text.toString().toFloat()
            var commissionPay = commissionPayText.text.toString().toFloat()
            var quickExpense = quickExpenseText.text.toString().toFloat()

            val boo = true
            
        }
    }
}