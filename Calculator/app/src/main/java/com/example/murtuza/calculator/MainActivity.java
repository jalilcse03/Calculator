package com.example.murtuza.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView showRsult;
    Character operator = ' ';

    String inp1 = "", inp2 = "", input_temp = "";
    int firstInputComplete = 0, operatorDoubleClick = 0, point_flag = 0, isEqulalPress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showRsult = (TextView) findViewById(R.id.showResult);

    }

    public void btn7Clicked(View view) {
        insertNum('7');
    }

    public void btn8Clicked(View view) {
        insertNum('8');
    }

    public void btn9Clicked(View view) {
        insertNum('9');
    }

    public void btn4Clicked(View view) {
        insertNum('4');
    }

    public void btn5Clicked(View view) {
        insertNum('5');
    }

    public void btn6Clicked(View view) {
        insertNum('6');
    }

    public void btn1Clicked(View view) {
        insertNum('1');
    }

    public void btn2Clicked(View view) {
        insertNum('2');
    }

    public void btn3Clicked(View view) {
        insertNum('3');
    }

    public void btn0Clicked(View view) {
        if (input_temp.equals("0") || input_temp.equals("")) {
            input_temp = "0";
            showRsult.setText("0");
        } else
            insertNum('0');
    }

    public void btnPoint(View view) {
        if (point_flag == 0) {
            point_flag = 1;
            insertNum('.');
        }

    }

    public void btnOff(View view) {
        finish();
        System.exit(0);
    }

    public void btnClearClicked(View view) {
        point_flag = 0;
        firstInputComplete = 0;
        input_temp = "";
        inp1 = inp2 = "";
        operatorDoubleClick = 0;
        isEqulalPress = 0;
        operator = ' ';
        showRsult.setText("");

    }

    public void btnMutiply(View view) {
        isEqulalPress = 0;
        if (operatorDoubleClick == 1 && operator != '*')
            operator = '*';
        else {
            operation();
            operator = '*';
        }
    }

    public void btnPlusClicked(View view) {
        isEqulalPress = 0;
        if (operatorDoubleClick == 1 && operator == '+')
            ;
        else if (operatorDoubleClick == 1)
            operator = '+';
        else {
            operation();
            operator = '+';
        }
    }

    public void btnMinusClicked(View view) {
        isEqulalPress = 0;
        if (operatorDoubleClick == 1 && operator != '-')
            operator = '-';
        else {
            operation();
            operator = '-';
        }

    }

    public void btnDivideClicked(View view) {
        isEqulalPress = 0;
        if (operatorDoubleClick == 1 && operator != '/')
            operator = '/';
        else {
            operation();
            operator = '/';
        }
    }

    public void btnBack(View view) {
        int len;
        if (input_temp.length() > 0) {
            len = input_temp.length() - 1;
            if (input_temp.charAt(len) == '.')
                point_flag = 0;
            input_temp = input_temp.substring(0, len);
            showRsult.setText(input_temp);
        } else if (inp1.length() > 0) {
            len = inp1.length() - 1;
            if (inp1.charAt(len) == '.')
                point_flag = 0;
            input_temp = inp1.substring(0, len);
            showRsult.setText(input_temp);
        } else
            Toast.makeText(MainActivity.this, "Input Empty", Toast.LENGTH_SHORT).show();
        inp2 = "";
        operator = ' ';
    }

    public void btnSqr(View view) {

        if (input_temp.length() > 0 || inp1.length() > 0) {
            isEqulalPress = 0;
            double sqrt = 0;
            if (input_temp.length() > 0)
                sqrt = Math.sqrt(Double.parseDouble(input_temp));
            else
                sqrt = Math.sqrt(Double.parseDouble(inp1));

            String result = String.valueOf(sqrt);
            if (result.length() > 15)
                result = result.substring(0, 15);

            showRsult.setText(result);
            inp1 = result;
            input_temp = "";

        }
    }


    public void btnEqualClicked(View view) {

        point_flag = 0;
        operatorDoubleClick = 0;
        if (operator == ' ') {
            if (input_temp.length() > 0)
                inp1 = input_temp;

            input_temp = "";
            showRsult.setText(inp1);
        } else {
            if (input_temp.length() > 0)
                inp2 = input_temp;
            double number = 0;
            switch (operator) {
                case '+':
                    number = Double.parseDouble(inp1) + Double.parseDouble(inp2);
                    break;
                case '-':
                    number = Double.parseDouble(inp1) - Double.parseDouble(inp2);
                    break;
                case '*':
                    number = Double.parseDouble(inp1) * Double.parseDouble(inp2);
                    break;
                case '/':
                    number = Double.parseDouble(inp1) / Double.parseDouble(inp2);
                    break;
                case '%':
                    number = Double.parseDouble(inp1) % Double.parseDouble(inp2);
                    break;


            }

            String result = String.valueOf(number);
            if (result.length() > 15)
                result = result.substring(0, 15);

            showRsult.setText(result);
            inp1 = result;
            input_temp = "";
            isEqulalPress = 1;


        }
    }

    private void insertNum(char in) {

        if (input_temp.length() > 14) {
            Toast.makeText(MainActivity.this, "Maximum number of digits(15) exceeded", Toast.LENGTH_SHORT).show();
        } else {
            if (isEqulalPress == 1) {
                operator = ' ';
                isEqulalPress = 0;
            }
            input_temp = input_temp + in;
            showRsult.setText(input_temp);
        }
    }

    private void operation() {
        if (input_temp.length() > 0) {
            inp1 = input_temp;
            input_temp = "";
            operatorDoubleClick = 1;
        }
    }

}
