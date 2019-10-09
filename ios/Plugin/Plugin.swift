import Foundation
import Capacitor
import FirebaseCore
import FirebaseAnalytics

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitor.ionicframework.com/docs/plugins/ios
 */
@objc(CapacitorFirebaseAnalyticsEvents)
public class CapacitorFirebaseAnalyticsEvents: CAPPlugin {

    public override func load() {
        if (FirebaseApp.app() == nil) {
            FirebaseApp.configure()
        }
    }

    @objc func addPaymentInfo(_ call: CAPPluginCall) {
        let parameters = [String : Any]()

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventAddPaymentInfo, parameters: parameters);
            call.success();
        }
    }

    @objc func beginCheckout(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log BEGIN_CHECKOUT")
            return
        }

        var parameters = [String : Any]()

        if let transactionId = event["transactionId"] as? String {
            parameters[AnalyticsParameterTransactionID] =  transactionId
        }

        if let value = event["value"] as? Double {
            parameters[AnalyticsParameterValue] =  value
        }

        if let currency = event["currency"] as? String {
            parameters[AnalyticsParameterCurrency] =  currency
        }

        //==== Hotels booking params
        if let numberOfNights = event["numberOfNights"] as? Int {
            parameters[AnalyticsParameterNumberOfNights] =  numberOfNights
        }

        if let numberOfRooms = event["numberOfRooms"] as? Int {
            parameters[AnalyticsParameterNumberOfRooms] =  numberOfRooms
        }

        //==== Travel params
        if let numberOfPassengers = event["numberOfPassengers"] as? Int {
            parameters[AnalyticsParameterNumberOfPassengers] =  numberOfPassengers
        }

        if let origin = event["origin"] as? String {
            parameters[AnalyticsParameterOrigin] =  origin
        }

        if let destination = event["destination"] as? String {
            parameters[AnalyticsParameterDestination] =  destination
        }

        if let startDate = event["startDate"] as? String {
            parameters[AnalyticsParameterStartDate] =  startDate
        }

        if let endDate = event["endDate"] as? String {
            parameters[AnalyticsParameterEndDate] =  endDate
        }

        if let travelClass = event["travelClass"] as? String {
            parameters[AnalyticsParameterTravelClass] =  travelClass
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventBeginCheckout, parameters: parameters);
            call.success();
        }
    }

    @objc func campaignDetails(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log CAMPAIGN_DETAILS")
            return
        }

        var parameters = [String : Any]()

        if let source = event["source"] as? String {
            parameters[AnalyticsParameterSource] =  source
        }

        if let medium = event["medium"] as? String {
            parameters[AnalyticsParameterMedium] =  medium
        }

        if let campaign = event["campaign"] as? String {
            parameters[AnalyticsParameterCampaign] =  campaign
        }

        if let term = event["term"] as? String {
            parameters[AnalyticsParameterTerm] =  term
        }

        if let content = event["content"] as? String {
            parameters[AnalyticsParameterContent] =  content
        }

        if let aclid = event["aclid"] as? String {
            parameters[AnalyticsParameterAdNetworkClickID] =  aclid
        }

        if let cp1 = event["cp1"] as? String {
            parameters[AnalyticsParameterCP1] =  cp1
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventCampaignDetails, parameters: parameters);
            call.success();
        }
    }

    @objc func checkoutProgress(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log CHECKOUT_PROGRESS")
            return
        }

        var parameters = [String : Any]()

        if let checkoutStep = event["checkoutStep"] as? Int {
            parameters[AnalyticsParameterCheckoutStep] =  checkoutStep
        }

        if let checkoutOption = event["checkoutOption"] as? String {
            parameters[AnalyticsParameterCheckoutOption] =  checkoutOption
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventCheckoutProgress, parameters: parameters);
            call.success();
        }
    }

    @objc func earnVirtualCurrency(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log EARN_VIRTUAL_CURRENCY")
            return
        }

        var parameters = [String : Any]()

        if let virtualCurrencyName = event["virtualCurrencyName"] as? String {
            parameters[AnalyticsParameterVirtualCurrencyName] =  virtualCurrencyName
        }

        if let value = event["value"] as? Double {
            parameters[AnalyticsParameterValue] =  value
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventEarnVirtualCurrency, parameters: parameters);
            call.success();
        }
    }

    @objc func spendVirtualCurrency(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log SPEND_VIRTUAL_CURRENCY")
            return
        }

        var parameters = [String : Any]()

        if let itemName = event["itemName"] as? String {
            parameters[AnalyticsParameterItemName] =  itemName
        }

        if let virtualCurrencyName = event["virtualCurrencyName"] as? String {
            parameters[AnalyticsParameterVirtualCurrencyName] =  virtualCurrencyName
        }

        if let value = event["value"] as? Double {
            parameters[AnalyticsParameterValue] =  value
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventSpendVirtualCurrency, parameters: parameters);
            call.success();
        }
    }

    @objc func eCommercePurchase(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log ECOMMERCE_PURCHASE")
            return
        }

        var parameters = [String : Any]()

        if let transactionId = event["transactionId"] as? String {
            parameters[AnalyticsParameterTransactionID] =  transactionId
        }

        if let value = event["value"] as? Double {
            parameters[AnalyticsParameterValue] =  value
        }

        if let currency = event["currency"] as? String {
            parameters[AnalyticsParameterCurrency] =  currency
        }

        if let tax = event["tax"] as? Double {
            parameters[AnalyticsParameterTax] =  tax
        }

        if let shipping = event["shipping"] as? Double {
            parameters[AnalyticsParameterShipping] =  shipping
        }

        if let coupon = event["coupon"] as? String {
            parameters[AnalyticsParameterCoupon] =  coupon
        }

        if let location = event["location"] as? String {
            parameters[AnalyticsParameterLocation] =  location
        }

        //==== Hotels booking params
        if let numberOfNights = event["numberOfNights"] as? Int {
            parameters[AnalyticsParameterNumberOfNights] =  numberOfNights
        }

        if let numberOfRooms = event["numberOfRooms"] as? Int {
            parameters[AnalyticsParameterNumberOfRooms] =  numberOfRooms
        }

        //==== Travel params
        if let numberOfPassengers = event["numberOfPassengers"] as? Int {
            parameters[AnalyticsParameterNumberOfPassengers] =  numberOfPassengers
        }

        if let origin = event["origin"] as? String {
            parameters[AnalyticsParameterOrigin] =  origin
        }

        if let destination = event["destination"] as? String {
            parameters[AnalyticsParameterDestination] =  destination
        }

        if let startDate = event["startDate"] as? String {
            parameters[AnalyticsParameterStartDate] =  startDate
        }

        if let endDate = event["endDate"] as? String {
            parameters[AnalyticsParameterEndDate] =  endDate
        }

        if let travelClass = event["travelClass"] as? String {
            parameters[AnalyticsParameterTravelClass] =  travelClass
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventEcommercePurchase, parameters: parameters);
            call.success();
        }
    }

    @objc func levelEnd(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log LEVEL_END")
            return
        }

        var parameters = [String : Any]()

        if let levelName = event["levelName"] as? Int {
            parameters[AnalyticsParameterLevelName] =  levelName
        }

        if let success = event["success"] as? String {
            parameters[AnalyticsParameterSuccess] =  success
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventLevelEnd, parameters: parameters);
            call.success();
        }
    }

    @objc func levelStart(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log LEVEL_START")
            return
        }

        var parameters = [String : Any]()

        if let levelName = event["levelName"] as? Int {
            parameters[AnalyticsParameterLevelName] =  levelName
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventLevelStart, parameters: parameters);
            call.success();
        }
    }

    @objc func levelUp(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log LEVEL_UP")
            return
        }

        var parameters = [String : Any]()

        if let levelName = event["levelName"] as? Int {
            parameters[AnalyticsParameterLevelName] =  levelName
        }

        if let character = event["character"] as? String {
            parameters[AnalyticsParameterCharacter] =  character
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventLevelUp, parameters: parameters);
            call.success();
        }
    }

    @objc func purchaseRefund(_ call: CAPPluginCall) {
        guard let event = call.getObject("event") else {
            call.error("The event's parameters are required to log PURCHASE_REFUND")
            return
        }

        var parameters = [String : Any]()

        if let transactionId = event["transactionId"] as? String {
            parameters[AnalyticsParameterTransactionID] =  transactionId
        }

        if let value = event["value"] as? Double {
            parameters[AnalyticsParameterValue] =  value
        }

        if let currency = event["currency"] as? String {
            parameters[AnalyticsParameterCurrency] =  currency
        }

        DispatchQueue.main.async {
            Analytics.logEvent(AnalyticsEventPurchaseRefund, parameters: parameters);
            call.success();
        }
    }


}
