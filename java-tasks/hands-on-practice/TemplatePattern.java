package org.example.practice;


abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    abstract  void cheerPlayers();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
    public final void cheer(){
        cheerPlayers();
    }
}

class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void cheerPlayers() {
        System.out.println("I am cheering");
    }
}


class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void cheerPlayers() {
        System.out.println("Football is good");
    }
}


 class TemplatePattern {
    public static void main(String[] args) {
        Game cricketGame = new Cricket();
        Game footballGame = new Football();

        System.out.println("Playing Cricket:");
        cricketGame.play();
        cricketGame.cheerPlayers();

        System.out.println("\nPlaying Football:");
        footballGame.play();
    }
}
