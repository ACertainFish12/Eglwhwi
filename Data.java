package it.paranoidsquirrels.idleguildmaster.storage.data;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CopyOnWriteArrayList;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheTower;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheSouthernGrove;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheSlimePond;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheLostExpedition;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDreadfulAscent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDireDescent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheDesert;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheCultistRebels;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SleepingPlanet;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.ObsidianMines;
import it.paranoidsquirrels.idleguildmaster.KingMessage;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import java.util.Set;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.Kaunis;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.ImperialRescue;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.HiddenCityOfLarox;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.FrostbitePeaks;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EternalBattlefield;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.DivineArcheology;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.CelestialMothership;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BlackwaterPort;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BarrenWastelands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.AncientGraveDigging;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.List;

public class Data
{
    private int adsWatched;
    private boolean adventurerPackPurchased;
    private List<Adventurer> adventurers;
    private int afflictionLevel;
    private int afflictionProgress;
    private List<Quest> afflictionQuests;
    private int amountOfPurchases;
    private AncientGraveDigging ancientGraveDigging;
    private BarrenWastelands barrenWastelands;
    private BlackwaterPort blackwaterPort;
    private CelestialMothership celestialMothership;
    private List<ItemAction> completedWorkshopItems;
    private int controlLevel;
    private int controlProgress;
    private List<Quest> controlQuests;
    private List<Adventurer> dismissedAdventurers;
    private DivineArcheology divineArcheology;
    private boolean doctrineMaxed;
    private EnchantedForest enchantedForest;
    private EternalBattlefield eternalBattlefield;
    private boolean everAscended;
    private int fortitudeLevel;
    private int fortitudeProgress;
    private List<Quest> fortitudeQuests;
    private FrostbitePeaks frostbitePeaks;
    private long gems;
    private int graceLevel;
    private int graceProgress;
    private List<Quest> graceQuests;
    private HiddenCityOfLarox hiddenCityOfLarox;
    private int illusionLevel;
    private int illusionProgress;
    private List<Quest> illusionQuests;
    private ImperialRescue imperialRescue;
    private boolean imperialVanguardPurchased;
    private boolean intercessionsRetroactivelyGranted;
    private List<Item> items;
    private long itemsCrafted;
    private long itemsSold;
    private Kaunis kaunis;
    private List<Quest> kingsQuests;
    private int knowledgeLevel;
    private int knowledgeProgress;
    private List<Quest> knowledgeQuests;
    private Set<Recipes> knownRecipes;
    private long last24Triggered;
    private long lastAccess;
    private long lastHourTriggered;
    private long lastWeekTriggered;
    private int levelMarketListings;
    private int levelMarketTime;
    private int levelQuarters;
    private int levelShelter;
    private int levelShelterAutofeed;
    private int levelStorage;
    private int levelTavernCapacity;
    private int levelTavernTime;
    private int levelWorkshopQueue;
    private int levelWorkshopTime;
    private LostLands lostLands;
    private List<ItemAction> marketListings;
    private int maxAdventurerTier;
    private int maxAdventurersOwned;
    private long maxWealth;
    private boolean merchantPackPurchased;
    private List<MerchantOffer> merchantRegularStockItems;
    private List<MerchantOffer> merchantSpecialReserve;
    private List<KingMessage> messagesGotten;
    private List<KingMessage> messagesToShow;
    private long money;
    private boolean newMerchantRegularItems;
    private boolean newMerchantSpecialItems;
    private long nextTavernVisit;
    private ObsidianMines obsidianMines;
    private List<Pet> pets;
    private boolean potsMaxed;
    private int questsCompleted;
    private boolean questsRefreshed;
    private boolean questsSeen;
    private boolean redeem_f1r39h15;
    private boolean redeem_g73mfkf4;
    private int redeem_m975nfu5;
    private boolean redeem_potionsRefund1;
    private boolean redeemed_e44opo7z;
    private boolean redeemed_f8hf3045;
    private boolean redeemed_fj9rf8hh;
    private boolean redeemed_g294ps91;
    private boolean redeemed_vre8983y;
    private boolean redeemed_vrw74ync;
    private boolean reviewShown;
    private boolean reviewTrigger;
    private int ruinLevel;
    private int ruinProgress;
    private List<Quest> ruinQuests;
    private Set<String> seenEnemies;
    private Set<String> seenItems;
    private boolean settingAutoOpenDungeonDetail;
    private boolean settingColorblindMode;
    private boolean settingConfirmRetreat;
    private boolean settingConfirmSwap;
    private boolean settingConfirmUpgrade;
    private boolean settingCraftMaxAmount;
    private boolean settingSellMaxAmount;
    private boolean settingVerboseLogs;
    private String settingsLanguage;
    private boolean shownDialogEpicRaid;
    private boolean shownDialogRaid;
    private SleepingPlanet sleepingPlanet;
    private List<ItemAction> soldMarketItems;
    private boolean starterPackPurchased;
    private boolean t4Pet;
    private List<Adventurer> tavernGuests;
    private boolean tavernLocked;
    private TheCultistRebels theCultistRebels;
    private TheDesert theDesert;
    private TheDireDescent theDireDescent;
    private TheDreadfulAscent theDreadfulAscent;
    private TheGoldenCity theGoldenCity;
    private TheLostExpedition theLostExpedition;
    private TheSlimePond theSlimePond;
    private TheSouthernGrove theSouthernGrove;
    private TheTower theTower;
    private long totalGemsPurchased;
    private int tutorialStep;
    private boolean unholyCrusadePurchased;
    private Set<String> uniqueItemsLost;
    private int upgradeMarketQueue;
    private int upgradeMarketTime;
    private int upgradeQuarters;
    private int upgradeShelter;
    private int upgradeStorage;
    private int upgradeTavernCapacity;
    private int upgradeTavernTime;
    private int upgradeWorkshopQueue;
    private int upgradeWorkshopTime;
    private boolean vial2RetGrant;
    private int warLevel;
    private int warProgress;
    private List<Quest> warQuests;
    private List<ItemAction> workshopQueue;
    
