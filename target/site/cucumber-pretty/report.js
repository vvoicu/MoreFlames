$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/search/Search.feature");
formatter.feature({
  "line": 1,
  "name": "Check search feature",
  "description": "In order to check the search feature\r\nAs a user\r\nI want to search for different terms",
  "id": "check-search-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6087384847,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Searching for a designer",
  "description": "",
  "id": "check-search-feature;searching-for-a-designer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "the user is in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "searches for \u0027GUCCI\u0027 in \u0027women\u0027 section",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "all the products displayed should be from \u0027GUCCI\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "MatchesFasion.givenTheUserIsOnTheHomePage()"
});
formatter.result({
  "duration": 140212162,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GUCCI",
      "offset": 14
    },
    {
      "val": "women",
      "offset": 25
    }
  ],
  "location": "MatchesFasion.givenTheUserSearchesForProduct(String,String)"
});
formatter.result({
  "duration": 15149830041,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GUCCI",
      "offset": 43
    }
  ],
  "location": "MatchesFasion.thenTheUserShouldBeOfSearchedDesigner(String)"
});
formatter.result({
  "duration": 3990465048,
  "status": "passed"
});
formatter.after({
  "duration": 50085,
  "status": "passed"
});
formatter.after({
  "duration": 583840748,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Searching for a product code",
  "description": "",
  "id": "check-search-feature;searching-for-a-product-code",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "the user is in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "searches for \u0027\u003cproduct_code\u003e\u0027 in \u0027women\u0027 section",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the displayed product code should be \u0027\u003cexpected_product_code\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "check-search-feature;searching-for-a-product-code;",
  "rows": [
    {
      "cells": [
        "product_code",
        "expected_product_code"
      ],
      "line": 16,
      "id": "check-search-feature;searching-for-a-product-code;;1"
    },
    {
      "cells": [
        "1059773",
        "1048129"
      ],
      "line": 17,
      "id": "check-search-feature;searching-for-a-product-code;;2"
    },
    {
      "cells": [
        "1048129",
        "1048129"
      ],
      "line": 18,
      "id": "check-search-feature;searching-for-a-product-code;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5554714928,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Searching for a product code",
  "description": "",
  "id": "check-search-feature;searching-for-a-product-code;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "the user is in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "searches for \u00271059773\u0027 in \u0027women\u0027 section",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the displayed product code should be \u00271048129\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MatchesFasion.givenTheUserIsOnTheHomePage()"
});
formatter.result({
  "duration": 127810894,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1059773",
      "offset": 14
    },
    {
      "val": "women",
      "offset": 27
    }
  ],
  "location": "MatchesFasion.givenTheUserSearchesForProduct(String,String)"
});
formatter.result({
  "duration": 14025462666,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1048129",
      "offset": 38
    }
  ],
  "location": "MatchesFasion.verifyThatProductCodeIsCorrect(String)"
});
formatter.result({
  "duration": 3861677094,
  "error_message": "java.lang.AssertionError: The product code is not correct\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.cucumber.stepdefinitions.fashion.MatchesFasion.verifyThatProductCodeIsCorrect(MatchesFasion.java:112)\r\n\tat ✽.Then the displayed product code should be \u00271048129\u0027(src/test/resources/features/search/Search.feature:14)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 3050223328,
  "status": "passed"
});
formatter.after({
  "duration": 637442731,
  "status": "passed"
});
formatter.before({
  "duration": 5557887910,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Searching for a product code",
  "description": "",
  "id": "check-search-feature;searching-for-a-product-code;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "the user is in home page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "searches for \u00271048129\u0027 in \u0027women\u0027 section",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the displayed product code should be \u00271048129\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MatchesFasion.givenTheUserIsOnTheHomePage()"
});
formatter.result({
  "duration": 135797740,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1048129",
      "offset": 14
    },
    {
      "val": "women",
      "offset": 27
    }
  ],
  "location": "MatchesFasion.givenTheUserSearchesForProduct(String,String)"
});
formatter.result({
  "duration": 13794994827,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1048129",
      "offset": 38
    }
  ],
  "location": "MatchesFasion.verifyThatProductCodeIsCorrect(String)"
});
formatter.result({
  "duration": 5872447329,
  "status": "passed"
});
formatter.after({
  "duration": 25453,
  "status": "passed"
});
formatter.after({
  "duration": 660788298,
  "status": "passed"
});
});