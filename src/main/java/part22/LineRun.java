package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and follows the loop of tape all the way round.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Loads the "line-track" world in the simulator.
@MBotLab(world = "line-track")
// Declares the class that holds the program.
public class LineRun {
    // The starting point of the program.
    public static void main(String[] args) {
        // Makes a rover named Tracker.
        Rover rover = new Rover("Tracker");
        // Follows the tape for 400 steps, about halfway round.
        rover.followLine(400);
        // Prints a halfway message.
        System.out.println("Halfway round");
        // Follows the tape 325 more steps to finish the lap.
        rover.followLine(325);
        // Prints that the rover finished a lap.
        System.out.println(rover + " finished a lap");
    }
}
