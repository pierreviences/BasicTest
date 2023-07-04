package presentation.view;

import util.ScannerInput;

public class AdminLoginPage {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public boolean showLoginPage() {
        String username, password;
        boolean validAdmin = false;
        do {
            System.out.print("Masukkan username: ");
            username = ScannerInput.nextLine();
            System.out.print("Masukkan password: ");
            password = ScannerInput.nextLine();
            validAdmin = validateAdmin(username, password);
            if (!validAdmin) {
                System.out.println("\n*Username atau password salah. Silakan coba lagi.\n");
            }
        } while (!validAdmin);
        return true;
    }

    private boolean validateAdmin(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }
}
