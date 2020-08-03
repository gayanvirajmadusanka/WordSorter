
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class SortListAlphabetically implements ActionListener {

    public SortListAlphabetically() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<String> arrayListString = WordSorter.getListOfStrings();

        Collections.sort(arrayListString);

        WordSorter.reloadJTextArea();
    }

}
