package net.manisha.SishuKalyan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class GovtSchemsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    ImageView backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_schems);

        tabLayout = findViewById(R.id.tabLayoutID);
        pager = findViewById(R.id.viewPagerID);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GovtSchemsActivity.this, MainActivity1.class));
                finish();
            }
        });

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new SchemsFragment(), "Govt Scheme");
        adapter.addFragment(new NGOFragment(), "NGOs");


        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(GovtSchemsActivity.this, MainActivity1.class));
        finish();
    }

    }
