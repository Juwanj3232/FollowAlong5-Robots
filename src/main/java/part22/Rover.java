package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

// Declares the Rover class, a blueprint for rovers that can drive, look and follow lines.
public class Rover {
    // The rover's name.
    private String name;
    // The chassis the rover drives with.
    private Chassis base;
    // The ultrasonic sensor that measures distance ahead.
    private Ultrasonic eyes;
    // The line sensor that looks at the tape on the floor.
    private LineSensor floor;
    // Remembers whether the tape was last seen on the left (starts false).
    private boolean lineWasLeft;

    // Constructor: builds a rover with the given name.
    public Rover(String name) {
        // Saves the given name in this rover's name field.
        this.name = name;
        // Makes the chassis first, because both sensors plug into it.
        this.base = new Chassis();
        // Plugs an ultrasonic sensor into the chassis.
        this.eyes = new Ultrasonic(base);
        // Plugs a line sensor into the chassis.
        this.floor = new LineSensor(base);
    }

    // Behavior: drives forward until something is cm or closer, and returns the number of moves.
    public int driveUntilBlocked(double cm) {
        // Starts counting moves at zero.
        int moves = 0;
        // Keeps going while the nearest thing ahead is farther than cm (checks the sensor every time).
        while (eyes.distance() > cm) {
            // Drives forward 5 cm.
            base.straight(5);
            // Adds one to the move count.
            moves++;
        }
        // Gives back how many moves it made.
        return moves;
    }

    // Behavior: slides the rover to the left by sideways cm, facing the same way after.
    public void goAroundLeft(double sideways) {
        // Turns left a quarter turn.
        base.turnLeft(90);
        // Drives sideways cm to get past the obstacle.
        base.straight(sideways);
        // Turns back to face the original direction.
        base.turnRight(90);
    }

    // Big behavior built from the small ones: go round the box and reach the goal.
    public void reachGoal() {
        // Drives to the box and saves how many moves it took.
        int first = driveUntilBlocked(15);
        // Prints how many moves it took to reach the box.
        System.out.println("Blocked after " + first + " moves. Going round.");
        // Steps 60 cm to the left to get past the box.
        goAroundLeft(60);
        // Drives forward again to the far wall and saves the moves.
        int second = driveUntilBlocked(15);
        // Prints how many moves it took to reach the far wall.
        System.out.println("Blocked after " + second + " moves. That is the far wall.");
        // Turns right to face the goal.
        base.turnRight(90);
        // Drives 50 cm into the goal.
        base.straight(50);
    }

    // Behavior: follows the tape for the given number of steps, steering toward it.
    public void followLine(int steps) {
        // Repeats once per step.
        for (int i = 0; i < steps; i++) {
            // Reads the line sensor once and saves the number.
            int s = floor.status();
            // If the tape is on the left side...
            if (s == 4 || s == 8 || s == 12) {
                // Turns left a little to steer toward it.
                base.turnLeft(4);
                // Remembers the tape was on the left.
                lineWasLeft = true;
            // Otherwise, if the tape is on the right side...
            } else if (s == 1 || s == 2 || s == 3) {
                // Turns right a little to steer toward it.
                base.turnRight(4);
                // Remembers the tape was on the right.
                lineWasLeft = false;
            // Otherwise, if no probe sees tape, the robot lost the line...
            } else if (s == 0) {
                // Uses its memory: was the tape last on the left?
                if (lineWasLeft) {
                    // Yes, so turn left to search for it.
                    base.turnLeft(4);
                // No, so it must have been on the right.
                } else {
                    // Turns right to search for it.
                    base.turnRight(4);
                }
            // Otherwise the tape is under the middle...
            } else {
                // Drives straight 1 cm.
                base.straight(1);
            }
        }
    }

    // Controls how a Rover prints as text.
    public String toString() {
        // Gives back the name plus " the rover".
        return name + " the rover";
    }

}
