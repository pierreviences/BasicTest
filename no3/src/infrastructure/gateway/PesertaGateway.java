package infrastructure.gateway;

import java.util.List;

import domain.entities.Peserta;

public interface PesertaGateway {
    void simpanPeserta(Peserta peserta);

    List<Peserta> getDaftarPeserta();

    Peserta cariPeserta(String nama);

    void updateNilaiPeserta(Peserta peserta, int[] nilai);

    void hapusPeserta(Peserta peserta);
}
