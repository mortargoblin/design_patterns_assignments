public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        // Proof that the encryption is reversible, not one-way.
        String encrypted = EncryptedPrinter.encrypt("Hello World!");
        System.out.println("Decrypted: " + EncryptedPrinter.decrypt(encrypted));
    }
}
