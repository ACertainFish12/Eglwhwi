package it.paranoidsquirrels.idleguildmaster;

import java.util.function.BooleanSupplier;
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment;
import it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment;
import it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment;
import it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftNamedBinding;
import android.content.DialogInterface$OnDismissListener;
import android.view.View$OnClickListener;
import androidx.core.content.res.ResourcesCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutBestiaryElementBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.AdapterView;
import android.os.VibrationEffect;
import android.os.Build$VERSION;
import android.os.Vibrator;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SleepingPlanet;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDireDescent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.HiddenCityOfLarox;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BarrenWastelands;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheSouthernGrove;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDreadfulAscent;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.ObsidianMines;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.FrostbitePeaks;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BlackwaterPort;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EternalBattlefield;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheDesert;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine;
import android.content.DialogInterface;
import android.view.Window;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import androidx.fragment.app.FragmentActivity;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import android.text.Html;
import java.util.Iterator;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter;
import android.widget.ArrayAdapter;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import android.widget.BaseAdapter;
import java.util.List;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import androidx.fragment.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.content.DialogInterface$OnShowListener;
import android.app.AlertDialog$Builder;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import android.content.res.Resources;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import androidx.fragment.app.Fragment;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutMoneyBinding;
import android.app.AlertDialog;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding;
import java.text.DecimalFormat;

public class UIUtils
{
    private static DecimalFormat df1;
    private static DecimalFormat df2;
    
    static {
        UIUtils.df1 = new DecimalFormat("0.0");
        UIUtils.df2 = new DecimalFormat("0.00");
    }
    
    public static void applyAscendedPalette(final LayoutAdventurerBinding layoutAdventurerBinding) {
        final Context context = layoutAdventurerBinding.getRoot().getContext();
        layoutAdventurerBinding.containerAdventurer.setBackgroundResource(2131231398);
        layoutAdventurerBinding.weapon.setBackgroundResource(2131231398);
        layoutAdventurerBinding.armor.setBackgroundResource(2131231398);
        layoutAdventurerBinding.accessory.setBackgroundResource(2131231398);
        layoutAdventurerBinding.image.setBackgroundResource(2131231414);
        layoutAdventurerBinding.name.setTextColor(context.getResources().getColor(2131099679, context.getTheme()));
    }
    
    public static AlertDialog askConfirmUpgrade(final Context context, final int n, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return getActionDialog(context, 2131887121, String.format(context.getString(2131887122), new Object[] { context.getString(n) }), 2131890001, dialogInterface$OnClickListener);
    }
    
    public static int backgroundFromRarity(final int n) {
        return 2131231405;
    }
    
    public static void changeMoneyContainerColor(final LayoutMoneyBinding layoutMoneyBinding, final boolean b) {
        final Context context = layoutMoneyBinding.getRoot().getContext();
        int failureColor;
        if (b) {
            failureColor = 2131099765;
        }
        else {
            failureColor = getFailureColor();
        }
        final int color = context.getColor(failureColor);
        layoutMoneyBinding.amountCopper.setTextColor(color);
        layoutMoneyBinding.amountSilver.setTextColor(color);
        layoutMoneyBinding.amountGold.setTextColor(color);
        layoutMoneyBinding.amountPlatinum.setTextColor(color);
    }
    
    public static void clickArea(final Fragment fragment, final Area area) {
        if (area.getAdventurersExploringIds().isEmpty()) {
            if (area.getAreaType() != 0 && !area.getTriesAvailable()) {
                if (MainActivity.shownDialogRefillRaidTry != null) {
                    return;
                }
                final int costToRefresh = area.costToRefresh();
                MainActivity.shownDialogRefillRaidTry = new DialogRefillRaidTry();
                MainActivity.shownDialogRefillRaidTry.title = fragment.getString(2131887807);
                MainActivity.shownDialogRefillRaidTry.description = String.format(fragment.getString(2131887806), new Object[] { costToRefresh });
                MainActivity.shownDialogRefillRaidTry.cost = costToRefresh;
                MainActivity.shownDialogRefillRaidTry.callback = (BooleanSupplier)new UIUtils$$ExternalSyntheticLambda2(costToRefresh, area, fragment);
                MainActivity.shownDialogRefillRaidTry.show(fragment.getParentFragmentManager(), "dialog_spend_gems");
            }
            else {
                if (MainActivity.shownDialogSendTeam != null) {
                    return;
                }
                MainActivity.shownDialogSendTeam = new DialogSendTeam();
                MainActivity.shownDialogSendTeam.area = area;
                MainActivity.shownDialogSendTeam.show(fragment.getParentFragmentManager(), "dialog_send_team");
            }
        }
        else if (!area.terminationRequested) {
            if (MainActivity.shownDialogDungeonDetail != null) {
                return;
            }
            MainActivity.shownDialogDungeonDetail = new DialogDungeonDetail();
            MainActivity.shownDialogDungeonDetail.area = area;
            MainActivity.shownDialogDungeonDetail.show(fragment.getParentFragmentManager(), "dialog_dungeon_detail");
        }
    }
    
