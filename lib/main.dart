// Copyright (c) 2022, the Dart project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter_extend_mz_demo_jinigen/my_utils.dart';
import 'package:jni/jni.dart';




JObject activity = JObject.fromRef(Jni.getCurrentActivity());

final hashmap = HashMap.ctor2(JString.type, JString.type);

extension IntX on int {
  JString toJString() {
    return toString().toJString();
  }
}

void showToast() {
  final toastCount =
  hashmap.getOrDefault("toastCount".toJString(), 0.toJString());
  final newToastCount = (int.parse(toastCount.toDartString()) + 1).toJString();
  hashmap.put("toastCount".toJString(), newToastCount);
  final message =
      '${newToastCount.toDartString()} - ${Build.MODEL.toDartString()}';
  MyUtils.showToast(activity, message.toJString(), 0);
}
void sm(){

  log('${MyUtils.sum1(1, 2)}');
}

void showAlerDialog(){
  MyUtils.showAlertDialog(activity);
}

void openCamera(){
  MyUtils.openCamera(activity);
}
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Forward Extend MZ',
      theme: ThemeData(
        primarySwatch: Colors.blueGrey,
      ),
      home: const MyHomePage(title: 'Flutter Forward Extend Mozambique'),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              child: const Text('Show Device Model'),
              onPressed: () {
              showToast();
              },
            ),
            ElevatedButton(
              child: const Text('Show Alert Dialog'),
              onPressed: () {
                showAlerDialog();
              },
            ),
            ElevatedButton(
              child: const Text('Open Camera'),
              onPressed: () {
                openCamera();
              },
            ),
          ],
        ),
      ),
    );
  }
}
