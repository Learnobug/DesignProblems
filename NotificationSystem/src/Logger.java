public class Logger extends Observer{
    @Override
    public void update(String message) {
        System.out.println("Log: " + message);
    }
}
