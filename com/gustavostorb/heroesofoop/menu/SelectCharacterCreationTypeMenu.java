package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.api.GameMenu;

import javax.swing.*;
import java.util.Arrays;

public class SelectCharacterCreationTypeMenu extends GameMenu<GameCharType> {

    @Override
    public GameCharType execute() {
        String menu = "Escolhe seu tipo:\n1 - Guerreiro\n2 - Mago\n3 - Arqueiro\n0 - Sair";
        String option = JOptionPane.showInputDialog(null, menu, "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE);
        Integer[] validOptions = new Integer[]{
                0, 1, 2, 3
        };

        if(option == null || option.equals("")) return null;

        boolean isValid = Arrays.asList(validOptions).contains(Integer.parseInt(option));
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "Opcão Invalida", "AVISO", JOptionPane.ERROR_MESSAGE);
            return this.execute();
        }

        GameCharType charType = null;

        switch (Integer.parseInt(option)) {
            case 1: {
                charType = GameCharType.WARRIOR;
                break;
            }
            case 2: {
                charType = GameCharType.MAGE;
                break;
            }
            case 3: {
                charType = GameCharType.ARCHER;
                break;
            }
        }

        return charType;
    }

}
