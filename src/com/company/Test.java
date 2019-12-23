package com.company;

import javax.swing.*;
import java.io.File;

public class Test {

    public static void main(String args[]){
        File output = new File("C:\\Users\\Nabeel Arif\\Desktop\\FilteredImage.jpg");
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\Users\\Nabeel Arif"));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
            ImageFiltering.blueStaticFilter(fc.getSelectedFile().getAbsoluteFile(), output);
            System.out.print("Success");
        }
    }
}
