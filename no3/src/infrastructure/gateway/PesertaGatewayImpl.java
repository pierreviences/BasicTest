package infrastructure.gateway;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Peserta;

public class PesertaGatewayImpl implements PesertaGateway {
    private List<Peserta> daftarPeserta;

    public PesertaGatewayImpl() {
        this.daftarPeserta = new ArrayList<>();
    }

    @Override
    public void simpanPeserta(Peserta peserta) {
        daftarPeserta.add(peserta);
    }

    @Override
    public List<Peserta> getDaftarPeserta() {
        return daftarPeserta;
    }

    @Override
    public Peserta cariPeserta(String nama) {
        for (Peserta peserta : daftarPeserta) {
            if (peserta.getNama().equals(nama)) {
                return peserta;
            }
        }
        return null;
    }

    @Override
    public void updateNilaiPeserta(Peserta peserta, int[] nilai) {
        peserta.setNilai(nilai);
    }

    @Override
    public void hapusPeserta(Peserta peserta) {
        daftarPeserta.remove(peserta);
    }
}