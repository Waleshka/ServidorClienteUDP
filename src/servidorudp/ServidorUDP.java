/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorudp;

import java.net.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 *
 * @author USUARIO`Ñ
 */
public class ServidorUDP {

    /**
     * @param args the command line arguments
     */
public static void main (String args[]) {
    final int PUERTO=5550;
    byte[] buffer = new byte[1024];
    try {
      System.out.println("Iniciando el Servidor UDP");
      DatagramSocket socketUDP = new DatagramSocket(PUERTO);
      

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);
        System.out.println("Recibo la informacion del cliente");
        String mensaje = new String(peticion.getData());
        System.out.println(mensaje);
        int puertoCliente = peticion.getPort();
        InetAddress direccion = peticion.getAddress();
        mensaje = "Hola desde el servidor";
        buffer = mensaje.getBytes();
        
        
        //System.out.print("Datagrama recibido del host: " +
        //                   peticion.getAddress());
        //System.out.println(" desde el puerto remoto: " +
        //                   peticion.getPort());

        // Construimos el DatagramPacket para enviar la respuesta
        DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
        
        // Enviamos la respuesta, que es un eco
        System.out.println("Envio la informacion del cliente");
        socketUDP.send(respuesta);
        
      }

    } catch (SocketException e) {
      Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, e);
    } catch (IOException e) {
      Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, e);
    }
  }


    
}
