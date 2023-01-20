# Assignment1

An application to create different classes of Heroes and equip them with the appropriate types of Weapons and Armor.

- Class Hero as an abstract parent class, from where subclasses like Mage, Warrior, Rogue and Ranger inherit.
- Every subclass has its own list of Valid Weapons and Valid Armor.
- Item as an abstract parent class, from where subclasses like Weapon and Armor inherit.
- Every item has a required level which the hero must reach, in order to be able to equip it.
- Abstract methods in parent classes so that the child classes override them and implement them properly.
- Implementation of methhods in parent classes, when the subclasses share the same functionality.
- Enums for Weapon types, Armor types and Slots.
- Heroes level up and their attribute levels increase accordingly.
- Total attributes calculated on the fly.
- Heroes' damage calculated according to each subclass formula.
- Hero's name, subclass, attributes and damage can be displayed.
- Classes grouped and packaged according to functionality.
- Unit testing for every functionality provided.
- Project built with Maven and test with JUnit 5.
