import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        // Adding first 10 elements in each set
        for (int i = 1; i <= 10; i++) {
            // Adding squares to the the squares set
            squares.add(i * i);
            // Adding cubes to the cubics set
            cubes.add(i * i * i);
        }

        Set<Integer> squaresOnly = new HashSet<>(squares);
        Set<Integer> cubesOnly = new HashSet<>(cubes);
        Set<Integer> union = new HashSet<>(squares);
        Set<Integer> intersection = new HashSet<>(squares);
        Set<Integer> symmetricDifference = new HashSet<>(union);
        squaresOnly.removeAll(cubes);
        cubesOnly.removeAll(squares);
        union.addAll(cubes);
        intersection.retainAll(cubes);
        symmetricDifference.removeAll(intersection);


        System.out.println("The size of the union set is " + union.size() + " elements\n");

        printSet(cubes,"cubic elements");
        printSet(squares,"squares");
        printSet(union,"all elements in the cubic and squares set");
        printSet(cubesOnly,"cubes without squares");
        printSet(squaresOnly,"squares without cubes");
        printSet(symmetricDifference,"Symmetric Difference");
        printSet(intersection,"shared values");

        System.out.println("Intersection contains " + intersection.size() + " elements");
        for (int i : intersection) {
            System.out.println("\t" +i + " is a member of both sets as it is " + Math.sqrt(i) + " squared, and is " + Math.cbrt(i) + " cubed.");
        }

    }

    private static void printSet(Set<Integer> set, String setType){

        System.out.println("The set of elements in the set of " + setType + " are: ");
        for(Integer i : set){
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }


}
