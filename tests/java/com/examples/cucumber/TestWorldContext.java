package com.examples.cucumber;

import model.Game;
import model.Virologist;
import model.map.Field;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWorldContext {
    static TestWorldContext instance;


    Field currentField;
    Virologist userPlayer;
    Virologist enemyPlayer;

    private TestWorldContext()
    {
    }

    public static TestWorldContext Instance()
    {
        if(instance == null)
            instance = new TestWorldContext();

        return instance;
    }
    public static TestWorldContext GetNewInstance()
    {
        instance = new TestWorldContext();
        return instance;
    }
}
