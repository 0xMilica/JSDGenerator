'''
Created on Dec 13, 2014

@author: xxx
'''

from jinja2.environment import Environment
from jinja2.loaders import PackageLoader


#Definisemo filter funkciju

def inputType(componentType):
    if componentType == "TextField":
        return "text"
    elif componentType == "Checkbox":
        return "checkbox"
    #moglo bi se dodati i za ostale tipove html input polja (uz prosirenje gramatike)
    #tipa date, password itd.
    return "text"
    
    

def generate(template_name, output_name, render_vars):
    env = Environment(trim_blocks = True, lstrip_blocks = True, loader = PackageLoader("generation", "templates"))
    #dodajemo filter pod nazivom inputType
    env.filters["inputType"] = inputType
    
    template = env.get_template(template_name)
    rendered = template.render(render_vars)
    print(rendered)
    #i pisemo u fajl
    file_name = "../output/" + output_name
    with open(file_name, "w+") as f:
        f.write(rendered)
        
    
    
    
    
                    