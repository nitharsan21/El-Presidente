package Technic.Tools;

import Ressources.Faction;
import Ressources.GlobleVariables.FactionName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactionTools {

    public static List<FactionName> getListOfAllFactions(){
        return new ArrayList<>(Arrays.asList(FactionName.values()));
    }

}
