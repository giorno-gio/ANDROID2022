package com.jogom.myappbdsqllite.complementos;

import android.content.Context;
import android.database.Cursor;

import com.jogom.myappbdsqllite.basededatos.BebidaVo;

import java.util.ArrayList;

public interface ConsultasDAO {
    public boolean insertarBebida(BebidaVo bebidaVo, Context context);
    public Cursor buscarBebida(BebidaVo bebidaVo, Context context);
    public ArrayList<BebidaVo> listarBebida(BebidaVo bebidaVo, Context context);
}
