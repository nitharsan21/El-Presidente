package Ressources;

import Ressources.GlobleVariables.Season;
import java.util.List;

public class Event {
    private String event;
    private Season season;
    private List<Choice> choices;
    private Event subEvent;

    public Event(String event, Season season, List<Choice> choices, Event subEvent) {
        this.event = event;
        this.season = season;
        this.choices = choices;
        this.subEvent = subEvent;
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

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Event getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(Event subEvent) {
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
