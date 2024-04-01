package structural.Adapter;

 public class ChatBot {

        public void respond() {
            System.out.println("Відповідь розмовного бота");}
            public void processRequest(String request) {

        if (request.contains("баланс")) {
            System.out.println("Ваш поточний баланс складає 1000 грн.");
        } else if (request.contains("історія транзакцій")) {
            System.out.println("Ось історія ваших останніх транзакцій...");
        } else {
            System.out.println("Вибачте, я не розумію вашого запиту.");
        }
    }
}
