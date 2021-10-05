
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';
import 'package:orders/services/orders_services.dart';
import 'views/login_page.dart';
import 'package:orders/services/api_service.dart';

// import 'package:flutter/material.dart';
// import 'package:get_it/get_it.dart';
// import 'package:notes/services/notes_service.dart';
// import 'package:notes/views/note_list.dart';

void setupLocator() {
  GetIt.I.registerLazySingleton(() => OrdersService());
}

void main() {
  setupLocator();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Image Loader',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        fontFamily: 'Poppins',
        primaryColor: Colors.white,
        floatingActionButtonTheme: FloatingActionButtonThemeData(
          elevation: 0,
          foregroundColor: Colors.white,
        ),
        accentColor: Colors.redAccent,
        textTheme: TextTheme(
          headline1: TextStyle(fontSize: 22.0, color: Colors.redAccent),
          headline2: TextStyle(
            fontSize: 24.0,
            fontWeight: FontWeight.w700,
            color: Colors.redAccent,
          ),
          bodyText1: TextStyle(
            fontSize: 14.0,
            fontWeight: FontWeight.w400,
            color: Colors.redAccent,
          ),
        ),
      ),
      home: LoginPage(),
    );
  }
}
