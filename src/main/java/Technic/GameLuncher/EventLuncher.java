package Technic.GameLuncher;

import Luncher.MainApp;
import Ressources.Choice;
import Ressources.Event;
import Technic.Tools.DisplayInformation;
import Technic.Tools.EventTools;
import Technic.Tools.InputActionString;
import Technic.Update.UpdateIsland;

import java.util.Random;

import java.util.List;

public class EventLuncher {

    /**
     * luncher of ramdom event with the help of ramdom function in math.
     */
    public static void lunchRandomEvent(){
        try{
            Event event = EventLuncher.getRandomEvent();
            EventLuncher.lunchEvent(event);

        }catch (Exception ex){

        }
    }

    /**
     * event luncher that verifer the sub event
     * @param event object Event
     */
    public static void lunchEvent(Event event){
        Choice choice = InputActionString.displayAndGetActions(event);
        new UpdateIsland().updateIsland(choice);
        if(event.getSubEvent() != 0){
            Event subEvent = EventLuncher.getEventWithIdFromList(event.getSubEvent());
            if(subEvent != null){
                lunchEvent(subEvent);
            }
        }
    }


    /**
     * get a random event for a spacifique saison
     * @return event
     */
    public static Event getRandomEvent(){
        List<Event> listevents = EventTools.getLunchableEvents();
        Random rand = new Random();
        Event randomEvent = listevents.get(rand.nextInt(listevents.size()));
        return randomEvent;
    }

    /**
     * get event by idevent
     * @param id eventid
     * @return class event
     */
    public static Event getEventWithIdFromList(int id){
        for (Event event : MainApp.events){
            if(event.getEventid() == id){
                return event;
            }
        }
        return null;
    }

}
