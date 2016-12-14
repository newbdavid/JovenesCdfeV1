package ec.edu.epn.jovenescdfefull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cancionero extends AppCompatActivity {
    ListView cancion;
    Spinner spinnerCancion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancionero);
        cancion = (ListView) findViewById(R.id.list_view_letras);
        spinnerCancion = (Spinner) findViewById(R.id.spinner_cancion);


    }



    public void cargarLetra (View view){
        List<String> letraCancion = new ArrayList<String>();
        String linea;
        InputStream is = this.getResources().openRawResource(R.raw.gracia_sublime_r);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            try {
                while ((linea=reader.readLine())!=null){
                    letraCancion.add(linea);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Carga: "+letraCancion.size(),Toast.LENGTH_LONG ).show();

        String datos[] = letraCancion.toArray(new String[letraCancion.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        cancion.setAdapter(adapter);
    }

}
