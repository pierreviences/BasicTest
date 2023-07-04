package presentation.presenter;

import java.util.List;

import domain.entities.Peserta;

public interface PesertaPresenter {
    void tampilkanDataPeserta(List<Peserta> daftarPeserta);

    void tampilkanPerangkingan(List<Peserta> daftarPeserta);
}