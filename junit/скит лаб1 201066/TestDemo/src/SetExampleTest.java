import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetExampleTest {

    @Test
    void uniqueIDs(){

        Set<String> a = new HashSet<String>();
        a.addAll(Arrays.asList(new String[] {"1", "3", "2", "4", "8", "9", "0"}));

        Set<String> b = new HashSet<String>();
        b.addAll(Arrays.asList(new String[] {"1", "3", "7", "5", "4", "0"}));

        SetExample setExample = new SetExample();

        Set<String> expected= new HashSet<String>();
        expected.addAll(Arrays.asList(new String[] {"2","5","7","8","9"}));

        assertEquals(expected, setExample.notInBothTeams(a,b));

    }
//    @Test
//    void noUniqueIDs(){
//        Set<String> a = new HashSet<String>();
//        a.addAll(Arrays.asList(new String[] {"1", "3", "2"}));
//
//        Set<String> b = new HashSet<String>();
//        b.addAll(Arrays.asList(new String[] {"2","1","3"}));
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            SetExample setExample = new SetExample();
//            setExample.notInBothTeams(a,b);
//        });
//
//
//    }

    @Test
    void emptyTeam2(){

        Set<String> a = new HashSet<String>();
        a.addAll(Arrays.asList(new String[] {"1", "3", "2", "4", "8", "9", "0"}));

        Set<String> b = new HashSet<String>();
        b.addAll(Arrays.asList(new String[] {}));

        SetExample setExample = new SetExample();

        Set<String> expected= new HashSet<String>();
        expected.addAll(Arrays.asList(new String[] {"0", "1", "2", "3", "4", "8", "9"}));

        assertEquals(expected, setExample.notInBothTeams(a,b));

    }

    @Test
    void emptyTeam1(){
        Set<String> a = new HashSet<String>();
        a.addAll(Arrays.asList(new String[] {}));

        Set<String> b = new HashSet<String>();
        b.addAll(Arrays.asList(new String[] {"1", "3", "7", "5", "4", "0", "7", "5"}));

        SetExample setExample = new SetExample();


        Set<String> expected= new HashSet<String>();
        expected.addAll(Arrays.asList(new String[] {"0", "1", "3", "4", "5", "7"}));



        assertEquals(expected, setExample.notInBothTeams(a,b));

    }


    @Test
    public void Team1IsNull() {
        Set<String> b = new HashSet<String>();
        b.addAll(Arrays.asList(new String[] {"1", "3", "7", "5", "4", "0", "7", "5"}));
        assertThrows(IllegalArgumentException.class, () -> {
            SetExample setExample = new SetExample();
            setExample.notInBothTeams(null,b);
        });
    }


    @Test
    public void Team2IsNull() {
        Set<String> a = new HashSet<String>();
        a.addAll(Arrays.asList(new String[] {"1", "3", "7", "5", "4", "0", "7", "5"}));
        assertThrows(IllegalArgumentException.class, () -> {
            SetExample setExample = new SetExample();
            setExample.notInBothTeams(a,null);
        });
    }

    @Test
    public void BothTeamsAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            SetExample setExample = new SetExample();
            setExample.notInBothTeams(null,null);
        });

    }

//    @Test
//    public void NoMembersInBothTeams()
//    {
//        Set<String> a = new HashSet<String>();
//        a.addAll(Arrays.asList(new String[] {}));
//        Set<String> b = new HashSet<String>();
//        b.addAll(Arrays.asList(new String[] {}));
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            SetExample setExample = new SetExample();
//            setExample.notInBothTeams(a,b);
//        });
//    }

}