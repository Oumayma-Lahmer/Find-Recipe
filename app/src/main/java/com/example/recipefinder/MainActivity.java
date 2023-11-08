package com.example.recipefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] recipes = {
            "Tomato Pasta: Tomatoes, Pasta, Olive oil, Salt, Pepper",
            "Vegetable Stir Fry: Mixed vegetables, Soy sauce, Oil, Salt, Pepper",
            "Banana Bread: Banana, Flour, Egg, Sugar, Baking soda, Salt"
    };
    private EditText editTextIngredient;
    private TextView textViewRecipe;
    private Button   buttonFindRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listenner explicite ce code remplcer le listener implicite on peut alors effacer android:onClick:findRecipe
        buttonFindRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findRecipe(editTextIngredient.getText().toString());
            }
        });

    }
    private void findRecipe(String ingredient) {
        for (String recipe : recipes) {
            if (recipe.toLowerCase().contains(ingredient.toLowerCase())) {
                textViewRecipe.setText(recipe);
                return; // Arreter jusqu'a trouver la premier recipe
            }
        }
        textViewRecipe.setText("No recipes found with the given ingredient.");
    }
    private void init(){
        editTextIngredient = findViewById(R.id.editTextIngredient);
        textViewRecipe = findViewById(R.id.textViewRecipe);
        buttonFindRecipe = findViewById(R.id.buttonFindRecipe);
    }
}
