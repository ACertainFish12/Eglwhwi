package it.paranoidsquirrels.idleguildmaster;

import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import android.app.Activity;
import com.google.android.gms.games.PlayGames;
import java.util.Iterator;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.ArrayList;
import java.util.List;

public class AchievementsUtils
{
    public static final String ACHIEVEMENT_AGONIZING_TITAN = "CgkIttPX_-AEEAIQJQ";
    public static final String ACHIEVEMENT_APPRENTICE_BLACKSMITH = "CgkIttPX_-AEEAIQAg";
    public static final String ACHIEVEMENT_APPRENTICE_MERCHANT = "CgkIttPX_-AEEAIQBQ";
    public static final String ACHIEVEMENT_ASCENDED = "CgkIttPX_-AEEAIQDA";
    public static final String ACHIEVEMENT_BLACKWATER_PORT = "CgkIttPX_-AEEAIQFg";
    public static final String ACHIEVEMENT_BUSY = "CgkIttPX_-AEEAIQDQ";
    public static final String ACHIEVEMENT_COSMIC_HORROR = "CgkIttPX_-AEEAIQJg";
    public static final String ACHIEVEMENT_DEICIDE = "CgkIttPX_-AEEAIQHQ";
    public static final String ACHIEVEMENT_DIVINE = "CgkIttPX_-AEEAIQMg";
    public static final String ACHIEVEMENT_ETERNAL_BATTLEFIELD = "CgkIttPX_-AEEAIQFA";
    public static final String ACHIEVEMENT_EXPERT = "CgkIttPX_-AEEAIQLQ";
    public static final String ACHIEVEMENT_FABLED = "CgkIttPX_-AEEAIQMQ";
    public static final String ACHIEVEMENT_FILTHY_RICH = "CgkIttPX_-AEEAIQEg";
    public static final String ACHIEVEMENT_FROSTBITE_PEAKS = "CgkIttPX_-AEEAIQFw";
    public static final String ACHIEVEMENT_GUILD_MANAGEMENT_101 = "CgkIttPX_-AEEAIQAQ";
    public static final String ACHIEVEMENT_HEAVY_DRINKER = "CgkIttPX_-AEEAIQEA";
    public static final String ACHIEVEMENT_INFILTRATOR = "CgkIttPX_-AEEAIQIA";
    public static final String ACHIEVEMENT_JACK_OF_ONE_TRADE = "CgkIttPX_-AEEAIQDw";
    public static final String ACHIEVEMENT_LEGENDARY = "CgkIttPX_-AEEAIQLw";
    public static final String ACHIEVEMENT_LEGENDARY_BLACKSMITH = "CgkIttPX_-AEEAIQBA";
    public static final String ACHIEVEMENT_LEGENDARY_MERCHANT = "CgkIttPX_-AEEAIQBw";
    public static final String ACHIEVEMENT_MYTHIC = "CgkIttPX_-AEEAIQMA";
    public static final String ACHIEVEMENT_NOVICE = "CgkIttPX_-AEEAIQKw";
    public static final String ACHIEVEMENT_OBSIDIAN_MINES = "CgkIttPX_-AEEAIQGA";
    public static final String ACHIEVEMENT_RARE_SPECIMEN = "CgkIttPX_-AEEAIQCw";
    public static final String ACHIEVEMENT_RESCUE_TEAM = "CgkIttPX_-AEEAIQHg";
    public static final String ACHIEVEMENT_RESPECTABLE_GUILD = "CgkIttPX_-AEEAIQCQ";
    public static final String ACHIEVEMENT_ROYAL_PUDDING = "CgkIttPX_-AEEAIQIg";
    public static final String ACHIEVEMENT_SEASONED_BLACKSMITH = "CgkIttPX_-AEEAIQAw";
    public static final String ACHIEVEMENT_SEASONED_MERCHANT = "CgkIttPX_-AEEAIQBg";
    public static final String ACHIEVEMENT_SKILLED = "CgkIttPX_-AEEAIQLA";
    public static final String ACHIEVEMENT_SMALL_GUILD = "CgkIttPX_-AEEAIQCA";
    public static final String ACHIEVEMENT_THE_APOSTLE = "CgkIttPX_-AEEAIQJw";
    public static final String ACHIEVEMENT_THE_BARREN_WASTELANDS = "CgkIttPX_-AEEAIQGg";
    public static final String ACHIEVEMENT_THE_CORE = "CgkIttPX_-AEEAIQIQ";
    public static final String ACHIEVEMENT_THE_COUNCIL = "CgkIttPX_-AEEAIQKQ";
    public static final String ACHIEVEMENT_THE_CULTISTS = "CgkIttPX_-AEEAIQJA";
    public static final String ACHIEVEMENT_THE_DESERT = "CgkIttPX_-AEEAIQEw";
    public static final String ACHIEVEMENT_THE_GOLDEN_CITY = "CgkIttPX_-AEEAIQFQ";
    public static final String ACHIEVEMENT_THE_HIDDEN_CITY = "CgkIttPX_-AEEAIQGw";
    public static final String ACHIEVEMENT_THE_LOST_LANDS = "CgkIttPX_-AEEAIQHA";
    public static final String ACHIEVEMENT_THE_NECROMANCER = "CgkIttPX_-AEEAIQIw";
    public static final String ACHIEVEMENT_THE_SEER = "CgkIttPX_-AEEAIQHw";
    public static final String ACHIEVEMENT_THE_SOUTHERN_GROVE = "CgkIttPX_-AEEAIQGQ";
    public static final String ACHIEVEMENT_THE_TOWER = "CgkIttPX_-AEEAIQKg";
    public static final String ACHIEVEMENT_UNITY = "CgkIttPX_-AEEAIQKA";
    public static final String ACHIEVEMENT_VERSATILE_ARMY = "CgkIttPX_-AEEAIQCg";
    public static final String ACHIEVEMENT_VETERAN = "CgkIttPX_-AEEAIQLg";
    public static final String ACHIEVEMENT_WEALTHY = "CgkIttPX_-AEEAIQEQ";
    public static final String ACHIEVEMENT_WORKAHOLIC = "CgkIttPX_-AEEAIQDg";
    private static List<String> achievementQueue;
    
