
import java.util.Scanner;

public class toDoApp {
    
    static int gorev_ekle(String gorev, String [] liste, int sayi){
                if (sayi < liste.length){ 
                    
                    liste[sayi] = gorev;
                    sayi++;
                }
                
                else {
                   System.out.println("Sınıra ulaştınız!!");    
                }  
                
        return sayi;
    }
    
    static void gorev_goster(int sayi, String [] liste){
        System.out.println("*** Görevleri Göster ***");
                
                for (int i = 0; i < sayi; i++){
                    System.out.println((i+1) + ". " +  liste[i]);
                }
    }
    
    static int gorev_kaldir(int sayi, String [] liste, int sayi2, Scanner scanner){
        System.out.println("*** Görev Kaldır ***");
                
                for (int i = 0; i < sayi; i++){
                    System.out.println((i+1) + ". " +  liste[i]);
                }
                
                if (sayi == 0){ 
                    System.out.println("Geçerli görev olmadığından silme işlemi yapılamamaktadır.");  
                }
                
                else {
                    System.out.print("hangi görev? (sayı girişi yapınız): ");
                    sayi2 = scanner.nextInt();
                    
                    if (sayi2 < 1 || sayi2 > sayi){
                    System.out.println("Lütfen geçerli bir sayı giriniz.");
                }
                    else {
                        for (int i = sayi2 - 1; i < sayi-1; i++){
                            liste[i] = liste [i+1];
                        }

                        System.out.println("Silme işlemi tamamlandı.");

                
                        sayi--;
                        liste[sayi] = null;
                    }
                } 
         return sayi;
    }
    
    static void gorev_ara(int sayi, String [] liste, String gorev){
                
                int sayac = 0;
                
                for(int i = 0; i < sayi; i++){

                    if (liste[i].contains(gorev)){
                        System.out.println("arattığınız görev bulundu: " + (i+1) + ". " + liste[i]);
                        sayac = 1;
                    }
                }     
                
                if (sayac == 0){
                    System.out.println("Aradığınız kelime ile alakalı bir görev bulunamadı.");
                }
    }
    
    
    public static void main(String[] args) {
        
        int sayi = 0;
        int sayi2 = 0;
        
        String [] liste = new String[10];
        String gorev;
        
        Scanner scanner = new Scanner(System.in);
        
        int secim;
        
        while (true){
            System.out.println("\nMerhabalar, lütfen bir işlem seçiniz..");
            System.out.println("1 - Görev Ekle\n2 - Görevleri Göster\n3 - Görev Kaldır\n4 - Görev Ara\n5 - Çıkış");
            
            System.out.print("\nSeçenek: ");
            secim = scanner.nextInt();
            scanner.nextLine(); //dummy Input
            
            if (secim == 1){
                System.out.println("*** Görev Ekle ***");
                System.out.print("Lütfen eklemek istediğiniz görevi buraya yazınız (teker teker en fazla 10 adet olmalıdır): ");
                gorev = scanner.nextLine(); 
                
               sayi = gorev_ekle(gorev, liste, sayi);
            }
                       
            else if (secim == 2){
                gorev_goster(sayi,liste);
            }
            
            else if (secim == 3){
                sayi = gorev_kaldir(sayi, liste, sayi2, scanner);
            }
            
            else if (secim == 4){
                        System.out.println("*** Görev Ara ***");
                
                System.out.print("Lütfen görevler içerisinde aratmak istediğiniz kelimeyi giriniz: ");
                gorev = scanner.nextLine();
                
                gorev_ara(sayi, liste, gorev);
            }
            
            else if (secim == 5){
                System.out.println("Sistemden çıkış yapılıyor. İyi günler dileriz.");
                break;
            }
            
        }
            
    }
}
