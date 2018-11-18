package net.tirgan.pediatrics.data;

public class HeadCircumferenceData {

    public final static String[] HEAD_CIRCUMFERENCE_AT_BIRTH = new String[]{"32.0", "32.5", "33.0", "33.5", "34.0", "34.5", "35.0", "35.5", "36.0", "36.5", "37.0"};

    private final static double[][][] head_circumference = new double[][][]{{{34.9, 35.3, 35.8, 36.3, 36.8, 37.3, 37.7, 38.2, 38.7, 39.1, 39.6},
            {36.8, 37.2, 37.7, 38.2, 38.6, 39.1, 39.5, 40.0, 40.5, 40.9, 41.5},
            {38.1, 38.5, 39.0, 39.5, 40.0, 40.5, 40.9, 41.4, 41.9, 42.3, 42.9},
            {39.2, 39.6, 40.1, 40.6, 41.1, 41.6, 42.0, 42.5, 43.0, 43.5, 44.0},
            {40.1, 40.5, 41.0, 41.5, 42.0, 42.6, 43.0, 43.5, 44.0, 44.5, 45.0},
            {40.9, 41.3, 41.8, 42.3, 42.8, 43.3, 43.7, 44.2, 44.7, 45.2, 45.8},
            {41.5, 41.9, 42.4, 42.9, 43.5, 44.0, 44.4, 44.9, 45.4, 45.9, 46.4},
            {42.0, 42.4, 43.0, 43.5, 44.0, 44.5, 44.9, 45.5, 46.0, 46.5, 47.0},
            {42.5, 42.9, 43.4, 43.9, 44.4, 45.0, 45.4, 46.0, 46.5, 47.0, 47.5},
            {42.9, 43.3, 43.8, 44.3, 44.9, 45.4, 45.9, 46.4, 46.9, 47.4, 47.9},
            {43.2, 43.6, 44.2, 44.7, 45.3, 45.8, 46.2, 46.7, 47.2, 47.7, 48.3},
            {43.5, 43.9, 44.5, 45.0, 45.5, 46.1, 46.5, 47.0, 47.6, 43.1, 48.6},
            {43.8, 44.2, 44.7, 45.3, 45.8, 46.3, 46.7, 47.3, 47.8, 48.4, 48.9},
            {44.0, 44.4, 45.0, 45.6, 46.1, 46.6, 47.0, 47.6, 48.1, 48.6, 49.2},
            {44.2, 44.7, 45.2, 45.7, 46.2, 46.8, 47.3, 47.8, 48.3, 48.8, 49.4},
            {44.4, 44.9, 45.4, 45.9, 46.4, 47.0, 47.5, 48.0, 48.5, 49.0, 49.6},
            {44.6, 45.0, 45.6, 46.1, 46.6, 47.2, 47.7, 48.2, 48.7, 49.2, 49.8},
            {44.7, 45.2, 45.7, 46.3, 46.8, 47.4, 47.9, 48.4, 48.9, 49.4, 50.0},
            {44.9, 45.4, 45.9, 46.4, 46.9, 47.5, 48.0, 48.5, 49.0, 49.5, 50.2},
            {45.0, 45.5, 46.1, 46.6, 47.1, 47.7, 48.2, 48.7, 49.3, 49.8, 50.4},
            {45.2, 45.7, 46.2, 46.7, 47.3, 47.8, 48.3, 48.8, 49.4, 50.0, 50.5},
            {45.3, 45.8, 46.4, 46.9, 47.4, 48.0, 48.5, 49.0, 49.5, 50.1, 50.7},
            {45.4, 45.9, 46.5, 47.0, 47.5, 48.1, 48.6, 49.1, 49.6, 50.2, 50.8},
            {45.5, 46.0, 46.6, 47.1, 47.6, 48.3, 48.8, 49.3, 49.8, 50.4, 51.0},
            {46.1, 46.6, 47.2, 47.8, 48.3, 48.9, 49.5, 50.0, 50.5, 51.1, 51.7},
            {46.6, 47.2, 47.8, 48.3, 48.9, 49.5, 50.0, 50.6, 51.1, 51.7, 52.3},
            {47.0, 47.6, 48.2, 48.7, 49.3, 49.9, 50.5, 51.0, 51.5, 52.1, 52.8},
            {47.3, 47.9, 48.5, 49.0, 49.6, 50.2, 50.7, 51.3, 51.8, 52.4, 53.1},
            {47.5, 48.1, 48.7, 49.3, 49.9, 50.5, 51.0, 51.6, 52.1, 52.7, 53.5},
            {47.7, 48.4, 49.0, 49.5, 50.1, 50.7, 51.3, 51.3, 52.3, 52.9, 53.7}},
            {{34.7, 35.2, 35.6, 36.2, 36.5, 37.2, 37.7, 38.1, 38.9, 39.2, 39.7},
                    {36.3, 36.8, 37.2, 37.8, 38.3, 38.9, 39.5, 39.9, 40.7, 41.0, 41.5},
                    {37.5, 38.1, 38.5, 39.1, 39.5, 40.2, 40.8, 41.2, 42.0, 42.3, 42.9},
                    {38.5, 39.1, 39.5, 40.1, 40.6, 41.2, 41.8, 42.2, 43.1, 43.5, 44.0},
                    {39.4, 40.0, 40.4, 41.1, 41.5, 42.1, 42.6, 43.2, 44.0, 44.4, 44.9},
                    {40.0, 40.7, 41.1, 42.7, 42.2, 42.8, 43.5, 43.9, 44.7, 45.1, 45.7},
                    {40.7, 41.3, 41.7, 42.3, 42.8, 43.5, 44.1, 44.6, 45.3, 45.8, 46.4},
                    {41.2, 41.8, 42.3, 43.0, 43.4, 44.1, 44.7, 45.3, 46.0, 46.4, 47.0},
                    {41.6, 42.3, 42.7, 43.4, 43.8, 44.5, 45.2, 45.7, 46.4, 46.8, 47.4},
                    {42.0, 42.7, 43.1, 43.7, 44.3, 45.0, 45.6, 46.0, 46.7, 47.3, 47.9},
                    {42.4, 43.0, 43.4, 44.2, 44.6, 45.3, 45.9, 46.4, 47.2, 47.7, 48.2},
                    {42.7, 43.3, 43.7, 44.5, 44.9, 45.6, 46.3, 46.7, 47.4, 47.9, 48.6},
                    {42.9, 43.6, 43.9, 44.7, 45.2, 45.9, 46.5, 46.9, 47.6, 48.2, 48.9},
                    {43.3, 43.9, 44.1, 45.0, 45.4, 46.2, 46.8, 47.2, 48.0, 48.5, 49.1},
                    {43.5, 44.1, 44.5, 45.3, 45.7, 46.4, 47.0, 47.5, 48.1, 48.7, 49.4},
                    {43.8, 44.3, 44.7, 45.5, 45.9, 46.7, 47.2, 47.7, 48.3, 48.9, 49.6},
                    {43.9, 44.5, 44.9, 45.7, 46.1, 46.9, 47.4, 47.8, 48.5, 49.1, 49.8},
                    {44.1, 44.7, 45.1, 45.8, 46.2, 47.0, 47.6, 43.0, 48.8, 49.3, 50.0},
                    {44.2, 44.8, 45.2, 46.0, 46.4, 47.2, 47.8, 48.2, 49.0, 49.5, 50.2},
                    {44.4, 45.0, 45.4, 46.2, 46.6, 47.4, 48.0, 48.5, 49.3, 49.7, 50.3},
                    {44.5, 45.1, 45.5, 46.3, 46.7, 47.5, 48.1, 48.6, 49.4, 49.8, 50.5},
                    {44.7, 45.3, 45.7, 46.5, 46.9, 47.7, 48.3, 48.7, 49.5, 50.0, 50.7},
                    {44.8, 45.4, 45.8, 46.6, 47.0, 47.8, 48.4, 48.9, 49.6, 50.1, 50.8},
                    {45.0, 45.6, 46.0, 46.8, 47.2, 48.0, 48.6, 49.0, 49.7, 50.3, 51.0},
                    {45.7, 46.3, 46.7, 47.5, 47.9, 48.7, 49.3, 49.7, 50.8, 51.0, 51.8},
                    {46.3, 46.9, 47.2, 48.0, 48.5, 49.3, 49.9, 50.3, 51.3, 51.6, 52.3},
                    {46.7, 47.3, 47.6, 48.5, 49.0, 49.8, 50.4, 50.7, 51.8, 52.1, 52.8},
                    {47.0, 47.6, 48.0, 48.9, 49.3, 50.2, 50.8, 51.2, 52.2, 52.5, 53.2},
                    {47.3, 47.9, 48.4, 49.2, 49.6, 50.5, 51.1, 51.5, 52.5, 52.8, 53.5},
                    {47.7, 48.3, 48.7, 49.5, 49.9, 50.8, 51.3, 51.7, 52.8, 53.1, 53.7}}};

    public static double getHeadCircumference(int aGender, int aAge, int aCircumferenceAtBirth) {
        int ageIndex = aAge - 1;
        return head_circumference[aGender][ageIndex][aCircumferenceAtBirth];
    }

}