import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Luis
 */
public class HT9 {
    public static void main(String[] args) throws IOException {
        Scanner ingreso = new Scanner(System.in);
        String source = "";
        ArrayList<String> rwDicc;
        rwDicc = new ArrayList<String>();
        String texTra = "";
        String tipoMapa = "";

        System.out.println("Bienvenido al traductor");
        System.out.println("Ingrese el tipo de arbol que desea usar:");
        System.out.println("1)RedBlack");
        System.out.println("2)Splay");
        tipoMapa = ingreso.nextLine();


        MAP<String, ASSO<String, String>> diccionario = MF.getMap(tipoMapa);

        System.out.println("Seleccione el archivo que contiene el Diccionario");
        System.out.println("Presiona ENTER para continuar");
        ingreso.nextLine();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src"));
        chooser.setDialogTitle("Seleccione su archivo");
        chooser.setFileFilter(new FileNameExtensionFilter("Text files (.dic)", "dic"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                
                FileInputStream fstream = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    rwDicc.add(strLine);
                }

                
                for (int i = 0; i < rwDicc.size(); i++) {
                    
                    String temp = rwDicc.get(i);
                    temp = temp.replaceAll(",", "\t");
                    temp = temp.replaceAll(", ", "\t");
                    temp = temp.replaceAll("; ", "\t");
                    temp = temp.replaceAll(";", "\t");
                    
                    if (temp.charAt(0) != '#') {
                        String[] part = temp.split("\t");
                        diccionario.put(part[0], new ASSO<String, String>(part[0], part[1]));
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Archivo no valido");
            }
        }

      
        System.out.println("Seleccione el archivo que contiene el texto a traducir");
        System.out.println("Presiona ENTER para continuar");
        ingreso.nextLine();
        JFileChooser chooser2 = new JFileChooser(System.getProperty("java.class.path"));
        chooser2.setDialogTitle("Seleccione su archivo");
        chooser2.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
        int returnVal2 = chooser2.showOpenDialog(null);
        if(returnVal2 == JFileChooser.APPROVE_OPTION) {
            try {
                Scanner inputFile2 = new Scanner(new File(chooser2.getSelectedFile().getAbsolutePath()));
                source = chooser2.getSelectedFile().getAbsolutePath();
            }
            catch (FileNotFoundException e) {
                System.out.println("No se sseleciono ningun archivo");

            }
        }


        try
        {
            BufferedReader datos = new BufferedReader(new FileReader(source)); 
            String rawText = datos.readLine();  
            
            rawText = rawText.substring(0, rawText.length()-1);
            String textoATraducir = rawText.toLowerCase();
            datos.close();  
            System.out.println("El texto Originas es: \n" + textoATraducir);
            String wIngles, wEspanol;
            String[] st = textoATraducir.split(" ");

            

            for (int i =0; i < st.length; i++){

                wIngles = st[i];
                if (diccionario.get(wIngles) != null){
                    texTra = (texTra +" "+ diccionario.get(wIngles).getValue());
                }
                else{
                    texTra = (texTra + " *"+wIngles+"*");
                }

            }
            
            System.out.println("El texto traducido es: \n");
            texTra = texTra + ".";
            System.out.println(texTra);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Archivo no valido!!!");
        }
        System.out.println("\nLas palabras no encontradas aparecen con *\n");


    }
}
