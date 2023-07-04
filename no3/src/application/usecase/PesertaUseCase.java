package application.usecase;

public interface PesertaUseCase {
    void tambahPeserta(String nama, int[] nilai);

    void tampilkanDataPeserta();

    void ubahNilaiPeserta(String nama, int[] nilai);

    void hapusPeserta(String nama);

    void sistemPerangkingan();
}