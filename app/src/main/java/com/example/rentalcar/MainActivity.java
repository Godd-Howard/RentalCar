package com.example.rentalcar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{



    EditText numberDr;

    Button enterButton;

    Spinner rentalSpinner;
    Spinner carSpinner;
    Spinner gasSpinner;
    Spinner uninsuredSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rentalSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rentalDays, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rentalSpinner.setAdapter(adapter);
        rentalSpinner.setOnItemSelectedListener(this);

        carSpinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.typeOfCar, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carSpinner.setAdapter(adapter2);
        carSpinner.setOnItemSelectedListener(this);

        gasSpinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.gasFill, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gasSpinner.setAdapter(adapter3);
        gasSpinner.setOnItemSelectedListener(this);

        uninsuredSpinner = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.gasFill, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        uninsuredSpinner.setAdapter(adapter4);
        uninsuredSpinner.setOnItemSelectedListener(this);

        numberDr = findViewById(R.id.editText1);

        enterButton = findViewById(R.id.button);

        numberDr.addTextChangedListener(loginTextWatcher);

        enterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String rentStr = rentalSpinner.getSelectedItem().toString();
                String carStr = carSpinner.getSelectedItem().toString();
                String gasStr = gasSpinner.getSelectedItem().toString();
                int numDriver = Integer.parseInt(numberDr.getText().toString());
                String uninsuredStr = uninsuredSpinner.getSelectedItem().toString();

                if(numDriver == 0)
                {
                    Toast toaster = Toast.makeText(getBaseContext(), "The Number of Drivers cannot be 0, someone has to drive the vehicle." , Toast.LENGTH_SHORT );
                    TextView text = toaster.getView().findViewById(android.R.id.message);
                    if( text != null)
                    {
                        text.setGravity(Gravity.CENTER);
                    }
                    toaster.show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("Value1", rentStr);
                    intent.putExtra("Value2", carStr);
                    intent.putExtra("Value3", gasStr);
                    intent.putExtra("Value4", numDriver);
                    intent.putExtra("Value5", uninsuredStr);

                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String drInput = numberDr.getText().toString().trim();

        if (parent.getItemAtPosition(position).equals(("Select One")))
        {
            enterButton.setEnabled(false);
        }
        else {
            if(!drInput.isEmpty() && !rentalSpinner.getSelectedItem().toString().equals("Select One") && !carSpinner.getSelectedItem().toString().equals("Select One") &&
            !gasSpinner.getSelectedItem().toString().equals("Select One") && !uninsuredSpinner.getSelectedItem().toString().equals("Select One"))
            {
                enterButton.setEnabled(true);
            }
            String text = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), "Selected: " + text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String drInput = numberDr.getText().toString().trim();

            enterButton.setEnabled(!drInput.isEmpty() && !rentalSpinner.getSelectedItem().toString().equals("Select One") && !carSpinner.getSelectedItem().toString().equals("Select One") &&
                    !gasSpinner.getSelectedItem().toString().equals("Select One") && !uninsuredSpinner.getSelectedItem().toString().equals("Select One"));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
