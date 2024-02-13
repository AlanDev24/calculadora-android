package gonzalez.alan.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var numero1: Double = 0.0;

    var operacion: Int = 0;

    lateinit var  tv_num1: TextView
    lateinit var  tv_num2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1);
        tv_num2 = findViewById(R.id.tv_num2);

        val btn_borrar: Button = findViewById(R.id.btn_borrar)
        val btn_igual: Button = findViewById(R.id.btn_igual)

        btn_igual.setOnClickListener{
            var numero2: Double = tv_num2.text.toString().toDouble()
            var respuesta: Double = 0.0

            when(operacion){
                1 -> respuesta = numero1 + numero2
                2 -> respuesta = numero1 - numero2
                3 ->{
                    if (numero2 != 0.0) {
                        respuesta = numero1 / numero2
                    } else {
                        tv_num2.text = "Error al dividir entre 0"
                        return@setOnClickListener
                    }
                }
                4 -> respuesta = numero1 * numero2

            }

            tv_num2.setText(respuesta.toString())
            tv_num1.setText("")
        }

        btn_borrar.setOnClickListener {
            numero1 = 0.0
            tv_num1.setText("")
            tv_num2.setText("")
            operacion =0
        }

    }

    fun  presionarDigito(view: View){
        var num2: String = tv_num2.text.toString();

        when(view.id){
            R.id.btn_0 -> tv_num2.setText(num2 + "0")
            R.id.btn_1 -> tv_num2.setText(num2 + "1")
            R.id.btn_2 -> tv_num2.setText(num2 + "2")
            R.id.btn_3 -> tv_num2.setText(num2 + "3")
            R.id.btn_4 -> tv_num2.setText(num2 + "4")
            R.id.btn_5 -> tv_num2.setText(num2 + "5")
            R.id.btn_6 -> tv_num2.setText(num2 + "6")
            R.id.btn_7 -> tv_num2.setText(num2 + "7")
            R.id.btn_8 -> tv_num2.setText(num2 + "8")
            R.id.btn_9 -> tv_num2.setText(num2 + "9")
            R.id.btn_punto -> tv_num2.setText(num2 + ".")
        }
    }

    fun clickOperacion(view: View){

        numero1 = tv_num2.text.toString().toDouble();
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
            R.id.btn_suma -> {
                tv_num1.setText(num2_text + '+');
                operacion = 1
            }
            R.id.btn_resta ->{
                tv_num1.setText(num2_text + '-');
                operacion = 2
            }
            R.id.btn_dividir -> {
                tv_num1.setText(num2_text + '/');
                operacion = 3
            }
            R.id.btn_multiplicar -> {
                tv_num1.setText(num2_text + '*');
                operacion = 4
            }
        }
    }
}