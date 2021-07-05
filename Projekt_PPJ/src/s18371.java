import java.io.*;

public class s18371 {
    public static void main(String[] args)  {
        switch (args[0]) {
            case "save":
                StatekPowietrzny[] stpow = {
                        new SamolotPasazerski(new int[]{-1, 2}, 20, 300, 200, 4, "SPP-1492","Boeing", 270,"LOT"),
                        new SamolotTransportowy(new int[]{5, 10}, 40, 200, 150, 2, "SLL-1500","Boeing", 1500,"DHL"),
                        new SamolotWojskowy(new int[]{10, 5}, 100, 150, 0, 4, "AAL-15560","Airbus", 10, "USA"),
                        new SamolotSportowy(new int[]{2, 8}, 5, 90, 150, 1, "SII-150","Cesna", "Czerwony"),
                        new SamolotModelarski(new int[]{2, 1}, 3, 5, 5, 1, "LLA-1","Baggo", 150,"1:40"),
                        new SamolotRolniczy(new int[]{-5,10},5,30,250,1,"SAA-1","Cesna",250),
                        new Szybowiec(new int[]{-100,-20},100,30,222,0,"SAP-1","DG",25000),
                        new Sterowiec(new int[]{500,200},30,27,140,1,"LLL-123","Sterowiec Polska",1500,300),
                        new HotAirBaloon(new int[]{10,20},40,2,10,0,"IAA-5","HAB",1500)
                };
                PrintWriter writer;
                try {
                    writer = new PrintWriter("samoloty.txt", "UTF-8");
                    for (int i = 0; i < stpow.length; i++) {
                        writer.println(stpow[i].toString());
                    }
                    writer.close();
                }
                catch (IOException e){
                    System.out.println("IO error");
                    break;
                }
                break;
            case "load":
                int par;
                try {
                    par = Integer.parseInt(args[1]);
                }catch (NumberFormatException e){
                    System.out.println("zły format liczby par");
                    break;
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(" nie podano liczby par");
                    break;
                }
                int currIdx = 0;
                Radar radar = new Radar();
                radar.sp = new StatekPowietrzny[0];
                FileReader fr ;
                try {
                    fr = new FileReader("samoloty.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        String[] linia = line.split(",");
                        switch (linia[0]) {
                            case "SamolotPasazerski":
                                SamolotPasazerski sp;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    sp = new SamolotPasazerski(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 100) : (int) (Math.random() * 100) * -1, random2 > 0.5 ? (int) (Math.random() * 100) : (int) (Math.random() * 100) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Integer.parseInt(linia[9]),
                                            linia[10]
                                    );
                                    radar.sp[currIdx] = sp;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "SamolotTransportowy":
                                SamolotTransportowy st;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    st = new SamolotTransportowy(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 100) : (int) (Math.random() * 100) * -1, random2 > 0.5 ? (int) (Math.random() * 100) : (int) (Math.random() * 100) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Double.parseDouble(linia[9]),
                                            linia[10]
                                    );
                                    radar.sp[currIdx] = st;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "SamolotWojskowy":
                                SamolotWojskowy sw;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    sw = new SamolotWojskowy(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 1000000) : (int) (Math.random() * 100) * -1, random2 > 0.5 ? (int) (Math.random() * 100) : (int) (Math.random() * 100) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Integer.parseInt(linia[9]),
                                            linia[10]
                                    );
                                    radar.sp[currIdx] = sw;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "SamolotSportowy":
                                SamolotSportowy ss;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    ss = new SamolotSportowy(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1, random2 > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            (linia[8])
                                    );
                                    radar.sp[currIdx] = ss;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "SamolotModelarski":
                                SamolotModelarski sm;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    sm = new SamolotModelarski(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1, random2 > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Integer.parseInt(linia[9]),
                                            linia[10]
                                    );
                                    radar.sp[currIdx] = sm;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "Sterowiec":
                                Sterowiec ste;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    ste = new Sterowiec(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1, random2 > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Double.parseDouble(linia[9]),
                                            Double.parseDouble(linia[10])
                                    );
                                    radar.sp[currIdx] = ste;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "HotAirBaloon":
                                HotAirBaloon ht;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    ht = new HotAirBaloon(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1, random2 > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Double.parseDouble(linia[9])

                                    );
                                    radar.sp[currIdx] = ht;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "Szybowiec":
                                Szybowiec szyb;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    szyb = new Szybowiec(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1, random2 > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Double.parseDouble(linia[9])

                                    );
                                    radar.sp[currIdx] = szyb;
                                    currIdx = currIdx + 1;
                                }
                                break;
                            case "SamolotRolniczy":
                                SamolotRolniczy srol;
                                for (int i = 0; i < par; i++) {
                                    radar.powiekszTablice();
                                    double random = (Math.random()), random2 = (Math.random());
                                    srol = new SamolotRolniczy(
                                            new int[]{random > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1, random2 > 0.5 ? (int) (Math.random() * 10) : (int) (Math.random() * 10) * -1},
                                            (int) (Math.random() * 1000),
                                            Double.parseDouble(linia[4]),
                                            Double.parseDouble(linia[5]),
                                            Integer.parseInt(linia[6]),
                                            linia[7],
                                            linia[8],
                                            Double.parseDouble(linia[9])

                                    );
                                    radar.sp[currIdx] = srol;
                                    currIdx = currIdx + 1;
                                }
                                break;


                        }
                    }
                }catch (FileNotFoundException e){
                    System.out.println("Brak pliku");
                    break;
                }
                catch (IOException e){
                    System.out.println("Błąd IO");
                    break;
                }
                double[] tablicaOdl = new double[radar.sp.length];
                for(int i =0;i<radar.sp.length;i++) {
                    tablicaOdl[i]=radar.odleglosc(radar.sp[i]);
                    if(tablicaOdl[i]>radar.maxOdl){
                        radar.maxOdl=tablicaOdl[i];
                    }
                }
                String[][] mapa = new String[radar.sp.length][2];
                for(int i =0;i<mapa.length;i++){
                    mapa[i][0]= String.valueOf(radar.sp[i].toString());
                    mapa[i][1]= String.valueOf(tablicaOdl[i]);
                }

                double wrt =0;
                int pow =-1;
                while (wrt<=radar.maxOdl){
                    pow++;
                    wrt=Math.pow(3,pow);
                }
                int[] tablicaInd = new int[pow];
                radar.spt = new StatekPowietrzny[pow][0];
                for(int i =0;i<radar.sp.length;i++) {
                    int index =-1;
                    double wartosc=0;
                    while (wartosc<=tablicaOdl[i]){
                        index++;
                        wartosc=Math.pow(3,index);
                    }
                    index=index-1;
                    radar.spt[index]=radar.powiekszTablice(radar.spt[index]);
                    radar.spt[index][tablicaInd[index]]=radar.sp[i];
                    tablicaInd[index]++;
                }
                for (int i =0;i<radar.spt.length;i++){
                    radar.spt[i]=radar.sortowanieBombelkowe(radar.spt[i],mapa);
                }
                for (int i =0;i<radar.spt.length;i++){
                    System.out.println("potęga: "+(i+1));
                    for(int j =0;j<radar.spt[i].length;j++){
                        for(int k =0;k<mapa.length;k++){
                            if(radar.spt[i][j].toString().equals(mapa[k][0])){
                                System.out.println(radar.spt[i][j].toString()+"         odl: "+mapa[k][1]);
                                break;
                            }

                        }
                    }
                }
                break;
            default:
                System.out.println("Zły parametr");
                break;
        }
    }

}

