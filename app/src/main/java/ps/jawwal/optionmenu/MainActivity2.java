package ps.jawwal.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

        Button button = findViewById(R.id.button);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ActionMode actionMode = startActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        getMenuInflater().inflate(R.menu.action_mode,menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.Action_edit:{
                                Toast.makeText(getApplicationContext(),"Edit Clicked",Toast.LENGTH_SHORT).show();
                                mode.finish();
                                return true;
                            }
                            case R.id.Action_share:{
                                Toast.makeText(getApplicationContext(),"Share Clicked",Toast.LENGTH_SHORT).show();
                                mode.finish();
                                return true;
                            }
                            case R.id.Action_delete:{
                                Toast.makeText(getApplicationContext(),"Delete Clicked",Toast.LENGTH_SHORT).show();
                                mode.finish();
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

                    }
                });
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:{
                Toast.makeText(getApplicationContext(),"Setting Clicked",Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.fav:{
                Toast.makeText(getApplicationContext(),"Fave Clicked",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //    public void openSetting(MenuItem item) {
//        Toast.makeText(getApplicationContext(),"Setting Clicked",Toast.LENGTH_LONG).show();
//    }
//
//    public void openFave(MenuItem item) {
//        Toast.makeText(getApplicationContext(),"Fave Clicked",Toast.LENGTH_LONG).show();
//    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_edit:{
                textView.setText("Hi Everyone!!");
                return true;
            }
            case R.id.context_share:{
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, textView.getText());
                intent.setType("text/plain");
                startActivity(intent);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}