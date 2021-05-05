package Quests.Quest856;

public class Movies_V1 {
    public static void main(String[] args) {

        String[] myFirstAdventure = {"Corey Carrier", "Margaret Tyzack", "Ruth de Sosa"};
        String[] passionForLife = {"Corey Carrier", "Lloyd Owen", "Ruth de Sosa"};
        String[] travelsWithFather = {"Corey Carrier", "Lloyd Owen", "Ruth de Sosa"};

        String[][] movies;
        movies = new String[][] {
                myFirstAdventure,
                passionForLife,
                travelsWithFather
        };

        for (String[] movie : movies) {
            System.out.print(movie + ": ");
            for (int i = 0; i < movie.length; i++) {
                System.out.print(movie[i]);
                if (i != (movie.length - 1)) {
                    System.out.print("; ");
                }
                else {
                    System.out.println(".");
                }
            }
        }

    }
}