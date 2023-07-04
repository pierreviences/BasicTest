package domain.entities;

public class Peserta {
    private String nama;
    private int[] nilai;

    public Peserta(String nama, int[] nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int[] getNilai() {
        return nilai;
    }

    public void setNilai(int[] nilai) {
        this.nilai = nilai;
    }

    public int getTotalNilai() {
        int total = 0;
        for (int n : nilai) {
            total += n;
        }
        return total;
    }
}
