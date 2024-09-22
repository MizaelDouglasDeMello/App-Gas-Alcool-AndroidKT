package br.com.mizaeldouglas.app_gas_alcool

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.mizaeldouglas.app_gas_alcool.fragments.ResultFragment
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnResult: Button
    private lateinit var editAlcool: TextInputEditText
    private lateinit var editGasolina: TextInputEditText
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnResult = findViewById(R.id.btn_calc)
        editAlcool = findViewById(R.id.txtEdit_precoAlcool)
        editGasolina = findViewById(R.id.txtEdit_precoGasolina)




        btnResult.setOnClickListener{
            val precoAlcool = editAlcool.text.toString().toDoubleOrNull() ?: 0.00
            val precoGasolina = editGasolina.text.toString().toDoubleOrNull() ?: 0.00



            val bundle = Bundle().apply {
                putDouble("precoAlcool", precoAlcool)
                putDouble("precoGasolina", precoGasolina)

            }

            val resultFragment = ResultFragment().apply {
                arguments = bundle
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragment_result, resultFragment).commit()



        }



    }
}