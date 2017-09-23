/**
 * 
 */
package model.services.einleser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import model.materialien.Frage;

/**
 * @author Schnizou
 *
 */
public class FragenEinleserTest
{

    private Frage _testFrage;
    private FragenEinleser _einleser;
    private static final File FRAGEN_DATEI = new File(
            "./bestand/fragenkatalog.txt");

    public FragenEinleserTest()
    {
        _testFrage = new Frage("Welche ist die beste Deutsche Mannschaft?",
                "Werder Bremen","Bayern München","HSV","Waldhof Mannheim");
        _einleser = new FragenEinleser();
        
    }
    
    @Test
    public void leseFragenEinTest() throws DateiLeseException
    {
        List<Frage> testListe = _einleser.leseFragenEin(FRAGEN_DATEI);
        assertEquals(_testFrage, testListe.get(1));
        assertTrue(testListe.contains(_testFrage));     
    }

}
