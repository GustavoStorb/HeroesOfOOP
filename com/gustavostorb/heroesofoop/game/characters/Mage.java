package com.gustavostorb.heroesofoop.game.characters;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.api.GameWeapon;

public class Mage extends GameChar {

    public Mage(String name, GameWeapon weapon) { // criação da classe do personagem mago junto com atributos de ataque/defesa/vida, também  extende outra classe GameChar da API
        super(name, GameCharType.MAGE, weapon, 20.0, 10.0, 200.0);
    }
}
