# Tutorial APAP
## Authors
* **Maisy Rahmawati** - *1806147035* - *B*

## Tutorial 1
### What I have learned today
Saya belajar menggunakan IDE Intellij pada tutorial kali ini, karena sebelumnya saya belum pernah
menggunakan Intellij. Saya juga mereview lagi penggunaan git di cmd karena sudah sedikit lupa.
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
 Issue tracker sendiri merupakan salah satu tempat yang disediakan oleh Github dimana pengguna dapat 
 menuliskan berbagai issue (permasalahan), ide, penyempurnaan, bugs software, dan sebagainya.
 Dinamakan issue tracker karena kita dapat melakukan tracking atau pelacakan terkait apa yang kita tulis
 seperti pekerjaan (project), masalah yang kita tulis, bugs, dsb.
 Dengan adanya issue di dalam repository, kita juga dapat memiliki feedback. Dengan adanya Issue Tracker,
 kita juga dapat mentransfer open issue ke repository yang lain. Kita dapat menggunakan "Pin" untuk
 menandai masalah, sehingga ketika kita melakukan tracking maka tidak ada masalah yang terlewat atau duplikat.
 Source: https://docs.github.com/en/github/managing-your-work-on-github/about-issues
2. Apa perbedaan dari git merge dan git merge --squash?
git merge dan git merge --squash sama sama mengintegrasikan (menyatukan) cabang / branch yang berbeda.
Perbedaannya terletak pada commit, dimana pada git merge maka hanya akan muncul merge commit.
Sedangkan pada git merge --squash, merge commit tidak muncul melainkan semua perubahan yang terjadi
di dalam Master akan dijadikan satu dengan commit squash.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
Version Control System merupakan infrastruktur yang mendukung pengembangan suatu project (aplikasi) secara 
kolaboratif. Dengan adanya fitur kolaborasi, maka suatu project aplikasi dapat dikerjakan secara bersama sesuai
dengan peran masing-masing orang. Maksudnya, orang kedua tidak harus menunggu orang pertama selesai dalam 
mengerjakan tugasnya lebih dulu untuk dapat mengerjakan fitur yang menjadi tanggung jawabnya. Ia dapat mengerjakan
bersamaan dengan fitur branch. Setelah semuanya selesai, mereka dapat mengintegrasikan fitur yang telah mereka
buat dalam masing-masing branch melalui perintah merge ke dalam master.
### Spring
4. Apa itu library & dependency?
Library adalah koleksi modul-modul program yang dapat mendukung dan memudahkan pengembangan software.
Depedency adalah ketergantungan, dalam hal ini adalah atribut yang menentukan nilai atribut lainnya.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven sendiri merupakan salah satu Build Tools, dimana tujuan dari penggunaan ini (Mavem) adalah sebagai
solusi terkait dengan permasalahan perbedaan penggunaan IDE. Setiap programmer tentukan akan nyaman membuat
suatu project seperti project Java dengan menggunakan IDE yang sudah familiar bagi mereka. Namun, setiap IDE
mempunyai struktur project default masing-masing yang telah mereka tentukan yang umumnya hanya dapat dibaca 
oleh IDE tersebut saja. Oleh karena itu, digunakan Build Tools agar programmer dapat berkerja bersama-sama 
dengan IDE yang berbeda. Maven memiliki keunggulan yaitu struktur project yang dibuat sendiri sehingga dapat
dibuka dengan berbagai IDE. Selain itu, Maven juga memberikan kemudahan dalam memanage dependency.
Alternatif selain maven yang dapat digunakan mungkin nodejs dan npm.
Source: https://medium.com/@acep.abdurohman90/mengenal-maven-sebagai-java-build-tools-5ba752f75812
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring Framework bisa digunakan untuk support pada dependency injection, dapat menjadi fondasi untuk framework
lainnya seperti AspectJ, Bean Validation, dan JPA.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?
@RequestParam digunakan untuk mengekstrak parameter query, @PathVariable digunakan untuk mengekstrak data langsung dari URI.
@PathVariable lebih digunakan untuk web RESTful di mana URL berisi nilai, mis. http: // localhost: 8080 
sedangkan @RequestParam digunakan untuk website tradisional.
Source: https://www.javacodegeeks.com/2017/10/differences-requestparam-pathvariable-annotations-spring-mvc.html
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa pakai VSCode susah ngerun?
- [ ] Bagaimana mendeteksi dan mengetahui error di Intellij?
- [ ] Bagaimana mengganti commit message di git?
- [ ] Apa web yang bisa menjadi referensi agar mudah mempelajari penggunaan perintah git di cmd?

