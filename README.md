# KEKOD İlk Hafta Proje Yarışması
## Proje Açıklaması
Bu proje, UI bileşenleri ve Jetpack Navigation kullanarak bir Android uygulaması geliştirmeyi hedefler. Uygulama, çeşitli switch'lerin durumlarına göre dinamik olarak BottomNavigationBar'ı yönetir.

## Özellikler
- Ego Switch: Açık olduğunda diğer switch'ler kapalı ve BottomNavigationBar gizli; kapalı olduğunda diğer switch'ler açılabilir ve BottomNavigationBar görünür.
- BottomNavigationBar: Her switch açıldığında bir ikon ve metin eklenir. "Ego" switch'i açıkken BottomNavigationBar görünmez.
- Slot Düzeni: Switch'lerin bulunduğu ekran 1. slotta yer alır; diğer 4 slot açılan switch'lere göre güncellenir. En son açılan switch BottomNavigationBar’a eklenmez.
- Detay Ekranı: BottomNavigationBar'daki her item’a tıklandığında ilgili detay ekranına gidilir.
- Veri Bağlama: DataBinding veya ViewBinding kullanılmalıdır.
