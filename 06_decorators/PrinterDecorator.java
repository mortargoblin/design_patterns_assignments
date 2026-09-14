public abstract class PrinterDecorator implements Printer {
    protected final Printer wrappee;

    protected PrinterDecorator(Printer printer) {
        this.wrappee = printer;
    }
}
