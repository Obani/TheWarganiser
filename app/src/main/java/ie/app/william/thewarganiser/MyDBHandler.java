package ie.app.william.thewarganiser;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
/**
 * Created by William on 05/11/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "legion.db";
    public static final String TABLE_PRODUCTS = "UnitsTable";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_CLASSY = "_classy";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE" + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_NAME + " VARCHAR(255) " +
                COLUMN_CLASSY + "VARCHAR(255) " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(sqLiteDatabase);
    }

    public void addProduct(Units units) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, units.get_name());
        values.put(COLUMN_CLASSY, units.get_classification());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(TABLE_PRODUCTS, null, values);
        sqLiteDatabase.close();
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        while (c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("name")) != null) {
                dbString += c.getString(c.getColumnIndex("name"));
                dbString += "\n";
            }



        }
        sqLiteDatabase.close();
        return dbString;
    }
}
