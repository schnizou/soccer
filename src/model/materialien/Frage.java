/**
 * 
 */
package model.materialien;


/**
 * Die Fragen des Spiels. Alle Fragen haben eine richtige Antwort und drei Falsche Antworten.
 * @author Schnizou
 *
 */
public class Frage
{
    private String _frage;
    private String _richtigeAntwort;
    private String _ersteFalscheAntwort;
    private String _zweiteFalscheAntwort;
    private String _dritteFalscheAntwort;

    /**
     * 
     * @param frage Die Frage
     * @param rA Die richtige Antwort
     * @param eFA Die erste falsche Antwort
     * @param zFA Die zweite falsche Antwort
     * @param dFA Die dritte falsche Antwort
     * 
     * @require frage != null
     * @require rA != null
     * @require eFA != null
     * @require zFA != null
     * @require dFA != null
     */
    public Frage(String frage, String rA, String eFA, String zFA, String dFA)
    {
        assert dFA != null : "Vorbedingung verletzt: dFA != null";
        assert zFA != null : "Vorbedingung verletzt: zFA != null";
        assert eFA != null : "Vorbedingung verletzt: eFA != null";
        assert rA != null : "Vorbedingung verletzt: rA != null";
        assert frage != null : "Vorbedingung verletzt: frage != null";
        
        _frage = frage;
        _richtigeAntwort = rA;
        _ersteFalscheAntwort = eFA;
        _zweiteFalscheAntwort = zFA;
        _dritteFalscheAntwort = dFA;
        
    }
   
    /**
     * Gibt die Frage als String zurück.
     * @return Die Frage
     */
    public String gibFrage()
    {
        return _frage;
    }

    /**
     * Gibt die richtige Antwort als String zurück.
     * 
     * @return Die richtige Antwort
     */
    public String gibRichtigeAntwort()
    {
        return _richtigeAntwort;
    }
    

    /**
     * Gibt die ersteFalsche Antwort als String zurück.
     * 
     * @return Die _ersteFalscheAntwort
     */
    public String gibErsteFalscheAntwort()
    {
        return _ersteFalscheAntwort;
    }

    /**
     * Gibt die zweite falsche Antwort als String zurück.
     * 
     * @return the _zweiteFalscheAntwort
     */
    public String gibZweiteFalscheAntwort()
    {
        return _zweiteFalscheAntwort;
    }

    /**
     * Gibt die dritte falsche Antwort als String zurück.
     * 
     * @return the _dritteFalscheAntwort
     */
    public String gibDritteFalscheAntwort()
    {
        return _dritteFalscheAntwort;
    }
    
    
    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        if (o instanceof Frage)
        {
            Frage vergleichsFrage = (Frage) o;

            result = _frage.equals(vergleichsFrage.gibFrage())
                    && _richtigeAntwort.equals(vergleichsFrage.gibRichtigeAntwort())
                    && _ersteFalscheAntwort.equals(vergleichsFrage.gibErsteFalscheAntwort())
                    && _zweiteFalscheAntwort.equals(vergleichsFrage.gibZweiteFalscheAntwort())
                    && _dritteFalscheAntwort.equals(vergleichsFrage.gibDritteFalscheAntwort());
        }
        return result;
    }
}
