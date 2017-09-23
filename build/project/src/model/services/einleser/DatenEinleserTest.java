/**
 * 
 */
package model.services.einleser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * Testklasse für den Spielereinleser. 
 * In der spielerDatei ist der erste Eintrag der Admin schnizou.
 * @author Schnizou
 *
 */
public class DatenEinleserTest
{
    private File testfileSpieler;
    private File testfragenDatei;
    private FileWriter writer;
    private DatenEinleser einleser;

    public DatenEinleserTest() throws IOException
    {
        
        testfileSpieler = new File("./bestand/test/testSpieler.txt");
        try
        {
            writer = new FileWriter(testfileSpieler);
            writer.write("Marco Bode;false");
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            writer.close();
        }

        testfragenDatei = new File("./bestand/test/testFragen.txt");
        try
        {
            writer = new FileWriter(testfragenDatei);
            writer.write("Wer ist der geilste;ich;du;er;sie");
            writer.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            writer.close();
        }
        einleser = new DatenEinleser(testfragenDatei, testfileSpieler);

    }

    @Test
    public void konstruktorTest()
    {

    }

    @Test
    public void wurdeEingelesenTest() throws DateiLeseException
    {
        assertFalse(einleser.wurdeEingelesen());
        einleser.leseDaten();
        assertTrue(einleser.wurdeEingelesen());

    }
}
