# KEN-Totalitas

## Daftar Isi
* [General Description](#general-description)
* [Technologies Used](#technologies-used)
* [External Libraries](#external-libraries)
* [Instruksi Penggunaan](#instruksi-penggunaan)
* [Data Structure (Tree)](#data-structure)
* [Author](#author)

## General Description
Aplikasi yang dibangun merupakan aplikasi berbasis java yang berguna sebagai alat pencatatan transaksi barang, yang dapat digunakan dalam sebuah toko market ataupun restoran. Dengan kata lain, program ini merupakan POS (Point of Sales) yang dapat membantu sebuah toko dalam melakukan dan mencatat transaksi bisnis mereka. Program ini memiliki fitur manajemen inventaris dan manajemen transaksi dasar, serta fitur membership untuk memberikan reward kepada pelanggan yang setia. Selain itu, program ini juga dilengkapi dengan fitur pembuatan laporan sehingga toko dapat melakukan evaluasi terhadap bisnis mereka. Program ini juga dirancang agar mudah diperluas dengan menyediakan dukungan plugin, sehingga pengguna dapat menambahkan fungsionalitas program sesuai dengan kebutuhan mereka. Dengan menggunakan program ini, diharapkan toko dapat mempercepat proses transaksi dan manajemen inventaris, serta meningkatkan kepuasan pelanggan dan efektivitas bisnis secara keseluruhan.

## Technologies Used
1. JDK 20
2. Lombok

## External Libraries
1. PDFBox
2. JFreeChart

## Instruksi penggunaan
1. Clone atau unduh repositry ini ke dalam local file
2. Pastikan IntelliJ telah terinstall
3. Build Program
4. Run `KEN-Totalitas/src/main/java/ken/gui/main`

## Data Structure
```bash
│   .gitignore
│   build.gradle
│   gradlew
│   gradlew.bat
│   README.md
│   settings.gradle
│
├───.gradle
│   │   file-system.probe
│   │
│   ├───8.1.1
│   │   │   gc.properties
│   │   │
│   │   ├───checksums
│   │   │       checksums.lock
│   │   │       md5-checksums.bin
│   │   │       sha1-checksums.bin
│   │   │
│   │   ├───dependencies-accessors
│   │   │       dependencies-accessors.lock
│   │   │       gc.properties
│   │   │
│   │   ├───executionHistory
│   │   │       executionHistory.bin
│   │   │       executionHistory.lock
│   │   │
│   │   ├───fileChanges
│   │   │       last-build.bin
│   │   │
│   │   ├───fileHashes
│   │   │       fileHashes.bin
│   │   │       fileHashes.lock
│   │   │       resourceHashesCache.bin
│   │   │
│   │   └───vcsMetadata
│   ├───buildOutputCleanup
│   │       buildOutputCleanup.lock
│   │       cache.properties
│   │       outputFiles.bin
│   │
│   └───vcs-1
│           gc.properties
│
├───.idea
│   │   .gitignore
│   │   compiler.xml
│   │   externalDependencies.xml
│   │   gradle.xml
│   │   jarRepositories.xml
│   │   KEN-Totalitas.iml
│   │   misc.xml
│   │   modules.xml
│   │   uiDesigner.xml
│   │   vcs.xml
│   │   workspace.xml
│   │
│   ├───libraries
│   │       MigLayout.xml
│   │
│   └───modules
│       │   KEN-Totalitas-2.iml
│       │   KEN-Totalitas.core.iml
│       │   KEN-Totalitas.iml
│       │   KEN-Totalitas.main.iml
│       │   KEN-Totalitas.test.iml
│       │   KEN-Totalitas.ui.iml
│       │   KEN-Totalitas_main.iml
│       │   KENPlug-Dummy.iml
│       │   KENPlugin-Base.iml
│       │   KENPlugin-Currency.iml
│       │   KENPlugin-Dummy.iml
│       │   KENPlugin-Linechart.iml
│       │   KENPlugin-Piechart.iml
│       │
│       ├───plugins
│       │   │   KEN-Totalitas.plugins.iml
│       │   │
│       │   └───KENPlug-Dummy
│       │           KEN-Totalitas.plugins.KENPlug-Dummy.iml
│       │           KEN-Totalitas.plugins.KENPlug-Dummy.main.iml
│       │
│       └───src
│           │   KEN-Totalitas.src.iml
│           │
│           └───ui
│                   KEN-Totalitas.src.KEN-Totalitas.ui.iml
│
├───asset
│       buku_tulis.jpg
│       gunting.jpg
│       no-image-replacement.jpg
│       OpenSans-Light.ttf
│       penghapus.jpg
│       pensil.jpg
│       pisau.jpg
│
├───bin
│   ├───default
│   ├───generated-sources
│   │   └───annotations
│   ├───generated-test-sources
│   │   └───annotations
│   ├───main
│   │   ├───database
│   │   │       barang.json
│   │   │       barang.ser
│   │   │       barang.xml
│   │   │       barang2.json
│   │   │       barang3.json
│   │   │       barangtes.json
│   │   │       bill.json
│   │   │       bill.xml
│   │   │       bill2.json
│   │   │       billFixed.json
│   │   │       billFixed2.json
│   │   │       customer.json
│   │   │       customer2.json
│   │   │       member.json
│   │   │       member2.json
│   │   │       tes.json
│   │   │       vip.json
│   │   │       vip2.json
│   │   │
│   │   └───ken
│   │       ├───backend
│   │       │   │   Vars.class
│   │       │   │
│   │       │   ├───algoritma
│   │       │   │       BillProcess.class
│   │       │   │       BillProcessDecorator.class
│   │       │   │       BillProcessor$Builder.class
│   │       │   │       BillProcessor.class
│   │       │   │
│   │       │   ├───controller
│   │       │   │   │   Controller.class
│   │       │   │   │
│   │       │   │   └───holder
│   │       │   │           BillHolder.class
│   │       │   │           CustomerHolder.class
│   │       │   │           FixedBillHolder.class
│   │       │   │           Holder.class
│   │       │   │           InventoryHolder.class
│   │       │   │           MemberHolder.class
│   │       │   │           VIPHolder.class
│   │       │   │
│   │       │   ├───dataStore
│   │       │   │       AdapterData.class
│   │       │   │       AdapterJSON.class
│   │       │   │       AdapterObject.class
│   │       │   │       AdapterXML.class
│   │       │   │
│   │       │   ├───kelas
│   │       │   │   ├───anggota
│   │       │   │   │       Customer.class
│   │       │   │   │       Member.class
│   │       │   │   │       VIP.class
│   │       │   │   │
│   │       │   │   ├───barang
│   │       │   │   │       Barang.class
│   │       │   │   │
│   │       │   │   └───bill
│   │       │   │           Bill.class
│   │       │   │           BillItem.class
│   │       │   │
│   │       │   ├───plugin
│   │       │   │       AddMenuTab.class
│   │       │   │       CallOnLoad.class
│   │       │   │       Plugin.class
│   │       │   │       PluginManager$1.class
│   │       │   │       PluginManager.class
│   │       │   │       SettingsItem.class
│   │       │   │
│   │       │   └───settings
│   │       │           Settings.class
│   │       │           SettingsEntry.class
│   │       │
│   │       ├───gui
│   │       │   │   .gitkeep
│   │       │   │   AddItem$1.class
│   │       │   │   AddItem$2.class
│   │       │   │   AddItem$3.class
│   │       │   │   AddItem$4.class
│   │       │   │   AddItem$5.class
│   │       │   │   AddItem.class
│   │       │   │   ButtonTabComponent$1.class
│   │       │   │   ButtonTabComponent.class
│   │       │   │   CartItem.class
│   │       │   │   DaftarMember$1.class
│   │       │   │   DaftarMember$2.class
│   │       │   │   DaftarMember.class
│   │       │   │   DefaultLayar.class
│   │       │   │   EditInventoryItem$1.class
│   │       │   │   EditInventoryItem$2.class
│   │       │   │   EditInventoryItem$3.class
│   │       │   │   EditInventoryItem$4.class
│   │       │   │   EditInventoryItem$5.class
│   │       │   │   EditInventoryItem.class
│   │       │   │   EditMember$1.class
│   │       │   │   EditMember$2.class
│   │       │   │   EditMember.class
│   │       │   │   HistoryMember.class
│   │       │   │   HistoryPanel.class
│   │       │   │   InventoryPanel.class
│   │       │   │   LayarCheckout$1.class
│   │       │   │   LayarCheckout.class
│   │       │   │   LayarFixedBill.class
│   │       │   │   LayarUtama.class
│   │       │   │   Main.class
│   │       │   │   MemberCheckoutPanel.class
│   │       │   │   MemberPanel.class
│   │       │   │   Menu$1$1.class
│   │       │   │   Menu$1.class
│   │       │   │   Menu.class
│   │       │   │   MenuItem.class
│   │       │   │   ShowDetail.class
│   │       │   │   TabManager.class
│   │       │   │   Tabs$1.class
│   │       │   │   Tabs.class
│   │       │   │   UnduhDetil.class
│   │       │   │   UnduhHistory.class
│   │       │   │
│   │       │   └───tab
│   │       │           History.class
│   │       │           Inventory$1.class
│   │       │           Inventory$2.class
│   │       │           Inventory$3.class
│   │       │           Inventory.class
│   │       │           Kasir$1.class
│   │       │           Kasir$2.class
│   │       │           Kasir$3.class
│   │       │           Kasir.class
│   │       │           KENTab.class
│   │       │           Members.class
│   │       │           Setting$PluginEntry.class
│   │       │           Setting.class
│   │       │
│   │       └───util
│   │               UID.class
│   │
│   └───test
│       ├───database
│       │       barang.json
│       │       barang.ser
│       │       barang.xml
│       │       barang2.json
│       │       barang3.json
│       │       bill.json
│       │       bill.xml
│       │       bill2.json
│       │       billFixed.json
│       │       billFixed2.json
│       │       customer.json
│       │       customer2.json
│       │       member.json
│       │       member2.json
│       │       tes.json
│       │       vip.json
│       │       vip2.json
│       │
│       └───kontest
│               AdapterTest.class
│               person.xml
│               PluginTest.class
│
├───build
│   ├───classes
│   │   └───java
│   │       └───main
│   │           └───ken
│   │               ├───backend
│   │               │   │   Vars.class
│   │               │   │
│   │               │   ├───algoritma
│   │               │   │       BillProcess.class
│   │               │   │       BillProcessDecorator.class
│   │               │   │       BillProcessor$1.class
│   │               │   │       BillProcessor$Builder.class
│   │               │   │       BillProcessor.class
│   │               │   │
│   │               │   ├───controller
│   │               │   │   │   Controller.class
│   │               │   │   │
│   │               │   │   └───holder
│   │               │   │           BillHolder.class
│   │               │   │           CustomerHolder.class
│   │               │   │           FixedBillHolder.class
│   │               │   │           Holder.class
│   │               │   │           InventoryHolder.class
│   │               │   │           MemberHolder.class
│   │               │   │           VIPHolder.class
│   │               │   │
│   │               │   ├───dataStore
│   │               │   │       AdapterData.class
│   │               │   │       AdapterJSON.class
│   │               │   │       AdapterObject.class
│   │               │   │       AdapterXML.class
│   │               │   │
│   │               │   ├───kelas
│   │               │   │   ├───anggota
│   │               │   │   │       Customer.class
│   │               │   │   │       Member.class
│   │               │   │   │       VIP.class
│   │               │   │   │
│   │               │   │   ├───barang
│   │               │   │   │       Barang.class
│   │               │   │   │
│   │               │   │   └───bill
│   │               │   │           Bill.class
│   │               │   │           BillItem.class
│   │               │   │
│   │               │   ├───plugin
│   │               │   │       AddMenuTab.class
│   │               │   │       CallOnLoad.class
│   │               │   │       Plugin.class
│   │               │   │       PluginManager$1.class
│   │               │   │       PluginManager.class
│   │               │   │       SettingsItem.class
│   │               │   │
│   │               │   └───settings
│   │               │           Settings.class
│   │               │           SettingsEntry.class
│   │               │
│   │               ├───gui
│   │               │   │   AddItem$1.class
│   │               │   │   AddItem$2.class
│   │               │   │   AddItem$3.class
│   │               │   │   AddItem$4.class
│   │               │   │   AddItem$5.class
│   │               │   │   AddItem.class
│   │               │   │   ButtonTabComponent$1.class
│   │               │   │   ButtonTabComponent.class
│   │               │   │   CartItem.class
│   │               │   │   DaftarMember$1.class
│   │               │   │   DaftarMember$2.class
│   │               │   │   DaftarMember.class
│   │               │   │   DefaultLayar.class
│   │               │   │   EditInventoryItem$1.class
│   │               │   │   EditInventoryItem$2.class
│   │               │   │   EditInventoryItem$3.class
│   │               │   │   EditInventoryItem$4.class
│   │               │   │   EditInventoryItem$5.class
│   │               │   │   EditInventoryItem.class
│   │               │   │   EditMember$1.class
│   │               │   │   EditMember$2.class
│   │               │   │   EditMember.class
│   │               │   │   HistoryMember.class
│   │               │   │   HistoryPanel.class
│   │               │   │   InventoryPanel.class
│   │               │   │   LayarCheckout$1.class
│   │               │   │   LayarCheckout.class
│   │               │   │   LayarFixedBill.class
│   │               │   │   LayarUtama.class
│   │               │   │   Main.class
│   │               │   │   MemberCheckoutPanel.class
│   │               │   │   MemberPanel.class
│   │               │   │   Menu$1$1.class
│   │               │   │   Menu$1.class
│   │               │   │   Menu.class
│   │               │   │   MenuItem.class
│   │               │   │   ShowDetail.class
│   │               │   │   TabManager.class
│   │               │   │   Tabs$1.class
│   │               │   │   Tabs.class
│   │               │   │   UnduhDetil.class
│   │               │   │   UnduhHistory.class
│   │               │   │
│   │               │   └───tab
│   │               │           History.class
│   │               │           Inventory$1.class
│   │               │           Inventory$2.class
│   │               │           Inventory$3.class
│   │               │           Inventory.class
│   │               │           Kasir$1.class
│   │               │           Kasir$2.class
│   │               │           Kasir$3.class
│   │               │           Kasir.class
│   │               │           KENTab.class
│   │               │           Members.class
│   │               │           Setting$PluginEntry.class
│   │               │           Setting.class
│   │               │
│   │               └───util
│   │                       UID.class
│   │
│   ├───generated
│   │   └───sources
│   │       ├───annotationProcessor
│   │       │   └───java
│   │       │       └───main
│   │       └───headers
│   │           └───java
│   │               └───main
│   ├───lombok
│   │   └───effective-config
│   │           lombok-main.config
│   │           lombok-test.config
│   │
│   ├───resources
│   │   └───main
│   │       └───database
│   │               barang.json
│   │               barang.ser
│   │               barang.xml
│   │               barang2.json
│   │               barang3.json
│   │               barangtes.json
│   │               bill.json
│   │               bill.xml
│   │               bill2.json
│   │               billFixed.json
│   │               billFixed2.json
│   │               customer.json
│   │               customer2.json
│   │               member.json
│   │               member2.json
│   │               tes.json
│   │               vip.json
│   │               vip2.json
│   │
│   └───tmp
│       └───compileJava
│           │   previous-compilation-data.bin
│           │
│           └───compileTransaction
│               ├───backup-dir
│               └───stash-dir
│                       LayarUtama.class.uniqueId1
│                       Main.class.uniqueId0
│
├───db
│       barang.json
│       barang.ser
│       barang.xml
│       bill.json
│       bill.ser
│       bill.xml
│       billFixed.json
│       billFixed.ser
│       billFixed.xml
│       customer.json
│       customer.ser
│       customer.xml
│       member.json
│       member.ser
│       member.xml
│       vip.json
│       vip.ser
│       vip.xml
│
├───gradle
│   └───wrapper
│           gradle-wrapper.jar
│           gradle-wrapper.properties
│
├───lib
│       miglayout-core-javadoc.jar
│       miglayout-core-sources.jar
│       miglayout-core.jar
│       miglayout-swing-javadoc.jar
│       miglayout-swing-sources.jar
│       miglayout-swing.jar
│
├───plugins
│   ├───KENPlugin-Base
│   │   │   build.gradle
│   │   │   gradlew
│   │   │   gradlew.bat
│   │   │   settings.gradle
│   │   │
│   │   ├───gradle
│   │   │   └───wrapper
│   │   │           gradle-wrapper.jar
│   │   │           gradle-wrapper.properties
│   │   │
│   │   └───src
│   │       └───main
│   │           └───java
│   │               └───kenpluginbase
│   │                   └───util
│   │                           Helper.java
│   │
│   ├───KENPlugin-Currency
│   │   │   build.gradle
│   │   │   gradlew
│   │   │   gradlew.bat
│   │   │   settings.gradle
│   │   │
│   │   ├───gradle
│   │   │   └───wrapper
│   │   │           gradle-wrapper.jar
│   │   │           gradle-wrapper.properties
│   │   │
│   │   └───src
│   │       ├───main
│   │       │   ├───java
│   │       │   │   └───kencurrency
│   │       │   │           KENCurrency.java
│   │       │   │           KENCurrencyConverter.java
│   │       │   │           KENCurrencyHolder.java
│   │       │   │
│   │       │   └───resources
│   │       │       └───kencurrency
│   │       │               converter.json
│   │       │
│   │       └───test
│   │           ├───java
│   │           │       CurrencyTest.java
│   │           │       
│   │           └───resources
│   │               └───kencurrency
│   │                       converter.json
│   │
│   ├───KENPlugin-Dummy
│   │   │   build.gradle
│   │   │   gradlew
│   │   │   gradlew.bat
│   │   │   settings.gradle
│   │   │
│   │   ├───gradle
│   │   │   └───wrapper
│   │   │           gradle-wrapper.jar
│   │   │           gradle-wrapper.properties
│   │   │
│   │   └───src
│   │       └───main
│   │           └───java
│   │                   DollarProcessor.java
│   │                   DummyContent.java
│   │                   DummyTab.java
│   │                   KENPluginDummy.java
│   │
│   ├───KENPlugin-Linechart
│   │   │   build.gradle
│   │   │   gradlew
│   │   │   gradlew.bat
│   │   │   settings.gradle
│   │   │
│   │   ├───gradle
│   │   │   └───wrapper
│   │   │           gradle-wrapper.jar
│   │   │           gradle-wrapper.properties
│   │   │
│   │   └───src
│   │       └───main
│   │           └───java
│   │               └───kenlinechart
│   │                       KENLinechart.java
│   │                       KENLinechartTab.java
│   │
│   └───KENPlugin-Piechart
│       │   build.gradle
│       │   gradlew
│       │   gradlew.bat
│       │   settings.gradle
│       │
│       ├───gradle
│       │   └───wrapper
│       │           gradle-wrapper.jar
│       │           gradle-wrapper.properties
│       │
│       └───src
│           └───main
│               └───java
│                   └───kenpiechart
│                           KENPiechart.java
│                           KENPiechartTab.java
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───ken
│   │   │       ├───backend
│   │   │       │   │   Vars.java
│   │   │       │   │
│   │   │       │   ├───algoritma
│   │   │       │   │       BillProcess.java
│   │   │       │   │       BillProcessDecorator.java
│   │   │       │   │       BillProcessor.java
│   │   │       │   │
│   │   │       │   ├───controller
│   │   │       │   │   │   Controller.java
│   │   │       │   │   │
│   │   │       │   │   └───holder
│   │   │       │   │           BillHolder.java
│   │   │       │   │           CustomerHolder.java
│   │   │       │   │           FixedBillHolder.java
│   │   │       │   │           Holder.java
│   │   │       │   │           InventoryHolder.java
│   │   │       │   │           MemberHolder.java
│   │   │       │   │           VIPHolder.java
│   │   │       │   │
│   │   │       │   ├───dataStore
│   │   │       │   │       AdapterData.java
│   │   │       │   │       AdapterJSON.java
│   │   │       │   │       AdapterObject.java
│   │   │       │   │       AdapterXML.java
│   │   │       │   │
│   │   │       │   ├───kelas
│   │   │       │   │   ├───anggota
│   │   │       │   │   │       Customer.java
│   │   │       │   │   │       Member.java
│   │   │       │   │   │       VIP.java
│   │   │       │   │   │
│   │   │       │   │   ├───barang
│   │   │       │   │   │       Barang.java
│   │   │       │   │   │
│   │   │       │   │   └───bill
│   │   │       │   │           Bill.java
│   │   │       │   │           BillItem.java
│   │   │       │   │
│   │   │       │   ├───plugin
│   │   │       │   │       AddMenuTab.java
│   │   │       │   │       CallOnLoad.java
│   │   │       │   │       Plugin.java
│   │   │       │   │       PluginManager.java
│   │   │       │   │       SettingsItem.java
│   │   │       │   │
│   │   │       │   └───settings
│   │   │       │           Settings.java
│   │   │       │           SettingsEntry.java
│   │   │       │
│   │   │       ├───gui
│   │   │       │   │   .gitkeep
│   │   │       │   │   AddItem.java
│   │   │       │   │   CartItem.java
│   │   │       │   │   DaftarMember.java
│   │   │       │   │   DefaultLayar.java
│   │   │       │   │   EditInventoryItem.java
│   │   │       │   │   EditMember.java
│   │   │       │   │   HistoryMember.java
│   │   │       │   │   HistoryPanel.java
│   │   │       │   │   InventoryPanel.java
│   │   │       │   │   LayarCheckout.java
│   │   │       │   │   LayarFixedBill.java
│   │   │       │   │   LayarUtama.java
│   │   │       │   │   Main.java
│   │   │       │   │   MemberCheckoutPanel.java
│   │   │       │   │   MemberPanel.java
│   │   │       │   │   Menu.java
│   │   │       │   │   MenuItem.java
│   │   │       │   │   ShowDetail.java
│   │   │       │   │   TabManager.java
│   │   │       │   │   Tabs.java
│   │   │       │   │   UnduhDetil.java
│   │   │       │   │   UnduhHistory.java
│   │   │       │   │
│   │   │       │   └───tab
│   │   │       │           History.java
│   │   │       │           Inventory.java
│   │   │       │           Kasir.java
│   │   │       │           KENTab.java
│   │   │       │           Members.java
│   │   │       │           Setting.java
│   │   │       │
│   │   │       └───util
│   │   │               UID.java
│   │   │
│   │   └───resources
│   │       └───database
│   │               barang.json
│   │               barang.ser
│   │               barang.xml
│   │               barang2.json
│   │               barang3.json
│   │               barangtes.json
│   │               bill.json
│   │               bill.xml
│   │               bill2.json
│   │               billFixed.json
│   │               billFixed2.json
│   │               customer.json
│   │               customer2.json
│   │               member.json
│   │               member2.json
│   │               tes.json
│   │               vip.json
│   │               vip2.json
│   │
│   └───test
│       ├───java
│       │   └───kontest
│       │           AdapterTest.java
│       │           person.xml
│       │           PluginTest.java
│       │
│       └───resources
│           └───database
│                   barang.json
│                   barang.ser
│                   barang.xml
│                   barang2.json
│                   barang3.json
│                   bill.json
│                   bill.xml
│                   bill2.json
│                   billFixed.json
│                   billFixed2.json
│                   customer.json
│                   customer2.json
│                   member.json
│                   member2.json
│                   tes.json
│                   vip.json
│                   vip2.json
│
└───test
        Bill 467219941
        Bill 585595257
        Bill 844554853
        Bill 912155221
        output.pdf
        output2.pdf
```
## Author
* [Alex Sander (13521061)](https://github.com/maximatey)
* [Ariel Jovananda (13521086)](https://github.com/arieljovananda88)
* [Shidqi Indy Izhari (13521097)](https://github.com/arieljovananda88)
* [Mohammad Farhan Fahrezy (13521106)](https://github.com/farhanfahreezy)
* [Jericho Russel Sebastian (13521107)](https://github.com/JerichoFletcher)
