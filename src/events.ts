export interface BeginCheckoutEvent {
	transactionId?: string;
	currency?: string;
	value?: number;

	//==== Hotels booking params
	numberOfNights?: number;
	numberOfRooms?: number;

	//==== Travel params
	numberOfPassengers?: number;
	origin?: string;
	destination?: string;
	startDate?: string;
	endDate?: string;
	travelClass?: string;
}

export interface CampaignDetailsEvent {
	source: string;
	medium: string;
	campaign: string;
	term?: string;
	content?: string;
	aclid?: string;
	cp1?: string;
}

export interface CheckoutProgressEvent {
	checkoutStep: number;
	checkoutOption: string;
}

export interface ECommercePurchaseEvent {
	transactionId?: string;
	currency?: string;
	value?: number;
	tax?: number;
	shipping?: number;
	coupon?: string;
	location?: string;

	//==== Hotels booking params
	numberOfNights?: number;
	numberOfRooms?: number;

	//==== Travel params
	numberOfPassengers?: number;
	origin?: string;
	destination?: string;
	startDate?: string;
	endDate?: string;
	travelClass?: string;
}

export interface EarnVirtualCurrencyEvent {
	virtualCurrencyName: string;
	value: number;
}

export interface SpendVirtualCurrencyEvent {
	itemName: string;
	virtualCurrencyName: string;
	value: number;
}

export interface LevelStartEvent {
	levelName: number;
}

export interface LevelUpEvent {
	level: number;
	character?: string;
}

export interface LevelEndEvent {
	levelName: number;
	success?: string;
}

export interface PurchaseRefundEvent {
	currency: string;
	value: number;
	transactionId: string;
}