    public Data() {
        this.messagesToShow = (List<KingMessage>)new CopyOnWriteArrayList();
        this.messagesGotten = (List<KingMessage>)new CopyOnWriteArrayList();
        this.adventurers = (List<Adventurer>)new CopyOnWriteArrayList();
        this.items = (List<Item>)new CopyOnWriteArrayList();
        this.seenItems = (Set<String>)new CopyOnWriteArraySet();
        this.seenEnemies = (Set<String>)new CopyOnWriteArraySet();
        this.knownRecipes = (Set<Recipes>)new CopyOnWriteArraySet();
        this.uniqueItemsLost = (Set<String>)new CopyOnWriteArraySet();
        this.pets = (List<Pet>)new CopyOnWriteArrayList();
        this.tavernGuests = (List<Adventurer>)new CopyOnWriteArrayList();
        this.dismissedAdventurers = (List<Adventurer>)new CopyOnWriteArrayList();
        this.soldMarketItems = (List<ItemAction>)new CopyOnWriteArrayList();
        this.marketListings = (List<ItemAction>)new CopyOnWriteArrayList();
        this.completedWorkshopItems = (List<ItemAction>)new CopyOnWriteArrayList();
        this.workshopQueue = (List<ItemAction>)new CopyOnWriteArrayList();
        this.merchantRegularStockItems = (List<MerchantOffer>)new CopyOnWriteArrayList();
        this.merchantSpecialReserve = (List<MerchantOffer>)new CopyOnWriteArrayList();
        this.questsSeen = false;
        this.questsRefreshed = false;
        this.kingsQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.afflictionQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.controlQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.fortitudeQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.graceQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.illusionQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.knowledgeQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.ruinQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.warQuests = (List<Quest>)new CopyOnWriteArrayList();
        this.reviewTrigger = false;
        this.reviewShown = false;
        this.redeemed_f8hf3045 = false;
        this.redeemed_g294ps91 = false;
        this.redeemed_vre8983y = false;
        this.redeemed_vrw74ync = false;
        this.redeemed_e44opo7z = false;
        this.redeem_potionsRefund1 = false;
        this.redeem_f1r39h15 = false;
        this.redeem_m975nfu5 = 0;
        this.redeem_g73mfkf4 = false;
        this.redeemed_fj9rf8hh = false;
        this.intercessionsRetroactivelyGranted = false;
        this.vial2RetGrant = false;
        this.messagesToShow.add((Object)KingMessage.MESSAGE_1);
        this.messagesGotten.add((Object)KingMessage.MESSAGE_1);
        this.tutorialStep = 1;
        this.settingsLanguage = "";
        this.settingSellMaxAmount = false;
        this.settingConfirmUpgrade = false;
        this.settingConfirmRetreat = true;
        this.settingConfirmSwap = true;
        this.settingAutoOpenDungeonDetail = true;
        this.settingVerboseLogs = true;
        this.enchantedForest = new EnchantedForest();
        this.theDesert = new TheDesert();
        this.eternalBattlefield = new EternalBattlefield();
        this.theGoldenCity = new TheGoldenCity();
        this.blackwaterPort = new BlackwaterPort();
        this.frostbitePeaks = new FrostbitePeaks();
        this.obsidianMines = new ObsidianMines();
        this.theSouthernGrove = new TheSouthernGrove();
        this.barrenWastelands = new BarrenWastelands();
        this.hiddenCityOfLarox = new HiddenCityOfLarox();
        this.lostLands = new LostLands();
        this.theSlimePond = new TheSlimePond();
        this.divineArcheology = new DivineArcheology();
        this.ancientGraveDigging = new AncientGraveDigging();
        this.imperialRescue = new ImperialRescue();
        this.theCultistRebels = new TheCultistRebels();
        this.theLostExpedition = new TheLostExpedition();
        this.theDreadfulAscent = new TheDreadfulAscent();
        this.celestialMothership = new CelestialMothership();
        this.theDireDescent = new TheDireDescent();
        this.sleepingPlanet = new SleepingPlanet();
        this.kaunis = new Kaunis();
        this.theTower = new TheTower();
        this.enchantedForest.setUnlocked(true);
        this.seenItems.add((Object)"ScarletStrand");
        this.seenItems.add((Object)"Intercession");
        this.seenItems.add((Object)"Dreamcatcher");
        this.seenItems.add((Object)"UpgradeMarketQueue");
        this.seenItems.add((Object)"UpgradeMarketTime");
        this.seenItems.add((Object)"UpgradeQuarters");
        this.seenItems.add((Object)"UpgradeShelter");
        this.seenItems.add((Object)"UpgradeStorage");
        this.seenItems.add((Object)"UpgradeTavernCapacity");
        this.seenItems.add((Object)"UpgradeTavernTime");
        this.seenItems.add((Object)"UpgradeWorkshopQueue");
        this.seenItems.add((Object)"UpgradeWorkshopTime");
        this.seenItems.add((Object)"Evo23Vial2");
    }
    
