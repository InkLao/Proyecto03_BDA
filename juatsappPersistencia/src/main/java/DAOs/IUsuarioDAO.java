/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import DTOs.UsuarioDTO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IUsuarioDAO {
    public void insertarUsuario(UsuarioDTO usuario);
    public UsuarioDTO encuentraUsuarioPorTelefono(String telefono);
    public UpdateResult actualizarUsuario(UsuarioDTO usuario);
    public DeleteResult eliminaUsuario(String telefono);
    public UsuarioDTO encuentraUsuarioPorId(ObjectId id);
}
