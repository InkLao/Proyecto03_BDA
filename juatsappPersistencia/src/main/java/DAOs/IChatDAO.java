/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import DTOs.Chat;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IChatDAO {
    public void insertarChat(Chat chat);
    public Chat encontrarChatPorNombre(String nombreChat);
    public UpdateResult actualizarChat(Chat chat);
    public DeleteResult eliminarChat(ObjectId id);
    public List<Chat> obtenerChatsPorParticipante(String participanteId);
}
