package com.example.csistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.widget.ThemedSpinnerAdapter;

import java.util.Date;

class DBHandler extends SQLiteOpenHelper{

    // below variable is for our dbname
    private static final String DB_NAME = "userinfo";
    // below int is our database version
    private static final int DB_VERSION = 1;
    // below variable is for our table name.
    private static final String TABLE_NAME = "user";
    // below variable is for our id column.
    private static final String EMAIL_ID = "id";
    // below variable is for our course name column
    private static final String NAME = "name";
    // below variable id for our phone number.
    private static final String PHONE_NUMBER = "phoneNo";
    // below variable for our course description column.
    private static final String PASSWORD= "password";
    // below variable is for our course tracks column.
    private static final String DOB = "dateOfBirth";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + EMAIL_ID + " STRING PRIMARY KEY , "
                + NAME + " TEXT,"
                + PHONE_NUMBER + " LONG,"
                + PASSWORD + " TEXT,"
                + DOB + " TEXT)";
        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String emailId, String name, long phoneNo, String pass, String dob ) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(EMAIL_ID, emailId);
        values.put(NAME, name);
        values.put(PASSWORD, pass);
        values.put(PHONE_NUMBER, phoneNo);
        values.put(DOB, dob);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public boolean checkUserExist(String username, String password){
        String[] columns = {"username"};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}