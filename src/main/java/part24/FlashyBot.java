package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4 and 6
//
// SECTION A — FOLLOW ALONG: type the FlashyBot class from the guide.
//    Leave the package, import and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Declares FlashyBot, a robot that IS-AN MBot2 but flashes its light when it turns.
public class FlashyBot extends MBot2 {

    // Constructor: builds a new FlashyBot.
    public FlashyBot() {
        // Builds the MBot2 part first.
        super();
    }

    // Replaces MBot2's turnLeft with a flashy version.
    @Override
    public void turnLeft(double degrees) {
        // Prints that it is turning left and by how much.
        System.out.println("Flash! Turning left " + degrees);
        // Turns light 1 blue.
        turnLedOn(1, 0, 0, 255);
        // Uses MBot2's normal turnLeft to actually turn.
        super.turnLeft(degrees);
        // Turns light 1 off again.
        turnLedOff(1);
    }

    // Replaces MBot2's turnRight with a flashy version.
    @Override
    public void turnRight(double degrees) {
        // Prints that it is turning right and by how much.
        System.out.println("Flash! Turning right " + degrees);
        // Turns light 1 green.
        turnLedOn(1, 0, 255, 0);
        // Uses MBot2's normal turnRight to actually turn.
        super.turnRight(degrees);
        // Turns light 1 off again.
        turnLedOff(1);
    }

    // Replaces MBot2's run with FlashyBot's own plan: drive a square.
    @Override
    public void run() {
        // Repeats 4 times, once for each side of the square.
        for (int i = 0; i < 4; i++) {
            // Drives forward 40 cm.
            straight(40);
            // Turns left 90 degrees, using the flashy turnLeft above.
            turnLeft(90);
        }
    }
}
