/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DTOs.Mensaje;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class MensajeDAO implements IMensajeDAO {

    private MongoCollection<Document> collection;

    public MensajeDAO() {
        MongoDatabase database = conexion.ConexionBD.getDatabase();
        collection = database.getCollection("mensajes");
    }

    public void insertarMensaje(Mensaje mensaje) {
        if (mensaje.getFechaHora() == null) {
            mensaje.setFechaHora(new Date()); // Establecer la fecha actual si es nula
        }
        Document doc = new Document()
                .append("chat_id", mensaje.getChatId())
                .append("usuario_id", mensaje.getUsuarioId())
                .append("texto_mensaje", mensaje.getTextoMensaje())
                .append("fecha_hora", mensaje.getFechaHora())
                .append("imagen", mensaje.getImagen());
        collection.insertOne(doc);
        System.out.println("Mensaje insertado correctamente.");
    }

    public DeleteResult eliminarMensaje(ObjectId id) {
        DeleteResult result = collection.deleteOne(eq("_id", id));
        System.out.println("Mensaje eliminado correctamente.");
        return result;
    }

    public List<Mensaje> obtenerMensajesPorChatId(ObjectId chatId) {
        List<Mensaje> mensajes = new ArrayList<>();
        List<Document> docs = collection.find(eq("chat_id", chatId)).into(new ArrayList<>());
        for (Document doc : docs) {
            Mensaje mensaje = new Mensaje(
                    doc.getObjectId("_id"),
                    doc.getObjectId("chat_id"),
                    doc.getObjectId("usuario_id"),
                    doc.getString("texto_mensaje"),
                    doc.getDate("fecha_hora"),
                    doc.getString("imagen")
            );
            mensajes.add(mensaje);
        }
        return mensajes;
    }
}
