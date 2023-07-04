package presentation.presenter;

import java.util.Comparator;
import java.util.List;

import domain.entities.Peserta;

public class PesertaPresenterImpl implements PesertaPresenter {
    @Override
    public void tampilkanDataPeserta(List<Peserta> daftarPeserta) {
        System.out.println("\n+===================================+");
        System.out.println("|          DATA PESERTA              |");
        System.out.println("+===================================+");
        if (daftarPeserta.isEmpty()) {
            System.out.println("*Peserta belum di tambah.\n");
            return;
        }
        for (Peserta peserta : daftarPeserta) {
            int totalNilai = peserta.getTotalNilai();
            System.out.println("Peserta " + peserta.getNama() + " - Total Nilai: " + totalNilai);
        }
        System.out.println("\n");
    }

    @Override
    public void tampilkanPerangkingan(List<Peserta> daftarPeserta) {
        System.out.println("\n+===================================+");
        System.out.println("|            DAFTAR JUARA           |");
        System.out.println("+===================================+");
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada peserta yang terdaftar.\n");
            return;
        }
        daftarPeserta.sort(new PeringkatComparator());
        for (int i = 0; i < daftarPeserta.size(); i++) {
            Peserta peserta = daftarPeserta.get(i);
            System.out.println("Peringkat " + (i + 1) + ": " + peserta.getNama() + " dengan total nilai "
                    + peserta.getTotalNilai());
        }
        System.out.println("\n");
    }

    private static class PeringkatComparator implements Comparator<Peserta> {
        @Override
        public int compare(Peserta p1, Peserta p2) {
            return Integer.compare(p2.getTotalNilai(), p1.getTotalNilai());
        }
    }
}