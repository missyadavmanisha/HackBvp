package net.manisha.SishuKalyan;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePageActivity extends AppCompatActivity {

    CardView profileCardView, videoDiagnosisCardView, speechTherpyCardView, gamesCardView, immunityCardView, nearByHelpCardView, educationalCardView, govtSchemesCardView, dataBankCardView, dietCardView;
    String age;
    SharedPreferences sharedPreferences;
    String languageCode;
    TextView babyNameTextView, ageTextView, bmiTextView, changeLanguageTextView, logoutTextView;
    ImageView notificationImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        sharedPreferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        languageCode = sharedPreferences.getString("lang", "en");

        profileCardView = findViewById(R.id.profileCardView);
        videoDiagnosisCardView = findViewById(R.id.videoDiagnosisCardView);
        speechTherpyCardView = findViewById(R.id.speechTherapyCardView);
        gamesCardView = findViewById(R.id.gamesCardView);
        immunityCardView = findViewById(R.id.immunizationCardView);
        nearByHelpCardView = findViewById(R.id.nearByHelpCardView);
        educationalCardView = findViewById(R.id.educationalCardView);
        govtSchemesCardView = findViewById(R.id.govtSchemsCardView);
        dataBankCardView = findViewById(R.id.dataBankCardView);
        dietCardView = findViewById(R.id.dietCardView);

        babyNameTextView = findViewById(R.id.babyNametextView);
        ageTextView = findViewById(R.id.ageTextView);
        bmiTextView = findViewById(R.id.bmiTextView);
        changeLanguageTextView = findViewById(R.id.changeLanguage);
        logoutTextView = findViewById(R.id.logoutTextView);

        notificationImageView = findViewById(R.id.notificationImage);


      /*  CallLanguage callLanguage;

        callLanguage = new CallLanguage(videoDiag.getText().toString(), HomePageActivity.this);
        videoDiag.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(speechTherapy.getText().toString(), HomePageActivity.this);
        speechTherapy.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(gamesSection.getText().toString(), HomePageActivity.this);
        gamesSection.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(diet.getText().toString(), HomePageActivity.this);
        diet.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(immunityReminder.getText().toString(), HomePageActivity.this);
        immunityReminder.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(educationVideos.getText().toString(), HomePageActivity.this);
        educationVideos.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(govtSchemes.getText().toString(), HomePageActivity.this);
        govtSchemes.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(sos.getText().toString(), HomePageActivity.this);
        sos.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(hellobaby.getText().toString(), HomePageActivity.this);
        hellobaby.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(t.getText().toString(), HomePageActivity.this);
        t.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(bmi.getText().toString(), HomePageActivity.this);
        bmi.setText(callLanguage.getResult());

        callLanguage = new CallLanguage(nearby.getText().toString(), HomePageActivity.this);
        nearby.setText(callLanguage.getResult());
*/

        profileCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, ProfileActivity.class));

            }
        });

        videoDiagnosisCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.edvard.poseestimation");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });

        speechTherpyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, VoiceTherapy.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        gamesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, GameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        immunityCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ImmunizationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        nearByHelpCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ActivityMapsCurrentPlace.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        educationalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, HelpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        govtSchemesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, GovtSchemsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        dataBankCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, DataBank.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        dietCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                final String dateString = dateFormat.format(date);

                String currDay = dateString.substring(0, 2);
                String currMonth = dateString.substring(3, 5);
                String currYear = dateString.substring(6, 10);
                age = AgeCalculater.findAge(Integer.parseInt(currDay), Integer.parseInt(currMonth), Integer.parseInt(currYear), 12, 1, 2018);
                Intent intent = new Intent(HomePageActivity.this, DietActivity.class);
                intent.putExtra("Age", age);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        changeLanguageTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                AlertDialog.Builder builder = new AlertDialog.Builder(HomePageActivity.this);
                builder.setTitle("Choose language");
                builder.setItems(R.array.language, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                editor.putString("lang", "en");
                                break;
                            case 1:
                                editor.putString("lang", "hi");
                                break;
                            case 2:
                                editor.putString("lang", "te");
                                break;
                            case 3:
                                editor.putString("lang", "ta");
                                break;
                            case 4:
                                editor.putString("lang", "gu");
                                break;
                            case 5:
                                editor.putString("lang", "pa");
                                break;
                        }
                        editor.apply();

                    }
                });
                builder.create();
                builder.show();

            }
        });

        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomePageActivity.this, LoginActivity.class));
            }
        });

        notificationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, Notification.class));
            }
        });


    }
}
