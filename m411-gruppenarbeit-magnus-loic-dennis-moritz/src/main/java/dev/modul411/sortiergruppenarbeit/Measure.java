package dev.modul411.sortiergruppenarbeit;

public class Measure {
    private long time;
    private long memory;
    private long comparison;
    private int[] sortedArray;

    public Measure(){
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public long getComparison() {
        return comparison;
    }

    public void setComparison(long comparison) {
        this.comparison = comparison;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }
}
