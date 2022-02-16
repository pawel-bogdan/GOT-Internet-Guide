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
* JGraphT(https://jgrapht.org/) -  a Java library of graph theory data structures and algorithms
* Google Guava(https://github.com/google/guava) - set of core Java libraries from Google that includes new collection types (such as multimap and multiset), immutable collections, a graph library, and utilities for concurrency, I/O, hashing, caching, primitives, strings, and more!

## Example of use
Main page
![main page](https://user-images.githubusercontent.com/72096306/154324780-1d14265e-ee92-4316-97fa-c3dcfe398bfe.png)



