/**
 * 
 */
package model.services.einleser;

import java.io.File;
import java.util.List;

import model.materialien.Frage;
import model.materialien.Spieler;

/**
 * @author Schnizou
 *
 */
public class DatenEinleser
{
    /**
     * Die Datei in der die Spieler gespeichert sind.
     */
    private final File _spielerDatei;

    /**
     * Die Datei in der die Fragen gespeichert sind.
     */
    private final File _fragenDatei;

    /**
     * Die eingelesenen Spieler, ist null wenn noch nicht eingelesen wurde.
     */
    private List<Spieler> _spieler;

    /**
     * Die eingelesenen Fragen, ist null wenn noch nicht eingelesen wurde.
     */
    private List<Frage> _fragen;

    /**
     * Initialisiert einen neuen DatenEinleser, der aus den angebenen Dateien
     * einliest.
     * 
     * @param fragenDatei Die Datei in der die Fragen gespeichert sind.
     * @param spielerDatei Die Datei in der die Spieler gespeichert sind.
     * 
     * @require fragenDatei != null
     * @require spielerDatei != null
     */
    public DatenEinleser(File fragenDatei, File spielerDatei)
    {
        assert fragenDatei != null : "Vorbedingung verletzt: medienDatei != null";
        assert spielerDatei != null : "Vorbedingung verletzt: kundenDatei != null";

        _spielerDatei = spielerDatei;
        _fragenDatei = fragenDatei;

    }

    /**
     * Liest die Daten aus den, beim Konstruktoraufruf angegebenen Dateien aus.
     * 
     * Das Ergebnis des Einlesens kann mit #getSpieler() und
     * #getFragen() abgefragt werden.
     * 
     * @throws DateiLeseException Wenn ein Fehler beim Lesen der Dateien
     *             auftritt.
     * 
     * @ensure wurdeEingelesen() == true
     */
    public void leseDaten() throws DateiLeseException
    {
        SpielerEinleser spielerEinleser = new SpielerEinleser();
        _spieler = spielerEinleser.leseSpielerEin(_spielerDatei);
        FragenEinleser fragenEinleser = new FragenEinleser();
        _fragen = fragenEinleser.leseFragenEin(_fragenDatei);

    }
    
    /**
     * Prüft ob eingelesen wurde.
     * 
     * @return true wenn eingelesen wurde, sonst false .
     */
    public boolean wurdeEingelesen()
    {
        return _spieler != null;
    }

    /**
     * Gibt die eingelesenen Fragen zurück.
     * 
     * @return Die eingelesenen Fragen.
     * 
     * @require wurdeEingelesen()
     */
    public List<Frage> gibFragen()
    {
        assert wurdeEingelesen() : "Vorbedingung verletzt: wurdeEingelesen()";
        return _fragen;
    }
    
    /**
     * Gibt die eingelesenen Fragen zurück.
     * 
     * @return Die eingelesenen Fragen.
     * 
     * @require wurdeEingelesen()
     */
    public List<Spieler> gibSpieler()
    {
        assert wurdeEingelesen() : "Vorbedingung verletzt: wurdeEingelesen()";
        return _spieler;
    }
    
    
}
