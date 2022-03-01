package edu.itesm.calculadoradepropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.itesm.calculadoradepropina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTip(.15) }
        binding.button20.setOnClickListener {
            interfaceCalculateTip(.25)  }
        binding.button35.setOnClickListener {
            interfaceCalculateTip(.35)  }
    }

    private fun interfaceCalculateTip(percentage: Double){
        val amount = binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()
        if( amountValue == null){
            binding.totalTip.text = "0.0"
            binding.totalAmount.text = "0.0"
            return
        }
        binding.totalTip.text = "${ amountValue * percentage }"
        binding.totalAmount.text = "${amountValue * (1 + percentage)}"
    }

}