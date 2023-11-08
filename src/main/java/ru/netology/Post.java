package ru.netology;

public class Post {
    private final int id;
    private final int ownerId;
    private String text;

    public Post(int id, int ownerId, String text) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
