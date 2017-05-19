package com.example.asmita.converter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class devActivity extends AppCompatActivity {

    ImageView img;
    TextView tv, bio, git, rate, sign;
    Button submit;
    RatingBar rbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        img = (ImageView)findViewById(R.id.me);
        tv = (TextView)findViewById(R.id.aboutMe);
        bio = (TextView)findViewById(R.id.bio);
        git = (TextView)findViewById(R.id.git);
        rate = (TextView)findViewById(R.id.rateApp);
        submit = (Button)findViewById(R.id.submit);
        rbar = (RatingBar)findViewById(R.id.rate);
        sign = (TextView)findViewById(R.id.sign);

        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/asmita-bhar")));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(rbar.getRating());
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("asmita.nitd@gmail.com"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"asmita.nitd@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Rating");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Rating of the user : "+s);
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail"));
                    finish();
                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(devActivity.this, "There is no email client installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(devActivity.this, MainActivity.class));
        devActivity.this.finish();
    }

}
