/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.MensajeDAO;
import DTOs.Mensaje;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public class MensajeNegocio implements IMensajeNegocio{
    private MensajeDAO mensajeDAO;

    public MensajeNegocio() {
        this.mensajeDAO = new MensajeDAO();
    }

    @Override
    public void enviarMensaje(ObjectId chatId, ObjectId usuarioId, String textoMensaje, String imagen) {
        Mensaje mensaje = new Mensaje();
        mensaje.setChatId(chatId);
        mensaje.setUsuarioId(usuarioId);
        mensaje.setTextoMensaje(textoMensaje);
        mensaje.setImagen(imagen);
        try {
            mensajeDAO.insertarMensaje(mensaje);
            System.out.println("Mensaje enviado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al enviar mensaje.");
        }
    }
    
    @Override
    public List<Mensaje> obtenerMensajesChat(ObjectId chatId) {
        return mensajeDAO.obtenerMensajesPorChatId(chatId);
    }
}
