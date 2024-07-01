/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTOs.Mensaje;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IMensajeNegocio {
    public void enviarMensaje(ObjectId chatId, ObjectId usuarioId, String textoMensaje, String imagen);
    public List<Mensaje> obtenerMensajesChat(ObjectId chatId);
}