class StatekPowietrzny{
    double pulap, predkosc,wektorRuchu;
    int iloscSilnikow;
    int[] pozycja;
    String numerSeryjny, producent;



    public StatekPowietrzny(int[] pozycja, double pulap, double predkosc, double wektorRuchu,int iloscSilnikow, String numerSeryjny,String producent){
        this.pozycja=pozycja;
        this.predkosc=predkosc;
        this.pulap=pulap;
        this.wektorRuchu= wektorRuchu;
        this.iloscSilnikow=iloscSilnikow;
        this.numerSeryjny=numerSeryjny;
        this.producent=producent;


    }
    public String toString(){
        return this.pozycja[0]+","+this.pozycja[1]+","+this.pulap+","+this.predkosc+","+this.wektorRuchu+","+this.iloscSilnikow+","+this.numerSeryjny+","+this.producent;
    }


}
class SamolotPasazerski extends StatekPowietrzny{
    int liczbaMiejsc;
    String przewoznik;

    public SamolotPasazerski(int[] pozycja, double pulap, double predkosc, double wektorRuchu,int iloscSilnikow,String numerSeryjny,String producent, int liczbaMiejsc,String przewoznik) {
        super(pozycja, pulap, predkosc, wektorRuchu,iloscSilnikow,numerSeryjny,producent);
        this.liczbaMiejsc=liczbaMiejsc;
        this.przewoznik=przewoznik;
    }
    public String toString(){
        return "SamolotPasazerski,"+super.toString()+","+this.liczbaMiejsc+","+this.przewoznik;
    }

}
class SamolotTransportowy extends StatekPowietrzny{
    double udzwig;
    String przewoznik;

    public SamolotTransportowy(int[] pozycja, double pulap, double predkosc, double wektorRuchu,int iloscSilnikow,String numerSeryjny, String producent, double udzwig, String przewoznik) {
        super(pozycja, pulap, predkosc, wektorRuchu,iloscSilnikow,numerSeryjny,producent);
        this.udzwig=udzwig;
        this.przewoznik=przewoznik;
    }
    public String toString(){
        return "SamolotTransportowy,"+super.toString()+","+this.udzwig+","+this.przewoznik;
    }
}
class SamolotWojskowy extends StatekPowietrzny{
    int liczbaBomb;
    String frakcja;

