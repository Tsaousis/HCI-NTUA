// import 'dart:async';
// import 'dart:convert';
//
// import 'package:flutter/cupertino.dart';
// import 'package:orders/utils/api.dart';
// import 'package:http/http.dart' as http;
// import 'package:orders/utils/http_exception.dart';
// import 'package:shared_preferences/shared_preferences.dart';
//
// class Auth with ChangeNotifier {
//   var MainUrl = Api.authUrl;
//   var key = Api.key;
//
//   String _token;
//   // String _userId;
//   String _username;
//   // DateTime _expiryDate;
//   Timer _authTimer;
//
//   bool get isAuth {
//     return token != null;
//   }
//
//   String get token {
//     // if (_expiryDate != null &&
//     //     _expiryDate.isAfter(DateTime.now()) &&
//     //     _token != null)
//     {
//       return _token;
//     }
//   }
//
//   // String get userId {
//   //   return _userId;
//   // }
//
//   String get username {
//     return _username;
//   }
//
//   Future<void> logout() async {
//     _token = null;
//     _username = null;
//
//     // _userId = null;
//     // _expiryDate = null;
//     //
//     // // if (_authTimer != null) {
//     // //   _authTimer.cancel();
//     // //   _authTimer = null;
//     // }
//
//     notifyListeners();
//
//     final pref = await SharedPreferences.getInstance();
//     pref.clear();
//   }
//   //
//   // void _autologout() {
//   //   if (_authTimer != null) {
//   //     _authTimer.cancel();
//   //   }
//   //   final timetoExpiry = _expiryDate.difference(DateTime.now()).inSeconds;
//   //   _authTimer = Timer(Duration(seconds: timetoExpiry), logout);
//   // }
//
//   Future<bool> tryautoLogin() async {
//     final pref = await SharedPreferences.getInstance();
//     if (!pref.containsKey('userData')) {
//       print('hi');
//       return false;
//       print('hi');
//     }
//
//     final extractedUserData =
//         json.decode(pref.getString('userData')) as Map<String, Object>;
//
//     // final expiryDate = DateTime.parse(extractedUserData['expiryDate']);
//     // if (expiryDate.isBefore(DateTime.now())) {
//     //   return false;
//     // }
//     _token = extractedUserData['key'];
//     // _userId = extractedUserData['userId'];
//     _username = extractedUserData['username'];
//     // _expiryDate = expiryDate;
//     notifyListeners();
//     // _autologout();
//
//     return true;
//   }
//
//   Future<void> Authentication(
//       String username, String password, String endpoint) async {
//
//     try {
//       final url = '${MainUrl}/rest-auth/';
//
//       final responce = await http.post(Uri.parse(url),
//           body: json.encode({
//             'username': username,
//             'password': password,
//             // 'returnSecureToken': true
//           }));
//
//       final responceData = json.decode(responce.body);
//       print('hi');
//       if (responceData['error'] != null) {
//         throw HttpException(responceData['error']['message']);
//       }
//       _token = responceData['key'];
//       // _userId = responceData['localId'];
//       _username = username;
//       // _expiryDate = DateTime.now()
//       //     .add(Duration(seconds: int.parse(responceData['expiresIn'])));
//
//       // _autologout();
//       notifyListeners();
//
//       final prefs = await SharedPreferences.getInstance();
//       final userData = json.encode({
//         'key': _token,
//         // 'userId': _userId,
//         'username': _username,
//         // 'expiryDate': _expiryDate.toIso8601String(),
//       });
//
//       prefs.setString('userData', userData);
//
//       print('check' + userData.toString());
//     } catch (e) {
//       throw e;
//     }
//   }
//
//   Future<void> login(String username, String password) {
//     // print('hi');
//     return Authentication(username, password, 'login');
//   }
//
//   Future<void> signUp(String username, String password) {
//     return Authentication(username, password, 'signUp');
//   }
// }
