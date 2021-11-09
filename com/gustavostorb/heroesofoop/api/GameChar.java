package com.gustavostorb.heroesofoop.api;

public abstract class GameChar {

    private final String name; // variavel tipo string para armazenar nome do personagem
    private final GameCharType type; // variavel para armazenar o tipo do personagem (MAGE, ARCHER, WARRIOR)
    private final GameWeapon weapon; // variavel para armazenar o tipo de arma do personagem 
    private final Double attack; // variavel tipo double para armazenar o ataque dos personagens
    private final Double defense; // variavel tipo double para armazenar a defesa dos personagens
    private Double health; // variavel tipo double para armazenar a vida dos personagens

    public GameChar(String name, GameCharType type, GameWeapon weapon, Double attack, Double defense, Double health) {
        this.name = name;
        this.type = type;
        this.weapon = weapon;
        this.attack = this.weapon != null ? attack + this.weapon.getAttack() : attack;
        this.defense = this.weapon != null ? defense + this.weapon.getDefense() : attack;
        this.health = health;
    }

    // getters e setters dos personagens
    
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
