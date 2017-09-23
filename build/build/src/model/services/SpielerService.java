/**
 * 
 */
package model.services;

import java.util.List;

import model.materialien.Spieler;

/**
 * @author Schnizou
 *
 */
public class SpielerService
{
    private List<Spieler> _spielerliste;
    
    /**
     * Konstruktor, initialisiert die Spielerliste
     * 
     * @param spielerliste Die Liste aller Spieler
     * 
     * @require spielerliste != null
     */
    public SpielerService(List<Spieler> spielerliste)
    {

        assert spielerliste != null : "Vorbedingung verletzt: spielerliste != null";

        _spielerliste = spielerliste;

    }
    
    public List<Spieler> gibSpielerListe()
    {
        return _spielerliste;
    }
    
    public void erstelleSpieler() {
      // TODO Spieler in spielerbestand.txt einfügen
        
    }
    
    public void loescheSpieler(Spieler spieler) {
        
        // TODO Spieler aus spielerbestand.txt löschen
          
    }

}