    static {
        AchievementsUtils.achievementQueue = (List<String>)new ArrayList();
    }
    
    private static void doctrineMaxed(final Adventurer adventurer) {
        if (adventurer.getDoctrine() instanceof EmptyDoctrine) {
            return;
        }
        for (final DoctrineAbility doctrineAbility : adventurer.getDoctrine().getAbilities()) {
            if (doctrineAbility.getLevel() < doctrineAbility.getType().maxLevel) {
                return;
            }
        }
        MainActivity.data.setDoctrineMaxed(true);
        unlock("CgkIttPX_-AEEAIQDw");
    }
    
    public static void flushQueue() {
        if (AchievementsUtils.achievementQueue.isEmpty()) {
            return;
        }
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        final Iterator iterator = AchievementsUtils.achievementQueue.iterator();
        while (iterator.hasNext()) {
            PlayGames.getAchievementsClient(activity).unlock((String)iterator.next());
        }
        AchievementsUtils.achievementQueue.clear();
    }
    
    private static Activity getActivity() {
        try {
            return (Activity)MainActivity.dungeonsFragment.getActivity();
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public static void increment(final String s, final int n) {
        final Activity activity = getActivity();
        if (activity != null) {
            PlayGames.getAchievementsClient(activity).increment(s, n);
        }
    }
    
    public static void retroactivelyUnlockAchievements() {
        if (MainActivity.data.getTutorialStep() >= 8) {
            unlock("CgkIttPX_-AEEAIQAQ");
        }
        final int size = MainActivity.data.getAdventurers().size();
        MainActivity.data.setMaxAdventurersOwned(size);
        if (size >= 5) {
            unlock("CgkIttPX_-AEEAIQCA");
        }
        if (size >= 12) {
            unlock("CgkIttPX_-AEEAIQCQ");
        }
        if (size >= 20) {
            unlock("CgkIttPX_-AEEAIQCg");
        }
        final Iterator iterator = MainActivity.data.getPets().iterator();
        while (true) {
            do {
                final boolean hasNext = iterator.hasNext();
                final boolean b = false;
                if (hasNext) {
                    continue;
                }
                final boolean t4Pet = false;
                MainActivity.data.setT4Pet(t4Pet);
                if (t4Pet) {
                    unlock("CgkIttPX_-AEEAIQCw");
                }
                final Iterator iterator2 = MainActivity.data.getAdventurers().iterator();
                int n = 1;
                boolean everAscended = b;
                while (iterator2.hasNext()) {
                    final Adventurer adventurer = (Adventurer)iterator2.next();
                    final int max = Math.max(n, adventurer.getMaxLevel() / 5);
                    boolean b2 = everAscended;
                    if (adventurer.isAscended()) {
                        b2 = true;
                    }
                    DialogConsumePotion.checkHeavyDrinker(adventurer);
                    n = max;
                    everAscended = b2;
                    if (!MainActivity.data.isDoctrineMaxed()) {
                        doctrineMaxed(adventurer);
                        n = max;
                        everAscended = b2;
                    }
                }
                MainActivity.data.setEverAscended(everAscended);
                if (everAscended) {
                    unlock("CgkIttPX_-AEEAIQDA");
                }
                final long money = MainActivity.data.getMoney();
                MainActivity.data.setMaxWealth(money);
                if (money > 10000L) {
                    unlock("CgkIttPX_-AEEAIQEQ");
                }
                if (money > 1000000L) {
                    unlock("CgkIttPX_-AEEAIQEg");
                }
                if (MainActivity.data.getTheDesert().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQEw");
                }
                if (MainActivity.data.getEternalBattlefield().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQFA");
                }
                if (MainActivity.data.getTheGoldenCity().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQFQ");
                }
                if (MainActivity.data.getBlackwaterPort().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQFg");
                }
                if (MainActivity.data.getFrostbitePeaks().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQFw");
                }
                if (MainActivity.data.getObsidianMines().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQGA");
                }
                if (MainActivity.data.getTheSouthernGrove().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQGQ");
                }
                if (MainActivity.data.getBarrenWastelands().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQGg");
                }
                if (MainActivity.data.getHiddenCityOfLarox().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQGw");
                }
                if (MainActivity.data.getLostLands().isUnlocked()) {
                    unlock("CgkIttPX_-AEEAIQHA");
                }
                if (MainActivity.data.getDivineArcheology().completed()) {
                    unlock("CgkIttPX_-AEEAIQHQ");
                }
                if (MainActivity.data.getImperialRescue().completed()) {
                    unlock("CgkIttPX_-AEEAIQHg");
                }
                if (MainActivity.data.getTheDreadfulAscent().completed()) {
                    unlock("CgkIttPX_-AEEAIQHw");
                }
                if (MainActivity.data.getCelestialMothership().completed()) {
                    unlock("CgkIttPX_-AEEAIQIA");
                }
                if (MainActivity.data.getTheDireDescent().completed()) {
                    unlock("CgkIttPX_-AEEAIQIQ");
                }
                if (MainActivity.data.getTheSlimePond().getMaxProgress() > 6) {
                    unlock("CgkIttPX_-AEEAIQIg");
                }
                if (MainActivity.data.getAncientGraveDigging().getMaxProgress() > 11) {
                    unlock("CgkIttPX_-AEEAIQIw");
                }
                if (MainActivity.data.getSeenItems().contains((Object)"ElixirOfLearning") || MainActivity.data.getSeenItems().contains((Object)"EternalHunger") || MainActivity.data.getSeenItems().contains((Object)"SealOfClaris")) {
                    unlock("CgkIttPX_-AEEAIQJA");
                }
                if (MainActivity.data.getSeenItems().contains((Object)"ExaltedPowder") || MainActivity.data.getSeenItems().contains((Object)"ColossalSword")) {
                    unlock("CgkIttPX_-AEEAIQJQ");
                }
                if (MainActivity.data.getSeenItems().contains((Object)"StarFragment")) {
                    unlock("CgkIttPX_-AEEAIQJg");
                }
                if (MainActivity.data.getSeenItems().contains((Object)"AstralGoo") || MainActivity.data.getSeenItems().contains((Object)"CosmicViolin")) {
                    unlock("CgkIttPX_-AEEAIQJw");
                }
                if (MainActivity.data.getSleepingPlanet().getMaxProgress() > 14) {
                    unlock("CgkIttPX_-AEEAIQKA");
                }
                if (MainActivity.data.getSleepingPlanet().getMaxProgress() > 16) {
                    unlock("CgkIttPX_-AEEAIQKQ");
                }
                if (MainActivity.data.getSleepingPlanet().getMaxProgress() > 35) {
                    unlock("CgkIttPX_-AEEAIQKg");
                }
                if (n > 1) {
                    unlock("CgkIttPX_-AEEAIQKw");
                }
                if (n > 2) {
                    unlock("CgkIttPX_-AEEAIQLA");
                }
                if (n > 3) {
                    unlock("CgkIttPX_-AEEAIQLQ");
                }
                if (n > 4) {
                    unlock("CgkIttPX_-AEEAIQLg");
                }
                if (n > 5) {
                    unlock("CgkIttPX_-AEEAIQLw");
                }
                if (n > 6) {
                    unlock("CgkIttPX_-AEEAIQMA");
                }
                if (n > 7) {
                    unlock("CgkIttPX_-AEEAIQMQ");
                }
                if (n > 8) {
                    unlock("CgkIttPX_-AEEAIQMg");
                }
                return;
            } while (((Pet)iterator.next()).getAbilityNumber() != 4);
            final boolean t4Pet = true;
            continue;
        }
    }
    
    public static void unlock(final String s) {
        final Activity activity = getActivity();
        if (activity != null) {
            PlayGames.getAchievementsClient(activity).unlock(s);
        }
        else {
            AchievementsUtils.achievementQueue.add((Object)s);
        }
    }
}
