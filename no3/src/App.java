import java.util.Scanner;
import application.usecase.PesertaUseCase;
import application.usecase.PesertaUseCaseImpl;
import infrastructure.gateway.PesertaGateway;
import infrastructure.gateway.PesertaGatewayImpl;
import presentation.presenter.ConsoleMenuPresenter;
import presentation.presenter.ConsoleMenuPresenterImpl;
import presentation.presenter.PesertaPresenter;
import presentation.presenter.PesertaPresenterImpl;
import presentation.view.AdminLoginPage;
import util.ScannerInput;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("+===================================+");
        System.out.println("| SELAMAT DATANG DI PROGRAM MEMANAH |");
        System.out.println("+===================================+");

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        boolean loginSuccess = adminLoginPage.showLoginPage();
        if (loginSuccess) {
            System.out.println("Login berhasil.\n");
            PesertaGateway pesertaGateway = new PesertaGatewayImpl();
            PesertaPresenter pesertaPresenter = new PesertaPresenterImpl();
            PesertaUseCase pesertaUseCase = new PesertaUseCaseImpl(pesertaGateway, pesertaPresenter);
            ConsoleMenuPresenter consoleMenuPresenter = new ConsoleMenuPresenterImpl(pesertaUseCase, pesertaGateway);
            boolean running = true;
            while (running) {
                consoleMenuPresenter.tampilkanMenu();
                System.out.print("Pilih menu (1-6): ");
                int pilihan = ScannerInput.nextInt();

                switch (pilihan) {
                    case 1:
                        consoleMenuPresenter.tambahPeserta();
                        break;
                    case 2:
                        consoleMenuPresenter.tampilkanDataPeserta();
                        break;
                    case 3:
                        consoleMenuPresenter.ubahNilaiPeserta();
                        break;
                    case 4:
                        consoleMenuPresenter.hapusPeserta();
                        break;
                    case 5:
                        consoleMenuPresenter.sistemPerangkingan();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
                        break;
                }
            }

            scanner.close();
        } else {
            System.out.println("Login gagal. Aplikasi berhenti.");
        }
    }
}