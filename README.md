# JalgoTrader
Stock market trader written in Java. Uses Alpaca as the stock trading api.


## Dependencies
* AlpaciAPI from Jacob Peterson
* org.json

## RoadMap

The roadmap is subject to change.

* Version 1.0 - Standalone client

## How to run

Jalgo uses gradle. The command to run is

`gradle runJalgo`

Jalgo offers a a text and gui implementation, however the main focus in development right now is GUI. Options can be choosen based on passing an arguements. Arguments for UI choice are 'gui' or 'text.' However, as GUI is the priority, do not expect the text implementation to be complete. Examples of passing in args:

`gradle runJalgo --args="text"`
`gradle runJalgo --args="gui"`
