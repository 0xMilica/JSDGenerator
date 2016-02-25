
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
import view.MainFrame;


public class CafePainter {

	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	
		List<Canvas> listaNivoa  = new ArrayList<Canvas>();
		Kafic kafic = new Kafic("Skochko", listaNivoa);
		mainFrame.setTitle(kafic.getNaziv());
		
		Canvas prizemlje = new Canvas("prizemlje", 500, 500, Color.gray);
		listaNivoa.add(prizemlje);
		mainFrame.addTab(prizemlje);		
		Element okrugli_sto1 = null;
		ArrayList<Oblik> obliciokrugli_sto1 = new ArrayList<Oblik>();
					
		Elipsa elipsa1 = new Elipsa(Color.RED,null,0,new Point2D.Double(100,100),120,150);

		obliciokrugli_sto1.add(elipsa1);	
		okrugli_sto1 = new Element("okrugli_sto1", obliciokrugli_sto1);		
		prizemlje.addElementToCanvas(okrugli_sto1);		
		Element stolica2 = null;
		ArrayList<Oblik> oblicistolica2 = new ArrayList<Oblik>();
					
		Elipsa elipsa2 = new Elipsa(Color.BLUE,null,0,new Point2D.Double(300,300),60,60);

		oblicistolica2.add(elipsa2);	
					
		Pravougaonik pravougaonik3 = new Pravougaonik(Color.BLUE,null,0,new Point2D.Double(100,350),new Point2D.Double(200,450));

		oblicistolica2.add(pravougaonik3);	
		stolica2 = new Element("stolica2", oblicistolica2);		
		prizemlje.addElementToCanvas(stolica2);		
		Canvas prvi_sprat = new Canvas("prvi_sprat", 450, 450, Color.gray);
		listaNivoa.add(prvi_sprat);
		mainFrame.addTab(prvi_sprat);		
		Element sank3 = null;
		ArrayList<Oblik> oblicisank3 = new ArrayList<Oblik>();
					
		ZaobljeniPravougaonik zaobljeniPravougaonik4 = new ZaobljeniPravougaonik(Color.GREEN,null,0,new Point2D.Double(120,120),65,75,10,10);

		oblicisank3.add(zaobljeniPravougaonik4);	
		sank3 = new Element("sank3", oblicisank3);		
		prvi_sprat.addElementToCanvas(sank3);		
		Canvas drugi_sprat = new Canvas("drugi_sprat", 300, 500, Color.gray);
		listaNivoa.add(drugi_sprat);
		mainFrame.addTab(drugi_sprat);		
	}

}