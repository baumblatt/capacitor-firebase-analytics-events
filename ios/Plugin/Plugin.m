#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(CapacitorFirebaseAnalyticsEvents, "CapacitorFirebaseAnalyticsEvents",
           CAP_PLUGIN_METHOD(addPaymentInfo, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(beginCheckout, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(campaignDetails, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(checkoutProgress, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(earnVirtualCurrency, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(spendVirtualCurrency, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(eCommercePurchase, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(levelEnd, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(levelStart, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(levelUp, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(purchaseRefund, CAPPluginReturnPromise);
)
