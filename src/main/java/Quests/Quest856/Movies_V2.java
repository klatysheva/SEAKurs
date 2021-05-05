package Quests.Quest856;

public class Movies_V2 {
    public static void main(String[] args) {
        String[] myFirstAdventureActors = {"Corey Carrier", "Margaret Tyzack", "Ruth de Sosa"};
        String[] passionForLifeActors = {"Corey Carrier", "Lloyd Owen", "Ruth de Sosa"};
        String[] travelsWithFatherActors = {"Corey Carrier", "Lloyd Owen", "Ruth de Sosa"};


        Movie myFirstAdventure = new Movie("My first adventure", myFirstAdventureActors);
        Movie passionForLife = new Movie("Passion for Life", passionForLifeActors);
        Movie travelsWithFather = new Movie("Travels with Father", travelsWithFatherActors);
        Movie [] movies;
        movies = new Movie [] {
                myFirstAdventure,
                passionForLife,
                travelsWithFather
        };
        for (Movie movie : movies) {
            System.out.print("In the movie " + movie.getTitle() + ", the main actors are: ");
            for (int i = 0; i < movie.getActors().length; i++) {
                System.out.print(movie.getActors()[i]);
                if (i != (movie.getActors().length - 1)) {
                    System.out.print("; ");
                }
                else {
                    System.out.println(".");
                }

            }
        }
    }
}
