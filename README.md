NameSplitter, a name splitter for Java
============

Utility to split names into the three common names using a backtracking algorithm. Automatically detects if has three, two or one name. 

## Usage

```java
NameSplitter nameSplitter = new NameSplitter("Name that I want to split");
String firstName = nameSplitter.getFirstName();
String middleName = nameSplitter.getMiddleName();
String lastName = nameSplitter.getLastName();
```

or

```java
String nameToSplit = "Name that I want to split";
String firstName = NameSplitter.split(nameToSplit)[NameSplitter.FIRST_NAME];
String middleName = NameSplitter.split(nameToSplit)[NameSplitter.MIDDLE_NAME];
String lastName = NameSplitter.split(nameToSplit)[NameSplitter.LAST_NAME];
```

Adapted for spanish names but extensible for others countries names.

## Accuracy of splitting

Tested with a total of 230 spanish names with an accuracy of 98.7%.
