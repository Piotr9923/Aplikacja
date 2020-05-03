package com.example.peew;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;
    Ball ball;

    @Before
    public void setUp(){

        player=new Player();

        player.setX(100);
        player.setY(50);

        ball = new Ball(200,200);
        ball.setVx(0);
        ball.setVy(0);

    }

    @Test
    public void getTest() {
        assertEquals(100,(int)player.getX());
        assertEquals(50,(int)player.getY());
    }

    @Test
    public void updateTest() {

        player.setVy(10);
        player.setVx(30);

        player.update();

        assertEquals(130,(int)player.getX());
        assertEquals(60,(int)player.getY());    }




    @Test
    public void kickTest() {

        player.setKickedBall(ball);

        player.kick(100,100);

        assertTrue(ball.getVx()!=0);
        assertTrue(ball.getVy()!=0);
    }


}