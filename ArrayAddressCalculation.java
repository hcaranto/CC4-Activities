import java.util.Scanner;

public class ArrayAddressCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter STARTING ADDRESS: ");
        long alpha = sc.nextInt();
        
        System.out.print("Enter ESIZE: ");
        long esize = sc.nextInt();
        
        System.out.println("");
                
        System.out.print("Enter NO. OF DIMENSIONS: ");
        int n = sc.nextInt();
        
        System.out.println("");
        
        int upperbounds[] = new int[n];
        
        for (int i = 0; i < n; i++){
            System.out.print("Enter size for DIMENSION " + (i+1) + ": ");
            upperbounds[i] = sc.nextInt();
        }

        System.out.println("");
        
        int address[] = new int[n];
        
        for (int i = 0; i < n; i++){
            System.out.print("Enter VARIABLE ADDRESS for dimension " + (i+1) + ": ");
            address[i] = sc.nextInt();
            if (address[i] > upperbounds[i]){
                System.out.println("Invalid input! Not within upperbounds of dimension! Try again.");
                break;
            }
        }
        
        System.out.println("\nTOTAL NUMBER OF ELEMENTS: " + calculateElements(upperbounds));
        System.out.println("ADDRESS OF X: " + calculateAddress(address, upperbounds, alpha, esize));
       
    }
    public static long calculateAddress(int a[], int b[], long alpha, long esize){
        long address, temp, sum = 0;
        
        for (int i = 0; i < a.length; i++){
            temp = a[i];
            for (int k = (i+1); k < a.length; k++){
                temp = temp*b[k];
            }
            sum += temp;
        }
        
        address = alpha + (sum*esize);
        
        return address;
    }
    public static long calculateElements (int[]a){
        long totalElements = 1, temp;
        
        for (int i = 0; i < a.length; i++){
            temp = a[i];
            totalElements *= temp;
        }
        
        return totalElements;
    }
}