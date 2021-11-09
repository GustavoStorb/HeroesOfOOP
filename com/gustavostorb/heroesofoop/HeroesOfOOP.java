package com.gustavostorb.heroesofoop;

import com.gustavostorb.heroesofoop.game.Game;
import com.gustavostorb.heroesofoop.menu.CreateNewGameMenu;

public class HeroesOfOOP {

     private final Game game;

     public HeroesOfOOP() {
         this.game = new Game();
     }

     private void start() {
         this.game.start();
     }

    public static void main(String[] args) {
        CreateNewGameMenu createNewGameMenu = new CreateNewGameMenu();

        Integer newGameMenu = createNewGameMenu.execute();
        if(newGameMenu == 0) return;

         HeroesOfOOP game = new HeroesOfOOP();
         game.start();
    }

}
