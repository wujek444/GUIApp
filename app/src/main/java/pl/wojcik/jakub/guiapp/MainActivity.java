package pl.wojcik.jakub.guiapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText personNameText;
    EditText personSurnameText;
    EditText notesCountText;
    Button notesButton;

    void HideNotesButtonIfEditTextFieldsAreEmpty(){
        if(personNameText.getText().length()!=0 && personSurnameText.getText().length()!=0
                && notesCountText.getText().length()!=0) notesButton.setVisibility(View.VISIBLE);
        else
            notesButton.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        personNameText = (EditText) findViewById(R.id.personName);
        personSurnameText = (EditText) findViewById(R.id.personSurname);
        notesCountText = (EditText) findViewById(R.id.notesCount);
        notesButton = (Button) findViewById(R.id.notesButton);




        personNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HideNotesButtonIfEditTextFieldsAreEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        personNameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && personNameText.getText().length()==0){
                        personNameText.setError("Proszę wpisać imię!");
                }
            }
        });

        personSurnameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HideNotesButtonIfEditTextFieldsAreEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        personSurnameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && personSurnameText.getText().length()==0){
                    personSurnameText.setError("Proszę wpisać nazwisko!");
                }
            }
        });

        notesCountText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HideNotesButtonIfEditTextFieldsAreEmpty();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        notesCountText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(notesCountText.getText().length()==0){
                       notesCountText.setError("Podaj ilość ocen!");
                    }
                    else if(Integer.parseInt(notesCountText.getText().toString()) < 5 || Integer.parseInt(notesCountText.getText().toString()) > 15) {
                        notesCountText.setError("Zła ilość ocen! Podaj wartość z przedziału [5; 15]!");
                    }
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
