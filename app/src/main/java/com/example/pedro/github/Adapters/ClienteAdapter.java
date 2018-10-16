package com.example.pedro.github.Adapters;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ClienteAdapter {
    private static final String NAME="cliente";
    private SQLiteDatabase sqlDB;


    public ClienteAdapter (SQLiteDatabase sqlDB){
        this.sqlDB=sqlDB;
    }


    private class Columns implements BaseColumns {
        public final static String ID="cliente_id";
        public final static String NOMBRE="nombre";
        public final static String APELLIDO="apellido";
        public final static String TELEFONO="telefono";

    }


    private final static String[] COLUMNS={
            Columns.ID,Columns.NOMBRE,Columns.APELLIDO,Columns.TELEFONO};


    public final static String CR_TABLE="create table if not exists"
            + NAME + "(" + Columns.ID + "integerprimarykeyautoincrement, "
            + Columns.NOMBRE + "textonull, " + Columns.APELLIDO + "textnonull, "
            + Columns.TELEFONO + " text)";


    public boolean insert(String nombre, String apellido, String telefono) {
        //Relacionamos campos con valores en el objeto ContentValues.
        ContentValues values = new ContentValues();
        values.put(Columns.NOMBRE, nombre);
        values.put(Columns.APELLIDO, apellido);
        values.put(Columns.TELEFONO, telefono);

        return sqlDB.insert(NAME, null, values) > 0;
    }

    public boolean delete (int id){
        String whereClause = "cliente_id=?";
        String[] whereArgs = {String.valueOf(id)};
        return sqlDB.delete(NAME, whereClause, whereArgs)>0;
    }
    /**
     * Devuelve el cursor con todos los nombres registrados en la tabla.
     *
     * @return Cursor
     */
    public Cursor getNombres(){
        String[] columns = { Columns.NOMBRE};
        return sqlDB.query(NAME, columns, null, null, null, null, null);
    }

    public String getName(){
        return NAME;
    }

    public String[] getColumns(){
        return COLUMNS;
    }

    public  boolean isEmpty() {
        return sqlDB.query(NAME, COLUMNS, null, null, null, null, null)
                .getCount() == 0;
    }

    public Cursor getDatos() {
        return sqlDB.query(NAME, COLUMNS, null, null, null, null, null);
    }

}
