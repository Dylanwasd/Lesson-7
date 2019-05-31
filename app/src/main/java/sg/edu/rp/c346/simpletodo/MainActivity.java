package sg.edu.rp.c346.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button add;
Button clear;
ArrayList<String> todo;
EditText text;
ArrayAdapter text1;
ListView lv;
Spinner spinner;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.buttonAdd);
        clear = findViewById(R.id.buttonClear);
        text=findViewById(R.id.editTextToDo);
        lv=findViewById(R.id.list);
        spinner=findViewById(R.id.spinner);
        delete=findViewById(R.id.buttonDelete);
        add.setEnabled(true);
        delete.setEnabled(true);
        todo = new ArrayList();
        text1=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,todo);
        lv.setAdapter(text1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        delete.setEnabled(false);
                        add.setEnabled(true);
                        add.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String name= text.getText().toString();
                                todo.add(name);
                                text1.notifyDataSetChanged();

                            }
                        });

                        clear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                todo.clear();
                                text1.notifyDataSetChanged();
                            }
                        });
                        break;
                    case 1:
                        add.setEnabled(false);
                        delete.setEnabled(true);
                        delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int index=Integer.parseInt(text.getText().toString());

                                if(todo.size()>=1) {
                                        if (todo.size()>=index){
                                            todo.remove(index);

                                        }else{
                                            Toast.makeText(MainActivity.this,"Wrong index number", Toast.LENGTH_SHORT).show();
                                        }

                                }else{
                                    Toast.makeText(MainActivity.this,"You do not have any tasks to remove", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        clear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                todo.clear();
                                text1.notifyDataSetChanged();

                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
