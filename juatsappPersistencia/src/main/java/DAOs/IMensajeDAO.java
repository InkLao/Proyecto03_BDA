/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import DTOs.Mensaje;
import com.mongodb.client.result.DeleteResult;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IMensajeDAO {
    public void insertarMensaje(Mensaje mensaje);
    public DeleteResult eliminarMensaje(ObjectId id);
    public List<Mensaje> obtenerMensajesPorChatId(ObjectId chatId);
    
}
