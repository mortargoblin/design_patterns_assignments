public class XMLPrinter extends PrinterDecorator {
    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        wrappee.print("<message>" + message + "</message>");
    }
}
