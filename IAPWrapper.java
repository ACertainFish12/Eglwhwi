package it.paranoidsquirrels.idleguildmaster;

import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.android.billingclient.api.BillingFlowParams$ProductDetailsParams;
import com.android.billingclient.api.BillingFlowParams;
import android.app.Activity;
import java.util.function.Predicate;
import java.util.Collection;
import java.util.ArrayList;
import com.android.billingclient.api.PurchaseHistoryRecord;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogShop;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import android.os.Handler;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.Iterator;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.PurchasesUpdatedListener;
import java.util.Arrays;
import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryProductDetailsParams$Product;
import com.android.billingclient.api.ProductDetails;
import java.util.List;
import com.android.billingclient.api.BillingClient;

public class IAPWrapper
{
    public static final String ID_1200_GEMS = "gems_1200";
    public static final String ID_250_GEMS = "gems_250";
    public static final String ID_3300_GEMS = "gems_3300";
    public static final String ID_550_GEMS = "gems_550";
    public static final String ID_ADVENTURER_PACK = "adventurer_pack";
    public static final String ID_IMPERIAL_VANGUARD = "imperial_vanguard";
    public static final String ID_MERCHANT_PACK = "merchant_pack";
    public static final String ID_STARTER_PACK = "starter_pack";
    public static final String ID_UNHOLY_CRUSADE = "unholy_crusade";
    private final BillingClient billingClient;
    public boolean initialized;
    private List<ProductDetails> productDetails;
    private List<QueryProductDetailsParams$Product> products;
    private long reconnectMillis;
    private Runnable refreshAdventurersCallback;
    private Runnable refreshGemsCallback;
    private Runnable refreshHeadquartersCallback;
    private Runnable refreshIconsCallback;
    private Runnable refreshShopCallback;
    
    public IAPWrapper(final Context context) {
        this.initialized = false;
        this.products = (List<QueryProductDetailsParams$Product>)Arrays.asList((Object[])new QueryProductDetailsParams$Product[] { this.buildProduct("gems_250"), this.buildProduct("gems_550"), this.buildProduct("gems_1200"), this.buildProduct("gems_3300"), this.buildProduct("starter_pack"), this.buildProduct("adventurer_pack"), this.buildProduct("merchant_pack"), this.buildProduct("imperial_vanguard"), this.buildProduct("unholy_crusade") });
        this.reconnectMillis = 10L;
        this.billingClient = BillingClient.newBuilder(context).setListener((PurchasesUpdatedListener)new IAPWrapper$$ExternalSyntheticLambda5(this)).enablePendingPurchases().build();
        this.startBillingClientConnection();
    }
    
    static /* synthetic */ long access$030(final IAPWrapper iapWrapper, long reconnectMillis) {
        reconnectMillis *= iapWrapper.reconnectMillis;
        return iapWrapper.reconnectMillis = reconnectMillis;
    }
    
    private QueryProductDetailsParams$Product buildProduct(final String productId) {
        return QueryProductDetailsParams$Product.newBuilder().setProductId(productId).setProductType("inapp").build();
    }
    
