'''
Created on Jan 21, 2016
'''

import pydot
from textx.export import metamodel_export, model_export
from textx.metamodel import metamodel_from_file
import generation.generator as generator

metamodel = metamodel_from_file("language_definition.tx")
metamodel_export(metamodel, "meta.dot")
graph = pydot.graph_from_dot_file("meta.dot")
graph.write_png("meta.png")

model = metamodel.model_from_file("example.cafe")
model_export(model, "model.dot")
graph = pydot.graph_from_dot_file("model.dot")
graph.write_png("model.png")
 
 
# generator.generate("painter_template.java", "painter.java", {"canvas" : model})
