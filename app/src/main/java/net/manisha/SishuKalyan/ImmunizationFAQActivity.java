package net.manisha.SishuKalyan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;


import java.util.ArrayList;
import java.util.List;

public class ImmunizationFAQActivity extends AppCompatActivity {

    List<String> questions, answers;

    RecyclerView faqRecyclerView;

    ImmunizationFAQDetailList immunizationFAQDetailList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization_faq);

        faqRecyclerView = findViewById(R.id.faqRecyclerView);

        questions = new ArrayList<>();
        answers = new ArrayList<>();

        Intent intent = getIntent();
        questions = intent.getStringArrayListExtra("Question");
        answers = intent.getStringArrayListExtra("Answer");

        immunizationFAQDetailList = new ImmunizationFAQDetailList(questions, answers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ImmunizationFAQActivity.this);
        faqRecyclerView.setLayoutManager(layoutManager);
        faqRecyclerView.setItemAnimator(new DefaultItemAnimator());
        faqRecyclerView.setAdapter(immunizationFAQDetailList);

    }
}
