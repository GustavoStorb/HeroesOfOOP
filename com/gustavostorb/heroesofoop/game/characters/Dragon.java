package com.gustavostorb.heroesofoop.game.characters;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;

public class Dragon extends GameChar {

    public Dragon() { // criação da classe do dragão junto com atributos de ataque/defesa/vida
        super("Dragão", GameCharType.DRAGON, null, 30.0, 30.0, 300.0);
    }
}