## Tutorial 2
### What I have learned today
Pada tutorial ke-dua ini, saya mempelajari konsep tentang MVC dan bagaimana kita mengaplikasikan MVC tersebut.
Selain itu, saya juga belajar untuk lebih memahami konsep dependency injection, walaupun sejujurnya masih terdapat
beberapa konsep yang masih membingungkan.
### Pertanyaan
1. Pertanyaan 1: Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom&catatan=Semangat
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi!
Ketika saya mencoba menjalankan akses link tersebut, saya mendapatkan error, di mana link tersebut tidak dapat terakses.
Menurut saya, hal tersebut dikarenakan pada saat kita membuat method public String addResep, di baris terakhir, kita
melakukan return "add-resep". View yang kita return berupa add-resep tersebut belum kita buat HTML-nya (templatenya),
sehingga sungguh mustahil jika kita dapat mengakses link tersebut disaat templatenya belum kita buat.
2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? 
Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat!
Menurut pendapat saya, anotasi @Autowired merupakan implementasi Dependency Injection.
Sebelum membuat method-method di dalam class ResepController, kita terlebih dahulu menuliskan @Controller. Ini dimaksudkan
untuk Spring Framework melakukan inisiasi terhadap class ResepController. Spring Framework juga akan melakukan injection
(suntikan) terhadap kebergantungan (dependency) class tersebut. Dari pandangan saya, anotasi @Autowired dapat menggantikan
peranan dari method setter atau penambahan argumen pada constructor saat kita akan melakukan injection terhadap dependency.
Ketika kita menggunakan anotasi @Autowired, maka Spring Framework akan melakukan injection dengan objek yang bertipe sama 
untuk dependency yang terjadi pada class tersebut. Pada kasus Controller dan Service yang telah dibuat, di dalam class
ResepController, terdapat objek ResepService yang mana ResepService akan menentukan terbentuknya class ResepController.
Atau kita dapat mengatakan bahwa class ResepController tidak dapat terbentuk tanpa terbentuknya ResepService (ada dependency
antara ResepController dan ResepService). Selanjutnya, kita juga membuat class ResepInMemoryService yang mengimplement 
ResepService. Dengan adanya implements ini, maka class ResepInMemoryService (khususnya method getResepByNomorResep) dapat 
digunakan pada property ResepService di dalam class ResepController. Selanjutnya, anotasi @Autowired pada properti ResepService
digunakan untuk injeksi ResepService yaitu ResepInMemoryService (khususnya method getResepByNomorResep).
3. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi!
Ketika saya mengakses link tersebut, yang muncul adalah Whitelabel Error Page. Menurut saya, hal ini dapat terjadi karena
tidak ada 'catatan' yang dimasukkan sebagai parameter di dalam link tersebut. Sementara, ketika kita membuat objek ResepModel,
terdapat parameter noResep, namaDokter, namaPasien, catatan yang harus kita masukkan sebagaimana yang telah didefinisikan pada class 
ResepModel yang telah kita buat sebelumnya. Oleh karena itu, ketika kita mengklik link tersebut, kita justru mendapatkan whitelabel 
error page. 
4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang harus diakses?
http://localhost:8080/resep/view?noResep=1 (pasien Quanta memiliki nomor resep 1, jadi kita harus memasukkan parameter noResep=1)
5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/resep/viewall , 
apa yang akan ditampilkan? Sertakan juga bukti screenshotmu!
Tampilan bahwa nomor resep yang kita yang kita masukkan berhasil ditambahkan, setelah masuk ke link resep/viewall, akan ditambilkan
informasi dari apa yang kita telah masukkan.
<img src="ss1.jpg" width="400">
Setelah kita mengakses http://localhost:8080/resep/viewall
<img src="ss2.jpg" width="400">
### Latihan
4. 
5. 
6. 
7. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Kenapa pakai VSCode susah ngerun?
- [ ] Bagaimana mendeteksi dan mengetahui error di Intellij?
- [ ] Bagaimana mengganti commit message di git?
- [ ] Apa web yang bisa menjadi referensi agar mudah mempelajari penggunaan perintah git di cmd?

