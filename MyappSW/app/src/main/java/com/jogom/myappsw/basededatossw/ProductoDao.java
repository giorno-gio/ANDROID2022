package com.jogom.myappsw.basededatossw;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jogom.myappsw.complementos.Constantes;
import com.jogom.myappsw.complementos.ConsultasDao;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductoDao implements ConsultasDao, Response.Listener<JSONObject>, Response.ErrorListener {

    private Integer banderaDeUso = 0;

    @Override
    public boolean insertarSW(ProductoVo pVo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.INSERTAR;
        //url por donde se trasladan los valores a los campos definidos como claves
        try {
            String url = Constantes.IPSERVER + "apiRestPhpSw2022/insertar.php?nombreProducto=" + pVo.getNombreProducto()
                    + "&precioUnitario=" + pVo.getPrecioUnitario() + "&fechaIngresoProducto=" + pVo.getFechaIngresoProducto()
                    + "&pesoProducto=" + pVo.getFechaIngresoProducto() + "&existenciasProducto=" + pVo.getExistenciasProducto();
            //proceso de interaccion con la api
            RequestQueue requestQueue = Volley.newRequestQueue(context); //define el acceso a la activity para salir a consumir el sw
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);

            resultado = true;
        } catch (Exception e) {
            Toast.makeText(context, "Error en la conexion" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }

    @Override
    public boolean buscarIdSW(ProductoVo pVo, Context context) {
        boolean resultado = true;
        banderaDeUso = Constantes.BUSCARID;
        try {
            String url = Constantes.IPSERVER + "apiRestPhpSw2022/buscarId.php?codigoProducto"
                    + pVo.getCodProducto();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        } catch (Exception e) {
            Toast.makeText(context, "Error en la conexion" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public void respuestaBusquedaID(ProductoVo pVo, Context context, JSONObject response) {
        JSONArray jsonArray =  response.optJSONArray("productos");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            pVo.setCodProducto(jsonObject.optInt("cod_producto"));
            pVo.setPrecioUnitario(jsonObject.optDouble());
        }catch (Exception e){

        }
    }

    @Override
    public void onResponse(JSONObject response) {
        switch (banderaDeUso) {
            case 1: //INSERTAR
                //System.out.println("------------Se inserto correctamente");
                break;
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        switch (banderaDeUso) {
            case 1: //INSERTAR
                //System.out.println("------------error en la insercion"+error);
                break;
        }
    }


}
