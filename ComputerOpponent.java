/**
 * This class random generates the  computer's move in Rock, Paper, Scissors.
 */
public class ComputerOpponent {
    public static String getMove() {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    return "rock";
                case 1:
                    return "paper";
                default: // (case 2)
                    return "scissors";
            }
        
    
        }

}