    public int getAdsWatched() {
        return this.adsWatched;
    }
    
    public List<Adventurer> getAdventurers() {
        return this.adventurers;
    }
    
    public int getAfflictionLevel() {
        return this.afflictionLevel;
    }
    
    public int getAfflictionProgress() {
        return this.afflictionProgress;
    }
    
    public List<Quest> getAfflictionQuests() {
        return this.afflictionQuests;
    }
    
    public int getAmountOfPurchases() {
        return this.amountOfPurchases;
    }
    
    public AncientGraveDigging getAncientGraveDigging() {
        return this.ancientGraveDigging;
    }
    
    public BarrenWastelands getBarrenWastelands() {
        return this.barrenWastelands;
    }
    
    public BlackwaterPort getBlackwaterPort() {
        return this.blackwaterPort;
    }
    
    public CelestialMothership getCelestialMothership() {
        return this.celestialMothership;
    }
    
    public List<ItemAction> getCompletedWorkshopItems() {
        return this.completedWorkshopItems;
    }
    
    public int getControlLevel() {
        return this.controlLevel;
    }
    
    public int getControlProgress() {
        return this.controlProgress;
    }
    
    public List<Quest> getControlQuests() {
        return this.controlQuests;
    }
    
    public List<Adventurer> getDismissedAdventurers() {
        return this.dismissedAdventurers;
    }
    
    public DivineArcheology getDivineArcheology() {
        return this.divineArcheology;
    }
    
    public EnchantedForest getEnchantedForest() {
        return this.enchantedForest;
    }
    
    public EternalBattlefield getEternalBattlefield() {
        return this.eternalBattlefield;
    }
    
    public int getFortitudeLevel() {
        return this.fortitudeLevel;
    }
    
    public int getFortitudeProgress() {
        return this.fortitudeProgress;
    }
    
    public List<Quest> getFortitudeQuests() {
        return this.fortitudeQuests;
    }
    
    public FrostbitePeaks getFrostbitePeaks() {
        return this.frostbitePeaks;
    }
    
    public long getGems() {
        return this.gems;
    }
    
    public int getGraceLevel() {
        return this.graceLevel;
    }
    
    public int getGraceProgress() {
        return this.graceProgress;
    }
    
    public List<Quest> getGraceQuests() {
        return this.graceQuests;
    }
    
    public HiddenCityOfLarox getHiddenCityOfLarox() {
        return this.hiddenCityOfLarox;
    }
    
    public int getIllusionLevel() {
        return this.illusionLevel;
    }
    
    public int getIllusionProgress() {
        return this.illusionProgress;
    }
    
    public List<Quest> getIllusionQuests() {
        return this.illusionQuests;
    }
    
    public ImperialRescue getImperialRescue() {
        return this.imperialRescue;
    }
    
    public List<Item> getItems() {
        return this.items;
    }
    
    public long getItemsCrafted() {
        return this.itemsCrafted;
    }
    
    public long getItemsSold() {
        return this.itemsSold;
    }
    
    public Kaunis getKaunis() {
        return this.kaunis;
    }
    
    public List<Quest> getKingsQuests() {
        return this.kingsQuests;
    }
    
    public int getKnowledgeLevel() {
        return this.knowledgeLevel;
    }
    
    public int getKnowledgeProgress() {
        return this.knowledgeProgress;
    }
    
    public List<Quest> getKnowledgeQuests() {
        return this.knowledgeQuests;
    }
    
    public Set<Recipes> getKnownRecipes() {
        return this.knownRecipes;
    }
    
    public long getLast24Triggered() {
        return this.last24Triggered;
    }
    
    public long getLastAccess() {
        return this.lastAccess;
    }
    
    public long getLastHourTriggered() {
        return this.lastHourTriggered;
    }
    
    public long getLastWeekTriggered() {
        return this.lastWeekTriggered;
    }
    
    public int getLevelMarketListings() {
        return this.levelMarketListings;
    }
    
    public int getLevelMarketTime() {
        return this.levelMarketTime;
    }
    
    public int getLevelQuarters() {
        return this.levelQuarters;
    }
    
    public int getLevelShelter() {
        return this.levelShelter;
    }
    
    public int getLevelShelterAutofeed() {
        return this.levelShelterAutofeed;
    }
    
    public int getLevelStorage() {
        return this.levelStorage;
    }
    
    public int getLevelTavernCapacity() {
        return this.levelTavernCapacity;
    }
    
    public int getLevelTavernTime() {
        return this.levelTavernTime;
    }
    
    public int getLevelWorkshopQueue() {
        return this.levelWorkshopQueue;
    }
    
    public int getLevelWorkshopTime() {
        return this.levelWorkshopTime;
    }
    
    public LostLands getLostLands() {
        return this.lostLands;
    }
    
    public List<ItemAction> getMarketListings() {
        return this.marketListings;
    }
    
    public int getMaxAdventurerTier() {
        return this.maxAdventurerTier;
    }
    
