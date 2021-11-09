package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameMenu;

import javax.swing.*;
import java.util.regex.Pattern;

public class CreateCharacterCreationNameMenu extends GameMenu<String> { // extende a classe GameMenu

    // Menu para criação do personagem
    @Override
    public String execute() {
        String menu = "Qual será o nome do seu personagem?";
        String option = JOptionPane.showInputDialog(null, menu, "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE); // interface grafica para perguntar o nome do personagem

        if(option == null || option.equals("")) return null; // verifica se voce colocar nada no nome

        boolean isValid = Pattern.matches("^[a-z-A-Z ]*$", option); // verifica se voce colocou apenas caracteres no nome
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "O nome só pode conter letras.", "AVISO", JOptionPane.ERROR_MESSAGE); // mensagem de erro caso nao tenha colocado nome ou tenha colocado algum caracter invalido
            return this.execute();
        }

        return option;
    }

}
