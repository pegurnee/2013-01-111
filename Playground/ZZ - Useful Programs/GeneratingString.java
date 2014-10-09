import java.util.Random;
import java.util.NoSuchElementException;
/**
 * Write a description of class GeneratingString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GeneratingString
{
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        generate("ided");
//         generate("over");
//         generate("flow");
//         generate("rulez");
    
        System.out.println("Took " + (System.currentTimeMillis() - time) + " ms");
    }
    
    private static void generate(String goal) {
        int[] seed = generateSeed(goal, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(seed[0]);
        System.out.println(randomString(seed[0], (char) seed[1]));
    }
    
    public static int[] generateSeed(String goal, int start, int finish) {
        char[] input = goal.toCharArray();
        char[] pool = new char[input.length];
        label:
        for (int seed = start; seed < finish; seed++) {
            Random random = new Random(seed);
    
            for (int i = 0; i < input.length; i++)
                pool[i] = (char) random.nextInt(27);
    
            if (random.nextInt(27) == 0) {
                int base = input[0] - pool[0];
                for (int i = 1; i < input.length; i++) {
                    if (input[i] - pool[i] != base)
                        continue label;
                }
                return new int[]{seed, base};
            }
    
        }
    
        throw new NoSuchElementException("Sorry :/");
    }
    
    public static String randomString(int i, char base) {
        System.out.println("Using base: '" + base + "'");
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        for (int n = 0; ; n++) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;
    
            sb.append((char) (base + k));
        }
    
        return sb.toString();
    }
}
