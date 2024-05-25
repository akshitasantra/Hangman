import java.util.*;
class Santra_Hangman{
    public static void main(String[] args){
        boolean keepPlaying = true;
        boolean rightGuess = false;
        int correctGuesses = 0;
        Scanner scan = new Scanner(System.in);
        List<String> incorrectGuesses = new ArrayList();
        List<String> guesses = new ArrayList();
        String guess;
        String word;
        while(keepPlaying){
            rightGuess = false;
            correctGuesses = 0;
            System.out.println("Word: ");
            word = scan.nextLine();
            while(!wordVerification(word)){
                System.out.println("That's not a word");
                System.out.println("Word: ");
                word = scan.nextLine();
            }
            String[] letters =new String [word.length()];
            incorrectGuesses.clear();
            guesses.clear();
            for(int i = 0; i < letters.length; i++){
                letters[i] = "_ ";
                System.out.print(letters[i] + " ");
            }
            System.out.println();
            for(int i = 0; incorrectGuesses.size() <= 10; i++){
                System.out.println("Guess: ");
                guess = scan.nextLine().toUpperCase();
                for(int j = 0; j < word.length(); j++){
                    if(guess.equalsIgnoreCase(word.substring(j,j+1)) && verification(guess) && notGuessedBefore(guesses, guess)){
                        letters[j] = guess + " ";
                        rightGuess = true;
                        correctGuesses++;
                    }
                }
                if(!verification(guess)){    
                    System.out.println("gurl that's not even a letter");
                }
                if(!notGuessedBefore(guesses, guess)){
                    System.out.println("you already said that");
                    rightGuess = true;
                }
                for(int a = 0; a < letters.length; a++){
                    System.out.print(letters[a] + " ");
                }
                if(!rightGuess){
                    System.out.println("wrong");
                    incorrectGuesses.add(guess);
                }
                rightGuess = false;
                System.out.println();
                System.out.println("Incorrect Guesses: " + dumb(incorrectGuesses));
                System.out.println();
                if(correctGuesses == word.length()){
                    System.out.println("AYO YOU WON");
                    System.out.println("Play again? y/n");
                    if(scan.nextLine().equalsIgnoreCase("y")){
                        keepPlaying = true;
                        break;
                    }
                    else{
                        keepPlaying = false;
                        break;
                    }
                }
                guesses.add(guess);
                System.out.println(stickman(incorrectGuesses));
            }
            if(correctGuesses != word.length()){
                System.out.println("how did u not win it was literally easy are u dumb????");
                System.out.println("Play again? y/n");
                if(scan.nextLine().equalsIgnoreCase("y")){
                    keepPlaying = true;
                }
                else{
                    keepPlaying = false;
                    break;
                }
            }
        }
    }

    public static String dumb(List<String> incorrectGuesses){
        String output = "";
        for(int i = 0; i<incorrectGuesses.size(); i++)
        {  
            for (int j = i+1; j<incorrectGuesses.size(); j++)
            {   
                if(incorrectGuesses.get(i).compareTo(incorrectGuesses.get(j))>0)   
                {  
                    String temp = incorrectGuesses.get(i);  
                    incorrectGuesses.set(i,incorrectGuesses.get(j));  
                    incorrectGuesses.set(j,temp);  
                }  
            }  
        }  
        for(String ch : incorrectGuesses){
            output += ch + " ";
        }
        return output;
    }

    public static boolean verification(String guess){
        if(guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))){
            return true;
        } 
        return false;
    }

    public static boolean notGuessedBefore(List<String> guesses, String guess){
        if(guesses.contains(guess)){
            return false;
        } 
        return true;
    }

    public static boolean wordVerification(String word){
        char[] wordArray = word.toCharArray();
        boolean r = true;
        for(char i : wordArray){
            if(!Character.isLetter(i)){
                r = false;
            }
        }
        return r;
    }

    public static String stickman(List<String> incorrectGuesses){
        if(incorrectGuesses.size() == 0){
            return "    +---+\n    |   |\n        |\n        |\n        |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 1){
            return "    +---+\n    |   |\n    O   |\n        |\n        |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 2){
            return "    +---+\n    |   |\n    O   |\n    |   |\n        |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 3){
            return "    +---+\n    |   |\n    O   |\n   /|   |\n        |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 4){
            return "    +---+\n    |   |\n    O   |\n   /|\\  |\n        |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 5){
            return "    +---+\n    |   |\n    O   |\n   /|\\  |\n   /    |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 6){
            return "    +---+\n    |   |\n    O   |\n   /|\\  |\n   / \\  |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 7){
            return "    +---+\n    |   |\n    O   |\n  _/|\\  |\n   / \\  |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 8){
            return "    +---+\n    |   |\n    O   |\n  _/|\\_ |\n   / \\  |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 9){
            return "    +---+\n    |   |\n    O   |\n  _/|\\_ |\n  _/ \\  |\n        |\n=========";
        }
        else if(incorrectGuesses.size() == 10){
            return "    +---+\n    |   |\n    O   |\n  _/|\\_ |\n  _/ \\_ |\n        |\n=========";
        }
        return "    +---+\n    |   |\n   x x  |\n  _/|\\_ |\n  _/ \\_ |\n        |\n=========";
    }
}