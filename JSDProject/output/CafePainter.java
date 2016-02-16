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
		
		Canvas canvas = mejnfrejm.getPanel();
		Element okrugli_sto = null;
		ArrayList<Oblik> oblici = new ArrayList<Oblik>();
		Elipsa testOblik = new Elipsa();
		oblici.add(testOblik);
					
		okrugli_sto = new Element(oblici);
		canvas.addElementToCanvas(okrugli_sto);		
		Element stolica = null;
		ArrayList<Oblik> oblici = new ArrayList<Oblik>();
		Elipsa testOblik = new Elipsa();
		oblici.add(testOblik);
					
		Pravougaonik testOblik = new Pravougaonik();
		oblici.add(testOblik);
					
		stolica = new Element(oblici);
		canvas.addElementToCanvas(stolica);		
		Canvas canvas = mejnfrejm.getPanel();
		Element sank = null;
		ArrayList<Oblik> oblici = new ArrayList<Oblik>();
		ZaobljeniPravougaonik testOblik = new ZaobljeniPravougaonik();
		oblici.add(testOblik);
					
		sank = new Element(oblici);
		canvas.addElementToCanvas(sank);		
		Canvas canvas = mejnfrejm.getPanel();
		
		
		
		
	//	Linija linija2 = new Linija(null, null, new Point2D.Double(12,12), new Point2D.Double(33,55));
	//	oblici.add(linija2);
		
		//test pravougaonika
		
		Pravougaonik pravougaonik = new Pravougaonik(null, Oblik.dashed, new Point2D.Double(55, 55), new Point2D.Double(155, 200));
		oblici.add(pravougaonik);
		
		Elipsa elipsa = new Elipsa (Color.BLUE, null, new Point2D.Double(70,70), 100, 100);
		
		oblici.add(elipsa);
		
		Trougao trougao = new Trougao(null, null, new Point2D.Double(10,15), new Point2D.Double(20, 70), new Point2D.Double(30,30));
		
		oblici.add(trougao);
	}

}