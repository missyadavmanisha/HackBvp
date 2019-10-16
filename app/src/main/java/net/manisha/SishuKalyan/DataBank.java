package net.manisha.SishuKalyan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataBank extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bank);
        Intent intent = new Intent(DataBank.this,WebViewActivity.class);
        intent.putExtra("databank","https://www.cerebralpalsy.org.uk/");
        startActivity(intent);
    }
}