    private void handleGemsPurchase(final Purchase purchase, final int n) {
        this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), (ConsumeResponseListener)new IAPWrapper$$ExternalSyntheticLambda1(this, n));
    }
    
    private void handlePackPurchase(final Purchase purchase, final String s) {
        if (!purchase.isAcknowledged()) {
            this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), (AcknowledgePurchaseResponseListener)new IAPWrapper$$ExternalSyntheticLambda0(this, s));
        }
    }
    
    private void handlePurchase(final BillingResult billingResult, final List<Purchase> list) {
        if (billingResult.getResponseCode() == 0 && list != null) {
            for (final Purchase purchase : list) {
                if (purchase.getPurchaseState() == 1) {
                    for (final String s : purchase.getProducts()) {
                        s.hashCode();
                        int n = -1;
                        switch (s.hashCode()) {
                            case 1794061781: {
                                if (!s.equals((Object)"gems_550")) {
                                    break;
                                }
                                n = 3;
                                break;
                            }
                            case 1794058898: {
                                if (!s.equals((Object)"gems_250")) {
                                    break;
                                }
                                n = 2;
                                break;
                            }
                            case -218721093: {
                                if (!s.equals((Object)"gems_3300")) {
                                    break;
                                }
                                n = 1;
                                break;
                            }
                            case -218781636: {
                                if (!s.equals((Object)"gems_1200")) {
                                    break;
                                }
                                n = 0;
                                break;
                            }
                        }
                        switch (n) {
                            default: {
                                this.handlePackPurchase(purchase, s);
                                continue;
                            }
                            case 3: {
                                this.handleGemsPurchase(purchase, 550);
                                continue;
                            }
                            case 2: {
                                this.handleGemsPurchase(purchase, 250);
                                continue;
                            }
                            case 1: {
                                this.handleGemsPurchase(purchase, 2000);
                                continue;
                            }
                            case 0: {
                                this.handleGemsPurchase(purchase, 1200);
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void queryProducts() {
        this.billingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList((List)this.products).build(), (ProductDetailsResponseListener)new IAPWrapper$$ExternalSyntheticLambda2(this));
    }
    
    private void run(final Runnable runnable) {
        ((MainActivity)MainActivity.dungeonsFragment.getActivity()).runOnUiThread(runnable);
    }
    
    private void startBillingClientConnection() {
        this.billingClient.startConnection((BillingClientStateListener)new BillingClientStateListener(this) {
            final IAPWrapper this$0;
            
            public void onBillingServiceDisconnected() {
                new Handler().postDelayed((Runnable)new IAPWrapper$1$$ExternalSyntheticLambda0(this), this.this$0.reconnectMillis);
                IAPWrapper.access$030(this.this$0, 2L);
            }
            
            public void onBillingSetupFinished(final BillingResult billingResult) {
                if (billingResult.getResponseCode() == 0) {
                    this.this$0.reconnectMillis = 10L;
                    this.this$0.queryProducts();
                    this.this$0.queryAsync();
                }
            }
        });
    }
    
    public ProductDetails getProductDetails(final String s) {
        final List<ProductDetails> productDetails = this.productDetails;
        if (productDetails == null) {
            return null;
        }
        for (final ProductDetails productDetails2 : productDetails) {
            if (s.equals((Object)productDetails2.getProductId())) {
                return productDetails2;
            }
        }
        return null;
    }
    
    public void purchaseFlow(final ProductDetails productDetails, final Activity activity) {
        this.billingClient.launchBillingFlow(activity, BillingFlowParams.newBuilder().setProductDetailsParamsList(Arrays.asList((Object[])new BillingFlowParams$ProductDetailsParams[] { BillingFlowParams$ProductDetailsParams.newBuilder().setProductDetails(productDetails).build() })).build());
    }
    
    public void queryAsync() {
        this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), (PurchasesResponseListener)new IAPWrapper$$ExternalSyntheticLambda4(this));
    }
    
    public void restorePurchases() {
        this.billingClient.queryPurchaseHistoryAsync(QueryPurchaseHistoryParams.newBuilder().setProductType("inapp").build(), (PurchaseHistoryResponseListener)new IAPWrapper$$ExternalSyntheticLambda3(this));
    }
    
    public void setRefreshAdventurersCallback(final Runnable refreshAdventurersCallback) {
        this.refreshAdventurersCallback = refreshAdventurersCallback;
    }
    
    public void setRefreshGemsCallback(final Runnable refreshGemsCallback) {
        this.refreshGemsCallback = refreshGemsCallback;
    }
    
    public void setRefreshHeadquartersCallback(final Runnable refreshHeadquartersCallback) {
        this.refreshHeadquartersCallback = refreshHeadquartersCallback;
    }
    
    public void setRefreshIconsCallback(final Runnable refreshIconsCallback) {
        this.refreshIconsCallback = refreshIconsCallback;
    }
    
    public void setRefreshShopCallback(final Runnable refreshShopCallback) {
        this.refreshShopCallback = refreshShopCallback;
    }
}
