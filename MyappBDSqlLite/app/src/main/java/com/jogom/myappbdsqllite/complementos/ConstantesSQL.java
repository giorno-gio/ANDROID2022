package com.jogom.myappbdsqllite.complementos;

public class ConstantesSQL {
    //paso 1
    //constantes para poder utilizar consultas ddl
    //Base de datos

    public static final String BDBEBIDA = "bdbebida"; //final es la palabra reservada en java para definir una constante

    //tabla
    public static final String TBL_BEBIDA = "bebida";

    //campos
    public static final String CAMPO_CODIGO = "cod_bebida";
    public static final String CAMPO_NOMBRE = "nombre_bebida";
    public static final String CAMPO_SABOR = "sabor_bebida";
    public static final String CAMPO_PRESENTACION = "presentacion_bebida";
    public static final String CAMPO_TIPO = "tipo_bebida";
    public static final String CAMPO_PRECIO = "precio_bebida";

    //crear tabla
    public static final String CREAR_TBL_BEBIDA = "CREATE TABLE "+TBL_BEBIDA+
            " ("+CAMPO_CODIGO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+" TEXT NOT NULL,"+
            CAMPO_SABOR+" TEXT NOT NULL,"+
            CAMPO_PRESENTACION+" INTEGER NOT NULL,"+
            CAMPO_TIPO+" TEXT NOT NULL,"+
            CAMPO_PRECIO+" DOUBLE NOT NULL)";

    //borrar table
    public static final String BORRAR_TBL_BEBIDA = "DROP TABLE IF EXISTS "+
            TBL_BEBIDA;

    //VERSION
    public static final Integer VERSION = 1;
}
