package Technic.Builder;

import Luncher.MainApp;
import Ressources.Choice;
import Ressources.Event;
import Ressources.Faction;
import Ressources.GlobleVariables.FactionName;
import Technic.Tools.DifficultyValues;
import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventBuilder {

    /**
     * build the events with the help of a json file
     *
     * @param file path of the json file with envents
     */
    public static void buildEvent(File file) {

        //JSON parser object to parse read file
        JsonParser jsonParser = new JsonParser();

        if ((file.exists() && !file.isDirectory())) {
            try (FileReader reader = new FileReader(file)) {

                //Read JSON file
                Object obj = jsonParser.parse(reader);

                JsonArray EventList = (JsonArray) obj;
//                System.out.println(EventList);

                //Iterate over Event array
                EventList.forEach(event -> parseEventObject((JsonObject) event));

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * changing the JsonObject to Class Event
     *
     * @param eventObject variable with all the data event
     */
    private static void parseEventObject(JsonObject eventObject) {
        //Get Event object within list
        JsonObject eventJson = (JsonObject) eventObject.get("event");

        //create events
        Event event = new Event();

        //Get idEvent
        int eventid = eventJson.get("eventid").getAsInt();
        event.setEventid(eventid);

        //Get Context
        String context = eventJson.get("context").getAsString();
        event.setEvent(context);

        //Get Season
        String season = eventJson.get("season").getAsString();
        event.setSeason(season);

        //Get subEventt
        int subEvent = eventJson.get("subEvent").getAsInt();
        event.setSubEvent(subEvent);

        //Get Choice
        List<Choice> choice = parseEventChoiseObject(eventJson.get("choices").getAsJsonArray());
        event.setChoices(choice);

        MainApp.events.add(event);
    }

    /**
     * changing the JsonObject to Class Choice for the event
     *
     * @param choiceObject variable with the data of choices for an event
     * @return list of choices defined in the  jsonObjet
     */
    private static List<Choice> parseEventChoiseObject(JsonArray choiceObject) {

        List<Choice> listchoices = new ArrayList<>();
        JsonArray choiceList = choiceObject.getAsJsonArray();
        for (int i = 0; i < choiceList.size(); i++) {
            JsonObject choiceJson = (JsonObject) choiceList.get(i);
            Choice newChoice = new Choice();

            //Get choice
            String choice = choiceJson.get("choice").getAsString();
            newChoice.setChoice(choice);

            //Get result Factions
            List<Faction> listresult = parseEventChoiseResultFactions(choiceJson.get("resultFactions").getAsJsonArray());
            newChoice.setResult(listresult);

            // Get result Ressources
            JsonArray resourceOject = choiceJson.get("resultResource").getAsJsonArray();
            for (int j = 0; j < resourceOject.size(); j++) {
                JsonObject resultJson = (JsonObject) resourceOject.get(j);
                String[] keys = resultJson.keySet().toArray(new String[0]);
                String nameResource = keys[0];
                double satifaction =  DifficultyValues.getValueWithDiffculty(resultJson.get(keys[0]).getAsDouble());
                newChoice.setResource(nameResource, satifaction);
            }

            //add choice to the list
            listchoices.add(newChoice);
        }


        return listchoices;
    }

    /**
     * Transform resiltObject into a HashMap with all the
     * list of satisfaction for the factions
     * @param resultObject object with all list of satisfaction for the factions
     * @return listResult
     */
    public static List<Faction> parseEventChoiseResultFactions(JsonArray resultObject) {
        List<Faction> listResult = new ArrayList<>();
        JsonArray resultList = resultObject.getAsJsonArray();
        for (int i = 0; i < resultList.size(); i++) {
            JsonObject resultJson = (JsonObject) resultList.get(i);
            String[] keys = resultJson.keySet().toArray(new String[0]);
            FactionName namefaction = FactionName.valueOf(keys[0]);
            double satifaction = DifficultyValues.getValueWithDiffculty(resultJson.get(keys[0]).getAsDouble());
            int partisans = resultJson.get("partisans").getAsInt();
            listResult.add(new Faction(namefaction, satifaction, partisans));
        }
        return listResult;
    }

}
