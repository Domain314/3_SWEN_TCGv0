package util;

import java.util.Random;

public class Constants {
    public static final int MAX_ROUNDS_PER_GAME = 100;
    public static final int CARDS_PER_DECK = 4;
    public static final int CARDS_PER_PACKAGE = 5;
    public static final int RANDOM_ELEMENT_CHANCE = 6;
    public static final int RANDOM_TYPE_CHANCE = 10;
    public static final int RANDOM_ID_FROM = 100000;
    public static final int RANDOM_ID_TO = 999999;
    public static final int RANDOM_DAMAGE_FROM = 1;
    public static final int RANDOM_DAMAGE_TO = 20;
    private static final int ELO_CONSTANT = 50;

    public static final Random RANDOM = new Random();

    public static final float[][] ELEMENT_MATRIX = {
            {1.0f, 0.5f, 2.0f, 0.66f, 1.25f},
            {2.0f, 1.0f, 0.66f, 0.5f, 1.25f},
            {0.5f, 0.66f, 1.0f, 2.0f, 1.25f},
            { 0.66f, 2.0f, 0.5f, 1.0f, 1.25f},
            {0.75f, 0.75f, 0.75f, 0.75f, 1.0f},
    };

    public static int EloChange(float ratingWinner, float ratingLoser) {
        return (int)(ELO_CONSTANT * (1 - probability(ratingLoser, ratingWinner)));
    }
    private static float probability(float rating1, float rating2) {
        return 1.0f / (1 + (float) (Math.pow(10, (rating1 - rating2) / 400)));
    }


}
