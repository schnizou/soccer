/**
 * 
 */
package hauptspielschirm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author schnizou
 *
 */
public class HauptView
{
    private Scene _scene;
    private String _sceneTitel;
    //RootContainer
    private VBox _root;

    //Alles für die Frage
    private Label _frage;

    //Alles für die Antworten
    //Container für die buttons
    private GridPane _antwortenPane;
    //Antwortenbuttons
    private Button _antwort1;
    private Button _antwort2;
    private Button _antwort3;
    private Button _antwort4;

    //Button um die nächste Frage zu starten
    private Button _nächsteFrageButton;

    //Label für die Auswertung
    private Label _auswertung;

    public HauptView()
    {
        //Layout initialisieren
        _root = new VBox();
        _root.setStyle("-fx-base: #808080");
        _root.setPadding(new Insets(25, 25, 25, 25));
        _root.setSpacing(10);
        _root.setAlignment(Pos.CENTER);
        _sceneTitel = "Fußballquiz";

        //Die Frage
        _frage = new Label("Die Frage");

        //Die Layout für die Antworten
        _antwortenPane = new GridPane();
        _antwortenPane.setAlignment(Pos.CENTER);
        //Abstand zwischen die Zeilen und Spalten
        _antwortenPane.setHgap(10);
        _antwortenPane.setVgap(10);
        _antwortenPane.setPadding(new Insets(25, 10, 25, 10));

        _antwort1 = new Button("Antwort 1");
        _antwort1.setPrefWidth(200);
        _antwort2 = new Button("Antwort 2");
        _antwort2.setPrefWidth(200);
        _antwort3 = new Button("Antwort 3");
        _antwort3.setPrefWidth(200);
        _antwort4 = new Button("Antwort 4");
        _antwort4.setPrefWidth(200);

        _antwortenPane.add(_antwort1, 0, 0);
        _antwortenPane.add(_antwort2, 1, 0);
        _antwortenPane.add(_antwort3, 0, 1);
        _antwortenPane.add(_antwort4, 1, 1);

        //Nächste Frage
        _nächsteFrageButton = new Button("Weiter");
        _nächsteFrageButton.setDisable(true);
        _nächsteFrageButton.setLineSpacing(10);;
        _nächsteFrageButton.setDefaultButton(true);

        //Die Auswertung
        _auswertung = new Label("Auswertung");

        _root.getChildren()
            .addAll(_frage, _antwortenPane, _nächsteFrageButton, _auswertung);
        _scene = new Scene(_root);
    }

    public void show(Stage stage)
    {
        stage.setTitle(_sceneTitel);
        stage.setScene(_scene);
        stage.show();
    }

    /**
     * @return the _scene
     */
    public Scene get_scene()
    {
        return _scene;
    }

    /**
     * @param _scene the _scene to set
     */
    public void set_scene(Scene _scene)
    {
        this._scene = _scene;
    }

    /**
     * @return the _root
     */
    public VBox get_root()
    {
        return _root;
    }

    /**
     * @param _root the _root to set
     */
    public void set_root(VBox _root)
    {
        this._root = _root;
    }

    /**
     * @return the _frage
     */
    public Label get_frage()
    {
        return _frage;
    }

    /**
     * @param _frage the _frage to set
     */
    public void set_frage(String _frage)
    {
        this._frage.setText(_frage);
    }

    /**
     * @return the _antwort1
     */
    public Button get_antwort1()
    {
        return _antwort1;
    }

    /**
     * @param _antwort1 the _antwort1 to set
     */
    public void set_antwort1(String _antwort1)
    {
        this._antwort1.setText(_antwort1);
    }

    /**
     * @return the _antwort2
     */
    public Button get_antwort2()
    {
        return _antwort2;
    }

    /**
     * @param _antwort2 the _antwort2 to set
     */
    public void set_antwort2(String _antwort2)
    {
        this._antwort2.setText(_antwort2);
    }

    /**
     * @return the _antwort3
     */
    public Button get_antwort3()
    {
        return _antwort3;
    }

    /**
     * @param _antwort3 the _antwort3 to set
     */
    public void set_antwort3(String _antwort3)
    {
        this._antwort3.setText(_antwort3);
    }

    /**
     * @return the _antwort4
     */
    public Button get_antwort4()
    {
        return _antwort4;
    }

    /**
     * @param _antwort4 the _antwort4 to set
     */
    public void set_antwort4(String _antwort4)
    {
        this._antwort4.setText(_antwort4);
    }

    /**
     * @return the _auswertung
     */
    public Label get_auswertung()
    {
        return _auswertung;
    }

    /**
     * @param _auswertung the _auswertung to set
     */
    public void set_auswertung(String _auswertung)
    {
        this._auswertung.setText(_auswertung);
    }

    public Button get_nächsteFrageButton()
    {

        return _nächsteFrageButton;
    }

    public GridPane gibAntwortenPane()
    {

        return _antwortenPane;

    }
}
