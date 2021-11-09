package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameMenu;

import javax.swing.*;
import java.util.regex.Pattern;

public class CreateCharacterCreationNameMenu extends GameMenu<String> {

    // Menu para criação do personagem
    @Override
    public String execute() {
        String menu = "Qual será o nome do seu personagem?";
        String option = JOptionPane.showInputDialog(null, menu, "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE);

        if(option == null || option.equals("")) return null;

        boolean isValid = Pattern.matches("^[a-z-A-Z ]*$", option);
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "O nome só pode conter letras.", "AVISO", JOptionPane.ERROR_MESSAGE);
            return this.execute();
        }

        return option;
    }

}
