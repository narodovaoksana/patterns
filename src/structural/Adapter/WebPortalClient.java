package structural.Adapter;


public class WebPortalClient implements ClientInterface {

    @Override
    public void communicate() {
        System.out.println("Взаємодія через веб-портал");
        sendMessage();
    }
        private void sendMessage() {
        System.out.println("Повідомлення успішно відправлене через веб-портал");
    }
}

