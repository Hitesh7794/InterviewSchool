package com.example.interviewschool.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.interviewschool.R;
import com.example.interviewschool.databinding.ActivityProfileBinding;
import com.example.interviewschool.models.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class profileAc extends AppCompatActivity {
    BottomNavigationView nav;
    FirebaseDatabase database;
    User user;
    ActivityProfileBinding binding;
    String emails="";
    String username = "";
    FirebaseAuth auth;
    long coins = 0;
//    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        nav = findViewById(R.id.bottom_navigation);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(profileAc.this,OptionsAc.class));
                        break;
                }
                return false;
            }
        });
        auth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = auth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        database.getReference().child("profiles")
                .child(currentUser.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                        progress.dismiss();
                        user = snapshot.getValue(User.class);
                        coins = user.getCoins();
                        Glide.with(profileAc.this)
                                .load(user.getProfile())
                                .into(binding.profilePicture);
                        binding.username.setText(user.getName());
                        binding.wallet.setText("Wallet : "+coins);
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        emails = user.getEmail();
        binding.email.setText("Email :"+emails);



    }
}