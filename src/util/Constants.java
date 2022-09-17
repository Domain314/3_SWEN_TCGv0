package util;

import java.util.Random;

public class Constants {
    public static final int MAX_ROUNDS_PER_GAME = 100;
    public static final int CARDS_PER_DECK = 4;
    public static final int CARDS_PER_PACKAGE = 5;
    public static final int RANDOM_ELEMENT_CHANCE = 6;
    public static final int RANDOM_TYPE_CHANCE = 8;
    public static final int RANDOM_ID_FROM = 100000;
    public static final int RANDOM_ID_TO = 999999;
    public static final int RANDOM_DAMAGE_FROM = 1;
    public static final int RANDOM_DAMAGE_TO = 20;

    public static final Random RANDOM = new Random();

    public static final float[][] ELEMENT_MATRIX = {
            {1.0f, 0.5f, 2.0f, -0.5f, 1.25f},
            {2.0f, 1.0f, -0.5f, 0.5f, 1.25f},
            {0.5f, -0.5f, 1.0f, 2.0f, 1.25f},
            {-0.5f, 2.0f, 0.5f, 1.0f, 1.25f},
            {0.75f, 0.75f, 0.75f, 0.75f, 1.0f},
    };

}
