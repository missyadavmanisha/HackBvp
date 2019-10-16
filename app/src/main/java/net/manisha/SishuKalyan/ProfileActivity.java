package net.manisha.SishuKalyan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    DatabaseReference dbref;
    TextView tvNameOfChild,age,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvNameOfChild=findViewById(R.id.nameTextView);
        age=findViewById(R.id.ageTextView);
        bmi=findViewById(R.id.BMITextView);
        dbref= FirebaseDatabase.getInstance().getReference();
        tvNameOfChild.setText("Aanya");
        age.setText("2 year");
        //weight=7.8 and ht=71.3
        bmi.setText("15.3");
       ImageView imgbmigraph=findViewById(R.id.chart);
        imgbmigraph.setImageResource(R.drawable.bmi_curve);

    }
}
