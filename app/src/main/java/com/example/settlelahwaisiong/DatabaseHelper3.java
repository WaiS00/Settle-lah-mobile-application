package com.example.settlelahwaisiong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper3 extends SQLiteOpenHelper {

    private DatabaseHelper3 DBHelper;
    private SQLiteDatabase db;

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "forgotpass.db";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + ForgotContract.BeneficiaryEntry.TABLE_NAME + " (" +
                ForgotContract.BeneficiaryEntry._ID + " INTEGER PRIMARY KEY," +
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_NAME + " TEXT NOT NULL, " +
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL + " TEXT NOT NULL, " +
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_ADDRESS + " TEXT NOT NULL, " +
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_COUNTRY + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }
    //drop beneficiary table
    private String DROP_BENEFICIARY_TABLE = "DROP TABLE IF EXISTS " + BeneficiaryContract.BeneficiaryEntry.TABLE_NAME;

    public DatabaseHelper3(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //---opens the database---
    public DatabaseHelper3 open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {

        //Drop User Table if exist

        db1.execSQL(DROP_BENEFICIARY_TABLE);

        // Create tables again
        onCreate(db1);

    }


    //Method to create beneficiary records

    public void addBeneficiary(Forgot beneficiary) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ForgotContract.BeneficiaryEntry._ID, beneficiary.getId());
        values.put(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_NAME, beneficiary.getName());
        values.put(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL, beneficiary.getEmail());
        values.put(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_ADDRESS, beneficiary.getAddress());
        values.put(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_COUNTRY, beneficiary.getCountry());

        db.insert(ForgotContract.BeneficiaryEntry.TABLE_NAME, null, values);
        db.close();
    }

    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                ForgotContract.BeneficiaryEntry._ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition

        Cursor cursor = db.query(ForgotContract.BeneficiaryEntry.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }





    public List<Forgot> getAllBeneficiary() {
        // array of columns to fetch
        String[] columns = {
                ForgotContract.BeneficiaryEntry._ID,
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_NAME,
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL,
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_ADDRESS,
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_COUNTRY
        };
        // sorting orders
        String sortOrder =
                ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_NAME + " ASC";
        List<Forgot> beneficiaryList = new ArrayList<Forgot>();

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(ForgotContract.BeneficiaryEntry.TABLE_NAME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Forgot beneficiary = new Forgot();
                beneficiary.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ForgotContract.BeneficiaryEntry._ID))));
                beneficiary.setName(cursor.getString(cursor.getColumnIndex(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_NAME)));
                beneficiary.setEmail(cursor.getString(cursor.getColumnIndex(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL)));
                beneficiary.setAddress(cursor.getString(cursor.getColumnIndex(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_ADDRESS)));
                beneficiary.setCountry(cursor.getString(cursor.getColumnIndex(ForgotContract.BeneficiaryEntry.COLUMN_BENEFICIARY_COUNTRY)));
                // Adding user record to list
                beneficiaryList.add(beneficiary);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return beneficiaryList;
    }
    public void removePlace(int placeId){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BeneficiaryContract.BeneficiaryEntry.TABLE_NAME, BeneficiaryContract.BeneficiaryEntry._ID	+ "	= ?", new String[] { String.valueOf(placeId)});
    }


}
