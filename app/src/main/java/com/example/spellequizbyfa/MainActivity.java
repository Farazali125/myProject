package com.example.spellequizbyfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.spellequizbyfa.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       ArrayList<CategoryModel> categories = new ArrayList<>();
       categories.add(new CategoryModel("","mathematics",""));
        categories.add(new CategoryModel("","Science",""));
        categories.add(new CategoryModel("","History",""));
        categories.add(new CategoryModel("","Language",""));
        categories.add(new CategoryModel("","Sports",""));
        categories.add(new CategoryModel("","Fruits",""));
//        categories.add(new CategoryModel("","Mathematics","R.drawable.mathematics"));
//        categories.add(new CategoryModel("","Science",R.drawable.science));
//        categories.add(new CategoryModel("","Sports",R.drawable.sports));
//        categories.add(new CategoryModel("","History",R.drawable.history));
//        categories.add(new CategoryModel("","Language",R.drawable.language));
//        categories.add(new CategoryModel("","Fruits",R.drawable.fruits));



        CategoryAdapter adapter = new CategoryAdapter(this,categories);
        binding.categoryList.setLayoutManager(new GridLayoutManager(this,2));
        binding.categoryList.setAdapter(adapter);
    }
}
