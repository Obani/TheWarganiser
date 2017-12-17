package ie.app.william.thewarganiser;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddUnits extends AppCompatActivity {

    private static final String TAG = "WillNote";

    EditText editName,editClasses,editID;
    MyDBHandler dbHandler;
    Button addButton;
    Button viewAllButton;
    Button updateButton;
    Button deleteButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "OnCreate");
        dbHandler = new MyDBHandler(this);

        editName = (EditText)findViewById(R.id.UnitNames);
        editClasses = (EditText)findViewById(R.id.UnitTypes);
        editID = (EditText)findViewById(R.id.editID);
        addButton = (Button)findViewById(R.id.addButton);
        viewAllButton = (Button)findViewById(R.id.viewAllButton);
        updateButton = (Button)findViewById(R.id.updateButton);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData()
    {
        deleteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = dbHandler.deleteDate(editID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(AddUnits.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddUnits.this,"Data Not Deleted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void UpdateData()
    {
        updateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = dbHandler.updateData(editName.getText().toString(),editClasses.getText().toString(),editID.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(AddUnits.this,"Units Have Been Added",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddUnits.this,"No Units Added",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void AddData()
    {
        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      boolean isInserted = dbHandler.insertData(editName.getText().toString(),
                                editClasses.getText().toString());
                      if(isInserted == true)
                          Toast.makeText(AddUnits.this,"Units Have Been Added",Toast.LENGTH_LONG).show();
                      else
                          Toast.makeText(AddUnits.this,"No Units Added",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll()
    {
        viewAllButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Cursor res = dbHandler.getAllData();
                       if(res.getCount() == 0) {
                           showMessage("Error","Nothing found");
                           return;
                       }

                       StringBuffer buffer = new StringBuffer();
                       while (res.moveToNext()) {
                           buffer.append("Id :"+ res.getString(0)+ "\n");
                           buffer.append("Name :"+ res.getString(1)+ "\n");
                           buffer.append("Class :"+ res.getString(2)+ "\n");
                       }

                       showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.AddUnits:
                Intent intent1 = new Intent(this, AddUnits.class);
                this.startActivity(intent1);
                return true;

            case R.id.BoltGun:
                Intent intent2 = new Intent(this, BoltGunActivity.class);
                this.startActivity(intent2);
                return true;

            case R.id.About:
                Intent intent3 = new Intent( this, About.class);
                this.startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }




    protected void onClick()
    {
        Log.i(TAG, "Onclick");
    }
}
