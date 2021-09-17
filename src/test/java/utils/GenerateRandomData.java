package utils;

public class GenerateRandomData {

    public int randomInteger(int max, int min){
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
