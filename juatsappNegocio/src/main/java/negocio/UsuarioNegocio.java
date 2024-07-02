/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.IUsuarioDAO;
import DAOs.UsuarioDAO;
import DTOs.UsuarioDTO;

/**
 *
 * @author eduar
 */
public class UsuarioNegocio implements IUsuarioNegocio{
    
    IUsuarioDAO usuarioDao = new UsuarioDAO();
    
    
    public void insertarUsuario(UsuarioDTO usuario){
    
        usuarioDao.insertarUsuario(usuario);
    }
}
