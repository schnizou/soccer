/**
 * 
 */
package model.materialien;

import static org.junit.Assert.*;

import org.junit.Test;

import model.services.einleser.DateiLeseException;

/**
 * @author Schnizou
 *
 */
public class FrageTest
{
    private Frage _dummieFrage;

    public FrageTest() throws DateiLeseException
    {

        _dummieFrage = new Frage("Welche ist die beste Deutsche Mannschaft?",
                "Werder Bremen", "Bayern München", "HSV", "Waldhof Mannheim");

    }

    @Test
    public void gibFrageTest()
    {
        String frage = "Welche ist die beste Deutsche Mannschaft?";
        String nichtFrage = " Wer nicht";

        assertEquals(frage, _dummieFrage.gibFrage());
        assertNotSame(nichtFrage, _dummieFrage.gibFrage());

    }

    @Test
    public void konstruktorTest()
    {
        Frage testFrage = new Frage("Der Sinn des Lebens", "42", "666",
                "Fußball", "Essen");
        assertTrue(testFrage.gibFrage().equals("Der Sinn des Lebens"));
        assertTrue(testFrage.gibRichtigeAntwort().equals("42"));
        assertTrue(testFrage.gibErsteFalscheAntwort().equals("666"));
        assertTrue(testFrage.gibZweiteFalscheAntwort().equals("Fußball"));
        assertTrue(testFrage.gibDritteFalscheAntwort().equals("Essen"));
    }

    @Test
    public void equalsTest()
    {
        assertEquals(_dummieFrage,
                new Frage("Welche ist die beste Deutsche Mannschaft?",
                        "Werder Bremen", "Bayern München", "HSV",
                        "Waldhof Mannheim"));
    }

}
