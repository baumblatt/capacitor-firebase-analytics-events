import {registerWebPlugin, WebPlugin} from '@capacitor/core';
import * as firebase from 'firebase';
import {CapacitorFirebaseAnalyticsEventsPlugin} from './definitions';
import {
	BeginCheckoutEvent,
	CampaignDetailsEvent,
	CheckoutProgressEvent,
	EarnVirtualCurrencyEvent,
	ECommercePurchaseEvent,
	LevelEndEvent,
	LevelStartEvent,
	LevelUpEvent,
	PurchaseRefundEvent,
	SpendVirtualCurrencyEvent
} from './events';

export class CapacitorFirebaseAnalyticsEventsWeb extends WebPlugin implements CapacitorFirebaseAnalyticsEventsPlugin {
	constructor() {
		super({
			name: 'CapacitorFirebaseAnalyticsEvents',
			platforms: ['web']
		});
	}

	async addPaymentInfo(): Promise<void> {
		// @ts-ignore
		firebase.analytics().logEvent('add_payment_info');

		return Promise.resolve();
	}

	async beginCheckout(options: { event: BeginCheckoutEvent }): Promise<void> {
		firebase.analytics().logEvent('begin_checkout', {
			...options.event,
			transaction_id: options.event.transactionId,
			number_of_nights: options.event.numberOfNights,
			number_of_rooms: options.event.numberOfRooms,
			number_of_passengers: options.event.numberOfPassengers,
			start_date: options.event.startDate,
			end_date: options.event.endDate,
			travel_class: options.event.travelClass,
		});

		return Promise.resolve();
	}

	async campaignDetails(options: { event: CampaignDetailsEvent }): Promise<void> {
		firebase.analytics().logEvent('campaign_details', {
			...options.event
		});

		return Promise.resolve();
	}

	async checkoutProgress(options: { event: CheckoutProgressEvent }): Promise<void> {
		firebase.analytics().logEvent('checkout_progress', {
			checkout_step: options.event.checkoutStep,
			checkout_option: options.event.checkoutOption
		});

		return Promise.resolve();
	}

	async eCommercePurchase(options: { event: ECommercePurchaseEvent }): Promise<void> {
		firebase.analytics().logEvent('purchase', {
			...options.event,
			transaction_id: options.event.transactionId,
			number_of_nights: options.event.numberOfNights,
			number_of_rooms: options.event.numberOfRooms,
			number_of_passengers: options.event.numberOfPassengers,
			start_date: options.event.startDate,
			end_date: options.event.endDate,
			travel_class: options.event.travelClass,
		});

		return Promise.resolve();
	}

	async earnVirtualCurrency(options: { event: EarnVirtualCurrencyEvent }): Promise<void> {
		firebase.analytics().logEvent('earnVirtualCurrency', {
			...options.event,
			virtual_currency_name: options.event.virtualCurrencyName
		});

		return Promise.resolve();

	}

	async levelEnd(options: { event: LevelEndEvent }): Promise<void> {
		firebase.analytics().logEvent('level_end', {
			...options.event,
			level_name: options.event.levelName
		});

		return Promise.resolve();

	}

	async levelStart(options: { event: LevelStartEvent }): Promise<void> {
		firebase.analytics().logEvent('level_start', {
			...options.event,
			level_name: options.event.levelName
		});

		return Promise.resolve();
	}

	async levelUp(options: { event: LevelUpEvent }): Promise<void> {
		firebase.analytics().logEvent('level_up', {
			...options.event
		});

		return Promise.resolve();
	}

	async purchaseRefund(options: { event: PurchaseRefundEvent }): Promise<void> {
		firebase.analytics().logEvent('purchase_refund', {
			...options.event,
			transaction_id: options.event.transactionId
		});

		return Promise.resolve();
	}

	async spendVirtualCurrency(options: { event: SpendVirtualCurrencyEvent }): Promise<void> {
		firebase.analytics().logEvent('spend_virtual_currency', {
			...options.event,
			virtual_currency_name: options.event.virtualCurrencyName
		});

		return Promise.resolve();
	}

	async setUserId(options: {userId: string}): Promise<void> {
		firebase.analytics().setUserId(options.userId);

		return Promise.resolve();
	}
}

const CapacitorFirebaseAnalyticsEvents = new CapacitorFirebaseAnalyticsEventsWeb();

export {CapacitorFirebaseAnalyticsEvents};

registerWebPlugin(CapacitorFirebaseAnalyticsEvents);
