package model.materialien;


/**
 * Es wird ein neuer Spieler angelegt. Dieser kann auch als Admin angelegt werden.
 * @author Schnizou
 *
 */
public class Spieler
{
    public String _spielerName;
    public boolean _admin;

    /**
     * Kontruktor für den Spieler
     * @param name Der Name des Spielers
     * @param admin boolean: True wenn Admin, false sonst
     */
    public Spieler(String name, boolean admin)
    {
        _spielerName = name;
        _admin = admin;
    }

    public String gibName()
    {
        return _spielerName;
    }

    public Boolean istAdmin()
    {
        return _admin;
    }

    @Override
    public boolean equals(Object o)
    {
        boolean result = false;
        if (o instanceof Spieler)
        {
            Spieler vergleichsSpieler = (Spieler) o;

            result = _spielerName.equals(vergleichsSpieler.gibName())
                    && _admin == vergleichsSpieler.istAdmin();

        }
        return result;
    }

}
