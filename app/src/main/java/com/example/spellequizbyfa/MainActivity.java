package com.example.spellequizbyfa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.spellequizbyfa.databinding.ActivityMainBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=FirebaseFirestore.getInstance();

       final ArrayList<CategoryModel> categories = new ArrayList<>();



//        categories.add(new CategoryModel("","Mathematics","R.drawable.mathematics"));
//        categories.add(new CategoryModel("","Science",R.drawable.science));
//        categories.add(new CategoryModel("","Sports",R.drawable.sports));
//        categories.add(new CategoryModel("","History",R.drawable.history));
//        categories.add(new CategoryModel("","Language",R.drawable.language));
//        categories.add(new CategoryModel("","Fruits",R.drawable.fruits));



        final CategoryAdapter adapter = new CategoryAdapter(this,categories);
        database.collection("categories")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        categories.clear();
                        for(DocumentSnapshot snapshot : value.getDocuments()) {
                            CategoryModel model= snapshot.toObject(CategoryModel.class);
                            model.setCategoryId(snapshot.getId());
                            categories.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
        binding.categoryList.setAdapter(adapter);
    }
}
