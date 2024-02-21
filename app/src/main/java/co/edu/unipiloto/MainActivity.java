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

        estado = findViewById(R.id.textView);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.products, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Seleccionado " + text, Toast.LENGTH_SHORT).show();

        Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent2, View view2, int position2, long id2) {
                estado.setText("Seleccionado: " + parent.getItemAtPosition(position).toString() + " "
                        + parent2.getItemAtPosition(position2).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent2) {
            }
        });

        if (text.equals("Solido")) {
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.productsSolido, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);
        } else if (text.equals("Agricola")) {
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.productsAgricola, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);
        } else if (text.equals("Liquidos")) {
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.productsLiquido, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
