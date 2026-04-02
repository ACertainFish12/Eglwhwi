package it.paranoidsquirrels.idleguildmaster;

import android.text.Html;
import android.widget.ImageView;
import android.content.res.Configuration;
import com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener;
import androidx.viewpager2.widget.ViewPager2$PageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.fragment.app.FragmentActivity;
import java.util.Locale;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.games.PlayGamesSdk;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import androidx.appcompat.app.AppCompatDelegate;
import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.AdRequest$Builder;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import android.view.View;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.games.AuthenticationResult;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import it.paranoidsquirrels.idleguildmaster.storage.FileManager;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.View$OnClickListener;
import com.google.android.gms.tasks.OnSuccessListener;
import android.app.Activity;
import com.google.android.gms.games.PlayGames;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import java.util.Arrays;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import java.io.IOException;
import com.google.android.gms.games.SnapshotsClient$DataOrConflict;
import com.google.android.gms.games.snapshot.Snapshot;
import it.paranoidsquirrels.idleguildmaster.storage.data.SnapshotData;
import com.google.android.gms.tasks.Task;
import android.content.DialogInterface;
import java.util.Iterator;
import java.util.List;
import it.paranoidsquirrels.idleguildmaster.storage.SaveManager;
import android.util.MutableLong;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import android.os.Handler;
import it.paranoidsquirrels.idleguildmaster.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMessagesReceived;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogWorkshop;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogTavern;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogStorage;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShelter;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSell;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSelectEquipment;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogReport;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefreshQuests;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRedeemCode;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecipes;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRecallAdventurers;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuests;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuarters;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPromotionChoices;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogPetDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMergePet;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMerchant;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogMarket;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogIdleProgress;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogFaq;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrineReset;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCraft;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfRejuvenation;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotionOfClumsiness;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeIntercession;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeFood;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeEvo23;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogCollectDrops;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChoosePet;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseDoctrine;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChooseAdventurer;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogChangeTraitRare;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBuyFromMerchant;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogBestiary;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail;
import android.app.AlertDialog;
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment;
import it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment;
import it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment;
import android.util.MutableBoolean;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    public static IAPWrapper IAPWrapper;
    public static MutableBoolean IDLE_THREAD_FINISHED;
    public static final String SAVE_FILE_NAME = "game_saved";
    public static AdventurersFragment adventurersFragment;
    public static final MutableBoolean applicationPaused;
    public static Data data;
    public static DungeonsFragment dungeonsFragment;
    public static HeadquartersFragment headquartersFragment;
    public static RaidsFragment raidsFragment;
    public static AlertDialog shownAdDialog;
    public static AlertDialog shownAdFreeDialog;
    public static DialogEntityDetail shownDialogAdventurerDetailPromotion;
    public static DialogBestiary shownDialogBestiary;
    public static DialogBuyFromMerchant shownDialogBuyFromMerchant;
    public static DialogChangeTraitRare shownDialogChangeTraitRare;
    public static DialogChooseAdventurer shownDialogChooseAdventurer;
    public static DialogChooseDoctrine shownDialogChooseDoctrine;
    public static DialogChoosePet shownDialogChoosePet;
    public static AlertDialog shownDialogCloud;
    public static DialogCollectDrops shownDialogCollectDrops;
    public static DialogConsumeEvo23 shownDialogConsumeEvo23;
    public static DialogConsumeFood shownDialogConsumeFood;
    public static DialogConsumeIntercession shownDialogConsumeIntercession;
    public static DialogConsumePotion shownDialogConsumePotion;
    public static DialogConsumePotionOfClumsiness shownDialogConsumePotionOfClumsiness;
    public static DialogConsumePotionOfRejuvenation shownDialogConsumePotionOfRejuvenation;
    public static DialogCraft shownDialogCraft;
    public static DialogDoctrine shownDialogDoctrine;
    public static DialogDoctrineReset shownDialogDoctrineReset;
    public static DialogDungeonDetail shownDialogDungeonDetail;
    public static DialogEntityDetail shownDialogEntityDetail;
    public static DialogFaq shownDialogFaq;
    public static AlertDialog shownDialogFullStorage;
    public static DialogIdleProgress shownDialogIdleProgress;
    public static AlertDialog shownDialogIndividualFaq;
    public static DialogItemDetail shownDialogItemDetail;
    public static DialogMarket shownDialogMarket;
    public static DialogMerchant shownDialogMerchant;
    public static DialogMergePet shownDialogMergePet;
    public static DialogPetDetail shownDialogPetDetail;
    public static DialogPromotionChoices shownDialogPromotionChoices;
    public static DialogQuarters shownDialogQuarters;
    public static DialogQuests shownDialogQuests;
    public static DialogRecallAdventurers shownDialogRecallAdventurers;
    public static DialogRecipes shownDialogRecipes;
    public static DialogRedeemCode shownDialogRedeemCode;
    public static DialogRefillRaidTry shownDialogRefillRaidTry;
    public static DialogRefreshQuests shownDialogRefreshQuests;
    public static DialogReport shownDialogReport;
    public static DialogSelectEquipment shownDialogSelectEquipment;
    public static DialogSell shownDialogSell;
    public static DialogSendTeam shownDialogSendTeam;
    public static DialogSettings shownDialogSettings;
    public static DialogShelter shownDialogShelter;
    public static DialogShop shownDialogShop;
    public static DialogStorage shownDialogStorage;
    public static DialogTavern shownDialogTavern;
    public static DialogWorkshop shownDialogWorkshop;
    public static AlertDialog shownKingMessageDialog;
    public static DialogMessagesReceived shownMessagesReceived;
    private final FullScreenContentCallback adCallback;
    private AdRequest adRequest;
    public ActivityMainBinding binding;
    private Handler handlerUI;
    private RewardedAd rewardedAd;
    private Thread updaterIdleProgress;
    private Thread updaterUI;
    
    static {
        applicationPaused = new MutableBoolean(false);
        MainActivity.IDLE_THREAD_FINISHED = new MutableBoolean(false);
    }
    
    public MainActivity() {
        this.adRequest = null;
        this.rewardedAd = null;
        this.adCallback = new FullScreenContentCallback() {
            final MainActivity this$0;
            
            public void onAdClicked() {
            }
            
            public void onAdDismissedFullScreenContent() {
                this.this$0.rewardedAd = null;
                this.this$0.loadAd();
            }
            
            public void onAdFailedToShowFullScreenContent(final AdError adError) {
                this.this$0.rewardedAd = null;
                this.this$0.loadAd();
            }
            
            public void onAdImpression() {
            }
            
            public void onAdShowedFullScreenContent() {
            }
        };
    }
    
    private MainActivity getThis() {
        return this;
    }
    
    private void initializeThreads() {
        final int min = Math.min(4, 4);
        final long lastAccess = MainActivity.data.getLastAccess();
        final long millis = TrueTimeUtils.millis();
        long max = 1L;
        if (lastAccess != 0L) {
            max = Math.max(1L, Math.min((long)((min + 8) * 3600), Math.round((millis - lastAccess) / 1000.0)));
        }
        Utils.progressTavernTime(max);
        Utils.progressMarketTime(max);
        Utils.progressWorkshopTime(max);
        Utils.checkDismissedAdventurersExpiration(millis);
        final Iterator iterator = Utils.compileDungeonRaidList().iterator();
        while (true) {
            while (iterator.hasNext()) {
                if (!((Area)iterator.next()).getAdventurersExploringIds().isEmpty()) {
                    final boolean b = true;
                    if (max > 60L && b) {
                        (MainActivity.shownDialogIdleProgress = new DialogIdleProgress()).skipOnShowListener();
                        MainActivity.shownDialogIdleProgress.setCancelable(false);
                        MainActivity.shownDialogIdleProgress.show(this.getSupportFragmentManager(), "dialog_idle_progress");
                    }
                    final MutableLong mutableLong = new MutableLong(0L);
                    (this.updaterIdleProgress = new Thread(this, max, mutableLong, millis) {
                        final MainActivity this$0;
                        final long val$currentTime;
                        final MutableLong val$progress;
                        final long val$secondsElapsed;
                        
                        public void run() {
                            final List<Area> compileDungeonRaidList = Utils.compileDungeonRaidList();
                            int n = 0;
                            while (true) {
                                final long n2 = n;
                                if (n2 >= this.val$secondsElapsed) {
                                    MainActivity.IDLE_THREAD_FINISHED.value = true;
                                    SaveManager.getInstance().save(this.this$0.getApplicationContext());
                                    return;
                                }
                                if (MainActivity.applicationPaused.value) {
                                    return;
                                }
                                final Iterator iterator = compileDungeonRaidList.iterator();
                                while (iterator.hasNext()) {
                                    ((Area)iterator.next()).tick();
                                }
                                final MutableLong val$progress = this.val$progress;
                                ++val$progress.value;
                                MainActivity.data.setLastAccess(this.val$currentTime - (this.val$secondsElapsed - n2) * 1000L);
                                ++n;
                            }
                        }
                    }).start();
                    final MutableBoolean mutableBoolean = new MutableBoolean(true);
                    final MutableBoolean mutableBoolean2 = new MutableBoolean(true);
                    if (this.handlerUI == null) {
                        this.handlerUI = new Handler();
                        final Thread updaterUI = new Thread(this, mutableBoolean2, mutableBoolean, mutableLong, max) {
                            final MainActivity this$0;
                            final MutableBoolean val$firstRun;
                            final MutableBoolean val$firstTick;
                            final MutableLong val$progress;
                            final long val$secondsElapsed;
                            
                            public void run() {
                                final HeadquartersFragment headquartersFragment = MainActivity.headquartersFragment;
                                final int n = 1;
                                final boolean b = headquartersFragment != null && MainActivity.headquartersFragment.getBinding() != null;
                                final boolean b2 = MainActivity.dungeonsFragment != null && MainActivity.dungeonsFragment.getBinding() != null;
                                final boolean b3 = MainActivity.adventurersFragment != null && MainActivity.adventurersFragment.getBinding() != null;
                                final boolean b4 = MainActivity.raidsFragment != null && MainActivity.raidsFragment.getBinding() != null;
                                int n2;
                                if (b && b2 && (!RaidsFragment.VISIBLE || b4) && b3) {
                                    n2 = n;
                                }
                                else {
                                    n2 = 0;
                                }
                                final boolean value = MainActivity.IDLE_THREAD_FINISHED.value;
                                long n3 = 10L;
                                if (value && n2 != 0) {
                                    if (this.val$firstTick.value) {
                                        this.val$firstTick.value = false;
                                        this.this$0.onLoadingComplete();
                                    }
                                    Utils.nextTimeTick();
                                    final Handler access$100 = this.this$0.handlerUI;
                                    if (!this.val$firstRun.value) {
                                        n3 = 1000L;
                                    }
                                    access$100.postDelayed((Runnable)this, n3);
                                }
                                else {
                                    if (MainActivity.shownDialogIdleProgress != null) {
                                        MainActivity.shownDialogIdleProgress.refreshProgress((int)(this.val$progress.value * 100L / (double)this.val$secondsElapsed));
                                    }
                                    this.this$0.handlerUI.postDelayed((Runnable)this, 10L);
                                }
                                this.val$firstRun.value = false;
                            }
                        };
                        this.updaterUI = updaterUI;
                        this.handlerUI.post((Runnable)updaterUI);
                    }
                    SaveManager.getInstance().startTimer(this.getApplicationContext());
                    return;
                }
            }
            final boolean b = false;
            continue;
        }
    }
    
    private void onLoadingComplete() {
        MainActivity.headquartersFragment.refresh();
        MainActivity.dungeonsFragment.refresh();
        MainActivity.dungeonsFragment.refreshDungeonVisibility();
        if (RaidsFragment.VISIBLE) {
            MainActivity.raidsFragment.refresh();
            MainActivity.raidsFragment.refreshRaidVisibility();
        }
        MainActivity.adventurersFragment.refresh();
        this.refresh();
        this.refreshRaidsFragmentVisibility();
        final DialogIdleProgress shownDialogIdleProgress = MainActivity.shownDialogIdleProgress;
        if (shownDialogIdleProgress != null) {
            shownDialogIdleProgress.dismiss();
            MainActivity.shownDialogIdleProgress = null;
        }
        AchievementsUtils.flushQueue();
    }
    
    private void retroactivelyAddKnownRecipes() {
    Label_0019:
        for (final Recipes recipes : Arrays.asList((Object[])new Recipes[] { Recipes.VoltaicShock })) {
            final Iterator iterator2 = recipes.getIngredients().iterator();
            while (true) {
                while (iterator2.hasNext()) {
                    if (MainActivity.data.getSeenItems().contains((Object)((Item)iterator2.next()).getTrueClass())) {
                        final boolean b = true;
                        if (b) {
                            MainActivity.data.getKnownRecipes().add((Object)recipes);
                            continue Label_0019;
                        }
                        continue Label_0019;
                    }
                }
                final boolean b = false;
                continue;
            }
        }
    }
    
    private void retroactivelyGrantEvo23Vial2() {
        if (!MainActivity.data.isVial2RetGrant()) {
            MainActivity.data.setVial2RetGrant(true);
            if (MainActivity.data.isAdventurerPackPurchased()) {
                Utils.collectItem(Item.getInstance("Evo23Vial2", 1), MainActivity.data.getItems());
            }
        }
    }
    
    private void retroactivelyGrantIntercession() {
        if (!MainActivity.data.isIntercessionsRetroactivelyGranted()) {
            MainActivity.data.setIntercessionsRetroactivelyGranted(true);
            if (MainActivity.data.isImperialVanguardPurchased()) {
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.getItems());
            }
            if (MainActivity.data.isUnholyCrusadePurchased()) {
                Utils.collectItem(Item.getInstance("Intercession", 1), MainActivity.data.getItems());
            }
        }
    }
    
    private void retroactivelySetSeenQuests() {
        if (!MainActivity.data.getKingsQuests().isEmpty() || !MainActivity.data.getAfflictionQuests().isEmpty() || !MainActivity.data.getControlQuests().isEmpty() || !MainActivity.data.getFortitudeQuests().isEmpty() || !MainActivity.data.getGraceQuests().isEmpty() || !MainActivity.data.getIllusionQuests().isEmpty() || !MainActivity.data.getKnowledgeQuests().isEmpty() || !MainActivity.data.getRuinQuests().isEmpty() || !MainActivity.data.getWarQuests().isEmpty()) {
            MainActivity.data.setQuestsSeen(true);
        }
    }
    
    private void retroactivelyUnlockCelestialMothership() {
        if (MainActivity.data.getBarrenWastelands().getMaxProgress() >= 180 && !MainActivity.data.getCelestialMothership().isUnlocked()) {
            UIUtils.unlockArea((Area)MainActivity.data.getCelestialMothership());
        }
    }
    
    private void retroactivelyUnlockHiddenCityOfLarox() {
        if (MainActivity.data.getBarrenWastelands().getMaxProgress() >= 100 && !MainActivity.data.getHiddenCityOfLarox().isUnlocked()) {
            UIUtils.unlockArea((Area)MainActivity.data.getHiddenCityOfLarox());
        }
    }
    
    private void retroactivelyUnlockLast3() {
        if (MainActivity.data.getTheDireDescent().getMaxProgress() >= 7) {
            if (!MainActivity.data.getSleepingPlanet().isUnlocked()) {
                UIUtils.unlockArea((Area)MainActivity.data.getSleepingPlanet());
            }
            if (!MainActivity.data.getKaunis().isUnlocked()) {
                UIUtils.unlockArea((Area)MainActivity.data.getKaunis());
            }
            if (!MainActivity.data.getTheTower().isUnlocked()) {
                UIUtils.unlockArea((Area)MainActivity.data.getTheTower());
            }
        }
    }
    
    private void retroactivelyUnlockLostLands() {
        if (MainActivity.data.getHiddenCityOfLarox().getMaxProgress() >= 100 && !MainActivity.data.getLostLands().isUnlocked()) {
            UIUtils.unlockArea((Area)MainActivity.data.getLostLands());
        }
    }
    
    private void retroactivelyUnlockTheDireDescent() {
        if (MainActivity.data.getLostLands().getMaxProgress() >= 100 && !MainActivity.data.getTheDireDescent().isUnlocked()) {
            UIUtils.unlockArea((Area)MainActivity.data.getTheDireDescent());
        }
    }
    
    private void retroactivelyUnlockTheLostExpedition() {
        if (MainActivity.data.getObsidianMines().getMaxProgress() >= 220 && !MainActivity.data.getTheLostExpedition().isUnlocked()) {
            UIUtils.unlockArea((Area)MainActivity.data.getTheLostExpedition());
        }
    }
    
    private void viewSaves() {
        PlayGames.getSnapshotsClient((Activity)this).getSelectSnapshotIntent("Saved Instance", true, true, 1).addOnSuccessListener((OnSuccessListener)new MainActivity$$ExternalSyntheticLambda26(this));
    }
    
    public void attachListeners() {
        this.binding.containerGems.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda16(this));
        this.binding.menuButton.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda17(this));
        this.binding.navViewDrawer.getMenu().findItem(2131297227).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda6(this));
        this.binding.navViewDrawer.getMenu().findItem(2131297220).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda7(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296679).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda8(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296967).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda37(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296752).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda38(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296429).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda39(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296316).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda1(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296505).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda2(this));
        this.binding.navViewDrawer.getMenu().findItem(2131297152).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda3(this));
        this.binding.navViewDrawer.getMenu().findItem(2131297151).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda4(this));
        this.binding.navViewDrawer.getMenu().findItem(2131296468).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new MainActivity$$ExternalSyntheticLambda5(this));
        this.binding.kingMessage.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda9(this));
        this.binding.merchant.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda10(this));
        this.binding.ad.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda12(this));
        this.binding.adfree.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda13(this));
        this.binding.shop.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda14(this));
        this.binding.quests.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda15(this));
    }
    
    void checkPrices() {
        for (final Recipes recipes : Recipes.values()) {
            long n = 0L;
            for (final Item item : recipes.getIngredients()) {
                n += item.getPrice() * item.getStack();
            }
            final double n2 = n * 1.5;
            long round;
            if (n2 % 0.5 == 0.0) {
                round = (long)Math.ceil(n2);
            }
            else {
                round = Math.round(n2);
            }
            if (round != recipes.getResult().getPrice()) {
                System.out.println("Incorrect price for " + recipes.getResult().getTrueClass() + ": expected " + round + ", found " + recipes.getResult().getPrice());
            }
        }
    }
    
    public void loadAd() {
        if (MainActivity.data.getAdsWatched() >= 5) {
            this.refreshIcons();
            return;
        }
        if (MainActivity.data.isStarterPackPurchased()) {
            return;
        }
        if (this.adRequest == null) {
            this.adRequest = new AdRequest$Builder().build();
        }
        RewardedAd.load((Context)this, "ca-app-pub-4589624666705243/2778487135", this.adRequest, (RewardedAdLoadCallback)new RewardedAdLoadCallback(this) {
            final MainActivity this$0;
            
            public void onAdFailedToLoad(final LoadAdError loadAdError) {
                this.this$0.rewardedAd = null;
                this.this$0.refreshIcons();
                new Handler().postDelayed((Runnable)new MainActivity$4$$ExternalSyntheticLambda0(this), 60000L);
            }
            
            public void onAdLoaded(final RewardedAd rewardedAd) {
                this.this$0.rewardedAd = rewardedAd;
                this.this$0.rewardedAd.setFullScreenContentCallback(this.this$0.adCallback);
                this.this$0.refreshIcons();
            }
        });
    }
    
    public Task<SnapshotData> loadSavedGame() {
        try {
            return (Task<SnapshotData>)PlayGames.getSnapshotsClient((Activity)this).open("game_saved", true, 3).addOnFailureListener((OnFailureListener)MainActivity$$ExternalSyntheticLambda24.INSTANCE).continueWith((Continuation)MainActivity$$ExternalSyntheticLambda20.INSTANCE);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        AppCompatDelegate.setDefaultNightMode(2);
        super.onCreate(bundle);
        UIUtils.hideUI(this.getWindow());
        this.getSupportActionBar().hide();
        if (0x10 == (this.getResources().getConfiguration().uiMode & 0x30)) {
            this.startActivity(new Intent((Context)this, (Class)MainActivity.class));
            return;
        }
        TrueTimeUtils.init();
        MainActivity.data = FileManager.load((Context)this);
        QuestsManager.initializeFields(QuestsManager.calculateDifficulty());
        QuestsManager.realignQuests();
        PlayGamesSdk.initialize((Context)this);
        MobileAds.initialize((Context)this, (OnInitializationCompleteListener)new MainActivity$$ExternalSyntheticLambda19(this));
        if (MainActivity.IAPWrapper == null) {
            (MainActivity.IAPWrapper = new IAPWrapper(this.getApplicationContext())).setRefreshGemsCallback((Runnable)new MainActivity$$ExternalSyntheticLambda28(this));
            MainActivity.IAPWrapper.setRefreshAdventurersCallback((Runnable)MainActivity$$ExternalSyntheticLambda30.INSTANCE);
            MainActivity.IAPWrapper.setRefreshHeadquartersCallback((Runnable)MainActivity$$ExternalSyntheticLambda31.INSTANCE);
            MainActivity.IAPWrapper.setRefreshIconsCallback((Runnable)new MainActivity$$ExternalSyntheticLambda29(this));
            MainActivity.IAPWrapper.setRefreshShopCallback((Runnable)MainActivity$$ExternalSyntheticLambda32.INSTANCE);
        }
        String s;
        if (MainActivity.data.getSettingsLanguage().isEmpty()) {
            s = Locale.getDefault().getLanguage();
        }
        else {
            s = MainActivity.data.getSettingsLanguage();
        }
        final Locale locale = new Locale(s);
        Locale.setDefault(locale);
        final Configuration configuration = this.getResources().getConfiguration();
        configuration.setLocale(locale);
        this.getResources().updateConfiguration(configuration, this.getResources().getDisplayMetrics());
        final ActivityMainBinding inflate = ActivityMainBinding.inflate(this.getLayoutInflater());
        this.binding = inflate;
        this.setContentView((View)inflate.getRoot());
        this.binding.pager.setAdapter((RecyclerView$Adapter)UIUtils.getPagerAdapter((FragmentActivity)this));
        this.binding.pager.setOffscreenPageLimit(4);
        this.binding.pager.setPageTransformer((ViewPager2$PageTransformer)new MarginPageTransformer(160));
        this.binding.navView.setOnItemSelectedListener((NavigationBarView$OnItemSelectedListener)new MainActivity$$ExternalSyntheticLambda27(this));
        this.retroactivelyUnlockHiddenCityOfLarox();
        this.retroactivelyUnlockLostLands();
        this.retroactivelyUnlockTheLostExpedition();
        this.retroactivelyUnlockCelestialMothership();
        this.retroactivelyUnlockTheDireDescent();
        this.retroactivelyGrantIntercession();
        this.retroactivelyGrantEvo23Vial2();
        this.retroactivelyUnlockLast3();
        this.retroactivelySetSeenQuests();
        if (MainActivity.data.getMaxWealth() == 0L && MainActivity.data.getMaxAdventurersOwned() == 0) {
            AchievementsUtils.retroactivelyUnlockAchievements();
        }
        this.refresh();
        this.refreshRaidsFragmentVisibility();
        this.attachListeners();
    }
    
    protected void onPause() {
        SaveManager.getInstance().stopTimerTask();
        SaveManager.getInstance().save(this.getApplicationContext());
        MainActivity.applicationPaused.value = true;
        this.handlerUI.removeCallbacks((Runnable)this.updaterUI);
        this.handlerUI = null;
        final DialogIdleProgress shownDialogIdleProgress = MainActivity.shownDialogIdleProgress;
        if (shownDialogIdleProgress != null) {
            shownDialogIdleProgress.dismiss();
            MainActivity.shownDialogIdleProgress = null;
        }
        final DialogDungeonDetail shownDialogDungeonDetail = MainActivity.shownDialogDungeonDetail;
        if (shownDialogDungeonDetail != null) {
            shownDialogDungeonDetail.dismiss();
            MainActivity.shownDialogDungeonDetail = null;
        }
        final DialogPromotionChoices shownDialogPromotionChoices = MainActivity.shownDialogPromotionChoices;
        if (shownDialogPromotionChoices != null) {
            shownDialogPromotionChoices.dismiss();
            MainActivity.shownDialogPromotionChoices = null;
        }
        super.onPause();
    }
    
    protected void onResume() {
        super.onResume();
        if (MainActivity.IAPWrapper.initialized) {
            MainActivity.IAPWrapper.queryAsync();
        }
        MainActivity.applicationPaused.value = false;
        SaveManager.inhibitSave = false;
        this.initializeThreads();
    }
    
    public void refresh() {
        this.refreshMoney();
        this.refreshGems();
        this.refreshKingMessages();
        this.refreshTutorial();
        this.refreshIcons();
    }
    
    public void refreshGems() {
        this.binding.amountGems.setText((CharSequence)String.valueOf(MainActivity.data.getGems()));
    }
    
    public void refreshIcons() {
        final ActivityMainBinding binding = this.binding;
        if (binding == null) {
            return;
        }
        final ImageView ad = binding.ad;
        final boolean starterPackPurchased = MainActivity.data.isStarterPackPurchased();
        final int n = 8;
        int visibility;
        if (!starterPackPurchased && this.rewardedAd != null && MainActivity.data.getAdsWatched() < 5) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        ad.setVisibility(visibility);
        final ImageView adfree = this.binding.adfree;
        int visibility2;
        if (MainActivity.data.isStarterPackPurchased() && MainActivity.data.getAdsWatched() < 5) {
            visibility2 = 0;
        }
        else {
            visibility2 = 8;
        }
        adfree.setVisibility(visibility2);
        final ImageView shop = this.binding.shop;
        int visibility3;
        if (MainActivity.IAPWrapper.initialized) {
            visibility3 = 0;
        }
        else {
            visibility3 = 8;
        }
        shop.setVisibility(visibility3);
        this.binding.navViewDrawer.getMenu().findItem(2131297227).setVisible(MainActivity.IAPWrapper.initialized);
        this.binding.navViewDrawer.getMenu().findItem(2131296468).setVisible("ko".equals((Object)MainActivity.data.getSettingsLanguage()));
        final ImageView newItems = this.binding.newItems;
        int visibility4;
        if (MainActivity.data.isNewMerchantRegularItems()) {
            visibility4 = 0;
        }
        else {
            visibility4 = 8;
        }
        newItems.setVisibility(visibility4);
        final boolean b = MainActivity.data.getKingsQuests().isEmpty() && MainActivity.data.getAfflictionQuests().isEmpty() && MainActivity.data.getControlQuests().isEmpty() && MainActivity.data.getFortitudeQuests().isEmpty() && MainActivity.data.getGraceQuests().isEmpty() && MainActivity.data.getIllusionQuests().isEmpty() && MainActivity.data.getKnowledgeQuests().isEmpty() && MainActivity.data.getRuinQuests().isEmpty() && MainActivity.data.getWarQuests().isEmpty();
        final ImageView quests = this.binding.quests;
        int visibility5;
        if (MainActivity.data.isQuestsSeen()) {
            visibility5 = 0;
        }
        else {
            visibility5 = 8;
        }
        quests.setVisibility(visibility5);
        final ImageView questsNotification = this.binding.questsNotification;
        int visibility6 = n;
        if (!b) {
            visibility6 = n;
            if (QuestsManager.QUEST_NOTIFICATION) {
                if (!MainActivity.data.isQuestsSeen()) {
                    visibility6 = n;
                }
                else {
                    visibility6 = 0;
                }
            }
        }
        questsNotification.setVisibility(visibility6);
    }
    
    public void refreshKingMessages() {
        final ImageView kingMessage = this.binding.kingMessage;
        int visibility;
        if (MainActivity.data.getMessagesToShow().size() > 0) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        kingMessage.setVisibility(visibility);
    }
    
    public void refreshMoney() {
        UIUtils.populateMoneyContainer(this.binding.money, MainActivity.data.getMoney(), false);
    }
    
    public void refreshRaidsFragmentVisibility() {
        if (RaidsFragment.VISIBLE) {
            return;
        }
        final List<Area> compileRaidList = Utils.compileRaidList();
        final boolean b = false;
        final Iterator iterator = compileRaidList.iterator();
        while (true) {
            do {
                final boolean b2 = b;
                if (iterator.hasNext()) {
                    continue;
                }
                RaidsFragment.VISIBLE = b2;
                this.binding.navView.getMenu().getItem(3).setVisible(b2);
                if (b2) {
                    this.binding.pager.getAdapter().notifyItemInserted(3);
                }
                return;
            } while (!((Area)iterator.next()).isUnlocked());
            final boolean b2 = true;
            continue;
        }
    }
    
    public void refreshTutorial() {
        final int tutorialStep = MainActivity.data.getTutorialStep();
        if (tutorialStep >= 7) {
            this.binding.containerTutorial.setVisibility(8);
            return;
        }
        this.binding.containerTutorial.setVisibility(0);
        int n = 0;
        switch (tutorialStep) {
            default: {
                n = 0;
                break;
            }
            case 6: {
                n = 2131889695;
                break;
            }
            case 5: {
                n = 2131889694;
                break;
            }
            case 4: {
                n = 2131889693;
                break;
            }
            case 3: {
                n = 2131889692;
                break;
            }
            case 2: {
                n = 2131889691;
                break;
            }
            case 0:
            case 1: {
                n = 2131889690;
                break;
            }
        }
        this.binding.tutorialStep.setText((CharSequence)String.format(this.getString(2131889696), new Object[] { tutorialStep }));
        this.binding.tutorialBody.setText((CharSequence)Html.fromHtml(this.getString(n), 63));
    }
    
    void testDataManipulation() {
        this.checkPrices();
    }
}