    public static String darknessDescription(final int n, final Resources resources) {
        if (n == 0) {
            return String.format(resources.getString(2131888410), new Object[] { n });
        }
        if (n <= 25) {
            return String.format(resources.getString(2131888411), new Object[] { n });
        }
        if (n <= 50) {
            return String.format(resources.getString(2131888412), new Object[] { n });
        }
        if (n <= 75) {
            return String.format(resources.getString(2131888413), new Object[] { n });
        }
        return String.format(resources.getString(2131888414), new Object[] { n });
    }
    
    public static String formatDouble1Decimal(final double n) {
        return UIUtils.df1.format(n);
    }
    
    public static String formatDouble2Decimals(final double n) {
        return UIUtils.df2.format(n);
    }
    
    public static String formatEquipmentDescription(final Equipment equipment, final Resources resources) {
        final String string = formatStat(2131887924, equipment.getMaxHp(), resources) + formatStat(2131887124, equipment.getConstitution(), resources) + formatStat(2131887928, equipment.getIntelligence(), resources) + formatStat(2131887178, equipment.getDexterity(), resources) + formatStat(2131887175, equipment.getDefense(), resources) + formatStat(2131888911, equipment.getMagicDefense(), resources);
        final StringBuilder append = new StringBuilder().append(string);
        final boolean empty = string.isEmpty();
        final String s = "";
        String s2;
        if (!empty && equipment.getIdEffect() != 0) {
            s2 = "\n";
        }
        else {
            s2 = "";
        }
        final StringBuilder append2 = append.append(s2);
        String string2;
        if (equipment.getIdEffect() == 0) {
            string2 = s;
        }
        else {
            string2 = resources.getString(equipment.getIdEffect());
        }
        return append2.append(string2).toString();
    }
    
    public static String formatSeconds(final long n) {
        final int n2 = (int)(n / 3600L);
        final int n3 = (int)(n / 60L % 60L);
        final int n4 = (int)(n % 60L);
        if (n2 == 0) {
            Object o;
            if (n4 > 9) {
                o = n4;
            }
            else {
                o = "0" + n4;
            }
            return String.format("%d:%s", new Object[] { n3, o });
        }
        Object o2;
        if (n3 > 9) {
            o2 = n3;
        }
        else {
            o2 = "0" + n3;
        }
        Object o3;
        if (n4 > 9) {
            o3 = n4;
        }
        else {
            o3 = "0" + n4;
        }
        return String.format("%d:%s:%s", new Object[] { n2, o2, o3 });
    }
    
    public static String formatStat(final int n, final int n2, final Resources resources) {
        final String s = "";
        if (n2 == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        final String string = resources.getString(n);
        String s2 = s;
        if (n2 > 0) {
            s2 = "+";
        }
        return sb.append(String.format(string, new Object[] { s2, n2 })).append(" ").toString();
    }
    
    public static AlertDialog getActionDialog(final Context context, final Integer n, final String message, final int n2, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context, 2131951616);
        if (n != null) {
            alertDialog$Builder.setTitle((int)n);
        }
        alertDialog$Builder.setMessage((CharSequence)message);
        alertDialog$Builder.setNegativeButton((CharSequence)context.getString(2131887090), (DialogInterface$OnClickListener)null);
        alertDialog$Builder.setPositiveButton((CharSequence)context.getString(n2), dialogInterface$OnClickListener);
        final AlertDialog create = alertDialog$Builder.create();
        create.setOnShowListener((DialogInterface$OnShowListener)new UIUtils$$ExternalSyntheticLambda0(create, context));
        create.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        create.getWindow().setBackgroundDrawableResource(2131231046);
        create.getWindow().setFlags(8, 8);
        return create;
    }
    
    public static void getAdventurerDetailDialog(final FragmentManager fragmentManager, final Entity entity, final boolean allowEquipmentChange, final boolean promotion) {
        if (!promotion && MainActivity.shownDialogEntityDetail != null) {
            return;
        }
        if (promotion && MainActivity.shownDialogAdventurerDetailPromotion != null) {
            return;
        }
        if (entity == null) {
            return;
        }
        final DialogEntityDetail dialogEntityDetail = new DialogEntityDetail();
        dialogEntityDetail.setEntity(entity);
        dialogEntityDetail.allowEquipmentChange = allowEquipmentChange;
        dialogEntityDetail.promotion = promotion;
        dialogEntityDetail.show(fragmentManager, "dialog_entity_detail");
    }
    
