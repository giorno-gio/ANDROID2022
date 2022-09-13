package com.jogom.myappsw.complementos;

import android.content.Context;

import com.jogom.myappsw.basededatossw.ProductoVo;

import org.json.JSONObject;

public interface ConsultasDao {

    public boolean insertarSW(ProductoVo pVo, Context context);
    public boolean buscarIdSW(ProductoVo pVo, Context context);
    public void respuestaBusquedaID(ProductoVo pVo, Context context, JSONObject response);


}
