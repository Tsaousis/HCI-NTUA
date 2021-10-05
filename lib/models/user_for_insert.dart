import 'package:flutter/foundation.dart';

class UserManipulation {
  // String adressTo;
  DateTime now =DateTime.now();
  //
  // OrderManipulation(
  //     {
  //       @required this.adressTo,
  //     }
  //     );
  Map<String, dynamic> toJson() {
    return {
      "isActive": true,
      "realHourStart": now.toString()
    };
  }
}
