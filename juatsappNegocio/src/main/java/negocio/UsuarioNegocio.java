/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.UsuarioDAO;
import DTOs.Usuario;
import java.util.Date;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author eduar
 */
public class UsuarioNegocio implements IUsuarioNegocio{
    private UsuarioDAO usuarioDAO;

    public UsuarioNegocio() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void registrarUsuario(String telefono, String nombre, String contrasena, String direccion, String sexo, Date fechaNacimiento, Binary imagenPerfil) {
        String contrasenaEncriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
        Usuario usuario = new Usuario(telefono, nombre, contrasenaEncriptada, fechaNacimiento, imagenPerfil, direccion, sexo);
        try {
            usuarioDAO.insertarUsuario(usuario);
            System.out.println("Usuario registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al registrar usuario.");
        }
    }

    @Override
    public Usuario obtenerUsuarioPorTelefono(String telefono) {
        try {
            return usuarioDAO.encuentraUsuarioPorTelefono(telefono);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener usuario por teléfono.");
            return null;
        }
    }

    @Override
    public Usuario obtenerUsuarioPorId(ObjectId id) {
        try {
            return usuarioDAO.encuentraUsuarioPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener usuario por ID.");
            return null;
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        if (usuario.getContrasenaEncriptada() != null && !usuario.getContrasenaEncriptada().isEmpty()) {
            String contrasenaEncriptada = BCrypt.hashpw(usuario.getContrasenaEncriptada(), BCrypt.gensalt());
            usuario.setContrasenaEncriptada(contrasenaEncriptada);
        }
        try {
            usuarioDAO.actualizarUsuario(usuario);
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar usuario.");
        }
    }
}
