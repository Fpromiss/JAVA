package language;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor executor;
    private int number;

    public void parse(Context context) throws ParseException {

        name = context.currentToken();
        context.skipToken(name);
        number = context.currentNumber();
        context.nextToken();
        executor = context.createExecutor(name, number);
    }
    public void execute() throws ExecuteException {
        if (executor == null) {
            throw new ExecuteException(name + ": is not defined");
        } else {
            executor.execute();
        }
    }
    public String toString() {
        return name;
    }
}
