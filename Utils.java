package it.paranoidsquirrels.idleguildmaster;

import java.util.Set;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;
import it.paranoidsquirrels.idleguildmaster.storage.FileManager;
import java.util.Date;
import java.util.Calendar;
import com.google.android.play.core.review.ReviewManagerFactory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade;
import java.util.function.ToIntFunction;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility;
import java.util.Map$Entry;
import java.util.Map;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemAction;
import com.google.android.gms.tasks.OnCompleteListener;
import android.app.Activity;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.gms.tasks.Task;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer;
import android.content.DialogInterface;
import android.os.Looper;
import java.util.HashSet;
import android.content.res.Resources;
import androidx.core.content.res.ResourcesCompat;
import android.graphics.drawable.Drawable;
import android.content.Context;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import java.util.Arrays;
import android.content.DialogInterface$OnDismissListener;
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.AdventureRecap;
import java.util.Collection;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import java.util.function.Predicate;
import java.util.Iterator;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import java.util.SplittableRandom;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import java.util.Comparator;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.List;

public class Utils
{
    public static final long ONE_DAY_IN_MILLISECONDS = 86400000L;
    public static final int ONE_DAY_IN_SECONDS = 86400;
    public static final long ONE_HOUR_IN_MILLISECONDS = 3600000L;
    public static final int ONE_HOUR_IN_SECONDS = 3600;
    private static final double PET_ABILITY_INDIVIDUAL_PROBABILITY = 0.07692307692307693;
    private static final double POTION_INDIVIDUAL_PROBABILITY = 0.09090909090909091;
    private static final double SPECIAL_FOOD_INDIVIDUAL_PROBABILITY = 0.16666666666666666;
    private static final double TRAIT_COMMON_INDIVIDUAL_PROBABILITY = 0.13333333333333333;
    private static final double TRAIT_RARE_INDIVIDUAL_PROBABILITY = 0.014285714285714287;
    static int checks;
    private static List<Area> dungeonsList;
    private static List<Area> dungeonsRaidsList;
    private static final Comparator<Entity> fightPriorityComparator;
    static boolean firstRunTriggered;
    public static final Comparator<Item> itemsByTypeComparator;
    public static final Comparator<Pet> petsComparator;
    private static List<Area> raidsList;
    private static SplittableRandom randomGenerator;
    public static final Comparator<Recipes> recipesByTypeComparator;
    
    static {
        Utils.randomGenerator = new SplittableRandom();
        fightPriorityComparator = (Comparator)Utils$$ExternalSyntheticLambda3.INSTANCE;
        itemsByTypeComparator = (Comparator)Utils$$ExternalSyntheticLambda4.INSTANCE;
        recipesByTypeComparator = (Comparator)Utils$$ExternalSyntheticLambda5.INSTANCE;
        petsComparator = (Comparator)Utils$$ExternalSyntheticLambda6.INSTANCE;
        Utils.checks = 60;
        Utils.firstRunTriggered = false;
    }
    
