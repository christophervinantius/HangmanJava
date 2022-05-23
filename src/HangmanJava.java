import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class HangmanJava {
	Scanner scan = new Scanner(System.in);
	ArrayList<String> daftarKata = new ArrayList<>();
	Random rand = new Random();
		
	public void addData() {
		System.out.println(" ");
		String kata;
		int valid;
			
		do {
			valid = 1;
			System.out.print("Masukkan kata (5 - 50 karakter): ");
			kata = scan.nextLine();
			for(String d:daftarKata) {
				if(d.equals(kata)) {
					valid = 0;
				}
			}
		}while(kata.length() < 5 || kata.length() > 50 || valid == 0);
			
		if(valid == 1) {
			daftarKata.add(kata);
			System.out.println("Kata berhasil ditambahkan");
			System.out.println("Tekan apa saja untuk melanjutkan...");
			scan.nextLine();
			mainMenu();
		}
		
	}
		
	public void lookData() {
		System.out.println(" ");
		if(daftarKata.size() == 0) {
			System.out.println("Tidak ada data, silakan tambahkan kata terlebih dahulu");
			System.out.println("Tekan apa saja untuk melanjutkan...");
			scan.nextLine();
			mainMenu();
		}else {
			System.out.println("Daftar kata:");
			int urutan = 1;
			
			Collections.sort(daftarKata);
				
			for(String d:daftarKata) {
				System.out.println(urutan + ". " + d);
				urutan++;
			}
				
			System.out.println("Tekan apa saja untuk melanjutkan...");
			scan.nextLine();
			mainMenu();
		}			
	}
		
	public void game() {
		System.out.println(" ");
		if(daftarKata.size() == 0) {
			System.out.println("Tidak ada data, silakan tambahkan kata terlebih dahulu");
			System.out.println("Tekan apa saja untuk melanjutkan...");
			scan.nextLine();
			mainMenu();
		}else {
			ArrayList<String> daftarTebakan = new ArrayList<>();
				
			int valid = 0, tertebak = 0, adaBenar, tebakanValid;
			int jumlahKata = daftarKata.size();
			int pilihan = rand.nextInt(jumlahKata);
			String kataPilihan = daftarKata.get(pilihan);
				
			String kataTebakan = "";
			for(int i=0; i<kataPilihan.length(); i++) {
				kataTebakan += '-';
			}
				
			char[] arrayKataTebakan = kataTebakan.toCharArray();
			String huruf;
				
			do {
				adaBenar = 0;
				tebakanValid = 1;
				for(int i=0; i<kataTebakan.length(); i++) {
					System.out.print(arrayKataTebakan[i]);
				}
					
				System.out.println(" ");
				System.out.print("Tekan huruf: ");
				huruf = scan.nextLine();
					
				for(String c:daftarTebakan) {
					if(huruf.equals(c)) {
						adaBenar = 1;
						tebakanValid = 0;
					}
				}
					
				for(int i=0; i<kataPilihan.length(); i++) {
					if(huruf.charAt(0) == kataPilihan.charAt(i)) {
						if(tebakanValid == 1) {
							arrayKataTebakan[i] = huruf.charAt(0);
							tertebak++;
							adaBenar = 1;
							daftarTebakan.add(huruf);
						}
					}
				}
					
				if(adaBenar == 0) {
					System.out.println("Huruf '" + huruf + "' tidak ada di kata tersebut!");
				}	
					
				if(tebakanValid == 0) {
					System.out.println("Huruf '" + huruf + "' sudah pernah ditebak sebelumnya!");
				}
				
				if(tertebak == kataPilihan.length()) {
					System.out.println(" ");
					for(int i=0; i<kataTebakan.length(); i++) {
						System.out.print(arrayKataTebakan[i]);
					}
					valid = 1;
				}
				
				System.out.println(" ");
			}while(valid == 0);
			
			System.out.println("Selamat!");
			scan.nextLine();
			mainMenu();
		}
	}
		
	public void mainMenu() {
		System.out.println(" ");
		int pilihan;
			
		System.out.println("Menu:");
		System.out.println("1. Add data");
		System.out.println("2. Look data");
		System.out.println("3. Game");
		System.out.println("4. Exit");
		System.out.print("Pilih menu: ");
			
		do {
			pilihan = scan.nextInt();
			scan.nextLine();
		}while(pilihan < 1 || pilihan > 4);
			
		switch(pilihan) {
			case 1:
				addData();
				break;
			case 2:
				lookData();
				break;
			case 3:
				game();
				break;
			case 4: 
				System.out.println(" ");
				System.out.println("Terima kasih");
				return;
		}
	}
		
	public HangmanJava() {
		mainMenu();
	}

	public static void main(String[] args) {
		new HangmanJava();	
	}

}
