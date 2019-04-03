package Doolhof.Classes;

/**
 * Created by sjoer on 2-4-2019.
 */
public class levels {

    public static int[][] sleutels(int index){
        int[][][] sleutels = {
                {
                        {2, 2, 300}, {6, 2, 100}, {2, 8, 300}, {6, 4, 100}
                },
                {
                        {1, 1, 100}
                }
        };
        return sleutels[index];
    }

    public static int[][] barricades(int index){
        int[][][] barricades = {
                {{3, 0, 300}, {0, 3, 100}, {2, 3, 200}, {2, 1, 200}, {3, 2, 200}, {5, 0, 200}, {7, 0, 300}, {4,1, 300}, {6,1, 300}, {8,1, 300}, {5,2, 300}, {7,2, 200}, {4,3, 200}, {6,3, 200}, {8,3, 300}, {1,4, 100}, {3,4, 100}, {5,4, 200}, {7,4, 200}, {0,5, 200}, {2,5, 200}, {4,5, 100}, {6,5, 300}, {8,5, 300}, {1,6, 100}, {3,6, 100}, {5,6, 200}, {7,6, 300}, {0,7, 100}, {2,7, 200}, {4,7, 200}, {6,7, 200}, {8,7, 200}, {1,8, 100}, {3,8, 100}, {5,8, 100}, {7,8, 100}},
                {{2, 2, 200}}
        };
        return barricades[index];
    }

    public static int[][] muren(int index){
        int[][][] muren = {
                {{1, 1}, {1, 3}, {1, 5}, {1, 7}, {1, 9}, {3, 1}, {3, 3}, {3, 5}, {3, 7}, {3, 9}, {5, 1}, {5, 3}, {5, 5}, {5, 7}, {5, 9}, {7, 1}, {7, 3}, {7, 5}, {7, 7}, {7, 9}, {9, 1}, {9, 3}, {9, 5}, {9, 7}, {9, 9}},
                {{3, 3}}
        };
        return muren[index];
    }

    public static int[] speler(int index){
        int[][] speler = {
                {0,0},
                {0,0}
        };
        return speler[index];
    }

    public static int[] eindveld(int index){
        int[][] eindveld = {
                {9,9},
                {9,9}
        };
        return eindveld[index];
    }

    public static void getLevel(){
        int[] levelId = {1};
        int randomInt = (int) Math.random()*(levelId.length-1);
        int[][] sleutelArray = sleutels(randomInt);
        Sleutel.setLocatie(sleutelArray);
        int[][] barricadeArray = barricades(randomInt);
        Barricade.setLocatie(barricadeArray);
        int[][] murenArray = muren(randomInt);
        Muur.setLocatie(murenArray);
        int[] spelerArray = speler(randomInt);
        Speler.setLocatie(spelerArray);
        int[] eindveldArray = eindveld(randomInt);
        Eindveld.setLocatie(eindveldArray);
        Speelveld.setLevel(randomInt);
        System.out.println("Klaar met laden level");
    }

    public static void getLevel(int level){
        int[][] sleutelArray = sleutels(level);
        Sleutel.setLocatie(sleutelArray);
        int[][] barricadeArray = barricades(level);
        Barricade.setLocatie(barricadeArray);
        int[][] murenArray = muren(level);
        Muur.setLocatie(murenArray);
        int[] spelerArray = speler(level);
        Speler.setLocatie(spelerArray);
        int[] eindveldArray = eindveld(level);
        Eindveld.setLocatie(eindveldArray);
        Speelveld.setLevel(level);
        System.out.println("Klaar met laden level");
    }
}
