/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resttest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 *
 * @author Usuario
 */
public class RestTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obtenemos la broma desde el servicio
        String broma = ConsumidorRest.consumirGet();
        
        // Utilzamos GSON para parsear la respuesta
        Gson gson = new GsonBuilder().create();
        JsonObject object = gson.fromJson(broma, JsonObject.class);
        JsonObject bromaJSON = object.getAsJsonObject("value");
        
        System.out.println("LA BROMA ES: " + bromaJSON.get("joke"));
    }
}
