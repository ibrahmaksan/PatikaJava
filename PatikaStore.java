package Patika;


// Birka� farkl� dosya a�arak olu�turulabilecek bir projeydi fakat tek dosya a�arakta projenin yap�labilece�ini g�stermek istedim.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Markalar implements Comparable<Markalar>{
	
	String name;
	private int ID;
	
	public Markalar(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}
	
	String getName() {
		return name;
	}
	
	int getID() {
		return ID;
	}


	@Override
	public int compareTo(Markalar o) { // Markalar� alfabetik olarak s�ralamak i�in yeniden yazd�m compareTO'yu. Tabi veri yap�lar� da kullan�labilirdi.
		if(this.name.compareTo(o.name) > 0) {	
			return 1;
		}
		else if(this.name.compareTo(o.name) < 0){
			
			return -1;
		}
		return 0;
	}

}

class Products{
	
	static Scanner scanner = new Scanner(System.in);
	String name;
	long ID;
	int price;
	double discount;
	static int stock;
	Markalar marka;
	int storage;
	String screen;
	String battery;
	int RAM;
	String color;

	public Products(String name, long ID, int price, double discount, Markalar marka, int storage, String screen, String battery, int RAM, String color){
		
		this.name = name;
		this.battery = battery;
		this.ID = ID;
		this.color = color;
		this.discount = discount;
		this.marka = marka;
		this.price = price;
		this.RAM = RAM;
		this.screen = screen;
		this.storage = storage;
	}
	
	public Products(String name, long ID, int price, double discount, Markalar marka, int storage, String screen, int RAM){
		
		this(name,ID,price,discount,marka,storage,screen,"Bilgi Yok",RAM,"Bilgi Yok");
	}
	
}

class Telefon extends Products{
	
	@Override
	public String toString() {
		return ID + " - " + "  " + marka.name + "  " + name +"  "+ storage +"  "+ RAM + "  " + screen + " "+ color;
	}

	public Telefon(String name, long ID, int price, double discount, Markalar marka, int storage,
			String screen, String battery, int RAM, String color) {
		super(name, ID, price, discount, marka, storage, screen, battery, RAM, color);
		stock++;
	} 
}

class Bilgisayar extends Products{

	public Bilgisayar(String name, long ID, int price, double discount, Markalar marka, int storage,
			String screen, int RAM) {
		super(name, ID, price, discount, marka, storage, screen, RAM);
		stock++;
	}
	
	@Override
	public String toString() {
		return "Marka ve Modeli : " + marka.name + " " + name +" Depolama Alan� : " + storage  +" Ram Miktra� : " + RAM + " Ekran: " + screen;
	}
	
	
}



public class PatikaStore {
	
	static Scanner scanner = new Scanner(System.in);
	
	
	static Markalar marka1 = new Markalar("Samsung",1);
	static Markalar marka2 = new Markalar("Lenovo",2);
	static Markalar marka3 = new Markalar("Apple",3);
	static Markalar marka4 = new Markalar("Huawei",4);
	static Markalar marka5 = new Markalar("Casper",5);
	static Markalar marka6 = new Markalar("Asus",6);
	static Markalar marka7 = new Markalar("HP",7);
	static Markalar marka8 = new Markalar("Xiaomi",8);
	
	static Markalar[] liste = {marka1,marka2,marka3,marka4,marka5,marka6,marka7,marka8};
	static ArrayList<Telefon> telefonlar = new ArrayList<Telefon>();
	static ArrayList<Bilgisayar> bilgisayarlar = new ArrayList<Bilgisayar>(); 
	
	public static void main(String[] args) {
		
		System.out.println("Ma�azam�za ho�geldiniz :");

		mainMenu();
		
		while(true) {
			
		System.out.println("Yapmak istedi�iniz i�lem : ");
		int islem = scanner.nextInt();scanner.nextLine();
		
		options(islem);
		}
	}
	
	static void listMobiles() {
		
		System.out.println("ID |" + " Marka ve Model |" + " Depolama Alan� |" + " RAM |" + " Ekran |" + " Renk |");
		
		for(int i = 0;i<telefonlar.size();i++) {
			
			System.out.println(telefonlar.get(i).toString());
		}
		
	}
	
	static void listPCs() {
		
		for(int i = 0;i<bilgisayarlar.size();i++) {
			
			System.out.println(bilgisayarlar.get(i).toString());
		}
		
	}
	
