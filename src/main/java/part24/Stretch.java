package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–7 (overriding, and polymorphism)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B also changes CarefulBot.java, FlashyBot.java and Mission.java.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "open-room")
public class Stretch {
    public static void main(String[] args) {
        /* Stretch A — my guess:
           Prints:
             Flash! Turning left 90.0
             true
           a.straight(10) runs Chassis's straight (inherited), because FlashyBot does not
           override straight, so it prints nothing.
           c.turnLeft(90) runs FlashyBot's turnLeft, even though c is a Chassis variable,
           because the object is really a FlashyBot and the object decides.
           a == c is true because a and c are two names for the same object.
         */
        MBot2 a = new FlashyBot();
        Chassis c = a;
        a.straight(10);
        c.turnLeft(90);
        System.out.println(a == c);
        System.out.println(a);

        /* B4: With pick 3, the first line prints "Mission start: MBot2".
           A plain MBot2 uses MBot2's own toString, which gives back the robot's name, and
           new MBot2() uses the default name "MBot2". CarefulBot and FlashyBot override
           toString, but a plain MBot2 does not get their versions.
         */
    }
}
