package ec.edu.epn.jovenescdfefull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    // Estas varibles permiten obtener los controles creados y asi poder manipularlos
    EditText edtItentificacion;
    EditText edtNombre;
    EditText edtApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // mapeamos las variables creadas con los controles.
        // de esta manera podemos setear valores u obtenerlos
        edtItentificacion = (EditText) findViewById(R.id.id_identificacion);
        edtNombre = (EditText) findViewById(R.id.id_nombre);
        edtApellido = (EditText) findViewById(R.id.id_apellido);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // estamos asignando el menu al activity
        getMenuInflater().inflate(R.menu.menu_usuario,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //de acuerdo al icono seleccionado, se debe realizar una accion
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_add:

                //en esta seccion debemos trabajar con todos los comtroles que definen el usuario para poderlo ingresar
                String ident = edtItentificacion.getText().toString();
                String nombre=edtNombre.getText().toString();
                String apelldio=edtApellido.getText().toString();
                //validamos que se ingresen todos los campos
                if(ident.length() > 0 && nombre.length()>0 && apelldio.length()>0){
                    //abrimos la base de datos de usuario
                    UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this,"DBUsuario", null, 1);
                    SQLiteDatabase db = usuario.getWritableDatabase();

                    db.execSQL("INSERT INTO Usuario (Identificacion, Nombre, Apellido) VALUES ('"+ident+"','"+nombre+"','"+apelldio+"')");
                    db.close();
                    Toast.makeText(this, "El usuario se a creado exitosamente", Toast.LENGTH_SHORT).show();
                    edtItentificacion.setText("");
                    edtNombre.setText("");
                    edtApellido.setText("");
                }
                else {
                    Toast.makeText(this, "Favor Ingresar todos los datos del usuario", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

