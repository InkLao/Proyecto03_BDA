/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTOs.Usuario;
import java.util.Date;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

/**
 *
 * @author eduar
 */
public interface IUsuarioNegocio {
    public void registrarUsuario(String telefono, String nombre, String contrasena, String direccion, String sexo, Date fechaNacimiento, Binary imagenPerfil);
    public Usuario obtenerUsuarioPorTelefono(String telefono);
    public Usuario obtenerUsuarioPorId(ObjectId id);
    public void actualizarUsuario(Usuario usuario);
}
