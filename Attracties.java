package Kermis;

import java.util.*;

public class Attracties {
	static ArrayList<Attractie> array = new ArrayList<Attractie>();
	public static void main(String[] args) {
		Menu m = new Menu();
		m.start(array);
	}

}

class Menu {
	void start(ArrayList<Attractie> array) {
		Attractie botsauto = new Botsauto("botsauto", 2.50, 0, 1);
		RisicoRijkeAttractie spin = new Spin("spin", 2.25, 0, 1);
		Attractie spiegelpaleis = new Spiegelpaleis("spiegelpaleis", 2.75, 0, 1);
		Attractie spookhuis = new Spookhuis("spookhuis", 3.20, 0, 1);
		RisicoRijkeAttractie hawaii = new Hawaii("hawaii", 2.90, 0, 1);
		Attractie ladderklimmen = new Ladderklimmen("ladderklimmen", 5.00, 0, 1);
		
		Kassa kassa = new Kassa();
		
		array.add(botsauto);
		array.add(spin);
		array.add(spiegelpaleis);
		array.add(spookhuis);
		array.add(hawaii);
		array.add(ladderklimmen);

		while (true) {
			Scanner sc = new Scanner(System.in);
			String keuze = sc.nextLine();
			switch (keuze) {
		case "1":botsauto.draaien();
				break;
		case "2":spin.draaien1();
				break;
		case "3":spiegelpaleis.draaien();
				break;
		case "4":spookhuis.draaien();
				break;
		case "5":hawaii.draaien2();
				break;
		case "6":ladderklimmen.draaien();
				break;
		case "o":kassa.Opbrengst(array);
				break;
		case "k":kassa.kaartenVerkocht(array);
				break;
		case "h": hawaii.monteurHawaii();
				break;
		case "s": spin.monteurSpin();
				break;
		case "b": ladderklimmen.kansSpelBelastingBetalen();
				break;
		default: System.out.println("verkeerde invoer");;
			}
		}
	}
}

class Kassa{
	public void Opbrengst(ArrayList<Attractie> array) {
		double totaleOpbrengst=0;
		for (Attractie a : array) {
			totaleOpbrengst	+= a.omzet;
		}
		System.out.println("De totale opbrengst is € " +totaleOpbrengst);
	}
	public void kaartenVerkocht (ArrayList<Attractie> array) {
		int totaalAantalKaartjes=0;
		for (Attractie a : array) {
			totaalAantalKaartjes += a.verkochteKaartjes;
		}
		System.out.println("Het totaal aantal verkochte kaartjes is: " + totaalAantalKaartjes + " kaartjes");
	}
}

interface kansSpelBelasting {
	void kansSpelBelastingBetalen();
}
class GokAttractie extends Attractie{

	public GokAttractie(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
	public void kansSpelBelastingBetalen(){
		
	}
	
}

class Attractie implements kansSpelBelasting {
	String naam;
	double omzet;
	double prijs;
	int aantalKaartjes;
	int verkochteKaartjes;
	double oppervlakte;

	public Attractie(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		this.naam = naam;
		this.prijs = prijs;
		this.oppervlakte = oppervlakte;
		this.aantalKaartjes = aantalKaartjes;

	}

	public void kansSpelBelastingBetalen() {	
	}
	
	public void draaien() {
		System.out.println(naam + " draait €" + prijs);
		System.out.println("De omzet van de €" + naam + " is: " + (omzet+=prijs));
		System.out.println("De hoeveelheid verkochte kaartjes van de " + naam + " is: " + (verkochteKaartjes= ++aantalKaartjes));
	}
}

abstract class RisicoRijkeAttractie extends Attractie{

	public RisicoRijkeAttractie(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
	public void draaien1() {
		if (verkochteKaartjes !=0 && verkochteKaartjes%5 == 0) {
			omzet-=prijs;
			verkochteKaartjes= --aantalKaartjes;
			System.out.println("Monteur nodig voor de " + naam);
		}else {
		System.out.println(naam + " draait €" + prijs);
		System.out.println("De omzet van de €" + naam + " is: " + (omzet+=prijs));
		System.out.println("De hoeveelheid verkochte kaartjes van de " + naam + " is: " + (verkochteKaartjes= ++aantalKaartjes));
		}
		}
	public void monteurSpin() {
		System.out.println("Spin gefixt");
		aantalKaartjes++;
		omzet+=prijs;
	}
	public void draaien2() {
		if (verkochteKaartjes !=0 && verkochteKaartjes%10 == 0) {
			omzet-=prijs;
			verkochteKaartjes= --aantalKaartjes;
			System.out.println("Monteur nodig voor de " + naam);
			
		}else {
		System.out.println(naam + " draait €" + prijs);
		System.out.println("De omzet van de €" + naam + " is: " + (omzet+=prijs));
		System.out.println("De hoeveelheid verkochte kaartjes van de " + naam + " is: " + (verkochteKaartjes= ++aantalKaartjes));
		}
		}
	public void monteurHawaii() {
		System.out.println("Hawaii gefixt");
		aantalKaartjes++;
		omzet+=prijs;
	}
}

class Botsauto extends Attractie {
	Botsauto(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
}

class Spin extends RisicoRijkeAttractie {
	Spin(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
}

class Spiegelpaleis extends Attractie {
	Spiegelpaleis(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
}

class Spookhuis extends Attractie {
	Spookhuis(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
}

class Hawaii extends RisicoRijkeAttractie {
	Hawaii(String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
}
class Ladderklimmen extends GokAttractie {
	Ladderklimmen (String naam, double prijs, int aantalKaartjes, double oppervlakte) {
		super(naam, prijs, aantalKaartjes, oppervlakte);
	}
	public void kansSpelBelastingBetalen() {
		System.out.println("De kansSpelBelasting van " +naam+ " is " + (omzet*0.3));
		omzet*=0.7;
	}
}
