import java.util.Scanner;
import java.lang.Math;

public class CA_Project_Copy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int userChoice = 0;
        int vert = 0;
        
        do{
            System.out.println("1) Vectors     2) 2D calculations       3) 3D Volume     4) Exit");
            
            userChoice = in.nextInt();
            
            switch(userChoice){
                case 1: 
                        System.out.println("1) Dot Product      2) Cross Product");
                        int userInt = in.nextInt();
                        
                        switch(userInt){
                            case 1: vert = 2;
                                    dotProduct(vert);
                                break;
                            case 2: vert = 2;
                                    crossProduct(vert);
                                break;
                            default: System.out.println("Enter another integer");
                                break;
                        }
                    break;
                case 2: 
                        System.out.println("1) Area   2) Perimeter");
                        userInt = in.nextInt();
                        
                        switch(userInt){
                            case 1: 
                                System.out.println("How many vertices would you like to enter?");
                                vert = in.nextInt();
                                area(vert);
                                break;
                            case 2: 
                                System.out.println("How many vertices would you like to enter?");
                                vert = in.nextInt();
                                perimeter(vert);
                                break;
                            case 3:
                                break;
                        }
                    break;
                case 3:
                       System.out.println("You may only enter three edges for volume");
                       System.out.println();
                       
                       vert = 3;         
                       volume(vert);                         
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default: 
                    System.out.println("Enter another integer");
                    break;
            }
        }while(userChoice != 4);
    }
    
    public static void dotProduct(int vert){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter " + vert + " x-value then y-value then z-value with spaces in between if you would like a 2D vector leave z = 0");
        
        String vertString = in.nextLine();
        
        String [] vertSarr = new String[vertString.length()];
        
        vertSarr = vertString.split(" ");
        
        int[] vertArr = new int[vertSarr.length]; 
        
        for(int i = 0; i < vertSarr.length; i++){
            
            vertArr[i] = Integer.parseInt(vertSarr[i]);  
        }
        
        int firx = vertArr[0];
        int firy = vertArr[1];
        int firz = vertArr[2];
        int secx = vertArr[3];
        int secy = vertArr[4];
        int secz = vertArr[5];
        
        int dotProd = 0;
        
        dotProd = firx*secx + firy*secy + firz*secz;
        
        System.out.println("Dot Product is " + dotProd);
        System.out.println();
    }
    
    public static void crossProduct(int vert){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter " + vert + " x-value then y-value then z-value with spaces in between if you would like a 2D vector leave z = 0");
        
        String vertString = in.nextLine();
        
        String [] vertSarr = new String[vertString.length()];
        
        vertSarr = vertString.split(" ");
        
        int[] vertArr = new int[vertSarr.length]; 
        
        for(int i = 0; i < vertSarr.length; i++){
            
            vertArr[i] = Integer.parseInt(vertSarr[i]);  
        }
        
        int firx = vertArr[0];
        int firy = vertArr[1];
        int firz = vertArr[2];
        int secx = vertArr[3];
        int secy = vertArr[4];
        int secz = vertArr[5];
        
        int x = firy*secz - firz*secy;
        int y = firz*secx - secz*firx;
        int z = firx*secy - secx*firy;
        
        System.out.println("Cross Product is ( " + x + ", " + y + ", " +  z + ")");
        System.out.println();
    }
    
    public static void area (int vert){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter " + vert + " vertices in clockwise or counter clockwise order, x-value first then y-value with spaces in between");
        
        String vertString = in.nextLine();
        
        String [] vertSarr = new String[vertString.length()];
        
        vertSarr = vertString.split(" ");
        
        int[] vertArr = new int[vertSarr.length]; 
        
        for(int i = 0; i < vertSarr.length; i++){
            
            vertArr[i] = Integer.parseInt(vertSarr[i]);  
        } 
        
        int firX, firY, secX, secY, set, next, det;
        int [] detArr= new int[vert];
        
        for(int i = 0; i < 2*vert - 2; i++){
            
            if(i%2 == 0){
                firX = vertArr[i];
                firY = vertArr[i+3];
                set = firX*firY;
            
                secX = vertArr[i+1];
                secY = vertArr[i+2];
           
                next = secX*secY;
            
                det = set - next;
                
                detArr[i/2] = det;
                
                System.out.println("i " + i);
            }
        }
        
        int element = vert*2;
        
        firX = vertArr[element - 2];
        firY = vertArr[1];
        set = firX*firY;
        secX = vertArr[0];
        secY = vertArr[element - 1];
        next = secX*secY;
        det = set - next;
        
        detArr[vert - 1] = det;
        
        System.out.println();
        System.out.println("These are the determinates");
        
        int sum = 0;
        double area = 0;
        
        for(int i = 0; i < detArr.length; i++){
            System.out.print(detArr[i] + " ");
            sum += detArr[i];
        }
        
        System.out.println();
        
        area = .5*sum;

        if(area < 0)
            area = area*-1;
        
        System.out.println("The area using only vertices is " + area);
        System.out.println();
    }
     
    public static void perimeter (int vert){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter " + vert + " vertices in clockwise or counter clockwise order, x-value first then y-value with spaces in between");
        
        String vertString = in.nextLine();
        
        String [] vertSarr = new String[vertString.length()];
        
        vertSarr = vertString.split(" ");
        
        int[] vertArr = new int[vertSarr.length]; 
        
        for(int i = 0; i < vertSarr.length; i++){
            
            vertArr[i] = Integer.parseInt(vertSarr[i]);  
        }
        
        double [] length = new double [vert];
        
        for(int i = 0; i < 2*vert -2; i++){
            if(i%2 == 0){
                double len = Math.sqrt((vertArr[i] - vertArr[i+2]) * (vertArr[i] - vertArr[i+2]) + (vertArr[i+1] - vertArr[i+3])*(vertArr[i+1] - vertArr[i+3]));
                
                length[i/2] = len;
            }
        }
        
        double len = Math.sqrt((vertArr[0] - vertArr[2*vert-2]) * (vertArr[0] - vertArr[2*vert-2]) + (vertArr[1] - vertArr[2*vert-1])*(vertArr[1] - vertArr[2*vert-1]));
        length[vert-1] = len;
        
        int sum = 0;
        
        for(int i = 0; i < vert; i++){
            
           sum += length[i];  
        }
        
        System.out.println();
        System.out.println("The perimeter of this shape is " + sum);
        System.out.println();
    }
    
    public static void volume(int vert){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter " + vert + " vertices x-value then y-value then z-value with spaces in between");
        
        String vertString = in.nextLine();
        
        String [] vertSarr = new String[vertString.length()];
        
        vertSarr = vertString.split(" ");
        
        int[] vertArr = new int[vertSarr.length]; 
        
        for(int i = 0; i < vertSarr.length; i++){
            
            vertArr[i] = Integer.parseInt(vertSarr[i]);  
        }
        
        int x = vertArr[0];
        int y = vertArr[1];
        int z = vertArr[2];
                
        int minor1 = x*((vertArr[4]*vertArr[8]) - (vertArr[7]*vertArr[5]));
        int minor2 = -1*y*((vertArr[3]*vertArr[8])-(vertArr[6]*vertArr[5]));        
        int minor3 = z*((vertArr[3]*vertArr[7])-(vertArr[4]*vertArr[6]));
        
        int sum = minor1 + minor2 + minor3;
        
        if(sum < 0)
            sum *= -1;
        
        System.out.println();
        System.out.println("The volume is " + sum);
        System.out.println();
    }
}
    
