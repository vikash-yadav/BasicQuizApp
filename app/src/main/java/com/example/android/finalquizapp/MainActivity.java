package com.example.android.finalquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    // Declaration/Initialization of variables

    int finalScore = 0;

    boolean ansOne;

    boolean ansTwoOne;
    boolean ansTwoTwo;
    boolean ansTwoThree;
    boolean ansTwoFour;

    boolean ansFour;
    boolean ansFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Radio Button Method
    public void onButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.qOneOptionOne:
                if (checked) {
                    ansOne = false;
                }
                break;
            case R.id.qOneOptionTwo:
                if (checked) {
                    ansOne = false;
                }
                break;
            case R.id.qOneOptionThree:
                if (checked) {
                    ansOne = true;
                }
                break;

            case R.id.qOneOptionFour:
                if (checked) {
                    ansOne = false;
                }
                break;
            case R.id.optionOne:
                if (checked) {
                    ansFour = false;
                }
                break;
            case R.id.optionTwo:
                if (checked) {
                    ansFour = false;
                }
                break;
            case R.id.optionThree:
                if (checked) {
                    ansFour = true;
                }
                break;

            case R.id.optionFour:
                if (checked) {
                    ansFour = false;
                }
                break;
        }
    }

    // For CheckBoxes
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.twoOptionOne:
                if (checked) {
                    ansTwoOne = true;
                } else {
                    ansTwoOne = false;
                }
                break;
            case R.id.twoOptionTwo:
                if (checked) {
                    ansTwoTwo = true;
                } else {
                    ansTwoTwo = false;
                }

                break;
            case R.id.twoOptionThree:
                if (checked) {
                    ansTwoThree = true;
                } else {
                    ansTwoThree = false;
                }
                break;

            case R.id.twoOptionFour:
                if (checked) {
                    ansTwoFour = true;
                } else {
                    ansTwoFour = false;
                }
                break;

        }

    }

    // On clicking the submit button

    public void submitQuiz(View view) {

        // Calculation of the final score
        // Question One
        if (ansOne)
            finalScore++;

        // Question Two
        if (ansTwoOne && ansTwoTwo && ansTwoThree && !ansTwoFour)
            finalScore++;

        // Question Three
        // EditText If the answered typed is equal to the right answer, it means one point more to the finalScore
        EditText qThree = findViewById(R.id.qThree);
        String questionAnswer = qThree.getText().toString();
        if (questionAnswer.equalsIgnoreCase("ENGLAND")) {
            finalScore++;
        }

        //Question Four
        if (ansFour)
            finalScore++;

        //Question Four
        if (ansFive)
            finalScore++;


// Calculate Result

        String result;
        String win = "Win";


        if (finalScore == 5)
            result = win;
        else
            result = "Your Final Score is " + finalScore + " improve your score";

        // Display Results

        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

        // Reset Score

        finalScore = 0;


    }

    /**
     * Radio button of question five
     * Calculates the score depending on right or wrong button checked
     */
    public void onRadioButtonQuestionFiveClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.oneOptionFive:
                if (checked)
                    ansFive = false;
                // Wrong answer means zero point to the score
                break;
            case R.id.twoOptionFive:
                if (checked)
                    ansFive = false;
                // Wrong answer means zero point to the score
                break;
            case R.id.threeOptionFive:
                if (checked)
                    ansFive = true;
                // Right answer add  1 to the score
                break;

            case R.id.fourthOptionFive:
                if (checked)
                    ansFive = false;
                // Wrong answer means zero point to the score
                break;
        }


    }


}