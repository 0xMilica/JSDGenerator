
class Interpreter(object):
    
    
    def __init__(self, model):
        self.component = {}
        self.model = model
        
    def interpret(self):
        
        print (self.model.naziv)
        print ('#####')
        for nivo in self.model.nivo:
            print(nivo.naziv)
        print ('#####')
        for nivo in self.model.nivo:
            print(nivo.naziv+" : \n")
            for element in nivo.element:
                print ("\t"+ element.naziv)
            print ('#####') 
            for element in nivo.element:
                print (element.naziv+" : \n")
                for oblik in element.oblik:
                    print ("\t"+ oblik.__class__.__name__)
        print ('#####')

        