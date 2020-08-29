package com.example.simplestcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //Local variables for buttons, text field and math operations
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonDot, buttonClear, buttonDel, buttonPlus, buttonMinus,
            buttonDivide, buttonMultiply, buttonEqual;
    EditText EditTextField;
    Double Result=0.0, Number1=0.0, Number2=0.0;
    Boolean mathIsChosen = false;
    Boolean buttonEqualPressed = false;
    int NegativeNumberInput = 0;
    String chosenMath = "";
    String EditTextFieldContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting variable for TextField where all input numbers are shown
        final TextView EditTextField = findViewById(R.id.TextField);

        //Displaying typed numeric buttons
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "1");
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "2");
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "3");
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "4");
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "5");
            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "6");
            }
        });
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "7");
            }
        });
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "8");
            }
        });
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "9");
            }
        });
        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + "0");
            }
        });
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextField.setText(EditTextField.getText() + ".");
            }
        });

        //Mathematical operations
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NegativeNumberInput = NegativeNumberInput + 1;
                // conditions for minus button presses. Deals with operation like X*(-Y)
                if ((NegativeNumberInput == 1) && ((EditTextField.getText()+"").equals(""))){
                    EditTextField.setText("");
                    EditTextField.setText(EditTextField.getText() + "-");
                    NegativeNumberInput = NegativeNumberInput + 1;
                }
                if ((NegativeNumberInput == 1) && (!(EditTextField.getText()+"").equals(""))){
                    EditTextFieldContent = EditTextField.getText()+"";
                    if (!(EditTextField.getText()+"").equals("-"))
                    {Number1 = Double.parseDouble(EditTextFieldContent);}
                    else {Number1 = 0.0;}
                    EditTextField.setText("");
                    NegativeNumberInput = NegativeNumberInput + 1;
                    mathIsChosen = true;
                    chosenMath = "Minus";
                    //−
                }
                if ((mathIsChosen == false) && (NegativeNumberInput == 3)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    Number1 = Double.parseDouble(EditTextFieldContent);
                    EditTextField.setText("");
                    NegativeNumberInput = 4;
                    mathIsChosen = true;
                    chosenMath = "Minus";
                }
                if ((mathIsChosen == true) && (NegativeNumberInput == 3)) {
                    EditTextField.setText("");
                    EditTextField.setText(EditTextField.getText() + "-");
                    NegativeNumberInput = 4;
                    mathIsChosen = true;
                }
                if ((mathIsChosen == true) && (NegativeNumberInput == 1)) {
                    if (!(EditTextField.getText()+"").equals("-"))
                    {Number1 = -1*Double.parseDouble(EditTextFieldContent);}
                    EditTextField.setText("");
                    NegativeNumberInput = 4;
                    mathIsChosen = true;
                }
            }
        });
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dealing with numbers above zero
                if ((mathIsChosen == false) && (NegativeNumberInput == 0)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    if ((EditTextField.getText()+"") != "") {Number1 = Double.parseDouble(EditTextFieldContent);}
                    EditTextField.setText("");
                }
                //Dealing with numbers below zero
                if ((mathIsChosen == false) && (NegativeNumberInput == 2)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    String temp=EditTextFieldContent.substring(1,EditTextFieldContent.length());
                    if ((EditTextField.getText()+"") != "") {Number1 = -1*Double.parseDouble(temp);}
                    EditTextField.setText("");
                }
                //  Toast myToast = Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG); myToast.show();
                //Dealing with pressed math operation button and no input number
                if (((EditTextField.getText()+"") == "") && (mathIsChosen == true)) {
                    Toast myToast = Toast.makeText(getApplicationContext(), "No number. Press C", Toast.LENGTH_SHORT); myToast.show();
                    Number1 = 0.0;
                }
                mathIsChosen = true;
                chosenMath = "Plus";
            }
        });
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((mathIsChosen == false) && (NegativeNumberInput == 0)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    if ((EditTextField.getText()+"") != "") {Number1 = Double.parseDouble(EditTextFieldContent);}
                    EditTextField.setText("");
                }
                if ((mathIsChosen == false) && (NegativeNumberInput == 2)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    String temp=EditTextFieldContent.substring(1,EditTextFieldContent.length());
                    if ((EditTextField.getText()+"") != "") {Number1 = -1*Double.parseDouble(temp);}
                    EditTextField.setText("");
                }
                if (((EditTextField.getText()+"") == "") && (mathIsChosen == true)) {
                    Toast myToast = Toast.makeText(getApplicationContext(), "No number. Press C", Toast.LENGTH_SHORT); myToast.show();
                    Number1 = 0.0;
                }
                mathIsChosen = true;
                chosenMath = "Multiply";
            }
        });
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((mathIsChosen == false) && (NegativeNumberInput == 0)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    if ((EditTextField.getText()+"") != ""){Number1 = Double.parseDouble(EditTextFieldContent);}
                    EditTextField.setText("");
                }
                if ((mathIsChosen == false) && (NegativeNumberInput == 2)) {
                    EditTextFieldContent = EditTextField.getText()+"";
                    String temp=EditTextFieldContent.substring(1,EditTextFieldContent.length());
                    if ((EditTextField.getText()+"") != ""){Number1 = -1*Double.parseDouble(temp);}
                    EditTextField.setText("");
                }
                if (((EditTextField.getText()+"") == "") && (mathIsChosen == true)) {
                    Toast myToast = Toast.makeText(getApplicationContext(), "No number. Press C", Toast.LENGTH_SHORT); myToast.show();
                    Number1 = 0.0;
                }
                mathIsChosen = true;
                chosenMath = "Divide";
            }
        });
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number1 = 0.0;
                Number2 = 0.0;
                Result = 0.0;
                EditTextField.setText("");
                EditTextFieldContent = "";
                mathIsChosen = false;
                buttonEqualPressed = false;
                chosenMath = "";
                NegativeNumberInput = 0;
            }
        });
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonEqualPressed == false) { //Checking if symbols are erased before calculations made
                    EditTextFieldContent = EditTextField.getText() + "";
                    if (EditTextFieldContent.length() > 1) {
                        //Erase last symbol in input number
                        String temp = EditTextFieldContent.substring(0, EditTextFieldContent.length() - 1);
                        EditTextField.setText(temp + "");
                    }
                    if (EditTextFieldContent.length() == 1) {
                        //Full screen clear
                        EditTextField.setText("");
                    }
                }
                else {
                    Toast myToast = Toast.makeText(getApplicationContext(), "Press C", Toast.LENGTH_SHORT); myToast.show();
                }
            }
        });



        //Performing math operation after Equal button pressed
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((buttonEqualPressed == false) && (mathIsChosen == true)) {
                    String Number2String = EditTextField.getText()+"";
                    //Dealing with no input of Number2
                    if (Number2String.equals("")){
                        Toast myToast = Toast.makeText(getApplicationContext(), "Missing a number. Press C", Toast.LENGTH_SHORT); myToast.show();
                        Number2 = 0.0;
                    }
                    else {
                        //String temp=EditTextFieldContent.substring(1,EditTextFieldContent.length());
                        if ((Number2String.substring (0,0).equals("-"))){
                            Number2 = Double.parseDouble(Number2String.substring(1,Number2String.length()));}
                        else {
                            Number2 = Double.parseDouble(Number2String);}
                        //Number2 = Double.parseDouble(EditTextField.getText() + "");
                    }
                    //Clearing screen
                    EditTextField.setText("");
                    //Conducting chosen math operation
                    if ((buttonEqualPressed == false) && (chosenMath == "Plus")){
                            Result = Number1 + Number2;
                            EditTextField.setText(EditTextFieldContent+"+"+Number2String+"="+Result.toString() + "");
                    }
                    if ((buttonEqualPressed == false) && (chosenMath == "Minus")){
                        Result = Number1 - Number2;
                        EditTextField.setText(EditTextFieldContent+"−"+Number2String+"="+Result.toString() + "");
                    }
                    if ((buttonEqualPressed == false) && (chosenMath == "Multiply")){
                        Result = Number1 * Number2;
                        EditTextField.setText(EditTextFieldContent+"×"+Number2String+"="+Result.toString() + "");
                    }
                    if ((buttonEqualPressed == false) && (chosenMath == "Divide")){
                        if (Number2 !=0) {
                            Result = Number1 / Number2;
                            EditTextField.setText(EditTextFieldContent+"÷"+Number2String+"="+Result.toString() + "");
                        }
                        else {
                            EditTextField.setText("Division by zero");
                        };
                    }
                }
                buttonEqualPressed = true;
            }
        });


    }
}