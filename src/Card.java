import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    //instance variables typically go after the class defintion
    private String suit, faceName;
    private Image image;

    /**
     * This constructor is used to create the Card object in the
     * system and will intialize the instance variable values
     */
    public Card(String suit, String faceName) {
        setSuit(suit);
        setFaceName(faceName);
        image = new Image("./images/"+getFaceName()+"_of_"+getSuit()+".png");
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method will return a list of valid suits
     */
    public static List<String> getListOfSuits()
    {
        return Arrays.asList("hearts","diamonds","clubs","spades");
    }

    /**
     * This method will validate the argument is a valid suit and set the instance
     * variable
     * @param suit hearts, diamonds, clubs or spades
     */
    public void setSuit(String suit) {
        List<String> validSuits = getListOfSuits();
        suit = suit.toLowerCase();

        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException("valid suits are: " + validSuits);
    }

    public String getFaceName() {
        return faceName;
    }

    /**
     * This method will return a list of valid face names
     * @return 2,3,4,5,6,7,8,9,10,jack,queen,king,ace
     */
    public static List<String> getListOfFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen",
                    "king","ace");
    }

    /**
     * This method will return the value of the card
     */
    public int getFaceValue()
    {
        return getListOfFaceNames().indexOf(faceName)+2;
    }

    /**
     * This method will return a Card in the form of a String matching the pattern
     * faceName of suit
     */
    public String toString()
    {
        return String.format("%s of %s", faceName, suit);
    }

    /**
     * This will validate the argument is a valid face name and set the instance
     * variable
     * @param faceName 2,3,4,5,6,7,8,9,10,jack,queen,king,ace
     */
    public void setFaceName(String faceName) {
        List<String> validNames = getListOfFaceNames();
        faceName = faceName.toLowerCase();

        if (validNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException("valid face names are: "+ validNames);
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
