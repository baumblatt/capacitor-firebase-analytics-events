package com.baumblatt.capacitor.firebase.analytics;

import android.os.Bundle;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.json.JSONException;

@NativePlugin()
public class CapacitorFirebaseAnalyticsEvents extends Plugin {
    private static final String PLUGIN_TAG = "CapFireAnalyticsEvents";
    private FirebaseAnalytics firebaseAnalytics;

    public void load() {
        Log.d(PLUGIN_TAG, "Verifying if the default FirebaseApp was initialized.");
        if(FirebaseApp.getApps(this.getContext()).size() == 0) {
            Log.d(PLUGIN_TAG, "Initializing the default FirebaseApp ");
            FirebaseApp.initializeApp(this.getContext());
        }

        firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
    }

	/**
	 * Add Payment Info event.
	 */
    @PluginMethod()
    public void addPaymentInfo(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event ADD_PAYMENT_INFO");

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_PAYMENT_INFO, new Bundle());
        call.success();
    }

    /**
     * E-Commerce Begin Checkout event.
     */
    @PluginMethod()
    public void beginCheckout(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event BEGIN_CHECKOUT");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log BEGIN_CHECKOUT");
            call.reject("The event's parameters are required to log BEGIN_CHECKOUT");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getString(value, "transactionId", bundle, FirebaseAnalytics.Param.TRANSACTION_ID);
        getDouble(value, "value", bundle, FirebaseAnalytics.Param.VALUE);
        getString(value, "currency", bundle, FirebaseAnalytics.Param.CURRENCY);

        //==== Hotels booking params
        getLong(value, "numberOfNights", bundle, FirebaseAnalytics.Param.NUMBER_OF_NIGHTS);
        getLong(value, "numberOfRooms", bundle, FirebaseAnalytics.Param.NUMBER_OF_ROOMS);

        //==== Travel params
        getLong(value, "numberOfPassengers", bundle, FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS);
        getString(value, "origin", bundle, FirebaseAnalytics.Param.ORIGIN);
        getString(value, "destination", bundle, FirebaseAnalytics.Param.DESTINATION);
        getString(value, "startDate", bundle, FirebaseAnalytics.Param.START_DATE);
        getString(value, "endDate", bundle, FirebaseAnalytics.Param.END_DATE);
        getString(value, "travelClass", bundle, FirebaseAnalytics.Param.TRAVEL_CLASS);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.BEGIN_CHECKOUT, bundle);
        call.success();
    }

	/**
	 * Log this event to supply the referral details of a re-engagement campaign.
	 */
    @PluginMethod()
    public void campaignDetails(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event CAMPAIGN_DETAILS");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log CAMPAIGN_DETAILS");
            call.reject("The event's parameters are required to log CAMPAIGN_DETAILS");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getString(value, "source", bundle, FirebaseAnalytics.Param.SOURCE);
        getString(value, "medium", bundle, FirebaseAnalytics.Param.MEDIUM);
        getString(value, "campaign", bundle, FirebaseAnalytics.Param.CAMPAIGN);
        getString(value, "term", bundle, FirebaseAnalytics.Param.TERM);
        getString(value, "content", bundle, FirebaseAnalytics.Param.CONTENT);
        getString(value, "aclid", bundle, FirebaseAnalytics.Param.ACLID);
        getString(value, "cp1", bundle, FirebaseAnalytics.Param.CP1);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.CAMPAIGN_DETAILS, bundle);
        call.success();
    }

	/**
	 * Checkout progress.
	 */
    @PluginMethod()
    public void checkoutProgress(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event CHECKOUT_PROGRESS");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log CHECKOUT_PROGRESS");
            call.reject("The event's parameters are required to log CHECKOUT_PROGRESS");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getLong(value, "checkoutStep", bundle, FirebaseAnalytics.Param.CHECKOUT_STEP);
        getString(value, "checkoutOption", bundle, FirebaseAnalytics.Param.CHECKOUT_OPTION);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.CHECKOUT_PROGRESS, bundle);
        call.success();
    }

	/**
	 * This event tracks the awarding of virtual currency in your app.
	 */
    @PluginMethod()
    public void earnVirtualCurrency(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event EARN_VIRTUAL_CURRENCY");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log EARN_VIRTUAL_CURRENCY");
            call.reject("The event's parameters are required to log EARN_VIRTUAL_CURRENCY");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getNumber(value, "value", bundle, FirebaseAnalytics.Param.VALUE);
        getString(value, "virtualCurrencyName", bundle, FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.EARN_VIRTUAL_CURRENCY, bundle);
        call.success();
    }

	/**
	 * Spend Virtual Currency event. This event tracks the sale of virtual goods in your app and
	 * can help you identify which virtual goods are the most popular objects of purchase.
	 */
    @PluginMethod()
    public void spendVirtualCurrency(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event SPEND_VIRTUAL_CURRENCY");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log SPEND_VIRTUAL_CURRENCY");
            call.reject("The event's parameters are required to log SPEND_VIRTUAL_CURRENCY");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getString(value, "itemName", bundle, FirebaseAnalytics.Param.ITEM_NAME);
        getNumber(value, "value", bundle, FirebaseAnalytics.Param.VALUE);
        getString(value, "virtualCurrencyName", bundle, FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SPEND_VIRTUAL_CURRENCY, bundle);
        call.success();
    }

	/**
	 * E-Commerce Purchase event. This event signifies that an item was purchased by a user.
	 */
    @PluginMethod()
    public void eCommercePurchase(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event E-COMMERCE_PURCHASE");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log E-COMMERCE_PURCHASE");
            call.reject("The event's parameters are required to log E-COMMERCE_PURCHASE");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getString(value, "transactionId", bundle, FirebaseAnalytics.Param.TRANSACTION_ID);
        getDouble(value, "value", bundle, FirebaseAnalytics.Param.VALUE);
        getString(value, "currency", bundle, FirebaseAnalytics.Param.CURRENCY);

        getDouble(value, "tax", bundle, FirebaseAnalytics.Param.TAX);
        getDouble(value, "shipping", bundle, FirebaseAnalytics.Param.SHIPPING);
        getString(value, "coupon", bundle, FirebaseAnalytics.Param.COUPON);
        getString(value, "location", bundle, FirebaseAnalytics.Param.LOCATION);

        //==== Hotels booking params
        getLong(value, "numberOfNights", bundle, FirebaseAnalytics.Param.NUMBER_OF_NIGHTS);
        getLong(value, "numberOfRooms", bundle, FirebaseAnalytics.Param.NUMBER_OF_ROOMS);

        //==== Travel params
        getLong(value, "numberOfPassengers", bundle, FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS);
        getString(value, "origin", bundle, FirebaseAnalytics.Param.ORIGIN);
        getString(value, "destination", bundle, FirebaseAnalytics.Param.DESTINATION);
        getString(value, "startDate", bundle, FirebaseAnalytics.Param.START_DATE);
        getString(value, "endDate", bundle, FirebaseAnalytics.Param.END_DATE);
        getString(value, "travelClass", bundle, FirebaseAnalytics.Param.TRAVEL_CLASS);


        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, bundle);
        call.success();
    }

	/**
	 * Level End event.
	 */
    @PluginMethod()
    public void levelEnd(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event LEVEL_END");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log LEVEL_END");
            call.reject("The event's parameters are required to log LEVEL_END");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getLong(value, "levelName", bundle, FirebaseAnalytics.Param.LEVEL_NAME);
        getString(value, "success", bundle, FirebaseAnalytics.Param.SUCCESS);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LEVEL_END, bundle);
        call.success();
    }

	/**
	 * Level Start event.
	 */
    @PluginMethod()
    public void levelStart(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event LEVEL_START");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log LEVEL_START");
            call.reject("The event's parameters are required to log LEVEL_START");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getLong(value, "levelName", bundle, FirebaseAnalytics.Param.LEVEL_NAME);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LEVEL_START, bundle);
        call.success();
    }

	/**
	 * Level Up event.
	 */
    @PluginMethod()
    public void levelUp(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event LEVEL_UP");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log LEVEL_UP");
            call.reject("The event's parameters are required to log LEVEL_UP");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getLong(value, "levelName", bundle, FirebaseAnalytics.Param.LEVEL_NAME);
        getString(value, "character", bundle, FirebaseAnalytics.Param.CHARACTER);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LEVEL_UP, bundle);
        call.success();
    }

	/**
	 * E-Commerce Purchase Refund event. This event signifies that an item purchase was refunded.
	 */
    @PluginMethod()
    public void purchaseRefund(PluginCall call) {
        Log.d(PLUGIN_TAG, "Firebase analytics event PURCHASE_REFUND");

        if (!call.getData().has("event")) {
            Log.w(PLUGIN_TAG, "The event's parameters are required to log PURCHASE_REFUND");
            call.reject("The event's parameters are required to log PURCHASE_REFUND");
            return;
        }

        JSObject value = call.getObject("event");
        Bundle bundle = new Bundle();

        getString(value, "transactionId", bundle, FirebaseAnalytics.Param.TRANSACTION_ID);
        getDouble(value, "value", bundle, FirebaseAnalytics.Param.VALUE);
        getString(value, "currency", bundle, FirebaseAnalytics.Param.CURRENCY);

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.PURCHASE_REFUND, bundle);
        call.success();
    }

    private void getString(JSObject value, String name, Bundle bundle, String param) {
        if (value.has(name)) {
            bundle.putString(param, value.getString(name));
        }
    }

    private void getDouble(JSObject value, String name, Bundle bundle, String param) {
        try {
            if (value.has(name)) {
                bundle.putDouble(param, value.getDouble(name));
            }
        } catch (JSONException exception) {
            Log.d(PLUGIN_TAG, String.format("Can't parse as double from JSObject for parameter %s from value of %s", param, name));
        }
    }

    private void getLong(JSObject value, String name, Bundle bundle, String param) {
        try {
            if (value.has(name)) {
                bundle.putLong(param, value.getLong(name));
            }
        } catch (JSONException exception) {
            Log.d(PLUGIN_TAG, String.format("Can't parse as long from JSObject for parameter %s from value of %s", param, name));
        }
    }

    private void getNumber(JSObject value, String name, Bundle bundle, String param) {
        try {
            if (value.has(name)) {
                Object object = value.get(name);

                if (object instanceof Integer) {
                    bundle.putInt(param, value.getInt(name));
                } else if (object instanceof Long) {
                    bundle.putLong(param, value.getLong(name));
                } else if (object instanceof Double) {
                    bundle.putDouble(param, value.getDouble(name));
                } else {
                    Log.d(PLUGIN_TAG, String.format("Can't parse as number from JSObject for parameter %s from value of %s", param, name));
                }
            }
        } catch (JSONException exception) {
            Log.d(PLUGIN_TAG, String.format("Can't parse as long from JSObject for parameter %s from value of %s", param, name));
        }
    }
}
