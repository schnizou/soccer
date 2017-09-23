/**
* 
*/
package anmeldeschirm;

import java.util.function.UnaryOperator;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author schnizou
 *
 */
@SuppressWarnings("unused")
public class AnmeldeView
{
    private Scene _scene;
    private String _sceneTitel;
    //RootContainer
    private VBox _root;

    //Begrüßung
    private Label _begruessung;

    //Grid für die Anmeldung
    private GridPane _grid;
    private Label _labelName;
    private TextField _spielerName;
    private Label _labelAnz;
    private TextField _anzFragen;

    //Testslider
    //private Slider _sliderAnz;

    //Startbutton
    private Button _start;

    //EIn Feld für Spielnachrichten
    private Label _msgBoard;

    public AnmeldeView()
    {
        //Layout
        _root = new VBox();
        _root.setStyle("-fx-base: #808080");
        _root.setPadding(new Insets(25, 25, 25, 25));
        _root.setAlignment(Pos.CENTER);
        _root.setSpacing(10);
        _sceneTitel = "Fußballquiz";
        _begruessung = new Label("Herzlich Willkommen zum Fußballquiz");
        _begruessung.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        _labelAnz = new Label("Anzahl Fragen:");
        _labelName = new Label("Spielername:");
        _spielerName = new TextField();
        _anzFragen = new TextField();
        setToNumericField(_anzFragen);

        _grid = new GridPane();
        //Ausrichtung Gird
        _grid.setAlignment(Pos.CENTER);
        //Abstand zwischen die Zeilen und Spalten
        _grid.setHgap(5);
        _grid.setVgap(20);
        _grid.setPadding(new Insets(25, 25, 25, 25));

        _grid.add(_labelName, 0, 0);
        _grid.add(_spielerName, 1, 0);
        _grid.add(_labelAnz, 0, 1);
        _grid.add(_anzFragen, 1, 1);

        _start = new Button("Los geht's!");
        _start.setDisable(true);
        _start.setDefaultButton(true);
        _grid.add(_start, 1, 2);

        //Hier ein kleiner Test zur Implementierung der Anzahl der Fragen als Slider
        //_sliderAnz = new Slider(0, 10, 0);
        //_sliderAnz.setMin(0);
        //_sliderAnz.setMax(10);
        //_sliderAnz.setShowTickLabels(true);
        //_sliderAnz.setShowTickMarks(true);
        //_sliderAnz.setMajorTickUnit(2);
        //_sliderAnz.setMinorTickCount(1);
        //_sliderAnz.setBlockIncrement(1);

        //_sliderAnz.setSnapToTicks(true);


        //Label _sliderLabel = new Label("0");

        //        _sliderAnz.valueProperty()
        //            .addListener((obs, oldval, newVal) -> _sliderLabel
        //                .setText(Integer.toString(newVal.intValue())));   

        //_grid.add(_sliderAnz, 1, 1);
        //_grid.add(_sliderLabel, 2, 1);

        _msgBoard = new Label();

        _root.getChildren()
            .add(_begruessung);
        _root.getChildren()
            .add(_grid);

        _root.getChildren()
            .add(_msgBoard);

        _scene = new Scene(_root);

    }

    /**
     * Die Method beschränkt die Eingabe eines Textfeldes auf Zahlen,
     * so dass nur ganzzahlige Werte eingeben werden können.
     * 
     * @param field Das Textfeld
     */
    private void setToNumericField(TextField field)
    {
        UnaryOperator<Change> filter = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*"))
            {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormater = new TextFormatter<>(filter);
        field.setTextFormatter(textFormater);
    }

    /**
     * Zeigt die Stage.
     * 
     * @param stage Die Stage für das gesamte Spiel.
     */
    public void show(Stage stage)
    {
        stage.setTitle(_sceneTitel);
        stage.setScene(_scene);
        stage.show();
    }

    public Button getStartButton()
    {
        return _start;
    }

    public TextField getAnzFragen()
    {
        return _anzFragen;
    }

    public TextField getSpielername()
    {
        return _spielerName;
    }

    public Label getMsgBoard()
    {
        return _msgBoard;
    }

}
