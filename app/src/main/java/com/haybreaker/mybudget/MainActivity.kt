package com.haybreaker.mybudget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FUnctions for testing writing files
        //File("expenses.dat").writeText("700")

        //If edit details button is clicked
        editDetailsButton.setOnClickListener(){
            val intent: Intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
            //TODO: put in details activity
        }

        //If edit expenses button is clicked
        editExpensesButton.setOnClickListener{
            Toast.makeText(this, "Function coming soon... thanks!", Toast.LENGTH_SHORT).show()
            //Implement todo: put in expenses activity

            val intent: Intent = Intent(this,com.haybreaker.mybudget.ExpensesActivity::class.java)
            startActivity(intent)
        }

        //If calculate budget button is clicked
        submitButton.setOnClickListener{
            //Toast.makeText(this, "Woah calm down cowboy", Toast.LENGTH_SHORT).show()
            calculateBudget()
        }
    }

    private fun calculateBudget(){

        if(hoursWorked.text.toString().toFloat() != null && otherIncome.text.toString().toFloat() != null){
            var hoursWorkedVal = hoursWorked.text.toString().toFloat()
            var otherIncomeVal = otherIncome.text.toString().toFloat()
            var commissionVal = 500.00
            var taxPaid = 0.00
            var commissionTax = 0.00

            //Initialize variables that are needed later for cals
            var x = 0

            var grossIncome = hoursWorkedVal * 23.00
            //Hardcoded variable to be replaced with read later on
            var expenses = 217.92

            var predictedAnnual: Int = ((grossIncome/30)*365).toInt()
            for ( x in 1 .. 180000){
                if(x == predictedAnnual){
                    if(x > 0){
                        taxPaid = 0.00
                        commissionTax = 0.00
                    }
                    if(x > 18200){
                        taxPaid = (0.19 * (predictedAnnual - 18200))
                        commissionTax = 0.19 * commissionVal
                    }
                    if(x > 45000){
                        taxPaid = 5092 + (0.325 * (predictedAnnual - 45000))
                        commissionTax = 0.325 * commissionVal
                    }
                    if(x > 120000){
                        taxPaid = 29467 + (0.37 *(predictedAnnual - 120000))
                        commissionTax = 0.37 * commissionVal
                    }
                    if(x > 180000){
                        taxPaid = 54667 + (0.45 * (predictedAnnual - 180000))
                        commissionTax = 0.45 * commissionVal
                    }
                }
            }

            //Finish final calculations
            var shortTax = (taxPaid/365)*30
            var superPaid = grossIncome * 0.10
            var netIncome = (grossIncome - shortTax - superPaid + otherIncomeVal + (commissionVal - commissionTax))
            var leftoverIncome = netIncome - expenses
            var spendingMoney = leftoverIncome*0.20
            var investingMoney = leftoverIncome*0.70
            var savingsMoney = leftoverIncome*0.10

            //Setting of Labels / Values parsed to screen
            labelNetIncomeVal.text = String.format("$ %.2f", netIncome)
            labelTaxAmountVal.text = String.format("$ %.2f", (shortTax + commissionTax))
            labelExpensesVal.text = String.format("$ %.2f", expenses)
            labelSpendingVal.text = String.format("$ %.2f", spendingMoney)
            labelInvestmentsVal.text = String.format("$ %.2f", investingMoney)
            labelSavingsVal.text = String.format("$ %.2f", savingsMoney)
        }
        else{
            Toast.makeText(this, "Please enter text into sections above.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun listExpenses(){

    }
    //Finish all functions by here **
}