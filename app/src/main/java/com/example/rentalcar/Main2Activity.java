package com.example.rentalcar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    TextView result1;
    TextView result2;
    TextView result3;
    TextView result4;
    TextView result5;
    TextView result6;
    int total;
    int rentInt;
    int carInt;
    int gasInt;
    int uninsuredInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result1 = findViewById(R.id.dayText2);
        result2 = findViewById(R.id.vehicleType2);
        result3 = findViewById(R.id.gasFill2);
        result4 = findViewById(R.id.numDrivers2);
        result5 = findViewById(R.id.numUninsured2);
        result6 = findViewById(R.id.f);

        Intent intent = getIntent();
        String rentStr = intent.getStringExtra("Value1");
        String carStr = intent.getStringExtra("Value2");
        String gasStr = intent.getStringExtra("Value3");
        int driverInt = intent.getIntExtra("Value4", 0);
        String uninsuredStr = intent.getStringExtra("Value5");

        result1.setText(rentStr);
        result2.setText(carStr);
        result3.setText(gasStr);
        result4.setText("" + driverInt);
        result5.setText(uninsuredStr);


        if(rentStr.equals("One"))
        {
            rentInt = 1;
        }
        else if (rentStr.equals("Two"))
        {
            rentInt = 2;
        }
        else if (rentStr.equals("Three"))
        {
            rentInt = 3;
        }
        else if (rentStr.equals("Four"))
        {
            rentInt = 4;
        }
        else if (rentStr.equals("Five"))
        {
            rentInt = 5;
        }
        else if (rentStr.equals("Six"))
        {
            rentInt = 6;
        }
        else if (rentStr.equals("Seven"))
        {
            rentInt = 7;
        }

        if(carStr.equals("Jeep Wrangler"))
        {
            carInt = 55;
        }
        else if (carStr.equals("Jeep Grand Cherokee"))
        {
            carInt = 85;
        }
        else if (carStr.equals("Land Rover"))
        {
            carInt = 125;
        }

        if(gasStr.equals("Yes"))
        {
            gasInt = 52;
        }
        else
        {
            gasInt = 0;
        }

        if(driverInt>1)
        {
            driverInt = 22;
        }
        else
        {
            driverInt = 0;
        }

        if(uninsuredStr.equals("No"))
        {
            uninsuredInt = 24;
        }
        else
        {
            uninsuredInt = 0;
        }

        total = (driverInt*rentInt) + gasInt + (uninsuredInt*rentInt) + (carInt*rentInt);

        if(rentInt == 1)
        {
            result6.setText("The total cost of renting a " + carStr + " for " + rentInt + " day with the options selected is $" + total + ".00.");
        }
        else
            {
            result6.setText("The total cost of renting a " + carStr + " for " + rentInt + " days with the options selected is $" + total + ".00.");
        }

    }
}