    public static int calculateAdventurersLevelSum(final Data data) {
        final Iterator iterator = data.getAdventurers().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final Adventurer adventurer = (Adventurer)iterator.next();
            n += (adventurer.getMaxLevel() / 5 - 1) * 5 + adventurer.getLevel();
        }
        for (final Adventurer adventurer2 : data.getDismissedAdventurers()) {
            n += (adventurer2.getMaxLevel() / 5 - 1) * 5 + adventurer2.getLevel();
        }
        return n;
    }
    
    public static int calculateNewAdventurerId() {
        final Iterator iterator = MainActivity.data.getAdventurers().iterator();
        int id = -1;
        while (iterator.hasNext()) {
            final Adventurer adventurer = (Adventurer)iterator.next();
            if (adventurer.getId() > id) {
                id = adventurer.getId();
            }
        }
        return id + 1;
    }
    
    public static int calculateNewPetId() {
        final Iterator iterator = MainActivity.data.getPets().iterator();
        int id = -1;
        while (iterator.hasNext()) {
            final Pet pet = (Pet)iterator.next();
            if (pet.getId() > id) {
                id = pet.getId();
            }
        }
        return id + 1;
    }
    
    public static void checkDismissedAdventurersExpiration(final long n) {
        try {
            MainActivity.data.getDismissedAdventurers().removeIf((Predicate)new Utils$$ExternalSyntheticLambda7(n));
        }
        catch (final UnsupportedOperationException ex) {}
    }
    
    public static void collectDrops(final Fragment fragment, final Area area) {
        final ArrayList list = new ArrayList();
        for (final Pet pet : MainActivity.data.getPets()) {
            if (pet.isFavourite()) {
                ((List)list).add((Object)pet);
            }
        }
        final int size = ((List)list).size();
        final int remainingInventorySpaceAfterCollecting = remainingInventorySpaceAfterCollecting(size > 0, (Item[])area.getDrops().toArray((Object[])new Item[0]));
        if (remainingInventorySpaceAfterCollecting >= 0) {
            final DialogCollectDrops dialogCollectDrops = new DialogCollectDrops();
            dialogCollectDrops.setCancelable(false);
            dialogCollectDrops.drops = (List)new ArrayList((Collection)area.getDrops());
            dialogCollectDrops.sourceArea = fragment.getString(area.getName());
            dialogCollectDrops.recap = area.getAdventureRecap();
            area.setAdventureRecap(new AdventureRecap());
            dialogCollectDrops.show(fragment.getParentFragmentManager(), "dialog_collect_drops");
            final Iterator iterator2 = area.getDrops().iterator();
            int n = 0;
            while (iterator2.hasNext()) {
                final Item item = (Item)iterator2.next();
                if (size > 0 && item instanceof Food) {
                    n += ((Food)item).getFeedPower() * item.getStack();
                }
                else {
                    collectItem(item, MainActivity.data.getItems());
                }
            }
            if (size > 0) {
                final int n2 = n / size;
                final Iterator iterator3 = ((List)list).iterator();
                while (iterator3.hasNext()) {
                    ((Pet)iterator3.next()).feed(n2);
                }
            }
            area.getDrops().clear();
            area.refreshLoot();
            if (area.getAreaType() == 2 && area.completed()) {
                ((RaidsFragment)fragment).refreshRaidVisibility();
                UIUtils.getInfoDialog(fragment.getContext(), 2131887635, String.format(fragment.getString(2131887634), new Object[] { fragment.getString(area.getName()) }), false).show();
            }
            MainActivity.headquartersFragment.refresh();
            return;
        }
        if (MainActivity.shownDialogFullStorage != null) {
            return;
        }
        (MainActivity.shownDialogFullStorage = UIUtils.getInfoDialog(fragment.getContext(), 2131888998, String.format(fragment.getString(2131888995), new Object[] { remainingInventorySpaceAfterCollecting * -1 }), false)).setOnDismissListener((DialogInterface$OnDismissListener)Utils$$ExternalSyntheticLambda0.INSTANCE);
        MainActivity.shownDialogFullStorage.show();
    }
    
    public static void collectItem(final Item item, final List<Item> obj) {
        MainActivity.data.getSeenItems().add((Object)item.getTrueClass());
        if (MainActivity.data.getItems().equals(obj)) {
            if ("DivineZygote".equals((Object)item.getTrueClass())) {
                MainActivity.data.setReviewTrigger(true);
            }
            final Recipes into = Recipes.into(item);
            if (into != null) {
                MainActivity.data.getKnownRecipes().add((Object)into);
            }
            MainActivity.data.getKnownRecipes().addAll((Collection)Recipes.from(item));
        }
        if (obj.contains((Object)item)) {
            final Item item2 = (Item)obj.get(obj.indexOf((Object)item));
            item2.setStack(Math.min(99999, item2.getStack() + item.getStack()));
        }
        else {
            obj.add((Object)Item.getInstance(item.getTrueClass(), Math.min(99999, item.getStack())));
        }
    }
    
    public static List<Area> compileDungeonList() {
        if (Utils.dungeonsList == null) {
            Utils.dungeonsList = (List<Area>)Arrays.asList((Object[])new Area[] { (Area)MainActivity.data.getEnchantedForest(), (Area)MainActivity.data.getTheDesert(), (Area)MainActivity.data.getEternalBattlefield(), (Area)MainActivity.data.getTheGoldenCity(), (Area)MainActivity.data.getBlackwaterPort(), (Area)MainActivity.data.getFrostbitePeaks(), (Area)MainActivity.data.getObsidianMines(), (Area)MainActivity.data.getTheSouthernGrove(), (Area)MainActivity.data.getBarrenWastelands(), (Area)MainActivity.data.getHiddenCityOfLarox(), (Area)MainActivity.data.getLostLands() });
        }
        return Utils.dungeonsList;
    }
    
    public static List<Area> compileDungeonRaidList() {
        if (Utils.dungeonsRaidsList == null) {
            (Utils.dungeonsRaidsList = (List<Area>)new ArrayList()).addAll((Collection)compileDungeonList());
            Utils.dungeonsRaidsList.addAll((Collection)compileRaidList());
        }
        return Utils.dungeonsRaidsList;
    }
    
    public static List<Area> compileRaidList() {
        if (Utils.raidsList == null) {
            Utils.raidsList = (List<Area>)Arrays.asList((Object[])new Area[] { (Area)MainActivity.data.getTheSlimePond(), (Area)MainActivity.data.getDivineArcheology(), (Area)MainActivity.data.getAncientGraveDigging(), (Area)MainActivity.data.getImperialRescue(), (Area)MainActivity.data.getTheCultistRebels(), (Area)MainActivity.data.getTheDreadfulAscent(), (Area)MainActivity.data.getTheLostExpedition(), (Area)MainActivity.data.getCelestialMothership(), (Area)MainActivity.data.getTheDireDescent(), (Area)MainActivity.data.getSleepingPlanet(), (Area)MainActivity.data.getKaunis(), (Area)MainActivity.data.getTheTower() });
        }
        return Utils.raidsList;
    }
    
    public static String getBaseClass(final Adventurer adventurer) {
        String s;
        if (adventurer.getWeaponType() == 2131889702) {
            s = "Archer";
        }
        else if (adventurer.getWeaponType() == 2131889704) {
            s = "Rogue";
        }
        else if (adventurer.getWeaponType() == 2131889710) {
            s = "Apprentice";
        }
        else {
            s = "Footman";
        }
        return s;
    }
    
    public static Weapon getDefaultWeapon(final int n) {
        if (n == 2131889711) {
            return (Weapon)Item.getInstance("Spade");
        }
        if (n == 2131889710) {
            return (Weapon)Item.getInstance("Cane");
        }
        if (n == 2131889704) {
            return (Weapon)Item.getInstance("Sickle");
        }
        if (n == 2131889702) {
            return (Weapon)Item.getInstance("TrainingBow");
        }
        return null;
    }
    
    public static Drawable getEquipmentDrawable(final Equipment equipment, final Context context) {
        final Resources resources = context.getResources();
        int idImage;
        if (equipment == null) {
            idImage = 2131231151;
        }
        else {
            idImage = equipment.getIdImage();
        }
        return ResourcesCompat.getDrawable(resources, idImage, context.getTheme());
    }
    
    public static List<Adventurer> getIdleAdventurers(final Integer... array) {
        final HashSet set = new HashSet((Collection)Arrays.asList((Object[])array));
        final Iterator iterator = compileDungeonRaidList().iterator();
        while (iterator.hasNext()) {
            ((Set)set).addAll((Collection)((Area)iterator.next()).getAdventurersExploringIds());
        }
        final ArrayList list = new ArrayList();
        for (final Adventurer adventurer : MainActivity.data.getAdventurers()) {
            if (!((Set)set).contains((Object)adventurer.getId())) {
                ((List)list).add((Object)adventurer);
            }
        }
        return (List<Adventurer>)list;
    }
    
    public static List<Pet> getIdlePets() {
        final ArrayList list = new ArrayList();
        for (final Area area : compileDungeonRaidList()) {
            if (area.getPetExploringId() != null) {
                ((List)list).add((Object)area.getPetExploringId());
            }
        }
        final ArrayList list2 = new ArrayList();
        for (final Pet pet : MainActivity.data.getPets()) {
            if (!((List)list).contains((Object)pet.getId())) {
                ((List)list2).add((Object)pet);
            }
        }
        return (List<Pet>)list2;
    }
    
    public static Data getNewestSaveFile(Data data, final Data data2) {
        final long lastAccess = data.getLastAccess();
        final long lastAccess2 = data2.getLastAccess();
        boolean b = true;
        final boolean b2 = lastAccess - lastAccess2 > 0L;
        final boolean b3 = calculateAdventurersLevelSum(data) < 6;
        if (calculateAdventurersLevelSum(data2) >= 6) {
            b = false;
        }
        if (b3 == b) {
            if (!b2) {
                data = data2;
            }
            return data;
        }
        if (b3) {
            data = data2;
        }
        return data;
    }
    
    public static boolean gotEnoughItem(final Item item) {
        final int index = MainActivity.data.getItems().indexOf((Object)item);
        return index != -1 && ((Item)MainActivity.data.getItems().get(index)).getStack() >= item.getStack();
    }
    
    public static boolean gotUniqueDrop(final String s, final Area area) {
        if (MainActivity.data.getSeenItems().contains((Object)s)) {
            return true;
        }
        final Iterator iterator = area.getDrops().iterator();
        while (iterator.hasNext()) {
            if (((Item)iterator.next()).getTrueClass().equals((Object)s)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isMainLooper() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
    
    public static List<String> listUniqueDropsMissing() {
        try {
            final ArrayList list = new ArrayList();
            for (final String s : Arrays.asList((Object[])new String[] { "DivineZygote", "DivineEmbryo", "DivineLarvae", "Sha", "EyesOfTheSwordsman", "AmuletOfTheSwordsman", "SkeletonKey", "SerpentStaff", "SerpentLunge", "SerpentBite", "SerpentSting" })) {
                if (MainActivity.data.getSeenItems().contains((Object)s)) {
                    ((List)list).add((Object)s);
                    final Item instance = Item.getInstance(s);
                    if (instance.getUniqueOrigin().equals((Object)instance.getTrueClass())) {
                        continue;
                    }
                    ((List)list).remove((Object)instance.getUniqueOrigin());
                }
            }
            final ArrayList list2 = new ArrayList();
            for (final Item item : MainActivity.data.getItems()) {
                if (((List)list).contains((Object)item.getTrueClass())) {
                    ((List)list2).add((Object)item.getTrueClass());
                }
            }
            for (final Adventurer adventurer : MainActivity.data.getAdventurers()) {
                if (adventurer.getWeapon() != null && ((List)list).contains((Object)adventurer.getWeapon().getTrueClass())) {
                    ((List)list2).add((Object)adventurer.getWeapon().getTrueClass());
                }
                if (adventurer.getArmor() != null && ((List)list).contains((Object)adventurer.getArmor().getTrueClass())) {
                    ((List)list2).add((Object)adventurer.getArmor().getTrueClass());
                }
                if (adventurer.getAccessory() != null && ((List)list).contains((Object)adventurer.getAccessory().getTrueClass())) {
                    ((List)list2).add((Object)adventurer.getAccessory().getTrueClass());
                }
            }
            final Iterator iterator4 = compileRaidList().iterator();
            while (iterator4.hasNext()) {
                for (final Item item2 : ((Area)iterator4.next()).getDrops()) {
                    if (((List)list).contains((Object)item2.getTrueClass())) {
                        ((List)list2).add((Object)item2.getTrueClass());
                    }
                }
            }
            final Iterator iterator6 = MainActivity.data.getWorkshopQueue().iterator();
            while (iterator6.hasNext()) {
                final Iterator iterator7 = Recipes.into(((ItemAction)iterator6.next()).getItem()).getIngredients().iterator();
                while (iterator7.hasNext()) {
                    ((List)list2).add((Object)((Item)iterator7.next()).getTrueClass());
                }
            }
            final Iterator iterator8 = MainActivity.data.getCompletedWorkshopItems().iterator();
            while (iterator8.hasNext()) {
                final Iterator iterator9 = Recipes.into(((ItemAction)iterator8.next()).getItem()).getIngredients().iterator();
                while (iterator9.hasNext()) {
                    ((List)list2).add((Object)((Item)iterator9.next()).getTrueClass());
                }
            }
            ((List)list).removeAll((Collection)list2);
            return (List<String>)list;
        }
        catch (final Exception ex) {
            return (List<String>)new ArrayList();
        }
    }
    
    public static int maxCraftableAmount(final Recipes recipes) {
        final Iterator iterator = recipes.getIngredients().iterator();
        int min = 99999;
        while (iterator.hasNext()) {
            final Item item = (Item)iterator.next();
            final int index = MainActivity.data.getItems().indexOf((Object)item);
            if (index == -1) {
                return 0;
            }
            min = Math.min(min, ((Item)MainActivity.data.getItems().get(index)).getStack() / item.getStack());
        }
        return min;
    }
    
    public static void newTavernVisitor() {
        final int tutorialStep = MainActivity.data.getTutorialStep();
        Adventurer adventurer;
        if (tutorialStep <= 1) {
            adventurer = Adventurer.getInstance("Footman", -1, 1, 0, null, null, null, null, null, new PotionsDrank(), null, false);
        }
        else if (tutorialStep == 6) {
            adventurer = Adventurer.getInstance("LightDisciple", -1, 1, 0, null, null, null, Trait.BOOKWORM, null, new PotionsDrank(), null, false);
        }
        else if (tutorialStep == 7) {
            adventurer = Adventurer.getInstance("Archer", -1, 1, 0, null, null, null, Trait.FERAL, null, new PotionsDrank(), null, false);
            MainActivity.data.setTutorialStep(8);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQAQ");
        }
        else {
            adventurer = Adventurer.getInstance(rollClass(), -1, 1, 0, null, null, null, rollCommonTrait(), rollRareTrait(), new PotionsDrank(), null, false);
        }
        adventurer.setWeapon(getDefaultWeapon(adventurer.getWeaponType()));
        MainActivity.data.getTavernGuests().add(0, (Object)adventurer);
        if (MainActivity.data.getTavernGuests().size() > Formulas.getTavernCapacity()) {
            MainActivity.data.getTavernGuests().remove(MainActivity.data.getTavernGuests().size() - 1);
        }
    }
    
    public static void nextTimeTick() {
        MainActivity.data.setLastAccess(TrueTimeUtils.millis());
        progressTavernTime(1L);
        progressMarketTime(1L);
        progressWorkshopTime(1L);
        tick60();
        final Iterator iterator = compileDungeonRaidList().iterator();
        while (iterator.hasNext()) {
            ((Area)iterator.next()).tick();
        }
        if (MainActivity.shownDialogEntityDetail != null) {
            MainActivity.shownDialogEntityDetail.update();
        }
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.update();
        }
        if (QuestsManager.QUEST_COMPLETED_RECENTLY && isMainLooper()) {
            QuestsManager.QUEST_COMPLETED_RECENTLY = false;
            QuestsManager.QUEST_NOTIFICATION = true;
            ((MainActivity)MainActivity.dungeonsFragment.getActivity()).refreshIcons();
            if (MainActivity.shownDialogQuests != null) {
                MainActivity.shownDialogQuests.reInitialize();
            }
        }
    }
    
    public static void orderByTurnsPriority(final List<Entity> list) {
        list.sort((Comparator)Utils.fightPriorityComparator);
    }
    
    public static void progressMarketTime(long secondsPassed) {
        final ArrayList list = new ArrayList();
        for (final ItemAction itemAction : MainActivity.data.getMarketListings()) {
            final long secondsPassed2 = itemAction.getSecondsPassed();
            final long secondsToSell = itemAction.getItem().getSecondsToSell();
            final long min = Math.min(secondsPassed, 1L + secondsToSell - secondsPassed2);
            final long n = secondsPassed - min;
            secondsPassed = secondsPassed2 + min;
            itemAction.setSecondsPassed(secondsPassed);
            if (MainActivity.shownDialogMarket != null) {
                MainActivity.shownDialogMarket.updateCountdown();
            }
            if (secondsPassed > secondsToSell) {
                ((List)list).add((Object)itemAction);
            }
            secondsPassed = n;
            if (n <= 0L) {
                break;
            }
        }
        for (final ItemAction itemAction2 : list) {
            MainActivity.data.getMarketListings().remove((Object)itemAction2);
            MainActivity.data.getSoldMarketItems().add(MainActivity.data.getSoldMarketItems().size(), (Object)itemAction2);
            if (MainActivity.shownDialogMarket != null) {
                MainActivity.shownDialogMarket.completeItem();
            }
        }
        if (MainActivity.headquartersFragment != null && MainActivity.headquartersFragment.getBinding() != null && ((List)list).size() > 0) {
            MainActivity.headquartersFragment.refresh();
        }
    }
    
    public static void progressTavernTime(long min) {
        if (MainActivity.data.isTavernLocked()) {
            return;
        }
        final long n = Formulas.getTavernVisitorInterval() / 1000L;
        final long n2 = min / n;
        final long n3 = MainActivity.data.getNextTavernVisit() - min % n;
        long n4 = n2;
        min = n3;
        if (n3 < 0L) {
            min = n3 + n;
            n4 = n2 + 1L;
        }
        MainActivity.data.setNextTavernVisit(min);
        min = Math.min(n4, (long)Formulas.getTavernCapacity());
        for (int n5 = 0; n5 < min; ++n5) {
            newTavernVisitor();
        }
        if (min > 0L) {
            if (MainActivity.headquartersFragment != null && MainActivity.headquartersFragment.getBinding() != null) {
                MainActivity.headquartersFragment.refresh();
            }
            if (MainActivity.shownDialogTavern != null) {
                MainActivity.shownDialogTavern.refreshAdventurers();
            }
        }
        if (MainActivity.shownDialogTavern != null) {
            MainActivity.shownDialogTavern.refreshProgressBar();
        }
    }
    
    public static void progressWorkshopTime(long secondsPassed) {
        final ArrayList list = new ArrayList();
        for (final ItemAction itemAction : MainActivity.data.getWorkshopQueue()) {
            final long secondsPassed2 = itemAction.getSecondsPassed();
            final long secondsToCraft = itemAction.getItem().getSecondsToCraft();
            final long min = Math.min(secondsPassed, 1L + secondsToCraft - secondsPassed2);
            final long n = secondsPassed - min;
            secondsPassed = secondsPassed2 + min;
            itemAction.setSecondsPassed(secondsPassed);
            if (MainActivity.shownDialogWorkshop != null) {
                MainActivity.shownDialogWorkshop.updateCountdown();
            }
            if (secondsPassed > secondsToCraft) {
                ((List)list).add((Object)itemAction);
            }
            secondsPassed = n;
            if (n <= 0L) {
                break;
            }
        }
        for (final ItemAction itemAction2 : list) {
            MainActivity.data.getWorkshopQueue().remove((Object)itemAction2);
            MainActivity.data.getCompletedWorkshopItems().add(MainActivity.data.getCompletedWorkshopItems().size(), (Object)itemAction2);
            if (MainActivity.shownDialogWorkshop != null) {
                MainActivity.shownDialogWorkshop.completeItem();
            }
        }
        if (MainActivity.headquartersFragment != null && MainActivity.headquartersFragment.getBinding() != null && ((List)list).size() > 0) {
            MainActivity.headquartersFragment.refresh();
        }
    }
    
    public static double random() {
        return Utils.randomGenerator.nextDouble();
    }
    
    public static void refreshCooldowns(long n) {
        n = (604800000L - (n - MainActivity.data.getLastWeekTriggered())) / 60000L;
        final int n2 = (int)(n / 1440L);
        n %= 1440L;
        final int n3 = (int)(n / 60L);
        final int n4 = (int)(n % 60L);
        if (MainActivity.raidsFragment != null && MainActivity.raidsFragment.getBinding() != null) {
            MainActivity.raidsFragment.getBinding().raidRefreshTime.setText((CharSequence)String.format(MainActivity.raidsFragment.getString(2131889645), new Object[] { n3, n4 }));
        }
        if (MainActivity.shownDialogMerchant != null) {
            MainActivity.shownDialogMerchant.refreshCooldowns(n2, n3, n4);
        }
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.refreshCooldowns(n2, n3, n4);
        }
    }
    
    public static int remainingInventorySpaceAfterCollecting(final boolean b, final Item... array) {
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final Item item = array[i];
            int n2 = n;
            Label_0058: {
                if (!MainActivity.data.getItems().contains((Object)item)) {
                    if (b) {
                        n2 = n;
                        if (item instanceof Food) {
                            break Label_0058;
                        }
                    }
                    n2 = n + 1;
                }
            }
            ++i;
            n = n2;
        }
        return Formulas.storageSpaces() - (n + MainActivity.data.getItems().size());
    }
    
    public static void removeItemFromStorage(final Item item) {
        final int index = MainActivity.data.getItems().indexOf((Object)item);
        if (index == -1) {
            return;
        }
        final Item item2 = (Item)MainActivity.data.getItems().get(index);
        item2.setStack(Math.max(0, item2.getStack() - item.getStack()));
        if (item2.getStack() == 0) {
            MainActivity.data.getItems().remove((Object)item2);
        }
    }
    
    private static void restoreErroneouslyCompletedEpicRaids() {
        final boolean completed = MainActivity.data.getCelestialMothership().completed();
        final int n = 1;
        boolean b;
        if (completed && !MainActivity.data.getSeenItems().contains((Object)"Evo23Vial")) {
            MainActivity.data.getCelestialMothership().setMaxProgress(1);
            MainActivity.data.getCelestialMothership().getDrops().clear();
            b = true;
        }
        else {
            b = false;
        }
        int n2 = b ? 1 : 0;
        if (MainActivity.data.getImperialRescue().completed()) {
            n2 = (b ? 1 : 0);
            if (!MainActivity.data.getSeenItems().contains((Object)"SkeletonKey")) {
                MainActivity.data.getImperialRescue().setMaxProgress(1);
                MainActivity.data.getImperialRescue().getDrops().clear();
                n2 = 1;
            }
        }
        int n3;
        if (MainActivity.data.getDivineArcheology().completed() && !MainActivity.data.getSeenItems().contains((Object)"DivineZygote")) {
            MainActivity.data.getDivineArcheology().setMaxProgress(1);
            MainActivity.data.getDivineArcheology().getDrops().clear();
            n3 = n;
        }
        else {
            n3 = n2;
        }
        if (n3 == 0) {
            return;
        }
        try {
            MainActivity.raidsFragment.refresh();
        }
        catch (final Exception ex) {}
    }
    
    private static String rollClass() {
        final double random = random();
        if (random < 0.25) {
            return "Footman";
        }
        if (random < 0.5) {
            return "Rogue";
        }
        if (random < 0.75) {
            return "Archer";
        }
        return "Apprentice";
    }
    
    private static Trait rollCommonTrait() {
        final double random = random();
        if (random < 0.13333333333333333) {
            return Trait.BOOKWORM;
        }
        if (random < 0.26666666666666666) {
            return Trait.BRUTE;
        }
        if (random < 0.4) {
            return Trait.FERAL;
        }
        return null;
    }
    
    public static <T> T rollFromWeightedMap(final Map<T, Integer> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                final double random = random();
                int n = 0;
                for (final Map$Entry map$Entry : map.entrySet()) {
                    if (random * 1000.0 < (n += (int)map$Entry.getValue())) {
                        return (T)map$Entry.getKey();
                    }
                }
            }
        }
        return null;
    }
    
    public static PetAbility rollPetAbility(final List<PetAbility> list) {
        Object o = null;
        while (o == null || list.contains(o)) {
            final double random = random();
            if (random < 0.07692307692307693) {
                o = PetAbility.FIGHTER;
            }
            else if (random < 0.15384615384615385) {
                o = PetAbility.HEALER;
            }
            else if (random < 0.23076923076923078) {
                o = PetAbility.DECOY;
            }
            else if (random < 0.3076923076923077) {
                o = PetAbility.OPPORTUNIST;
            }
            else if (random < 0.38461538461538464) {
                o = PetAbility.MAGIC;
            }
            else if (random < 0.46153846153846156) {
                o = PetAbility.SAVAGE;
            }
            else if (random < 0.5384615384615385) {
                o = PetAbility.BRIGHT;
            }
            else if (random < 0.6153846153846154) {
                o = PetAbility.EXPERIENCE;
            }
            else if (random < 0.6923076923076923) {
                o = PetAbility.DROPS;
            }
            else if (random < 0.7692307692307693) {
                o = PetAbility.COUNTERATTACK;
            }
            else if (random < 0.8461538461538463) {
                o = PetAbility.LIFESTEAL;
            }
            else if (random < 0.9230769230769231) {
                o = PetAbility.REGENERATION;
            }
            else {
                if (random >= 1.0) {
                    continue;
                }
                o = PetAbility.BARRIER;
            }
        }
        return (PetAbility)o;
    }
    
    public static MerchantOffer rollPotion() {
        final double random = random();
        int n = 80;
        Item item;
        if (random < 0.09090909090909091) {
            item = Item.getInstance("PotionOfConstitution");
        }
        else if (random < 0.18181818181818182) {
            item = Item.getInstance("PotionOfDexterity");
        }
        else if (random < 0.2727272727272727) {
            item = Item.getInstance("PotionOfIntelligence");
        }
        else if (random < 0.36363636363636365) {
            item = Item.getInstance("PotionOfHealth");
        }
        else if (random < 0.4545454545454546) {
            item = Item.getInstance("PotionOfDefense");
            n = 110;
        }
        else if (random < 0.5454545454545454) {
            item = Item.getInstance("PotionOfMagicDefense");
            n = 100;
        }
        else if (random < 0.6363636363636364) {
            item = Item.getInstance("PotionOfPrecision");
        }
        else if (random < 0.7272727272727273) {
            item = Item.getInstance("PotionOfViciousness");
        }
        else if (random < 0.8181818181818182) {
            item = Item.getInstance("PotionOfDarkness");
        }
        else if (random < 0.9090909090909092) {
            item = Item.getInstance("PotionOfImmunity");
            n = 70;
        }
        else if (random < 1.0) {
            item = Item.getInstance("PotionOfAgility");
        }
        else {
            item = null;
            n = 0;
        }
        final MerchantOffer merchantOffer = new MerchantOffer(item);
        merchantOffer.setPrice(n);
        merchantOffer.setGems(true);
        return merchantOffer;
    }
    
    private static Trait rollRareTrait() {
        final double random = random();
        if (random < 0.014285714285714287) {
            return Trait.EMPATHETIC;
        }
        if (random < 0.028571428571428574) {
            return Trait.GIFTED;
        }
        if (random < 0.04285714285714286) {
            return Trait.INTIMIDATING;
        }
        if (random < 0.05714285714285715) {
            return Trait.FOCUSED;
        }
        if (random < 0.07142857142857144) {
            return Trait.DRAGON_BLOOD;
        }
        if (random < 0.08571428571428572) {
            return Trait.CURSED;
        }
        if (random < 0.1) {
            return Trait.REACTIVE;
        }
        if (random < 0.1142857142857143) {
            return Trait.NOCTURNAL;
        }
        if (random < 0.1285714285714286) {
            return Trait.MINDFUL;
        }
        if (random < 0.14285714285714288) {
            return Trait.TROLL_BLOOD;
        }
        if (random < 0.15714285714285717) {
            return Trait.RUTHLESS;
        }
        if (random < 0.17142857142857143) {
            return Trait.BLESSED;
        }
        if (random < 0.18571428571428572) {
            return Trait.ALERT;
        }
        if (random < 0.2) {
            return Trait.NIMBLE;
        }
        return null;
    }
    
    public static List<MerchantOffer> rollSpecialFoods() {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < 3; ++i) {
            MerchantOffer merchantOffer = null;
            while (merchantOffer == null || ((List)list).contains((Object)merchantOffer)) {
                final double random = random();
                Item item;
                int n;
                if (random < 0.16666666666666666) {
                    item = Item.getInstance("GlazedDonut");
                    n = 50;
                }
                else if (random < 0.3333333333333333) {
                    item = Item.getInstance("GourmetIcecream");
                    n = 100;
                }
                else if (random < 0.5) {
                    item = Item.getInstance("Maxxiburger");
                    n = 200;
                }
                else if (random < 0.6666666666666666) {
                    item = Item.getInstance("Cheesecake");
                    n = 400;
                }
                else if (random < 0.8333333333333333) {
                    item = Item.getInstance("Ambrosia");
                    n = 800;
                }
                else if (random < 1.0) {
                    item = Item.getInstance("CeremonialCake");
                    n = 1500;
                }
                else {
                    n = 0;
                    item = null;
                }
                merchantOffer = new MerchantOffer(item);
                merchantOffer.setPrice(n);
                merchantOffer.setGems(true);
            }
            ((List)list).add((Object)merchantOffer);
        }
        ((List)list).sort(Comparator.comparingInt((ToIntFunction)Utils$$ExternalSyntheticLambda9.INSTANCE));
        return (List<MerchantOffer>)list;
    }
    
    public static List<MerchantOffer> rollUpgrades() {
        final ArrayList list = new ArrayList();
        if (MainActivity.data.getUpgradeMarketQueue() < 1) {
            ((List)list).add((Object)Item.getInstance("UpgradeMarketQueue"));
        }
        if (MainActivity.data.getUpgradeMarketTime() < 2) {
            ((List)list).add((Object)Item.getInstance("UpgradeMarketTime"));
        }
        if (MainActivity.data.getUpgradeQuarters() < 1) {
            ((List)list).add((Object)Item.getInstance("UpgradeQuarters"));
        }
        if (MainActivity.data.getUpgradeShelter() < 1) {
            ((List)list).add((Object)Item.getInstance("UpgradeShelter"));
        }
        if (MainActivity.data.getUpgradeStorage() < 10) {
            ((List)list).add((Object)Item.getInstance("UpgradeStorage"));
        }
        if (MainActivity.data.getUpgradeTavernCapacity() < 1) {
            ((List)list).add((Object)Item.getInstance("UpgradeTavernCapacity"));
        }
        if (MainActivity.data.getUpgradeTavernTime() < 2) {
            ((List)list).add((Object)Item.getInstance("UpgradeTavernTime"));
        }
        if (MainActivity.data.getUpgradeWorkshopQueue() < 1) {
            ((List)list).add((Object)Item.getInstance("UpgradeWorkshopQueue"));
        }
        if (MainActivity.data.getUpgradeWorkshopTime() < 2) {
            ((List)list).add((Object)Item.getInstance("UpgradeWorkshopTime"));
        }
        final ArrayList list2 = new ArrayList();
        if (MainActivity.data.getUpgradeStorage() < 6) {
            final Item instance = Item.getInstance("UpgradeStorage");
            ((List)list).remove((Object)instance);
            final MerchantOffer merchantOffer = new MerchantOffer(instance);
            merchantOffer.setPrice(((Upgrade)instance).getGemPrice());
            merchantOffer.setGems(true);
            ((List)list2).add((Object)merchantOffer);
        }
        while (!((List)list).isEmpty() && ((List)list2).size() < 3) {
            final Item item = (Item)((List)list).get((int)(random() * ((List)list).size()));
            ((List)list).remove((Object)item);
            final MerchantOffer merchantOffer2 = new MerchantOffer(item);
            merchantOffer2.setPrice(((Upgrade)item).getGemPrice());
            merchantOffer2.setGems(true);
            ((List)list2).add((Object)merchantOffer2);
        }
        return (List<MerchantOffer>)list2;
    }
    
    public static int round(final double n) {
        return (int)(n + 1.0E-4);
    }
    
    private static void showReviewCard() {
        try {
            final ReviewManager create = ReviewManagerFactory.create(MainActivity.headquartersFragment.getContext());
            create.requestReviewFlow().addOnCompleteListener((OnCompleteListener)new Utils$$ExternalSyntheticLambda1(create));
        }
        catch (final Exception ex) {}
    }
    
    private static void tick24Hours(final long n) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(n));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        MainActivity.data.setLast24Triggered(instance.getTime().getTime());
        for (final Area area : compileRaidList()) {
            final int areaType = area.getAreaType();
            if (areaType != 1 && areaType != 2) {
                continue;
            }
            area.setTriesAvailable(true);
            area.refreshTries();
        }
        MainActivity.data.getMerchantRegularStockItems().clear();
        final ArrayList list = new ArrayList((Collection)compileDungeonList());
        ((List)list).removeIf((Predicate)Utils$$ExternalSyntheticLambda8.INSTANCE);
        Object subList = list;
        if (((List)list).size() > 4) {
            subList = ((List)list).subList(((List)list).size() - 4, ((List)list).size());
        }
        for (final Area area2 : subList) {
            if (!area2.isUnlocked()) {
                continue;
            }
            final Item item = rollFromWeightedMap((java.util.Map<Item, Integer>)area2.rollMerchantRegularOffers());
            if (item == null) {
                continue;
            }
            final MerchantOffer merchantOffer = new MerchantOffer(item);
            merchantOffer.setGems(false);
            merchantOffer.setPrice(item.getPrice() * item.getStack() * 10L);
            MainActivity.data.getMerchantRegularStockItems().add((Object)merchantOffer);
        }
        MainActivity.data.setNewMerchantRegularItems(true);
        ((MainActivity)MainActivity.dungeonsFragment.getActivity()).refreshIcons();
        if (MainActivity.shownDialogMerchant != null) {
            MainActivity.shownDialogMerchant.newItems();
        }
        MainActivity.data.setAdsWatched(0);
        ((MainActivity)MainActivity.dungeonsFragment.getActivity()).loadAd();
        restoreErroneouslyCompletedEpicRaids();
    }
    
    public static void tick60() {
        final int checks = Utils.checks;
        if (checks < 60) {
            Utils.checks = checks + 1;
            return;
        }
        final long millis = TrueTimeUtils.millis();
        final Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(millis));
        Utils.checks = instance.get(13) - 1;
        checkDismissedAdventurersExpiration(millis);
        refreshCooldowns(millis);
        if (Utils.firstRunTriggered && MainActivity.data.isReviewTrigger() && !MainActivity.data.isReviewShown()) {
            MainActivity.data.setReviewShown(true);
            showReviewCard();
        }
        if (millis - MainActivity.data.getLastWeekTriggered() > 604800000L) {
            tickWeek(millis);
        }
        if (millis - MainActivity.data.getLast24Triggered() > 86400000L) {
            tick24Hours(millis);
        }
        if (millis - MainActivity.data.getLastHourTriggered() > 3600000L) {
            tickHour(millis);
        }
        Utils.firstRunTriggered = true;
    }
    
    private static void tickHour(final long n) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(n));
        instance.set(12, 0);
        instance.set(13, 0);
        MainActivity.data.setLastHourTriggered(instance.getTime().getTime());
        FileManager.writeToCloud();
    }
    
    private static void tickWeek(final long n) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(n));
        instance.add(7, -(instance.get(7) - 1));
        final int n2 = 0;
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        MainActivity.data.setLastWeekTriggered(instance.getTime().getTime());
        QuestsManager.extractQuests();
        QuestsManager.QUEST_NOTIFICATION = true;
        ((MainActivity)MainActivity.dungeonsFragment.getActivity()).refreshIcons();
        MainActivity.data.getMerchantSpecialReserve().clear();
        final List<Area> compileDungeonList = compileDungeonList();
        Object enchantedForest = MainActivity.data.getEnchantedForest();
        final Iterator iterator = compileDungeonList.iterator();
        int n3 = 50;
        while (iterator.hasNext()) {
            final Area area = (Area)iterator.next();
            if (area.isUnlocked()) {
                n3 += 5;
                enchantedForest = area;
            }
        }
        final Item item = rollFromWeightedMap((java.util.Map<Item, Integer>)((Area)enchantedForest).rollMerchantSpecialOffers());
        if (item != null) {
            final MerchantOffer merchantOffer = new MerchantOffer(item);
            merchantOffer.setPrice(n3);
            merchantOffer.setGems(true);
            MainActivity.data.getMerchantSpecialReserve().add((Object)merchantOffer);
        }
        if (random() < 0.55) {
            final MerchantOffer merchantOffer2 = new MerchantOffer(Item.getInstance("Aegis"));
            merchantOffer2.setPrice(1000L);
            merchantOffer2.setGems(true);
            MainActivity.data.getMerchantSpecialReserve().add((Object)merchantOffer2);
        }
        final MerchantOffer merchantOffer3 = new MerchantOffer(Item.getInstance("ScarletStrand"));
        merchantOffer3.setPrice(650L);
        merchantOffer3.setGems(true);
        MainActivity.data.getMerchantSpecialReserve().add((Object)merchantOffer3);
        final Iterator iterator2 = listUniqueDropsMissing().iterator();
        int i;
        while (true) {
            i = n2;
            if (!iterator2.hasNext()) {
                break;
            }
            final MerchantOffer merchantOffer4 = new MerchantOffer(Item.getInstance((String)iterator2.next()));
            merchantOffer4.setPrice(1L);
            merchantOffer4.setGems(true);
            MainActivity.data.getMerchantSpecialReserve().add((Object)merchantOffer4);
        }
        while (i < 3) {
            MainActivity.data.getMerchantSpecialReserve().add((Object)rollPotion());
            ++i;
        }
        MainActivity.data.getMerchantSpecialReserve().addAll((Collection)rollSpecialFoods());
        MainActivity.data.getMerchantSpecialReserve().addAll((Collection)rollUpgrades());
        MainActivity.data.setNewMerchantSpecialItems(true);
        if (MainActivity.shownDialogQuests != null) {
            MainActivity.shownDialogQuests.dismiss();
        }
    }
    
    public static void triggerGuildSizeAchievementCheck() {
        final int maxAdventurersOwned = MainActivity.data.getMaxAdventurersOwned();
        if (maxAdventurersOwned >= 20) {
            return;
        }
        final int size = MainActivity.data.getAdventurers().size();
        if (maxAdventurersOwned < 5 && size >= 5) {
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQCA");
        }
        if (maxAdventurersOwned < 12 && size >= 12) {
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQCQ");
        }
        if (size >= 20) {
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQCg");
        }
        MainActivity.data.setMaxAdventurersOwned(Math.max(size, maxAdventurersOwned));
    }
    
    public static long truncatePrice(final long n) {
        if (n <= 10000L) {
            return n;
        }
        long n2;
        if (n <= 1000000L) {
            n2 = n % 100L;
        }
        else {
            n2 = n % 10000L;
        }
        return n - n2;
    }
    
    private static int typeToPriority(final Item item) {
        try {
            if (item instanceof Sword) {
                return 1;
            }
            if (item instanceof Bow) {
                return 2;
            }
            if (item instanceof Dagger) {
                return 3;
            }
            if (item instanceof Staff) {
                return 4;
            }
            if (item instanceof LightArmor) {
                return 5;
            }
            if (item instanceof MediumArmor) {
                return 6;
            }
            if (item instanceof HeavyArmor) {
                return 7;
            }
            if (item instanceof Accessory) {
                return 8;
            }
            if (item instanceof Potion) {
                return 9;
            }
            if (item instanceof Egg) {
                return 10;
            }
            if (item instanceof Food) {
                return 11;
            }
            return 13;
        }
        catch (final Exception ex) {
            return 13;
        }
    }
}
