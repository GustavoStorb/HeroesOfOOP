package com.gustavostorb.heroesofoop.api;

public abstract class GameWeapon { // Classe

    private final String name; // variavel tipo string para armazenar o nome das armas
    private final Double attack; // variavel tipo double para armazenar o valor do ataque das armas
    private final Double defense; // variavel tipo double para armazenar o valor de defesa das armas

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
