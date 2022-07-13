package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

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
            }else{
                String[] words = query.split(" ");
                return String.valueOf(Integer.parseInt(words[2])-Integer.parseInt(words[4]));
            }
        } else if (query.contains("which of the following numbers is the largest:")){
            String[] first = query.split(":");
            return "";
        } else{
            return "";
        }
    }
}
