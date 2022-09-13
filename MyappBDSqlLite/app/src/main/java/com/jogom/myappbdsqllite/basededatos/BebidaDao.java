package com.jogom.myappbdsqllite.basededatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jogom.myappbdsqllite.complementos.ConstantesSQL;
import com.jogom.myappbdsqllite.complementos.ConsultasDAO;

import java.util.ArrayList;


public class BebidaDao implements ConsultasDAO {

    @Override
    public boolean insertarBebida(BebidaVo bebidaVo, Context context) {
        boolean resultado = false;//validar
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BDBEBIDA, null, ConstantesSQL.VERSION);
        //paso 1 implementar el construstor     del conector

        //paso 2 instanciar un objeto que nos permitira realizar la accion de escribir o registrar datos

        SQLiteDatabase database = conectorSQLite.getWritableDatabase();//metodo para escribir porque cuando inserto escribo

        //paso 3
        try {
            String consulta = "INSERT INTO "+ConstantesSQL.TBL_BEBIDA+"("+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_SABOR+", "
                    +ConstantesSQL.CAMPO_PRESENTACION+", "+ConstantesSQL.CAMPO_TIPO+", "+ConstantesSQL.CAMPO_PRECIO+") VALUES ('"+
                    bebidaVo.getNombreBebida()+"', '"+bebidaVo.getSaborBebida()+"', "+bebidaVo.getPresentacionBebida()+", '"+bebidaVo.getTipoBebida()+"', "+
                    bebidaVo.getPrecioBebida()+")";
            database.execSQL(consulta);
            database.close();
            resultado = true;
        }catch (Exception e){
            e.getMessage();
            database.close();
        }

        return resultado;
    }

    @Override
    public Cursor buscarBebida(BebidaVo bebidaVo, Context context) {
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BDBEBIDA, null, ConstantesSQL.VERSION);
        //objeto que nos permite leer informacion
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        //crear objeto de tipo cursor para solicitar info ala bd luego leerla y obtenerla
        Cursor cursor = null;
        String[] parametro = {bebidaVo.getCodBebida().toString()};//identifica un parametro para identificar
        try{
            String consulta = "SELECT "+ConstantesSQL.CAMPO_CODIGO+", "+
                    ConstantesSQL.CAMPO_NOMBRE+", "+
                    ConstantesSQL.CAMPO_SABOR+", "+
                    ConstantesSQL.CAMPO_PRESENTACION+", "+
                    ConstantesSQL.CAMPO_TIPO+", "+
                    ConstantesSQL.CAMPO_PRECIO+" FROM "+ConstantesSQL.TBL_BEBIDA
                    +" WHERE "+ConstantesSQL.CAMPO_CODIGO+" = ?";

            cursor = database.rawQuery(consulta,parametro);//consulta y luego el elemento que viene de un arreglo
            cursor.moveToFirst();
            bebidaVo.setCodBebida(cursor.getInt(0));
            bebidaVo.setNombreBebida(cursor.getString(1));
            bebidaVo.setSaborBebida(cursor.getString(2));
            bebidaVo.setPresentacionBebida(cursor.getInt(3));
            bebidaVo.setTipoBebida(cursor.getString(4));
            bebidaVo.setPrecioBebida(cursor.getDouble(5));
            cursor.close();


        }catch (Exception e){
            e.getMessage();
            cursor.close();
            database.close();
        }
        return cursor;
    }

    @Override
    public ArrayList<BebidaVo> listarBebida(BebidaVo bebidaVo, Context context) {
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BDBEBIDA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        ArrayList<BebidaVo> listadoBebidas = new ArrayList<>();
        try{
            String consulta = "SELECT * FROM "+ConstantesSQL.TBL_BEBIDA;
            Cursor cursor = database.rawQuery(consulta,null);//solicita informacion la lee y la obtiene
            //to next ->encontre un registro siguiente encontre un registro siguiente

            while (cursor.moveToNext()){
                bebidaVo = new BebidaVo();//cada vez que reccora el while crea un constructor luego se reinicia
                bebidaVo.setCodBebida(cursor.getInt(0));
                bebidaVo.setNombreBebida(cursor.getString(1));
                bebidaVo.setSaborBebida(cursor.getString(2));
                bebidaVo.setPresentacionBebida(cursor.getInt(3));
                bebidaVo.setTipoBebida(cursor.getString(4));
                bebidaVo.setPrecioBebida(cursor.getDouble(5));
                listadoBebidas.add(bebidaVo);
            }
            cursor.close();

        }catch (Exception e){
            e.getMessage();
            database.close();
        }

        return listadoBebidas;
    }
}
