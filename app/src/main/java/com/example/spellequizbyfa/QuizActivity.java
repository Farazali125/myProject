package com.example.spellequizbyfa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.spellequizbyfa.databinding.ActivityMainBinding;
import com.example.spellequizbyfa.databinding.ActivityQuizBinding;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
}
