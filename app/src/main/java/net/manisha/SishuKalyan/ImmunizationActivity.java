package net.manisha.SishuKalyan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ImmunizationActivity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    DataSnapshot immunizationSnapshot, immuneLevel;

    int daysAge;

    ArrayList<String> immuneList;

    Button level1Button, level2Button, level3Button, level4Button, level5Button, level6Button, level7Button;
    RecyclerView immunizationListView;
    ImageView backButton;

    ImmunizationDetailList immunizationDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization);

        daysAge = getIntent().getIntExtra("DaysAge", 0);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        firebaseDatabase = FirebaseDatabase.getInstance();

        immuneList = new ArrayList<>();

        level1Button = findViewById(R.id.level1Button);
        level2Button = findViewById(R.id.level2Button);
        level3Button = findViewById(R.id.level3Button);
        level4Button = findViewById(R.id.level4Button);
        level5Button = findViewById(R.id.level5Button);
        level6Button = findViewById(R.id.level6Button);
        level7Button = findViewById(R.id.level7Button);
        backButton = findViewById(R.id.backButton);

        immunizationListView = findViewById(R.id.immunizationListView);

        databaseReference = firebaseDatabase.getReference("CerebralPalsy/Immunization");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                immunizationSnapshot = dataSnapshot;


                if (daysAge < 45) {
                    immuneLevel = immunizationSnapshot.child("0");
                }
                else if (daysAge > 45 && daysAge < 75) {
                    immuneLevel = immunizationSnapshot.child("45");
                }
                else if (daysAge > 75 && daysAge < 105) {
                    immuneLevel = immunizationSnapshot.child("75");
                }
                else if (daysAge > 105 && daysAge < 270) {
                    immuneLevel = immunizationSnapshot.child("105");
                }
                else if (daysAge > 270 && daysAge < 480) {
                    immuneLevel = immunizationSnapshot.child("270");
                }
                else if (daysAge > 480 && daysAge < 540) {
                    immuneLevel = immunizationSnapshot.child("480-540");
                }
                else if (daysAge > 1825) {
                    immuneLevel = immunizationSnapshot.child("1825");
                }

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immuneLevel = immunizationSnapshot.child(Integer.toString(daysAge));

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, Integer.toString(daysAge), ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        level1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("0");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "0", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));


            }
        });

        level2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("45");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "45", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));


            }
        });

        level3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("75");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "75", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));


            }
        });

        level4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("105");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "105", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));


            }
        });

        level5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("270");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "270", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));

            }
        });

        level6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("480-540");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "480-540", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));


            }
        });

        level7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                immuneLevel = immunizationSnapshot.child("1825");

                immuneList.clear();

                for (DataSnapshot snapshot : immuneLevel.getChildren()) {
                    immuneList.add(snapshot.getKey());
                }

                immunizationDetailList = new ImmunizationDetailList(immuneList, immunizationSnapshot, "1825", ImmunizationActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationActivity.this);
                immunizationListView.setLayoutManager(layoutManager);
                immunizationListView.setItemAnimator(new DefaultItemAnimator());
                immunizationListView.setAdapter(immunizationDetailList);
                immunizationListView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_fall_down));


            }
        });

    }
}
