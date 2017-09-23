/**
 * 
 */
package anmeldeschirm;

import hauptspielschirm.HauptVC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Model;

/**
 * @author schnizou
 *
 */
public class AnmeldeVC
{
    private Model model;

    private AnmeldeView aV;

    private int _anzFragen;

    public AnmeldeVC(Model model)
    {

        this.model = model;
        this.aV = new AnmeldeView();

        registriereEventhandler();

    }

    private void registriereEventhandler()
    {

        //EventHandler für den StartButton 
        aV.getStartButton()
            .setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    //Ab hier wird dann zum Hauptbildschirm gewechselt
                    HauptVC hauptView = new HauptVC(model, _anzFragen);
                    hauptView.show();

                }
            });

        //EventHandler für das TextField AnzahlFragen
        aV.getAnzFragen()
            .setOnKeyReleased(new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent event)
                {
                    if (AnzFragenErlaubt())
                    {
                        _anzFragen = Integer.parseInt(aV.getAnzFragen()
                            .getText());

                    }
                    enableDisableStartButton();
                    setMsgBoardText();
                }
            });

        //EventHandler für das TextField SpielerName
        aV.getSpielername()
            .setOnKeyReleased(new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent event)
                {
                    enableDisableStartButton();
                    setMsgBoardText();
                }
            });
    }

    public void show()
    {
        setMsgBoardText();
        aV.show(model.getStage());

    }

    private boolean AnzFragenErlaubt()
    {
        if (!aV.getAnzFragen()
            .getText()
            .isEmpty())
        {
            int az = Integer.parseInt(aV.getAnzFragen()
                .getText());
            if (az <= 10 && az > 0)
            {
                return true;
            }
        }
        return false;
    }

    private void enableDisableStartButton()
    {
        if (AnzFragenErlaubt() && !aV.getSpielername()
            .getText()
            .isEmpty())
        {
            aV.getStartButton()
                .setDisable(false);
        }
        else
        {
            aV.getStartButton()
                .setDisable(true);
        }
    }

    private void setMsgBoardText()
    {
        if (AnzFragenErlaubt() && !aV.getSpielername()
            .getText()
            .isEmpty())
        {
            aV.getMsgBoard()
                .setText("Jetzt passt es. Gut Schuß!");
        }
        else if (AnzFragenErlaubt() && aV.getSpielername()
            .getText()
            .isEmpty())
        {
            aV.getMsgBoard()
                .setText("Keine Spielername");
        }
        else if (!AnzFragenErlaubt() && !aV.getSpielername()
            .getText()
            .isEmpty())
        {
            aV.getMsgBoard()
                .setText("Die Anzahl der Fragen muss zwischen 1 und 10 sein.");
        }
        else if (!AnzFragenErlaubt() && aV.getSpielername()
            .getText()
            .isEmpty())
        {
            aV.getMsgBoard()
                .setText(
                        "Bitte geben Sie ihren Namen und die Anzahl\nder gewünschten Fragen(1-10) ein."
                                + "\nViel Erfolg!");
        }
    }
}
