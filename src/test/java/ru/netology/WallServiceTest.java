package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class WallServiceTest {

    @BeforeEach
    void clear() {
        WallService.clear();
    }

    @Test
    void add() {
        // given:
        Post post = new Post(689, 369, "Какой-то текст из первого поста");
        // when:
        Post result = WallService.add(post);
        // then:
        Assertions.assertEquals(1, result.getId());
    }

    @Test
    void updateTrue() {
        // given:
        Post post = new Post(689, 369, "Какой-то текст из первого поста");
        WallService.add(post);
        Post updatePost = new Post(1, 369, "Отредактированный текст");
        // when:
        boolean result = WallService.update(updatePost);
        // then:
        Assertions.assertTrue(result);
    }

    @Test
    void updateFalse() {
        // given:
        Post post = new Post(689, 369, "Какой-то текст из первого поста");
        WallService.add(post);
        // when:
        boolean result = WallService.update(post);
        // then:
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 369, true",
            "1, 368, false",
            "2, 368, false",
            "2, 369, false"
    })
    void update(int id, int ownerId, boolean expected) {
        // given:
        WallService.add(new Post(689, 369, "Какой-то текст из первого поста"));
        // when:
        boolean actual = WallService.update(new Post(id, ownerId, "Текст новый"));
        // then:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addUsingHamcrest() {
        // given:
        Post post = new Post(689, 369, "Какой-то текст из первого поста");

        // when:
        Post result = WallService.add(post);

        // then:
        assertThat("ID первого поста не зависит от входных данных и должен быть равен 1", result.getId(), is(1));
    }
}