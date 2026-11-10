package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3–6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and sends it round the box to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Loads the "obstacles" world in the simulator.
@MBotLab(world = "obstacles")
// Declares the class that holds the program.
public class ObstacleRun {
    // The starting point of the program.
    public static void main(String[] args) {
        // Makes a rover named Dash.
        Rover rover = new Rover("Dash");
        // Tells the rover to go round the box and reach the goal.
        rover.reachGoal();
        // Prints that the rover reached the goal.
        System.out.println(rover + " reached the goal");
    }
}
