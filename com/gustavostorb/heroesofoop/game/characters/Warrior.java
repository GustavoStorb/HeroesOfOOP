package com.gustavostorb.heroesofoop.game.characters;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.api.GameWeapon;

public class Warrior extends GameChar {

    public Warrior(String name, GameWeapon weapon) { // criação da classe do personagem guerreiro junto com atributos de ataque/defesa/vida, também  extende outra classe GameChar da API
        super(name, GameCharType.WARRIOR, weapon, 30.0, 20.0, 180.0);
    }

}
