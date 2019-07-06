package databaseandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TableHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Tutorial.db";
    public static final String Table_NAME = "Tutorial_table";


    public static final String COL_1 ="Tutorial_Id";
    public static final String COL_2 = "Tutorial_Name";
    public static final String COL_3 = "Tutorial_Description";
    public static final String COL_4 = "Tutorial_Icon";

    public TableHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String table1="CREATE TABLE IF NOT EXISTS "+
                Table_NAME+"("+
                COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_2+" TEXT, "+
                COL_3+" TEXT, "+
                COL_4+" TEXT)";
        Log.i("Query for Table ::",table1);
        db.execSQL(table1);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }
}
