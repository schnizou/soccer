package model.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.materialien.Frage;

/**
 * Ein FragenService ist ein Service, der die Fragen verwaltet
 * @author Schnizou
 * 
 *
 */
public class FragenService
{

    private List<Frage> _fragenkatalog;

    /**
     * Konstruktor, initialisiert den Fragenkatalog
     * 
     * @param fragenliste Die Liste aller Fragen
     * 
     * @require fragenliste != null
     */
    public FragenService(List<Frage> fragenliste)
    {

        assert fragenliste != null : "Vorbedingung verletzt: fragenliste != null";

        _fragenkatalog = fragenliste;

    }

    /*public void erweitereKatalogUmFrage(String frage, String Antwort,
            String eFA, String zFA, String dFA) throws DateiSchreibException
    {
    
        try
        {
            FileWriter writer = new FileWriter(FRAGEN_DATEI, true);
            writer.write("\n"+frage+";"+Antwort+";"+eFA+";"+zFA+";"+dFA);
            writer.flush();
            writer.close();
    
        }
        catch (FileNotFoundException e)
        {
            throw new DateiSchreibException(
                    "Die Frage konnte nicht erstellt werden, da die Datei nicht gefunden wurde.");
        }
        catch (IOException e)
        {
            throw new DateiSchreibException(
                    "Die Frage konnte nicht erstellt werden, da die Frage nich in der Datei gespeichert wurde.");
        }
    }*/

    public List<Frage> gibFragenkatalog()
    {

        return _fragenkatalog;
    }

    /**
     * Die Method gib eine geshuffelte Liste mit den Antworten zurück. 
     * @param frage; die Frage
     * @return Die Liste der zufällig sortierten Antworten 
     */
    public List<String> shuffleAntworten(Frage frage)
    {

        Frage f = frage;

        List<String> res = new ArrayList<String>();
        res.add(f.gibRichtigeAntwort());
        res.add(f.gibErsteFalscheAntwort());
        res.add(f.gibZweiteFalscheAntwort());
        res.add(f.gibDritteFalscheAntwort());
        Collections.shuffle(res);
        return res;
    }

}
