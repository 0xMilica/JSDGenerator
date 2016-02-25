{% macro attributes(dict)%}
	{% for key, value in dict.items() %}
		{% if loop.last -%}
{{ value }});
		{% else %}
{{ value }}, 
		{%- endif %}
	{% endfor %}
{% endmacro %}

{% macro packageAndImports(imports) %}
	{% for packageAndImport in imports %}
{{packageAndImport}}
	{% endfor %}
{% endmacro %}
{{packageAndImports(imports)}}

public class CafePainter {

	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	
		List<Canvas> listaNivoa  = new ArrayList<Canvas>();
		Kafic kafic = new Kafic("{{kafic.naziv}}", listaNivoa);
		mainFrame.setTitle(kafic.getNaziv());
		
{% for canvas in kafic.nivoi %}
		Canvas {{canvas.naziv}} = new Canvas("{{canvas.naziv}}", {{canvas.sirina}}, {{canvas.duzina}}, Color.{{canvas.boja_podloge}});
		listaNivoa.add({{canvas.naziv}});
		mainFrame.addTab({{canvas.naziv}});		
	{% for element in canvas.elementi %}
		Element {{element.naziv}} = null;
		ArrayList<Oblik> oblici{{element.naziv}} = new ArrayList<Oblik>();
		{% for oblik in element.oblici %}					
		{{oblik.ime_klase}} {{oblik.naziv}} = new {{oblik.ime_klase}}({{attributes(oblik.atributi)}}
		oblici{{element.naziv}}.add({{oblik.naziv}});	
		{% endfor %}
		{{element.naziv}} = new Element("{{element.naziv}}", oblici{{element.naziv}});		
		{{canvas.naziv}}.addElementToCanvas({{element.naziv}});		
	{% endfor %}
{% endfor %}
	}

}
