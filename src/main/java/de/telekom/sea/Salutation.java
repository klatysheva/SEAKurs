package de.telekom.sea;

import java.util.Locale;

public enum Salutation {

    MR,
    MRS,
    MISS;

//    MR(1, "Mr."),
//    MRS(2, "Ms."),
//    MISS(3, "Miss");
//
//    int index;
//    String salutation;
//
//    private Salutation(int index, String s) {
//        this.index = index;
//        this.salutation = s;
//    }

    public static Salutation fromString(String str) {
        switch (str.toLowerCase(Locale.ROOT)) {
            case "mr":
            case "mr.":
            case "mister":
                return MR;
            case "mrs":
            case "mrs.":
            case "misses":
                return MRS;
            case "miss.":
            case "miss":
                return MISS;
            default:
                throw new IllegalArgumentException("Unexpected value: " + str);
        }
    }

    @Override
    public String toString () {
        switch (this) {
            case MRS:
                return "Mrs.";
            case MR:
                return "Mr.";
            case MISS:
                return "Miss.";
            default :
                throw new IllegalArgumentException("Unexpected case!");
        }
    }

}
