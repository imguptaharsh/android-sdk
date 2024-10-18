// lib/main.dart

import 'dart:developer';

import 'package:flutter/material.dart';
import 'dart:async'; // For async operations
import 'package:flutter/services.dart'; // For platform channels

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  _MyAppState createState() => _MyAppState();
}

// Define the platform channel
const platform = MethodChannel('com.example.myandroidsdk/mysdk');

class _MyAppState extends State<MyApp> {
  String _androidVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
    _getAndroidVersion();
  }

  Future<void> _getAndroidVersion() async {
    String androidVersion;
    try {
      final String result = await platform.invokeMethod('printAndroidVersion');
      androidVersion = result;
      log("res: $result");
    } on PlatformException catch (e) {
      androidVersion = "Failed to get Android version: '${e.message}'.";
    }

    setState(() {
      _androidVersion = androidVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter with Android SDK',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Hello World Flutter App'),
        ),
        body: Center(
          child: Text('Android Version: $_androidVersion'),
        ),
      ),
    );
  }
}
