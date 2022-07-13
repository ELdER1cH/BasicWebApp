package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Maxi";
        } else if (query.contains("what is")) { // TODO extend the programm here
            if (query.contains("plus")){
                String[] words = query.split(" ");
                int result =Integer.parseInt(words[2])+Integer.parseInt(words[4]);
                return String.valueOf(result);
            }else if (query.contains("minus")){
                String[] words = query.split(" ");
                return String.valueOf(Integer.parseInt(words[2])-Integer.parseInt(words[4]));
            }else {
                return "";
            }
        } else if (query.contains("which of the following numbers is the largest:")){
            String[] first = query.split(":");
            String[] numbers = first[1].split(" ");
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = numbers[i].replace(",","");
                numbers[i] = numbers[i].replace("\"","");
            }
            String[] secondNumbers = Arrays.copyOfRange(numbers,1,numbers.length);
            int[] intNumbers = Arrays.stream(secondNumbers).map(Integer::parseInt).sorted().mapToInt(i->i).toArray();
            return String.valueOf(intNumbers[intNumbers.length-1]);
        } else{
            return "";
        }
    }
}
