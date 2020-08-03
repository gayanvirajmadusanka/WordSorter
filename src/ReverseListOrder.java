
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
public class ReverseListOrder implements ActionListener {

    public ReverseListOrder() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> arrayListString = WordSorter.getListOfStrings();

        Collections.reverse(arrayListString);

        WordSorter.reloadJTextArea();

    }
}
