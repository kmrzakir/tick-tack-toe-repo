package com.example.tic_tac_toe_game

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    var turn = 0
    var after_clicks = 0
    var whose_turn = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

    }

    fun btnclick(vi: View) {
        if (turn != 2) {
            after_clicks++
            var clicked_btn = vi as Button
            if (clicked_btn.text.equals("") && turn == 0) {
                clicked_btn.text = "O"
                turn = 1;
            } else if (clicked_btn.text.equals("") && turn == 1) {
                clicked_btn.text = "X"
                turn = 0
            }
            check_turn()
            if (after_clicks >= 5) {
                chech_winner(false)
            }
        }
    }

    fun check_turn() {
        var show_turn_textview = findViewById<TextView>(R.id.show_turn_textview)
        if (whose_turn == 0) {
            show_turn_textview.text = "turn of player X"
            whose_turn = 1
        } else {
            show_turn_textview.text = "turn of player O"
            whose_turn = 0
        }
    }




    fun chech_winner(bool: Boolean) {


        var i = 1;

        if (btn1.text.equals(btn2.text) && btn2.text.equals(btn3.text) && btn1.text != "") {

            Toast.makeText(this, "winner is ${btn1.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn1,"nodraw")
        }
        if (btn4.text.equals(btn5.text) && btn5.text.equals(btn6.text) && btn4.text != "") {
            Toast.makeText(this, "winner is ${btn4.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn4,"nodraw")
        }
        if (btn7.text.equals(btn8.text) && btn8.text.equals(btn9.text) && btn7.text != "") {
            Toast.makeText(this, "winner is ${btn7.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn7,"nodraw")
        }
        if (btn1.text.equals(btn5.text) && btn5.text.equals(btn9.text) && btn1.text != "") {
            Toast.makeText(this, "winner is ${btn1.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn1,"nodraw")
        }
        if (btn3.text.equals(btn5.text) && btn5.text.equals(btn7.text) && btn3.text != "") {
            Toast.makeText(this, "winner is ${btn3.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn3,"nodraw")
        }
        if (btn3.text.equals(btn6.text) && btn6.text.equals(btn9.text) && btn3.text != "") {
            Toast.makeText(this, "winner is ${btn3.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn3,"nodraw")
        }
        if (btn1.text.equals(btn4.text) && btn4.text.equals(btn7.text) && btn1.text != "") {
            Toast.makeText(this, "winner is ${btn1.text}", Toast.LENGTH_SHORT).show()
            turn = 2
            i = 2;
            show_result_in_Dialog(btn1,"nodraw")

        }
        if (!btn1.text.equals("") && !btn2.text.equals("") && !btn3.text.equals("") && !btn4.text.equals("")
            && !btn5.text.equals("") && !btn6.text.equals("") && !btn7.text.equals("") && !btn8.text.equals("") && !btn9.text.equals("") &&  i != 2) {
            Toast.makeText(this, "match draw", Toast.LENGTH_SHORT).show()
            turn = 2
            show_result_in_Dialog(btn1,"draw")
        }
    }
    fun reset_game(view: View) {
        var show_turn_textview = findViewById<TextView>(R.id.show_turn_textview)
        show_turn_textview.text = "lets start the game"
        turn = 0
         after_clicks = 0
         whose_turn = 0
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""
    }
    fun  show_result_in_Dialog(btn: Button,draw: String){
        var inflate = LayoutInflater.from(this)
        var  show_result_in_Dialog = inflate.inflate(R.layout.tic_toe_dialog,null)
        var show_result_textview = show_result_in_Dialog.findViewById<TextView>(R.id.show_result_textview)
        var play_again_button = show_result_in_Dialog.findViewById<Button>(R.id.play_again_button)
        if(draw == "nodraw"){
            show_result_textview.text = "winner is ${btn.text}"
        }else if(draw == "draw"){
            show_result_textview.text = "match is draw"
        }
        var dialog = Dialog(this)
        dialog.setContentView(show_result_in_Dialog)
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
        play_again_button.setOnClickListener {
            reset_game(play_again_button)
            dialog.dismiss()
        }
    }
}
