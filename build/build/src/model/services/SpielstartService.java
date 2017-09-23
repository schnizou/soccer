/**
 * 
 */
package model.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.materialien.*;

/**
 * Der Spielstartservice wird gestartet, wenn deas Spiel gestartet wird.
 * Die Anzahl der Fragen legt fest, wieviel Fragen gespielt werden. 
 * Diese werden zufällig aus dem #fragenkatalog ausgewählt.
 * 
 * @author Schnizou
 *
 */
public class SpielstartService
{
    //Der aktuelle Spieler
    @SuppressWarnings("unused")
    private Spieler _spieler;

    //Die Liste der Fragen für das aktuelle Spiel
    private List<Frage> _spielfragen;

    //Der gesamte Fragenkatalog
    private List<Frage> _fragenkatalog;

    //Die Liste aller registrierten Spieler
    @SuppressWarnings("unused")
    private List<Spieler> _spielerbestand;

    /**
     * Konstruktor für den SpielstartService
     * 
     * @param anzahlFragen Die Anzahl der Fragen
     * @param spieler Der Spieler
     * @param fragenkatalog Der Fragenservice
     * @param spielerbestand Der Spielerservice
     * 
     * @require spieler != null
     * @require fragenkatalog != null
     * @require spielerbestand != null
     * 
     */
    public SpielstartService(FragenService fragenkatalog,
            SpielerService spielerbestand)
    {
        assert spielerbestand != null : "Vorbedingung verletzt: spielerbestand != null";
        assert fragenkatalog != null : "Vorbedingung verletzt: fragenkatalog != null";

        _fragenkatalog = fragenkatalog.gibFragenkatalog();
        _spielerbestand = spielerbestand.gibSpielerListe();

    }

    /**
     * Erstellt eine zufällige Liste von Fragen entsprechend der gewünscht Anzahl an Fragen.
     * @param anzahl Die anzahl der Spiele
     * @return Eine Liste mit Fragen
     * 
     * @require anzahlFragen > 0
     * @require anzahlFragen < 11
     * 
     */
    public List<Frage> erstelleFragenFuersSpiel(int anzahlFragen)
    {
        assert anzahlFragen > 0 : "Vorbedingung verletzt: anzahlFragen > 0";
        assert anzahlFragen < 11 : "Vorbedingung verletzt: anzahlFragen < 11";

        Set<Frage> fragenmenge = new HashSet<Frage>();
        while (fragenmenge.size() <= anzahlFragen)
        {
            Frage frage = _fragenkatalog
                .get(new Random().nextInt(_fragenkatalog.size()));
            fragenmenge.add(frage);
        }
        List<Frage> result = new ArrayList<Frage>();
        for (Frage i : fragenmenge)
        {
            result.add(i);
        }
        return result;
    }

    /**
     * Gibt die Liste der Spielfragen zurück
     * @return Die Spielfragen
     */
    public List<Frage> gibSpielfragen()
    {
        return _spielfragen;
    }

}
