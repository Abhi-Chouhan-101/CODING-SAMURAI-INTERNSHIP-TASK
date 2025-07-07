import java.util.Scanner;
public class Simple_Calculator{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("====== Calculator ======");
        String repeat;
        double n1=0, n2=0;
        do {
            double result = 0.0;
             System.out.println(" Press : 1 for ADDITION \n Press : 2 For SUBTRACTION \n Press : 3 For Multiplication \n Press : 4 For Division");
             System.out.print("Enter Your choice : ");
             int ch = sc.nextInt();
             
             if(ch>0&&ch<5){
             System.out.print("Enter the First No : ");
              n1  =  sc.nextDouble(); 
             System.out.print("Enter the Second No : ");
              n2  =  sc.nextDouble(); 
             }
            switch (ch) {
                case 1:{
                       result = (n1+n2);
                       break;
                       }
                 case 2:{
                       result = (n1-n2);
                       break;
                       }
                 case 3:{
                       result = (n1*n2);
                       break;
                        }
                 case 4:{
                       result = (n1/n2);
                       break;
                       }
            
                default:
                    System.out.println("invalid credential!");;
            }
            System.out.println("Resuls is : "+result);
            System.out.print("Do you want to perform another calculation? (y/n): ");
            repeat = sc.next();
        } while (repeat.equals("y"));
        {
            System.out.println("==== calculator closed..==== ");
            sc.close();
        }


  
    }
}