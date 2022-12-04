import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static class Game{
        private Rps player1;
        private Rps player2;

        public Game(){}
        public void SetPlayer1(Rps player1){
            this.player1 = player1;
        }
        public void SetPlayer2(Rps player2){
            this.player2 = player2;
        }
        public void SetInstruction(Instruction instruction){
            if(instruction == Instruction.DRAW){
                player2 = player1;
            }else if(instruction == Instruction.WIN) {
                if(player1 == Rps.ROCK) {
                    player2 = Rps.PAPER;
                }else if(player1 == Rps.PAPER) {
                    player2 = Rps.SCISSORS;
                }else if(player1 == Rps.SCISSORS) {
                    player2 = Rps.ROCK;
                }
            }else if(instruction == Instruction.LOSE){
                if(player1 == Rps.ROCK) {
                    player2 = Rps.SCISSORS;
                }else if(player1 == Rps.PAPER) {
                    player2 = Rps.ROCK;
                }else if(player1 == Rps.SCISSORS) {
                    player2 = Rps.PAPER;
                }
            }
        }

        public int getScore(){
            int score = player2.getPoints();
            //Equal Conditions
            if(player1 == player2){
                score += 3;
            }
            //Winning conditions
            else if(player2 == Rps.ROCK && player1 == Rps.SCISSORS){
                score += 6;
            }
            else if(player2 == Rps.PAPER && player1 == Rps.ROCK){
                score += 6;
            }
            else if(player2 == Rps.SCISSORS && player1 == Rps.PAPER){
                score += 6;
            }
            return score;
        }
    }
    public enum Instruction{
        DRAW,WIN,LOSE
    }
    public enum Rps {
        ROCK(1), PAPER(2), SCISSORS(3);
        private int points;
        Rps(int points){
            this.points = points;
        }
        public int getPoints() {
            return points;
        }
    }

    public static void main(String[] args) {
        List<String> input = Reader.readfile("Day2.txt");
        List<Game> games = mapInputToGame(input);
        System.out.println(getScore(games));
    }

    public static int getScore(List<Game> games){
        int score = 0;
        for(Game game : games){
            score += game.getScore();
        }
        return score;
    }

    public static List<Game> mapInputToGame(List<String> input){
        List<Game> games = new ArrayList<>();
        for (String line : input){
            Game game = new Game();
            String[] splitLine = line.split(" ");
            char player1 = splitLine[0].charAt(0);
            if(player1 == 'A'){
                game.SetPlayer1(Rps.ROCK);
            }else if(player1 == 'B'){
                game.SetPlayer1(Rps.PAPER);}
            else {
                game.SetPlayer1(Rps.SCISSORS);
            }
            char player2 = splitLine[1].charAt(0);
            if(player2 == 'X'){
                game.SetInstruction(Instruction.LOSE);
                //game.SetPlayer2(Rps.ROCK);
            }
            else if(player2 == 'Y'){
                //game.SetPlayer2(Rps.PAPER);
                game.SetInstruction(Instruction.DRAW);
            }
            else {
                game.SetInstruction(Instruction.WIN);
                //game.SetPlayer2(Rps.SCISSORS);
            }
            games.add(game);
        }
        return games;
    }
}
