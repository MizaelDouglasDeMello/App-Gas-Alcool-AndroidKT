package br.com.mizaeldouglas.app_gas_alcool.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.mizaeldouglas.app_gas_alcool.R

class ResultFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.result_fragment, container, false)

        val precoAlcool = arguments?.getDouble("precoAlcool") ?: 0.00
        val precoGasolina = arguments?.getDouble("precoGasolina") ?: 0.00

        val txtViewAlcool = view.findViewById<TextView>(R.id.txt_result_precoAlcool)
        val txtViewGasolina = view.findViewById<TextView>(R.id.txt_result_precoGasolina)
        val txtViewResult = view.findViewById<TextView>(R.id.txt_result)



        if (precoAlcool > 0 && precoGasolina > 0) {

            txtViewAlcool.text = "Preço do Álcool: R$ $precoAlcool"
            txtViewGasolina.text = "Preço da Gasolina: R$ $precoGasolina"

            val relacao = precoAlcool / precoGasolina

            val resultado = if (relacao < 0.7) {
                "Compensa usar Álcool"
            } else {
                "Compensa usar Gasolina"
            }
            txtViewResult.text = resultado
        } else {
            txtViewAlcool.text = ""
            txtViewResult.text = ""
            txtViewGasolina.text = ""
        }

        return view
    }
}
