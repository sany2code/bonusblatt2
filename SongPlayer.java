package org.example.player;

public class SongPlayer {
    private SongState currentState;

    public SongPlayer() {
        this.currentState = SongState.BEREIT;
    }

    public SongState getState() {
        return currentState;
    }

    public void play() {
        if (currentState == SongState.BEREIT || currentState == SongState.PAUSIERT) {
            currentState = SongState.SPIELT;
        } else {
            error("play");
        }
    }

    public void pause() {
        if (currentState == SongState.SPIELT) {
            currentState = SongState.PAUSIERT;
        } else {
            error("pause");
        }
    }

    public void resume() {
        if (currentState == SongState.PAUSIERT) {
            currentState = SongState.SPIELT;
        } else {
            error("resume");
        }
    }

    public void stop() {
        if (currentState == SongState.SPIELT || currentState == SongState.PAUSIERT) {
            currentState = SongState.BEREIT;
        } else {
            error("stop");
        }
    }

    public void onFinished() {
        if (currentState == SongState.SPIELT) {
            currentState = SongState.BEENDET;
        } else {
            error("onFinished");
        }
    }

    public void forward() {
        // Kein Zustandswechsel, aber nur gültig in SPIELT
        if (currentState != SongState.SPIELT && currentState != SongState.BEREIT) {
            error("forward");
        }
    }

    public void rewind() {
        // Kein Zustandswechsel, aber nur gültig in SPIELT
        if (currentState != SongState.SPIELT && currentState != SongState.BEREIT) {
            error("rewind");
        }
    }

    private void error(String action) {
        System.out.println("Aktion \"" + action + "\" im Zustand " + currentState + " nicht erlaubt.");
    }
}