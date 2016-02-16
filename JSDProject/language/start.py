'''
Created on Jan 21, 2016
'''

import pydot
from textx.export import metamodel_export, model_export
from textx.metamodel import metamodel_from_file
import generation.generator as generator
from generation.languageInterpreter import Interpreter

def javaPackageAndImports():
        importList = ["package test;\n",
                      "import java.awt.Color;",
                      "import java.awt.geom.Point2D;",
                      "import java.util.ArrayList;",
                      "import model.Canvas;",
                      "import model.Element;",
                      "import model.Oblik;",
                      "import model.elements.Elipsa;",
                      "import model.elements.Pravougaonik;",
                      "import model.elements.Trougao;",
                      "import view.MainFrame;"]
        return importList

if __name__ == "__main__":

    metamodel = metamodel_from_file("language_definition.tx")
    metamodel_export(metamodel, "meta.dot")
    graph = pydot.graph_from_dot_file("meta.dot")
    graph.write_png("meta.png")
    
    model = metamodel.model_from_file("example.cafe")
    model_export(model, "model.dot")
    graph = pydot.graph_from_dot_file("model.dot")
    graph.write_png("model.png")
     
    interpreter = Interpreter(model)
    interpreter.interpret()
    konkretanKafic = interpreter.kafic
    generator.generate("painter_template.java", "CafePainter.java", 
                       {"canvas" : model, "imports" : javaPackageAndImports(), "kafic" : konkretanKafic } )
