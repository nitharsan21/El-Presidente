package Technic.GameLuncher;

import Luncher.MainApp;
import Ressources.Choice;
import Ressources.Event;
import Technic.Tools.EventTools;
import Technic.Tools.InputActionString;

import java.util.Random;

import java.util.List;

public class EventLuncher {

    /**
     * luncher of ramdom event with the help of ramdom function in math.
     */
    public static void LunchRandomEvent(){
        try{
            Event event = EventLuncher.getRandomEvent();
            Choice choice = InputActionString.displayAndGetActions(event);
            System.out.println(choice);
        }catch (Exception ex){

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

}
