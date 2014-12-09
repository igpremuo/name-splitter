com.igpremuo.utils.NameSplitter
============

Utility to split names into the three commons names using a backtracking algorithm.

### Usage

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

- First name
- Middle name
- Last name

Adapted for spanish names but extensible for others countries.

### Test

Tested with a total of 230 spanish names with an accurate of 98.7%.