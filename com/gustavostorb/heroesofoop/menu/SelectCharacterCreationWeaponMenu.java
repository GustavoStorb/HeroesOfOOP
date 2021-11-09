package com.gustavostorb.heroesofoop.menu;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.api.GameMenu;
import com.gustavostorb.heroesofoop.api.GameWeapon;
import com.gustavostorb.heroesofoop.game.characters.Archer;
import com.gustavostorb.heroesofoop.game.characters.Mage;
import com.gustavostorb.heroesofoop.game.characters.Warrior;
import com.gustavostorb.heroesofoop.game.weapons.archer.Bow;
import com.gustavostorb.heroesofoop.game.weapons.archer.Crossbow;
import com.gustavostorb.heroesofoop.game.weapons.mage.Staff;
import com.gustavostorb.heroesofoop.game.weapons.mage.Wand;
import com.gustavostorb.heroesofoop.game.weapons.warrior.Axe;
import com.gustavostorb.heroesofoop.game.weapons.warrior.Sword;

import javax.swing.*;
import java.util.Arrays;

public class SelectCharacterCreationWeaponMenu extends GameMenu<GameChar> {

    private final String charName;
    private final GameCharType charType;

    public SelectCharacterCreationWeaponMenu(String charName, GameCharType charType) {
        this.charName = charName;
        this.charType = charType;
    }

    
    // Menu para seleionar armas dos personagens
    @Override
    public GameChar execute() {
        GameWeapon[] weapons = new GameWeapon[]{};

        switch (this.charType) {
            case WARRIOR: {
                weapons = new GameWeapon[]{
                        new Sword(),
                        new Axe()
                };

                break;
            }
            case MAGE: {
                weapons = new GameWeapon[]{
                        new Staff(),
                        new Wand()
                };

                break;
            }
            case ARCHER: {
                weapons = new GameWeapon[]{
                        new Bow(),
                        new Crossbow()
                };

                break;
            }
        }

        String menu = "Escolhe sua arma:\n1 - "
                + weapons[0].getName() + " (" + weapons[0].getAttack() + " ATK)"
                + "\n2 - "
                + weapons[1].getName() + " (" + weapons[1].getAttack() + " ATK)"
                + "\n0 - Sair";

        String option = JOptionPane.showInputDialog(null, menu, "Heroes Of OOP", JOptionPane.INFORMATION_MESSAGE);
        Integer[] validOptions = new Integer[]{
                0, 1, 2
        };

        if(option == null || option.equals("")) return null;

        boolean isValid = Arrays.asList(validOptions).contains(Integer.parseInt(option));
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "Opcão Invalida", "AVISO", JOptionPane.ERROR_MESSAGE);
            return this.execute();
        }

        int selectedOption = Integer.parseInt(option);
        if(selectedOption == 0) return null;
        GameWeapon weapon = weapons[selectedOption-1];
        GameChar gameChar = null;
        switch (charType) {
            case WARRIOR: {
                gameChar = new Warrior(this.charName, weapon);
                break;
            }
            case MAGE: {
                gameChar = new Mage(this.charName, weapon);
                break;
            }
            case ARCHER: {
                gameChar = new Archer(this.charName, weapon);
                break;
            }
        }

        return gameChar;
    }

}
