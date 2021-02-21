package Technic.Tools;

import Luncher.MainApp;
import Ressources.Event;
import Ressources.GlobleVariables.Season;

import java.util.ArrayList;
import java.util.List;

public class EventTools {
    public static List<Event> getLunchableEvents(){
        List<Event> listEvents = new ArrayList<>();
        for(Event event : MainApp.events){
            if(event.getSeason().equals(MainApp.island.getSeason())
                    || event.getSeason().equals(Season.ALL) ){
                listEvents.add(event);
            }
        }
        return listEvents;
    }

}
