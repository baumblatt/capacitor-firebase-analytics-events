import {
	BeginCheckoutEvent,
	CampaignDetailsEvent, CheckoutProgressEvent,
	EarnVirtualCurrencyEvent,
	ECommercePurchaseEvent,
	LevelEndEvent, LevelStartEvent, LevelUpEvent, PurchaseRefundEvent, SpendVirtualCurrencyEvent
} from './events';

declare module "@capacitor/core" {
	interface PluginRegistry {
		CapacitorFirebaseAnalyticsEvents: CapacitorFirebaseAnalyticsEventsPlugin;
	}
}

export interface CapacitorFirebaseAnalyticsEventsPlugin {
	/**
	 * Add Payment Info event.
	 */
	addPaymentInfo(): Promise<void>;

	/**
	 * E-Commerce Begin Checkout event.
	 */
	beginCheckout(options: { event: BeginCheckoutEvent }): Promise<void>;

	/**
	 * Log this event to supply the referral details of a re-engagement campaign.
	 */
	campaignDetails(options: { event: CampaignDetailsEvent }): Promise<void>;

	/**
	 * Checkout progress.
	 */
	checkoutProgress(options: { event: CheckoutProgressEvent }): Promise<void>;

	/**
	 * This event tracks the awarding of virtual currency in your app.
	 */
	earnVirtualCurrency(options: { event: EarnVirtualCurrencyEvent }): Promise<void>;

	/**
	 * Spend Virtual Currency event. This event tracks the sale of virtual goods in your app and
	 * can help you identify which virtual goods are the most popular objects of purchase.
	 */
	spendVirtualCurrency(options: { event: SpendVirtualCurrencyEvent
	}): Promise<void>;

	/**
	 * E-Commerce Purchase event. This event signifies that an item was purchased by a user.
	 */
	eCommercePurchase(options: { event: ECommercePurchaseEvent }): Promise<void>;

	/**
	 * Level End event.
	 */
	levelEnd(options: { event: LevelEndEvent }): Promise<void>;

	/**
	 * Level Start event.
	 */
	levelStart(options: { event: LevelStartEvent }): Promise<void>;

	/**
	 * Level Up event.
	 */
	levelUp(options: { event: LevelUpEvent }): Promise<void>;

	/**
	 * E-Commerce Purchase Refund event. This event signifies that an item purchase was refunded.
	 */
	purchaseRefund(options: { event: PurchaseRefundEvent }): Promise<void>;

	/**
	 * The user ID to ascribe to the user of this app on this device,
	 * which must be non-empty and no more than 256 characters long.
	 * Setting the ID to null removes the user ID.
	 */
	setUserId(options: {userId: string}): Promise<void>;
}
