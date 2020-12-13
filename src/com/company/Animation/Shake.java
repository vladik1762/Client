package com.company.Animation;


import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(100), node);
        tt.setFromX(0f);
        tt.setByX(5f);
        tt.setFromY(0f);
        tt.setByY(5f);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);
    }

    public void playAnim(){
        tt.playFromStart();
    }
}