    public static BaseAdapter getBestiaryListAdapter(final List<Area> list) {
        return new BestiaryAdapter(list);
    }
    
    public static BaseAdapter getDoctrinesAdapter(final List<Doctrine> list, final Adventurer adventurer) {
        return new DoctrinesAdapter(list, adventurer);
    }
    
    public static ArrayAdapter<Enemy> getEnemiesGridAdapter(final Context context, final List<Enemy> list) {
        return new BestiaryGridAdapter(context, 2131492967, list);
    }
    
    public static void getEnemyDetailDialog(final FragmentManager fragmentManager, final Entity entity) {
        getAdventurerDetailDialog(fragmentManager, entity, false, false);
    }
    
    public static ArrayAdapter<EnemyCounter> getEnemyReportGridAdapter(final Context context, final List<EnemyCounter> list) {
        return new GridAdapterEnemies(context, 2131492977, list);
    }
    
    public static int getFailureColor() {
        int n;
        if (MainActivity.data.isSettingColorblindMode()) {
            n = 2131099771;
        }
        else {
            n = 2131099770;
        }
        return n;
    }
    
    public static BaseAdapter getFaqAdapter(final List<Faq> list) {
        return new FaqAdapter(list);
    }
    
    public static int getFightRarity(final List<Enemy> list) {
        final Iterator iterator = list.iterator();
        int rarity = 1;
        while (iterator.hasNext()) {
            final Enemy enemy = (Enemy)iterator.next();
            if (enemy.getRarity() > rarity) {
                rarity = enemy.getRarity();
            }
        }
        if (rarity == 2) {
            return 2131889501;
        }
        if (rarity == 3) {
            return 2131889500;
        }
        if (rarity == 4) {
            return 2131889498;
        }
        if (rarity != 5) {
            return 2131889497;
        }
        return 2131889499;
    }
    
