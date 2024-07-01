/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTOs.Chat;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface IChatNegocio {
    public void crearChat(String nombreChat, String imagenMiniatura, List<String> participantes);
    public Chat buscarChatPorNombre(String nombreChat);
    public List<Chat> obtenerChatsUsuario(String usuarioId);
}
