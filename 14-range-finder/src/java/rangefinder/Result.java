package rangefinder;

import java.sql.Time;

public class Result {
    int resultid;
    int year;
    String event;
    String athlete;
    String medal;
    String country;
    Time result;

    public Result() {
    }

    public Result(int resultid, int year, String event, String athlete, String medal, String country, Time result) {
        this.resultid = resultid;
        this.year = year;
        this.event = event;
        this.athlete = athlete;
        this.medal = medal;
        this.country = country;
        this.result = result;
    }

    public int getResultid() {
        return resultid;
    }

    public int getYear() {
        return year;
    }

    public String getEvent() {
        return event;
    }

    public String getAthlete() {
        return athlete;
    }

    public String getMedal() {
        return medal;
    }

    public String getCountry() {
        return country;
    }

    public Time getResult() {
        return result;
    }
}
