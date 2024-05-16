from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webdriver import WebDriver


class DomPageActions():

    def __init__(self, driver: WebDriver):
        self.driver = driver
        self.xpath = By.XPATH
        self.className = By.CLASS_NAME

    def clica_primeiro_botao(self):
        element = self.driver.find_element(*(self.className, "button"))
        print("Button encontrado: ", element.is_displayed())
        element.click()

    def clica_segundo_botao(self):
        element = self.driver.find_element(*(self.xpath, "//a[contains(@class, 'button alert')]"))
        print("Button Alert encontrado: ", element.is_displayed())
        element.click()

    def clica_terceiro_botao(self):
        element = self.driver.find_element(*(self.xpath, "//a[contains(@class, 'button success')]"))
        print("Button Success encontrado: ", element.is_displayed())
        element.click()

    def clica_em_cada_link_edit(self, qtdLinks: int):
        element = ''
        for number in range(1, qtdLinks + 1):
            element = self.driver.find_element(self.xpath,
                                               "(//a[@href='#edit'][normalize-space()='edit'])[" + str(number) + "]")
            print("Elemento Edit(" + str(number - 1) + ") encontrado: ", element.is_displayed())
            element.click()
            print("Elemento Edit(" + str(number - 1) + ") clicado")

    def clica_em_cada_link_delete(self, qtdLinks: int):
        element = ''
        for number in range(1, qtdLinks + 1):
            element = self.driver.find_element(self.xpath,
                                               "(//a[@href='#edit'][normalize-space()='edit'])[" + str(number) + "]")
            print("Elemento Delete(" + str(number - 1) + ") encontrado: ", element.is_displayed())
            element.click()
            print("Elemento Delete(" + str(number - 1) + ") clicado")
