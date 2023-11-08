package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallServiceTest {

    @BeforeEach
    void clear(){
        WallService.clear();
    }

    @Test
    void add() {
        // given:
        Post post = new Post(689,369,"Какой-то текст из первого поста");
        // when:
        Post result = WallService.add(post);
        // then:
        Assertions.assertEquals(1, result.getId());
    }

    @Test
    void updateTrue() {
        // given:
        Post post = new Post(689,369,"Какой-то текст из первого поста");
        WallService.add(post);
        Post updatePost = new Post(1,369,"Отредактированный текст");
        // when:
        boolean result = WallService.update(updatePost);
        // then:
        Assertions.assertTrue(result);
    }

    @Test
    void updateFalse() {
        // given:
        Post post = new Post(689,369,"Какой-то текст из первого поста");
        WallService.add(post);
        // when:
        boolean result = WallService.update(post);
        // then:
        Assertions.assertFalse(result);
    }
}