/**
 * 
 */
package model;

import java.io.File;
import java.util.List;

import javafx.stage.Stage;
import model.services.FragenService;
import model.services.SpielerService;
import model.services.SpielstartService;
import model.services.einleser.DateiLeseException;
import model.services.einleser.DatenEinleser;
import model.materialien.*;

/**
 * Das Model für das Spiel. Das Spiel ist nach dem Entwurfsmuster Model-View-Controller 
 * geschrieben worden. Das Model verwaltet dabei die Materialien und die Srvices für das Spiel. 
 * 
 * @author schnizou
 *
 */
public class Model
{
    //Die Stage für das gesamte Spiel
    private Stage stage;

    //Die notwendigen Datein um den FragenKatalog und den Spielerbestand zu lesen
    private static final File FRAGEN_DATEI = new File(
            "./bestand/fragenkatalog.txt");
    private static final File SPIELER_DATEI = new File(
            "./bestand/spielerbestand.txt");

    //Die Services zum erstellen eines Spiels
    private static FragenService _fragenkatalog;
    private static SpielerService _spielerbestand;
    private static SpielstartService _spielstartService;

    /**
     * Der Konstruktor für das Model. 
     * @param primaryStage Die Stage für das Spiel.
     */
    public Model(Stage primaryStage)
    {
        erstelleServices();
        stage = primaryStage;
    }

    /**
     * Erstellt die Services für das Spiel.
     */
    private static void erstelleServices()
    {
        try
        {
            DatenEinleser einleser = new DatenEinleser(FRAGEN_DATEI,
                    SPIELER_DATEI);
            einleser.leseDaten();
            _fragenkatalog = new FragenService(einleser.gibFragen());
            _spielerbestand = new SpielerService(einleser.gibSpieler());
            _spielstartService = new SpielstartService(_fragenkatalog,
                    _spielerbestand);
        }
        catch (DateiLeseException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return Die Stage
     */
    public Stage getStage()
    {
        return stage;
    }

    public List<Frage> erstelleFragenListe(int anzFragen)
    {
        return _spielstartService.erstelleFragenFuersSpiel(anzFragen);
    }

    public List<String> shuffleAntworten(Frage frage)
    {
        return _fragenkatalog.shuffleAntworten(frage);
    }

}
