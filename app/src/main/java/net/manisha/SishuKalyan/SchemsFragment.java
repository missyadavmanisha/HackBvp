package net.manisha.SishuKalyan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SchemsFragment extends Fragment {

    View view;

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    List<GovtDetailClass> govtList;

    GovtSchemsDetailList govtSchemsDetailList;
    String content , detail,name , eligibilityCriteria;

    Context context;
    public SchemsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getActivity();
        view = inflater.inflate(R.layout.activity_recyclerview, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);


        FirebaseApp.initializeApp(context);
        databaseReference = FirebaseDatabase.getInstance().getReference("CerebralPalsy/GovtSchems/");

        govtList = new ArrayList<>();
        Log.e("govt",govtList.size()+"");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                govtList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    content = snapshot.child("Content").getValue(String.class);
                    detail = snapshot.child("Detail").getValue(String.class);
                    eligibilityCriteria = snapshot.child("EligibilityCriteria").getValue(String.class);
                    name = snapshot.child("Name").getValue(String.class);
                    GovtDetailClass govtDetailClass = new GovtDetailClass(content,detail,eligibilityCriteria,name);
                    govtList.add(govtDetailClass);
                }
                     Log.e("govt1",govtList.size()+"");



                        govtSchemsDetailList = new GovtSchemsDetailList(govtList, context);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(govtSchemsDetailList);

                    }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}


