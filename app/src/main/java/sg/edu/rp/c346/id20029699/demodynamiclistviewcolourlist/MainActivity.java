package sg.edu.rp.c346.id20029699.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndex;
    Button addBtn;
    Button removeBtn;
    Button updateBtn;
    ListView colourList;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndex = findViewById(R.id.editTextIndex);
        addBtn = findViewById(R.id.buttonAddItem);
        removeBtn = findViewById(R.id.buttonRemove);
        updateBtn = findViewById(R.id.buttonUpdate);
        colourList = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alColours);

        colourList.setAdapter(aaColour);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userColour = etElement.getText().toString();
                int userPOS = Integer.parseInt(etIndex.getText().toString());
                alColours.add(userPOS, userColour);
                aaColour.notifyDataSetChanged();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userPOS = Integer.parseInt(etIndex.getText().toString());
                alColours.remove(userPOS);
                aaColour.notifyDataSetChanged();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userColourUpdate = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.set(pos,userColourUpdate);
                aaColour.notifyDataSetChanged();
            }
        });

        colourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colourSelected = alColours.get(position);
                Toast.makeText(MainActivity.this, "" + colourSelected,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}