    public SamolotWojskowy(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow,String numerSeryjny,String producent, int liczbaBomb, String frakcja) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow,numerSeryjny,producent);
        this.liczbaBomb=liczbaBomb;
        this.frakcja=frakcja;
    }
    public String toString(){
        return "SamolotWojskowy,"+super.toString()+","+this.liczbaBomb+","+this.frakcja;
    }
}
class SamolotSportowy extends StatekPowietrzny{
    String kolorDymu;

    public SamolotSportowy(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow,String numerSeryjny,String producent, String kolorDymu) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow,numerSeryjny,producent);
        this.kolorDymu=kolorDymu;
    }
    public String toString(){
        return "SamolotSportowy,"+super.toString()+","+this.kolorDymu;
    }
}
class SamolotModelarski extends StatekPowietrzny{
    int iloscElementów;
    String skala;

    public SamolotModelarski(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow,String numerSeryjny,String producent, int iloscElementów, String skala) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow,numerSeryjny,producent);
        this.iloscElementów=iloscElementów;
        this.skala=skala;
    }
    public String toString(){
        return "SamolotModelarski,"+super.toString()+","+this.iloscElementów+","+this.skala;
    }
}
class Sterowiec extends StatekPowietrzny{
    double objetoscSzkieletu;
    double udzwig;


    public Sterowiec(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow, String numerSeryjny, String producent, double objetoscSzkieletu, double udzwig) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow, numerSeryjny, producent);
        this.objetoscSzkieletu=objetoscSzkieletu;
        this.udzwig=udzwig;
    }
    public String toString(){
        return "Sterowiec,"+super.toString()+","+this.objetoscSzkieletu+","+this.udzwig;
    }
}

class HotAirBaloon extends StatekPowietrzny{
    double objetoscBalonu;


    public HotAirBaloon(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow, String numerSeryjny, String producent, double objetoscBalonu) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow, numerSeryjny, producent);
        this.objetoscBalonu=objetoscBalonu;
    }
    public String toString(){
        return "HotAirBaloon,"+super.toString()+","+this.objetoscBalonu;
    }
}
class Szybowiec extends StatekPowietrzny{
    double zasiegMax;
    public Szybowiec(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow, String numerSeryjny, String producent,double zasiegMax) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow, numerSeryjny, producent);
        this.zasiegMax=zasiegMax;
    }
    public String toString(){
        return "Szybowiec,"+super.toString()+","+this.zasiegMax;
    }
}
class SamolotRolniczy extends StatekPowietrzny{
    double pojemnoscZbiornikaNawozowego;

    public SamolotRolniczy(int[] pozycja, double pulap, double predkosc, double wektorRuchu, int iloscSilnikow, String numerSeryjny, String producent, double pojemnoscZbiornikaNawozowego) {
        super(pozycja, pulap, predkosc, wektorRuchu, iloscSilnikow, numerSeryjny, producent);
        this.pojemnoscZbiornikaNawozowego=pojemnoscZbiornikaNawozowego;
    }
    public String toString(){
        return "SamolotRolniczy,"+super.toString()+","+this.pojemnoscZbiornikaNawozowego;
    }
}

class Radar{
    double odleglosc(StatekPowietrzny p3d){
        return Math.sqrt(Math.pow(0- p3d.pozycja[0],2)+ Math.pow(0- p3d.pozycja[1],2)+ Math.pow(0-p3d.pulap,2));
    }
    double maxOdl;
    StatekPowietrzny[][] spt;
    StatekPowietrzny[] sp;
    public Radar(){
        this.spt = new StatekPowietrzny[2][];
        this.maxOdl=0;

    }
    void powiekszTablice(){
        int dlugosc = this.sp.length+1;
        StatekPowietrzny[] sptt = new StatekPowietrzny[dlugosc];
        for(int i =0;i<this.sp.length;i++){
            sptt[i]=this.sp[i];
        }
        this.sp=sptt;
    }
    StatekPowietrzny[] powiekszTablice(StatekPowietrzny[] tab){
        int dlugosc = tab.length+1;
        StatekPowietrzny[] sptt = new StatekPowietrzny[dlugosc];
        for(int i =0;i<tab.length;i++){
            sptt[i]=tab[i];
        }
        return sptt;
    }
    public StatekPowietrzny[] sortowanieBombelkowe(StatekPowietrzny[] tablica,String[][] mapa) {
        int idx = tablica.length;
        while (idx>0) {
            for (int i = 0; i < tablica.length - 1; i++) {
                double odleglosc = 0;
                double odleglosc2 = 0;
                for (int j = 0; j < mapa.length; j++) {
                    if (tablica[i].toString().equals(mapa[j][0])) {
                        odleglosc = Double.parseDouble(mapa[j][1]);
                        break;
                    }
                }
                for (int j = 0; j < mapa.length; j++) {
                    if (tablica[i + 1].toString().equals(mapa[j][0])) {
                        odleglosc2 = Double.parseDouble(mapa[j][1]);
                        break;
                    }
                }
                if (odleglosc > odleglosc2) {
                    StatekPowietrzny st = tablica[i];
                    tablica[i] = tablica[i + 1];
                    tablica[i + 1] = st;
                }
            }
            idx--;
        }
        return tablica;
    }


}



