from collections import OrderedDict

class Interpreter(object):
    
    
    def __init__(self, model):
        self.component = {}
        self.model = model  
        self.kafic = None      
       
    def first_lower(self, stringg):
        if len(stringg) == 0:
            return stringg
        else:
            return stringg[0].lower() + stringg[1:]
        
    def interpret(self):
        
        self.kafic = Kafic(self.model.naziv)
        brojacOblika = 0;
        brojacElemenata = 0;
        
        for nivo in self.model.nivo:
            
            temp_nivo = Nivo(naziv = nivo.naziv, sirina = nivo.sirina, duzina = nivo.duzina, boja_podloge = nivo.boja_podloge)
            print(nivo.naziv+" : \n")
            
            for element in nivo.element:
                brojacElemenata += 1
                print ("\t"+ element.naziv)
                temp_element = Element(naziv = element.naziv+str(brojacElemenata))

                for oblik in element.oblik:
                    
                    print ("\t"+ oblik.__class__.__name__)
                    clsname = oblik.tipOblika.__class__.__name__
                    brojacOblika += 1
                    
                    if clsname == 'Elipsa':
                        atributi = OrderedDict([('Color' , 'Color.'+oblik.boja.upper()),
                                    ('Stroke' , 'null'),
                                    ('ugao' , oblik.ugao),
                                    ('centar' , 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka.x, oblik.tipOblika.tacka.y)),
                                    ('visina' , oblik.tipOblika.r1), 
                                    ('sirina' , oblik.tipOblika.r2)
                                    ])
        
                    elif clsname == 'Pravougaonik':
                        atributi = OrderedDict([('Color','Color.'+oblik.boja.upper()),
                                    ('Stroke' , 'null'),
                                    ('ugao' , oblik.ugao),
                                    ('pocetnaTacka' , 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka[0].x, oblik.tipOblika.tacka[0].y)),
                                    ('krajnjaTacka' , 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka[1].x, oblik.tipOblika.tacka[1].y))
                                    ])
                        print atributi
                    elif clsname == 'Trougao':
                        atributi = OrderedDict([('Color','Color.'+oblik.boja.upper()),
                                    ('Stroke' , 'null'),
                                    ('ugao' , oblik.ugao),
                                    ('a' , 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka[0].x, oblik.tipOblika.tacka[0].y)),
                                    ('b' , 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka[1].x, oblik.tipOblika.tacka[1].y)),
                                    ('c' , 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka[2].x, oblik.tipOblika.tacka[2].y))
                                    ])
                        print atributi
                    elif clsname == 'ZaobljeniPravougaonik':
                        atributi = OrderedDict([('Color','Color.'+oblik.boja.upper()),
                                    ('Stroke' , 'null'),
                                    ('ugao' , oblik.ugao),
#                                     TODO ispada iz sablona po kom su odradjeni ostali graficki elementi
#                                     'pozicija' : 'new Point2D.Double({0},{1})'.format(oblik.tipOblika.tacka.x, oblik.tipOblika.tacka.y),
                                    ('sirinaPravougaonika' , oblik.tipOblika.sirina_pravougaonika),
                                    ('visinaPravougaonika' , oblik.tipOblika.visina_pravougaonika),
                                    ('sirinaLuka' , oblik.tipOblika.sirina_luka),
                                    ('visinaLuka' , oblik.tipOblika.visina_luka)
                                    ])
                    
                    temp_oblik = Oblik(self.first_lower(clsname)+str(brojacOblika), oblik.boja, oblik.ugao, clsname, atributi)
                
                    temp_element.oblici.append(temp_oblik)
                    
                temp_nivo.elementi.append(temp_element)
                
            self.kafic.nivoi.append(temp_nivo)
                

class Kafic(object):
    
    def __init__(self, naziv):
        self.naziv = naziv
        self.nivoi = []
    
class Nivo(object):
    
    def __init__(self, naziv, duzina, sirina, boja_podloge):
        self.naziv = naziv
        self.duzina = duzina
        self.sirina = sirina
        self.boja_podloge = boja_podloge
        self.elementi = []
        
class Element(object):
    
    def __init__(self, naziv):
        self.naziv = naziv
        self.oblici = []
        
class Oblik(object):
    
    def __init__(self, naziv, boja, ugao, ime_klase, atributi):
        self.naziv = naziv
        self.boja = boja
        self.ugao = ugao
        self.ime_klase= ime_klase
        self.atributi = atributi
        
            