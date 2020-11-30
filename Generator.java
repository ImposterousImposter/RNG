import java.util.Random;
import javafx.scene.control.TextField;

public class Generator {
    private int generatedNumber;
    private String limit;

    public void setLimit(TextField upperBound)//Set the highest number that can be generated.
    {
        limit = upperBound.getText();
    }

    public int generate(int generatedNumber)//Generate a random number with reference to the setLimit method.
    {
        Random value = new Random();
        generatedNumber = value.nextInt(Integer.parseInt(limit) + 1);
        return generatedNumber;
    }

    public int generateNum(TextField upperBound)//Combines the previous two methods.
    {
        setLimit(upperBound);
        return generate(generatedNumber);
    }
}
