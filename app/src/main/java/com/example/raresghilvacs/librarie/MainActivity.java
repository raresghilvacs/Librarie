package com.example.raresghilvacs.librarie;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private HistoryBook mHistoryFact = new HistoryBook();
    private BkgColor mColor = new BkgColor();
    private TextView mFactTextView;
    private EditText newFact;
    private Button mNextFactButton,mDeleteFactButton,mPrevFactButton,mAddFactButton,mEditFactButton,mSaveNewFact, mEditFactConfirmButton;
    private RelativeLayout mRelativeLayout;
    //private ToggleButton mShowOption;
    int numberIndex = 0;
    String fact = mHistoryFact.getFactByIndex(numberIndex);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mFactTextView.setText(fact);
        mNextFactButton = (Button) findViewById(R.id.showFactButton);
        mPrevFactButton = (Button) findViewById(R.id.prevFactButton);
        mSaveNewFact = (Button) findViewById(R.id.mSaveNewFact);
        mDeleteFactButton = (Button) findViewById(R.id.deleteFactButton);
        mAddFactButton = (Button) findViewById(R.id.addFactButton);
        mEditFactButton = (Button) findViewById(R.id.editFactButton);
        mEditFactConfirmButton = (Button) findViewById(R.id.editFactConfirmButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        newFact = (EditText) findViewById(R.id.newFact);
//      for next



        View.OnClickListener next_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIndex++;
                fact = mHistoryFact.getFactByIndex(numberIndex);
                if (fact!=null){
                    int color = mColor.getColor();

                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
                } else {
                    numberIndex=0;
                    fact = mHistoryFact.getFactByIndex(numberIndex);
                    int color = mColor.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
                }
            }
        };
//      for prev
        View.OnClickListener prev_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIndex--;
                fact = mHistoryFact.getFactByIndex(numberIndex);
                if (fact!=null){
                    int color = mColor.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
                } else {
                    numberIndex=mHistoryFact.getFacts().length-1;
                    fact = mHistoryFact.getFactByIndex(numberIndex);
                    int color = mColor.getColor();
                    mFactTextView.setText(fact);
                    mRelativeLayout.setBackgroundColor(color);
//                    mNextFactButton.setTextColor(color);
                }
            }
        };

//      for delete
        View.OnClickListener listener_delete = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHistoryFact.removeElements(fact);
                fact = mHistoryFact.getFactByIndex(numberIndex);
                if (fact!=null) {
                    mFactTextView.setText(fact);
                } else {
                    fact=mHistoryFact.getFactByIndex(0);
                    mFactTextView.setText(fact);
                }
                int color = mColor.getColor();
                mRelativeLayout.setBackgroundColor(color);
                mDeleteFactButton.setTextColor(color);
            }
        };

        //      for add
        View.OnClickListener listener_add = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibilityForHide();
                newFact.setVisibility(View.VISIBLE);
                newFact.setText(null);
                mSaveNewFact.setVisibility(View.VISIBLE);
            }
        };

        //      for add a new fACT
        View.OnClickListener listener_add_fact = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFactText= newFact.getText().toString();
                mHistoryFact.addElement(newFactText);
                numberIndex++;
                fact = mHistoryFact.getFactByIndex(numberIndex);
                mFactTextView.setText( newFactText);
                setVisibilityForShow();
                newFact.setVisibility(View.INVISIBLE);
                mSaveNewFact.setVisibility(View.INVISIBLE);

            }
        };

        //      for edit
        View.OnClickListener listener_edit= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibilityForHide();
                newFact.setVisibility(View.VISIBLE);
                newFact.setText(fact);
                mEditFactConfirmButton.setVisibility(View.VISIBLE);
                mSaveNewFact.setVisibility(View.INVISIBLE);
            }
        };


        //      for edit a  fact
        View.OnClickListener listener_edit_fact_confirm_button = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editFactText= newFact.getText().toString();
                String[] allFacts=mHistoryFact.editFact(numberIndex,editFactText);
                mFactTextView.setText(editFactText);
                setVisibilityForShow();
                newFact.setVisibility(View.INVISIBLE);
                mEditFactConfirmButton.setVisibility(View.INVISIBLE);
            }
        };

        mNextFactButton.setOnClickListener(next_listener);
        mPrevFactButton.setOnClickListener(prev_listener);
        mDeleteFactButton.setOnClickListener(listener_delete);
        mAddFactButton.setOnClickListener(listener_add);
        mEditFactButton.setOnClickListener(listener_edit);
        mEditFactConfirmButton.setOnClickListener(listener_edit_fact_confirm_button);
        mSaveNewFact.setOnClickListener(listener_add_fact);
    }


    private boolean setVisibilityForHide(){
        mFactTextView.setVisibility(View.INVISIBLE);
        mNextFactButton.setVisibility(View.INVISIBLE);
        mPrevFactButton.setVisibility(View.INVISIBLE);
        mDeleteFactButton.setVisibility(View.INVISIBLE);
        mEditFactButton.setVisibility(View.INVISIBLE);
        mEditFactButton.setVisibility(View.INVISIBLE);
        mAddFactButton.setVisibility(View.INVISIBLE);
        return true;
    }
    private boolean setVisibilityForShow (){
        mFactTextView.setVisibility(View.VISIBLE);
        mNextFactButton.setVisibility(View.VISIBLE);
        mPrevFactButton.setVisibility(View.VISIBLE);
        mDeleteFactButton.setVisibility(View.VISIBLE);
        mEditFactButton.setVisibility(View.VISIBLE);
        mEditFactButton.setVisibility(View.VISIBLE);
        mAddFactButton.setVisibility(View.VISIBLE);
        return true;
    }
}
