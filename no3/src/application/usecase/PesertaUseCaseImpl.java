package application.usecase;

import domain.entities.Peserta;
import infrastructure.gateway.PesertaGateway;
import presentation.presenter.PesertaPresenter;

public class PesertaUseCaseImpl implements PesertaUseCase {
    private final PesertaGateway pesertaGateway;
    private final PesertaPresenter pesertaPresenter;

    public PesertaUseCaseImpl(PesertaGateway pesertaGateway, PesertaPresenter pesertaPresenter) {
        this.pesertaGateway = pesertaGateway;
        this.pesertaPresenter = pesertaPresenter;
    }

    @Override
    public void tambahPeserta(String nama, int[] nilai) {
        Peserta peserta = new Peserta(nama, nilai);
        pesertaGateway.simpanPeserta(peserta);
    }

    @Override
    public void tampilkanDataPeserta() {
        pesertaPresenter.tampilkanDataPeserta(pesertaGateway.getDaftarPeserta());
    }

    @Override
    public void ubahNilaiPeserta(String nama, int[] nilai) {
        Peserta peserta = pesertaGateway.cariPeserta(nama);
        if (peserta != null) {
            pesertaGateway.updateNilaiPeserta(peserta, nilai);
        }
    }

    @Override
    public void hapusPeserta(String nama) {
        Peserta peserta = pesertaGateway.cariPeserta(nama);
        if (peserta != null) {
            pesertaGateway.hapusPeserta(peserta);
        }
    }

    @Override
    public void sistemPerangkingan() {
        pesertaPresenter.tampilkanPerangkingan(pesertaGateway.getDaftarPeserta());
    }
}