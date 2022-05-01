import java.io.*;
import java.util.*;

public class LZW
{

    //  Calculate log2(x)
    public static double log2(double x){
        return Math.log(x)/Math.log(2);
    }

    // Calculate probability
    public static double p(int num,int length){
        return (num*1.0)/length;
    }

    //Calculate entropy
    public static double entropy(String s){

        //Create a hashmap to store the number of each character
        HashMap<String,Integer> hashMap=new HashMap();

        int length=s.length();
        for(int i=0;i<length;i++){
            String str=Character.toString(s.charAt(i));
            if (hashMap.get(str) ==null){
                hashMap.put(str,1);
            }
            else{
                hashMap.replace(str,hashMap.get(str)+1);
            }
        }

        double entropy = 0;
        double p=0;

        for (String s1 : hashMap.keySet()) {
           p=p(hashMap.get(s1),length);
            entropy+=p*log2(p);
        }
        entropy=-entropy;

        return entropy;
    }

    /**
     * @return Results is a self-defined class to set and get dictionary and sequence code.
     */
    public static Results output(String s)
    {
        // dictionary : Used for storing the initial code and new code
        Vector<String> dictionary = new Vector<>();
        // code : Store sequences code
        Vector<String> code = new Vector<>();

        //initialize dictionary
        dictionary.add("A");
        dictionary.add("B");
        dictionary.add("C");
        dictionary.add("AB");
        dictionary.add("BA");


        int index = 0;

        // pre : Used for storing the previous sequence
        String pre = new String("");


        int length = s.length();

        while (index < length)
        {

            boolean isFind = false;

            // cur : Used for storing the current sequence
            String cur=Character.toString(s.charAt(index));

            //Match
            for (String search : dictionary) {
                if ((pre+cur).equals(search))
                {
                    isFind = true;
                    break;
                }
            }

            // Update pre sequence and store code
            if (isFind)
            {
                pre+=cur;
                index++;
            }
            else
            {
                dictionary.add(pre+cur);
                code.add(Integer.toString(dictionary.indexOf(pre)));
                pre=Character.toString(s.charAt(index));
                index++;
            }

        }

        //Deal with the special situation when index arrives at the end of the sequence
        if (index==length){
            code.add(Integer.toString(dictionary.indexOf(pre)));
        }

        //Use the self-defined class Results to store dictionary and code
        Results results=new Results();
        results.setDictionary(dictionary);
        results.setCode(code);

        return results;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner input=new Scanner(System.in);
        String s=input.next();

        // Get sequence entropy
        if(s.length()<=64)
        {
            double entropy = entropy(s);

            // Get a Results object,and get dictionary and code from it
            Results results = output(s);
            Vector<String> dictionary = results.getDictionary();
            Vector<String> code = results.getCode();

            // Print information
            System.out.println("Sequence entropy: " + entropy);
            System.out.println("Input sequence: " + s);
            System.out.print("Output sequence: ");
            for (int num1 = 0; num1 < code.size(); num1++) {
                System.out.print(code.get(num1) + " ");
            }
            System.out.println();
            System.out.println("Dictionary:");
            for (int num1 = 0; num1 < dictionary.size(); num1++) {
                System.out.println(num1 + " " + dictionary.get(num1));
            }
            System.out.print("\n");
        }
    }
}