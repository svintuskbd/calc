package com.example.oleg.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    EditText action;
    Button send;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        action = (EditText) findViewById(R.id.action_calc);
        send = (Button) findViewById(R.id.send);
        layout = (RelativeLayout) findViewById(R.id.activity_main);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action.setCursorVisible(true);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action.getText().toString().isEmpty()) {
                    action.setText(R.string.empty_error);

                    return;
                }

                action.setText(calc(action.getText().toString()));
            }
        });
    }

    protected String calc(String action) {
        if (action.contains("+")) {
            return calculatePlus(action, "\\+");
        } else if (action.contains("-")) {
            return calculateMinus(action, "\\-");
        } else if (action.contains("*")) {
            return calculateMultiply(action, "\\*");
        } else if (action.contains("/")) {
            return calculateDivided(action, "\\/");
        }

        return "Error action";
    }

    private String calculateDivided(String actionString, String actionPattern) {
        String[] array = actionString.split(actionPattern, -1);
        if (array.length > 0) {
            if (Integer.parseInt(array[1]) <= 0) {
                return "Error";
            }

            int res = Integer.parseInt(array[0]) / Integer.parseInt(array[1]);

            return Integer.toString(res);
        }

        return "Error!";
    }

    private String calculateMultiply(String actionString, String actionPattern) {
        String[] array = actionString.split(actionPattern, -1);
        if (array.length > 0) {
            int res = Integer.parseInt(array[0]) * Integer.parseInt(array[1]);

            return Integer.toString(res);
        }

        return "Error!";
    }

    private String calculatePlus(String actionString, String actionPattern) {
        String[] array = actionString.split(actionPattern, -1);
        if (array.length > 0) {
            int res = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);

            return Integer.toString(res);
        }

        return "Error!";
    }

    private String calculateMinus(String actionString, String actionPattern) {
        String[] array = actionString.split(actionPattern, -1);
        if (array.length > 0) {
            int res = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);

            return Integer.toString(res);
        }

        return "Error!";
    }
}
