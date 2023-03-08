package TheoriesExplained.ExceptionHandling;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int myInt = Integer.parseInt("pants");
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Hey dude, you can't make an int out of that. Stop trying to make it happen!");
        } finally {
            System.out.println("In finally..");
        }
        System.out.println("End here");
    }
}