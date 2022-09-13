package com.jogom.myappbdsqllite.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jogom.myappbdsqllite.complementos.ConstantesSQL;

import androidx.annotation.Nullable;

//1 extends sqlite open
public class ConectorSQLite extends SQLiteOpenHelper {

    //3 crear el 1 constructor que aparece
    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //2Implementear metodos abstractos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //4 crear table
        sqLiteDatabase.execSQL(ConstantesSQL.CREAR_TBL_BEBIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //5 borar la tabla si ya existe
        sqLiteDatabase.execSQL(ConstantesSQL.BORRAR_TBL_BEBIDA);
        onCreate(sqLiteDatabase);
    }
}