    public static AlertDialog getInfoDialog(final Context context, final Integer n, final String s, final boolean b) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context, 2131951616);
        if (n != null) {
            alertDialog$Builder.setTitle((int)n);
        }
        Object fromHtml = s;
        if (b) {
            fromHtml = Html.fromHtml(s, 63);
        }
        alertDialog$Builder.setMessage((CharSequence)fromHtml);
        alertDialog$Builder.setPositiveButton(2131887101, (DialogInterface$OnClickListener)null);
        final AlertDialog create = alertDialog$Builder.create();
        create.setOnShowListener((DialogInterface$OnShowListener)new UIUtils$$ExternalSyntheticLambda1(create, context));
        create.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        create.getWindow().setBackgroundDrawableResource(2131231046);
        create.getWindow().setFlags(8, 8);
        return create;
    }
    
    public static ArrayAdapter<Item> getItemsGridAdapter(final Context context, final List<Item> list) {
        return new GridAdapter(context, 2131492977, list);
    }
    
    public static BaseAdapter getKingMessagesAdapter(final List<KingMessage> list) {
        return new KingMessagesAdapter(list);
    }
    
    public static ScreenSlidePagerAdapter getPagerAdapter(final FragmentActivity fragmentActivity) {
        return new ScreenSlidePagerAdapter(fragmentActivity);
    }
    
    public static ArrayAdapter<Pet> getPetsGridAdapter(final Context context, final List<Pet> list) {
        return new PetsGridAdapter(context, 2131492982, list);
    }
    
    public static BaseAdapter getRecipesListAdapter(final List<Recipes> list) {
        return new RecipesAdapter(list);
    }
    
    public static void hideUI(final Window window) {
        window.setNavigationBarColor(0);
        window.getDecorView().setSystemUiVisibility(5638);
    }
    
    public static void openDoctrineDialog(final Adventurer adventurer, final Doctrine doctrine) {
        if (MainActivity.shownDialogDoctrine != null) {
            return;
        }
        MainActivity.shownDialogDoctrine = new DialogDoctrine();
        final DialogDoctrine shownDialogDoctrine = MainActivity.shownDialogDoctrine;
        Doctrine doctrine2;
        if (doctrine == null) {
            doctrine2 = adventurer.getDoctrine();
        }
        else {
            doctrine2 = doctrine;
        }
        shownDialogDoctrine.setDoctrine(doctrine2);
        MainActivity.shownDialogDoctrine.setAdventurer(adventurer);
        MainActivity.shownDialogDoctrine.setReadOnly(doctrine != null);
        MainActivity.shownDialogDoctrine.show(MainActivity.headquartersFragment.getParentFragmentManager(), "dialog_doctrine");
    }
    
    public static void openItemDetail(final Item item) {
        if (MainActivity.shownDialogItemDetail != null) {
            return;
        }
        try {
            final FragmentManager parentFragmentManager = MainActivity.headquartersFragment.getParentFragmentManager();
            final DialogItemDetail dialogItemDetail = new DialogItemDetail();
            dialogItemDetail.setItems((List)new ArrayList((Collection)Collections.singletonList((Object)item)));
            dialogItemDetail.show(parentFragmentManager, "item_detail");
        }
        catch (final Exception ex) {}
    }
    
    public static void populateMoneyContainer(final LayoutMoneyBinding layoutMoneyBinding, final long n, final boolean b) {
        final long n2 = n % 100L;
        final long n3 = (n % 10000L - n2) / 100L;
        final long n4 = (n % 1000000L - n3 - n2) / 10000L;
        final long n5 = (n - n4 - n3 - n2) / 1000000L;
        layoutMoneyBinding.amountCopper.setText((CharSequence)String.valueOf(n2));
        layoutMoneyBinding.amountSilver.setText((CharSequence)String.valueOf(n3));
        layoutMoneyBinding.amountGold.setText((CharSequence)String.valueOf(n4));
        layoutMoneyBinding.amountPlatinum.setText((CharSequence)String.valueOf(n5));
        boolean b2 = true;
        final int n6 = 0;
        final boolean b3 = n3 == 0L && n4 == 0L && n5 == 0L;
        final boolean b4 = n4 == 0L && n5 == 0L;
        final boolean b5 = n5 == 0L;
        final boolean b6 = b && n >= 10000L;
        if (!b || n < 1000000L) {
            b2 = false;
        }
        final TextView amountCopper = layoutMoneyBinding.amountCopper;
        int visibility;
        if (b6) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        amountCopper.setVisibility(visibility);
        final ImageView imageCopper = layoutMoneyBinding.imageCopper;
        int visibility2;
        if (b6) {
            visibility2 = 8;
        }
        else {
            visibility2 = 0;
        }
        imageCopper.setVisibility(visibility2);
        final TextView amountSilver = layoutMoneyBinding.amountSilver;
        int visibility3;
        if (!b3 && !b2) {
            visibility3 = 0;
        }
        else {
            visibility3 = 8;
        }
        amountSilver.setVisibility(visibility3);
        final ImageView imageSilver = layoutMoneyBinding.imageSilver;
        int visibility4;
        if (!b3 && !b2) {
            visibility4 = 0;
        }
        else {
            visibility4 = 8;
        }
        imageSilver.setVisibility(visibility4);
        final TextView amountGold = layoutMoneyBinding.amountGold;
        int visibility5;
        if (b4) {
            visibility5 = 8;
        }
        else {
            visibility5 = 0;
        }
        amountGold.setVisibility(visibility5);
        final ImageView imageGold = layoutMoneyBinding.imageGold;
        int visibility6;
        if (b4) {
            visibility6 = 8;
        }
        else {
            visibility6 = 0;
        }
        imageGold.setVisibility(visibility6);
        final TextView amountPlatinum = layoutMoneyBinding.amountPlatinum;
        int visibility7;
        if (b5) {
            visibility7 = 8;
        }
        else {
            visibility7 = 0;
        }
        amountPlatinum.setVisibility(visibility7);
        final ImageView imagePlatinum = layoutMoneyBinding.imagePlatinum;
        int visibility8 = n6;
        if (b5) {
            visibility8 = 8;
        }
        imagePlatinum.setVisibility(visibility8);
    }
    
    public static String traitsToLongString(final Adventurer adventurer, final Resources resources) {
        final Trait traitCommon = adventurer.getTraitCommon();
        final Trait traitRare = adventurer.getTraitRare();
        if (traitCommon == null && traitRare == null) {
            return "";
        }
        if (traitCommon != null && traitRare != null) {
            return String.format(resources.getString(2131889689), new Object[] { resources.getString(traitCommon.name), resources.getString(traitCommon.description), resources.getString(traitRare.name), resources.getString(traitRare.description) });
        }
        if (traitCommon != null) {
            return String.format(resources.getString(2131889688), new Object[] { resources.getString(traitCommon.name), resources.getString(traitCommon.description) });
        }
        return String.format(resources.getString(2131889688), new Object[] { resources.getString(traitRare.name), resources.getString(traitRare.description) });
    }
    
    public static String traitsToShortString(final Adventurer adventurer, final Resources resources) {
        final Trait traitCommon = adventurer.getTraitCommon();
        final Trait traitRare = adventurer.getTraitRare();
        if (traitCommon == null && traitRare == null) {
            return "";
        }
        if (traitCommon != null && traitRare != null) {
            return resources.getString(traitCommon.name) + ", " + resources.getString(traitRare.name);
        }
        if (traitCommon != null) {
            return resources.getString(traitCommon.name);
        }
        return resources.getString(traitRare.name);
    }
    
    public static void unlockArea(final Area area) {
        area.setUnlocked(true);
        area.setTriesAvailable(true);
        if (area instanceof TheDesert) {
            unlockMessage(KingMessage.MESSAGE_2);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQEw");
        }
        else if (area instanceof EternalBattlefield) {
            unlockMessage(KingMessage.MESSAGE_3);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQFA");
        }
        else if (area instanceof TheGoldenCity) {
            unlockMessage(KingMessage.MESSAGE_4);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQFQ");
        }
        else if (area instanceof BlackwaterPort) {
            unlockMessage(KingMessage.MESSAGE_5);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQFg");
        }
        else if (area instanceof FrostbitePeaks) {
            unlockMessage(KingMessage.MESSAGE_6);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQFw");
        }
        else if (area instanceof ObsidianMines) {
            unlockMessage(KingMessage.MESSAGE_7);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQGA");
        }
        else if (area instanceof TheDreadfulAscent) {
            unlockMessage(KingMessage.MESSAGE_8);
        }
        else if (area instanceof TheSouthernGrove) {
            unlockMessage(KingMessage.MESSAGE_9);
            unlockMessage(KingMessage.MESSAGE_10);
            unlockMessage(KingMessage.MESSAGE_11);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQGQ");
        }
        else if (area instanceof BarrenWastelands) {
            unlockMessage(KingMessage.MESSAGE_12);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQGg");
        }
        else if (area instanceof HiddenCityOfLarox) {
            unlockMessage(KingMessage.MESSAGE_13);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQGw");
        }
        else if (area instanceof LostLands) {
            unlockMessage(KingMessage.MESSAGE_14);
            AchievementsUtils.unlock("CgkIttPX_-AEEAIQHA");
        }
        else if (area instanceof TheDireDescent) {
            unlockMessage(KingMessage.MESSAGE_15);
        }
        else if (area instanceof SleepingPlanet) {
            unlockMessage(KingMessage.MESSAGE_16);
            unlockMessage(KingMessage.MESSAGE_17);
        }
        if (MainActivity.dungeonsFragment != null && Utils.isMainLooper()) {
            MainActivity.dungeonsFragment.refreshDungeonVisibility();
            final MainActivity mainActivity = (MainActivity)MainActivity.dungeonsFragment.getActivity();
            mainActivity.refreshKingMessages();
            mainActivity.refreshRaidsFragmentVisibility();
        }
        if (MainActivity.raidsFragment != null && Utils.isMainLooper()) {
            MainActivity.raidsFragment.refreshRaidVisibility();
        }
    }
    
    private static void unlockMessage(final KingMessage kingMessage) {
        MainActivity.data.getMessagesToShow().add((Object)kingMessage);
        MainActivity.data.getMessagesGotten().add((Object)kingMessage);
    }
    
    public static void vibrate(final Context context) {
        final Vibrator vibrator = (Vibrator)context.getSystemService("vibrator");
        if (Build$VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(50L, -1));
        }
        else {
            vibrator.vibrate(50L);
        }
    }
    
    private static class BestiaryAdapter extends BaseAdapter
    {
        List<Area> areas;
        
        public BestiaryAdapter(final List<Area> areas) {
            this.areas = areas;
        }
        
        private Area get(final int n) {
            final Iterator iterator = this.areas.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                final Area area = (Area)iterator.next();
                if (n == n2) {
                    return area;
                }
                ++n2;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + n + " of a Set with size " + this.areas.size());
        }
        
        public int getCount() {
            return this.areas.size();
        }
        
        public Object getItem(final int n) {
            return this.get(n);
        }
        
        public long getItemId(final int n) {
            return 0L;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            LayoutBestiaryElementViewHolder layoutBestiaryElementViewHolder;
            if (view == null) {
                layoutBestiaryElementViewHolder = new LayoutBestiaryElementViewHolder(LayoutBestiaryElementBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
            }
            else {
                layoutBestiaryElementViewHolder = (LayoutBestiaryElementViewHolder)view.getTag();
            }
            final LayoutBestiaryElementBinding access$200 = layoutBestiaryElementViewHolder.binding;
            final Context context = access$200.getRoot().getContext();
            final Area value = this.get(n);
            final List<Enemy> listEnemies = value.listEnemies();
            access$200.areaName.setText((CharSequence)context.getString(value.getName()));
            access$200.enemiesGrid.setAdapter((ListAdapter)UIUtils.getEnemiesGridAdapter(context, listEnemies));
            access$200.enemiesGrid.setOnItemClickListener((AdapterView$OnItemClickListener)new UIUtils$BestiaryAdapter$$ExternalSyntheticLambda0(listEnemies));
            return layoutBestiaryElementViewHolder.view;
        }
        
        private static class LayoutBestiaryElementViewHolder
        {
            private LayoutBestiaryElementBinding binding;
            private View view;
            
            LayoutBestiaryElementViewHolder(final LayoutBestiaryElementBinding binding) {
                final ConstraintLayout root = binding.getRoot();
                this.view = (View)root;
                this.binding = binding;
                ((View)root).setTag((Object)this);
            }
        }
    }
    
    private static class BestiaryGridAdapter extends ArrayAdapter<Enemy>
    {
        List<Enemy> enemies;
        int resource;
        
        public BestiaryGridAdapter(final Context context, final int resource, final List<Enemy> enemies) {
            super(context, resource);
            this.resource = resource;
            this.enemies = enemies;
        }
        
        public int getCount() {
            return this.enemies.size();
        }
        
        public View getView(int imageId, final View view, final ViewGroup viewGroup) {
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup)null);
            }
            final ImageView imageView = (ImageView)inflate.findViewById(2131296829);
            final Enemy enemy = (Enemy)this.enemies.get(imageId);
            final boolean contains = MainActivity.data.getSeenEnemies().contains((Object)enemy.getTrueClass());
            final Resources resources = this.getContext().getResources();
            if (contains) {
                imageId = enemy.getImageId();
            }
            else {
                imageId = 2131231937;
            }
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, imageId, this.getContext().getTheme()));
            return inflate;
        }
    }
    
    private static class DoctrinesAdapter extends BaseAdapter
    {
        Adventurer adventurer;
        List<Doctrine> doctrines;
        
        public DoctrinesAdapter(final List<Doctrine> doctrines, final Adventurer adventurer) {
            this.doctrines = doctrines;
            this.adventurer = adventurer;
        }
        
        private Doctrine get(final int n) {
            final Iterator iterator = this.doctrines.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                final Doctrine doctrine = (Doctrine)iterator.next();
                if (n == n2) {
                    return doctrine;
                }
                ++n2;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + n + " of a Set with size " + this.doctrines.size());
        }
        
        public int getCount() {
            return this.doctrines.size();
        }
        
        public Object getItem(final int n) {
            return this.get(n);
        }
        
        public long getItemId(final int n) {
            return 0L;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(2131492971, (ViewGroup)null);
            }
            final TextView textView = (TextView)inflate.findViewById(2131296685);
            final TextView textView2 = (TextView)inflate.findViewById(2131296682);
            final ImageView imageView = (ImageView)inflate.findViewById(2131296683);
            final Doctrine doctrine = (Doctrine)this.doctrines.get(n);
            textView.setText((CharSequence)context.getString(doctrine.getIdName()));
            textView2.setText((CharSequence)context.getString(doctrine.getIdDescriptionShort()));
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), doctrine.getIdImage(), context.getTheme()));
            inflate.setOnClickListener((View$OnClickListener)new UIUtils$DoctrinesAdapter$$ExternalSyntheticLambda0(this, doctrine));
            return inflate;
        }
    }
    
    private static class FaqAdapter extends BaseAdapter
    {
        List<Faq> faqs;
        
        public FaqAdapter(final List<Faq> faqs) {
            this.faqs = faqs;
        }
        
        private Faq get(final int n) {
            final Iterator iterator = this.faqs.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                final Faq faq = (Faq)iterator.next();
                if (n == n2) {
                    return faq;
                }
                ++n2;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + n + " of a Set with size " + this.faqs.size());
        }
        
        public int getCount() {
            return this.faqs.size();
        }
        
        public Object getItem(final int n) {
            return this.get(n);
        }
        
        public long getItemId(final int n) {
            return 0L;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(2131492978, (ViewGroup)null);
            }
            final TextView textView = (TextView)inflate.findViewById(2131296965);
            final Faq faq = (Faq)this.faqs.get(n);
            textView.setText(faq.title);
            inflate.setOnClickListener((View$OnClickListener)new UIUtils$FaqAdapter$$ExternalSyntheticLambda1(context, faq));
            return inflate;
        }
    }
    
    private static class GridAdapter extends ArrayAdapter<Item>
    {
        List<Item> items;
        int resource;
        
        public GridAdapter(final Context context, final int resource, final List<Item> items) {
            super(context, resource);
            this.resource = resource;
            this.items = items;
        }
        
        public int getCount() {
            return this.items.size();
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup)null);
            }
            final ImageView imageView = (ImageView)inflate.findViewById(2131296829);
            final TextView textView = (TextView)inflate.findViewById(2131297272);
            final Item item = (Item)this.items.get(n);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(this.getContext().getResources(), item.getIdImage(), this.getContext().getTheme()));
            imageView.setBackgroundResource(UIUtils.backgroundFromRarity(item.getRarity()));
            textView.setText((CharSequence)String.valueOf(item.getStack()));
            return inflate;
        }
    }
    
    private static class GridAdapterEnemies extends ArrayAdapter<EnemyCounter>
    {
        List<EnemyCounter> enemies;
        int resource;
        
        public GridAdapterEnemies(final Context context, final int resource, final List<EnemyCounter> enemies) {
            super(context, resource);
            this.resource = resource;
            this.enemies = enemies;
        }
        
        public int getCount() {
            return this.enemies.size();
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup)null);
            }
            final ImageView imageView = (ImageView)inflate.findViewById(2131296829);
            final TextView textView = (TextView)inflate.findViewById(2131297272);
            final EnemyCounter enemyCounter = (EnemyCounter)this.enemies.get(n);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(this.getContext().getResources(), Enemy.getInstance(enemyCounter.getEnemy()).getImageId(), this.getContext().getTheme()));
            imageView.setBackgroundResource(2131231405);
            textView.setText((CharSequence)String.valueOf(enemyCounter.getTimesSlain()));
            return inflate;
        }
    }
    
    private static class KingMessagesAdapter extends BaseAdapter
    {
        List<KingMessage> messages;
        
        public KingMessagesAdapter(final List<KingMessage> messages) {
            this.messages = messages;
        }
        
        private KingMessage get(final int n) {
            final Iterator iterator = this.messages.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                final KingMessage kingMessage = (KingMessage)iterator.next();
                if (n == n2) {
                    return kingMessage;
                }
                ++n2;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + n + " of a Set with size " + this.messages.size());
        }
        
        public int getCount() {
            return this.messages.size();
        }
        
        public Object getItem(final int n) {
            return this.get(n);
        }
        
        public long getItemId(final int n) {
            return 0L;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(2131492978, (ViewGroup)null);
            }
            final TextView textView = (TextView)inflate.findViewById(2131296965);
            final KingMessage kingMessage = (KingMessage)this.messages.get(n);
            textView.setText(kingMessage.title);
            inflate.setOnClickListener((View$OnClickListener)new UIUtils$KingMessagesAdapter$$ExternalSyntheticLambda1(context, kingMessage));
            return inflate;
        }
    }
    
    private static class PetsGridAdapter extends ArrayAdapter<Pet>
    {
        List<Pet> pets;
        int resource;
        
        public PetsGridAdapter(final Context context, final int resource, final List<Pet> pets) {
            super(context, resource);
            this.resource = resource;
            this.pets = pets;
        }
        
        public int getCount() {
            return this.pets.size();
        }
        
        public View getView(int visibility, final View view, final ViewGroup viewGroup) {
            View inflate = view;
            if (view == null) {
                inflate = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(this.resource, (ViewGroup)null);
            }
            final ImageView imageView = (ImageView)inflate.findViewById(2131296829);
            final TextView textView = (TextView)inflate.findViewById(2131296895);
            final ImageView imageView2 = (ImageView)inflate.findViewById(2131296421);
            final Pet pet = (Pet)this.pets.get(visibility);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(this.getContext().getResources(), pet.getIdImage(), this.getContext().getTheme()));
            textView.setText((CharSequence)String.valueOf(pet.getLevel()));
            if (pet.isFavourite()) {
                visibility = 0;
            }
            else {
                visibility = 4;
            }
            imageView2.setVisibility(visibility);
            return inflate;
        }
    }
    
    private static class RecipesAdapter extends BaseAdapter
    {
        List<Recipes> recipes;
        
        public RecipesAdapter(final List<Recipes> recipes) {
            this.recipes = recipes;
        }
        
        private Recipes get(final int n) {
            final Iterator iterator = this.recipes.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                final Recipes recipes = (Recipes)iterator.next();
                if (n == n2) {
                    return recipes;
                }
                ++n2;
            }
            throw new IndexOutOfBoundsException("Trying to access element " + n + " of a Set with size " + this.recipes.size());
        }
        
        public int getCount() {
            return this.recipes.size();
        }
        
        public Object getItem(final int n) {
            return this.get(n);
        }
        
        public long getItemId(final int n) {
            return 0L;
        }
        
        public View getView(int n, final View view, final ViewGroup viewGroup) {
            LayoutCraftNamedViewHolder layoutCraftNamedViewHolder;
            if (view == null) {
                layoutCraftNamedViewHolder = new LayoutCraftNamedViewHolder(LayoutCraftNamedBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
            }
            else {
                layoutCraftNamedViewHolder = (LayoutCraftNamedViewHolder)view.getTag();
            }
            final LayoutCraftNamedBinding access$000 = layoutCraftNamedViewHolder.binding;
            final Context context = access$000.getRoot().getContext();
            final Recipes value = this.get(n);
            access$000.name.setText(value.getResult().getIdName());
            access$000.result.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), value.getResult().getIdImage(), context.getTheme()));
            access$000.result.image.setBackgroundResource(UIUtils.backgroundFromRarity(value.getResult().getRarity()));
            access$000.result.stack.setText((CharSequence)String.valueOf(value.getResult().getStack()));
            access$000.result.getRoot().setOnClickListener((View$OnClickListener)new UIUtils$RecipesAdapter$$ExternalSyntheticLambda0(value));
            access$000.ingredient1.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), ((Item)value.getIngredients().get(0)).getIdImage(), context.getTheme()));
            access$000.ingredient1.image.setBackgroundResource(UIUtils.backgroundFromRarity(((Item)value.getIngredients().get(0)).getRarity()));
            access$000.ingredient1.stack.setText((CharSequence)String.valueOf(((Item)value.getIngredients().get(0)).getStack()));
            final TextView stack = access$000.ingredient1.stack;
            final Resources resources = context.getResources();
            final boolean gotEnoughItem = Utils.gotEnoughItem((Item)value.getIngredients().get(0));
            final int n2 = 2131099765;
            if (gotEnoughItem) {
                n = 2131099765;
            }
            else {
                n = UIUtils.getFailureColor();
            }
            stack.setTextColor(resources.getColor(n, context.getTheme()));
            access$000.ingredient1.getRoot().setOnClickListener((View$OnClickListener)new UIUtils$RecipesAdapter$$ExternalSyntheticLambda1(value));
            if (value.getIngredients().size() > 1) {
                access$000.plusSign1.setVisibility(0);
                access$000.ingredient2.getRoot().setVisibility(0);
                access$000.ingredient2.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), ((Item)value.getIngredients().get(1)).getIdImage(), context.getTheme()));
                access$000.ingredient2.image.setBackgroundResource(UIUtils.backgroundFromRarity(((Item)value.getIngredients().get(1)).getRarity()));
                access$000.ingredient2.stack.setText((CharSequence)String.valueOf(((Item)value.getIngredients().get(1)).getStack()));
                final TextView stack2 = access$000.ingredient2.stack;
                final Resources resources2 = context.getResources();
                if (Utils.gotEnoughItem((Item)value.getIngredients().get(1))) {
                    n = 2131099765;
                }
                else {
                    n = UIUtils.getFailureColor();
                }
                stack2.setTextColor(resources2.getColor(n, context.getTheme()));
                access$000.ingredient2.getRoot().setOnClickListener((View$OnClickListener)new UIUtils$RecipesAdapter$$ExternalSyntheticLambda2(value));
            }
            else {
                access$000.plusSign1.setVisibility(8);
                access$000.ingredient2.getRoot().setVisibility(8);
            }
            if (value.getIngredients().size() > 2) {
                access$000.plusSign2.setVisibility(0);
                access$000.ingredient3.getRoot().setVisibility(0);
                access$000.ingredient3.image.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), ((Item)value.getIngredients().get(2)).getIdImage(), context.getTheme()));
                access$000.ingredient3.image.setBackgroundResource(UIUtils.backgroundFromRarity(((Item)value.getIngredients().get(2)).getRarity()));
                access$000.ingredient3.stack.setText((CharSequence)String.valueOf(((Item)value.getIngredients().get(2)).getStack()));
                final TextView stack3 = access$000.ingredient3.stack;
                final Resources resources3 = context.getResources();
                if (Utils.gotEnoughItem((Item)value.getIngredients().get(2))) {
                    n = n2;
                }
                else {
                    n = UIUtils.getFailureColor();
                }
                stack3.setTextColor(resources3.getColor(n, context.getTheme()));
                access$000.ingredient3.getRoot().setOnClickListener((View$OnClickListener)new UIUtils$RecipesAdapter$$ExternalSyntheticLambda3(value));
            }
            else {
                access$000.plusSign2.setVisibility(8);
                access$000.ingredient3.getRoot().setVisibility(8);
            }
            return layoutCraftNamedViewHolder.view;
        }
        
        private static class LayoutCraftNamedViewHolder
        {
            private LayoutCraftNamedBinding binding;
            private View view;
            
            LayoutCraftNamedViewHolder(final LayoutCraftNamedBinding binding) {
                final ConstraintLayout root = binding.getRoot();
                this.view = (View)root;
                this.binding = binding;
                ((View)root).setTag((Object)this);
            }
        }
    }
    
    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter
    {
        public ScreenSlidePagerAdapter(final FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
        
        public Fragment createFragment(final int n) {
            if (n == 1) {
                return (Fragment)new AdventurersFragment();
            }
            if (n == 2) {
                return (Fragment)new DungeonsFragment();
            }
            if (n != 3) {
                return (Fragment)new HeadquartersFragment();
            }
            return (Fragment)new RaidsFragment();
        }
        
        public int getItemCount() {
            int n;
            if (RaidsFragment.VISIBLE) {
                n = 4;
            }
            else {
                n = 3;
            }
            return n;
        }
    }
}
