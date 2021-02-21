package Technic.Tools;

import Ressources.Choice;
import Ressources.Event;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class InputActionString {


    /**
     * display the event for the choice
     * @param event current event
     * @return choice of the president
     */
    public static Choice displayAndGetActions(Event event){
        int action;
        List<Choice> listChoice = event.getChoices();
        do{
            System.out.println("\n" + event.getEvent());
            for(int i = 0; i<listChoice.size();i++){
                System.out.println( i+1 + " - " + listChoice.get(i).getChoice());
            }
            System.out.print("\nAction : ");
            try{
                action = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                if(action < 0 || action >listChoice.size()){
                    System.out.println(DisplayStyle.ANSI_RED+" !!! - Action INCONNU - Entrez un nombre - !!! "+ DisplayStyle.ANSI_RESET);
                    action = 0;
                }
            }catch (Exception ex){
                action = 0;
            }
        }while(action == 0);
        return listChoice.get(action-1);
    }


    public static int displayAndGetActionsWithString(String actions){
        int action ;
        String[] desision;
        desision = actions.split(",");
        do{
            System.out.println("\n\nxxxxxxxxxxxxxxxxx			SELECTION D'UN ACTION				xxxxxxxxxxxxxx\n");
            for(int i = 0; i<desision.length;i++){
                System.out.println( i+1 +" - " + desision[i]);
            }
            System.out.print("\nAction : ");
            try{
                action = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                if(action < 0 || action >desision.length){
                    System.out.println(DisplayStyle.ANSI_RED+" !!! - Action INCONNU - Entrez un nombre - !!! "+ DisplayStyle.ANSI_RESET);
                    action = 0;
                }
            }catch (Exception ex){
                action = 0;
            }
        }while(action == 0);
        return action;
    }



}
