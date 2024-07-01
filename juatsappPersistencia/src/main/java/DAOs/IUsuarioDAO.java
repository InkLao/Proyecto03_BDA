/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import DTOs.Usuario;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IUsuarioDAO {
    public void insertarUsuario(Usuario usuario);
    public Usuario encuentraUsuarioPorTelefono(String telefono);
    public UpdateResult actualizarUsuario(Usuario usuario);
    public DeleteResult eliminaUsuario(String telefono);
    public Usuario encuentraUsuarioPorId(ObjectId id);
}
