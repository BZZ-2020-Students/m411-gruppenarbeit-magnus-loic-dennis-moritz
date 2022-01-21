package dev.modul411.sortiergruppenarbeit;

/**
 * This class measures the different values for the algorithms
 *
 * @author Magnus Götz
 * @version 1.0
 * @since 2022-01-18
 */
public class Measure {
    private long time;
    private long iterations;
    private long comparison;
    private int[] sortedArray;

    /**
     * Default constructor
     */
    public Measure() {
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time set the time
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @return the iterations done by the algorithm
     */
    public long getIterations() {
        return iterations;
    }

    /**
     * @param iterations sets the amount of iterations done by the algorithm
     */
    public void setIterations(long iterations) {
        this.iterations = iterations;
    }

    /**
     * @return the amount of comparisons made by the algorithm
     */
    public long getComparison() {
        return comparison;
    }

    public void setComparison(long comparison) {
        this.comparison = comparison;
    }

    /**
     * @return the sorted array
     */
    public int[] getSortedArray() {
        return sortedArray;
    }

    /**
     * @param sortedArray set the sorted array
     */
    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }
}
