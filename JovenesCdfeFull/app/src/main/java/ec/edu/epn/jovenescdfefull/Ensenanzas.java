package ec.edu.epn.jovenescdfefull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ensenanzas extends AppCompatActivity {
    ListView cancion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensenanzas);
        cancion = (ListView) findViewById(R.id.list_view_ensenanza);
    }

    public void cargarEnsenanza (View view){
        List<String> letraCancion = new ArrayList<String>();
        String linea;
        InputStream is = this.getResources().openRawResource(R.raw.una_nueva_vida);
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
