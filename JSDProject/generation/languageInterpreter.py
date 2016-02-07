
class Interpreter(object):
    
    
    def __init__(self, model):
        self.component = {}
        self.model = model
        
    def interpret(self):
        
        print (self.model.naziv_kafica)
        print ('#####')
        for nivo in self.model.nivo:
            print(nivo.naziv_nivoa)
        print ('#####')
        for nivo in self.model.nivo:
            print(nivo.naziv_nivoa+" : \n")
            for element in nivo.element:
                print ("\t"+ element.naziv_elementa)
            print ('#####') 
            for element in nivo.element:
                print (element.naziv_elementa+" : \n")
                for oblik in element.oblik:
                    print ("\t"+ oblik.__class__.__name__)
        print ('#####')

        