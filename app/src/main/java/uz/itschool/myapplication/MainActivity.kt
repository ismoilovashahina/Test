package uz.itschool.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import uz.itschool.myapplication.Result
import uz.itschool.myapplication.model.Test

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    var savollar = arrayListOf<Test>()
    var index = 0
    var counter = 0
    var c = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        savollar.add(Test("The largest country in the world?", "Russia", "China", "3-variant", "4-variant", "3"))
        savollar.add(Test("What is the capital of Britain?", "London", "Moscow", "Birmingham", "Tashkent", "London"))
        savollar.add(Test("-5+8=?", "54", "1", "2", "3", "3"))
        savollar.add(Test("-5*8=?", "54", "1", "-40", "3", "-40"))
        savollar.add(Test("Humoyunnomani kim yozgan?", "Humoyun Mirzo", "Bobur mirzo", "Gulbadanbegim", "Xondamir", "Gulbadanbegim"))


        questionNumber(savollar.size)

        question(0)


        next.setOnClickListener {

            if (index==savollar.size-1){
                Toast.makeText(this, "obbo", Toast.LENGTH_LONG).show()
                finish_test()
                return@setOnClickListener
            }
            index++

            question(index)
            radioGroup.clearCheck()


            if(answer1.isChecked && answer1.text==savollar[0].javob){
                counter++
            }
            if(answer2.isChecked && answer2.text==savollar[1].javob){
                counter++
            }
            if(answer4.isChecked && answer1.text==savollar[2].javob){
                counter++
            }
            if(answer3.isChecked && answer1.text==savollar[3].javob){
                counter++
            }
            if(answer3.isChecked && answer1.text==savollar[4].javob){
                counter++
            }

        }

        finish.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putExtra("count", counter)
        }

    }

    fun finish_test(){
        next.visibility=View.INVISIBLE
        finish.visibility = View.VISIBLE


    }
    fun question(index:Int){
        var test1 = savollar[index]
        question.text = test1.savol

        answer1.text = test1.variant1
        answer2.text = test1.variant2
        answer3.text = test1.variant3
        answer4.text = test1.variant4
    }

    fun questionNumber(n:Int){
        for (i in 1..n){
            var btn = Button(this)
            btn.id = i
            btn.text = "$i"
            btn.tag = "$i"
            btn.setOnClickListener(this)
            q_number.addView(btn)
        }
    }

    override fun onClick(v: View?) {
        val btn = findViewById<Button>(v!!.id)
        index = btn.tag.toString().toInt()-1
        question(index)


    }
}