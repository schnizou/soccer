/**
 * 
 */
package hauptspielschirm;

import java.util.ArrayList;
import java.util.List;

import anmeldeschirm.AnmeldeVC;
import javafx.scene.control.Button;
import model.Model;
import model.materialien.Frage;

/**
 * @author Schnizou
 *
 */
public class HauptVC
{
    private Model model;

    private HauptView view;

    private int _anzahlFragen;
    private List<Frage> _fragenliste;
    private Frage _aktuelleFrage;
    private List<Button> _antwortenButton;

    private int _countRichtigeAntwort;

    private int _countFragen;

    public HauptVC(Model model, int anz)
    {
        this.model = model;
        this.view = new HauptView();
        _anzahlFragen = anz;
        this._fragenliste = model.erstelleFragenListe(_anzahlFragen);
        _countFragen = 0;
        _countRichtigeAntwort = 0;
        erstelleButtonListe();
        nächsteFrage();

        registriereEventHandler();

    }

    private List<Button> erstelleButtonListe()
    {

        _antwortenButton = new ArrayList<Button>();
        _antwortenButton.add(view.get_antwort1());
        _antwortenButton.add(view.get_antwort2());
        _antwortenButton.add(view.get_antwort3());
        _antwortenButton.add(view.get_antwort4());
        return _antwortenButton;

    }

    private void registriereEventHandler()
    {
        //Eventhandler für die Antwortenbuttons
        for (Button b : _antwortenButton)
        {
            b.setOnAction(e -> {

                if(b.getText()
                    .equals(_aktuelleFrage.gibRichtigeAntwort()))
                {
                    //Setzt die Buttonfarbe grün
                    b.setStyle("-fx-base: #8bea00");
                    disableAllButtons();
                    enableNächsteFrageButton();
                    _countRichtigeAntwort++;
                    _countFragen++;
                    setzeAuswertung();

                }
                else
                {
                    //Setzt die Buttonfarbe rot
                    b.setStyle("-fx-base: #ff0000");
                    disableAllButtons();
                    enableNächsteFrageButton();
                    _countFragen++;
                    setzeAuswertung();
                    for(Button c : _antwortenButton) {
                        if(c.getText()
                                .equals(_aktuelleFrage.gibRichtigeAntwort())) {
                            c.setStyle("-fx-base: #8bea00");
                        }
                    }
                    
                    ;

                }
                if (_countFragen == _anzahlFragen)
                {
                    view.get_nächsteFrageButton()
                        .setText("Neues Spiel?");

                }
            });

        }

        view.get_nächsteFrageButton()
            .setOnAction(e -> {

                view.get_nächsteFrageButton()
                    .setDisable(true);
                if (_countFragen < _anzahlFragen)
                {
                    nächsteFrage();
                    enableAllButtoos();
                }
                if (_countFragen == _anzahlFragen)
                {
                    AnmeldeVC anmeldungVC = new AnmeldeVC(model);
                    anmeldungVC.show();

                }

            });
    }

    public void show()
    {
        view.show(model.getStage());
    }

    private void setzeAuswertung()
    {
        if (_countFragen == 1)
        {
            view.get_auswertung()
            .setText("Nach der ersten Frage, hast du "
                    + _countRichtigeAntwort + " von " + _anzahlFragen
                    + " richtig beantwortet.");

        }
        else
        {
            view.get_auswertung()
                .setText("Nach " + _countFragen + " Fragen, hast du "
                        + _countRichtigeAntwort + " von " + _anzahlFragen
                        + " richtig beantwortet.");
        }
    }

    private void disableAllButtons()
    {
        for (Button b : _antwortenButton)
        {
            b.setDisable(true);
        }
    }

    private void enableAllButtoos()
    {
        for (Button b : _antwortenButton)
        {
            b.setDisable(false);
            b.setStyle(null);
        }
    }

    private void enableNächsteFrageButton()
    {
        view.get_nächsteFrageButton()
            .setDisable(false);
    }

    private void nächsteFrage()
    {
        _aktuelleFrage = _fragenliste.get(_countFragen);
        List<String> Antworten = model.shuffleAntworten(_aktuelleFrage);
        view.set_frage(_aktuelleFrage.gibFrage());
        view.set_antwort1(Antworten.get(0));
        view.set_antwort2(Antworten.get(1));
        view.set_antwort3(Antworten.get(2));
        view.set_antwort4(Antworten.get(3));
        setzeAuswertung();
    }

}
