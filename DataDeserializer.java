package it.paranoidsquirrels.idleguildmaster.storage.data;

import com.google.gson.JsonParseException;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheTower;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.Kaunis;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SleepingPlanet;;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheredeemDireDescent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.CelestialMothership;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDreadfulAscent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheLostExpedition;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheCultistRebels;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.ImperialRescue;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.AncientGraveDigging;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.DivineArcheology;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheSlimePond;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.HiddenCityOfLarox;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BarrenWastelands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheSouthernGrove;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.ObsidianMines;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.FrostbitePeaks;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BlackwaterPort;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EternalBattlefield;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheDesert;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.KingMessage;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import java.util.concurrent.CopyOnWriteArrayList;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import java.util.List;
import java.util.Iterator;
import com.google.gson.JsonArray;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Action;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap;
import com.google.gson.JsonElement;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;

public class DataDeserializer implements JsonDeserializer<Data>
{
    private Data data;
    
    private Adventurer getAdventurer(final JsonObject jsonObject) {
        final boolean has = jsonObject.has("weapon");
        Doctrine doctrine = null;
        Weapon weapon;
        if (has) {
            weapon = (Weapon)this.getItem(jsonObject.get("weapon").getAsJsonObject());
        }
        else {
            weapon = null;
        }
        Armor armor;
        if (jsonObject.has("armor")) {
            armor = (Armor)this.getItem(jsonObject.get("armor").getAsJsonObject());
        }
        else {
            armor = null;
        }
        Accessory accessory;
        if (jsonObject.has("accessory")) {
            accessory = (Accessory)this.getItem(jsonObject.get("accessory").getAsJsonObject());
        }
        else {
            accessory = null;
        }
        final String asString = jsonObject.get("trueClass").getAsString();
        final int asInt = jsonObject.get("id").getAsInt();
        final int asInt2 = jsonObject.get("level").getAsInt();
        final int asInt3 = jsonObject.get("experience").getAsInt();
        Trait fromString;
        if (jsonObject.has("traitCommon")) {
            fromString = Trait.fromString(jsonObject.get("traitCommon").getAsString());
        }
        else {
            fromString = null;
        }
        Trait fromString2;
        if (jsonObject.has("traitRare")) {
            fromString2 = Trait.fromString(jsonObject.get("traitRare").getAsString());
        }
        else {
            fromString2 = null;
        }
        PotionsDrank potionsDrank;
        if (jsonObject.has("potionsDrank")) {
            potionsDrank = this.getPotionsDrank(jsonObject.get("potionsDrank").getAsJsonObject());
        }
        else {
            potionsDrank = new PotionsDrank();
        }
        if (jsonObject.has("doctrine")) {
            doctrine = this.getDoctrine(jsonObject.get("doctrine").getAsJsonObject());
        }
        final boolean has2 = jsonObject.has("ascended");
        int asInt4 = 0;
        final Adventurer instance = Adventurer.getInstance(asString, asInt, asInt2, asInt3, weapon, armor, accessory, fromString, fromString2, potionsDrank, doctrine, has2 && jsonObject.get("ascended").getAsBoolean());
        instance.setCurrentHp(jsonObject.get("currentHp").getAsInt());
        instance.setCurrentMana(jsonObject.get("currentMana").getAsInt());
        if (jsonObject.has("currentShield")) {
            asInt4 = jsonObject.get("currentShield").getAsInt();
        }
        instance.setCurrentShield(asInt4);
        instance.setPositiveStatusEffects(this.getEffects(jsonObject.get("positiveStatusEffects").getAsJsonArray()));
        instance.setNegativeStatusEffects(this.getEffects(jsonObject.get("negativeStatusEffects").getAsJsonArray()));
        instance.setSeen(jsonObject.get("seen").getAsBoolean());
        instance.setTimeWhenDismissed(jsonObject.get("timeWhenDismissed").getAsLong());
        return instance;
    }
    
    private <T extends Area> T getArea(final Class<T> clazz, JsonObject asJsonObject, final String s) {
        final Integer n = null;
        try {
            final Area area = clazz.newInstance();
            if (!asJsonObject.has(s)) {
                return (T)area;
            }
            asJsonObject = asJsonObject.get(s).getAsJsonObject();
            try {
                final JsonArray asJsonArray = asJsonObject.get("adventurersExploringIds").getAsJsonArray();
                final Iterator iterator = asJsonArray.iterator();
                while (iterator.hasNext()) {
                    area.getAdventurersExploringIds().add((Object)((JsonElement)iterator.next()).getAsInt());
                }
                final Iterator iterator2 = asJsonObject.get("savedAdventurersIds").getAsJsonArray().iterator();
                while (iterator2.hasNext()) {
                    area.getSavedAdventurersIds().add((Object)((JsonElement)iterator2.next()).getAsInt());
                }
                Integer value;
                if (asJsonObject.has("petExploringId")) {
                    value = asJsonObject.get("petExploringId").getAsInt();
                }
                else {
                    value = null;
                }
                area.setPetExploringId(value);
                Integer value2;
                if (asJsonObject.has("savedPetId")) {
                    value2 = asJsonObject.get("savedPetId").getAsInt();
                }
                else {
                    value2 = null;
                }
                area.setSavedPetId(value2);
                final Iterator iterator3 = asJsonObject.get("drops").getAsJsonArray().iterator();
                while (iterator3.hasNext()) {
                    area.getDrops().add((Object)this.getItem(((JsonElement)iterator3.next()).getAsJsonObject()));
                }
                area.setProgress(asJsonObject.get("progress").getAsInt());
                area.setMaxProgress(asJsonObject.get("maxProgress").getAsInt());
                area.setUnlocked(asJsonObject.get("unlocked").getAsBoolean());
                area.setTriesAvailable(asJsonObject.get("triesAvailable").getAsBoolean());
                final AdventureRecap adventureRecap = new AdventureRecap();
                if (asJsonObject.has("adventureRecap")) {
                    final JsonObject asJsonObject2 = asJsonObject.get("adventureRecap").getAsJsonObject();
                    adventureRecap.setSecondsPassed(asJsonObject2.get("secondsPassed").getAsInt());
                    adventureRecap.setAreasCleared(asJsonObject2.get("areasCleared").getAsInt());
                    adventureRecap.setWiped(asJsonObject2.get("wiped").getAsInt());
                    adventureRecap.setExpEarned(asJsonObject2.get("expEarned").getAsInt());
                    adventureRecap.setExpLost(asJsonObject2.get("expLost").getAsInt());
                    if (asJsonObject2.has("enemiesKilled")) {
                        final Iterator iterator4 = asJsonObject2.get("enemiesKilled").getAsJsonArray().iterator();
                        while (iterator4.hasNext()) {
                            adventureRecap.getEnemiesKilled().add((Object)this.getEnemyCounter(((JsonElement)iterator4.next()).getAsJsonObject()));
                        }
                    }
                }
                area.setAdventureRecap(adventureRecap);
                if (asJsonArray.size() > 0) {
                    final Iterator iterator5 = asJsonObject.get("enemies").getAsJsonArray().iterator();
                    while (iterator5.hasNext()) {
                        area.getEnemies().add((Object)this.getEnemy(((JsonElement)iterator5.next()).getAsJsonObject()));
                    }
                    final Iterator iterator6 = asJsonObject.get("corpses").getAsJsonArray().iterator();
                    while (iterator6.hasNext()) {
                        area.getCorpses().add((Object)this.getEnemy(((JsonElement)iterator6.next()).getAsJsonObject()));
                    }
                    final JsonObject asJsonObject3 = asJsonObject.get("action").getAsJsonObject();
                    final Action action = new Action(asJsonObject3.get("type").getAsInt());
                    action.setTurnsPassed(asJsonObject3.get("turnsPassed").getAsInt());
                    area.setAction(action);
                    area.setupAdventurers(this.data.getAdventurers(), this.data.getPets());
                    Integer value3;
                    if (asJsonObject.has("savedActingEntity") ^ true) {
                        value3 = n;
                    }
                    else {
                        value3 = asJsonObject.get("savedActingEntity").getAsInt();
                    }
                    area.setSavedActingEntity(value3);
                    area.setTurnsFighting(asJsonObject.get("turnsFighting").getAsInt());
                    if (asJsonObject.has("event")) {
                        final JsonObject asJsonObject4 = asJsonObject.get("event").getAsJsonObject();
                        final Event event = new Event();
                        event.setKey(asJsonObject4.get("key").getAsInt());
                        event.setProgress(asJsonObject4.get("progress").getAsInt());
                        area.setEvent(event);
                    }
                }
                area.setupInitialDarkness();
                return (T)area;
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return (T)area;
            }
        }
        catch (final Exception ex2) {
            ex2.printStackTrace();
            return null;
        }
    }
    
