## TextEditor

Diese Klasse bildet das Herz des Editors ab. Sie verwaltet das ganze Programm und beinhaltet auch die run() Methode.
Zusätzlich speichert sie das Objekt unseres Textes

### Interaktion mit anderen Klassen

- InstructiuonsPrinter: übergabe der Instructions
- Text: erstellen, speichern und delegierung der Referenz
- CommandInput: ruft auf um Command zu erhalten
- CommandController: Aufruf und delegierung des Commands


## InstructionsPrinter

Printed für den User die nötigen Instructions, damit das Programm gut bedienbar ist.

Interagiert mit keiner anderen Klasse, sondern wird nur aufgerufen

## CommandInput

Ist einer der Schnittstellen zwischen User und dem Programm und holt sich die Commands via Scanner

### Interaktion mit anderen Klassen

- core.TextEditor: ruft CommandInput aufgerufen und gibt Command zurück

## (Enum) Commands

Ist zuständig für die Input-Validierung und gibt diesen entweder zurück oder einen leeren String, wenn der Input Invalid ist.

### Interaktion mit anderen Klassen
- ActionTupel: übergibt Befehl für Validierung
- CommandController: überprüft in Switch-Case die verschiedenen Enums

## Text

Die Klasse speichert, verwaltet und gibt die Absätzen zurück welche vom benutzer erstellt werden, indem er eine liste mit Instanzen von der Klasse Paragraph speichert.

### Interaktion mit anderen Klassen
- Paragraph: ruft auf um die einzelnen Absätze jeweils in einzelnen Instanzen von der Klasse Paragraph zu speichern.

Paragraph speichert lediglich die Absätze des benutzers und gibt diese zurück

## ParameterInput

Die Aufgabe dieser Klasse ist es den User nach dem Input gewisser (Befehlsabhängiger) Parameter zu fragen, resp.. diese einzulesen.

### Interaktion mit anderen Klassen
- OutputPrinter: übergabe der Resultate die ausgabe der Anuforderung
- CommandParameter:  aufruf um benötigte Parameter abzufragen

## OutputPrinter
Ist für die Ausgabe auf die Konsole zuständig. Er printet Resultate und Errors.

Interagiert mit keiner anderen Klasse, sondern wird nur aufgerufen

## CommandController
Der Command Controller ist für das Erstellen von dem richtigen Command mit den richtigen Parametern verantwortlich.
Er bekommt ein ActionTupel, ruft dann ParameterInput auf um die zusätzlichen Parametern abzufragen und dann wird callCommand aufgerufen.

### Interaktion mit anderen Klassen
- ParameterInput: Wird benutzt um die weiteren Parameter zu vom User abzufragen.
- CommandsInterface: Wird benutzt wenn ein Command Objekt erstellt wird (z.B. ADD).

## CommandParameter
Ist ein Datentyp, welcher von den einzelnen Commands als Liste an den CommandInput delegiert wird

### Interaktion mit anderen Klassen
- Alle Commands: wird in einer Liste übergeben
- ParameterInput: bekommt Liste mit CommandParameter

## ActionTupel

Fungiert als reiner Datentyp welcher von Texteditor aufgerufen und dem Commandcontroller übergeben wird.
Sie beinhaltet den Enum Typ Befehl und den einen String mit der eingabe des Benutzter.

### Interaktion mit anderen Klassen
- (Enum) Commands: wird in ActionTupel gespeichert