    public int getMaxAdventurersOwned() {
        return this.maxAdventurersOwned;
    }
    
    public long getMaxWealth() {
        return this.maxWealth;
    }
    
    public List<MerchantOffer> getMerchantRegularStockItems() {
        return this.merchantRegularStockItems;
    }
    
    public List<MerchantOffer> getMerchantSpecialReserve() {
        return this.merchantSpecialReserve;
    }
    
    public List<KingMessage> getMessagesGotten() {
        return this.messagesGotten;
    }
    
    public List<KingMessage> getMessagesToShow() {
        return this.messagesToShow;
    }
    
    public long getMoney() {
        return this.money;
    }
    
    public long getNextTavernVisit() {
        return this.nextTavernVisit;
    }
    
    public ObsidianMines getObsidianMines() {
        return this.obsidianMines;
    }
    
    public List<Pet> getPets() {
        return this.pets;
    }
    
    public int getQuestsCompleted() {
        return this.questsCompleted;
    }
    
    public int getRedeem_m975nfu5() {
        return this.redeem_m975nfu5;
    }
    
    public int getRuinLevel() {
        return this.ruinLevel;
    }
    
    public int getRuinProgress() {
        return this.ruinProgress;
    }
    
    public List<Quest> getRuinQuests() {
        return this.ruinQuests;
    }
    
    public Set<String> getSeenEnemies() {
        return this.seenEnemies;
    }
    
    public Set<String> getSeenItems() {
        return this.seenItems;
    }
    
    public String getSettingsLanguage() {
        return this.settingsLanguage;
    }
    
    public SleepingPlanet getSleepingPlanet() {
        return this.sleepingPlanet;
    }
    
    public List<ItemAction> getSoldMarketItems() {
        return this.soldMarketItems;
    }
    
    public List<Adventurer> getTavernGuests() {
        return this.tavernGuests;
    }
    
    public TheCultistRebels getTheCultistRebels() {
        return this.theCultistRebels;
    }
    
    public TheDesert getTheDesert() {
        return this.theDesert;
    }
    
    public TheDireDescent getTheDireDescent() {
        return this.theDireDescent;
    }
    
    public TheDreadfulAscent getTheDreadfulAscent() {
        return this.theDreadfulAscent;
    }
    
    public TheGoldenCity getTheGoldenCity() {
        return this.theGoldenCity;
    }
    
    public TheLostExpedition getTheLostExpedition() {
        return this.theLostExpedition;
    }
    
    public TheSlimePond getTheSlimePond() {
        return this.theSlimePond;
    }
    
    public TheSouthernGrove getTheSouthernGrove() {
        return this.theSouthernGrove;
    }
    
    public TheTower getTheTower() {
        return this.theTower;
    }
    
    public long getTotalGemsPurchased() {
        return this.totalGemsPurchased;
    }
    
    public int getTutorialStep() {
        return this.tutorialStep;
    }
    
    public Set<String> getUniqueItemsLost() {
        return this.uniqueItemsLost;
    }
    
    public int getUpgradeMarketQueue() {
        return this.upgradeMarketQueue;
    }
    
    public int getUpgradeMarketTime() {
        return this.upgradeMarketTime;
    }
    
    public int getUpgradeQuarters() {
        return this.upgradeQuarters;
    }
    
    public int getUpgradeShelter() {
        return this.upgradeShelter;
    }
    
    public int getUpgradeStorage() {
        return this.upgradeStorage;
    }
    
    public int getUpgradeTavernCapacity() {
        return this.upgradeTavernCapacity;
    }
    
    public int getUpgradeTavernTime() {
        return this.upgradeTavernTime;
    }
    
    public int getUpgradeWorkshopQueue() {
        return this.upgradeWorkshopQueue;
    }
    
    public int getUpgradeWorkshopTime() {
        return this.upgradeWorkshopTime;
    }
    
    public int getWarLevel() {
        return this.warLevel;
    }
    
    public int getWarProgress() {
        return this.warProgress;
    }
    
    public List<Quest> getWarQuests() {
        return this.warQuests;
    }
    
    public List<ItemAction> getWorkshopQueue() {
        return this.workshopQueue;
    }
    
    public boolean isAdventurerPackPurchased() {
        return this.adventurerPackPurchased;
    }
    
    public boolean isDoctrineMaxed() {
        return this.doctrineMaxed;
    }
    
    public boolean isEverAscended() {
        return this.everAscended;
    }
    
    public boolean isImperialVanguardPurchased() {
        return this.imperialVanguardPurchased;
    }
    
    public boolean isIntercessionsRetroactivelyGranted() {
        return this.intercessionsRetroactivelyGranted;
    }
    
    public boolean isMerchantPackPurchased() {
        return this.merchantPackPurchased;
    }
    
    public boolean isNewMerchantRegularItems() {
        return this.newMerchantRegularItems;
    }
    
    public boolean isNewMerchantSpecialItems() {
        return this.newMerchantSpecialItems;
    }
    
    public boolean isPotsMaxed() {
        return this.potsMaxed;
    }
    
    public boolean isQuestsRefreshed() {
        return this.questsRefreshed;
    }
    
    public boolean isQuestsSeen() {
        return this.questsSeen;
    }
    
    public boolean isRedeem_f1r39h15() {
        return this.redeem_f1r39h15;
    }
    