    private Doctrine getDoctrine(final JsonObject jsonObject) {
        try {
            return Doctrine.getInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("l1").getAsInt(), jsonObject.get("l2").getAsInt(), jsonObject.get("l3").getAsInt(), jsonObject.get("l4").getAsInt(), jsonObject.get("l5").getAsInt(), jsonObject.get("l6").getAsInt());
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    private List<StatusEffect> getEffects(final JsonArray jsonArray) {
        final CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        final Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            final JsonObject asJsonObject = ((JsonElement)iterator.next()).getAsJsonObject();
            final StatusEffectType value = StatusEffectType.valueOf(asJsonObject.get("type").getAsString());
            if (!value.serialized) {
                continue;
            }
            ((List)list).add((Object)new StatusEffect(value, null, asJsonObject.get("turnsLeft").getAsInt(), 0.0));
        }
        return (List<StatusEffect>)list;
    }
    
    private Enemy getEnemy(final JsonObject jsonObject) {
        final Enemy instance = Enemy.getInstance(jsonObject.get("trueClass").getAsString());
        instance.setCurrentHp(jsonObject.get("currentHp").getAsInt());
        instance.setCurrentMana(jsonObject.get("currentMana").getAsInt());
        int asInt;
        if (jsonObject.has("currentShield")) {
            asInt = jsonObject.get("currentShield").getAsInt();
        }
        else {
            asInt = 0;
        }
        instance.setCurrentShield(asInt);
        instance.setPositiveStatusEffects((List)this.getEffects(jsonObject.get("positiveStatusEffects").getAsJsonArray()));
        instance.setNegativeStatusEffects((List)this.getEffects(jsonObject.get("negativeStatusEffects").getAsJsonArray()));
        return instance;
    }
    
    private EnemyCounter getEnemyCounter(final JsonObject jsonObject) {
        return new EnemyCounter(jsonObject.get("enemy").getAsString(), jsonObject.get("timesSlain").getAsInt());
    }
    
    private Item getItem(final JsonObject jsonObject) {
        return Item.getInstance(jsonObject.get("trueClass").getAsString(), Math.max(jsonObject.get("stack").getAsInt(), 1));
    }
    
    private ItemAction getItemAction(final JsonObject jsonObject) {
        final ItemAction itemAction = new ItemAction(this.getItem(jsonObject.get("item").getAsJsonObject()));
        itemAction.setSecondsPassed(jsonObject.get("secondsPassed").getAsLong());
        return itemAction;
    }
    
    private MerchantOffer getMerchantOffer(final JsonObject jsonObject) {
        final MerchantOffer merchantOffer = new MerchantOffer(this.getItem(jsonObject.get("item").getAsJsonObject()));
        merchantOffer.setPrice(jsonObject.get("price").getAsLong());
        merchantOffer.setGems(jsonObject.get("gems").getAsBoolean());
        return merchantOffer;
    }
    
