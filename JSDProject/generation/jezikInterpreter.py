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
            
            naziv = ""
            atributi = ""
            naziv_rasporeda = nivo.raspored.__class__.__name__
            if naziv_rasporeda == "Grid":
                naziv = 'GridRaspored'
                atributi = '{0},{1}'.format(nivo.raspored.broj_kolona, nivo.raspored.broj_redova)          
            elif naziv_rasporeda == "Koordinate":
                naziv = 'KoordinateRaspored'
            elif naziv_rasporeda == "StraneSveta":
                naziv = 'StraneSvetaRaspored'
                
            temp_raspored = Raspored(naziv, atributi)
            
            temp_nivo = Nivo(naziv = nivo.naziv, sirina = nivo.sirina, duzina = nivo.duzina, 
                             boja_podloge = nivo.boja_podloge, raspored = temp_raspored)

            naziv = ""
            atributi = ""
            brojac_pozicija = 0
            for pozicija in nivo.raspored.pozicije:
                
                brojac_pozicija += 1
                
                if pozicija.__class__.__name__ == 'GridPozicija':
                    naziv = 'GridPozicija'
                    atributi ='{0},{1}'.format(pozicija.broj_kolone, pozicija.broj_reda)
                
                if pozicija.__class__.__name__ == 'KoordinatePozicija':
                    for tacka in pozicija.koordinate:
                        naziv = 'KoordinatePozicija'
                        atributi ='{0},{1}'.format(tacka.x, tacka.y)
                
                if pozicija.__class__.__name__ == 'StraneSvetaPozicija':
                    naziv = 'StraneSvetaPozicija'
                    atributi = 'StraneSveta.{0}'.format(pozicija.strana_sveta)
            
                temp_pozicija = Pozicija(self.first_lower(naziv)+str(brojac_pozicija), naziv_pozicije = naziv, atributi = atributi)  
                temp_nivo.raspored = temp_raspored
                temp_raspored.pozicije.append(temp_pozicija)
                
            for element in nivo.element:
                brojacElemenata += 1
                temp_element = Element(naziv = element.naziv+str(brojacElemenata))

                for oblik in element.oblik:
                    
                    clsname = oblik.tipOblika.__class__.__name__
                    #print ("\t" + clsname)
                    brojacOblika += 1
                    lista = []
                    rasp = nivo.raspored.__class__.__name__
                    pozicija_oblika = ""
                    pozicija_oblika_polje = ""
                    if rasp == "Grid":
                        pozicija_oblika = "new GridPozicija({0},{1},{2})".format(oblik.pozicija.broj_kolone, 
                                                                                 oblik.pozicija.broj_reda,
                                                                                 "raspored_"+nivo.naziv)
                    elif rasp == "StraneSveta":
                        strana = "StraneSveta.{0}".format(oblik.pozicija.strana_sveta)
                        pozicija_oblika = "new StraneSvetaPozicija({0},{1})".format(strana,"raspored_"+nivo.naziv)
                    elif rasp == "Koordinate":
                        for tacka in oblik.pozicija.koordinate:
                            atributi ='{0},{1}'.format(tacka.x, tacka.y)
                            lista.append(atributi)
                        pozicija_oblika = "new KoordinatePozicija({0},{1})".format(",".join(lista),"raspored_"+nivo.naziv)
                    if clsname == 'Elipsa':                                      
                        atributi = OrderedDict([
                                    ('boja' , 'Color.' + oblik.boja),
                                    ('ugao' , oblik.ugao),
                                    ('precnik1' , oblik.tipOblika.precnik1), 
                                    ('precnik2' , oblik.tipOblika.precnik2)
                                    ])       
                    elif clsname == 'Pravougaonik':
                        atributi = OrderedDict([
                                    ('boja','Color.' + oblik.boja),
                                    ('ugao' , oblik.ugao),
                                    ('a' , oblik.tipOblika.a),
                                    ('b' , oblik.tipOblika.b),
                                    ])
                        #print atributi
                    elif clsname == 'Trougao':
                        atributi = OrderedDict([
                                    ('boja','Color.' + oblik.boja),
                                    ('ugao' , oblik.ugao),
                                    ('a' , oblik.tipOblika.a),
                                    ('b' , oblik.tipOblika.b),
                                    ('c' , oblik.tipOblika.c)
                                    ])
                        #print atributi
                    elif clsname == 'ZaobljeniPravougaonik':
                        atributi = OrderedDict([
                                    ('boja','Color.' + oblik.boja),
                                    ('ugao' , oblik.ugao),
                                    ('a' , oblik.tipOblika.a),
                                    ('b' , oblik.tipOblika.b),
                                    ('sirina_luka' , oblik.tipOblika.sirina_luka),
                                    ('visina_luka' , oblik.tipOblika.visina_luka)
                                    ])
                    elif clsname == 'Linija':
                        atributi = OrderedDict([
                                    ('boja','Color.' + oblik.boja),
                                    ('ugao' , oblik.ugao),
                                    ('a' , oblik.tipOblika.a),
                                    ])
 
                    print(pozicija_oblika_polje)
                    temp_oblik = Oblik(self.first_lower(clsname)+str(brojacOblika), oblik.boja, oblik.ugao, clsname, atributi, 
                                       pozicija = pozicija_oblika)
                
                    temp_element.oblici.append(temp_oblik) 
                
                temp_nivo.elementi.append(temp_element)

            self.kafic.nivoi.append(temp_nivo)
                

class Kafic(object):
    
    def __init__(self, naziv):
        self.naziv = naziv
        self.nivoi = []
    
class Nivo(object):
    
    def __init__(self, naziv, duzina, sirina, boja_podloge, raspored):
        self.naziv = naziv
        self.duzina = duzina
        self.sirina = sirina
        self.boja_podloge = boja_podloge
        self.raspored = raspored
        self.elementi = []
        
class Element(object):
    
    def __init__(self, naziv):
        self.naziv = naziv
        self.oblici = []
        
class Oblik(object):
    
    def __init__(self, naziv, boja, ugao, ime_klase, atributi, pozicija):
        self.naziv = naziv
        self.boja = boja
        self.ugao = ugao
        self.ime_klase = ime_klase
        self.atributi = atributi
        self.pozicija = pozicija
        
class Raspored(object):
    
    def __init__(self, naziv, atributi):
        self.naziv = naziv
        self.atributi = atributi 
        self.pozicije = []
                   
class Pozicija(object):
    
    def __init__(self, polje, naziv_pozicije, atributi):
        self.polje = polje
        self.naziv_pozicije = naziv_pozicije
        self.atributi = atributi
