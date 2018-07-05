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


    boolean qOneOpOne;
    boolean qOneOpTwo;
    boolean qOneOpThree;
    boolean qOneOpFour;
    boolean qTwoOpOne = false;
    boolean qTwoOpTwo = false;
    boolean qTwoOpThree = false;
    boolean qTwoOpFour =false;
    boolean qThree;
    boolean qFourOpOne;
    boolean qFourOpTwo;
    boolean qFourOpThree;
    boolean qFourOpFour;

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
                    qOneOpOne = true;
                    qOneOpTwo = false;
                    qOneOpThree = false;
                    qOneOpFour = false;
                }
                break;
            case R.id.qOneOptionTwo:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = true;
                    qOneOpThree = false;
                    qOneOpFour = false;
                }
                break;
            case R.id.qOneOptionThree:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = false;
                    qOneOpThree = true;
                    qOneOpFour = false;
                }
                break;

            case R.id.qOneOptionFour:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = false;
                    qOneOpThree = false;
                    qOneOpFour = true;
                }
                break;
            case R.id.optionOne:
                if (checked) {
                    qFourOpOne = true;
                    qFourOpTwo = false;
                    qFourOpThree = false;
                    qOneOpFour = false;
                }
                break;
            case R.id.optionTwo:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = true;
                    qFourOpThree = false;
                    qOneOpFour = false;
                }
                break;
            case R.id.optionThree:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = false;
                    qFourOpThree = true;
                }
                break;

            case R.id.optionFour:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = false;
                    qFourOpThree = false;
                    qFourOpFour = true;
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
                    qTwoOpOne = true;
                } else {
                    qTwoOpOne = false;
                }
                break;
            case R.id.twoOptionTwo:
                if (checked) {
                    qTwoOpTwo = true;
                } else {
                    qTwoOpTwo = false;
                }

                break;
            case R.id.twoOptionThree:
                if (checked) {
                    qTwoOpThree = true;
                } else {
                    qTwoOpThree = false;
                }
                break;

            case R.id.twoOptionFour:
                if (checked) {
                    qTwoOpThree = true;
                } else {
                    qTwoOpThree = true;

                    break;
                }
        }

    }

        // On clicking the submit button

    public void submitQuiz(View view) {

        // Calculation of the final score
        // Question One

        if (qOneOpThree)
            finalScore++;

        // Question Two

        if (qTwoOpOne && qTwoOpThree && !qTwoOpTwo)
            finalScore++;

        // Question Three

        EditText questionThree = (EditText) findViewById(R.id.qThree);
        String ansqwerThree = questionThree.getText().toString();
        qThree = ansqwerThree.equals(getString(R.string.questionThree));

        if (qThree)
            finalScore++;

        // Question Four

        if (qFourOpThree)
            finalScore++;

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
                    finalScore = finalScore + 0;
                // Wrong answer means zero point to the score
                break;
            case R.id.twoOptionFive:
                if (checked)
                    finalScore = finalScore + 0;
                // Wrong answer means zero point to the score
                break;
            case R.id.threeOptionFive:
                if (checked)
                    finalScore = finalScore + 1;
                // Right answer add  1 to the score
                break;

            case R.id.fourthOptionFive:
                if (checked)
                    finalScore = finalScore + 0;
                // Wrong answer means zero point to the score
                break;
        }

        // Calculate Result

        String result;
        String win = "Win";
        String improve_score = "Improve Score" ;

        if (finalScore == 5)
            result = win;
        else
            result = "Your Final Score is " + finalScore + " improve your score";

        // Display Results

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, result, duration);
        toast.show();

        // Reset Score

        finalScore = 0;
    }



}