package Ressources;

import Ressources.GlobleVariables.Difficulty;
import Ressources.GlobleVariables.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private int eventid;
    private String event;
    private Season season;
    private List<Choice> choices;
    private int subEvent;

    public Event(int eventid, String event, Season season, List<Choice> choices, int subEvent) {
        this.eventid = eventid;
        this.event = event;
        this.season = season;
        this.choices = choices;
        this.subEvent = subEvent;
    }

    public Event(){
        this.choices = new ArrayList<>();
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setSeason(String season) {
        this.season = Season.valueOf(season);
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public int getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(int subEvent) {
        this.subEvent = subEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event='" + event + '\'' +
                ", season=" + season +
                ", choices=" + choices +
                ", subEvent=" + subEvent +
                '}';
    }
}
