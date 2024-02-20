package co.edu.unipiloto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estado=findViewById(R.id.textView);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.products, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Seleccionado"+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
        if(parent.getItemAtPosition(position).equals("Solido")){
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.productsSolido, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        estado.setText("Seleccionado: "+parent.getItemAtPosition(position).toString()+" "+spinner2.getSelectedItem().toString());
        }
        else if(parent.getItemAtPosition(position).equals("Agricola")){
            Spinner spinner2 = findViewById(R.id.spinner2);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.productsAgricola, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter);
            estado.setText("Seleccionado: "+parent.getItemAtPosition(position).toString()+" "+spinner2.getSelectedItem().toString());
        }
        else if (parent.getItemAtPosition(position).equals("Liquidos")){
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.productsLiquido, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
            estado.setText("Seleccionado: "+parent.getItemAtPosition(position).toString()+" "+spinner2.getSelectedItem().toString());
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}