package ec.edu.epn.jovenescdfefull;

/**
 * Created by David Moncayo on 13/12/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Joselo on 12/12/2016.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    // Crear una variable que contenga la sentencia SQL de creacion de la tabla

    String sql = "CREATE TABLE Usuario (Identificacion INTEGER, Nombre TEXT, Apellido TEXT)";

    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // este metodo se ejecuta automaticamente cuando la base de datos no existe
        // es decir crea la base de datos
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // elimina las tablas existente y crea una nueva
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Usuario");
        sqLiteDatabase.execSQL(sql);
    }
}