	public static void Listele() {
		
		Arrays.sort(liste);
		
		System.out.println("�u an ma�azam�zda bulunan markalar : ");
		
		for(int i = 0; i<liste.length; i++) {
			
			System.out.println((i+1) + " - " + liste[i].name);
		}	
	}
	
	public static void addPhone() {
		
		System.out.println("Telefon ekleme sayfas�na ho�geldiniz.");
		Listele(); // Listele fonksiyonu ile markalar alfabetik olarak s�raland�.
		
		System.out.println("Telefonun markas�n�n numaras�n� se�iniz : ");
		int marka = scanner.nextInt();scanner.nextLine();
		
		System.out.println("Telefon ad� : ");
		String name = scanner.nextLine();
		System.out.println("RAM : ");
		int ram = scanner.nextInt();scanner.nextLine();
		
		System.out.println("Depolama Alan� : ");
		int depo = scanner.nextInt();scanner.nextLine();
		
		System.out.println("Batarya : ");
		String batarya = scanner.nextLine();
		
		System.out.println("Ekran boyutu : ");
		String ekran = scanner.nextLine();
		
		System.out.println("Renk: ");
		String renk = scanner.nextLine();
		
		System.out.println("�r�n fiyat� : ");
		int fiyat = scanner.nextInt();scanner.nextLine();
		
		System.out.println("�ndirim : ");
		Double indirim = scanner.nextDouble();scanner.nextLine();
		
		System.out.println("�r�n ID'si: ");
		long ID = scanner.nextLong();
		
		Telefon telefon = new Telefon(name,ID,fiyat,indirim,liste[marka-1],depo,ekran,batarya,ram,renk);
		telefonlar.add(telefon);
		}
	
	public static void addNotebook() {
		
		System.out.println("Bilgisayar ekleme sayfas�na ho�geldiniz.");
		Listele();
		System.out.println("Eklemek istedi�imiz marka : ");
		int marka = scanner.nextInt();scanner.nextLine();
		
		System.out.println("PC ad� : ");
		String name = scanner.nextLine();
		System.out.println("RAM : ");
		int ram = scanner.nextInt();scanner.nextLine();
		
		System.out.println("Depolama Alan� : ");
		int depo = scanner.nextInt();scanner.nextLine();
		
		System.out.println("Ekran boyutu : ");
		String ekran = scanner.nextLine();
		
		System.out.println("�r�n fiyat� : ");
		int fiyat = scanner.nextInt();scanner.nextLine();
		
		System.out.println("�ndirim : ");
		Double indirim = scanner.nextDouble();scanner.nextLine();
		
		System.out.println("�r�n ID'si: ");
		long ID = scanner.nextLong();
		
		Bilgisayar bilgisayar = new Bilgisayar(name,ID,fiyat,indirim,liste[marka-1],depo,ekran,ram);
		bilgisayarlar.add(bilgisayar);
		}
	
	
	static void deletePhone() {
		
		System.out.println("Hangi indeksteki telfonu sileceksiniz : ");
		telefonlar.remove(scanner.nextInt());
		System.out.println("�r�n listeden kald�r�ld�\n");
	}
	
	static void deleteNotebook() {
		
		System.out.println("Hangi indeksteki notebooku sileceksiniz : ");
		telefonlar.remove(scanner.nextInt());
		System.out.println("�r�n listeden kald�r�ld�\n");
	}
	
	static void mainMenu() {
		
		System.out.println("1- Telefonlar");
		System.out.println("2- Bilgisayarlar");
		System.out.println("3- Telefon ekle");
		System.out.println("4- B�lgisayar Ekle");
		System.out.println("5- Telefon sil");
		System.out.println("6- Bilgisayar sil");
		System.out.println("7- Sistemden ��k");
	}
	
	static void options(int pr) {
		
		if(pr == 1) {
			
			listMobiles();
		}
		
		else if(pr == 2) {
			
			listPCs();
		}
		
		else if(pr == 3) {
			addPhone();
		}
		else if(pr == 4) {
			addNotebook();
		}
		
		else if(pr == 5) {
			
			deletePhone();
		}
		else if(pr == 6) {
			deleteNotebook();
		}
		else if(pr == 7) {
			System.out.println("Sistemden ��k�ld�.");
			System.exit(1);
		}
		
		else {
			System.out.println("Se�enekler haricinde bir tu�lama yapt�n�z. Programdan ��k�l�yor.");
			System.exit(1);
		}
	}
}
