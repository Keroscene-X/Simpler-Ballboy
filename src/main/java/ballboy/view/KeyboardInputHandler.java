package ballboy.view;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import ballboy.model.GameEngine;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class KeyboardInputHandler{
    private final GameEngine model;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private Set<KeyCode> pressedKeys = new HashSet<>();

    private Map<String, MediaPlayer> sounds = new HashMap<>();

    KeyboardInputHandler(GameEngine model) {
        this.model = model;

        // TODO (longGoneUser): Is there a better place for this code?
        URL mediaUrl = getClass().getResource("/jump.wav");
        String jumpURL = mediaUrl.toExternalForm();

        Media sound = new Media(jumpURL);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        sounds.put("jump", mediaPlayer);
    }

    void handlePressed(KeyEvent keyEvent) {
        if (pressedKeys.contains(keyEvent.getCode())) {
            return;
        }
        pressedKeys.add(keyEvent.getCode());

        if (keyEvent.getCode().equals(KeyCode.UP)) {
            if (model.boostHeight()) {
                MediaPlayer jumpPlayer = sounds.get("jump");
                jumpPlayer.stop();
                jumpPlayer.play();
                model.stopBoostHeight();
            }
        }

        if (keyEvent.getCode().equals(KeyCode.LEFT)) {
            left = true;
        }
        else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
            right = true;
        }
        else if (keyEvent.getCode().equals(KeyCode.UP)) {
            up = true;
        }
        else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
            down = true;
        }
        else {
            return;
        }

        if (left) {
            model.moveLeft();
        }
        else if (right){
            model.moveRight();
        }
        else if (up) {
            model.boostHeight();
        }
        else if (down) {
            model.dropHeight();
        }
    }

    void handleReleased(KeyEvent keyEvent) {
        pressedKeys.remove(keyEvent.getCode());

        if (keyEvent.getCode().equals(KeyCode.LEFT)) {
            left = false;
            model.stop();
        }
        else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
            right = false;
            model.stop();
        }
        else if (keyEvent.getCode().equals(KeyCode.UP)) {
            up = false;
            model.stopBoostHeight();
        }
        else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
            down = false;
            model.stopDropHeight();
        }
        else {
            return;
        }

        if (down) {
            model.dropHeight();
        }
        else if (right) {
            model.moveRight();
        }
        else if (left) {
            model.moveLeft();
        }
        else if (up) {
            model.boostHeight();
        }
    }
}
