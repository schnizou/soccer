/**
 * 
 */
package model.services.einleser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.materialien.Spieler;

/**
 * @author Schnizou
 *
 */
public class SpielerEinleser
{
    /**
     * Liest Kunden aus einer Textdatei ein und gibt alle eingelesenen Spieler
     * zurück.
     * 
     * @param spielerDatei Die Datei in der die Kunden gespeichert sind.
     * @throws DateiLeseException wenn der Spielerbestand nicht gelesen werden
     *             konnte.
     * 
     * @require spielerDatei != null
     * 
     * @ensure result != null
     * 
     * @return Die Liste aller Spieler
     */
    public List<Spieler> leseSpielerEin(File spielerDatei)
            throws DateiLeseException
    {
        assert spielerDatei != null : "Vorbedingung verletzt: kundenDatei != null";
        List<Spieler> eingeleseneKunden = new ArrayList<Spieler>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(spielerDatei));

            String line = null;
            // liest Datei Zeile für Zeile
            while ((line = reader.readLine()) != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                boolean admin = Boolean.valueOf(tokenizer.nextToken());

                Spieler kunde = new Spieler(name, admin);

                eingeleseneKunden.add(kunde);

            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            throw new DateiLeseException(
                    "Der Spielerbestand konnte nicht eingelesen werden, da die Datei nicht gefunden wurde.");
        }
        catch (IOException e)
        {
            throw new DateiLeseException(
                    "Der Spielerbestand konnte nicht eingelesen werden, da die Datei nicht gelesen werden konnte.");
        }
        finally
        {
            // Abschließend wird versucht, die Datei erneut zu schließen, falls
            // dies vorher nicht gemacht werden konnte, da eine Exception vor
            // der close() Anweisung geworfen wurde.
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    // Diese Exception wird geschluckt.
                }
            }
        }
        return eingeleseneKunden;
    }
}
