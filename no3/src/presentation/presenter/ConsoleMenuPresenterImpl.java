// Presentation Layer
package presentation.presenter;

import application.usecase.PesertaUseCase;
import infrastructure.gateway.PesertaGateway;
import domain.entities.Peserta;
import util.ScannerInput;

public class ConsoleMenuPresenterImpl implements ConsoleMenuPresenter {
    private PesertaUseCase pesertaUseCase;
    private PesertaGateway pesertaGateway;

    public ConsoleMenuPresenterImpl(PesertaUseCase pesertaUseCase, PesertaGateway pesertaGateway) {
        this.pesertaUseCase = pesertaUseCase;
        this.pesertaGateway = pesertaGateway;
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("+===================================+");
        System.out.println("|             MENU UTAMA             |");
        System.out.println("+===================================+");
        System.out.println("| 1. Tambah Peserta                  |");
        System.out.println("| 2. Data Peserta                    |");
        System.out.println("| 3. Ubah Nilai Peserta              |");
        System.out.println("| 4. Hapus Peserta                   |");
        System.out.println("| 5. Daftar Juara                    |");
        System.out.println("| 6. Keluar                          |");
        System.out.println("+===================================+");
    }

    @Override
    public void tambahPeserta() {
        System.out.println("\n=== Tambah Peserta ===");
        ScannerInput.nextLine();
        System.out.print("Masukkan nama peserta: ");
        String nama = ScannerInput.nextLine();

        int[] nilai = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            nilai[i] = ScannerInput.nextInt();
        }

        pesertaUseCase.tambahPeserta(nama, nilai);
        System.out.println("\n*Peserta baru dengan nama " + nama + " berhasil ditambahkan\n");
    }

    @Override
    public void tampilkanDataPeserta() {
        pesertaUseCase.tampilkanDataPeserta();
    }

    @Override
    public void ubahNilaiPeserta() {
        System.out.println("\n=== Ubah Nilai Peserta ===");
        ScannerInput.nextLine();
        System.out.print("Masukkan nama peserta yang ingin diubah nilainya: ");
        String nama = ScannerInput.nextLine();
        Peserta peserta = pesertaGateway.cariPeserta(nama);
        if (peserta != null) {
            int[] nilai = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
                nilai[i] = ScannerInput.nextInt();
            }

            pesertaUseCase.ubahNilaiPeserta(nama, nilai);
            System.out.println("\n*Nilai peserta berhasil diubah.\n");

        } else {
            System.out.println("\n*Peserta dengan nama '" + nama + "' tidak ditemukan.\n");
        }
    }

    @Override
    public void hapusPeserta() {
        System.out.println("\n=== Hapus Peserta ===");
        ScannerInput.nextLine();
        System.out.print("Masukkan nama peserta yang ingin dihapus: ");
        String nama = ScannerInput.nextLine();

        Peserta peserta = pesertaGateway.cariPeserta(nama);
        if (peserta != null) {
            pesertaUseCase.hapusPeserta(nama);
            System.out.println("\n*Peserta berhasil dihapus.\n");
        } else {
            System.out.println("\n*Peserta dengan nama '" + nama + "' tidak ditemukan.\n");
        }
    }

    @Override
    public void sistemPerangkingan() {
        pesertaUseCase.sistemPerangkingan();
    }
}
