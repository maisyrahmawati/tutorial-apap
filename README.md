# Tutorial APAP
## Authors
* **<Maisy Rahmawati>** - *<1806147035>* - *<B>*

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