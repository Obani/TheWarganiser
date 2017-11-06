package ie.app.william.thewarganiser;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    EditText UnitNames;
    EditText UnitTypes;
    MyDBHandler dbHandler;
    TextView armies;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"OnCreate");

        final Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Unit Added",
                        Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "UNIT ADDED");
            }


        });

        UnitNames = (EditText) findViewById(R.id.UnitNames);
        UnitTypes = (EditText) findViewById(R.id.UnitTypes);
        armies = (TextView) findViewById(R.id.armies);
        dbHandler = new MyDBHandler(this, null, null,1);
        printDatabase();
    }

    public void addButtonClicked(){
        Units units = new Units(UnitNames.getText().toString(),UnitTypes.getText().toString());
        dbHandler.addProduct(units);
        printDatabase();
    }

    public void printDatabase()
    {
        String dbString = dbHandler.databaseToString();
        armies.setText(dbString);
        UnitNames.setText("");
        UnitTypes.setText("");

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

            case R.id.boltgun:
                Intent intent2 = new Intent(this, BoltGun.class);
                this.startActivity(intent2);
                return true;

            case R.id.about:
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
