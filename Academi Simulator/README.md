# Academic Simulator
Academic Simulator adalah aplikasi simulasi akademik yang menggunakan Java Persistence API (JPA) untuk menyimpan data ke dalam database. Aplikasi ini dikembangkan dengan menggunakan H2 Database.

## Deskripsi
Academic Simulator merupakan aplikasi yang memungkinkan pengguna untuk mengelola data akademik seperti Course, Student, dan Enrollment . 
Aplikasi ini terdiri dari 3 entitas utama, yaitu:
1. Course
2. Student
3. Enrollment
   
Aplikasi ini menyediakan fitur-fitur berikut:
1. Menambahkan data Course
2. Menambahkan data Student
3. Menambahkan data Enrollment
4. Menampilkan data Course
5. Menampilkan data Student
6. Menampilkan data Enrollment
7. Menampilkan data Student berdasarkan NPM

## Task 
Pada Aplikasi ini saya mengembangkan sebuah driver (```academic.driver.Driver4```) yang mampu menyimulasikan kemampuan penyimpanan multiple pada semua entitas (```academic.model.Course```, ```academic.model.Student```, dan ```academic.model.Enrollment```). Untuk membedakan instruksi, ditambahkan sebuah segmen pada bagian awal input dengan spesifikasi sebagai berikut:
1. ```course-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Course```.
2. ```student-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Student```.
3. ```enrollment-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Enrollment```.
4. ```course-show``` dimaksudkan untuk menampilkan semua entitas ```academic.model.Course```.
5. ```student-show``` dimaksudkan untuk menampilkan semua entitas ```academic.model.Student```.
6. ```enrollment-show``` dimaksudkan untuk menampilkan semua entitas ```academic.model.Enrollment```.
7. ```student-details``` dimaksudkan untuk menampilkan entitas ```academic.model.Student``` berdasarkan NPM.
8. ```enrollment-grade``` dimaksudkan untuk menambahkan nilai pada entitas ```academic.model.Enrollment```.
9. ```---``` dimaksudkan untuk mengakhiri program.
Perhatikan contoh berikut.

**Input:**
```bash
course-add#12S2203#Object-oriented Programming#3#C
course-add#10S1002#Pemrograman Prosedural#2#D
course-show
student-add#12S20999#Wiro Sableng#2020#Information Systems
student-add#12S20111#Jaka Sembung#2019#Information Systems
student-show
enrollment-add#12S2203#12S20111#2020/2021#even
enrollment-add#12S2203#12S20999#2021/2022#even
enrollment-add#10S1002#12S20999#2020/2021#even
enrollment-show
enrollment-grade#12S2203#12S20111#2020/2021#even#AB
enrollment-grade#12S2203#12S20999#2021/2022#even#A
enrollment-grade#10S1002#12S20999#2020/2021#even#A
enrollment-show
student-details#12S20111
student-details#12S20999
---

````                    

**Output:**
```bash

12S2203|Object-oriented Programming|3|C
10S1002|Pemrograman Prosedural|2|D
12S20999|Wiro Sableng|2020|Information Systems|0.0
12S20111|Jaka Sembung|2019|Information Systems|0.0
12S2203|12S20111|2020/2021|even|none
12S2203|12S20999|2021/2022|even|none
10S1002|12S20999|2020/2021|even|none
12S2203|12S20111|2020/2021|even|AB
12S2203|12S20999|2021/2022|even|A 
10S1002|12S20999|2020/2021|even|A 
12S20111|Jaka Sembung|2019|Information Systems|10.5
12S20999|Wiro Sableng|2020|Information Systems|12.0
12S20999|Wiro Sableng|2020|Information Systems|8.0

```


## Teknologi yang Digunakan
1. Java 17
2. Java Persistence API (JPA)
3. H2 Database
4. Maven
5. Git
6. IntelliJ IDEA
   

## Cara Menjalankan Aplikasi
1. Clone repository ini
2. Buka IntelliJ IDEA
3. Pilih menu File -> Open
4. Pilih folder repository ini
5. Tunggu proses import selesai
6. Buka terminal
7. Jalankan perintah `mvn -q clean compile assembly:single"`
8. Jalankan lagi perintah `java -cp ./target/demo-1.0-SNAPSHOT-jar-with-dependencies.jar com.project.App`




## Konfigurasi Database
1. Buka file `persistence.xml`
2. Ubah nilai dari property `javax.persistence.jdbc.url` sesuai dengan lokasi database H2 yang ingin digunakan
3. Ubah value dari property `javax.persistence.jdbc.driver` sesuai dengan driver yang digunakan oleh database H2 yang ingin digunakan
4. Ubah value dari property `javax.persistence.schema-generation.database.action` sesuai dengan action yang ingin dilakukan pada database H2 yang ingin digunakan
5. Ubah value dari property `eclipselink.ddl-generation` sesuai dengan action yang ingin dilakukan pada database H2 yang ingin digunakan
6. Ubah value dari property `eclipselink.ddl-generation.output-mode` sesuai dengan action yang ingin dilakukan pada database H2 yang ingin digunakan
   


## Struktur Proyek
```
.
├── README.md
├── README2.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── project
│   │   │           ├── model
│   │   │           │   ├── Course.java
│   │   │           │   ├── Enrollment.java
│   │   │           │   └── Student.java 
│   │   |           |   └── drivApp.java
│   │   │           |   └── .gitignore
│   │   │           └── App.java
│   │   └── resources
│   │       ├── META-INF
│   │       │   └── persistence.xml
│   └── test
│       └── java
│           └── com
│               └── project
│                   ├── AppTest.java
└── target
    ├── archive-tmp
    |──classes
    │   ├── META-INF
    │   │   └── persistence.xml
    │   └── com
    │       └── project
    │           ├── App.class
    │           ├── model
    │           │   ├── Course.class
    │           │   ├── Enrollment.class
    │           │   └── Student.class
    |           |   |── drivApp.class
    │           │   └── .gitignore
    │           └── App.class
    ├── demo-1.0-SNAPSHOT.jar-with-dependencies.jar
    ├── generated-sources
    │   └── annotations
    ├── maven-archiver
    │   └── pom.properties
    ├── maven-status
    │   └── createdFiles.lst
    |── └── inputFiles.lst
    ├── surefire
    │   ├── TEST-com.project.AppTest.xml
    │   └── com.project.AppTest.txt
    └── test-classes
        └── com
            └── project
                └── AppTest.class





```



## Pertanyaan atau Masalah
Jika Anda memiliki pertanyaan atau mengalami masalah dalam menjalankan aplikasi ini, jangan ragu untuk menghubungi kami melalui [estopangaribuan@gmail.com] 

Terima kasih telah menggunakan Academic Simulator!



   