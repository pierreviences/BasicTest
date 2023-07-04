# Menjawab Soal No 2

# Alasan menggunakan metode ini

Sebelumnya izin memeberikan informasi, dikarenakan layanan Google Maps API saat ini mengenakan biaya, saya memilih Bing Maps API sebagai alternatif untuk mengambil data maps dan menjawab pertanyaan nomor 1. Setelah saya ngoprek sana-sini dan nyari referensi dari banyak sumber, akhirnya saya nemuin metode yang menurut saya oke banget buat nyelesain masalah si john ini. Tapi, saya sendiri gatau sebenernya metode ini namanya apa. 

Metodenya bagaimana sih? Dan alesannya apa kenapa kamu pakai metode itu? Okai jadi kan Dalam kasus ini, dengan asumsi setiap karyawan harus absen di 10 lokasi berbeda setiap hari, maka John akan memerlukan sekitar 300 permintaan lokasi per hari untuk 10 pengguna. Jumlah ini mencakup 1 pengguna dikalikan dengan 30 hari dikalikan dengan 10 lokasi. Jika layanan Google Maps mengenakan biaya sebesar $5 per 1000 permintaan lokasi, maka John akan menghadapi biaya sebesar $15 untuk 10 pengguna. Oleh karena itu, setelah saya berfikir keras akhirnya saya menemukan ide, pertama-tama kita akan menyimpan hasil data reverse geocoding ke dalam session storage di lingkungan web atau menggunakan shared preference di lingkungan Android. Dengan cara ini, setiap kali pengguna membuka aplikasi, alamat yang sudah disimpan dalam session storage atau shared preference dapat langsung ditampilkan tanpa perlu menunggu respons dari Google Maps. Hal ini akan meningkatkan kecepatan aplikasi dan memberikan pengalaman yang lebih responsif bagi pengguna. Atau mungkin bisa dibilang nama metodenya yaitu metode cache kali ya. 

Metode cache yang digunakan akan menyimpan data alamat yang telah diperoleh melalui reverse geocoding ke dalam session storage atau shared preference. Saat pengguna membuka aplikasi, data maps/lokasi/alamat akan diambil langsung dari session storage atau shared preference tanpa perlu meminta data ke layanan Google Maps setiap kali. Ini akan mengurangi jumlah permintaan yang perlu dikirim dan menghemat biaya. Selain itu, metode ini juga memungkinkan akses offline ke data alamat. Jika pengguna telah membuka lokasi tertentu sebelumnya dan data alamatnya sudah disimpan di cache, pengguna masih dapat melihat alamat tersebut bahkan saat tidak terhubung ke internet. Hal ini meningkatkan fungsionalitas dan kenyamanan pengguna dalam menggunakan aplikasi absensi.

Dengan metode ini, saya berhasil mengurangi secara signifikan jumlah permintaan yang harus dikirim ke layanan Google Maps setiap kali pengguna membuka halaman atau berinteraksi dengan aplikasi. Hasilnya, biaya penggunaan layanan tersebut dapat dihemat dengan cukup signifikan. Lebih keren lagi, karena saya udah nyimpen datanya di session storage, saya bisa langsung aja tampilin alamatnya di web tanpa nungguin respons dari Google Maps. Pokoknya, aplikasinya jadi lebih cepet dan user-nya dapet pengalaman yang lebih responsif. 

Walaupun ada banyak metode lain yang bisa dipake buat ngatasi masalah ini, namun menurut saya metode yang telah dijelaskan ini adalah pilihan yang sangat efektif. Metode ini relatif mudah diimplementasikan dan memberikan hasil yang maksimal dalam mengatasi masalah yang dihadapi oleh John. Akhirnya John akan dapat mengurangi biaya yang harus dikeluarkan untuk layanan Google Maps dengan signifikan, sehingga pendapatan dari langganan sebesar $10 dapat mencukupi kebutuhan pengeluaran. Aplikasi yang dihasilkan juga akan menjadi lebih cepat, responsif, dan memungkinkan akses offline ke data alamat, memberikan pengalaman yang lebih baik bagi pengguna. Dengan demikian, solusi ini akan membantu John mengatasi masalah biaya yang tinggi dari layanan Google Maps dan mengoptimalkan proses reverse geocoding dalam aplikasi absensi karyawan harian yang dibuatnya.




