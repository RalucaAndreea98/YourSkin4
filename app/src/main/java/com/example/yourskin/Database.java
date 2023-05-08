package com.example.yourskin;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "cosmetics18.db";
    public static final int DB_VER = 1;



    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<Ingredient> getIngredient() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Id", "Denumire", "Tip", "Descriere"};
        String tableName = "ingredients";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, "Denumire");
        List<Ingredient> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                ingredient.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                ingredient.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                ingredient.setDescriere(cursor.getString(cursor.getColumnIndexOrThrow("Descriere")));
                result.add(ingredient);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getDenumire() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Denumire"};
        String tableName = "ingredients";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Ingredient> getIngredientByDenumire(String denumire) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Id", "Denumire", "Tip", "Descriere"};
        String tableName = "ingredients";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Denumire LIKE ?", new String[]{"%" + denumire + "%"}, null, null, null);
        List<Ingredient> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                ingredient.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                ingredient.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                ingredient.setDescriere(cursor.getString(cursor.getColumnIndexOrThrow("Descriere")));
                result.add(ingredient);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdus() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<String> getDenumireP() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Denumire"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByDenumire(String denumire) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente","Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Denumire LIKE ?", new String[]{"%" + denumire + "%"}, null, null, null);
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByDry() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Dry =1", null , null, null, null);
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByNormal() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente","Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Normal =1", null , null, null, null);
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusBySensitive() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Sensitive =1", null , null, null, null);
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByOily() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Oily =1", null , null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByCremaH() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Moisturizer"};
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
       String a="Moisturizer";
        Cursor cursor = qb.query(db, sqlSelect, "Tip =?",args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByDemachiant() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Cleanser"};
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Tip =?",args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByTratament() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Treatment"};
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Tip =?",args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByMasca() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Face Mask"};
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Tip =?",args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByOchi() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Eye cream"};
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Tip =?",args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }



    public List<Produs> getProdusBySoare() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Sun protect"};
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Tip =?",args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByUscat1() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Sun protect","1"};
        String selection = "Tip =? AND Dry=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByUscat2() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Moisturizer","1"};
        String selection = "Tip =? AND Dry=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByUscat3() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Cleanser","1"};
        String selection = "Tip =? AND Dry=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByUscat4() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Treatment","1"};
        String selection = "Tip =? AND Dry=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByUscat5() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Face Mask","1"};
        String selection = "Tip =? AND Dry=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusByUscat6() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Eye cream","1"};
        String selection = "Tip =? AND Dry=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusBySensibil1() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Moisturizer","1"};
        String selection = "Tip =? AND Sensitive=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusBySensibil2() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Cleanser","1"};
        String selection = "Tip =? AND Sensitive=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusBySensibil3() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Treatment","1"};
        String selection = "Tip =? AND Sensitive=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusBySensibil4() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Face Mask","1"};
        String selection = "Tip =? AND Sensitive=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusBySensibil5() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Eye cream","1"};
        String selection = "Tip =? AND Sensitive=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<Produs> getProdusBySensibil6() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Sun protect","1"};
        String selection = "Tip =? AND Sensitive=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByNormal1() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Moisturizer","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByNormal2() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Cleanser","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByNormal3() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Treatment","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByNormal4() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Face Mask","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByNormal5() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Eye cream","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByNormal6() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Sun protect","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByGras1() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Moisturizer","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByGras2() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Cleanser","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByGras3() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Treatment","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByGras4() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Face Mask","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByGras5() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Eye cream","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<Produs> getProdusByGras6() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String [] args={"Sun protect","1"};
        String selection = "Tip =? AND Normal=?";
        String[] sqlSelect = {"Tip", "Brand", "Denumire", "Ingrediente", "Rank"};
        String tableName = "cosmetics";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, selection,args, null, null, "Rank DESC");
        List<Produs> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Produs produs= new Produs();
                produs.setBrand(cursor.getString(cursor.getColumnIndexOrThrow("Brand")));
                produs.setDenumire(cursor.getString(cursor.getColumnIndexOrThrow("Denumire")));
                produs.setTip(cursor.getString(cursor.getColumnIndexOrThrow("Tip")));
                produs.setIngrediente(cursor.getString(cursor.getColumnIndexOrThrow("Ingrediente")));
                produs.setRank(cursor.getString(cursor.getColumnIndexOrThrow("Rank")));
                result.add(produs);
            } while (cursor.moveToNext());
        }
        return result;
    }



}