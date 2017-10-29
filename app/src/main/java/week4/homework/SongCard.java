package week4.homework;
// Homework Question 3
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================


public class SongCard {

    private int songs;
    private boolean activated;

    public SongCard(int n) {
        this.songs = n;
        this.activated = false;
    }

    public void activate(){
        this.activated = true;
    }

    public void buyASong()
        throws CardNotActivatedException, CardEmptyException {
        if (!activated){
            throw new CardNotActivatedException();
        }
        if (songs <= 0){
            throw new CardEmptyException();
        }
        songs--;
        System.out.printf("Bought a song: Card has %d songs and is activated \n", songs);
    }

    public int songsRemaining(){
        return songs;
    }
    public String toString() {

        return String.format("Card has %d songs and is %s", songs, activated ? "activated" : "not activated");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SongCard sc = new SongCard(10);
        System.out.println(sc);
        System.out.println("Trying to buy a song");
        try{
            sc.buyASong();
        } catch (CardEmptyException e1){
            System.out.println("Caught error: " +e1.getMessage() );
        } catch (CardNotActivatedException e2){
            System.out.println("Caught error: " +e2.getMessage() );
        }
        System.out.println(sc);
        System.out.println("Activating the card");
        sc.activate();
        System.out.println(sc);
        System.out.println("Buying songs");
        
        for (int i = 0; i <= 10; i++){
            try {
                sc.buyASong();
            } catch (CardEmptyException e1){
            System.out.println("Caught error: " +e1.getMessage() );
            } catch (CardNotActivatedException e2){
                System.out.println("Caught error: " +e2.getMessage() );
            }
        }
        System.out.println(sc);
    }

    public class CardNotActivatedException extends Exception{
       public CardNotActivatedException(){
           super("Card not activated");
       }
    }

    public class CardEmptyException extends Exception{
        public CardEmptyException(){
            super("No more songs on the card");
        }
    }
}
