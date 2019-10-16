package net.manisha.SishuKalyan;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ColorActivity2 extends AppCompatActivity {
    DatabaseReference databaseReference;
    MediaPlayer SoundCorrect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_color2);
        final ImageView img1=findViewById(R.id.img1);
        final ImageView img2=findViewById(R.id.img2);
        final ImageView img3=findViewById(R.id.img);
        databaseReference=FirebaseDatabase.getInstance().getReference("CerebralPalsy").child("Personal Details").child("Hr4btxFKRqM05RVElOjSYcqiuaq1").child("Intial Detail").child("ColorGame");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                final long Correct=  dataSnapshot.child("Correct").getValue(Long.class);
                final long Incorrect= dataSnapshot.child("Incorrect").getValue(Long.class);
                Log.e("TAG","Correct"+Correct);
                img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SoundCorrect= MediaPlayer.create(ColorActivity2.this, R.raw.buzzerwronganswer);
                        SoundCorrect.start();
                        Toast.makeText(ColorActivity2.this,"Incorrect",Toast.LENGTH_SHORT).show();
                        databaseReference.child("Incorrect").setValue(Incorrect+1);

                    }
                });
                img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SoundCorrect= MediaPlayer.create(ColorActivity2.this, R.raw.rightanswersoundeffect);
                        SoundCorrect.start();
                        Toast.makeText(ColorActivity2.this,"Correct",Toast.LENGTH_SHORT).show();
                        databaseReference.child("Correct").setValue(Correct+1);

                    }
                });
                img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SoundCorrect= MediaPlayer.create(ColorActivity2.this, R.raw.buzzerwronganswer);
                        SoundCorrect.start();
                        Toast.makeText(ColorActivity2.this,"Incorrect",Toast.LENGTH_SHORT).show();
                        databaseReference.child("Incorrect").setValue(Incorrect+1);

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

      /*  img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundCorrect= MediaPlayer.create(ColorActivity2.this, R.raw.airhorn);
                SoundCorrect.start();
            }
        });*/
    }

}