    public boolean isRedeem_g73mfkf4() {
        return this.redeem_g73mfkf4;
    }
    
    public boolean isRedeem_potionsRefund1() {
        return this.redeem_potionsRefund1;
    }
    
    public boolean isRedeemed_e44opo7z() {
        return this.redeemed_e44opo7z;
    }
    
    public boolean isRedeemed_f8hf3045() {
        return this.redeemed_f8hf3045;
    }
    
    public boolean isRedeemed_fj9rf8hh() {
        return this.redeemed_fj9rf8hh;
    }
    
    public boolean isRedeemed_g294ps91() {
        return this.redeemed_g294ps91;
    }
    
    public boolean isRedeemed_vre8983y() {
        return this.redeemed_vre8983y;
    }
    
    public boolean isRedeemed_vrw74ync() {
        return this.redeemed_vrw74ync;
    }
    
    public boolean isReviewShown() {
        return this.reviewShown;
    }
    
    public boolean isReviewTrigger() {
        return this.reviewTrigger;
    }
    
    public boolean isSettingAutoOpenDungeonDetail() {
        return this.settingAutoOpenDungeonDetail;
    }
    
    public boolean isSettingColorblindMode() {
        return this.settingColorblindMode;
    }
    
    public boolean isSettingConfirmRetreat() {
        return this.settingConfirmRetreat;
    }
    
    public boolean isSettingConfirmSwap() {
        return this.settingConfirmSwap;
    }
    
    public boolean isSettingConfirmUpgrade() {
        return this.settingConfirmUpgrade;
    }
    
    public boolean isSettingCraftMaxAmount() {
        return this.settingCraftMaxAmount;
    }
    
    public boolean isSettingSellMaxAmount() {
        return this.settingSellMaxAmount;
    }
    
    public boolean isSettingVerboseLogs() {
        return this.settingVerboseLogs;
    }
    
    public boolean isShownDialogEpicRaid() {
        return this.shownDialogEpicRaid;
    }
    
    public boolean isShownDialogRaid() {
        return this.shownDialogRaid;
    }
    
    public boolean isStarterPackPurchased() {
        return this.starterPackPurchased;
    }
    
    public boolean isT4Pet() {
        return this.t4Pet;
    }
    
    public boolean isTavernLocked() {
        return this.tavernLocked;
    }
    
    public boolean isUnholyCrusadePurchased() {
        return this.unholyCrusadePurchased;
    }
    
    public boolean isVial2RetGrant() {
        return this.vial2RetGrant;
    }
    
    public void setAdsWatched(final int adsWatched) {
        this.adsWatched = adsWatched;
    }
    
    public void setAdventurerPackPurchased(final boolean adventurerPackPurchased) {
        this.adventurerPackPurchased = adventurerPackPurchased;
    }
    
    public void setAdventurers(final List<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }
    
    public void setAfflictionLevel(final int afflictionLevel) {
        this.afflictionLevel = afflictionLevel;
    }
    
    public void setAfflictionProgress(final int afflictionProgress) {
        this.afflictionProgress = afflictionProgress;
    }
    
    public void setAfflictionQuests(final List<Quest> afflictionQuests) {
        this.afflictionQuests = afflictionQuests;
    }
    
    public void setAmountOfPurchases(final int amountOfPurchases) {
        this.amountOfPurchases = amountOfPurchases;
    }
    
    public void setAncientGraveDigging(final AncientGraveDigging ancientGraveDigging) {
        this.ancientGraveDigging = ancientGraveDigging;
    }
    
    public void setBarrenWastelands(final BarrenWastelands barrenWastelands) {
        this.barrenWastelands = barrenWastelands;
    }
    
    public void setBlackwaterPort(final BlackwaterPort blackwaterPort) {
        this.blackwaterPort = blackwaterPort;
    }
    
    public void setCelestialMothership(final CelestialMothership celestialMothership) {
        this.celestialMothership = celestialMothership;
    }
    
    public void setCompletedWorkshopItems(final List<ItemAction> completedWorkshopItems) {
        this.completedWorkshopItems = completedWorkshopItems;
    }
    
    public void setControlLevel(final int controlLevel) {
        this.controlLevel = controlLevel;
    }
    
    public void setControlProgress(final int controlProgress) {
        this.controlProgress = controlProgress;
    }
    
    public void setControlQuests(final List<Quest> controlQuests) {
        this.controlQuests = controlQuests;
    }
    
    public void setDismissedAdventurers(final List<Adventurer> dismissedAdventurers) {
        this.dismissedAdventurers = dismissedAdventurers;
    }
    
    public void setDivineArcheology(final DivineArcheology divineArcheology) {
        this.divineArcheology = divineArcheology;
    }
    
    public void setDoctrineMaxed(final boolean doctrineMaxed) {
        this.doctrineMaxed = doctrineMaxed;
    }
    
    public void setEnchantedForest(final EnchantedForest enchantedForest) {
        this.enchantedForest = enchantedForest;
    }
    
    public void setEternalBattlefield(final EternalBattlefield eternalBattlefield) {
        this.eternalBattlefield = eternalBattlefield;
    }
    
    public void setEverAscended(final boolean everAscended) {
        this.everAscended = everAscended;
    }
    
    public void setFortitudeLevel(final int fortitudeLevel) {
        this.fortitudeLevel = fortitudeLevel;
    }
    
