import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {
    // XOR cipher with a fixed key, Base64-encoded so the output stays printable.
    // Symmetric, so decrypt() reverses encrypt() exactly.
    private static final int KEY = 42;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        wrappee.print(encrypt(message));
    }

    public static String encrypt(String message) {
        byte[] bytes = message.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ KEY);
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decrypt(String encrypted) {
        byte[] bytes = Base64.getDecoder().decode(encrypted);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ KEY);
        }
        return new String(bytes);
    }
}
