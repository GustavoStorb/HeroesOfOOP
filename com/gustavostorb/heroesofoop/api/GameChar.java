package com.gustavostorb.heroesofoop.api;

public abstract class GameChar {

    private final String name;
    private final GameCharType type;
    private final GameWeapon weapon;
    private final Double attack;
    private final Double defense;
    private Double health;

    public GameChar(String name, GameCharType type, GameWeapon weapon, Double attack, Double defense, Double health) {
        this.name = name;
        this.type = type;
        this.weapon = weapon;
        this.attack = this.weapon != null ? attack + this.weapon.getAttack() : attack;
        this.defense = this.weapon != null ? defense + this.weapon.getDefense() : attack;
        this.health = health;
    }

    // getters e setters
    
    public String getName() {
        return name;
    }

    public GameCharType getType() {
        return type;
    }

    public GameWeapon getWeapon() {
        return weapon;
    }

    public Double getAttack() {
        return attack;
    }

    public Double getDefense() {
        return defense;
    }

    public Double getHealth() {
        return health;
    }

    public void removeHealth(Double health) {
        this.health -= health;
    }

}
