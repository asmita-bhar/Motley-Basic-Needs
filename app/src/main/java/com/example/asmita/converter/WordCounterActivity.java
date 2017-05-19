package com.example.asmita.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WordCounterActivity extends AppCompatActivity {

    TextView tv1,tv2,output;
    EditText input;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_counter);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        output = (TextView)findViewById(R.id.output);
        input = (EditText)findViewById(R.id.input);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in = input.getText().toString();
                if(in.equals("")) {
                    Toast.makeText(WordCounterActivity.this, "no input!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int count = 1;
                    for(int i=0; i<in.length()-1;i++)
                    {
                        if(in.charAt(i)==' ') {
                            if(Character.isLetter(in.charAt(i+1)))
                                count++;
                        }

                    }
                    output.setText(Integer.toString(count)+"");
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        WordCounterActivity.this.finish();
        Intent intent = new Intent(WordCounterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
