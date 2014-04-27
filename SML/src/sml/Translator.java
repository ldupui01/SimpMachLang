package sml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code

    private static final String SRC = "src";

    public Translator(String fileName) {
        this.fileName = SRC + "/" + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) {
        Scanner sc; // Scanner attached to the file chosen by the user
        try {
            sc = new Scanner(new File(fileName));
        } catch (IOException ioE) {
            System.out.println("File: IO error to start " + ioE.getMessage());
            return false;
        }
        labels = lab;
        labels.reset();
        program = prog;
        program.clear();

        try {
            line = sc.nextLine();
        } catch (NoSuchElementException ioE) {
            sc.close();
            return false;
        }

        // Each iteration processes line and reads the next line into line
        while (line != null) {
            // Store the label in label
            String label = scan();

            if (label.length() > 0) {
                Instruction ins = getInstruction(label);
                if (ins != null) {
                    labels.addLabel(label);
                    program.add(ins);
                }
            }

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                sc.close();
                return false;
            }
        }
        sc.close();
        return true;
    }

    // line should consist of an MML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) {

        if (line.equals(""))
            return null;
        try{
            return getInstanceOfInstruction(label);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * this method takes any instruction as an id'ed string, then the label @ params[0], and then the actual constructor parameters @ params[...after 1] and returns an instance of that defined instruction.
     * @return
     */
    private <V> Instruction getInstanceOfInstruction(String label) throws Exception{
        Instruction newInsObj = null;

        //this ids the type of instruction, which is the first element on the line.
        String ins = scan();

        //this collects all the parameters in the current line under eval.
        ArrayList<V> parameters = new ArrayList<V>();
        String currentParam = scan();
        while(!currentParam.equals("")){
            if(Character.isDigit(currentParam.charAt(0))){
                parameters.add((V) Integer.valueOf(currentParam));
            }else {
                parameters.add((V)currentParam);
            }
            currentParam = scan();
        }

        //all instructions have a first parameter label which is of type String
        parameters.add(0,(V)label);
        
        int paramSiz = parameters.size();
        try{
            int c = 0;
        	String inputInstructionClass = ins;
            //this finds the class and invokes its constructor.
            Constructor[] consList = getInsClass(inputInstructionClass).getDeclaredConstructors();
            for(int i = 0; i< consList.length; i++){
            	if(consList[i].getParameterCount() == paramSiz) c = i;
            }
            
            newInsObj = (Instruction) getInsClass(inputInstructionClass)
                    .getDeclaredConstructors()[c]
                    .newInstance(parameters.toArray((V[]) new Object[0]));

            return newInsObj;
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }
        return null;
    }

    //Uses the properties file to identify the right class via the name (defined by String: inputInstructionClass).
    private Class getInsClass(String inputInstructionClass) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("sml.properties"));
            String key = inputInstructionClass;
            String className = properties.getProperty(key);
            return Class.forName(className);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    public String scan() {
        line = line.trim();
        if (line.length() == 0)
            return "";

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' '
                && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    public int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }

}