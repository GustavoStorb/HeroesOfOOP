package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameMenu;

import javax.swing.*;
import java.util.Arrays;

public class CreateNewGameMenu extends GameMenu<Integer> { // extende a classe GameMenu

    // Menu para inicial de novo jogo
    @Override
    public Integer execute() {
        String menu = "1 - Nova partida\n0 - Sair do jogo\n";
        String option = JOptionPane.showInputDialog(null, menu, "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE); // interface grafica do menu inicial
        Integer[] validOptions = new Integer[]{
                0, 1
        };

        if(option == null || option.equals("")) return 0; // verificação caso opção seja vazia ou null retorna 0 ou seja fecha a interface

        boolean isValid = Arrays.asList(validOptions).contains(Integer.parseInt(option)); // verificação para verificar se opcao foi valida ou nao
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "Opcão Invalida", "AVISO", JOptionPane.ERROR_MESSAGE); // mensagem de erro caso selecione uma opcao que nao é valida (APENAS 0  e 1 SÃO  VALIDAS)
            return this.execute();
        }

        return Integer.parseInt(option);
    }

}
