package com.httpman_bok.instancestate;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
      int score;
    EditText et;
    String etString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        et = (EditText)findViewById(R.id.editText1);
    }

@Override
    protected void onSaveInstanceState (Bundle outState) {
    super.onSaveInstanceState(outState);
    etString = et.getText().toString();

    outState.putString("edittext",etString);
    outState.putInt("score",score);
}

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        et.setText(savedInstanceState.getString("edittext"));
        score = savedInstanceState.getInt("score");
    }

    public void performAction(View v) {
        switch (v.getId()) {
            case R.id.bincrement:
                score += 1;

                break;

            case R.id.bshowValue:

                Toast.makeText(getApplicationContext(), "Your Score is " + score,
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
