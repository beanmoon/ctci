package chapter07;

/**
 * Created by bean on 9/24/15.
 */
public class PrimeNumGenerator {
    public void generate(int max){
        boolean[] flags = new boolean[max + 1];
        init(flags);

        int prime = 2;
        while(prime < max){
            crossoff(flags, prime);
            prime = getNextPrime(flags, prime);
        }

        for(int i = 2; i <= max; i++)
            if(flags[i])
                System.out.print(i + " ");
        System.out.println();
    }

    public int getNextPrime(boolean[] flags, int prime){
        int next = prime + 1;
        while(next < flags.length && !flags[next]){
            next++;
        }
        return next;
    }

    public void crossoff(boolean[] flags, int prime){
        for(int i = prime * prime; i < flags.length; i += prime){
            flags[i] = false;
        }
    }

    public void init(boolean[] flags){
        flags[0] = false;
        flags[1] = false;
        for(int i = 2; i < flags.length; i++){
            flags[i] = true;
        }
    }

    public static void main(String[] args) {
        PrimeNumGenerator png = new PrimeNumGenerator();
        png.generate(4);
    }
}
