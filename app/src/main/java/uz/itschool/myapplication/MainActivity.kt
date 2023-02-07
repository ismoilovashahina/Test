package uz.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import uz.itschool.myapplication.model.Test

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    var savollar = arrayListOf<Test>()
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        savollar.add(Test("The largest country in the world?", "Russia", "China", "3-variant", "4-variant", "3"))
        savollar.add(Test("2-savol", "0", "1", "2", "3", "3"))
        savollar.add(Test("3-savol", "54", "1", "2", "3", "3"))
        savollar.add(Test("4-savol", "0", "1", "5353", "3", "3"))


        questionNumber(savollar.size)

        question(0)


        next.setOnClickListener {
            index++
            question(index)
            radioGroup.clearCheck()
        }


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