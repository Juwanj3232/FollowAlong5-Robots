package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

// Declares Scout, a robot class that IS-AN MBot2, so it gets all of MBot2's methods.
public class Scout extends MBot2 {
    // The scout's name.
    private String name;
    // The scout HAS-A scanner it uses to look in several directions.
    private Scanner scanner;

    // Constructor: builds a scout with the given name.
    public Scout(String name) {
        // Builds the MBot2 part first (wheels, motors, sensors).
        super();
        // Saves the given name in this scout's name field.
        this.name = name;
        // Makes a scanner and plugs it into this scout.
        this.scanner = new Scanner(this);
    }

    // Drives forward until something is 25 cm or closer, and returns how many moves it made.
    public int driveUntilBlocked() {
        // Starts counting moves at zero.
        int moves = 0;
        // Keeps going while the ultrasonic (inherited from MBot2) reads more than 25 cm.
        while (readUltrasonic() > 25) {
            // Drives forward 5 cm using the inherited straight method.
            straight(5);
            // Adds one to the move count.
            moves++;
        }
        // Gives back how many moves it made.
        return moves;
    }

    // Scans all 7 directions and returns the index of the most open one.
    public int openestIndex() {
        // Scans and saves the 7 distances in an array.
        double[] d = scanner.scan();
        // Starts by assuming the first direction (index 0) is the most open.
        int best = 0;
        // Goes through the rest of the directions, starting at index 1.
        for (int i = 1; i < d.length; i++) {
            // If this direction is farther away than the best so far
            if (d[i] > d[best]) {
                // remember it as the new best.
                best = i;
            }
        }
        // Gives back the index of the most open direction.
        return best;
    }

    // Turns a quarter turn toward whichever side is most open.
    public void turnTowardOpenSide() {
        // Finds the index of the most open direction.
        int i = openestIndex();
        // If that direction's angle is positive, it is on the left
        if (Scanner.ANGLES[i] > 0) {
            // so turn left 90 degrees.
            turnLeft(90);
        // otherwise it is on the right (or straight ahead)
        } else {
            // so turn right 90 degrees.
            turnRight(90);
        }
    }

    // Controls how a Scout prints as text.
    public String toString() {
        // Gives back the name plus " the scout".
        return name + " the scout";
    }
}
