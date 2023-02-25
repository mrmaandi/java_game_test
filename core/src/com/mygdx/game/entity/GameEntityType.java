package com.mygdx.game.entity;

public enum GameEntityType {
    _4HEAD("4head", "4Head.png"),
    KAPPA("kappa", "Kappa.png");

    GameEntityType(String textValue, String img) {
        this.textValue = textValue;
        this.img = img;
    }

    public final String textValue;
    public final String img;
}