    private Pet getPet(final JsonObject jsonObject) {
        final Pet instance = Pet.getInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("id").getAsInt(), jsonObject.get("level").getAsInt(), jsonObject.get("food").getAsInt(), PetAbility.fromString(jsonObject.get("petAbility1").getAsString()), PetAbility.fromString(jsonObject.get("petAbility2").getAsString()), PetAbility.fromString(jsonObject.get("petAbility3").getAsString()), PetAbility.fromString(jsonObject.get("petAbility4").getAsString()));
        instance.setFavourite(jsonObject.get("favourite").getAsBoolean());
        return instance;
    }
    
    private PotionsDrank getPotionsDrank(final JsonObject jsonObject) {
        try {
            return new PotionsDrank(jsonObject.get("potionOfConstitutionDrank").getAsInt(), jsonObject.get("potionOfDexterityDrank").getAsInt(), jsonObject.get("potionOfIntelligenceDrank").getAsInt(), jsonObject.get("potionOfHealthDrank").getAsInt(), jsonObject.get("potionOfDefenseDrank").getAsInt(), jsonObject.get("potionOfMagicDefenseDrank").getAsInt(), jsonObject.get("potionOfPrecisionDrank").getAsInt(), jsonObject.get("potionOfViciousnessDrank").getAsInt(), jsonObject.get("potionOfDarknessDrank").getAsInt(), jsonObject.get("potionOfImmunityDrank").getAsInt(), jsonObject.get("potionOfAgilityDrank").getAsInt());
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return new PotionsDrank();
        }
    }
    
    private Quest getQuest(final JsonObject jsonObject) {
        try {
            return Quest.loadInstance(jsonObject.get("trueClass").getAsString(), jsonObject.get("rarity").getAsInt(), jsonObject.get("targetProgress").getAsInt(), jsonObject.get("progress").getAsInt());
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public Data deserialize(JsonElement asJsonObject, Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        asJsonObject = (JsonElement)asJsonObject.getAsJsonObject();
        (this.data = new Data()).setLastAccess(((JsonObject)asJsonObject).get("lastAccess").getAsLong());
        this.data.setTutorialStep(((JsonObject)asJsonObject).get("tutorialStep").getAsInt());
        this.data.setNextTavernVisit(((JsonObject)asJsonObject).get("nextTavernVisit").getAsLong());
        this.data.setTavernLocked(((JsonObject)asJsonObject).get("tavernLocked").getAsBoolean());
        this.data.getMessagesToShow().clear();
        final Iterator iterator = ((JsonObject)asJsonObject).get("messagesToShow").getAsJsonArray().iterator();
        while (iterator.hasNext()) {
            this.data.getMessagesToShow().add((Object)KingMessage.valueOf(((JsonElement)iterator.next()).getAsString()));
        }
        this.data.getMessagesGotten().clear();
        final Iterator iterator2 = ((JsonObject)asJsonObject).get("messagesGotten").getAsJsonArray().iterator();
        while (iterator2.hasNext()) {
            this.data.getMessagesGotten().add((Object)KingMessage.valueOf(((JsonElement)iterator2.next()).getAsString()));
        }
        this.data.setMoney(((JsonObject)asJsonObject).get("money").getAsLong());
        this.data.setGems(((JsonObject)asJsonObject).get("gems").getAsLong());
        this.data.setLevelQuarters(((JsonObject)asJsonObject).get("levelQuarters").getAsInt());
        this.data.setLevelTavernCapacity(((JsonObject)asJsonObject).get("levelTavernCapacity").getAsInt());
        this.data.setLevelTavernTime(((JsonObject)asJsonObject).get("levelTavernTime").getAsInt());
        this.data.setLevelStorage(((JsonObject)asJsonObject).get("levelStorage").getAsInt());
        this.data.setLevelMarketListings(((JsonObject)asJsonObject).get("levelMarketListings").getAsInt());
        this.data.setLevelMarketTime(((JsonObject)asJsonObject).get("levelMarketTime").getAsInt());
        this.data.setLevelWorkshopQueue(((JsonObject)asJsonObject).get("levelWorkshopQueue").getAsInt());
        this.data.setLevelWorkshopTime(((JsonObject)asJsonObject).get("levelWorkshopTime").getAsInt());
        final Data data = this.data;
        final boolean has = ((JsonObject)asJsonObject).has("levelShelter");
        final boolean b = false;
        int asInt;
        if (has) {
            asInt = ((JsonObject)asJsonObject).get("levelShelter").getAsInt();
        }
        else {
            asInt = 0;
        }
        data.setLevelShelter(asInt);
        final Data data2 = this.data;
        int asInt2;
        if (((JsonObject)asJsonObject).has("levelShelterAutofeed")) {
            asInt2 = ((JsonObject)asJsonObject).get("levelShelterAutofeed").getAsInt();
        }
        else {
            asInt2 = 0;
        }
        data2.setLevelShelterAutofeed(asInt2);
        final Data data3 = this.data;
        int asInt3;
        if (((JsonObject)asJsonObject).has("upgradeMarketQueue")) {
            asInt3 = ((JsonObject)asJsonObject).get("upgradeMarketQueue").getAsInt();
        }
        else {
            asInt3 = 0;
        }
        data3.setUpgradeMarketQueue(asInt3);
        final Data data4 = this.data;
        int asInt4;
        if (((JsonObject)asJsonObject).has("upgradeMarketTime")) {
            asInt4 = ((JsonObject)asJsonObject).get("upgradeMarketTime").getAsInt();
        }
        else {
            asInt4 = 0;
        }
        data4.setUpgradeMarketTime(asInt4);
        final Data data5 = this.data;
        int asInt5;
        if (((JsonObject)asJsonObject).has("upgradeQuarters")) {
            asInt5 = ((JsonObject)asJsonObject).get("upgradeQuarters").getAsInt();
        }
        else {
            asInt5 = 0;
        }
        data5.setUpgradeQuarters(asInt5);
        final Data data6 = this.data;
        int asInt6;
        if (((JsonObject)asJsonObject).has("upgradeShelter")) {
            asInt6 = ((JsonObject)asJsonObject).get("upgradeShelter").getAsInt();
        }
        else {
            asInt6 = 0;
        }
        data6.setUpgradeShelter(asInt6);
        final Data data7 = this.data;
        int asInt7;
        if (((JsonObject)asJsonObject).has("upgradeStorage")) {
            asInt7 = ((JsonObject)asJsonObject).get("upgradeStorage").getAsInt();
        }
        else {
            asInt7 = 0;
        }
        data7.setUpgradeStorage(asInt7);
        final Data data8 = this.data;
        int asInt8;
        if (((JsonObject)asJsonObject).has("upgradeTavernCapacity")) {
            asInt8 = ((JsonObject)asJsonObject).get("upgradeTavernCapacity").getAsInt();
        }
        else {
            asInt8 = 0;
        }
        data8.setUpgradeTavernCapacity(asInt8);
        final Data data9 = this.data;
        int asInt9;
        if (((JsonObject)asJsonObject).has("upgradeTavernTime")) {
            asInt9 = ((JsonObject)asJsonObject).get("upgradeTavernTime").getAsInt();
        }
        else {
            asInt9 = 0;
        }
        data9.setUpgradeTavernTime(asInt9);
        final Data data10 = this.data;
        int asInt10;
        if (((JsonObject)asJsonObject).has("upgradeWorkshopQueue")) {
            asInt10 = ((JsonObject)asJsonObject).get("upgradeWorkshopQueue").getAsInt();
        }
        else {
            asInt10 = 0;
        }
        data10.setUpgradeWorkshopQueue(asInt10);
        final Data data11 = this.data;
        int asInt11;
        if (((JsonObject)asJsonObject).has("upgradeWorkshopTime")) {
            asInt11 = ((JsonObject)asJsonObject).get("upgradeWorkshopTime").getAsInt();
        }
        else {
            asInt11 = 0;
        }
        data11.setUpgradeWorkshopTime(asInt11);
        final Iterator iterator3 = ((JsonObject)asJsonObject).get("adventurers").getAsJsonArray().iterator();
        while (iterator3.hasNext()) {
            this.data.getAdventurers().add((Object)this.getAdventurer(((JsonElement)iterator3.next()).getAsJsonObject()));
        }
        final Iterator iterator4 = ((JsonObject)asJsonObject).get("items").getAsJsonArray().iterator();
        while (iterator4.hasNext()) {
            this.data.getItems().add((Object)this.getItem(((JsonElement)iterator4.next()).getAsJsonObject()));
        }
        final Iterator iterator5 = ((JsonObject)asJsonObject).get("seenItems").getAsJsonArray().iterator();
        while (iterator5.hasNext()) {
            this.data.getSeenItems().add((Object)((JsonElement)iterator5.next()).getAsString());
        }
        if (((JsonObject)asJsonObject).has("seenEnemies")) {
            final Iterator iterator6 = ((JsonObject)asJsonObject).get("seenEnemies").getAsJsonArray().iterator();
            while (iterator6.hasNext()) {
                this.data.getSeenEnemies().add((Object)((JsonElement)iterator6.next()).getAsString());
            }
        }
        type = (Type)((JsonObject)asJsonObject).get("knownRecipes").getAsJsonArray().iterator();
        JsonElement jsonElement;
        boolean potsMaxed;
        long asLong;
        int asInt12;
        long asLong2;
        Iterator iterator7;
        int asInt13;
        Iterator iterator8;
        long n;
        long asLong3;
        Iterator iterator9;
        Iterator iterator10;
        int asInt14;
        Quest quest;
        long asLong4;
        int asInt15;
        int asInt16;
        long asLong5;
        int asInt17;
        int asInt18;
        int asInt19;
        Iterator iterator11;
        Iterator iterator12;
        int asInt20;
        int asInt21;
        int asInt22;
        int asInt23;
        int asInt24;
        Iterator iterator13;
        Iterator iterator14;
        int asInt25;
        Iterator iterator15;
        int asInt26;
        int asInt27;
        int asInt28;
        int asInt29;
        Quest quest2;
        Iterator iterator16;
        Iterator iterator17;
        int asInt30;
        Quest quest3;
        Quest quest4;
        int asInt31;
        int asInt32;
        boolean has2;
        Block_139_Outer:Label_3047_Outer:Block_71_Outer:Label_2701_Outer:Label_1530_Outer:Label_4131_Outer:Label_3331_Outer:Label_3741_Outer:
        while (true) {
            Label_1111: {
                if (!((Iterator)type).hasNext()) {
                    break Label_1111;
                }
                jsonElement = (JsonElement)((Iterator)type).next();
                try {
                    this.data.getKnownRecipes().add((Object)Recipes.valueOf(jsonElement.getAsString()));
                    continue Block_139_Outer;
                Label_3741:
                    while (true) {
                    Label_3331:
                        while (true) {
                        Label_4131:
                            while (true) {
                                Label_4170:Label_3402_Outer:Label_3702_Outer:Label_1644_Outer:
                                while (true) {
                                    Label_1644:Block_130_Outer:
                                    while (true) {
                                        Block_32: {
                                            while (true) {
                                                Label_4424: {
                                                    while (true) {
                                                        Block_110: {
                                                            Label_3402:Label_3189_Outer:
                                                            while (true) {
                                                            Label_2655:
                                                                while (true) {
                                                                Block_112_Outer:
                                                                    while (true) {
                                                                    Block_26_Outer:
                                                                        while (true) {
                                                                            while (true) {
                                                                                Label_3189:Label_3780_Outer:
                                                                                while (true) {
                                                                                    Block_92: {
                                                                                    Label_3780:
                                                                                        while (true) {
                                                                                        Label_1530:
                                                                                            while (true) {
                                                                                            Label_4092_Outer:
                                                                                                while (true) {
                                                                                                    Label_4092:Label_3819_Outer:
                                                                                                    while (true) {
                                                                                                    Label_3819:
                                                                                                        while (true) {
                                                                                                        Label_2701:
                                                                                                            while (true) {
                                                                                                            Label_4209:
                                                                                                                while (true) {
                                                                                                                    Block_123: {
                                                                                                                        while (true) {
                                                                                                                        Label_4053:
                                                                                                                            while (true) {
                                                                                                                                Block_119: {
                                                                                                                                    while (true) {
                                                                                                                                    Label_3975:
                                                                                                                                        while (true) {
                                                                                                                                            Block_117: {
                                                                                                                                                while (true) {
                                                                                                                                                    Label_4463: {
                                                                                                                                                        while (true) {
                                                                                                                                                            Label_1416:Label_4385_Outer:
                                                                                                                                                            while (true) {
                                                                                                                                                                Label_4385:Block_90_Outer:
                                                                                                                                                                while (true) {
                                                                                                                                                                    while (true) {
                                                                                                                                                                        Label_4627:Block_115_Outer:Label_4502_Outer:
                                                                                                                                                                        while (true) {
                                                                                                                                                                        Label_4502:
                                                                                                                                                                            while (true) {
                                                                                                                                                                                Block_89: {
                                                                                                                                                                                    while (true) {
                                                                                                                                                                                        Label_2976: {
                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                Label_3858:Label_1245_Outer:
                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                Label_1245:
                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                            Block_141: {
                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                    Block_83: {
                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                        Label_1125:
                                                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                                                Label_1473:Block_114_Outer:
                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                            Label_3544:Label_3936_Outer:
                                                                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                                                            Label_3936:
                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                                    Label_3260:
                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                            Block_93: {
                                                                                                                                                                                                                                                                Label_1188:Label_1359_Outer:
                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                    Block_24: {
                                                                                                                                                                                                                                                                    Block_107:
                                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                                        Label_1359:
                                                                                                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                                Label_3897:
                                                                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                                                                        Block_85: {
                                                                                                                                                                                                                                                                                            Label_3663: {
                                                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                                                    Block_140: {
                                                                                                                                                                                                                                                                                                        Block_104_Outer:Block_25_Outer:
                                                                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                                                                            Label_2826: {
                                                                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                                                                    Block_84: {
                                                                                                                                                                                                                                                                                                                        Block_30_Outer:Block_101_Outer:
                                                                                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                                                                                                                                                Block_106: {
                                                                                                                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                                                                                                                        Block_49: {
                                                                                                                                                                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                                                                                                                                                            Label_4014:
                                                                                                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                                                                                                                                                                            Block_103:
                                                                                                                                                                                                                                                                                                                                                                while (true) {
                                                                                                                                                                                                                                                                                                                                                                    potsMaxed = b;
                                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_4715:)(!((JsonObject)asJsonObject).get("potsMaxed").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                    break Block_140;
                                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_3094:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                                                                                                                                                                    break Block_85;
                                                                                                                                                                                                                                                                                                                                                                    asLong = ((JsonObject)asJsonObject).get("totalGemsPurchased").getAsLong();
                                                                                                                                                                                                                                                                                                                                                                    break Label_2701;
                                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setGraceProgress(asInt12);
                                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_4089:)(!((JsonObject)asJsonObject).has("illusionProgress"));
                                                                                                                                                                                                                                                                                                                                                                    break Label_3819;
                                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_1231:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                                                                                                                                                                    break Block_24;
                                                                                                                                                                                                                                                                                                                                                                    Label_4421: {
                                                                                                                                                                                                                                                                                                                                                                        asLong2 = 0L;
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                    break Label_4424;
                                                                                                                                                                                                                                                                                                                                                                    type = (Type)((JsonObject)asJsonObject).get("kingsQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                                    break Label_2976;
                                                                                                                                                                                                                                                                                                                                                                    this.data.getRuinQuests().add((Object)type);
                                                                                                                                                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                                                                                                                                                        while (true) {
                                                                                                                                                                                                                                                                                                                                                                            iftrue(Label_3520:)(!iterator7.hasNext());
                                                                                                                                                                                                                                                                                                                                                                            break Block_103;
                                                                                                                                                                                                                                                                                                                                                                            Label_3855:
                                                                                                                                                                                                                                                                                                                                                                            asInt13 = 0;
                                                                                                                                                                                                                                                                                                                                                                            break Label_3858;
                                                                                                                                                                                                                                                                                                                                                                            type = (Type)iterator8.next();
                                                                                                                                                                                                                                                                                                                                                                            this.data.getTavernGuests().add((Object)this.getAdventurer(((JsonElement)type).getAsJsonObject()));
                                                                                                                                                                                                                                                                                                                                                                            break Label_1245;
                                                                                                                                                                                                                                                                                                                                                                            ((Data)type).setPotsMaxed(potsMaxed);
                                                                                                                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                            asLong3 = n;
                                                                                                                                                                                                                                                                                                                                                                            iftrue(Label_4752:)(!((JsonObject)asJsonObject).has("maxWealth"));
                                                                                                                                                                                                                                                                                                                                                                            break Block_141;
                                                                                                                                                                                                                                                                                                                                                                            type = (Type)iterator9.next();
                                                                                                                                                                                                                                                                                                                                                                            this.data.getSoldMarketItems().add((Object)this.getItemAction(((JsonElement)type).getAsJsonObject()));
                                                                                                                                                                                                                                                                                                                                                                            break Label_1359;
                                                                                                                                                                                                                                                                                                                                                                            asLong2 = ((JsonObject)asJsonObject).get("itemsCrafted").getAsLong();
                                                                                                                                                                                                                                                                                                                                                                            break Label_4424;
                                                                                                                                                                                                                                                                                                                                                                            Label_3449:
                                                                                                                                                                                                                                                                                                                                                                            iftrue(Label_3520:)(!((JsonObject)asJsonObject).has("ruinQuests"));
                                                                                                                                                                                                                                                                                                                                                                            Block_102: {
                                                                                                                                                                                                                                                                                                                                                                                break Block_102;
                                                                                                                                                                                                                                                                                                                                                                                this.data.getWorkshopQueue().add((Object)this.getItemAction(((JsonElement)((Iterator)type).next()).getAsJsonObject()));
                                                                                                                                                                                                                                                                                                                                                                                break Label_1530;
                                                                                                                                                                                                                                                                                                                                                                                Label_1573:
                                                                                                                                                                                                                                                                                                                                                                                iterator10 = ((JsonObject)asJsonObject).get("merchantRegularStockItems").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                                                break Block_26_Outer;
                                                                                                                                                                                                                                                                                                                                                                                Label_3023:
                                                                                                                                                                                                                                                                                                                                                                                iftrue(Label_3094:)(!((JsonObject)asJsonObject).has("afflictionQuests"));
                                                                                                                                                                                                                                                                                                                                                                                break Block_84;
                                                                                                                                                                                                                                                                                                                                                                                Label_4167:
                                                                                                                                                                                                                                                                                                                                                                                asInt14 = 0;
                                                                                                                                                                                                                                                                                                                                                                                break Label_4170;
                                                                                                                                                                                                                                                                                                                                                                                iftrue(Label_3591:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                                                                                                                                                                                break Block_106;
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)((JsonObject)asJsonObject).get("pets").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                                                continue Label_1188;
                                                                                                                                                                                                                                                                                                                                                                                quest = this.getQuest(((JsonElement)((Iterator)type).next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                                                                                                                iftrue(Label_3189:)(quest == null);
                                                                                                                                                                                                                                                                                                                                                                                break Block_92;
                                                                                                                                                                                                                                                                                                                                                                                Label_1687:
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeemed_fj9rf8hh(((JsonObject)asJsonObject).has("ed_fj9rf8hh") && ((JsonObject)asJsonObject).get("redeemed_fj9rf8hh").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeemed_f8hf3045(((JsonObject)asJsonObject).has("redeemed_f8hf3045") && ((JsonObject)asJsonObject).get("redeemed_f8hf3045").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeemed_g294ps91(((JsonObject)asJsonObject).has("redeemed_g294ps91") && ((JsonObject)asJsonObject).get("redeemed_g294ps91").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeemed_vre8983y(((JsonObject)asJsonObject).has("redeemed_vre8983y") && ((JsonObject)asJsonObject).get("redeemed_vre8983y").getAsBoolean())
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeemed_vrw74ync(((JsonObject)asJsonObject).has("redeemed_vrw74ync") && ((JsonObject)asJsonObject).get("redeemed_vrw74ync").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeemed_e44opo7z(((JsonObject)asJsonObject).has("redeemed_e44opo7z") && ((JsonObject)asJsonObject).get("redeemed_e44opo7z").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeem_potionsRefund1(((JsonObject)asJsonObject).has("redeem_potionsRefund1") && ((JsonObject)asJsonObject).get("redeem_potionsRefund1").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                ((Data)type).setRedeem_f1r39h15(((JsonObject)asJsonObject).has("redeem_f1r39h15") && ((JsonObject)asJsonObject).get("redeem_f1r39h15").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                                iftrue(Label_2061:)(!((JsonObject)asJsonObject).has("redeem_m975nfu5"));
                                                                                                                                                                                                                                                                                                                                                                                break Block_49;
                                                                                                                                                                                                                                                                                                                                                                                this.data.getKnowledgeQuests().add((Object)type);
                                                                                                                                                                                                                                                                                                                                                                                break Label_3402;
                                                                                                                                                                                                                                                                                                                                                                                Label_4460:
                                                                                                                                                                                                                                                                                                                                                                                asLong4 = 0L;
                                                                                                                                                                                                                                                                                                                                                                                break Label_4463;
                                                                                                                                                                                                                                                                                                                                                                                Label_4624:
                                                                                                                                                                                                                                                                                                                                                                                asInt15 = 0;
                                                                                                                                                                                                                                                                                                                                                                                break Label_4627;
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                            iterator7 = ((JsonObject)asJsonObject).get("ruinQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                                            continue Block_25_Outer;
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                        this.data.getGraceQuests().add((Object)type);
                                                                                                                                                                                                                                                                                                                                                                        break Label_3260;
                                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_3236:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                                                                                                                                                                        continue Block_101_Outer;
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                    Label_1402:
                                                                                                                                                                                                                                                                                                                                                                    type = (Type)((JsonObject)asJsonObject).get("marketListings").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                                    break Label_1416;
                                                                                                                                                                                                                                                                                                                                                                    asInt16 = ((JsonObject)asJsonObject).get("controlLevel").getAsInt();
                                                                                                                                                                                                                                                                                                                                                                    break Label_3663;
                                                                                                                                                                                                                                                                                                                                                                    Label_4050:
                                                                                                                                                                                                                                                                                                                                                                    asInt12 = 0;
                                                                                                                                                                                                                                                                                                                                                                    continue Label_4053;
                                                                                                                                                                                                                                                                                                                                                                    asLong5 = ((JsonObject)asJsonObject).get("lastHourTriggered").getAsLong();
                                                                                                                                                                                                                                                                                                                                                                    break Label_2826;
                                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setIllusionLevel(asInt17);
                                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_3816:)(!((JsonObject)asJsonObject).has("knowledgeLevel"));
                                                                                                                                                                                                                                                                                                                                                                    break Label_2701;
                                                                                                                                                                                                                                                                                                                                                                    asInt18 = ((JsonObject)asJsonObject).get("afflictionProgress").getAsInt();
                                                                                                                                                                                                                                                                                                                                                                    break Label_3936;
                                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setQuestsCompleted(asInt15);
                                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setDoctrineMaxed(((JsonObject)asJsonObject).has("doctrineMaxed") && ((JsonObject)asJsonObject).get("doctrineMaxed").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                                    potsMaxed = b;
                                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_4715:)(!((JsonObject)asJsonObject).has("potsMaxed"));
                                                                                                                                                                                                                                                                                                                                                                    continue Label_3047_Outer;
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                type = (Type)this.getQuest(((JsonElement)iterator7.next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                                                                                                iftrue(Label_3473:)(type == null);
                                                                                                                                                                                                                                                                                                                                                                continue Block_25_Outer;
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            asInt19 = ((JsonObject)asJsonObject).get("knowledgeProgress").getAsInt();
                                                                                                                                                                                                                                                                                                                                                            break Label_4131;
                                                                                                                                                                                                                                                                                                                                                            Label_1164: {
                                                                                                                                                                                                                                                                                                                                                                iftrue(Label_1231:)(!((JsonObject)asJsonObject).has("pets"));
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            continue Block_101_Outer;
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                        type = (Type)this.getQuest(((JsonElement)iterator11.next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_3118:)(type == null);
                                                                                                                                                                                                                                                                                                                                                        break Block_89;
                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_3378:)(!iterator12.hasNext());
                                                                                                                                                                                                                                                                                                                                                        break Label_3780;
                                                                                                                                                                                                                                                                                                                                                        Label_4011: {
                                                                                                                                                                                                                                                                                                                                                            asInt20 = 0;
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                        break Label_4014;
                                                                                                                                                                                                                                                                                                                                                        ((Data)type).setControlProgress(asInt21);
                                                                                                                                                                                                                                                                                                                                                        type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_4011:)(!((JsonObject)asJsonObject).has("fortitudeProgress"));
                                                                                                                                                                                                                                                                                                                                                        Block_118: {
                                                                                                                                                                                                                                                                                                                                                            break Block_118;
                                                                                                                                                                                                                                                                                                                                                            asInt22 = ((JsonObject)asJsonObject).get("maxAdventurerTier").getAsInt();
                                                                                                                                                                                                                                                                                                                                                            break Label_4385;
                                                                                                                                                                                                                                                                                                                                                            Label_4206:
                                                                                                                                                                                                                                                                                                                                                            asInt23 = 0;
                                                                                                                                                                                                                                                                                                                                                            break Label_4209;
                                                                                                                                                                                                                                                                                                                                                            type = (Type)iterator10.next();
                                                                                                                                                                                                                                                                                                                                                            this.data.getMerchantRegularStockItems().add((Object)this.getMerchantOffer(((JsonElement)type).getAsJsonObject()));
                                                                                                                                                                                                                                                                                                                                                            break Block_26_Outer;
                                                                                                                                                                                                                                                                                                                                                            type = (Type)((JsonObject)asJsonObject).get("uniqueItemsLost").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                            break Label_1125;
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                        asInt20 = ((JsonObject)asJsonObject).get("fortitudeProgress").getAsInt();
                                                                                                                                                                                                                                                                                                                                                        break Label_4014;
                                                                                                                                                                                                                                                                                                                                                        ((Data)type).setFortitudeLevel(asInt24);
                                                                                                                                                                                                                                                                                                                                                        type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_3738:)(!((JsonObject)asJsonObject).has("graceLevel"));
                                                                                                                                                                                                                                                                                                                                                        break Label_3331;
                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_1516:)(!iterator13.hasNext());
                                                                                                                                                                                                                                                                                                                                                        break Label_3260;
                                                                                                                                                                                                                                                                                                                                                        Label_1630:
                                                                                                                                                                                                                                                                                                                                                        iterator14 = ((JsonObject)asJsonObject).get("merchantSpecialReserve").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                                                        break Label_1644;
                                                                                                                                                                                                                                                                                                                                                        Label_2823:
                                                                                                                                                                                                                                                                                                                                                        asLong5 = 0L;
                                                                                                                                                                                                                                                                                                                                                        break Label_2826;
                                                                                                                                                                                                                                                                                                                                                        Label_3660:
                                                                                                                                                                                                                                                                                                                                                        asInt16 = 0;
                                                                                                                                                                                                                                                                                                                                                        break Label_3663;
                                                                                                                                                                                                                                                                                                                                                        iftrue(Label_1402:)(!iterator9.hasNext());
                                                                                                                                                                                                                                                                                                                                                        continue Label_1359_Outer;
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setTotalGemsPurchased(asLong);
                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setIntercessionsRetroactivelyGranted(((JsonObject)asJsonObject).has("intercessionsRetroactivelyGranted") && ((JsonObject)asJsonObject).get("intercessionsRetroactivelyGranted").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                    ((Data)type).setVial2RetGrant(((JsonObject)asJsonObject).has("vial2RetGrant") && ((JsonObject)asJsonObject).get("vial2RetGrant").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                    iftrue(Label_2823:)(!((JsonObject)asJsonObject).has("lastHourTriggered"));
                                                                                                                                                                                                                                                                                                                                                    continue Label_3780_Outer;
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                ((Data)type).setFortitudeProgress(asInt20);
                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                iftrue(Label_4050:)(!((JsonObject)asJsonObject).has("graceProgress"));
                                                                                                                                                                                                                                                                                                                                                break Block_119;
                                                                                                                                                                                                                                                                                                                                                Label_2061: {
                                                                                                                                                                                                                                                                                                                                                    asInt25 = 0;
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                break Label_1530;
                                                                                                                                                                                                                                                                                                                                                ((Data)type).setMaxAdventurerTier(asInt22);
                                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                                iftrue(Label_4421:)(!((JsonObject)asJsonObject).has("itemsCrafted"));
                                                                                                                                                                                                                                                                                                                                                continue Block_30_Outer;
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            iftrue(Label_3307:)(!iterator15.hasNext());
                                                                                                                                                                                                                                                                                                                                            break Label_4092;
                                                                                                                                                                                                                                                                                                                                            this.data.getUniqueItemsLost().add((Object)((JsonElement)((Iterator)type).next()).getAsString());
                                                                                                                                                                                                                                                                                                                                            break Label_1125;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        asInt25 = ((JsonObject)asJsonObject).get("redeem_m975nfu5").getAsInt();
                                                                                                                                                                                                                                                                                                                                        break Label_1530;
                                                                                                                                                                                                                                                                                                                                        asInt26 = ((JsonObject)asJsonObject).get("warLevel").getAsInt();
                                                                                                                                                                                                                                                                                                                                        break Label_3897;
                                                                                                                                                                                                                                                                                                                                        Label_3236: {
                                                                                                                                                                                                                                                                                                                                            iftrue(Label_3307:)(!((JsonObject)asJsonObject).has("graceQuests"));
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        break Block_93;
                                                                                                                                                                                                                                                                                                                                        Label_4499:
                                                                                                                                                                                                                                                                                                                                        asInt27 = 0;
                                                                                                                                                                                                                                                                                                                                        break Label_4502;
                                                                                                                                                                                                                                                                                                                                        iftrue(Label_1573:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                                                                                                                                        continue Label_1530_Outer;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    asInt28 = ((JsonObject)asJsonObject).get("afflictionLevel").getAsInt();
                                                                                                                                                                                                                                                                                                                                    break Label_1473;
                                                                                                                                                                                                                                                                                                                                    Label_3738: {
                                                                                                                                                                                                                                                                                                                                        asInt29 = 0;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    break Label_3741;
                                                                                                                                                                                                                                                                                                                                    Label_3378:
                                                                                                                                                                                                                                                                                                                                    iftrue(Label_3449:)(!((JsonObject)asJsonObject).has("knowledgeQuests"));
                                                                                                                                                                                                                                                                                                                                    break Label_2655;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                quest2 = this.getQuest(((JsonElement)((Iterator)type).next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                                                                iftrue(Label_3544:)(quest2 == null);
                                                                                                                                                                                                                                                                                                                                break Block_107;
                                                                                                                                                                                                                                                                                                                                ((Data)type).setAfflictionProgress(asInt18);
                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                iftrue(Label_3972:)(!((JsonObject)asJsonObject).has("controlProgress"));
                                                                                                                                                                                                                                                                                                                                break Block_117;
                                                                                                                                                                                                                                                                                                                                ((Data)type).setMaxAdventurersOwned(asInt27);
                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                ((Data)type).setT4Pet(((JsonObject)asJsonObject).has("t4Pet") && ((JsonObject)asJsonObject).get("t4Pet").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                ((Data)type).setEverAscended(((JsonObject)asJsonObject).has("everAscended") && ((JsonObject)asJsonObject).get("everAscended").getAsBoolean());
                                                                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                                iftrue(Label_4624:)(!((JsonObject)asJsonObject).has("questsCompleted"));
                                                                                                                                                                                                                                                                                                                                break Label_4502;
                                                                                                                                                                                                                                                                                                                                type = (Type)this.getQuest(((JsonElement)iterator16.next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                                                                iftrue(Label_3402:)(type == null);
                                                                                                                                                                                                                                                                                                                                continue Label_3402_Outer;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            iftrue(Label_1288:)(!iterator8.hasNext());
                                                                                                                                                                                                                                                                                                                            continue Label_1245_Outer;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        iftrue(Label_1687:)(!iterator14.hasNext());
                                                                                                                                                                                                                                                                                                                        break Block_32;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    type = (Type)((JsonObject)asJsonObject).get("afflictionQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                                    continue Block_71_Outer;
                                                                                                                                                                                                                                                                                                                    asInt17 = ((JsonObject)asJsonObject).get("illusionLevel").getAsInt();
                                                                                                                                                                                                                                                                                                                    continue Label_3780;
                                                                                                                                                                                                                                                                                                                    type = (Type)iterator17.next();
                                                                                                                                                                                                                                                                                                                    this.data.getDismissedAdventurers().add((Object)this.getAdventurer(((JsonElement)type).getAsJsonObject()));
                                                                                                                                                                                                                                                                                                                    break Label_3189;
                                                                                                                                                                                                                                                                                                                    ((Data)type).setMaxWealth(asLong3);
                                                                                                                                                                                                                                                                                                                    this.data.setEnchantedForest(this.getArea(EnchantedForest.class, (JsonObject)asJsonObject, "enchantedForest"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheDesert(this.getArea(TheDesert.class, (JsonObject)asJsonObject, "theDesert"));
                                                                                                                                                                                                                                                                                                                    this.data.setEternalBattlefield(this.getArea(EternalBattlefield.class, (JsonObject)asJsonObject, "eternalBattlefield"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheGoldenCity(this.getArea(TheGoldenCity.class, (JsonObject)asJsonObject, "theGoldenCity"));
                                                                                                                                                                                                                                                                                                                    this.data.setBlackwaterPort(this.getArea(BlackwaterPort.class, (JsonObject)asJsonObject, "blackwaterPort"));
                                                                                                                                                                                                                                                                                                                    this.data.setFrostbitePeaks(this.getArea(FrostbitePeaks.class, (JsonObject)asJsonObject, "frostbitePeaks"));
                                                                                                                                                                                                                                                                                                                    this.data.setObsidianMines(this.getArea(ObsidianMines.class, (JsonObject)asJsonObject, "obsidianMines"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheSouthernGrove(this.getArea(TheSouthernGrove.class, (JsonObject)asJsonObject, "theSouthernGrove"));
                                                                                                                                                                                                                                                                                                                    this.data.setBarrenWastelands(this.getArea(BarrenWastelands.class, (JsonObject)asJsonObject, "barrenWastelands"));
                                                                                                                                                                                                                                                                                                                    this.data.setHiddenCityOfLarox(this.getArea(HiddenCityOfLarox.class, (JsonObject)asJsonObject, "hiddenCityOfLarox"));
                                                                                                                                                                                                                                                                                                                    this.data.setLostLands(this.getArea(LostLands.class, (JsonObject)asJsonObject, "lostLands"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheSlimePond(this.getArea(TheSlimePond.class, (JsonObject)asJsonObject, "theSlimePond"));
                                                                                                                                                                                                                                                                                                                    this.data.setDivineArcheology(this.getArea(DivineArcheology.class, (JsonObject)asJsonObject, "divineArcheology"));
                                                                                                                                                                                                                                                                                                                    this.data.setAncientGraveDigging(this.getArea(AncientGraveDigging.class, (JsonObject)asJsonObject, "ancientGraveDigging"));
                                                                                                                                                                                                                                                                                                                    this.data.setImperialRescue(this.getArea(ImperialRescue.class, (JsonObject)asJsonObject, "imperialRescue"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheCultistRebels(this.getArea(TheCultistRebels.class, (JsonObject)asJsonObject, "theCultistRebels"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheLostExpedition(this.getArea(TheLostExpedition.class, (JsonObject)asJsonObject, "theLostExpedition"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheDreadfulAscent(this.getArea(TheDreadfulAscent.class, (JsonObject)asJsonObject, "theDreadfulAscent"));
                                                                                                                                                                                                                                                                                                                    this.data.setCelestialMothership(this.getArea(CelestialMothership.class, (JsonObject)asJsonObject, "celestialMothership"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheDireDescent(this.getArea(TheDireDescent.class, (JsonObject)asJsonObject, "theDireDescent"));
                                                                                                                                                                                                                                                                                                                    this.data.setSleepingPlanet(this.getArea(SleepingPlanet.class, (JsonObject)asJsonObject, "sleepingPlanet"));
                                                                                                                                                                                                                                                                                                                    this.data.setKaunis(this.getArea(Kaunis.class, (JsonObject)asJsonObject, "kaunis"));
                                                                                                                                                                                                                                                                                                                    this.data.setTheTower(this.getArea(TheTower.class, (JsonObject)asJsonObject, "theTower"));
                                                                                                                                                                                                                                                                                                                    return this.data;
                                                                                                                                                                                                                                                                                                                    ((Data)type).setIllusionProgress(asInt30);
                                                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                                                    iftrue(Label_4128:)(!((JsonObject)asJsonObject).has("knowledgeProgress"));
                                                                                                                                                                                                                                                                                                                    continue Label_4131_Outer;
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            ((Data)type).setLastHourTriggered(asLong5);
                                                                                                                                                                                                                                                                                                            this.data.setLast24Triggered(((JsonObject)asJsonObject).get("last24Triggered").getAsLong());
                                                                                                                                                                                                                                                                                                            this.data.setLastWeekTriggered(((JsonObject)asJsonObject).get("lastWeekTriggered").getAsLong());
                                                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                                                            ((Data)type).setQuestsSeen(((JsonObject)asJsonObject).has("questsSeen") && ((JsonObject)asJsonObject).get("questsSeen").getAsBoolean());
                                                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                                                            ((Data)type).setQuestsRefreshed(((JsonObject)asJsonObject).has("questsRefreshed") && ((JsonObject)asJsonObject).get("questsRefreshed").getAsBoolean());
                                                                                                                                                                                                                                                                                                            iftrue(Label_3023:)(!((JsonObject)asJsonObject).has("kingsQuests"));
                                                                                                                                                                                                                                                                                                            continue Block_104_Outer;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        iterator11 = ((JsonObject)asJsonObject).get("controlQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                                        break Label_4053;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    potsMaxed = true;
                                                                                                                                                                                                                                                                                                    continue Label_1359_Outer;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                quest3 = this.getQuest(((JsonElement)((Iterator)type).next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                                iftrue(Label_2976:)(quest3 == null);
                                                                                                                                                                                                                                                                                                break Block_83;
                                                                                                                                                                                                                                                                                                Label_3621: {
                                                                                                                                                                                                                                                                                                    asInt28 = 0;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                break Label_1473;
                                                                                                                                                                                                                                                                                                Label_3972:
                                                                                                                                                                                                                                                                                                asInt21 = 0;
                                                                                                                                                                                                                                                                                                continue Label_3975;
                                                                                                                                                                                                                                                                                                Label_3894:
                                                                                                                                                                                                                                                                                                asInt26 = 0;
                                                                                                                                                                                                                                                                                                break Label_3897;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            ((Data)type).setControlLevel(asInt16);
                                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                                            iftrue(Label_3699:)(!((JsonObject)asJsonObject).has("fortitudeLevel"));
                                                                                                                                                                                                                                                                                            break Block_110;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        quest4 = this.getQuest(((JsonElement)((Iterator)type).next()).getAsJsonObject());
                                                                                                                                                                                                                                                                                        iftrue(Label_3047:)(quest4 == null);
                                                                                                                                                                                                                                                                                        this.data.getAfflictionQuests().add((Object)quest4);
                                                                                                                                                                                                                                                                                        continue Block_71_Outer;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    ((Data)type).setWarLevel(asInt26);
                                                                                                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                                                                                                    iftrue(Label_3933:)(!((JsonObject)asJsonObject).has("afflictionProgress"));
                                                                                                                                                                                                                                                                                    continue Label_3936_Outer;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                ((Data)type).setRuinProgress(asInt14);
                                                                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                                                                iftrue(Label_4206:)(!((JsonObject)asJsonObject).has("warProgress"));
                                                                                                                                                                                                                                                                                break Block_123;
                                                                                                                                                                                                                                                                                Label_1345: {
                                                                                                                                                                                                                                                                                    iterator9 = ((JsonObject)asJsonObject).get("soldMarketItems").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                continue Label_1359;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            iterator12 = ((JsonObject)asJsonObject).get("illusionQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                                            continue Label_3331;
                                                                                                                                                                                                                                                                            ((Data)type).setWarProgress(asInt23);
                                                                                                                                                                                                                                                                            this.data.setAdsWatched(((JsonObject)asJsonObject).get("adsWatched").getAsInt());
                                                                                                                                                                                                                                                                            this.data.setShownDialogRaid(((JsonObject)asJsonObject).get("shownDialogRaid").getAsBoolean());
                                                                                                                                                                                                                                                                            this.data.setShownDialogEpicRaid(((JsonObject)asJsonObject).get("shownDialogEpicRaid").getAsBoolean());
                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                            ((Data)type).setReviewTrigger(((JsonObject)asJsonObject).has("reviewTrigger") && ((JsonObject)asJsonObject).get("reviewTrigger").getAsBoolean());
                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                            ((Data)type).setReviewShown(((JsonObject)asJsonObject).has("reviewShown") && ((JsonObject)asJsonObject).get("reviewShown").getAsBoolean());
                                                                                                                                                                                                                                                                            type = (Type)this.data;
                                                                                                                                                                                                                                                                            iftrue(Label_4382:)(!((JsonObject)asJsonObject).has("maxAdventurerTier"));
                                                                                                                                                                                                                                                                            continue Label_4385_Outer;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        this.data.getWarQuests().add((Object)quest2);
                                                                                                                                                                                                                                                                        continue Label_3544;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    this.data.getPets().add((Object)this.getPet(((JsonElement)((Iterator)type).next()).getAsJsonObject()));
                                                                                                                                                                                                                                                                    continue Label_1188;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                asInt13 = ((JsonObject)asJsonObject).get("ruinLevel").getAsInt();
                                                                                                                                                                                                                                                                break Label_3858;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            iterator15 = ((JsonObject)asJsonObject).get("graceQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                            continue Label_3260;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        type = (Type)iterator13.next();
                                                                                                                                                                                                                                                        this.data.getCompletedWorkshopItems().add((Object)this.getItemAction(((JsonElement)type).getAsJsonObject()));
                                                                                                                                                                                                                                                        continue Label_1473;
                                                                                                                                                                                                                                                        type = (Type)((JsonObject)asJsonObject).get("fortitudeQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                        continue Label_3189;
                                                                                                                                                                                                                                                        Label_3307: {
                                                                                                                                                                                                                                                            iftrue(Label_3378:)(!((JsonObject)asJsonObject).has("illusionQuests"));
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        continue Block_114_Outer;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    Label_3933: {
                                                                                                                                                                                                                                                        asInt18 = 0;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    continue Label_3936;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                type = (Type)((JsonObject)asJsonObject).get("warQuests").getAsJsonArray().iterator();
                                                                                                                                                                                                                                                continue Label_3544;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            Label_1288: {
                                                                                                                                                                                                                                                iterator17 = ((JsonObject)asJsonObject).get("dismissedAdventurers").getAsJsonArray().iterator();
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            break Label_3189;
                                                                                                                                                                                                                                            Label_3520:
                                                                                                                                                                                                                                            iftrue(Label_3591:)(!((JsonObject)asJsonObject).has("warQuests"));
                                                                                                                                                                                                                                            continue Label_3819_Outer;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        ((Data)type).setKnowledgeLevel(asInt31);
                                                                                                                                                                                                                                        type = (Type)this.data;
                                                                                                                                                                                                                                        iftrue(Label_3855:)(!((JsonObject)asJsonObject).has("ruinLevel"));
                                                                                                                                                                                                                                        continue Block_90_Outer;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    Label_1459: {
                                                                                                                                                                                                                                        iterator13 = ((JsonObject)asJsonObject).get("completedWorkshopItems").getAsJsonArray().iterator();
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    continue Label_1473;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                ((Data)type).setAfflictionLevel(asInt28);
                                                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                                                iftrue(Label_3660:)(!((JsonObject)asJsonObject).has("controlLevel"));
                                                                                                                                                                                                                                continue Label_3780_Outer;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            iftrue(Label_1164:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                            continue Block_115_Outer;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        Label_3816: {
                                                                                                                                                                                                                            asInt31 = 0;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        continue Label_3819;
                                                                                                                                                                                                                        iftrue(Label_1459:)(!((Iterator)type).hasNext());
                                                                                                                                                                                                                        break Label_4385;
                                                                                                                                                                                                                        asLong4 = ((JsonObject)asJsonObject).get("itemsSold").getAsLong();
                                                                                                                                                                                                                        break Label_4463;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    this.data.getKingsQuests().add((Object)quest3);
                                                                                                                                                                                                                    break Label_2976;
                                                                                                                                                                                                                    Label_3591: {
                                                                                                                                                                                                                        type = (Type)this.data;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    iftrue(Label_3621:)(!((JsonObject)asJsonObject).has("afflictionLevel"));
                                                                                                                                                                                                                    continue Label_3741_Outer;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                Label_4089: {
                                                                                                                                                                                                                    asInt30 = 0;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                continue Label_4092;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            asLong3 = ((JsonObject)asJsonObject).get("maxWealth").getAsLong();
                                                                                                                                                                                                            continue Label_4092_Outer;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        Label_1231: {
                                                                                                                                                                                                            iterator8 = ((JsonObject)asJsonObject).get("tavernGuests").getAsJsonArray().iterator();
                                                                                                                                                                                                        }
                                                                                                                                                                                                        continue Label_1245;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    ((Data)type).setAmountOfPurchases(asInt32);
                                                                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                                                                    has2 = ((JsonObject)asJsonObject).has("totalGemsPurchased");
                                                                                                                                                                                                    n = 0L;
                                                                                                                                                                                                    iftrue(Label_2698:)(!has2);
                                                                                                                                                                                                    continue Label_2701_Outer;
                                                                                                                                                                                                }
                                                                                                                                                                                                ((Data)type).setRuinLevel(asInt13);
                                                                                                                                                                                                type = (Type)this.data;
                                                                                                                                                                                                iftrue(Label_3894:)(!((JsonObject)asJsonObject).has("warLevel"));
                                                                                                                                                                                                continue Label_4502_Outer;
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                        iftrue(Label_3023:)(!((Iterator)type).hasNext());
                                                                                                                                                                                        continue Block_90_Outer;
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                                this.data.getControlQuests().add((Object)type);
                                                                                                                                                                                break Label_4053;
                                                                                                                                                                                asInt27 = ((JsonObject)asJsonObject).get("maxAdventurersOwned").getAsInt();
                                                                                                                                                                                continue Label_4502;
                                                                                                                                                                            }
                                                                                                                                                                            asInt15 = ((JsonObject)asJsonObject).get("questsCompleted").getAsInt();
                                                                                                                                                                            continue Label_4627;
                                                                                                                                                                        }
                                                                                                                                                                        Label_3165: {
                                                                                                                                                                            iftrue(Label_3236:)(!((JsonObject)asJsonObject).has("fortitudeQuests"));
                                                                                                                                                                        }
                                                                                                                                                                        continue Label_3819_Outer;
                                                                                                                                                                    }
                                                                                                                                                                    Label_4382: {
                                                                                                                                                                        asInt22 = 0;
                                                                                                                                                                    }
                                                                                                                                                                    continue Label_4385;
                                                                                                                                                                }
                                                                                                                                                                this.data.getMarketListings().add((Object)this.getItemAction(((JsonElement)((Iterator)type).next()).getAsJsonObject()));
                                                                                                                                                                continue Label_1416;
                                                                                                                                                            }
                                                                                                                                                            Label_3094: {
                                                                                                                                                                iftrue(Label_3165:)(!((JsonObject)asJsonObject).has("controlQuests"));
                                                                                                                                                            }
                                                                                                                                                            continue Label_3819_Outer;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    ((Data)type).setItemsSold(asLong4);
                                                                                                                                                    type = (Type)this.data;
                                                                                                                                                    iftrue(Label_4499:)(!((JsonObject)asJsonObject).has("maxAdventurersOwned"));
                                                                                                                                                    continue;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            asInt21 = ((JsonObject)asJsonObject).get("controlProgress").getAsInt();
                                                                                                                                            continue Label_3975;
                                                                                                                                        }
                                                                                                                                        iftrue(Label_3449:)(!iterator16.hasNext());
                                                                                                                                        continue Block_112_Outer;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                asInt12 = ((JsonObject)asJsonObject).get("graceProgress").getAsInt();
                                                                                                                                continue Label_4053;
                                                                                                                            }
                                                                                                                            iftrue(Label_3165:)(!iterator11.hasNext());
                                                                                                                            continue Label_3331_Outer;
                                                                                                                        }
                                                                                                                        Label_2652: {
                                                                                                                            asInt32 = 0;
                                                                                                                        }
                                                                                                                        continue Label_2655;
                                                                                                                    }
                                                                                                                    asInt23 = ((JsonObject)asJsonObject).get("warProgress").getAsInt();
                                                                                                                    continue Label_4209;
                                                                                                                }
                                                                                                                Label_2698: {
                                                                                                                    asLong = 0L;
                                                                                                                }
                                                                                                                continue Label_2701;
                                                                                                            }
                                                                                                            asInt31 = ((JsonObject)asJsonObject).get("knowledgeLevel").getAsInt();
                                                                                                            continue Label_3819;
                                                                                                        }
                                                                                                        asInt30 = ((JsonObject)asJsonObject).get("illusionProgress").getAsInt();
                                                                                                        continue Label_4092;
                                                                                                    }
                                                                                                    type = (Type)this.getQuest(((JsonElement)iterator15.next()).getAsJsonObject());
                                                                                                    iftrue(Label_3260:)(type == null);
                                                                                                    continue Label_3189_Outer;
                                                                                                }
                                                                                                Label_1516: {
                                                                                                    type = (Type)((JsonObject)asJsonObject).get("workshopQueue").getAsJsonArray().iterator();
                                                                                                }
                                                                                                continue Label_1530;
                                                                                            }
                                                                                            ((Data)type).setRedeem_m975nfu5(asInt25);
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setRedeem_g73mfkf4(((JsonObject)asJsonObject).has("redeem_g73mfkf4") && ((JsonObject)asJsonObject).get("redeem_g73mfkf4").getAsBoolean());
                                                                                            this.data.setNewMerchantRegularItems(((JsonObject)asJsonObject).get("newMerchantRegularItems").getAsBoolean());
                                                                                            this.data.setNewMerchantSpecialItems(((JsonObject)asJsonObject).get("newMerchantSpecialItems").getAsBoolean());
                                                                                            this.data.setSettingsLanguage(((JsonObject)asJsonObject).get("settingsLanguage").getAsString());
                                                                                            this.data.setSettingSellMaxAmount(((JsonObject)asJsonObject).get("settingSellMaxAmount").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setSettingCraftMaxAmount(((JsonObject)asJsonObject).has("settingCraftMaxAmount") && ((JsonObject)asJsonObject).get("settingCraftMaxAmount").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setSettingConfirmUpgrade(((JsonObject)asJsonObject).has("settingConfirmUpgrade") && ((JsonObject)asJsonObject).get("settingConfirmUpgrade").getAsBoolean());
                                                                                            this.data.setSettingConfirmRetreat(((JsonObject)asJsonObject).get("settingConfirmRetreat").getAsBoolean());
                                                                                            this.data.setSettingConfirmSwap(((JsonObject)asJsonObject).get("settingConfirmSwap").getAsBoolean());
                                                                                            this.data.setSettingAutoOpenDungeonDetail(((JsonObject)asJsonObject).get("settingAutoOpenDungeonDetail").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setSettingVerboseLogs(!((JsonObject)asJsonObject).has("settingVerboseLogs") || ((JsonObject)asJsonObject).get("settingVerboseLogs").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setSettingColorblindMode(((JsonObject)asJsonObject).has("settingColorblindMode") && ((JsonObject)asJsonObject).get("settingColorblindMode").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setStarterPackPurchased(((JsonObject)asJsonObject).has("starterPackPurchased") && ((JsonObject)asJsonObject).get("starterPackPurchased").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setAdventurerPackPurchased(((JsonObject)asJsonObject).has("adventurerPackPurchased") && ((JsonObject)asJsonObject).get("adventurerPackPurchased").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setMerchantPackPurchased(((JsonObject)asJsonObject).has("merchantPackPurchased") && ((JsonObject)asJsonObject).get("merchantPackPurchased").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setImperialVanguardPurchased(((JsonObject)asJsonObject).has("imperialVanguardPurchased") && ((JsonObject)asJsonObject).get("imperialVanguardPurchased").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            ((Data)type).setUnholyCrusadePurchased(((JsonObject)asJsonObject).has("unholyCrusadePurchased") && ((JsonObject)asJsonObject).get("unholyCrusadePurchased").getAsBoolean());
                                                                                            type = (Type)this.data;
                                                                                            iftrue(Label_2652:)(!((JsonObject)asJsonObject).has("amountOfPurchases"));
                                                                                            break Block_112_Outer;
                                                                                            Label_3777: {
                                                                                                asInt17 = 0;
                                                                                            }
                                                                                            continue Label_3780;
                                                                                        }
                                                                                        type = (Type)this.getQuest(((JsonElement)iterator12.next()).getAsJsonObject());
                                                                                        iftrue(Label_3331:)(type == null);
                                                                                        break Label_4131;
                                                                                    }
                                                                                    this.data.getFortitudeQuests().add((Object)quest);
                                                                                    continue Label_3189;
                                                                                }
                                                                                iftrue(Label_1345:)(!iterator17.hasNext());
                                                                                continue Block_130_Outer;
                                                                            }
                                                                            ((Data)type).setGraceLevel(asInt29);
                                                                            type = (Type)this.data;
                                                                            iftrue(Label_3777:)(!((JsonObject)asJsonObject).has("illusionLevel"));
                                                                            continue Block_26_Outer;
                                                                        }
                                                                        iftrue(Label_1630:)(!iterator10.hasNext());
                                                                        continue Label_3702_Outer;
                                                                    }
                                                                    asInt32 = ((JsonObject)asJsonObject).get("amountOfPurchases").getAsInt();
                                                                    continue Label_2655;
                                                                }
                                                                iterator16 = ((JsonObject)asJsonObject).get("knowledgeQuests").getAsJsonArray().iterator();
                                                                continue Label_3402;
                                                            }
                                                            ((Data)type).setKnowledgeProgress(asInt19);
                                                            type = (Type)this.data;
                                                            iftrue(Label_4167:)(!((JsonObject)asJsonObject).has("ruinProgress"));
                                                            break Label_1644;
                                                            Label_3699: {
                                                                asInt24 = 0;
                                                            }
                                                            continue Label_1644_Outer;
                                                        }
                                                        asInt24 = ((JsonObject)asJsonObject).get("fortitudeLevel").getAsInt();
                                                        continue Label_1644_Outer;
                                                    }
                                                }
                                                ((Data)type).setItemsCrafted(asLong2);
                                                type = (Type)this.data;
                                                iftrue(Label_4460:)(!((JsonObject)asJsonObject).has("itemsSold"));
                                                continue;
                                            }
                                        }
                                        type = (Type)iterator14.next();
                                        this.data.getMerchantSpecialReserve().add((Object)this.getMerchantOffer(((JsonElement)type).getAsJsonObject()));
                                        continue Label_1644;
                                    }
                                    asInt14 = ((JsonObject)asJsonObject).get("ruinProgress").getAsInt();
                                    continue Label_4170;
                                }
                                Label_4128: {
                                    asInt19 = 0;
                                }
                                continue Label_4131;
                            }
                            this.data.getIllusionQuests().add((Object)type);
                            continue Label_3331;
                        }
                        asInt29 = ((JsonObject)asJsonObject).get("graceLevel").getAsInt();
                        continue Label_3741;
                    }
                }
                catch (final Exception ex) {}
            }
        }
    }
}
