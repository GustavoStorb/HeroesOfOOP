package com.gustavostorb.heroesofoop.game.characters;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.api.GameWeapon;

public class Archer extends GameChar {
    public Archer(String name, GameWeapon weapon) {
        super(name, GameCharType.ARCHER, weapon, 20.0, 30.0, 300.0);
    }
}
