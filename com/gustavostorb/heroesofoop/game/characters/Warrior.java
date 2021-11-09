package com.gustavostorb.heroesofoop.game.characters;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.api.GameWeapon;

public class Warrior extends GameChar {

    public Warrior(String name, GameWeapon weapon) {
        super(name, GameCharType.WARRIOR, weapon, 30.0, 20.0, 180.0);
    }

}
