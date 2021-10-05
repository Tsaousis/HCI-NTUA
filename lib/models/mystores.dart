class StoreForListing {

  int storeID;
  String name;
  String adress;
  String phone;

  StoreForListing({this.storeID, this.name, this.adress, this.phone });
  factory StoreForListing.fromJson(Map<String, dynamic> item) {
    return StoreForListing(
        storeID: item["user"],
        name: item["name"],
        adress : item["adress"],
        phone: item["phone"],

    );
  }}
