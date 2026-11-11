package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2, 5 and 7
//
// SECTION A — FOLLOW ALONG: type the mission method and the main method from the guide.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

// Loads the "wall-ahead" world in the simulator.
@MBotLab(world = "wall-ahead")
// Declares the class that holds the program.
public class Mission {

    // Runs a mission with ANY kind of MBot2 (CarefulBot, FlashyBot or a plain MBot2).
    public static void mission(MBot2 bot) {
        // Prints that the mission is starting, and which robot it is.
        System.out.println("Mission start: " + bot);
        // Runs this robot's own run method; which one depends on the robot's real class.
        bot.run();
        // Prints that the mission is finished, and the robot's final state.
        System.out.println("Mission done: " + bot);
    }

    // The starting point of the program.
    public static void main(String[] args) {
        // Picks which robot to use: 1, 2 or anything else.
        int pick = 1;
        // Makes a variable that can hold any kind of MBot2.
        MBot2 bot;
        // If pick is 1
        if (pick == 1) {
            // use a CarefulBot.
            bot = new CarefulBot();
        // Otherwise, if pick is 2
        } else if (pick == 2) {
            // use a FlashyBot.
            bot = new FlashyBot();
        // otherwise
        } else {
            // use a plain MBot2.
            bot = new MBot2();
        }
        // Sends the chosen robot on the mission.
        mission(bot);
    }
}
