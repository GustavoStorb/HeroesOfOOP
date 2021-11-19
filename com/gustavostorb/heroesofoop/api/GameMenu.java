package com.gustavostorb.heroesofoop.api;

public abstract class GameMenu<T> { // clase abstrata para utilizar o execute em outras funções T é tipo um Object, tipo o que eu colocar nesse <> ele vai gerar o execute com o retorno q eu defini no T

    public abstract T execute();

}
