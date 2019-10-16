package net.manisha.SishuKalyan;

import android.content.Context;
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

public class NGOFragment extends Fragment {

    View view;

    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    List<NGODetailClass> ngoList;

    NGODetailList ngoSchemsDetailList;
    String content , detail,name , website;

    Context context;
    public NGOFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getActivity();
        view = inflater.inflate(R.layout.activity_recyclerview, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);


        FirebaseApp.initializeApp(context);
        databaseReference = FirebaseDatabase.getInstance().getReference("CerebralPalsy/NGOs/");

        ngoList = new ArrayList<>();
        Log.e("govt",ngoList.size()+"");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ngoList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    content = snapshot.child("Contact no").getValue(String.class);
                    detail = snapshot.child("Description").getValue(String.class);
                    website = snapshot.child("Website").getValue(String.class);
                    name = snapshot.child("Name").getValue(String.class);
                    NGODetailClass ngoDetailClass= new NGODetailClass(content,detail,name,website);
                    ngoList.add(ngoDetailClass);
                }
                Log.e("ngo1",ngoList.size()+"");



                ngoSchemsDetailList = new NGODetailList(ngoList, context);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(ngoSchemsDetailList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}

