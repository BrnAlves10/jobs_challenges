from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager


class DriverInitializer:

    def __init__(self):
        self.service = Service(ChromeDriverManager().install())
        self.driver = webdriver.Chrome(service=self.service)
        self.driver.maximize_window()
        self.driver.get('http://the-internet.herokuapp.com/challenging_dom')

    def get_driver(self):
        return self.driver

    def quit_driver(self):
        self.driver.quit()