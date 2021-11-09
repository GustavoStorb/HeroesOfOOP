package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameMenu;

import javax.swing.*;
import java.util.Arrays;

public class CreateNewGameMenu extends GameMenu<Integer> {

    @Override
    public Integer execute() {
        String menu = "1 - Nova partida\n0 - Sair do jogo\n";
        String option = JOptionPane.showInputDialog(null, menu, "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE);
        Integer[] validOptions = new Integer[]{
                0, 1
        };

        if(option == null || option.equals("")) return 0;

        boolean isValid = Arrays.asList(validOptions).contains(Integer.parseInt(option));
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "Opcão Invalida", "AVISO", JOptionPane.ERROR_MESSAGE);
            return this.execute();
        }

        return Integer.parseInt(option);
    }

}