    public void setFortitudeProgress(final int fortitudeProgress) {
        this.fortitudeProgress = fortitudeProgress;
    }
    
    public void setFortitudeQuests(final List<Quest> fortitudeQuests) {
        this.fortitudeQuests = fortitudeQuests;
    }
    
    public void setFrostbitePeaks(final FrostbitePeaks frostbitePeaks) {
        this.frostbitePeaks = frostbitePeaks;
    }
    
    public void setGems(final long gems) {
        this.gems = gems;
    }
    
    public void setGraceLevel(final int graceLevel) {
        this.graceLevel = graceLevel;
    }
    
    public void setGraceProgress(final int graceProgress) {
        this.graceProgress = graceProgress;
    }
    
    public void setGraceQuests(final List<Quest> graceQuests) {
        this.graceQuests = graceQuests;
    }
    
    public void setHiddenCityOfLarox(final HiddenCityOfLarox hiddenCityOfLarox) {
        this.hiddenCityOfLarox = hiddenCityOfLarox;
    }
    
    public void setIllusionLevel(final int illusionLevel) {
        this.illusionLevel = illusionLevel;
    }
    
    public void setIllusionProgress(final int illusionProgress) {
        this.illusionProgress = illusionProgress;
    }
    
    public void setIllusionQuests(final List<Quest> illusionQuests) {
        this.illusionQuests = illusionQuests;
    }
    
    public void setImperialRescue(final ImperialRescue imperialRescue) {
        this.imperialRescue = imperialRescue;
    }
    
    public void setImperialVanguardPurchased(final boolean imperialVanguardPurchased) {
        this.imperialVanguardPurchased = imperialVanguardPurchased;
    }
    
    public void setIntercessionsRetroactivelyGranted(final boolean intercessionsRetroactivelyGranted) {
        this.intercessionsRetroactivelyGranted = intercessionsRetroactivelyGranted;
    }
    
    public void setItems(final List<Item> items) {
        this.items = items;
    }
    
    public void setItemsCrafted(final long itemsCrafted) {
        this.itemsCrafted = itemsCrafted;
    }
    
    public void setItemsSold(final long itemsSold) {
        this.itemsSold = itemsSold;
    }
    
    public void setKaunis(final Kaunis kaunis) {
        this.kaunis = kaunis;
    }
    
    public void setKingsQuests(final List<Quest> kingsQuests) {
        this.kingsQuests = kingsQuests;
    }
    
    public void setKnowledgeLevel(final int knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }
    
    public void setKnowledgeProgress(final int knowledgeProgress) {
        this.knowledgeProgress = knowledgeProgress;
    }
    
    public void setKnowledgeQuests(final List<Quest> knowledgeQuests) {
        this.knowledgeQuests = knowledgeQuests;
    }
    
    public void setKnownRecipes(final Set<Recipes> knownRecipes) {
        this.knownRecipes = knownRecipes;
    }
    
    public void setLast24Triggered(final long last24Triggered) {
        this.last24Triggered = last24Triggered;
    }
    
    public void setLastAccess(final long lastAccess) {
        this.lastAccess = lastAccess;
    }
    
    public void setLastHourTriggered(final long lastHourTriggered) {
        this.lastHourTriggered = lastHourTriggered;
    }
    
    public void setLastWeekTriggered(final long lastWeekTriggered) {
        this.lastWeekTriggered = lastWeekTriggered;
    }
    
    public void setLevelMarketListings(final int levelMarketListings) {
        this.levelMarketListings = levelMarketListings;
    }
    
    public void setLevelMarketTime(final int levelMarketTime) {
        this.levelMarketTime = levelMarketTime;
    }
    
    public void setLevelQuarters(final int levelQuarters) {
        this.levelQuarters = levelQuarters;
    }
    
    public void setLevelShelter(final int levelShelter) {
        this.levelShelter = levelShelter;
    }
    
    public void setLevelShelterAutofeed(final int levelShelterAutofeed) {
        this.levelShelterAutofeed = levelShelterAutofeed;
    }
    
    public void setLevelStorage(final int levelStorage) {
        this.levelStorage = levelStorage;
    }
    
    public void setLevelTavernCapacity(final int levelTavernCapacity) {
        this.levelTavernCapacity = levelTavernCapacity;
    }
    
    public void setLevelTavernTime(final int levelTavernTime) {
        this.levelTavernTime = levelTavernTime;
    }
    
    public void setLevelWorkshopQueue(final int levelWorkshopQueue) {
        this.levelWorkshopQueue = levelWorkshopQueue;
    }
    
    public void setLevelWorkshopTime(final int levelWorkshopTime) {
        this.levelWorkshopTime = levelWorkshopTime;
    }
    
    public void setLostLands(final LostLands lostLands) {
        this.lostLands = lostLands;
    }
    
    public void setMarketListings(final List<ItemAction> marketListings) {
        this.marketListings = marketListings;
    }
    
    public void setMaxAdventurerTier(final int maxAdventurerTier) {
        this.maxAdventurerTier = maxAdventurerTier;
    }
    
    public void setMaxAdventurersOwned(final int maxAdventurersOwned) {
        this.maxAdventurersOwned = maxAdventurersOwned;
    }
    
    public void setMaxWealth(final long maxWealth) {
        this.maxWealth = maxWealth;
    }
    
