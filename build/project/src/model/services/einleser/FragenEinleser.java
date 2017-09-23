package model.services.einleser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.materialien.Frage;

/**
 * @author Schnizou
 *
 */
public class FragenEinleser
{

    /**
    * Liest Fragen aus einer Textdatei ein und gibt alle eingelesenen Kunden
    * zurück.
    * 
    * @param fragenDatei Die Datei in der die Fragen gespeichert sind.
    * @throws DateiLeseException wenn der Fragenkatalog nicht gelesen werden
    *             konnte.
    * 
    * @require fragenDatei != null
    * 
    * @ensure result != null
    * 
    * @return Der Fragenkatalog als Liste
    */
    public List<Frage> leseFragenEin(File fragenDatei) throws DateiLeseException
    {
        assert fragenDatei != null : "Vorbedingung verletzt: kundenDatei != null";
        List<Frage> eingeleseneFragen = new ArrayList<Frage>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(fragenDatei));

            String line = null;
            // liest Datei Zeile für Zeile
            while ((line = reader.readLine()) != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String Frage = tokenizer.nextToken();
                String richtigeAntwort = tokenizer.nextToken();
                String ersteFalscheAntwort = tokenizer.nextToken();
                String zweiteFalscheAntwort = tokenizer.nextToken();
                String dritteFalscheAntwort = tokenizer.nextToken();

                Frage frage = new Frage(Frage, richtigeAntwort,
                        ersteFalscheAntwort, zweiteFalscheAntwort,
                        dritteFalscheAntwort);

                eingeleseneFragen.add(frage);

            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            throw new DateiLeseException(
                    "Der Fragenkatalog konnte nicht eingelesen werden, da die Datei nicht gefunden wurde.");
        }
        catch (IOException e)
        {
            throw new DateiLeseException(
                    "Der Fragenkatalog konnte nicht eingelesen werden, da die Datei nicht gelesen werden konnte.");
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
        return eingeleseneFragen;
    }
}
