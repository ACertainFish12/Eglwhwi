package it.paranoidsquirrels.idleguildmaster;

public class Formulas
{
    private static final int BASE_MARKET_SPACES = 1;
    private static final int BASE_QUARTERS_SPACES = 2;
    private static final int BASE_STORAGE_SPACES = 35;
    private static final int BASE_TAVERN_SPACES = 1;
    private static final long BASE_TAVERN_VISITOR_INTERVAL = 28800L;
    private static final int BASE_WORKSHOP_SPACES = 1;
    private static final long IMPOSSIBLY_HIGH_PRICE = 99999999999999L;
    
    public static int experienceToNextLevel(int n, final boolean b) {
        final double pow = Math.pow((double)n, 1.4);
        int n2;
        n = (n2 = (int)((3.0 + pow) * 10.0 * pow));
        if (b) {
            n2 = n * 2;
        }
        if (n2 >= 10000) {
            n = n2 / 1000 * 1000;
        }
        else if (n2 >= 1000) {
            n = n2 / 100 * 100;
        }
        else if ((n = n2) >= 100) {
            n = n2 / 10 * 10;
        }
        return n;
    }
    
    public static int foodToNextLevel(final int n) {
        return (int)(Math.pow(1.085, (double)n) * 30.0);
    }
    
    public static long getMarketListingsPrice() {
        return Utils.truncatePrice((long)(Math.pow(4.5, (double)MainActivity.data.getLevelMarketListings()) * 20.0));
    }
    
    public static long getMarketTimePrice() {
        return Utils.truncatePrice((long)(Math.pow(1.7, (double)MainActivity.data.getLevelMarketTime()) * 10.0));
    }
    
    public static int getQuartersCapacity() {
        int starterPackPurchased;
        final int n = starterPackPurchased = (MainActivity.data.isStarterPackPurchased() ? 1 : 0);
        if (MainActivity.data.isAdventurerPackPurchased()) {
            starterPackPurchased = n + 2;
        }
        int n2 = starterPackPurchased;
        if (MainActivity.data.isImperialVanguardPurchased()) {
            n2 = starterPackPurchased + 4;
        }
        int n3 = n2;
        if (MainActivity.data.isUnholyCrusadePurchased()) {
            n3 = n2 + 4;
        }
        return MainActivity.data.getLevelQuarters() + 2 + MainActivity.data.getUpgradeQuarters() + n3;
    }
    
    public static long getQuartersPrice() {
        long n = 0L;
        switch (MainActivity.data.getLevelQuarters()) {
            default: {
                n = 99999999999999L;
                break;
            }
            case 22: {
                n = 10000000L;
                break;
            }
            case 21: {
                n = 9000000L;
                break;
            }
            case 20: {
                n = 8000000L;
                break;
            }
            case 19: {
                n = 7000000L;
                break;
            }
            case 18: {
                n = 6000000L;
                break;
            }
            case 17: {
                n = 5000000L;
                break;
            }
            case 16: {
                n = 4000000L;
                break;
            }
            case 15: {
                n = 3000000L;
                break;
            }
            case 14: {
                n = 2400000L;
                break;
            }
            case 13: {
                n = 1850000L;
                break;
            }
            case 12: {
                n = 1400000L;
                break;
            }
            case 11: {
                n = 1000000L;
                break;
            }
            case 10: {
                n = 700000L;
                break;
            }
            case 9: {
                n = 500000L;
                break;
            }
            case 8: {
                n = 400000L;
                break;
            }
            case 7: {
                n = 300000L;
                break;
            }
            case 6: {
                n = 200000L;
                break;
            }
            case 5: {
                n = 100000L;
                break;
            }
            case 4: {
                n = 40000L;
                break;
            }
            case 3: {
                n = 10000L;
                break;
            }
            case 2: {
                n = 2000L;
                break;
            }
            case 1: {
                n = 275L;
                break;
            }
            case 0: {
                n = 5L;
                break;
            }
        }
        return Utils.truncatePrice(n);
    }
    
    public static long getShelterAutofeedPrice() {
        long n;
        if (MainActivity.data.getLevelShelterAutofeed() > 0) {
            n = 99999999999999L;
        }
        else {
            n = 10000L;
        }
        return Utils.truncatePrice(n);
    }
    