    public void setMerchantPackPurchased(final boolean merchantPackPurchased) {
        this.merchantPackPurchased = merchantPackPurchased;
    }
    
    public void setMerchantRegularStockItems(final List<MerchantOffer> merchantRegularStockItems) {
        this.merchantRegularStockItems = merchantRegularStockItems;
    }
    
    public void setMerchantSpecialReserve(final List<MerchantOffer> merchantSpecialReserve) {
        this.merchantSpecialReserve = merchantSpecialReserve;
    }
    
    public void setMessagesGotten(final List<KingMessage> messagesGotten) {
        this.messagesGotten = messagesGotten;
    }
    
    public void setMessagesToShow(final List<KingMessage> messagesToShow) {
        this.messagesToShow = messagesToShow;
    }
    
    public void setMoney(final long money) {
        this.money = money;
    }
    
    public void setNewMerchantRegularItems(final boolean newMerchantRegularItems) {
        this.newMerchantRegularItems = newMerchantRegularItems;
    }
    
    public void setNewMerchantSpecialItems(final boolean newMerchantSpecialItems) {
        this.newMerchantSpecialItems = newMerchantSpecialItems;
    }
    
    public void setNextTavernVisit(final long nextTavernVisit) {
        this.nextTavernVisit = nextTavernVisit;
    }
    
    public void setObsidianMines(final ObsidianMines obsidianMines) {
        this.obsidianMines = obsidianMines;
    }
    
    public void setPets(final List<Pet> pets) {
        this.pets = pets;
    }
    
    public void setPotsMaxed(final boolean potsMaxed) {
        this.potsMaxed = potsMaxed;
    }
    
    public void setQuestsCompleted(final int questsCompleted) {
        this.questsCompleted = questsCompleted;
    }
    
    public void setQuestsRefreshed(final boolean questsRefreshed) {
        this.questsRefreshed = questsRefreshed;
    }
    
    public void setQuestsSeen(final boolean questsSeen) {
        this.questsSeen = questsSeen;
    }
    
    public void setRedeem_f1r39h15(final boolean redeem_f1r39h15) {
        this.redeem_f1r39h15 = redeem_f1r39h15;
    }
    
    public void setRedeem_g73mfkf4(final boolean redeem_g73mfkf4) {
        this.redeem_g73mfkf4 = redeem_g73mfkf4;
    }
    
    public void setRedeem_m975nfu5(final int redeem_m975nfu5) {
        this.redeem_m975nfu5 = redeem_m975nfu5;
    }
    
    public void setRedeem_potionsRefund1(final boolean redeem_potionsRefund1) {
        this.redeem_potionsRefund1 = redeem_potionsRefund1;
    }
    
    public void setRedeemed_e44opo7z(final boolean redeemed_e44opo7z) {
        this.redeemed_e44opo7z = redeemed_e44opo7z;
    }
    
    public void setRedeemed_f8hf3045(final boolean redeemed_f8hf3045) {
        this.redeemed_f8hf3045 = redeemed_f8hf3045;
    }
    
    public void setRedeemed_fj9rf8hh(final boolean redeemed_fj9rf8hh) {
        this.redeemed_fj9rf8hh = redeemed_fj9rf8hh;
    }
    
    public void setRedeemed_g294ps91(final boolean redeemed_g294ps91) {
        this.redeemed_g294ps91 = redeemed_g294ps91;
    }
    
    public void setRedeemed_vre8983y(final boolean redeemed_vre8983y) {
        this.redeemed_vre8983y = redeemed_vre8983y;
    }
    
    public void setRedeemed_vrw74ync(final boolean redeemed_vrw74ync) {
        this.redeemed_vrw74ync = redeemed_vrw74ync;
    }
    
    public void setReviewShown(final boolean reviewShown) {
        this.reviewShown = reviewShown;
    }
    
    public void setReviewTrigger(final boolean reviewTrigger) {
        this.reviewTrigger = reviewTrigger;
    }
    
    public void setRuinLevel(final int ruinLevel) {
        this.ruinLevel = ruinLevel;
    }
    
    public void setRuinProgress(final int ruinProgress) {
        this.ruinProgress = ruinProgress;
    }
    
    public void setRuinQuests(final List<Quest> ruinQuests) {
        this.ruinQuests = ruinQuests;
    }
    
    public void setSeenEnemies(final Set<String> seenEnemies) {
        this.seenEnemies = seenEnemies;
    }
    
    public void setSeenItems(final Set<String> seenItems) {
        this.seenItems = seenItems;
    }
    
    public void setSettingAutoOpenDungeonDetail(final boolean settingAutoOpenDungeonDetail) {
        this.settingAutoOpenDungeonDetail = settingAutoOpenDungeonDetail;
    }
    
    public void setSettingColorblindMode(final boolean settingColorblindMode) {
        this.settingColorblindMode = settingColorblindMode;
    }
    
    public void setSettingConfirmRetreat(final boolean settingConfirmRetreat) {
        this.settingConfirmRetreat = settingConfirmRetreat;
    }
    
    public void setSettingConfirmSwap(final boolean settingConfirmSwap) {
        this.settingConfirmSwap = settingConfirmSwap;
    }
    
    public void setSettingConfirmUpgrade(final boolean settingConfirmUpgrade) {
        this.settingConfirmUpgrade = settingConfirmUpgrade;
    }
    
