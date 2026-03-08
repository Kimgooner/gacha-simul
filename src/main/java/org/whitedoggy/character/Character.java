package org.whitedoggy.character;

public class Character {
    private final String name;
    private final CharacterGroup group;
    private final double score;

    public Character(String name, CharacterGroup group, double score) {
        this.name = name;
        this.group = group;
        this.score = score;
    }

    public CharacterGroup getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public double getScore() { return score; }
}