## Tutorial 3
### What I have learned today
Pada tutorial-3 ini saya mempelajari tentang bagaiaman menghubungkan antara database dengan program Java, yaitu
hitungbmi. Selain itu, saya juga mempelajari penggunaan ORM, meskipun masih belum memahami konsep ORM itu sendiri.
Selain itu, saya juga mempelajari tentang Qualifier.
### Pertanyaan
1. Pada class ResepDb, terdapat method findByNoResep, apakah kegunaan dari method tersebut?
Method findByNoResep terdapat pada interface ResepDb yang mengekstend JpaRepository. Method ini berfungsi untuk
mencari atau menemukan data-data di dalam database berdasarkan nomor resep. Oleh karena itu, method ini memiliki
parameter berupa nomor resep bertipe Long, yang mana nomor resep ini yang akan menjadi acuan pencarian dari data-
data di dalam database. Misalkan pada class ResepServiceImpl, method ini digunakan di dalam method getResepByNomorResep
yang akan mengambil data berdasarkan nomor resep dengan mencari data dari database berdasarkan nomor resep tersebut
(method findByNoResep).
2. Pada class ResepController, jelaskan perbedaan method addResepFormPage dan addResepSubmit?
Method addResepFormPage menggunakan anotasi GetMapping, di mana anotasi ini berfungsi untuk method GET untuk mengakses 
form page resep. Melalui anotasi GetMapping tersebut, maka akan dilakukan routing ke path url localhost:8080/resep/add 
dan data yang direquest oleh browser hanya akan ditampilkan pada path url tersebut. Sebaliknya method addResepSubmit 
menggunakan anotasi PostMapping. Sesuai namanya, anotasi ini berfungsi untuk method POST, dimana data yang telah diisi
oleh user melalui form akan dikirimkan (disubmit) untuk ditampung (disimpan).
3. Jelaskan kegunaan dari JPA Repository!
JPA merupakan salah satu standar yang digunakan untuk mengakses database di dalam Java. JPA pada dasarnya menggunakan
ORM (Objek Relational Mapping), yang mana diimplementasikan oleh Hibernate. JPA Repositoru ini berfungsi untuk memudahkan
kita dalam membangun aplikasi, karena di dalamnya terdapat fungsi-fungsi CRUD dasar (Create, Read, Update, Delete), sehingga
kita dapat langsung mengimplementasikan fungsi-fungsi tersebut tanpa harus membuat fungsi sendiri.
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara ResepModel dan ObatModel dibuat?
Menurut code yang ada di dalam ResepModel dan ObatModel, pada bagian @JoinColumn(name="resep_id",referencedColumnName="no_resep",
nullable=false) di dalam class ObatModel. Hal ini karena dengan adanya anotasi JoinColumn, maka ada kolom yang direference oleh
ObatModel, yaitu kolom no_resep pada ResepModel, sehingga dengan adanya JoinColumn ini maka akan ada relasi antara ResepModel
dan ObatModel.
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!
FetchType terdapat pada Hibernate, yang digunakan dalam penentuan load collection object (child) setelah parentnya di-fetch,
apakah akan di-load semua collection object (child) atau tidak. FetchType.LAZY akan me-load collection object (child)
jika dibutuhkan dalam method getter. Artinya FetchType.LAZY tidak akan me-load semua collection object (child) setelah
parentnya di-fetch. Sebaliknya, FetchType.EAGER akan me-load semua collection object (child) setelah parentnya di-fetch.
Sementara itu, Cascade pada dasarnya digunakan sebagai operasi antara tabel relasi, dimana adanya type ALL pada cascade
memungkinkan semua operasi cascade akan diterapkan pada entitas-entitas yang terkait. Misalkan entitas A dihapus, maka
entitas yang terkait dengan entitas A akan dihapus juga.
### Latihan
4. 
5. 
6. 
7. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya sering mengalami troubel pada Hibernate?
- [ ] Bagaimana penjelasan lebih lanjut tentang ORM?
- [ ] Bagaimana mendeteksi dan mengetahui error di Intellij?
- [ ] Bagaimana mengganti commit message di git?
- [ ] Beberapa method dalam tutorial masih belum bisa dipahami

