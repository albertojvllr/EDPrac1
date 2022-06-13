package cost;


import java.util.Random;
import linked_list.*;
import excepcions.*;
import hash_table.Hashtable;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Cost_LinkedList {
	public static void main(String[] args) throws NoTrobat, NoInserit, IOException {

		File f = new File("C:\\Users\\xoxob\\Desktop\\ECLIPSE\\EDPrac1\\fichero.txt");
		File x = new File("C:\\Users\\xoxob\\Desktop\\ECLIPSE\\EDPrac1\\fichero1.txt");
        FileWriter fw = new FileWriter(f);
        FileWriter xw = new FileWriter(x);
         
        try (BufferedWriter bw = new BufferedWriter(fw);

			    BufferedWriter xsw = new BufferedWriter(xw);) {
			int n=50000;      
			Linked_List<Integer> llista = new Linked_List<Integer>();
			Hashtable<Integer, String> TaulaHash= new Hashtable<Integer,String>();
			TaulaHash.Crear(n+1);
			int i=0;
			for(i =0; i<n; i++){
			    Random r = new Random();
			    int valor = r.nextInt(n/2);
			    String valorHash = String.valueOf(Integer.valueOf(valor));
			    try {
			        llista.Inserir(valor);

			        TaulaHash.Inserir(valorHash, valor);
			    }catch (NoInserit e){
			    }
			}
			bw.write(" NumElements "+n);
			bw.newLine();
			for(i =0; i<n; i++){
			    Random r = new Random();
			    int p=(n/2);
			    int valor = r.nextInt(p)+1;
			    String valorHash = String.valueOf(Integer.valueOf(valor));
			    try {
			        bw.write(","+llista.Buscar(valor));
			        bw.write("\n");
			    }catch (Exception e){
			        bw.write("-");
			        bw.write("\n");

			    }

			    try {
			        xsw.write("," + TaulaHash.Buscar(valorHash));
			        xsw.newLine();


			    }catch (NoTrobat e){
			       // System.out.println(e);
			        xsw.write("-");
			        xsw.newLine();
			    }

			}
			bw.close();
			xsw.close();
		}

        
        fw.close();
		}
}