package model.services;

import java.io.File;

import model.services.einleser.DateiLeseException;
import model.services.einleser.FragenEinleser;
/**
 * 
 * @author Schnizou
 * @version 08.2017
 *
 */
public class FragenServiceTest
{
    private static final File FRAGEN_DATEI = new File(
            "./bestand/fragenkatalog.txt");

    @SuppressWarnings("unused")
    private FragenService _fragenservice;
    private FragenEinleser _einleser;

    public FragenServiceTest() throws DateiLeseException
    {
        _einleser = new FragenEinleser();
        _fragenservice = new FragenService(
                _einleser.leseFragenEin(FRAGEN_DATEI));

    }

}