## Tutorial 4
### What I have learned today
Pada tutorial ini, saya mempelajari banyak materi terkait thymeleaf. Walaupun sejujurnya saya masih mengalami cukup
kesulitan karena saya juga harus mengingat-ingat kembali materi PPW yang berkaitan dengan materi yang saya pelajari
saat ini.
### Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!
Ketika kita menggunakan include yaitu: <div th:include = "...">Something</div> maka pada kondisi ini, fragment akan 
ditempatkan di dalam tag <div>
Sedangkan ketika kita menggunakan replace: <div th:replace = "...">Something</div> maka pada kondisi ini, <div> akan 
digantikan oleh Something.
Melalui Thymeleaf, kita dapat menyertakan bagian halaman lain sebagai fragment menggunakan th: include (akan menyertakan 
konten fragmen ke dalam tag host-nya) atau th: replace yang akan menggantikan tag host dengan fragmen. Jika dilihat dari 
fungsionalitasnya, th:include akan memasukkan fragmen yang ditentukan sebagai bagian dari tag host-nya tetapi tidak
menyertakan tag fragmen. Sementara itu, th:replace akan menggantikan tag host dengan fragmen, dengan menghapus tag host 
dan menggantikan tag host, th:replace akan menambahkan fragmen yang ditentukan termasuk tag fragmen.
2. Jelaskan apa fungsi dari th:object!
th:object merupakan salah satu penerapan tag thymeleaf yang digunakan untuk menampung objek yang berasal dari controller. 
Contohnya th:object="${obat}, maka objek obat akan ditampung oleh th:object.
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
$ atau variable expressions dapat dilihat sebagai attribute values atau bagian darinya, depending on the attribute. 
Variable expressions tidak hanya dapat melibatkan proses output tetapi juga pemrosesan yang lebih kompleks seperti 
conditional dan iterasi. Sementara itu, * atau selection expressions hampir sama dengan variable expressions hanya 
saja selection expressions akan dieksekusi pada objek yang dipilih sebelumnya bukan pada variable map secara keseluruhan. 
Objek yang terlibat akan ditampung dalam th:object. Variable expressions dapat kita gunakan ketika kita sedang melakukan
iterasi atau membuat conditional expression. Sedangkan selection expression dapat kita gunakan ketika kita melakukan
mapping.
4. Bagaimana kamu menyelesaikan latihan nomor 3?
Sebenarnya saya belum menyelesaikan latihan nomor 3 karena saya masih kurang memahami cara mengirim variabel ke fragment.
Tetapi, ide yang saya dapatkan yaitu dengan menetapkan suatu argumen dari suatu method lalu kita mengambil argumen tersebut
dari fragment. Selain itu, saya juga memikirkan adanya implement sebagai cara untuk berkomunikasi dengan fragment.
### Latihan
Di dalam kode. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya sering mengalami troubel pada Hibernate?
- [ ] Bagaimana penjelasan lebih lanjut tentang application.properties?
- [ ] Bagaimana cara kerja pom xml?
- [ ] Bagaimana fungsionalitas dari form hendler?
- [ ] Bagaimana menemukan error di internal service error?

