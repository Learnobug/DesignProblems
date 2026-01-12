import java.util.ArrayList;
import java.util.List;

public class NotificationEngine extends Observer{
    List<NotificationStrategy> strategies = new ArrayList<>();
    public void addStrategy(NotificationStrategy strategy) {
        strategies.add(strategy);
    }

    @Override
    public void update(String message) {
        for (NotificationStrategy strategy : strategies) {
            strategy.sendNotification(message);
        }
    }
}
