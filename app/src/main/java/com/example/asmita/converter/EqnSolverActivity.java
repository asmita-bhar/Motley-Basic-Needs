package com.example.asmita.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EqnSolverActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    EditText input1,input2,input3;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqn_solver);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        tv7 = (TextView)findViewById(R.id.tv7);
        tv8 = (TextView)findViewById(R.id.tv8);
        input1 = (EditText)findViewById(R.id.input1);
        input2 = (EditText)findViewById(R.id.input2);
        input3 = (EditText)findViewById(R.id.input3);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String in1 = input1.getText().toString();
                    String in2 = input2.getText().toString();
                    String in3 = input3.getText().toString();

                    if (in1.equals("") || in2.equals("") || in3.equals("")) {
                        Toast.makeText(EqnSolverActivity.this, "no input", Toast.LENGTH_SHORT).show();
                    } else {
                        float a = Float.parseFloat(in1);
                        float b = Float.parseFloat(in2);
                        float c = Float.parseFloat(in3);
                        float d = b*b - 4*a*c;
                        if(d>=0)
                        {
                            double x1 = (-b + Math.sqrt(d))/(2*a);
                            double x2 = (-b - Math.sqrt(d))/(2*a);
                            tv7.setText(Double.toString(x1)+"");
                            tv8.setText(Double.toString(x2)+"");

                        }
                        else
                        {
                            d = Math.abs(d);
                            double s = Math.sqrt(d);
                            b = -b;
                            float div = 2*a;
                            String x1 = Float.toString(b);
                            x1 = "(" + x1 + "+ " + Double.toString(s) + "i)/" + Float.toString(div);
                            String x2 = Float.toString(b);
                            x2 = "(" + x2 + "- " + Double.toString(s) + "i)/" + Float.toString(div);
                            tv7.setText(x1+"");
                            tv8.setText(x2+"");
                        }

                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(EqnSolverActivity.this, "invalid input!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        EqnSolverActivity.this.finish();
        Intent intent = new Intent(EqnSolverActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
