/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienteudp;

import java.net.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author USUARIO`Ñ
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {

    final int PUERTO_SERVIDOR=5550;
    byte[] buffer = new byte[1024];
    

    try {
      InetAddress hostServidor = InetAddress.getByName("localhost");
      DatagramSocket socketUDP = new DatagramSocket();
      String mensaje = "Hola mundo desde el cliente";
      buffer = mensaje.getBytes();
      // Construimos un datagrama para enviar el mensaje al servidor
      DatagramPacket peticion = new DatagramPacket(buffer, buffer.length, hostServidor, PUERTO_SERVIDOR);
      

      // Enviamos el datagrama
      System.out.println("Envio el datagrama");
      socketUDP.send(peticion);

      // Construimos el DatagramPacket que contendrá la respuesta
      
      DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
      socketUDP.receive(respuesta);
      System.out.println("Recibo la respuesta");
      // Enviamos la respuesta del servidor a la salida estandar
      
      mensaje = new String(respuesta.getData());
      System.out.println("Respuesta: " + mensaje);

      // Cerramos el socket
      socketUDP.close();

    } catch (SocketException ex) {
      Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnknownHostException ex){
      Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);  
    } catch (IOException ex) {
      Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
