{% macro packageAndImports(imports) %}
	{% for packageAndImport in imports %}
{{packageAndImport}}
	{% endfor %}
{% endmacro %}
{{packageAndImports(imports)}}

public class {{kafic.naziv}} {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		MainFrame mejnfrejm = new MainFrame();
		mejnfrejm.setVisible(true);
		
		// TODO: Deo za jezik
		
		{% for canvas in kafic.nivoi %}
		Canvas canvas = mejnfrejm.getPanel();
				{% for element in canvas.elementi %}
		Element {{element.naziv}} = null;
		ArrayList<Oblik> oblici = new ArrayList<Oblik>();
					{% for oblik in element.oblici %}
		{{oblik.ime_klase}} {{oblik.naziv}} = new {{oblik.ime_klase}}();
		oblici.add({{oblik.naziv}});
					
					{% endfor %}
		{{element.naziv}} = new Element(oblici);
		canvas.addElementToCanvas({{element.naziv}});		
			{% endfor %}
		{% endfor %}
		
		
		
		
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
