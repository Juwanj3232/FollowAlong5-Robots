package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Tells the simulator to load the "wall-ahead" world for this program.
@MBotLab(world = "wall-ahead")
// Declares the class that holds our program.
public class FollowAlong {
    // The starting point; Java runs this method first.
    public static void main(String[] args) {
        // Makes a new Rover named Scout and stores it in scout.
        Rover scout = new Rover("Scout");
        // Prints the rover's name followed by "is ready".
        System.out.println(scout + " is ready");

        // Tells the rover to drive forward until something is close ahead.
        scout.driveUntilBlocked();
        // Prints a message saying the rover stopped near the wall.
        System.out.println(scout + " stopped. Something is less than 20 cm ahead.");
    }

}
