package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class WallService {
    private static int counter = 0;
    private static List<Post> posts = new ArrayList<>();

    public static Post add (Post post) {
        posts.add(new Post(++counter, post.getOwnerId(), post.getText()));
        return posts.get(posts.size() - 1);
    }

    public static Boolean update (Post post) {
        for (Post value : posts) {
            if (post.getId() == value.getId() && post.getOwnerId() == value.getOwnerId()) {
                value.setText(post.getText());
                return true;
            }
        }
        return false;
    }

    public static List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public static void clear() {
        posts = new ArrayList<>();
        counter = 0;
    }
}
