package behavioral.CoR;

public abstract class TransactionHandler {
    private TransactionHandler nextHandler;

    public void setNextHandler(TransactionHandler handler) {
        this.nextHandler = handler;
    }

    public void processRequest(TransactionRequest request) {
        if (canHandle(request)) {
            handle(request);
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        } else {
            System.out.println("No suitable handler found for the transaction.");
        }
    }

    protected abstract boolean canHandle(TransactionRequest request);

    protected abstract void handle(TransactionRequest request);
}