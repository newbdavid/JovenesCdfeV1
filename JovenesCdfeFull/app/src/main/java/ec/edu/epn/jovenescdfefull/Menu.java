package ec.edu.epn.jovenescdfefull;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void calendario(View view){
        Intent i = new Intent(this,Calendario.class);
        startActivity(i);
    }

    public void cancionero (View view){
        Intent i = new Intent(this,Cancionero.class);
        startActivity(i);
    }

    public void ensenanzas (View view){
        Intent i = new Intent(this,Ensenanzas.class);
        startActivity(i);
    }

    public void publicaciones (View view){
        Intent i = new Intent(this,PublicacionesFacebook.class);
        startActivity(i);
    }

    public void tusVersiculos (View view){
        Intent i = new Intent(this,TusVersiculos.class);
        startActivity(i);
    }

    public void ingresarFechas (View view){
        Intent i = new Intent(this,IngresarFechas.class);
        startActivity(i);
    }

    public void videos (View view){
        Intent i = new Intent(this,Video.class);
        startActivity(i);
    }

    public void musica (View view){
        Intent i = new Intent(this,Musica.class);
        startActivity(i);
    }

    public void registrar (View view){
        Intent i = new Intent(this,Registro.class);
        startActivity(i);
    }
}
