package com.gustavostorb.heroesofoop.game;

import com.gustavostorb.heroesofoop.api.GameChar;
import com.gustavostorb.heroesofoop.api.GameCharType;
import com.gustavostorb.heroesofoop.game.characters.Dragon;
import com.gustavostorb.heroesofoop.menu.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final List<GameChar> characters; // variavel privada de lista dos personagens
    private final GameChar dragon; // variavel privada do dragao

    private GameChar defensiveChar; // variavel do modo defensivo
    private Integer stage; // variavel tipo Integer para contar o round/stage

    public Game() {
        this.characters = new ArrayList<>(); // cria uma nova lista de personagens
        this.dragon = new Dragon(); // cria um novo dragão
        this.defensiveChar = null; // seta o modo defensivo do personagem para 0 ou null.
        this.stage = 0; // define o round/stage para 0
    }

    
    public void start() {
        try {
            StartGameMenu startGameMenu = new StartGameMenu();
            Integer gameMenu = startGameMenu.execute();
            if(gameMenu == 0) return;

            if(gameMenu == 1) { // 1 = criar personagem
                if(this.characters.size() >= 3) { // verifica se voce possui 3 personagens
                    JOptionPane.showMessageDialog(null, "Você já possuí 3 personagens.", "AVISO", JOptionPane.ERROR_MESSAGE); // mensagem de erro caso voce ja tenha criado mais 3 personagens
                    this.start();
                    return;
                }

                GameChar gameChar = this.startCharacterCreationStage(); // inicio a criação do personagem.
                if(gameChar == null) return;
                characters.add(gameChar); // adiciono na lista de personagens do jogo.
                this.start(); // retorno para o menu inicial.
                return;
            }

            if(this.characters.size() < 1) { // verifica se voce possui no minimo 1 personagem
                JOptionPane.showMessageDialog(null, "Você não possuí nenhum personagem.", "AVISO", JOptionPane.ERROR_MESSAGE); // mensagem de erro caso voce não possua nenhum personagem
                this.start();
                return;
            }

            this.nextStage(); // começo o próximo round.
        } catch(Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Opcão Invalida", "AVISO", JOptionPane.ERROR_MESSAGE);
            this.start();
        }
    }

    private void nextStage() {
        try {
            if(this.characters.size() <= 0) { // verificação para saber se todos os personagem morreram.
                JOptionPane.showMessageDialog(null, "Todos os seus personagens morreram.", "VOCÊ PERDEU!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean dragonIsDead = this.dragon.getHealth() <= 0.0; // verificação pra saber se a vida do dragão é menor ou igual a 0. retorna true/false
            if(dragonIsDead) {
                JOptionPane.showMessageDialog(null, "Parabéns, você derrotou o dragão e ganhou Heroes Of OOP.", "UHUUU VITÓRIA!", JOptionPane.OK_OPTION); // mensagem caso voce derrote o dragão
                return;
            }

            this.stage++; // avanço o número do round

            boolean isDragonStage = this.stage % 2 == 0; // Caso seja par sera um round de dragão. 2, 4, 6 etc.
            if(isDragonStage) {
                Random random = new Random(); // cria uma variavel aleatoria (LIB)
                GameChar randomChar = this.characters.get(random.nextInt(this.characters.size())); // pegar um personagem aleatório baseado em quantos personagens voce tem
                Double defense = randomChar.getDefense(); // apos ser aleatorizado pega a defesa de tal personagem
                if(defensiveChar == randomChar) {
                    int extraDefense = (int) ((10.0 / 100.0) * defense); // adiciona 10% de defesa a defesa do personagem caso ele esteja no modo defensivo
                    defense += extraDefense; 
                }

                double damage = dragon.getAttack() - defense; // ATAQUE DO DRAGÃO - DEFESA DO PERSONAGEM ALEATORIO

                if(damage == 0) {
                    JOptionPane.showMessageDialog(null, "O personagem " + randomChar.getName() + " se defendeu do dragão com sucesso e não sofreu nenhum dano.", "SE SAFOU DESSA!.", JOptionPane.OK_OPTION); // if criado para mandar mensagem caso defesa do personagem = ataque do dragão.
                    this.nextStage();
                    return;
                }

                if(damage < 0) {
                    double receivedDamage = defense - dragon.getAttack();
                    dragon.removeHealth(receivedDamage);

                    JOptionPane.showMessageDialog(null, "O dragão tentou atacar o personagem " + randomChar.getName() + " e sofreu " + receivedDamage + " de dano, pois a defesa do personagem é maior que o ataque dele.", "BURRAO MANÉ", JOptionPane.OK_OPTION); // if criado para mandar mensagem caso a defesa do personagem seja maior que do dragão.
                    this.nextStage();
                    return;
                }

                if(randomChar.getHealth() <= damage) {
                    this.characters.remove(randomChar);
                    JOptionPane.showMessageDialog(null, "Nããããoo, o personagem " + randomChar.getName() + " foi morto pelo dragão.", "Personagem Morto.", JOptionPane.OK_OPTION); // mensagem caso dragão retire todos pontos de vida de algum personagem.
                    this.nextStage();
                    return;
                }

                randomChar.removeHealth((dragon.getAttack() - randomChar.getDefense())); // remove a vida do personagem selecionado.
                JOptionPane.showMessageDialog(null, "O dragão atacou " + randomChar.getName() + " e retirou " + damage + " de vida.", "AAAAA QUE DANO!", JOptionPane.OK_OPTION); // mensagem de quando o dragão ataca algum personagem aleatorio.
                this.nextStage();
                return;
            }

            SelectCharacterStageMenu selectCharacterStageMenu = new SelectCharacterStageMenu(this);
            GameChar gameChar = selectCharacterStageMenu.execute(); 
            if(gameChar == null) return;

            SelectCharacterStageModeMenu selectCharacterStageModeMenu = new SelectCharacterStageModeMenu();
            Integer mode = selectCharacterStageModeMenu.execute();
            if(mode == 0) return;

            this.defensiveChar = null;

            boolean isDefensiveMode = mode == 2;
            if(isDefensiveMode) {
                this.defensiveChar = gameChar;
                this.nextStage();
                return;
            }

            double damage = gameChar.getAttack() - dragon.getDefense();
            dragon.removeHealth(damage);

            JOptionPane.showMessageDialog(null, "O personagem " + gameChar.getName() + " atacou o dragão e retirou " + (int) damage + " de vida. Agora ele possuí " + dragon.getHealth() + " de vida restante.", "AAAAA ENTÃO TOMA!", JOptionPane.OK_OPTION); // mensagem de quando o personagem ataca o dragão e tira pontos de vida dele.
            this.nextStage();
        } catch(Exception ignored) {

        }

    }

    private GameChar startCharacterCreationStage() {
        SelectCharacterCreationTypeMenu selectCharacterCreationTypeMenu = new SelectCharacterCreationTypeMenu();
        GameCharType charType = selectCharacterCreationTypeMenu.execute();
        if(charType == null) return null;

        CreateCharacterCreationNameMenu createCharacterCreationNameMenu = new CreateCharacterCreationNameMenu();
        String charName = createCharacterCreationNameMenu.execute();
        if(charName == null) return null;

        SelectCharacterCreationWeaponMenu selectCharacterCreationWeaponMenu = new SelectCharacterCreationWeaponMenu(charName, charType);
        return selectCharacterCreationWeaponMenu.execute();
    }

    public List<GameChar> getCharacters() {
        return this.characters;
    }


}
