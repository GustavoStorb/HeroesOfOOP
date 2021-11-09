package com.gustavostorb.heroesofoop.api;

public abstract class GameWeapon {

    private final String name;
    private final Double attack;
    private final Double defense;

    public GameWeapon(String name, Double attack, Double defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }
    
    // getters e setters das armas

    public String getName() {
        return name;
    }

    public Double getAttack() {
        return attack;
    }

    public Double getDefense() {
        return defense;
    }
}
