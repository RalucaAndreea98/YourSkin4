package com.example.yourskin;

import androidx.annotation.Nullable;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScanActivity extends AppCompatActivity {
    Button button_capture;
    TextView textview_data, textView2, textView5;
    private static final int REQUEST_CAMERA_CODE=100;
    Bitmap bitmap;

    Database database;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter adapter;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        button_capture = findViewById(R.id.scanBtn);

        textview_data =findViewById(R.id.textView);

        recyclerView = findViewById(R.id.recycler_search);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
       textView2=findViewById(R.id.textView2);
        textView5=findViewById(R.id.textView5);
        textView2.setVisibility(View.INVISIBLE);


        database= new Database(this);

        textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), CumScanez.class);
                startActivity(activity2Intent);
            }
        });

        if(ContextCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ScanActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, REQUEST_CAMERA_CODE);
        }
        button_capture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(ScanActivity.this);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result= CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK){
                Uri resultUri = result.getUri();

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
                    getTextFromImage(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getTextFromImage (Bitmap bitmap) {
        TextRecognizer recognizer = new TextRecognizer.Builder(this).build();
        if ( !recognizer.isOperational()){
            Toast.makeText(ScanActivity.this, "Error Occured!!!", Toast.LENGTH_SHORT).show();

        }
        else {
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> textBlockSparseArray = recognizer.detect(frame);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<textBlockSparseArray.size();i++){
                TextBlock textBlock = textBlockSparseArray.valueAt(i);
                stringBuilder.append(textBlock.getValue());
                stringBuilder.append("\n");

            }
          String a;
            a =stringBuilder.toString();
            String[] strArray = a.split("[-,]");

            List<Ingredient> ingrediente = new ArrayList<Ingredient>();
            List<Ingredient> ingrediente1 = new ArrayList<Ingredient>();
            for(int i=0; i<strArray.length;i++) {
                try{
                    Ingredient ingr = database.getIngredientByDenumire(strArray[i].trim()).get(0);

                    ingrediente.add(ingr);
                    textview_data.setVisibility(View.INVISIBLE);
                    textView2.setVisibility(View.INVISIBLE);

                    }catch(Exception e) {
                }
            }
            String descriere;
            if (ingrediente.isEmpty())

            { textview_data.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView2.setText(" Your product does not contain harmful ingredients! ");}
                adapter = new SearchAdapter(this, ingrediente);
                recyclerView.setAdapter(adapter);
                button_capture.setText("Retake");
                textView5.setVisibility(View.INVISIBLE);
        }
    }

    private void copyToClipBoard(String text){
        ClipboardManager clipBoard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied data", text);
        clipBoard.setPrimaryClip(clip);
        //Toast.makeText(ScanActivity.this,"Copied to clipoard",Toast.LENGTH_SHORT).show();

    }




    }



