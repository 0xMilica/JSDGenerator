
package test;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import model.Canvas;
import model.Element;
import model.Oblik;
import model.elements.Elipsa;
import model.elements.Pravougaonik;
import model.elements.Trougao;
import view.MainFrame;


public class Skochko {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MainFrame mejnfrejm = new MainFrame();
		mejnfrejm.setVisible(true);
		
		// TODO: Deo za jezik
		
		Canvas prizemlje = mejnfrejm.getPanel();
		Element okrugli_sto1 = null;
		ArrayList<Oblik> obliciokrugli_sto1 = new ArrayList<Oblik>();
					
		Elipsa elipsa1 = new Elipsa(Color.RED,null,0,new Point2D.Double(20,30),3,3);

		obliciokrugli_sto1.add(elipsa1);	
		okrugli_sto1 = new Element("okrugli_sto1", obliciokrugli_sto1);
		prizemlje.addElementToCanvas(okrugli_sto1);		
		Element stolica2 = null;
		ArrayList<Oblik> oblicistolica2 = new ArrayList<Oblik>();
					
		Elipsa elipsa2 = new Elipsa(Color.BLUE,null,0,new Point2D.Double(20,30),5,5);

		oblicistolica2.add(elipsa2);	
					
		Pravougaonik pravougaonik3 = new Pravougaonik(Color.BLUE,null,0,new Point2D.Double(10,10),new Point2D.Double(20,20));

		oblicistolica2.add(pravougaonik3);	
		stolica2 = new Element("stolica2", oblicistolica2);
		prizemlje.addElementToCanvas(stolica2);		
		Canvas prvi_sprat = mejnfrejm.getPanel();
		Element sank3 = null;
		ArrayList<Oblik> oblicisank3 = new ArrayList<Oblik>();
					
		ZaobljeniPravougaonik zaobljeniPravougaonik4 = new ZaobljeniPravougaonik(Color.GREEN,null,0,30,30,10,10);

		oblicisank3.add(zaobljeniPravougaonik4);	
		sank3 = new Element("sank3", oblicisank3);
		prvi_sprat.addElementToCanvas(sank3);		
		Canvas drugi_sprat = mejnfrejm.getPanel();
		
		
		
		
	//	Linija linija2 = new Linija(null, null, new Point2D.Double(12,12), new Point2D.Double(33,55));
	//	oblici.add(linija2);
		
		//test pravougaonika
		
//		Pravougaonik pravougaonik = new Pravougaonik(null, Oblik.dashed, new Point2D.Double(55, 55), new Point2D.Double(155, 200));
//		oblici.add(pravougaonik);
//		
//		Elipsa elipsa = new Elipsa (Color.BLUE, null, new Point2D.Double(70,70), 100, 100);
//		
//		oblici.add(elipsa);
//		
//		Trougao trougao = new Trougao(null, null, new Point2D.Double(10,15), new Point2D.Double(20, 70), new Point2D.Double(30,30));
//		
//		oblici.add(trougao);
	}

}