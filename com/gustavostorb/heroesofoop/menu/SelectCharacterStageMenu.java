package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameMenu;
import com.gustavostorb.heroesofoop.game.Game;

import javax.swing.*;
import java.util.List;

public class SelectCharacterStageMenu extends GameMenu<GameChar> {

    private final Game game;

    public SelectCharacterStageMenu(Game game) {
        this.game = game;
    }

    
    // Menu para selecionar o personagem que ira atacar ou defender no Round/Stage e informar seus atributos (ATK, DEF, HP).
    @Override
    public GameChar execute() {
        StringBuilder menu = new StringBuilder("Escolha o personagem do round:");
        List<GameChar> gameChars = this.game.getCharacters();
        for(int i = 0; i < gameChars.size(); i++) {
            GameChar gameChar = gameChars.get(i);
            menu.append("\n")
                    .append((i + 1))
                    .append(" - ")
                    .append(gameChar.getName())
                    .append(" (")
                    .append(gameChar.getAttack())
                    .append(" ATK, ")
                    .append(gameChar.getDefense())
                    .append(" DEF, ")
                    .append(gameChar.getHealth())
                    .append(" HP)");
        }

        menu.append("\n0 - Sair");

        String option = JOptionPane.showInputDialog(null, menu.toString() , "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE);
        if(option == null || option.equals("")) return null;

        if(Integer.parseInt(option) == 0) return null;

        GameChar gameChar = gameChars.get(Integer.parseInt(option)-1);
        if(gameChar == null) {
            JOptionPane.showMessageDialog(null, "Opcão Invalida", "AVISO", JOptionPane.ERROR_MESSAGE);
            return this.execute();
        }

        return gameChar;
    }

}
