//TODO Create a Race class, store races in a file, when person uses an unstored Race, prompt them to save as new Race

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select a race:");
        System.out.println("[1] Tahoe Trail 100");
        System.out.println("[2] Manually enter your race");
        System.out.print("Your selection: ");
        int selection = sc.nextInt();

        Race theRace = new Race(selection);

        int totalTime = readTargetTime();

        System.out.println();
        printTenMileSplits(theRace.getRaceDistance(), totalTime);
        System.out.println();
        printRaceSplits(theRace.getRaceDistance(), theRace.getStopDistances(), totalTime);
//        printFinishTime(theRace.getRaceDistance(), totalTime);

    }

    private static int readTargetTime() {

        Scanner sc = new Scanner(System.in);

//        System.out.println();

        System.out.print("Enter your target hours: ");
        int targetHours = sc.nextInt();

        System.out.print("Enter your target minutes: ");
        int targetMinutes = sc.nextInt();

        System.out.print("Enter your target seconds: ");
        int targetSeconds = sc.nextInt();

        return getTotalSeconds(targetHours, targetMinutes, targetSeconds);
    }

    private static int getTotalSeconds(int targetHours, int targetMinutes, int targetSeconds) {
        return targetHours*3600 + targetMinutes*60 + targetSeconds;
    }

//    private static void printFinishTime(double raceDistance, int totalTime) {
//
//        double finishTime;
//        int finishHours;
//        int finishMinutes;
//        int finishSeconds;
//
//        finishTime = totalTime;
//        finishHours = (int)finishTime/3600;
//        finishTime -= finishHours*3600;
//        finishMinutes = (int)finishTime/60;
//        finishTime -= finishMinutes*60;
//        finishSeconds = (int)finishTime;
//
//        System.out.println("Finish (" + raceDistance + "mi): " + String.format("%02d", finishHours) + ":" +
//                String.format("%02d", finishMinutes + ":" + String.format("%02d", totalTime)));
//        System.out.println("\nGOOD LUCK!!!");
//    }

    private static void printTenMileSplits(double raceDistance, int totalTime) {

        double splitTime;
        int splitHours;
        int splitMinutes;
        int splitSeconds;

        System.out.println("DIST     TIME");
        System.out.println("-----------------");


        for(int i = 10; i < raceDistance; i+=10) {
            splitTime = (i/raceDistance)*totalTime;
            splitHours = (int)splitTime/3600;
            splitTime -= splitHours*3600;
            splitMinutes = (int)splitTime/60;
            splitTime -= splitMinutes*60;
            splitSeconds = (int)splitTime;
            System.out.println(i + " mile: " + String.format("%02d", splitHours) + ":"
                    + String.format("%02d", splitMinutes) + ":" + String.format("%02d", splitSeconds));
        }
    }

    private static void printRaceSplits(double raceDistance, double[] stopDistances, int totalTime) {

        double splitTime;
        int splitHours;
        int splitMinutes;
        int splitSeconds;

        System.out.println("SPLIT    DIST      TIME");
        System.out.println("---------------------------");

        for(int i = 0; i <= stopDistances.length; i++) {
            if(i == stopDistances.length)
                splitTime = totalTime;
            else
                splitTime = (stopDistances[i]/raceDistance)*totalTime;
            splitHours = (int)splitTime/3600;
            splitTime -= splitHours*3600;
            splitMinutes = (int)splitTime/60;
            splitTime -= splitMinutes*60;
            splitSeconds = (int)splitTime;
            if(i == stopDistances.length) {
                System.out.println("Finish   (" + String.format("%.1f", raceDistance) + "mi): " + String.format("%02d", splitHours) + ":" + String.format("%02d", splitMinutes) + ":" + String.format("%02d", splitSeconds));
                System.out.println("\nGOOD LUCK!!!");
            } else
                System.out.println("Split #" + (i+1) + " (" + String.format("%.1f", stopDistances[i]) + "mi): " + String.format("%02d", splitHours) + ":"
                        + String.format("%02d", splitMinutes) + ":" + String.format("%02d", splitSeconds));
        }
    }
}