    public void setSettingCraftMaxAmount(final boolean settingCraftMaxAmount) {
        this.settingCraftMaxAmount = settingCraftMaxAmount;
    }
    
    public void setSettingSellMaxAmount(final boolean settingSellMaxAmount) {
        this.settingSellMaxAmount = settingSellMaxAmount;
    }
    
    public void setSettingVerboseLogs(final boolean settingVerboseLogs) {
        this.settingVerboseLogs = settingVerboseLogs;
    }
    
    public void setSettingsLanguage(final String settingsLanguage) {
        this.settingsLanguage = settingsLanguage;
    }
    
    public void setShownDialogEpicRaid(final boolean shownDialogEpicRaid) {
        this.shownDialogEpicRaid = shownDialogEpicRaid;
    }
    
    public void setShownDialogRaid(final boolean shownDialogRaid) {
        this.shownDialogRaid = shownDialogRaid;
    }
    
    public void setSleepingPlanet(final SleepingPlanet sleepingPlanet) {
        this.sleepingPlanet = sleepingPlanet;
    }
    
    public void setSoldMarketItems(final List<ItemAction> soldMarketItems) {
        this.soldMarketItems = soldMarketItems;
    }
    
    public void setStarterPackPurchased(final boolean starterPackPurchased) {
        this.starterPackPurchased = starterPackPurchased;
    }
    
    public void setT4Pet(final boolean t4Pet) {
        this.t4Pet = t4Pet;
    }
    
    public void setTavernGuests(final List<Adventurer> tavernGuests) {
        this.tavernGuests = tavernGuests;
    }
    
    public void setTavernLocked(final boolean tavernLocked) {
        this.tavernLocked = tavernLocked;
    }
    
    public void setTheCultistRebels(final TheCultistRebels theCultistRebels) {
        this.theCultistRebels = theCultistRebels;
    }
    
    public void setTheDesert(final TheDesert theDesert) {
        this.theDesert = theDesert;
    }
    
    public void setTheDireDescent(final TheDireDescent theDireDescent) {
        this.theDireDescent = theDireDescent;
    }
    
    public void setTheDreadfulAscent(final TheDreadfulAscent theDreadfulAscent) {
        this.theDreadfulAscent = theDreadfulAscent;
    }
    
    public void setTheGoldenCity(final TheGoldenCity theGoldenCity) {
        this.theGoldenCity = theGoldenCity;
    }
    
    public void setTheLostExpedition(final TheLostExpedition theLostExpedition) {
        this.theLostExpedition = theLostExpedition;
    }
    
    public void setTheSlimePond(final TheSlimePond theSlimePond) {
        this.theSlimePond = theSlimePond;
    }
    
    public void setTheSouthernGrove(final TheSouthernGrove theSouthernGrove) {
        this.theSouthernGrove = theSouthernGrove;
    }
    
    public void setTheTower(final TheTower theTower) {
        this.theTower = theTower;
    }
    
    public void setTotalGemsPurchased(final long totalGemsPurchased) {
        this.totalGemsPurchased = totalGemsPurchased;
    }
    
    public void setTutorialStep(final int tutorialStep) {
        this.tutorialStep = tutorialStep;
    }
    
    public void setUnholyCrusadePurchased(final boolean unholyCrusadePurchased) {
        this.unholyCrusadePurchased = unholyCrusadePurchased;
    }
    
    public void setUniqueItemsLost(final Set<String> uniqueItemsLost) {
        this.uniqueItemsLost = uniqueItemsLost;
    }
    
    public void setUpgradeMarketQueue(final int upgradeMarketQueue) {
        this.upgradeMarketQueue = upgradeMarketQueue;
    }
    
    public void setUpgradeMarketTime(final int upgradeMarketTime) {
        this.upgradeMarketTime = upgradeMarketTime;
    }
    
    public void setUpgradeQuarters(final int upgradeQuarters) {
        this.upgradeQuarters = upgradeQuarters;
    }
    
    public void setUpgradeShelter(final int upgradeShelter) {
        this.upgradeShelter = upgradeShelter;
    }
    
    public void setUpgradeStorage(final int upgradeStorage) {
        this.upgradeStorage = upgradeStorage;
    }
    
    public void setUpgradeTavernCapacity(final int upgradeTavernCapacity) {
        this.upgradeTavernCapacity = upgradeTavernCapacity;
    }
    
    public void setUpgradeTavernTime(final int upgradeTavernTime) {
        this.upgradeTavernTime = upgradeTavernTime;
    }
    
    public void setUpgradeWorkshopQueue(final int upgradeWorkshopQueue) {
        this.upgradeWorkshopQueue = upgradeWorkshopQueue;
    }
    
    public void setUpgradeWorkshopTime(final int upgradeWorkshopTime) {
        this.upgradeWorkshopTime = upgradeWorkshopTime;
    }
    
    public void setVial2RetGrant(final boolean vial2RetGrant) {
        this.vial2RetGrant = vial2RetGrant;
    }
    
    public void setWarLevel(final int warLevel) {
        this.warLevel = warLevel;
    }
    
    public void setWarProgress(final int warProgress) {
        this.warProgress = warProgress;
    }
    
    public void setWarQuests(final List<Quest> warQuests) {
        this.warQuests = warQuests;
    }
    
    public void setWorkshopQueue(final List<ItemAction> workshopQueue) {
        this.workshopQueue = workshopQueue;
    }
}
