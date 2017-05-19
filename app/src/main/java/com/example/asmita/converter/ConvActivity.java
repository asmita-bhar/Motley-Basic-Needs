package com.example.asmita.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConvActivity extends AppCompatActivity {

    TextView tvb,tvd,tvo,tvh;
    EditText tvbi,tvdi,tvoi,tvhi;
    Button submit,clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv);

        tvb = (TextView)findViewById(R.id.tvb);
        tvbi = (EditText)findViewById(R.id.tvbi);
        tvd = (TextView)findViewById(R.id.tvd);
        tvdi = (EditText)findViewById(R.id.tvdi);
        tvo = (TextView)findViewById(R.id.tvo);
        tvoi = (EditText)findViewById(R.id.tvoi);
        tvh = (TextView)findViewById(R.id.tvh);
        tvhi = (EditText)findViewById(R.id.tvhi);

        submit = (Button)findViewById(R.id.submit);
        clear = (Button)findViewById(R.id.clear);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String binary = tvbi.getText().toString();
                    String decimal = tvdi.getText().toString();
                    String octal = tvoi.getText().toString();
                    String hexa = tvhi.getText().toString();

                    if (binary.equals("") && decimal.equals("") && octal.equals("") && hexa.equals("")) {
                        Toast.makeText(ConvActivity.this, "no input!", Toast.LENGTH_SHORT).show();
                    } else {

                        if (!binary.equals("")) {
                            if (!decimal.equals("") || !octal.equals("") || !hexa.equals("")) {
                                Toast.makeText(ConvActivity.this, "more than one input!", Toast.LENGTH_SHORT).show();
                                tvbi.setText("");
                                tvdi.setText("");
                                tvoi.setText("");
                                tvhi.setText("");
                            } else {
                                int  d = Integer.parseInt(binary, 2);
                                tvdi.setText(Integer.toString(d) + "");
                                tvoi.setText(Integer.toOctalString(d) + "");
                                tvhi.setText(Integer.toHexString(d) + "");
                            }
                        } else if (!decimal.equals("")) {
                            if (!binary.equals("") || !octal.equals("") || !hexa.equals("")) {
                                Toast.makeText(ConvActivity.this, "more than one input!", Toast.LENGTH_SHORT).show();
                                tvbi.setText("");
                                tvdi.setText("");
                                tvoi.setText("");
                                tvhi.setText("");
                            } else {
                                int d = Integer.parseInt(decimal);
                                tvbi.setText(Integer.toBinaryString(d) + "");
                                tvoi.setText(Integer.toOctalString(d) + "");
                                tvhi.setText(Integer.toHexString(d) + "");
                            }
                        } else if (!octal.equals("")) {
                            if (!binary.equals("") || !decimal.equals("") || !hexa.equals("")) {
                                Toast.makeText(ConvActivity.this, "more than one input!", Toast.LENGTH_SHORT).show();
                                tvbi.setText("");
                                tvdi.setText("");
                                tvoi.setText("");
                                tvhi.setText("");
                            } else {
                                int d = Integer.parseInt(octal, 8);
                                tvbi.setText(Integer.toBinaryString(d) + "");
                                tvdi.setText(Integer.toString(d) + "");
                                tvhi.setText(Integer.toHexString(d) + "");

                            }
                        } else {
                            if (!binary.equals("") || !decimal.equals("") || !octal.equals("")) {
                                Toast.makeText(ConvActivity.this, "more than one input!", Toast.LENGTH_SHORT).show();
                                tvbi.setText("");
                                tvdi.setText("");
                                tvoi.setText("");
                                tvhi.setText("");
                            } else {

                                int d = Integer.parseInt(hexa, 16);
                                tvbi.setText(Integer.toBinaryString(d) + "");
                                tvdi.setText(Integer.toString(d) + "");
                                tvoi.setText(Integer.toOctalString(d) + "");

                            }
                        }
                    }

                }
                catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(ConvActivity.this, "invalid input!", Toast.LENGTH_SHORT).show();
                }
            }


        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvbi.setText("");
                tvdi.setText("");
                tvoi.setText("");
                tvhi.setText("");
            }
        });
    }

    @Override
    public void onBackPressed() {
        ConvActivity.this.finish();
        Intent intent = new Intent(ConvActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
