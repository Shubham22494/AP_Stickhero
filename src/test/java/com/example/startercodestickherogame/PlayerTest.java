package com.example.startercodestickherogame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    public void testIsAliveReturnsTrueInitially() {
        // Arrange
        Player player = new Player("stickhero");  // Instantiate your Player class

        // Act
        boolean isAlive = player.isAlive();

        // Assert
        assertTrue(isAlive);
    }
}