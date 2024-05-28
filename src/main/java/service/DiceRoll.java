package service;

import java.util.Random;

public class DiceRoll {
    public static int rollDies(int d,String ms){
        Random rand = new Random();
        int diesValue = rand.nextInt(6);
        if(d==1){
            if(diesValue==0){
                return diesValue+1;
            }
            else{
                return diesValue;
            }
        }
        int[] rollingDies = new int[d];

        for(int i=0;i<d;i++){
            int random = rand.nextInt(6);
            rollingDies[i] = random;
        }

        switch(ms){
            case("SUM"):
                int sum =0;
                for(int j=0;j<d;j++){
                    sum = sum + rollingDies[j];
                }
                return sum;

            case("MAX"):
                int max = Integer.MIN_VALUE;
                for(int j=0;j<d;j++) {
                    max = Math.max(max,rollingDies[j] );
                }
                return max;
            case("MIN"):
                int min = Integer.MAX_VALUE;
                for(int j=0;j<d;j++) {
                    min = Math.max(min,rollingDies[j] );
                }
                return min;
            default:
                return -1;
        }

    }
}
