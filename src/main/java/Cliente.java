/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;

public class Cliente {

    public static void main(String[] args) {
        try {

            Client client = Client.create();
            WebResource webResource = null;
            ClientResponse response = null;
            int opcion = -1;
            Scanner lectura = new Scanner(System.in);
            System.out.println("Bienvenido sistema gestion de Mercancias Secas");
         
            do {
                System.out.println("1. Listar 2. Crear. 3 Borrar TODO");
                opcion = lectura.nextInt();
                switch (opcion) {
                    case 1:
                        webResource = client.resource("http://localhost:8080/myapp/mercancias/");

                        response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

                        if (response.getStatus() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
                        }

                        String output = response.getEntity(String.class);
                        System.out.println("Output from Server .... \n");
                        System.out.println(output);
                        break;

                    case 2:
                        webResource = client
                                .resource("http://localhost:8080/myapp/mercancias/");

                        ObjectMapper mapper = new ObjectMapper();
                        MercanciasSecas paciente = new MercanciasSecas();
                        
                        System.out.println("Ingrese numero Serial");
                        int serial = lectura.nextInt();
                        paciente.setSerial(serial);
                        
                        System.out.println("Ingrese numero lote");
                        int lote = lectura.nextInt();
                        paciente.setLote(lote);
                        
                        System.out.println("ingrese el tipo de mercancia");
                        String tipo = lectura.next();
                        paciente.setTipo(tipo);
                        
                        System.out.println("ingrese la cantidad");
                        int cantidad = lectura.nextInt();
                        paciente.setCantidad(cantidad);
                        
                        System.out.println("ingrese el numero de serie");
                        int serie = lectura.nextInt();
                        paciente.setSerie(serie);
                        
                        String input = mapper.writeValueAsString(paciente);
                        //Luego se utilizara Jackson
                        //String input = "{\"empNo\":\"E11\",\"empName\":\"" + nombre + "\",\"position\":\"Salesman\"}";

                        response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, input);

                        if (response.getStatus() != 200) {
                            System.out.println(response.toString());
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
                        }

                        output = response.getEntity(String.class);
                        System.out.println(output);
                        break;

                    case 3:
                        //System.out.println("Indique el ID del empleado");
                        //String id = lectura.next();
                        webResource = client.resource("http://localhost:8080/myapp/mercancias/" );//+ id);

                        response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

                        if (response.getStatus() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
                        }

                        break;
                    default:
                        System.out.println("Opcion invalida");

                }

            } while (opcion != 4);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
