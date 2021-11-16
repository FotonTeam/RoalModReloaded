package ru.fotontv.royalmod.util;

import austeretony.oxygen_core.client.api.OxygenHelperClient;
import austeretony.oxygen_shop.client.ShopMenuManager;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GuiTask extends TimerTask {

    private final int bank;

    public GuiTask(int bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        completeTask(bank);
    }

    private void completeTask(int bank) {
        OxygenHelperClient.scheduleTask(() -> ShopMenuManager.openShopMenuDelegated(bank), 100L, TimeUnit.MILLISECONDS);
    }
}
