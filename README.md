###########################################################################
# README

###########################################################################
# To run the tests (chrome is the default browser, as specified in the config.properties)
mvn clean install

###########################################################################
# To run the tests in a specific browser
mvn clean install -Dbrowser=chrome
mvn clean install -Dbrowser=firefox

###########################################################################
# To view reports
Open the html report from "target/site/allure-maven-plugin/index.html" in a browser to view the test results.

