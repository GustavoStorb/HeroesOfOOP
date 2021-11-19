package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameMenu;

import javax.swing.*;
import java.util.Arrays;

public class SelectCharacterStageModeMenu extends GameMenu<Integer> {

    private GameChar gameChar;
    
    public SelectCharacterStageModeMenu(GameChar gameChar) {
        this.gameChar = gameChar;
    }

    // Menuu para selecionar modo de Defesa ou Ataque do personagem.
    @Override
    public Integer execute() {
        String menu = "1 - Ataque\n2 - Defesa\n0 - Sair do jogo\n";
        String option = JOptionPane.showInputDialog(null, menu, "Selecione o modo do personagem: " + gameChar.getName(), JOptionPane.INFORMATION_MESSAGE);
        Integer[] validOptions = new Integer[]{
                0, 1, 2
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
