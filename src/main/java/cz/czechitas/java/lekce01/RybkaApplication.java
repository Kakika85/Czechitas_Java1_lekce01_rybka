package cz.czechitas.java.lekce01;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import cz.czechitas.java.playground.CzechitasGameApplication;
import cz.czechitas.java.playground.Kamen;
import cz.czechitas.java.playground.Rybka;
import javafx.scene.paint.Color;

public class RybkaApplication extends CzechitasGameApplication {
    private Rybka rybka;
    private Kamen kamen;

    private int kamenX = 200;
    private int kamenY = 200;

    private int rybkaX = 100;
    private int rybkaY = 100;

    private int delkaKroku = 10;
    private int steps = (int) ((kamenX - rybkaX) * 2 / delkaKroku);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setNative(true);
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Rybka Renata");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        FXGL.getGameScene().setBackgroundColor(Color.AQUA);
        super.initGame();
    }

    @Override
    protected void onStart() {
        kamen = new Kamen(kamenX, kamenY);
        rybka = new Rybka(rybkaX, rybkaY);
        gaming();
    }

    protected void gaming() {
        for (int x = 0; x <= steps; x++) {
            rybka.plavatVpravo();
        }
        for (int x = 0; x <= steps; x++) {
            rybka.plavatDolu();
        }
        for (int x = 0; x <= steps; x++) {
            rybka.plavatVlevo();
        }
        for (int x = 0; x <= steps; x++) {
            rybka.plavatNahoru();
        }
    }
}
