module talks {
    exports zoo.animal.talks.content;
 // exports zoo.animal.talks.content to zoo.staff;
    exports zoo.animal.talks.media;
    exports zoo.animal.talks.schedule;

    requires feeding;
    requires care;
}