import time

import pytest
from utils.driver_initializer import DriverInitializer
from pages.dom_page_actions import DomPageActions


@pytest.fixture(scope="module")
def driver():
    driver_init = DriverInitializer()
    yield driver_init.get_driver()
    driver_init.quit_driver()


def test_clica_nos_tres_botoes(driver):
    acPage = DomPageActions(driver)
    acPage.clica_primeiro_botao()
    time.sleep(3)
    acPage.clica_segundo_botao()
    time.sleep(3)
    acPage.clica_terceiro_botao()

def test_cliaca_em_todos_botoes_edit(driver):
    acPage = DomPageActions(driver)
    acPage.clica_em_cada_link_edit(10)

def test_cliaca_em_todos_botoes_delete(driver):
    acPage = DomPageActions(driver)
    acPage.clica_em_cada_link_delete(10)