package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class scoreActivity extends AppCompatActivity {
    // Score variables for both teams
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    // UI element references
    private TextView scoreViewA;
    private TextView scoreViewB;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);

        findViewById(R.id.team_a_plus_3).setOnClickListener(v -> addPoints(true, 3));
        findViewById(R.id.team_a_plus_2).setOnClickListener(v -> addPoints(true, 2));
        findViewById(R.id.team_a_free_throw).setOnClickListener(v -> addPoints(true, 1));

        findViewById(R.id.team_b_plus_3).setOnClickListener(v -> addPoints(false, 3));
        findViewById(R.id.team_b_plus_2).setOnClickListener(v -> addPoints(false, 2));
        findViewById(R.id.team_b_free_throw).setOnClickListener(v -> addPoints(false, 1));

        resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> resetScores());

        updateScoreDisplay();
    }
    private void addPoints(boolean isTeamA, int points) {
        if (isTeamA) {
            scoreTeamA += points;
        } else {
            scoreTeamB += points;
        }
        updateScoreDisplay();
    }
    private void updateScoreDisplay() {
        scoreViewA.setText(String.valueOf(scoreTeamA));
        scoreViewB.setText(String.valueOf(scoreTeamB));
    }
    private void resetScores() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        updateScoreDisplay();
    }
}
