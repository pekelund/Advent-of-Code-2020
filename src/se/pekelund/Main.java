package se.pekelund;


import se.pekelund.dagar.December1;
import se.pekelund.dagar.December2;
import se.pekelund.dagar.December3;

public class Main {

    public static void main(String[] args) {
        December1 dag = new December1();
        dag.solve();

        new December2().solve();
        new December3().solve();
    }
}
