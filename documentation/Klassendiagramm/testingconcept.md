17.11.2023

# Testing Konzept


## 1. Version

### Was wir testen wollen:
Getestet werden sollen die vorgegebenen Befehle, welche als Klassen angelegt werden. 
Es muss kontrolliert werden, dass die Ausgabe mit Format richtig durchgeführt wird (wegen Leerzeichen & Umbrüchen achtgeben).
Beim CommandInput respektive dem ParameterInput sollen die Regex getestet werden, sodass nur die erlaubten Zeichen bei einer Texteingabe eingelesen werden. 
Ebenso soll getestet werden, dass beim Löschen eines Eintrages oder beim Einfügen eines neuen Eintrages die Indexe der Arraylist korrekt nachgerutscht werden.
Bei einem falsch eingegebenen Befehl soll der User erneut aufgefordert wird, eine Eingabe zu tätigen.
Ob das Programm korrekt beendet werden kann.

#### Automatische Tests sollten für folgende Klassen verfügbar sein:
- Alle Befehlsklassen
- CommandController
- CommandInput/ParameterInput (Regex)

Für andere Klassen werden keine automatischen Tests benötigt, weil ihre Aufgabe zu repetitiv oder unstetig (Input Klassen) ist.

#### Zusammengefasst: 
Ein zentraler Teil des Testingskonzept ist das Testen der vorgegebenen Aufgabenstellung und der dort geforderten Funktionen also die einzelnen Befehle.

### Was wir nicht testen wollen:
Nicht getestet wird das Abspeichern von Texten in der Klasse Paragrafen.
Ebenfalls das Ausgeben auf der Konsole von normalen unformatierten Texten wie die Start-message oder die Instruktionen. 

