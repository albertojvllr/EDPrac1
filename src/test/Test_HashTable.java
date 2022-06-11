package test;
import java.util.Iterator;
import java.util.Scanner;

import linked_list.Linked_List;
import hash_table.Hashtable;
import excepcions.NoEsborrat;
import excepcions.NoInserit;
import excepcions.NoObtingut;
import excepcions.NoTrobat;

public class Test_HashTable {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws NoTrobat, NoInserit, NoEsborrat, NoObtingut{
		Ciutada[] ctds = new Ciutada[10];
		Linked_List<Ciutada> valors = new Linked_List<Ciutada>();
		Linked_List<String> claus = new Linked_List<String>();
		Iterator<Ciutada> itvalors = null;
		Iterator<String> itclaus = null;
		int opcio;
		String clau;
		
		ctds[0] = new Ciutada("Alberto", "Jovellar", "48054983W");
		ctds[1] = new Ciutada("Pepe", "Viyuela", "66666666S");
		ctds[2] = new Ciutada("Harrison", "Ford", "12345678D");
		ctds[3] = new Ciutada("Kanye", "West", "58338934D");
		ctds[4] = new Ciutada("Kim", "Kardashian", "30635794H");
		ctds[5] = new Ciutada("Hared", "Leto", "27937958G");
		ctds[6] = new Ciutada("Mariano", "Rajoy", "12489688L");
		ctds[7] = new Ciutada("Mac", "Miller", "23657854M");
		ctds[8] = new Ciutada("Eduardo", "Camavinga", "24567769F");
		ctds[9] = new Ciutada("Pedri", "Gonzalez", "12454576B");
		
		Hashtable<Ciutada, String> taula= new Hashtable<Ciutada,String>();
		taula.Crear(17);
		
		for(int i = 0; i < 10; i++) {
			taula.Inserir(ctds[i].getDNI(), ctds[i]);
		}
		do {
			opcio=opcions();
			
			switch (opcio) {
			case 1:
				try {
					Inserir2(taula);
				} catch (NoInserit e) {
					System.out.println("\n" + e + "\n");;
				}
				
				break;
			case 2:
				System.out.println("Escriu la clau: ");
				sc.nextLine();
				clau=sc.nextLine();
				try {
					System.out.println(taula.obtenir(clau));
				} catch (NoObtingut e) {
					System.out.println("\n" + e + "\n");
				}
				break;
			case 3:
				try {
					opcio=Buscar(taula);
					System.out.println("El ciutada es a la taula. Cost: " + opcio);
				} catch (NoTrobat e) {
					System.out.println("\n" + e + "\n");
				}
				break;
			case 4:
				System.out.println("La mida de la taula es: " + taula.Mida());
				break;
			case 5:
				System.out.println("Introdueix la clau del ciutada a borrar: ");
				sc.nextLine();
				clau = sc.nextLine();
				try {
					taula.Esborrar(clau);				
				} catch (NoEsborrat e) {
					System.out.println("\n" + e + "\n");
				}
				break;
			case 6:
				valors=taula.ObtenirValors();
				
				itvalors = valors.iterator();
				while(itvalors.hasNext()) {
					System.out.println(itvalors.next());
				}
				System.out.println(itvalors.next());
				break;
			case 7:
				claus=taula.ObtenirClaus();
				
				itclaus = claus.iterator();
				while(itclaus.hasNext()) {
					System.out.println(itclaus.next());
				}
				System.out.println(itclaus.next());
				
				break;
			case 8:
				System.out.println("\nEl factor de carrega es: " + taula.ObtenirFactorDeCarrega() + "\n");
				break;
			}
	
		}while(opcio != 0);	
		System.out.println("Programa Finalitzat");
	}
	public static int opcions() {
		int opcio;
		System.out.println("1-Inserir ciutada");
		System.out.println("2-Obtenir ciutada amb la clau");
		System.out.println("3-Buscar ciutada");
		System.out.println("4-Mida taula");
		System.out.println("5-Esborrar ciutada");
		System.out.println("6-Obtenir ciutada");
		System.out.println("7-Obtenir clau");
		System.out.println("8-Obtenir factor de carrega");
		System.out.println("0-Finalitzar");
		
		do {
			System.out.println("Tria: ");
			opcio = sc.nextInt();
		}while(opcio < 0 || opcio > 8);
		return opcio;
		
	}
	public static void Inserir2(Hashtable<Ciutada, String> taula) throws NoInserit{
		sc.nextLine();
		System.out.println("\nNom: ");
		String nom = sc.nextLine();
		
		System.out.println("\nCognom: ");
		String cognom = sc.nextLine();
		
		System.out.println("\nDNI: ");
		String dni = sc.nextLine();
		
		Ciutada ctd1 = new Ciutada(nom, cognom, dni);
		taula.Inserir(ctd1.getDNI(), ctd1);
		
		if(taula.ObtenirFactorDeCarrega()>0.75) {
			taula.Redimensionar();
		}

	}
	
	
	
	public static int Buscar(Hashtable<Ciutada, String> taula) throws NoTrobat{
		sc.nextLine();
		System.out.println("\nIntrodueix el DNI: ");
		String clau = sc.nextLine();
		
		return taula.Buscar(clau);
	}
}
