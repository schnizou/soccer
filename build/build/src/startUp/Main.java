package startUp;

import anmeldeschirm.AnmeldeVC;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Model model = new Model(primaryStage);

        AnmeldeVC anmeldungVC = new AnmeldeVC(model);
        anmeldungVC.show();

    }

}
