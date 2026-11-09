package part21;

import mbot.Chassis;
import mbot.Ultrasonic;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.

// Declares the Rover class, a blueprint for making rover robots.
public class Rover {
    // Stores the rover's name; private so only this class can touch it.
    private String name;
    // The rover has a Chassis, which does the driving.
    private Chassis base;
    // The rover has an Ultrasonic sensor, which it uses to see distances.
    private Ultrasonic eyes;

    // Constructor: runs when we make a new Rover and takes its name.
    public Rover(String name) {
        // Saves the name that was passed in into this rover's name field.
        this.name = name;
        // Builds a new Chassis for this rover to drive with.
        this.base = new Chassis();
        // Builds an Ultrasonic sensor attached to the chassis.
        this.eyes = new Ultrasonic(base);
    }

    // Controls how a Rover prints as text.
    public String toString() {
        // Gives back the name plus " the rover", ex. "Scout the rover".
        return name + " the rover";
    }

    // Answers true/false: is something closer than cm centimeters ahead?
    public boolean somethingAhead(double cm) {
        // Reads the sensor distance and returns true if it is less than cm.
        return eyes.distance() < cm;
    }

    // Drives forward until something gets close, then stops.
    public void driveUntilBlocked() {
        // Keeps looping as long as nothing is within 20 cm ahead.
        while (!somethingAhead(20)) {
            // Moves the chassis straight forward 5 units each loop.
            base.straight(5);
        }
    }

}
