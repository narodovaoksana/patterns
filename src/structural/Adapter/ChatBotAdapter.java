package structural.Adapter;

public class ChatBotAdapter implements ClientInterface {
    private ChatBot chatBot;

    public ChatBotAdapter(ChatBot chatBot) {
        this.chatBot = chatBot;
    }

    @Override
    public void communicate() {
        System.out.println("Взаємодія через розмовного бота");
           chatBot.respond();
    }
}