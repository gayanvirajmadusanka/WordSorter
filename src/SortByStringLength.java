
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class SortByStringLength implements ActionListener, Comparator<Integer> {

    public SortByStringLength() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> arrayListString = WordSorter.getListOfStrings();

        arrayListString.sort((first, second) -> {
            return new SortByStringLength().compare(first.length(), second.length());
        });

        WordSorter.reloadJTextArea();
    }

    @Override
    public int compare(Integer x, Integer y) {
        if (x < y) {
            return -1;
        } else if (x == y) {
            return 0;
        } else {
            return 1;
        }
//        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

}
