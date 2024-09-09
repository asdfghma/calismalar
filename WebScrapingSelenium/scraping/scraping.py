from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time

# WebDriver'ı başlat
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

try:
    # E-ticaret sitesini ziyaret et
    driver.get('https://www.trendyol.com/sr?wc=108656,103665')  # Bu URL'yi hedef sitenizle değiştirin

    # Sayfanın yüklenmesini bekleyin
    time.sleep(5)  # Sayfanın tamamen yüklenmesini sağlamak için bekleme

    # Fiyatları çekmek için gerekli elementleri bulun
    fiyatlar = driver.find_elements(By.CLASS_NAME, 'prc-box-dscntd')  # Bu sınıf adı örnek olup, hedef sitenizin HTML yapısına göre değişebilir

    for fiyat in fiyatlar:
        print(f"Bilgisyar Fiyatları: {fiyat.text}")

finally:
    pass



try:
    # E-ticaret sitesini ziyaret et
    driver.get('https://www.trendyol.com/cep-telefonu-x-c103498')  # Bu URL'yi hedef sitenizle değiştirin
    
    time.sleep(5)
    # Fiyatları çekmek için gerekli elementleri bulun
    fiyatlar = driver.find_elements(By.CLASS_NAME, 'prc-box-dscntd')  # Bu sınıf adı örnek olup, hedef sitenizin HTML yapısına göre değişebilir

    for fiyat in fiyatlar:
        print(f"Telefon Fiyatları: {fiyat.text}")

finally:
    # Tarayıcıyı kapat
    driver.quit()
    