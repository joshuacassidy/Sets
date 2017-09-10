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
        //Adding all of the elements from the square set to the squaresOnly set same, this is the same for each of these sets with the respective set being added
        Set<Integer> squaresOnly = new HashSet<>(squares);
        Set<Integer> cubesOnly = new HashSet<>(cubes);
        Set<Integer> union = new HashSet<>(squares);
        Set<Integer> intersection = new HashSet<>(squares);
        Set<Integer> symmetricDifference = new HashSet<>(union);
        // Removing all the cubes from the squares set
        squaresOnly.removeAll(cubes);
        cubesOnly.removeAll(squares);
        // Adding all the elements from the cube to to the union set
        union.addAll(cubes);
        // Removing all the elements that are not common to the intersection and cubes set
        intersection.retainAll(cubes);
        // Removing all elements the intersection from the symmetric difference set
        symmetricDifference.removeAll(intersection);

        System.out.println("The size of the union set is " + union.size() + " elements");
        System.out.println(cubes.containsAll(intersection) ? "The set of elements in the intersection is a subset of the cubes set\n" : "The set of elements in the intersection is not a subset of the cubes set\n");
        Set[] sets = {cubes,squares,squares,union,cubesOnly,squaresOnly,symmetricDifference,intersection};
        String[] setsDescription = {"The cubic set","The squares set","The universal set of the cubes and squares","The set of cubes without square","The set of squares without cubes","Symmetric Difference between the cubic and squares set","The intersection between the squares and cubic sets"};

        printSet(sets,setsDescription);

        System.out.println("The intersection set contains " + intersection.size() + " elements");
        for (int i : intersection) {
            System.out.println("\t" +i + " is a member of both sets as it is " + Math.sqrt(i) + " squared, and is " + Math.cbrt(i) + " cubed.");
        }
    }

    private static void printSet(Set[] sets, String[] setsDescription){
        for(int i = 0; i < sets.length-1; i++){
            System.out.println(setsDescription[i]);
            for(Object set : sets[i]){
                System.out.print(set + " ");
            }
            System.out.println("\n");
        }
    }
}
