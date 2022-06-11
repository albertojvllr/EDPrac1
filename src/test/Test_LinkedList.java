package test;
import excepcions.*;
import linked_list.Linked_List;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Test_LinkedList {
	private static int opcio = -1;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws NoTrobat, NoInserit, NoEsborrat, NoObtingut
	{

		boolean fi = false, trobat = false;

		Linked_List<Ciutada> llistaCiutadans = new Linked_List<Ciutada>();
		String nom = null, cognom = null, DNI = null;
		Ciutada ctd1 = new Ciutada();
		llistaCiutadans.Crear();
		llistaCiutadans.Inserir(ctd1);
		Ciutada aux = null;
		Iterator<Ciutada> it = null;
		int posicio = 0;
		while (!fi) {

			try {
				menuOpcions();
			} catch (InputMismatchException e) {
				System.err.println("Numero NO Valid");
				sc.nextLine();
			}

			switch (opcio) {
			case 0:
				sc.close();
				System.out.println("FINALITZAT");
				fi = true;
				break;
			case 1:
				sc.nextLine();
				System.out.println("Introdueix el nom del ciutada");
				nom = sc.nextLine();

				System.out.println("Introdueix el cognom del ciutada");
				cognom = sc.nextLine();

				System.out.println("Introdueix el DNI del ciutada");
				DNI = sc.nextLine();

				if (nom == null || nom.equals("\n")) {
					nom = ctd1.getNom();
				}
				if (cognom == null || cognom.equals("")) {
					cognom = ctd1.getCognom();
				}
				if (DNI == null || DNI.equals("")) {
					DNI = ctd1.getDNI();
				}

				it = llistaCiutadans.iterator();
				while (it.hasNext() && !trobat) {
					aux = it.next();

					if (aux.compareTo(new Ciutada(nom, cognom, DNI)) == 0) {
						System.err.println("Ja existeix algu amb aquest DNI");
						trobat = true;
					}

				}
				if (!trobat) {
					llistaCiutadans.Inserir(new Ciutada(nom, cognom, DNI));
					System.out.println("Ciutada inserit");
					
					it = llistaCiutadans.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					System.out.println(it.next());
				}

				break;
			case 2:

				System.out.println("A quina posicio vols inserir el ciutada? (0-" + llistaCiutadans.Longitud(llistaCiutadans)+ ")");
				posicio = sc.nextInt();
				sc.nextLine();
				System.out.println("Introdueix el nom del ciutada");
				nom = sc.nextLine();

				System.out.println("Introdueix el cognom del ciutada");
				cognom = sc.nextLine();

				System.out.println("Introdueix el DNI del ciutada");
				DNI = sc.nextLine();

				if (nom == null || nom.trim().equals("")) {
					nom = ctd1.getNom();
				}
				if (cognom == null || cognom.trim().equals("")) {
					cognom = ctd1.getCognom();
				}
				if (DNI == null || DNI.trim().equals("")) {
					DNI = ctd1.getDNI();
				}

				it = llistaCiutadans.iterator();
				while (it.hasNext() && !trobat) {
					aux = it.next();

					if (aux.compareTo(new Ciutada(nom, cognom, DNI)) == 0) {
						System.err.println("Ja existeix algu amb aquest DNI");
						trobat = true;
					}

				}
				if (!trobat) {
					llistaCiutadans.Inserir(posicio, new Ciutada(nom, cognom, DNI));
					System.out.println("Ciutada inserit");
					
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					System.out.println(it.next());
				}
				break;
			case 3:
					do {
						System.out.println("Introdueix la posicio del node a obtenir (0-"+ llistaCiutadans.Longitud(llistaCiutadans)+")");
						posicio=sc.nextInt();
					}while(posicio<0 || posicio>llistaCiutadans.Longitud(llistaCiutadans));
					System.out.println("\nNode " + posicio + ":\n" + llistaCiutadans.Obtenir(posicio));
				break;
			case 4:
				System.out.println("Longitud de la llista: "+ llistaCiutadans.Longitud(llistaCiutadans));
				break;
			case 5:
				if (llistaCiutadans.Longitud(llistaCiutadans)==1) {
					System.out.println("La llista sols te un node, per tant no pots borrar cap node");
					break;
				}
				do {
					System.out.println("Introdueix la posicio del node a borrar (1-"+ llistaCiutadans.Longitud(llistaCiutadans)+")");
					posicio=sc.nextInt();
				}while(posicio<1 || posicio>llistaCiutadans.Longitud(llistaCiutadans));
				
				System.out.println("Node a esborrar:");
				System.out.println(llistaCiutadans.Obtenir(posicio));
				System.out.println("Llista abans d'esborrar:");
				
				it = llistaCiutadans.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				System.out.println(it.next());
				
				llistaCiutadans.Esborrar(posicio);
				System.out.println("Llista despres d'esborrar:");
				
				it = llistaCiutadans.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				System.out.println(it.next());
				break;
				
			case 6:
				sc.nextLine();
				System.out.println("Indica el nom del ciutada");
				nom = sc.nextLine();
				
				System.out.println("Indica el cognom del ciutada");
				cognom = sc.nextLine();
				
				System.out.println("Indica el DNI del ciutada");
				DNI = sc.nextLine();
				
				if (nom==null || nom.equals("") || cognom==null || cognom.equals("") || DNI==null || DNI.equals("")) {
					System.err.println("Error, ciutada no complet");
				}else {
					posicio=llistaCiutadans.Buscar(new Ciutada(nom, cognom, DNI));
					ctd1=llistaCiutadans.Obtenir(posicio);
					if(ctd1.compareTo(new Ciutada(nom, cognom, DNI))==0){
						System.out.println("Ciutada:\n"+ ctd1);
						System.out.println("S'han recorregut "+ posicio +" ciutadans");
					}
					else {
						System.out.println("No s'ha trobat el ciutada cercat");
					}
				}

				break;
			case 7:
					//System.out.println(llistaCiutadans);
					it = llistaCiutadans.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					System.out.println(it.next());
				break;
			}
		}

	}

	private static void menuOpcions() {
		do {
			System.out.println("Menu d'opcions:");
			System.out.println("0. Finalitzar");
			System.out.println("1. Inserir un element al final de la llista");
			System.out.println("2. Inserir un element a una posicio de la llista");
			System.out.println("3. Obtindre un node de la llista");
			System.out.println("4. Obtindre el tamany de la llista");
			System.out.println("5. Esborrar un node de la llista");
			System.out.println("6. Buscar si un element a la llista");
			System.out.println("7. Mostrar el contingut de tota la llista");

			System.out.print("Triar: ");
			opcio = sc.nextInt();

		} while (opcio < 0 || opcio > 7);
	}
}
