# GOT - Internet Guide

## Table of contents
* [General info](#general-info)
* [Tools](#tools)
* [Libraries](#libraries)
* [Example of use](#example-of-use)

## General info

GOT(Górska Odznaka Turystyczna) is an motivational award for people who climb polish mountains. The rules are very easy - for each reached trail you get appropriate number of points, if you get enough number of points - you get award. There are thousands of trails and  each of them has a point value, color, estimated time of travel and many others... Planning the route can be cumbersome and discourage many people. That is why I decided to build this app. 

It allows **generate routes** which meets user's requirements. User is asked for data such as **starting point** and **end point** and optionally **intermediate points**. The generator will display the **fastest route** and  **alternative** one which usually is **more valuable** in points. App also allows **access** to all trails belonging to GOT program(they can be **filtered**). Logged users have access to more "secret" data and can **modify/add** trails.

## Tools
App is build using technologies such as: 
* Java 11
* Spring 2.6.2
* Oracle DB / H2 DB(for github users) 
* JavaScript
* HTML
* CSS

## Libraries
Two main libraries used in app:
* JGraphT(https://jgrapht.org/) -  a Java library of graph theory data structures and algorithms.
* Google Guava(https://github.com/google/guava) - set of core Java libraries from Google that includes new collection types (such as multimap and multiset), immutable collections, a graph library, and utilities for concurrency, I/O, hashing, caching, primitives, strings, and more!

## Example of use
Main page
![main page](https://user-images.githubusercontent.com/72096306/154324780-1d14265e-ee92-4316-97fa-c3dcfe398bfe.png)

List of available trails with all important informations. User has possibility to filter that list.
![image](https://user-images.githubusercontent.com/72096306/154325315-1de8760a-fc44-49f8-9038-9b9c8ebcbe34.png)

Filtered list(trails marked as a GREEN and points for reaching between 10, 14)
![image](https://user-images.githubusercontent.com/72096306/154325438-33bcbab3-7ed4-41ab-82c9-2c469a621857.png)

Route generator. Points have been chosen and user can generate route which will start in Chuda Przełączka, end in Rysy and visits Polana Huciska, Rakoń, Wyżnia Kira Miętusia.
![image](https://user-images.githubusercontent.com/72096306/154325725-e28cfa4c-520a-4be1-bb73-27ccf74bea15.png)

The visualization of route. On the screen is seen the fastest possible route which is just ordered list of trails.
![image](https://user-images.githubusercontent.com/72096306/154325844-4620d1ee-51ee-4104-9b3b-702f89d57f13.png)

The alternative route.
![image](https://user-images.githubusercontent.com/72096306/154325955-cef6a524-dd32-4cb7-978d-58a8c789f41c.png)

Administrator view(if you want to have access to that type **username=admin** **password=admin** in login page). There are some actions allowed only for logged users. Administrator can add and modify trails.
![image](https://user-images.githubusercontent.com/72096306/154326081-ad9275e6-494c-4ebe-9367-a199cda057fe.png)




