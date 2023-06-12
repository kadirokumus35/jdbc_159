public class bilgi {
    /*
    JDBC java ile yazilmis class ve interfacelerden olusan bir eklentidir.
    JDBC ayrı bir tool olmadigindan kurulum yapmaya gerek yok
    ancak database lerin Driver classina path ile yolunu gostermeliyiz
    1- connection gerekir
    bunun icin DriverManager ile getConnection methodu ile
    host name uzerinde dt si gosterip kullanici passwoord ile baglanti kurarim
    2- baglanti sonrasi
    sorgulamami olusturmama/ sorgulamalari db e iletmeye / sorgulari db uzerinde calistiran
    bu methodlari iceren Statement a ihtiyac var.
    sorgulari calistiran Execute() methodu var. boolean dondurur
    executeQuery() ile ise ResultSet icine atarak bilgiler iicnde gezebilirz.
    next () ile satir satir gezebiliyorsduk
execute ile kac data etkilendi bunu ogrenmek icin integer deger donduren
executeUpdate methodunu cagirabiliriz.

parcalanamaz en kucuk islem transaction dır
bunu oto commit ile handle edip
setAutoCommit(false) e cekilip rollback ile try cath icine aliriz.


     */
}
