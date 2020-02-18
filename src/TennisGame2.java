
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getLiteralScore(){
        String literalScore = "";
        if (isNormal())
        	literalScore = getLiteral(player1Points) + "-" + getLiteral(player2Points);
         
        
        if (isTie())
        	literalScore=getLiteral(player1Points)+"-All";
            
        if (isDeuce())
            literalScore = "Deuce";
        
        if (isAdvantage1(player1Points,player2Points)) 
        	literalScore = "Advantage player1";
       
        if (isAdvantage1(player2Points,player1Points)) 
           literalScore = "Advantage player2";
        
       
       if (isWinnerOver(player1Points,player2Points)) 
           literalScore = "Win for player1";
       if (isWinnerOver(player2Points,player1Points)) 
           literalScore = "Win for player2";
        return literalScore;
    }


		private boolean isNormal() {
			return player1Points!=player2Points;
		}

	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==0)
			result = "Love";
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
		if (playerPoints==3)
			result = "Forty";
		return result;
	}

		
		
	

	private boolean isTie() {
		return player1Points == player2Points && player1Points < 4;
	}


	private boolean isWinnerOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	

	private boolean isAdvantage1(int firstPlayerPoint, int secondPlayerPoint) {
		return firstPlayerPoint > secondPlayerPoint && secondPlayerPoint >= 3;
	}

	private boolean isDeuce() {
		return player1Points==player2Points && player1Points>=3;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}