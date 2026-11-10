package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3, 5 and 6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Scout and sends it through the junctions to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Loads the "junctions" world in the simulator.
@MBotLab(world = "junctions")
// Declares the class that holds the program.
public class Explore {
    // The starting point of the program.
    public static void main(String[] args) {
        // Makes a scout named Pathfinder.
        Scout scout = new Scout("Pathfinder");
        // Repeats for 3 legs of the trip (leg 1, 2 and 3).
        for (int leg = 1; leg <= 3; leg++) {
            // Drives until blocked and saves how many moves it took.
            int moves = scout.driveUntilBlocked();
            // Prints the leg number and its moves.
            System.out.println("Leg " + leg + ": " + moves + " moves");
            // Only turns after legs 1 and 2, not after the last one.
            if (leg < 3) {
                // Turns toward the open side of the junction.
                scout.turnTowardOpenSide();
            }
        }
        // Prints that the scout reached the goal.
        System.out.println(scout + " reached the goal");
    }
}
