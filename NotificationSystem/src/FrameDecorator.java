public class FrameDecorator extends decorator{
    public FrameDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContext() {
        return "*****\n" + super.getContext() + "\n*****";
    }
}
