package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–3 and 6
//
// Part 24 — overriding: your robot keeps a method's name, but changes what it does.
//
// SECTION A — FOLLOW ALONG: type the CarefulBot class from the guide.
//    Leave the "package part24;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

// Declares CarefulBot, a robot that IS-AN MBot2 but drives more carefully.
public class CarefulBot extends MBot2 {

    // Constructor: builds a new CarefulBot.
    public CarefulBot() {
        // Builds the MBot2 part first.
        super();
    }

    // Replaces MBot2's straight with a careful version that checks for walls first.
    @Override
    public void straight(double cm) {
        // Only drives if there is more than cm + 20 cm of space ahead.
        if (readUltrasonic() > cm + 20) {
            // Uses MBot2's normal straight to actually drive.
            super.straight(cm);
        // Otherwise it is too close to the wall...
        } else {
            // Turns light 1 red as a warning.
            turnLedOn(1, 255, 0, 0);
            // Prints that it refused to drive because it is too close.
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
        }
    }

    // Replaces MBot2's run with CarefulBot's own plan.
    @Override
    public void run() {
        // Repeats 5 times.
        for (int i = 0; i < 5; i++) {
            // Tries to drive 40 cm, using the careful straight above.
            straight(40);
        }
    }
}
