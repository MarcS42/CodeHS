import java.util.ArrayList;

public class WeatherData {
    /** Guaranteed not to be <code>null</code> and to contain only
     * non-<code>null</code> entries */
    private final ArrayList<Double> temperatures;

    public WeatherData(double[] tempsIn){
        temperatures = new ArrayList<>();
        for (double v : tempsIn)
        {
            temperatures.add(v);
        }
    }

    /** Cleans data by removing from <code> temperatures </code> all values
     * that are less than <code>lower</code> and all values greater than
     * <code>upper</code>.
     */
    public void cleanData(double lower, double upper)
    {
        for (int i = temperatures.size() - 1; i >= 0 ; i--)
        {
            if(temperatures.get(i) < lower || temperatures.get(i) > upper)
                temperatures.remove(i);
        }
    }

    /** Returns the length of the longest 'heat wave' found in
     * <code>temperatures</code>. Heat wave is >= 2 consecutive days t>threshold
     * Precondition: There is at least one heat wave contained in
     * <code>temperatures</code> based on <code>threshold</code>
     */
    public int longestHeatWave(double threshold)
    {
        int bsf = 1, count = 1;
        double prevTemp, nextTemp;
        for (int i = 1; i < temperatures.size(); i++)
        {
            prevTemp = temperatures.get(i-1);
            nextTemp = temperatures.get(i);
            if (prevTemp > threshold && nextTemp > threshold) count++;
            else if (count > bsf)
            {
                bsf = count;
                count = 1;
            }
        }
        return bsf;
    }

    public static void main(String[] args)
    {
        double[] loadMe1 = {99.1, 142.0, 85.0, 85.1, 84.6, 94.3, 124.9, 98.0,
                101.0, 102.5};
        double[] loadMe2 = {100.5, 98.5, 102.0, 103.9, 87.5, 105.2, 90.3,
                94.8, 109.1, 102.1, 107.4, 93.2};

        WeatherData w1 = new WeatherData(loadMe1);
        WeatherData w2 = new WeatherData(loadMe2);
        WeatherData w3 = new WeatherData(loadMe2);

        System.out.println("TempsIn: ");
        for(Double t: w1.temperatures) System.out.print(t + " ,");

        w1.cleanData(85.0,120.0);
        System.out.println("\nCleaned TempsOut: ");
        for(Double t: w1.temperatures) System.out.print(t + " ,");
        System.out.println();

        System.out.println("TempsIn: ");
        for(Double t: w2.temperatures) System.out.print(t + " ,");

        double threshold = 100.5;
        int days = w2.longestHeatWave(threshold);
        System.out.printf("%nThreshold %1$.1f %nHeat Wave Days: %2$d %n%n",
                threshold, days);

        System.out.println("TempsIn: ");
        for(Double t: w3.temperatures) System.out.print(t + " ,");

        threshold = 95.2;
        days = w3.longestHeatWave(threshold);
        System.out.printf("%nThreshold %1$.1f %nHeat Wave Days: %2$d %n%n",
                threshold, days);



    }
}
