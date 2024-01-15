public class TowerOfHanoi
{
    public static void TOH(int n, String S, String H, String D){
        if(n == 1){
            System.out.println("the disc " + n +" transfer from " + S + " to " + D);
            return;
        }
        else{
            TOH(n-1, S, D, H);
            System.out.println("the disc " + n +" transfer from " + S + " to " + D);
            TOH(n-1, H, S, D);
        }
    }
    
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        TOH(n, "S", "H", "D");
        
    }
}

// s = source, h = helper, d = destination