    public static long getShelterPrice() {
        long n = 0L;
        switch (MainActivity.data.getLevelShelter()) {
            default: {
                n = 99999999999999L;
                break;
            }
            case 10: {
                n = 4000000L;
                break;
            }
            case 9: {
                n = 2000000L;
                break;
            }
            case 8: {
                n = 1000000L;
                break;
            }
            case 7: {
                n = 512000L;
                break;
            }
            case 6: {
                n = 256000L;
                break;
            }
            case 5: {
                n = 128000L;
                break;
            }
            case 4: {
                n = 64000L;
                break;
            }
            case 3: {
                n = 32000L;
                break;
            }
            case 2: {
                n = 8000L;
                break;
            }
            case 1: {
                n = 2000L;
                break;
            }
            case 0: {
                n = 500L;
                break;
            }
        }
        return Utils.truncatePrice(n);
    }
    
    public static long getStorageCapacityPrice() {
        final int n = MainActivity.data.getLevelStorage() + 1;
        if (n > 80) {
            return 99999999999999L;
        }
        long n2 = 0L;
        if (n > 60) {
            n2 = 0L + Math.min(n - 60, 20) * 30000L;
        }
        long n3 = n2;
        if (n > 50) {
            n3 = n2 + Math.min(n - 50, 10) * 22000L;
        }
        long n4 = n3;
        if (n > 40) {
            n4 = n3 + Math.min(n - 40, 10) * 12000L;
        }
        long n5 = n4;
        if (n > 30) {
            n5 = n4 + Math.min(n - 30, 10) * 4000L;
        }
        long n6 = n5;
        if (n > 20) {
            n6 = n5 + Math.min(n - 20, 10) * 800L;
        }
        long n7 = n6;
        if (n > 10) {
            n7 = n6 + Math.min(n - 10, 10) * 150L;
        }
        return n7 + Math.min(n, 10) * 50L;
    }
    
    public static int getTavernCapacity() {
        int starterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        if (MainActivity.data.isAdventurerPackPurchased()) {
            starterPackPurchased += 2;
        }
        return MainActivity.data.getLevelTavernCapacity() + 1 + MainActivity.data.getUpgradeTavernCapacity() + starterPackPurchased;
    }
    
    public static long getTavernCapacityPrice() {
        return Utils.truncatePrice((long)(Math.pow(3.0, (double)MainActivity.data.getLevelTavernCapacity()) * 5000.0));
    }
    
    public static long getTavernTimePrice() {
        return Utils.truncatePrice((long)(Math.pow(1.7, (double)MainActivity.data.getLevelTavernTime()) * 200.0));
    }
    
    public static long getTavernVisitorInterval() {
        return (long)(Math.pow(0.9, (double)(MainActivity.data.getLevelTavernTime() + MainActivity.data.getUpgradeTavernTime())) * 28800.0 * 1000.0);
    }
    
    public static long getWorkshopQueuePrice() {
        return Utils.truncatePrice((long)(Math.pow(4.5, (double)MainActivity.data.getLevelWorkshopQueue()) * 20.0));
    }
    
    public static long getWorkshopTimePrice() {
        return Utils.truncatePrice((long)(Math.pow(1.7, (double)MainActivity.data.getLevelWorkshopTime()) * 10.0));
    }
    
    public static int marketListings() {
        int starterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        if (MainActivity.data.isMerchantPackPurchased()) {
            starterPackPurchased += 2;
        }
        return MainActivity.data.getLevelMarketListings() + 1 + MainActivity.data.getUpgradeMarketQueue() + starterPackPurchased;
    }
    
    public static int shelterCapacity() {
        return MainActivity.data.getLevelShelter() + MainActivity.data.getUpgradeShelter() + 2;
    }
    
    public static int storageSpaces() {
        int n;
        if (MainActivity.data.isStarterPackPurchased()) {
            n = 35;
        }
        else {
            n = 0;
        }
        int n2 = n;
        if (MainActivity.data.isAdventurerPackPurchased()) {
            n2 = n + 35;
        }
        int n3 = n2;
        if (MainActivity.data.isMerchantPackPurchased()) {
            n3 = n2 + 70;
        }
        return MainActivity.data.getLevelStorage() + 35 + MainActivity.data.getUpgradeStorage() + n3;
    }
    
    public static int totalStarsToNextLp(final int n) {
        return n * 3 + 4;
    }
    
    public static int workshopQueue() {
        int starterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        if (MainActivity.data.isMerchantPackPurchased()) {
            starterPackPurchased += 2;
        }
        return MainActivity.data.getLevelWorkshopQueue() + 1 + MainActivity.data.getUpgradeWorkshopQueue() + starterPackPurchased;
    }
}
