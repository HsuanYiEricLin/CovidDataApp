package com.zegroup.models;

public class SummaryModel {
    private String country;
    private long maxConfirmed;
    private long minConfirmed;
    private long averageConfirmed;
    private long totalConfirmed;
    private int rangeCount;

    public SummaryModel(String country) {
        this.country = country;
    }

    public SummaryModel(String country, long max, long min, long total, int days) {
        this.country = country;
        this.maxConfirmed = max;
        this.minConfirmed = min;
        this.totalConfirmed = total;
        this.rangeCount = days;
        this.averageConfirmed = calculateAverage();
    }

    private long calculateAverage() {
        return totalConfirmed / (long)rangeCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getMaxConfirmed() {
        return maxConfirmed;
    }

    public void setMaxConfirmed(long maxConfirmed) {
        this.maxConfirmed = maxConfirmed;
    }

    public long getMinConfirmed() {
        return minConfirmed;
    }

    public void setMinConfirmed(long minConfirmed) {
        this.minConfirmed = minConfirmed;
    }

    public long getAverageConfirmed() {
        return averageConfirmed;
    }

    public void setAverageConfirmed(long averageConfirmed) {
        this.averageConfirmed = averageConfirmed;
    }

    public long getTotal() {
        return totalConfirmed;
    }

    public void setTotal(long total) {
        this.totalConfirmed = total;
    }

    public int getRangeCount() {
        return rangeCount;
    }

    public void setRangeCount(int rangeCount) {
        this.rangeCount = rangeCount;
    }
}
