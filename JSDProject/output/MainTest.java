
package test;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import model.Canvas;
import model.Element;
import model.Kafic;
import model.Oblik;
import model.elements.Elipsa;
import model.elements.Pravougaonik;
import model.elements.Trougao;
import model.elements.Linija;
import model.elements.ZaobljeniPravougaonik;
import model.pozicija.KoordinatePozicija;
import model.raspored.KoordinateRaspored;
import model.raspored.GridRaspored;
import model.raspored.Raspored;
import model.pozicija.GridPozicija;
import model.pozicija.Pozicija;
import model.pozicija.StraneSvetaPozicija;
import model.raspored.StraneSvetaRaspored;
import model.raspored.StraneSveta;
import view.MainFrame;

public class MainTest {
	
	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	
		List<Canvas> listaNivoa  = new ArrayList<Canvas>();
		Kafic kafic = new Kafic("Skochko", listaNivoa);
		mainFrame.setTitle(kafic.getNaziv());
	
		Raspored raspored_prizemlje = new GridRaspored(3,3);
		Canvas prizemlje = new Canvas("prizemlje", 600, 600, Color.white, raspored_prizemlje, kafic);
		raspored_prizemlje.setNivo(prizemlje);
		listaNivoa.add(prizemlje);
		mainFrame.addTab(prizemlje);
	
		Element sto11 = null;
		ArrayList<Oblik> oblicisto11 = new ArrayList<Oblik>();
					
		Elipsa elipsa1 = new Elipsa(new GridPozicija(0,0,raspored_prizemlje),sto11,Color.pink,0,150,100);

		oblicisto11.add(elipsa1);	
		sto11 = new Element("sto11", oblicisto11, prizemlje);		
		prizemlje.addElementToCanvas(sto11);		
		Element sto22 = null;
		ArrayList<Oblik> oblicisto22 = new ArrayList<Oblik>();
					
		Pravougaonik pravougaonik2 = new Pravougaonik(new GridPozicija(1,0,raspored_prizemlje),sto22,Color.yellow,0,160,160);

		oblicisto22.add(pravougaonik2);	
		sto22 = new Element("sto22", oblicisto22, prizemlje);		
		prizemlje.addElementToCanvas(sto22);		
		Element sto33 = null;
		ArrayList<Oblik> oblicisto33 = new ArrayList<Oblik>();
					
		Trougao trougao3 = new Trougao(new GridPozicija(1,1,raspored_prizemlje),sto33,Color.green,0,100,100,100);

		oblicisto33.add(trougao3);	
		sto33 = new Element("sto33", oblicisto33, prizemlje);		
		prizemlje.addElementToCanvas(sto33);		
		Element sto44 = null;
		ArrayList<Oblik> oblicisto44 = new ArrayList<Oblik>();
					
		ZaobljeniPravougaonik zaobljeniPravougaonik4 = new ZaobljeniPravougaonik(new GridPozicija(1,2,raspored_prizemlje),sto44,Color.orange,0,160,160,10,10);

		oblicisto44.add(zaobljeniPravougaonik4);	
		sto44 = new Element("sto44", oblicisto44, prizemlje);		
		prizemlje.addElementToCanvas(sto44);		
		Raspored raspored_prvi_sprat = new StraneSvetaRaspored();
		Canvas prvi_sprat = new Canvas("prvi_sprat", 600, 500, Color.white, raspored_prvi_sprat, kafic);
		raspored_prvi_sprat.setNivo(prvi_sprat);
		listaNivoa.add(prvi_sprat);
		mainFrame.addTab(prvi_sprat);
	
		Element paravan5 = null;
		ArrayList<Oblik> obliciparavan5 = new ArrayList<Oblik>();
					
		Linija linija5 = new Linija(new StraneSvetaPozicija(StraneSveta.zapad,raspored_prvi_sprat),paravan5,Color.yellow,0,100);

		obliciparavan5.add(linija5);	
		paravan5 = new Element("paravan5", obliciparavan5, prvi_sprat);		
		prvi_sprat.addElementToCanvas(paravan5);		
		Element sto56 = null;
		ArrayList<Oblik> oblicisto56 = new ArrayList<Oblik>();
					
		ZaobljeniPravougaonik zaobljeniPravougaonik6 = new ZaobljeniPravougaonik(new StraneSvetaPozicija(StraneSveta.centar,raspored_prvi_sprat),sto56,Color.blue,0,160,160,15,15);

		oblicisto56.add(zaobljeniPravougaonik6);	
		sto56 = new Element("sto56", oblicisto56, prvi_sprat);		
		prvi_sprat.addElementToCanvas(sto56);		
		Element sto67 = null;
		ArrayList<Oblik> oblicisto67 = new ArrayList<Oblik>();
					
		Pravougaonik pravougaonik7 = new Pravougaonik(new StraneSvetaPozicija(StraneSveta.istok,raspored_prvi_sprat),sto67,Color.gray,0,100,160);

		oblicisto67.add(pravougaonik7);	
		sto67 = new Element("sto67", oblicisto67, prvi_sprat);		
		prvi_sprat.addElementToCanvas(sto67);		
		Element sto78 = null;
		ArrayList<Oblik> oblicisto78 = new ArrayList<Oblik>();
					
		Elipsa elipsa8 = new Elipsa(new StraneSvetaPozicija(StraneSveta.jug,raspored_prvi_sprat),sto78,Color.yellow,0,60,60);

		oblicisto78.add(elipsa8);	
		sto78 = new Element("sto78", oblicisto78, prvi_sprat);		
		prvi_sprat.addElementToCanvas(sto78);		
		Raspored raspored_drugi_sprat = new KoordinateRaspored();
		Canvas drugi_sprat = new Canvas("drugi_sprat", 600, 600, Color.white, raspored_drugi_sprat, kafic);
		raspored_drugi_sprat.setNivo(drugi_sprat);
		listaNivoa.add(drugi_sprat);
		mainFrame.addTab(drugi_sprat);
	
		Element sto89 = null;
		ArrayList<Oblik> oblicisto89 = new ArrayList<Oblik>();
					
		Trougao trougao9 = new Trougao(new KoordinatePozicija(50,50,150,50,50,100,raspored_drugi_sprat),sto89,Color.red,0,100,100,100);

		oblicisto89.add(trougao9);	
		sto89 = new Element("sto89", oblicisto89, drugi_sprat);		
		drugi_sprat.addElementToCanvas(sto89);		
		Element sto910 = null;
		ArrayList<Oblik> oblicisto910 = new ArrayList<Oblik>();
					
		Pravougaonik pravougaonik10 = new Pravougaonik(new KoordinatePozicija(100,360,200,360,200,450,100,450,raspored_drugi_sprat),sto910,Color.green,10,100,100);

		oblicisto910.add(pravougaonik10);	
		sto910 = new Element("sto910", oblicisto910, drugi_sprat);		
		drugi_sprat.addElementToCanvas(sto910);		
	}

}