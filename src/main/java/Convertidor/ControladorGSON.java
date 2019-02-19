package Convertidor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ControladorGSON {

    //Instancia de gson. Usando GsonBuilder y pretty printing se imprime el resultado con formato.
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String XMLtoJSON(String XML){
        String JSON;

        JSON = gson.toJson(XML);

        //Pasa si el texto iba vacio
        if(XML.trim().equals(""))
            JSON = "Ingresa algun texto XML";

        return JSON;
    }

    public String JavaToJSON(String java){
        String JSON;

        String[] atributos = java.split("\n");

        //Si son menos de 3 lineas muestra el mensaje
        if(atributos.length < 3){
            JSON = "Ingresa tres lineas de texto por favor";
        //Si no, entonces toma los primeros 3 string del arreglo y los usa como atributos
        }else{
            ModeloPrueba obj = new ModeloPrueba();
            obj.setColor(atributos[0]);
            obj.setMarca(atributos[1]);
            obj.setDueño(atributos[2]);

            JSON = gson.toJson(obj);
        }

        return JSON;
    }

}
