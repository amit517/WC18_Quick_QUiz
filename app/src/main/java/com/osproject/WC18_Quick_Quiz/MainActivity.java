package com.osproject.WC18_Quick_Quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


        Button mTrueButton;
        Button mFalseButton;
        TextView mQuestionTextview;

        int mIndex;
        int mQuestion;
        int mScore;
        ProgressBar mProgressBar;
        TextView mScoreTextview;




    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1,true ),
            new TrueFalse(R.string.question_2,false ),
            new TrueFalse(R.string.question_3,false ),
            new TrueFalse(R.string.question_4,true ),
            new TrueFalse(R.string.question_5,true ),
            new TrueFalse(R.string.question_6,false ),
            new TrueFalse(R.string.question_7,true ),
            new TrueFalse(R.string.question_8,true ),
            new TrueFalse(R.string.question_9,true ),
            new TrueFalse(R.string.question_10,false ),
            new TrueFalse(R.string.question_11,false ),
            new TrueFalse(R.string.question_12,true ),
            new TrueFalse(R.string.question_13,false ),
            new TrueFalse(R.string.question_14,true ),
            new TrueFalse(R.string.question_15,false ),
            new TrueFalse(R.string.question_16,true ),
            new TrueFalse(R.string.question_17,true ),
            new TrueFalse(R.string.question_18,false ),
            new TrueFalse(R.string.question_19,true ),
            new TrueFalse(R.string.question_20,false ),
            new TrueFalse(R.string.question_21,true ),
            new TrueFalse(R.string.question_22,false ),
            new TrueFalse(R.string.question_23,false ),
            new TrueFalse(R.string.question_24,false ),
            new TrueFalse(R.string.question_25,false ),
            new TrueFalse(R.string.question_26,true ),
            new TrueFalse(R.string.question_27,false ),
            new TrueFalse(R.string.question_28,false ),
            new TrueFalse(R.string.question_29,true ),
            new TrueFalse(R.string.question_30,false ),
            new TrueFalse(R.string.question_31,false ),
            new TrueFalse(R.string.question_32,true ),
            new TrueFalse(R.string.question_33,true ),
            new TrueFalse(R.string.question_34,true ),
            new TrueFalse(R.string.question_35,true ),
            new TrueFalse(R.string.question_36,true ),
            new TrueFalse(R.string.question_37,false ),
            new TrueFalse(R.string.question_38,false ),
            new TrueFalse(R.string.question_39,true ),
            new TrueFalse(R.string.question_40,true ),
            new TrueFalse(R.string.question_41,false ),
            new TrueFalse(R.string.question_42,true ),
            new TrueFalse(R.string.question_43,false ),
            new TrueFalse(R.string.question_44,false ),
            new TrueFalse(R.string.question_45,true ),
            new TrueFalse(R.string.question_46,false ),
            new TrueFalse(R.string.question_47,false ),
            new TrueFalse(R.string.question_48,true ),
            new TrueFalse(R.string.question_49,true ),
            new TrueFalse(R.string.question_50,true ),
    };

    final int Progress_Bar_Increment =(int) Math.ceil(100.0/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            mScore = savedInstanceState.getInt("ScoreKey");
            mIndex = savedInstanceState.getInt("IndexKey");

        }
        else
        {
            mScore= 0;
            mIndex= 0;
        }

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextview=(TextView)findViewById(R.id.question_text_view);

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextview.setText(mQuestion);

        mProgressBar =(ProgressBar) findViewById(R.id.progress_bar);
        mScoreTextview= (TextView) findViewById(R.id.score);
        mScoreTextview.setText("Score "+mScore+"/"+mQuestionBank.length);
        //updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
                updateQuestion();



            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();

            }
        });


    }

    private void updateQuestion()
    {
        mIndex = (mIndex + 1) % mQuestionBank.length;

        if(mIndex == 0)
        {
            AlertDialog.Builder alart = new AlertDialog.Builder(this);
            alart.setTitle("Game Over");
            alart.setCancelable(false);
            alart.setMessage("You scored "+mScore+" points");
            alart.setPositiveButton("CLose Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alart.show();
        }



        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextview.setText(mQuestion);
        mProgressBar.incrementProgressBy(Progress_Bar_Increment);
        mScoreTextview.setText("Score "+mScore+"/"+mQuestionBank.length);
    }

    private void checkAnswer(boolean userSelection)
    {
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();
        if (correctAnswer == userSelection)
        {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mScore+=1;

        }
        else
        {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey", mScore);
        outState.putInt("Indexkey",mIndex );
    }




}
