import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static Set<String> notInBothTeams(Set<String> team1, Set<String> team2){

        if (team1==null || team2==null){
            throw new IllegalArgumentException("Parametar can't be null.");
        }

//        if (team1.isEmpty() && team2.isEmpty()){
//
//            throw new IllegalArgumentException("Both teams don't have members");
//        }
        Set<String> difference = new HashSet<String>(team1);
        difference.removeAll(team2);


        Set<String> difference2 = new HashSet<String>(team2);
        difference2.removeAll(team1);


        Set<String> uniqueIDs = new HashSet<String>(difference);
        uniqueIDs.addAll(difference2);

//        if(uniqueIDs.isEmpty()){
//            throw new IllegalArgumentException("There are no employees who work only for one team");
//        }
        return uniqueIDs;

    }

}
