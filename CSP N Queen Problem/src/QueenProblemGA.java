import java.util.Arrays;
import java.util.Random;

public class QueenProblemGA {

	public static int fitness(int queen[][],int n){
        int attackCount = 0;
        int nonAttackCount = 0; 
        int queensDone = 0;
        int var=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(queen[i][j]>0){
                    queensDone++;
                    for(int k=j+1;k<n;k++){
                        if(queen[i][k]>0){
                            attackCount++;
                            System.out.println("attack of queen["+i+"]["+j+"] on => "+queen[i][k]);
                        }
                    }
                    var=1;
                    for(int k=i+1;k<n;k++){
                        
                        int x1 = k;//i=4 j=2 k=5
                        int y1 = j-var;//0
                        int x2 = k;//0
                        int y2 = j+var;//0
                        var++;
                        if(y1>=0){
                            if(queen[x1][y1]>0){
                                System.out.println("attack of queen["+i+"]["+j+"] on => "+queen[x1][y1]);
                                attackCount++;
                            }else{
                                
                            }
                        }
                        if(y2<n){
                            if(queen[x2][y2]>0){
                                attackCount++;
                                System.out.println("attack of queen["+i+"]["+j+"] on => "+queen[x2][y2]);

                            }else{
                                
                            }
                        }
                    }
                }
            }
        }
        
        return attackCount;
    }
    
    
    public static int[] randompopulation(int n,int pop,int loop){
        
        int x;
        int[] population;
        population = new int[4];
        
        Random rand = new Random();
        int i,j;
        j=0;
        
        for (i = 0; i < pop; i++) {
            x=0;
            for (j = 1; j <=loop; j++) {
                int temp;
                temp = rand.nextInt(n);
                temp +=1;
                x = x*10 +temp;
            }
            population[i] = x;
        }
        
        return population;
    }
    
    public static int[][] queenboard(int population[],int a,int n){
        
        int[][] queen = new  int[n][n];
        char[] charpop = new char[100];
        int[] intpop;
        
        
      
        //int a=0;
        //while(a<(pop)){
        
            System.out.print(" "+(a+1)+" Population Queen Board:  ");
            //System.out.println("");
            String str1; 
            str1 = Integer.toString(population[a]);
            intpop = new int[str1.length()];
            charpop = str1.toCharArray(); //storing string into char array
            //System.out.println("String: "+str1);
        
            for (int k = 0; k < str1.length(); k++) {
                intpop[k] = (int)charpop[k]-48; //storing char array to integer
                System.out.print(" "+intpop[k]);
            }
            System.out.println("");
        
            //first queen board
            //if(a==0){

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        int y = intpop[k];
                        queen[y-1][k]=intpop[k];
                    }
                }
                
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        System.out.print("  "+queen[k][l]);
                    }
                    System.out.println("");
                }
                System.out.println("");  
                
            //}
        return (queen);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("8-Queen Problem Using Genetic Algoritm");
        System.out.println("");
        int n=8;//numbers of queens
        int pop=4;//four population
        int max=n;//range 1-n
        int loop=n;//string of n
        int[] population;
        population = randompopulation(n,pop,loop);
        
        
        //we got all randomly generated population
        for (int k = 0; k < pop; k++) {
            System.out.println(" "+(k+1)+" Population: "+population[k]);
        }
        
        System.out.println("");
        //System.out.println(population[0]);
        
        //int[][] queen1 = new  int[8][8];
        //int[][] queen2 = new  int[8][8];    
        //int[][] queen3 = new  int[8][8];
        //int[][] queen4 = new  int[8][8];
        
        /*************fitness values array*************/
        int[] fit = new int[4];
        int var=0;
        
        //1st Queen
        int queennum=0;
        int[][] queen1 = queenboard(population,queennum++,n);
        int f1=fitness(queen1,n);
        fit[var]=f1;
        var++;
        
        System.out.println("AttackingCount: "+f1);
        System.out.println("");  
        System.out.println("");  
        //2nd Queen
        int[][] queen2 = queenboard(population,queennum++,n);
        int f2=fitness(queen2,n);
        fit[var]=f2;
        var++;
        
        System.out.println("AttackingCount: "+f2);
        System.out.println("");  
        System.out.println("");  
        //3rd Queen
        int[][] queen3 = queenboard(population,queennum++,n);
        int f3=fitness(queen3,n);
        fit[var]=f3;
        var++;
        
        System.out.println("AttackingCount: "+f3);
        System.out.println("");   
        System.out.println("");   
        //4th Queen
        int[][] queen4 = queenboard(population,queennum++,n);
        int f4=fitness(queen4,n);
        fit[var]=f4;

        
        /***********Asim's Code Start************/
        //few declarations of my code is in above part
        
        int indx =0;
        int indx2=0;
        int indx3 =0;
        int indx4=0;
        int minimum  = 100000;
        int minimum2 = 100000;
        int minimum3 = 100000;
        int minimum4 = 100000;
        float total = 0;
        int[] percentage = new int[4];
        
        
        for(int x=0;x<4;x++){
        	total+=fit[x];
        }
        for(int y=0;y<4;y++){
        	percentage[y] = (int) ((float)(fit[y]/total)*100);
        	if(percentage[y]<minimum){
        		minimum = percentage[y];
        		indx = y;
        	}
        }

        for(int z=0;z<4;z++){
        	if(percentage[z]<minimum2 && (z!=indx)){
        		minimum2 = percentage[z];
        		indx2 = z;
        	}
        }
        for(int y2=0;y2<4;y2++){
        	if(percentage[y2]<minimum3 && (y2!=indx) && (y2!=indx2)){
        		minimum3 = percentage[y2];
        		indx3 = y2;
        	}
        }
        for(int y2=0;y2<4;y2++){
        	if(percentage[y2]<minimum4 && (y2!=indx) && (y2!=indx2) 
        			&& (y2!=indx3)){
        		minimum4 = percentage[y2];
        		indx4 = y2;
        	}
        }
        
        System.out.println("\n\n============Asim's printing start===========");
        System.out.println("fit is an array which has all the percentage values that were calculated from (fitness/total)*100");
        System.out.println("\n1st Minimum value is "+minimum+" on fit["+indx+"]");
        System.out.println("2nd Minimum value is "+minimum2+" on fit["+indx2+"]");
        System.out.println("3rd Minimum value is "+minimum3+" on fit["+indx3+"]");
        System.out.println("4th Minimum value is "+minimum4+" on fit["+indx4+"]");
        System.out.println("Total is => "+total);
        System.out.println("============Asim's printing end===========\n\n");

        /**************Asim's Code Ends****************/
        
        
        System.out.println("AttackingCount: "+f4);
        System.out.println(""); 
        System.out.println(""); 
                
                
      
        
        System.out.println("");
        System.out.println("");
        int[] fitarray = new int[4];
        
        //total fitness
        float f=f1+f2+f3+f4;
        System.out.println("F = "+f1+" + "+f2+" + "+f3+" + "+f4+" = "+(int)f);
        //first fitness probability
        System.out.print("F1: "+f1+" / "+(int)f+" = "+(f1/f));
        f1=Math.round((f1/f)*100);
        System.out.println(" = "+f1+"%");
        fitarray[0]=f1;
        //Second fitness probability
        System.out.print("F2: "+f2+" / "+(int)f+" = "+(f2/f));
        f2=Math.round((f2/f)*100);
        System.out.println(" = "+f2+"%");
        fitarray[1]=f2;
        //Third fitness probability
        System.out.print("F3: "+f3+" / "+(int)f+" = "+(f3/f));
        f3=Math.round((f3/f)*100);
        System.out.println(" = "+f3+"%");
        fitarray[2]=f3;
        //Fourth fitness probability
        System.out.print("F4: "+f4+" / "+(int)f+" = "+(f4/f));
        f4=Math.round((f4/f)*100);
        System.out.println(" = "+f4+"%");
        fitarray[3]=f4;
        
        
        System.out.println("");
        
        for (int i = 0; i < fitarray.length; i++) {
            System.out.print(" "+fitarray[i]);
        }
        
        System.out.println("");
        
        int[] arrindex = new int[4];
        //int[] min = new int[4];
        int min = fitarray[0];
        for (int i = 1; i < fitarray.length; i++) {
            // if(fitarray[i]<min){
                //min=fitarray[i];
                arrindex[i]=i;
            
        }
        
        for (int i = 0; i < 4; i++) {
            System.out.print(" "+arrindex[i]);
        }
        
        
        //Crossover;
        
        
        
        
        int[] array1 = new int[]{2,4,7,4,8,5,5,2};
        
        int[] array2 = new int[]{3,2,7,5,2,4,1,1};
       
        int[] array3 = new int[]{2,4,4,1,5,1,2,4};
   
        int[] array4 = new int[]{3,2,5,4,3,2,1,3};
        
        int[] temparr1 = new int[8];
        int[] temparr2 = new int[8];
        
        
        temparr1 = Arrays.copyOfRange(array1, 0, 3);
        temparr2 = Arrays.copyOfRange(array2, 0, 3);
        
        System.out.println("");
        System.out.println("Before");
        System.out.println("Array1: "+Arrays.toString(array1));
        System.out.println("Array2: "+Arrays.toString(array2));
        //System.out.println("temp1: "+Arrays.toString(temparr1));
        //System.out.println("temp2: "+Arrays.toString(temparr2));
        
        System.arraycopy(temparr2, 0, array1, 0, 3);
        System.arraycopy(temparr1, 0, array2, 0, 3);
        
        //array2 = Arrays.copyOfRange(temparr2, 0, 5);
        System.out.println("");
        System.out.println("After");
        System.out.println("Array1: "+Arrays.toString(array1));
        System.out.println("Array2: "+Arrays.toString(array2));
        
        
           
    }
}
