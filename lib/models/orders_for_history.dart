class OrderForHistoryListing {

  int orderID;
  String price;
  String adressTo;
  DateTime timeToPickup;
  bool runningNow;
  int store;
  String storeName;

  OrderForHistoryListing({this.orderID, this.price, this.adressTo, this.timeToPickup, this.runningNow ,this.store,this.storeName});
  factory OrderForHistoryListing.fromJson(Map<String, dynamic> item) {
    return OrderForHistoryListing(
        orderID: item["id"],
        price: item["price"],
        adressTo: item["adress_to"],
        runningNow: item["running_now"],
        timeToPickup: DateTime.parse(item["time_to_pickup"]),
        store: item["store"],
        storeName : item["store_name"]


    );
  }}
