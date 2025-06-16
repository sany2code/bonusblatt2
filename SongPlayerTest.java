package org.example.player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongPlayerTest {

    @Test
    public void testPlayTransitionFromReadyToPlaying() {
        SongPlayer player = new SongPlayer();
        assertEquals(SongState.BEREIT, player.getState());

        player.play();
        assertEquals(SongState.SPIELT, player.getState());
    }

    @Test
    public void testAllStatesInSequence() {
        SongPlayer player = new SongPlayer();

        assertEquals(SongState.BEREIT, player.getState());

        player.play();
        assertEquals(SongState.SPIELT, player.getState());

        player.pause();
        assertEquals(SongState.PAUSIERT, player.getState());

        player.resume();
        assertEquals(SongState.SPIELT, player.getState());

        player.onFinished();
        assertEquals(SongState.BEENDET, player.getState());
    }

    @Test
    public void testInvalidForwardFromReady() {
        SongPlayer player = new SongPlayer();
        player.forward();
        assertEquals(SongState.BEREIT, player.getState());
    }
}