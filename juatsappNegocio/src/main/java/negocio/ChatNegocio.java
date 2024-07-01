/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.ChatDAO;
import DTOs.Chat;
import java.util.List;

/**
 *
 * @author eduar
 */
public class ChatNegocio implements IChatNegocio{
    private ChatDAO chatDAO;
    
    public ChatNegocio(){
        this.chatDAO= new ChatDAO();
    }
    
    @Override
    public void crearChat(String nombreChat, String imagenMiniatura, List<String> participantes) {
        Chat chat = new Chat();
        chat.setNombreChat(nombreChat);
        chat.setImagenMiniatura(imagenMiniatura);
        chat.setParticipantes(participantes);
        try {
            chatDAO.insertarChat(chat);
            System.out.println("Chat creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear el chat.");
        }
    }

    @Override
    public Chat buscarChatPorNombre(String nombreChat) {
        try {
            return chatDAO.encontrarChatPorNombre(nombreChat);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar el chat por nombre.");
            return null;
        }
    }

    @Override
    public List<Chat> obtenerChatsUsuario(String usuarioId) {
        try {
            return chatDAO.obtenerChatsPorParticipante(usuarioId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener los chats del usuario.");
            return null;
        }
    }
}
