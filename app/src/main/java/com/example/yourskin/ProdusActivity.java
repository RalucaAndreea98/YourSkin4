package com.example.yourskin;

import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProdusActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapterP adapter;
    SearchAdapterP adapter1;
    Button button2;
    Database database;
    TextView textView3, textView4;
    CheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10;
    MaterialSearchBar materialSearchBar;
    List<String> suggestList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produs);

        recyclerView = findViewById(R.id.recycler_search);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        materialSearchBar =findViewById(R.id.search_bar);

        database= new Database(this);

        button2=findViewById(R.id.button2);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);
        checkBox7=findViewById(R.id.checkBox7);
        checkBox8=findViewById(R.id.checkBox8);
        checkBox9=findViewById(R.id.checkBox9);
        checkBox10=findViewById(R.id.checkBox10);
        checkBox=findViewById(R.id.checkBox);

        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);

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

        adapter = new SearchAdapterP(this,database.getProdus());
        recyclerView.setAdapter(adapter);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if((checkBox10.isChecked()) && (checkBox2.isChecked())){
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByUscat1());
                    recyclerView.setAdapter(adapter1);
                    Text();
                }
                else if ((checkBox3.isChecked()) && (checkBox2.isChecked())||(checkBox5.isChecked()) && (checkBox2.isChecked())||(checkBox4.isChecked()) && (checkBox2.isChecked())||(checkBox4.isChecked()) && (checkBox3.isChecked())||(checkBox3.isChecked()) && (checkBox5.isChecked())||(checkBox4.isChecked()) && (checkBox5.isChecked())){ Text3R();
                }
                else if ((checkBox.isChecked()) && (checkBox6.isChecked())||(checkBox.isChecked()) && (checkBox7.isChecked())||(checkBox.isChecked()) && (checkBox7.isChecked())||(checkBox.isChecked()) && (checkBox8.isChecked())||(checkBox.isChecked()) && (checkBox9.isChecked())||(checkBox.isChecked()) && (checkBox10.isChecked())
                        ||(checkBox6.isChecked()) && (checkBox7.isChecked())||(checkBox6.isChecked()) && (checkBox8.isChecked())||(checkBox6.isChecked()) && (checkBox9.isChecked())||(checkBox6.isChecked()) && (checkBox10.isChecked())||(checkBox7.isChecked()) && (checkBox8.isChecked())||(checkBox7.isChecked()) && (checkBox9.isChecked())||(checkBox7.isChecked()) && (checkBox10.isChecked())
                        ||(checkBox8.isChecked()) && (checkBox9.isChecked())||(checkBox8.isChecked()) && (checkBox10.isChecked())||(checkBox9.isChecked()) && (checkBox10.isChecked())){ Text4R();
                }

                else if ((checkBox.isChecked()) && (checkBox2.isChecked())){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByUscat2());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox6.isChecked()) && (checkBox2.isChecked())){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByUscat3());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox7.isChecked()) && (checkBox2.isChecked())){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByUscat4());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox8.isChecked()) && (checkBox2.isChecked())){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByUscat5());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox9.isChecked()) && (checkBox2.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByUscat6());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox3.isChecked()) && (checkBox.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusBySensibil1());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox3.isChecked()) && (checkBox6.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusBySensibil2());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox3.isChecked()) && (checkBox7.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusBySensibil3());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox3.isChecked()) && (checkBox8.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusBySensibil4());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox3.isChecked()) && (checkBox9.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusBySensibil5());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox3.isChecked()) && (checkBox10.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusBySensibil6());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox5.isChecked()) && (checkBox.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByGras1());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox5.isChecked()) && (checkBox6.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByGras2());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox5.isChecked()) && (checkBox7.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByGras3());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox5.isChecked()) && (checkBox8.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByGras4());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox5.isChecked()) && (checkBox9.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByGras5());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox5.isChecked()) && (checkBox10.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByGras6());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox4.isChecked()) && (checkBox.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByNormal1());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox4.isChecked()) && (checkBox6.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByNormal2());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox4.isChecked()) && (checkBox7.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByNormal3());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox4.isChecked()) && (checkBox8.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByNormal4());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox4.isChecked()) && (checkBox9.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByNormal5());
                    recyclerView.setAdapter(adapter1);
                }
                else if ((checkBox4.isChecked()) && (checkBox10.isChecked())) {
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this, database.getProdusByNormal6());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox2.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByDry());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox4.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByOily());
                    recyclerView.setAdapter(adapter1);
            }
                else if (checkBox3.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusBySensitive());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox5.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByNormal());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByCremaH());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox6.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByDemachiant());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox7.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByTratament());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox8.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByMasca());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox10.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusBySoare());
                    recyclerView.setAdapter(adapter1);
                }
                else if (checkBox9.isChecked()){
                    Text();
                    adapter1 = new SearchAdapterP(ProdusActivity.this,  database.getProdusByOchi());
                    recyclerView.setAdapter(adapter1);
                }
                else  {
                    Text3R();Text4R();
                }
            }
        });
    }
    private void Text(){
        textView3.setText("Choose your skin type:");
        textView4.setText("Choose a type of product:");
        textView3.setTextColor(Color.parseColor("#000000"));
        textView4.setTextColor(Color.parseColor("#000000"));
    }
    private void Text3R(){
        textView3.setText("Atention! Choose one type of skin!");
        textView3.setTextColor(Color.parseColor("#ff0001"));
    }
    private void Text4R(){
        textView4.setText("Atention! Choose one type of product!");
        textView4.setTextColor(Color.parseColor("#ff0001"));
    }
    private void startSearch(String text) {
        adapter=new SearchAdapterP(this, database.getProdusByDenumire(text) );
        recyclerView.setAdapter(adapter);
    }
    private void loadSuggestinList() {
        suggestList =database.getDenumireP();
        materialSearchBar.setLastSuggestions(suggestList);
    }
}