## Tutorial 5
### What I have learned today
Pada tutorial kali ini, saya banyak belajar tentang web service. Selain itu, saya juga mempelajari tentang bagaimana
cara menggunakan postman. Sejujurnya, saya sendiri masih mengalami beberapa kendala dalam mengoperasikan postman karena ini
pertama kalinya saya menggunakan aplikasi tersebut. Terkait dengan web service, saya mendapatkan ilmu baru seperti tahu tentang
anotasi baru yaitu JsonIgnoreProperties dan JsonProperty. Selain itu, saya juga mempelajari mengenai web client.
### Pertanyaan
1. Apa itu Postman? Apa kegunaannya?
Postman adalah salah satu tool atau alat atau aplikasi yang digunakan oleh para developer untuk melakukan proses pembuatan, 
developing atau testinG API, di mana Postman menyediakan banyak fitur ada yang berbayar (paid) tetapi ada pula yang gratis 
(free). Beberapa contoh fitur free yang disediakan oleh Postman diantaranya Sharing Collection API for Documentation dan Testing
API. Sedangkan untuk fitur paid, Postman menyediakan fitur Realtime Collaboration Team, Monitoring API, dan Integration. Adanya 
fitur ini memberikan kemudahan terutama bagi para developer yang dekat dengan hal-hal berbau API.
Ref: (https://medium.com/skyshidigital/documentation-testing-api-dengan-postman-part-1-5d33e430dca7)
Kegunaan dari Postman seperti yang telah dijelaskan sebelumnya yaitu membantu dalam proses pembuatan API, pengembangan API, dan 
testing API. Dalam proses development API, Postman menyediakan fitur:
- Collection yang memudahkan pengelompokan request sesuai dengan proyek tertentu.
- Environment untuk menyimpan atribut yang dapat digunakan atau dimanipulasi dalam proses request API.
- Mock Server yang dapat berguna dengan adanya fitur example response sebagaimana yang telah dipelajari pada tutorial.
- Response yaitu semacam mockup API.
Ref: (https://medium.com/@novancimol12/postman-4f181d625fe1#:~:text=Postman%20merupakan%20tool%20untuk%20melakukan,Collection)
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty!
@JsonIgnoreProperties berguna untuk menyembunyikan serialisasi properti ketika terjadi atau selama serialization dan untuk 
mengabaikan pemrosesan JSON properties read ketika terjadi atau selama deserialization. Atau dengan kata lain, @JsonIgnoreProperties
berguna untuk memberikan tanda pada properti-properti (daftar properti) yang akan diabaikan atau disembunyikan pada suatu class.
Ref: (https://fasterxml.github.io/jackson-annotations/javadoc/2.6/com/fasterxml/jackson/annotation/JsonIgnoreProperties.html)
@JsonProperty sifatnya lebih general, anotasi ini berguna untuk memberikan tanda pada method setter dan getter yang non-standard untuk
digunakan berkaitan dengan Json property. Dari hal tersebut, kita dapat menandai suatu method sebagai method getter dengan menggunakan 
anotasi @JsonProperty atau anotasi alternatif lain yaitu @JsonGetter dan kita dapat menandai suatu method sebagai method setter dengan
anotasi @JsonProperty atau anotasi alternatif lain yaitu @JsonSetter terutama ketika kita ingin membaca beberapa data JSON, tetapi 
entity class target tidak sama persis dengan data tersebut. Jika melihat lagi penggunaan @JsonProperty pada tutorial, maka anotasi tersebut
digunakan untuk mengganti nama method menjadi nama method yang menggunakan tanda dash(-) di dalamnya.
Ref: (https://www.baeldung.com/jackson-annotations)
Ref: (https://www.tutorialspoint.com/jackson_annotations/jackson_annotations_jsonproperty.htm)
3. Apa kegunaan atribut WebClient?
Menurut pendapat saya, atribut WebClient diposisikan sebagaimana web client dalam suatu network yang memiliki kaitan dengan web service 
(web server). Dalam hal ini, WebClient adalah method yang sifatnya final dan dia merupakan method yang meminta informasi dengan cara
mengakses web service melalui web browser. Pada kasus ini, WebClient digunakan untuk mengirimkan setiap jenis URI yang telah dibuat.
Oleh karena itu, sebagaimana yang telah dilakukan di dalam tutorial bahwa kita harus melakukan setup WebClient terlebih dahulu untuk 
memverifikasi bahwa URI yang valid diminta.
Ref: (https://www.baeldung.com/webflux-webclient-parameters)
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity adalah suatu entity yang mewakili response HTTP, termasuk di dalamnya header, isi, dan juga status. Dengan menggunakan
ResponseEntity maka kita dapat menambahkan header dan status code sehingga dapat kita katakan bahwa dengan ResponseEntity maka kita juga 
dapat mengontrol apapun yang ada di dalam response HTTP termasuk header, isi, dan status code.
Ref: (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html)
BindingResult digunakan sebagai penyimpanan dari hasil validasi dan binding yang dilakukan. Selain itu, BindingResult juga berisi error apa 
saja yang mungkin telah terjadi. BindingResult akan muncul tepat setelah model yang divalidasi. Jika tidak, Spring akan gagal untuk memvalidasi 
objek tersebut dan akan terjadi throws an exception.
Ref: (http://zetcode.com/spring/bindingresult/)
### Latihan
Di dalam kode. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Bagaimana melakukan konfigurasi beberapa request seperti PUT dan DEL di dalam postman?
- [ ] Bagaimana keterkaitan antara satu method dengan method yang lain?
- [ ] Bagaimana cara mengoperasikan postman?

## Tutorial 6
### What I have learned today
Pada tutorial kali ini, saya belajar tentang web security, bagaimana kita membuat otentikasi dan otorisasi dari setiap user yang
masuk ke dalam sistem atau website ini. Selain itu, saya juga mengingat-ingat kembali bagaimana membuat login dan logout dengan
menggunakan spring boot. Saya juga belajar bagaimana mengoperasikan phpmyadmin (mysql) terutama untuk insert role. Terakhir, saya
juga mempelajari proses pengambilan username dan password dari database mysql dan menggunakannya untuk proses otentikasi dan otorisasi.
### Pertanyaan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut 
diimplementasi?
Otentikasi merupakan suatu proses "mengenali" pengguna yang masuk ke dalam suatu sistem atau website atau dapat dikatakan bahwa
proses otentikasi akan memverifikasi siapa yang pengguna yang masuk ke dalam sistem. Biasanya proses otentikasi dilakukan dengan
mengenali username dan password yang dimasukan oleh pengguna. Sedangkan otorisasi adalah suatu proses yang akan memverifikasi
apa saja hal-hal yang dapat dilakukan oleh suatu pengguna saat berselancar di dalam sistem atau website atau dapat dikatakan bahwa
otorisasi akan memverifikasi pengguna terkait akses ke suatu data atau informasi yang ia miliki di dalam sistem atau website.
Di dalam kode yang telah saya buat, konsep otentikasi dan otorisasi diimplementasi di dalam class WebSecurityConfig.java di dalam 
package security. Lebih tepatnya, otentikasi ada pada method public void configureGlobal(AuthenticationManagerBuilder auth) sebelum 
username dan password diambil dari database dan pada method public void configAuthentication(AuthenticationManagerBuilder auth) ketika 
username dan password diambil dari database. Sementara otorisasi ada pada method protected void configure(HttpSecurity http) seperti
pada baris .antMatchers("/resep/**").hasAnyAuthority("APOTEKER") dan pada class UserDetailsServiceImpl.java.
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!
BCryptPasswordEncoder adalah suatu constructor (class, encoder) yang memang disediakan oleh Spring Security untuk melakukan hashing
dengan menggunakan algoritma "bcrypt" 16 byte random. Selain BCryptPasswordEncoder, Spring Security juga menyediakan StandardPasswordEncoder 
dan NoOpPasswordEncoder terkait dengan proses hashing. BCryptPasswordEncoder meng-implements interface PasswordEncoder sebagai mekanisme
password hashing. BCryptPasswordEncoder sangat direkomendasikan ketika proses hashing tidak diperlukan tetapi akan memakan waktu yang
lebih banyak. Bcrypt akan menyimpan salt yang ada di dalam nilai hash itu sendiri. Nantinya, hash value yang akan dihasilkan akan mengandung
BCrypt algorithm version, strength of the algorithm, dan generated salt yang dihasilkan secara random.
Ref: https://terasolunaorg.github.io/guideline/1.0.x/en/Security/PasswordHashing.html
3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID merupakan bagian dari spring session, yang digunakan untuk menyimpan session (sesi) dari user yang masuk ke dalam sistem atau website.
UUID digunakan melalui pendefinisian di dalam model yang kita buat yaitu melalui anotasi @GenericGenerator sebagai value dari strategy yang digunakan.
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
class UserDetailsServiceImpl.java berguna untuk melakukan otorisasi pada user yang masuk ke dalam sistem atau website di mana otorisasi akan
digenerated dari username dan role dari username tersebut. Class UserDetailsServiceImpl.java berbeda dengan UserRoleServiceImpl.java di mana class
UserRoleServiceImpl.java digunakan untuk menambahkan user dan encrypt password dengan BCryptPasswordEncoder. Class UserDetailsServiceImpl.java
penting dan tanpa adanya class tersebut maka otorisasi sesuai dengan role dari username tidak dapat dihasilkan dan semua user tidak ada pembagian
hak akses di dalam sistem atau website.
### Latihan
Di dalam kode. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Bagaimana mengatasi masalah database mysql yang tidak dapat dijalankan pada xampp?
- [ ] Mengapa sering sekali muncul error unable to start web server ketika mengerjakan tutorial?
- [ ] Bagaimana melalukan matched verifikasi username dan password yang diinput user dengan data di dalam database?

## Tutorial 7
### What I have learned today
Pada tutorial kali ini, saya cukup mengalami kesulitan terutama saat menginstall npm untuk create-react-app dan untuk membuat create-react-app 
frontend. Saya masih tidak memahami mengapa saya tidak kunjung dapat menginstall npm dan membuat frontend. Hal ini membuat saya tidak dapat menyelesaikan
tutorial kali ini dengan tepat waktu. Walaupun demikian, pada tutorial kali ini, saya mempelajari mengenai react dan bagaimana kita dapat memanfaatkan
adanya component dengan data dan interface yang saling terkait.
### Pertanyaan
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.
	Untuk soal nomor 1, menurut ide saya, untuk mengilangkan checkbox pada item di list pada bagian kiri, saya menggunakan approach yaitu
menghilangkan type dari input pada index.js di dalam component Item. Pada index.js di dalam component Item, saya menghilangkan type="checkbox"
dengan melakukan comment line pada type="checkbox" tersebut. Dengan menghilangkan type="checkbox" maka checkbox pada item di list bagian kiri
juga akan hilang (tidak terlihat).
	Untuk soal nomor 2, untuk dapat membuat button yang dapat menghapus semua list favorit apabila diklik yaitu dengan membuat deleteList
(listMovies) pada component App.js. Isi dari method tersebut yaitu baris pertama adalah const list = [ ...this.state.favItems] yaitu list yang 
akan terisi dengan item-item yang menjadi favorit. Selanjutnya dilakukan conditional dengan if (listMovies > 0) this.setState({ list: list.filter
(list => list != listMovies)}) yang menunjukkan bahwa jika listMoviesnya lebih dari nol (terdapat movie favorite) maka list akan difilter. 
Selanjutnya, saya membuat button Delete pada bagian render di dalam component App.js dengan keterangan onClick={this.deleteList("List")} yang 
menyatakan jika button diklik maka akan menghapus list movie favorit.
	Untuk soal nomor 3, untuk membuat list pada bagian hanya melakukan operasi Add, maka pada component App.js, saya melakukan comment line untuk 
baris else newItems.splice(targetInd, 1) pada method handleItemClick. Begitu pula pada component AppFunc.js, saya juga melakukan comment line untuk 
baris else newItems.splice(targetInd, 1) pada function handleItemClick. Hal ini dikarenakan method splice akan menghapus targetId sebanyak 1 elemen. 
Adanya method splice membuat list pada bagian kiri dapat menghapus item pada bagian kanan. Oleh karena itu, method ini perlu dihilangkan untuk membuat 
bagian kiri hanya melakukan operasi Add saja.
	Untuk soal nomor 4, untuk membuat toggle on dan of, pertama-tama saya membuat method isFavItem pada component App.js yang akan mengetahui apakah 
suatu item adalah favorite atau bukan. Selanjutnya, saya membuat method toogleSwitch juga pada component App.js, dimana di dalam method ini akan di 
setState bahwa item bukan merupakan item favorite. Selanjutnya, dibuat pula toogle slinder round pada bagian render di dalam component App.js yang 
akan memanggil method toogleSwitch.
	Untuk soal nomor 5, untuk menampilkan pesan Belum ada item yang dipilih pada bagian kanan jika daftar favorite masih kosong, pertama-tama saya 
membuat method checkList() pada component App.js yang akan melakukan pengecekan jika favItems adalah null maka akan mengembalikan pesan Belum ada item 
yang dipilih. favItem merupakan const yang saya buat dengan isi this.state. Kemudian pada render masih di dalam component App.js, pada tag List yang 
kedua saya membuat nilai items adalah favItems.checkList() yang berarti favItems akan memanggil method checkList() dan melakukan pengecekan.
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
State dan props adalah suatu data. State dan props tersimpan di dalam components. Perbedaan dari state dan props yaitu state sifatnya 
private yang artinya data yang state hanya memiliki relevansi dengan components sebagai tempat state disimpan. Karena sifatnya tersebut, 
state dapat menyimpan dan mengubah datanya sendiri di dalam components. Sedangkan props atau property memiliki penggunaan yang serupa 
dengan proses penambahan atribut di dalam tag HTML. Karena props memiliki proses layaknya atribut HTML maka value dari props lebih bersifat 
read-only atau tidak dapat diubah nilainya. Props digunakan juga untuk melakukan komunikasi antar components.
3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!
Keuntungan menggunakan components di dalam React yaitu kita dapat menyimpan data yang kita gunakan serta UI (User Interface) dari aplikasi 
yang akan dibuat. Dalam hal ini UI dan data memiliki keterkaitan satu sama lain di mana UI sangat bergantung kepada data yang tersimpan 
sehingga jika kita akan mengubah tampilan UI dari aplikasi yang kita bangun, maka kita harus mengubah pula data yang akan kita gunakan. 
Dengan adanya components, maka akan memudahkan kita dalam mengolah data sekaligus UI.
4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?
Kelebihan penggunaan React dalam pengembangan web yaitu dengan menggunakan React maka aplikasi web yang kita bangun akan bersifat lebih dinamis 
dan component yang telah kita buat sifatnya reuse atau dapat digunakan kembali.
5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?
Kekurangan penggunaan React dalam pengembangan web yaitu dokumentasi dari React kurang banyak dan adanya pencampuran antara HTML dan JavaScript 
juga cukup membingungkan apalagi untuk para pemula.
### Latihan
Di dalam kode. 
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Apa yang menyebabkan sulitnya menginstall npm create-react-app dan membuat app frontend?
- [ ] Bagaimana caranya mengatasi dan mengetahui letak error dari kode-kode yang dibuat?
- [ ] Bagaimana implementasi dari props dan state yang benar?