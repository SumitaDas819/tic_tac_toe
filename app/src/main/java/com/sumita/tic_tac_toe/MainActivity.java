package com.sumita.tic_tac_toe;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, restart,enterbutton;
    EditText edtx;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0, count = 0;
    String get_form_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findid();
        disablebtn();
        Toast.makeText(this, "Select your options to start the game", Toast.LENGTH_SHORT).show();
        restart = findViewById(R.id.btnrestart);
        enterbutton=findViewById(R.id.btnent);
        edtx=findViewById(R.id.edttext);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });
        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_form_edittext=edtx.getText().toString();

                if(get_form_edittext.equals("o")){
                    flag=1;
                    enable_button();


                }
                else if(get_form_edittext.equals("x"))
                {
                    flag=0;
                    enable_button();


                }else{
                    Toast.makeText(MainActivity.this, "Enter the right options", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void findid() {
//        this method is for find the id of evey reference variable
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
    public void enable_button(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    public void restart() {
        count = 0;
        flag=0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        disablebtn();
        Toast.makeText(this, "Select your options to start the game", Toast.LENGTH_LONG).show();
    }
    public void buttoninitialization(){
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();
    }
    public void disablebtn(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    public void check(View v) {
        //this method is for checking the action of the button
        AppCompatButton btncurrent = (AppCompatButton) v;

        if (btncurrent.getText().toString().equals("")) {
            buttoninitialization();
            count++;
            if (flag == 0) {
                btncurrent.setText("X");
                flag = 1;
            } else {
                btncurrent.setText("O");
                flag = 0;
            }
            if (count > 4) {
                //after 4th move there is a chance to wining
                //check condition
                //horinzontal conditions
                buttoninitialization();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    //1
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);


                } else if (b4.equals(b5) && b5.equals(b6) && !b6.equals("")) {
                    Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);

                    //2
                } else if (b7.equals(b8) && b8.equals(b9) && !b9.equals("")) {
                    Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);

                    //3
                }
                //vartical conditions
                else if (b1.equals(b4) && b4.equals(b7) && !b4.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);

                    //4
                } else if (b2.equals(b5) && b5.equals(b8) && !b8.equals("")) {
                    Toast.makeText(this, "Winner is " + b5, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);
                    //5
                } else if (b3.equals(b6) && b6.equals(b9) && !b9.equals("")) {
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);
                    //6
                }
                //Dioganal right
                else if (b1.equals(b5) && (b5.equals(b9) && !b9.equals(""))) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);
                    //7
                }
                //Dioganal left
                else if (b3.equals(b5) && b5.equals(b7) && !b7.equals("")) {
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_LONG).show();
                    disablebtn();
                    edtx.setText(null);

                } else if (count == 9) {
                    Toast.makeText(this, "Match draw", Toast.LENGTH_SHORT).show();
                    disablebtn();
                    edtx.setText(null);
                }

            }

        }

    }
}