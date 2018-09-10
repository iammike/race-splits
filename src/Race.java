import java.util.Scanner;

public class Race {

    private double raceDistance;
    private double[] stopDistances;

    public Race(int raceSelection)
    {

        Scanner sc = new Scanner(System.in);

        if(raceSelection == 1) { // Tahoe 100
            stopDistances = new double[]{13.33, 24.3, 27.8, 31.9, 44.6, 55.4, 58.9};
            raceDistance = 63.1;
        } else if(raceSelection == 2){
            System.out.print("How long is your Race? ");
            raceDistance = sc.nextDouble();

            System.out.print("How many splits are there? ");
            int numSplits = sc.nextInt();
            stopDistances = new double[numSplits];

            for(int i = 0; i < numSplits; i++) {
                System.out.print("Enter the distance to Split #" + (i+1) + ": ");
                stopDistances[i] = sc.nextDouble();
            }
        } else
            throw new RuntimeException("Please enter a valid choice next time.");
    }

    public double getRaceDistance() {
        return raceDistance;
    }

    public double[] getStopDistances() {
        return stopDistances;
    }
}
