package ie.app.william.thewarganiser;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BoltGunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolt_gun);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int[] playState = new int[1];
        playState[0] = 0;

        final MediaPlayer boltGunPlayer = MediaPlayer.create(this, R.raw.boltgun_song);

        Button playButton = (Button) this.findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(playState[0] == 0){
                   boltGunPlayer.start();
                   playState[0]++;
               }
               else if(playState[0] == 1){
                   boltGunPlayer.stop();
                   playState[0]--;
               }

            }
        });

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
}
