package com.example.day_off;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String USER = "user";
    public static final String COL_NOM = "nom";
    public static final String COL_EMAIL = "email";
    public static final String COL_CNI = "cni";
    public static final String COL_SEXE = "sexe";
    public static final String COL_SIT_MATRIMONIALE = "sit_matrimoniale";
    public static final String COL_TELEPHONE = "telephone";
    public static final String COL_ADRESSE = "adresse";
    public static final String COL_DATE_NAISSANCE = "date_naissance";
    public static final String COL_DEPARTEMENT = "departement";
    public static final String COL_FONCTION = "fonction";
    public static final String COL_TYPE_DE_CONTRAT = "type_de_contrat";
    public static final String COL_DATE_ENTRE = "date_entre";
    public static final String COL_IDENTIFIANT = "identifiant";
    public static final String COL_PASSWORD = "password";
    public static final String COL_CONFIRMER_PASSWORD = "confirmer_password";
    public static final String demande = "demande";
    public static final String COL_DATE_DEMANDE = "date_demande";
    public static final String COL_TYPE_CONGE = "type_de_conge";
    public static final String COL_DATE_DEPART = "date_de_depart";
    public static final String COL_DATE_RETOUR = "date_de_retour";
    public static final String COL_NBR_JR = "nbr_de_jour";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + USER + "(" + COL_NOM + " text, "  + COL_EMAIL + " text, " + COL_CNI + " text, " + COL_SEXE + " text, " + COL_SIT_MATRIMONIALE + " text, " +
                COL_TELEPHONE + " int, " + COL_ADRESSE + " text, " + COL_DATE_NAISSANCE + " text, " + COL_DEPARTEMENT + " text, " + COL_FONCTION + " text, " + COL_TYPE_DE_CONTRAT + " text, " + COL_DATE_ENTRE + " text, " + COL_IDENTIFIANT + " text, " + COL_PASSWORD + " text, " + COL_CONFIRMER_PASSWORD + " text)");
        db.execSQL("Create table " + demande + "(" + COL_CNI + " text, " + COL_NOM + " text, " + COL_DATE_DEMANDE + " text," + COL_TYPE_CONGE + " text, " + COL_DATE_DEPART + " text, " + COL_DATE_RETOUR + " text, " + COL_NBR_JR + " text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + USER);
        db.execSQL("drop table if exists demande");
        onCreate(db);
    }
    //insertion de la base de donnée
    public boolean insert(String nom, String email, String cni, String sexe, String sit_matrimoniale, String telephone,
                          String adresse, String date_naisssance, String departement, String fonction, String type_de_contrat, String date_entre, String identifiant, String password, String confirmer_password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOM, nom);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_CNI, cni);
        contentValues.put(COL_SEXE, sexe);
        contentValues.put(COL_SIT_MATRIMONIALE, sit_matrimoniale);
        contentValues.put(COL_TELEPHONE, telephone);
        contentValues.put(COL_ADRESSE, adresse);
        contentValues.put(COL_DATE_NAISSANCE, date_naisssance);
        contentValues.put(COL_DEPARTEMENT, departement);
        contentValues.put(COL_FONCTION, fonction);
        contentValues.put(COL_TYPE_DE_CONTRAT, type_de_contrat);
        contentValues.put(COL_DATE_ENTRE, date_entre);
        contentValues.put(COL_IDENTIFIANT, identifiant);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put( COL_CONFIRMER_PASSWORD, confirmer_password);
        long ins = db.insert(USER, null,contentValues);
        if (ins==-1) {
            return false;
        }
        else return true;

    }

   //recuperation de l'identifiant et du mot de poasse
    public Boolean identifiantpassword(String identifiant,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + USER + " where " + COL_IDENTIFIANT + "=? and " + COL_PASSWORD + "=?",new String[]{identifiant,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean ajoutdemande(String cni, String nom, String date_demande, String type_de_conge, String date_de_depart, String
                                date_de_retour, String nombre_de_jour){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CNI, cni);
        contentValues.put(COL_NOM, nom);
        contentValues.put(COL_DATE_DEMANDE, date_demande);
        contentValues.put(COL_TYPE_CONGE, type_de_conge);
        contentValues.put(COL_DATE_DEPART, date_de_depart);
        contentValues.put(COL_DATE_RETOUR, date_de_retour);
        contentValues.put(COL_NBR_JR, nombre_de_jour);
        long ins = db.insert(demande, null, contentValues );
        if (ins==-1) return false;
        else return  true;
    }

    public List<String> getAll()
    {
        List<String> list =new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("USER", null, null, null, null, null, null);
        try {
            c.moveToFirst();
            do {
                @SuppressLint("Range") String nom = c.getString(c.getColumnIndex("nom"));
                String email = c.getString(c.getColumnIndex("email"));
                String cni = c.getString(c.getColumnIndex("cni"));
                String sexe = c.getString(c.getColumnIndex("sexe"));
                String sit_matrimoniale = c.getString(c.getColumnIndex("sit_matrimoniale"));
                String telephone = c.getString(c.getColumnIndex("telephone"));
                String adresse = c.getString(c.getColumnIndex("adresse"));
                String date_naissance = c.getString(c.getColumnIndex("date_naissance"));
                String departement = c.getString(c.getColumnIndex("departement"));
                String fonction = c.getString(c.getColumnIndex("fonction"));
                String type_de_contrat = c.getString(c.getColumnIndex("type_de_contrat"));
                String date_entre = c.getString(c.getColumnIndex("date_entre"));
                String identifiant = c.getString(c.getColumnIndex("identifiant"));
                String password = c.getString(c.getColumnIndex("password"));
                String confirmer_password= c.getString(c.getColumnIndex("confirmer_password"));

                list.add(nom + "| "+ email + " | "+ cni + " | "+ sexe + " | "+ sit_matrimoniale + " | "+ telephone + " | "+ adresse + " | "+ date_naissance + " | "+ departement + " | "+ fonction + " | "+ type_de_contrat
                        + " | "+ date_entre + " | "+ identifiant + " | "+ password + " | "+ confirmer_password);
                c.moveToNext();
            }while (!c.isAfterLast());

        }catch (Exception e){
            e.printStackTrace();
        }
        c.close();
        db.close();
        return list;
    }

    public List<String> getAlldemande()
    {
        List<String> list =new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("demande", null, null, null, null, null, null);
        try {
            c.moveToFirst();
            do {
                String nom = c.getString(c.getColumnIndex("nom"));
                String cni = c.getString(c.getColumnIndex("cni"));
                list.add(nom + "| "+ cni);
                c.moveToNext();
            }while (!c.isAfterLast());

        }catch (Exception e){
            e.printStackTrace();
        }
        c.close();
        db.close();
        return list;
    }

}
