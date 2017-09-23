/**
 * 
 */
package model.services.einleser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import model.materialien.Spieler;

/**
 * Testklasse für den Spielereinleser. 
 * In der spielerDatei ist der erste Eintrag der Admin schnizou.
 * @author Schnizou
 *
 */
public class SpielerEinleserTest
{
    private Spieler _testSpieler;
    private SpielerEinleser _einleser;
    private static final File SPIELER_DATEI = new File(
            "./bestand/spielerbestand.txt");

    public SpielerEinleserTest()
    {
        _testSpieler = new Spieler("schnizou", true);
        _einleser = new SpielerEinleser();

    }

    @Test
    public void leseSpielerEinTest() throws DateiLeseException
    {
        List<Spieler> testListe = _einleser
            .leseSpielerEin(SPIELER_DATEI);

        assertEquals(_testSpieler, testListe.get(0));
        assertTrue(testListe.contains(_testSpieler));

    }

}
