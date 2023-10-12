package at.campus02.iwi;

public class Promotion {
    private int year;
    private String benefit;

    public Promotion(int year, String benefit) {
        this.year = year;
        this.benefit = benefit;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "year=" + year +
                ", benefit='" + benefit + '\'' +
                '}';
    }
}
