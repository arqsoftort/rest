/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;

/**
 *
 * @author Usuario
 */
public class ConsumidorRest {
    
    static Logger log = Logger.getLogger(ConsumidorRest.class.getName());
    
    public static String consumirGet(){
        BufferedReader reader = null;
        try {
            log.info("Invocando servicio");
            URL url = new URL("http://api.icndb.com/jokes/random");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String valor = reader.readLine();
            log.info("Respuesta obtenida: " + valor);
            return valor;
        } catch (Exception ex) {
            log.error(ex);
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    log.error(ex);
                }
            }
        }
        return null;
    }
}
