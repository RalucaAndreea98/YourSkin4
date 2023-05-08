package com.example.yourskin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IngredientsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter adapter;

    Database database;

    MaterialSearchBar materialSearchBar;
    List<String> suggestList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

            recyclerView = findViewById(R.id.recycler_search);
            layoutManager= new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

            materialSearchBar =findViewById(R.id.search_bar);

            database= new Database(this);

            materialSearchBar.setHint("Search");
            materialSearchBar.setCardViewElevation(10);
            loadSuggestinList();
            materialSearchBar.addTextChangeListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    List<String> suggest = new ArrayList<>();
                    for(String search:suggestList)
                    {
                        if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                            suggest.add(search);
                    }materialSearchBar.setLastSuggestions(suggest);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
                @Override
                public void onSearchStateChanged(boolean enabled) {
                    if(!enabled) recyclerView.setAdapter(adapter);
                }

                @Override
                public void onSearchConfirmed(CharSequence text) {
                    startSearch(text.toString());
                }

                @Override
                public void onButtonClicked(int buttonCode) {

                }
            });

            adapter = new SearchAdapter(this,database.getIngredient());
            recyclerView.setAdapter(adapter);



    }

    private void startSearch(String text) {
        adapter=new SearchAdapter(this, database.getIngredientByDenumire(text) );
        recyclerView.setAdapter(adapter);
    }

    private void loadSuggestinList() {
        suggestList =database.getDenumire();
        materialSearchBar.setLastSuggestions(suggestList);
    }
}
