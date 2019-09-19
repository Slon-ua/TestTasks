For start test write in the console
    $ mvn clean test -DtestngFile=testNGSuite.xml -Denv=dev -Dbrws=Firefox
or
    $ mvn clean test -Dtest='*/HomePageTest' -Denv=dev -Dbrws=Firefox

    $ mvn clean test -Dtest='*/HomePageTest'       /     $ mvn clean test

