package com.osproject.WC18_Quick_Quiz;

public class TrueFalse {
    private int mQuestionID;
    private boolean mAnswer;

    public TrueFalse(int QuestionResourceID,boolean trueFalse)
    {
        mQuestionID = QuestionResourceID;
        mAnswer = trueFalse;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }


}
