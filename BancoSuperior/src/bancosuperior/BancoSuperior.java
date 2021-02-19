/*
    Projéto didático POO
 */
package bancosuperior;

/**
 *
 * @author jessica
 */
public class BancoSuperior {


    public static void main(String[] args) {
       
        Conta conta1 = new Conta("Jéssica", "702.653", "6132", "1597", 'c');
        Conta conta2 = new Conta("Monalisa", "121.653", "6222", "3434", 'p');
        
        conta1.depositar(100);
        conta1.transferir(conta2, 50);
        
        System.out.println(conta1.toString());
        System.out.println(conta2.toString());
        
    }
    
}
