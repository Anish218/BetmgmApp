package com.example.assignmentone.data.Api
object LobbyBodyService {
    const val lobbyQuery = "{\n" +
            "  lobbyResponse {\n" +
            "    id\n" +
            "    template {\n" +
            "      name\n" +
            "      folder\n" +
            "    }\n" +
            "    page\n" +
            "    widgets {\n" +
            "      title\n" +
            "      type\n" +
            "      id\n" +
            "      templateName\n" +
            "      order\n" +
            "      payload {\n" +
            "        fixtures {\n" +
            "          fixtureId\n" +
            "          name\n" +
            "          stage\n" +
            "          startTime\n" +
            "          sport {\n" +
            "            id\n" +
            "            name\n" +
            "          }\n" +
            "          competition {\n" +
            "            sportId\n" +
            "            type\n" +
            "            id\n" +
            "            name\n" +
            "          }\n" +
            "          participateContentList {\n" +
            "            participateId\n" +
            "            imageURL\n" +
            "            imageLogo\n" +
            "            name\n" +
            "          }\n" +
            "          finalGameContentList{\n" +
            "                                    key\n" +
            "                                    value{\n" +
            "                                      optionNames\n" +
            "                                      sixPackKey\n" +
            "                                      gameId\n" +
            "                                      content\n" +
            "                                      index\n" +
            "                                      resultList {\n" +
            "                                        resultId\n" +
            "                                        nameResult\n" +
            "                                        name\n" +
            "                                        odd\n" +
            "                                        visibility\n" +
            "                                      }\n" +
            "\n" +
            "                                      gridGroupingId\n" +
            "                                      spread\n" +
            "                                      grouping {\n" +
            "                                        gridGroups\n" +
            "                                      }\n" +
            "\n" +
            "                                    }\n" +
            "\n" +
            "                                  }\n" +
            "\n" +
            "                                  finalOptionMarkets{\n" +
            "                                    key\n" +
            "                                    value{\n" +
            "                                      index\n" +
            "                                      optionNames\n" +
            "                                      optionMarketName\n" +
            "                                      optionMarketId\n" +
            "                                      options {\n" +
            "                                        optionid\n" +
            "                                        optionSourceName\n" +
            "                                        optionName\n" +
            "                                        optionPriceAmericanOdds\n" +
            "                                        optionPriceDenominator\n" +
            "                                        optionPriceId\n" +
            "                                        optionPriceNumerator\n" +
            "                                        optionOdds\n" +
            "                                      }\n" +
            "                                    }\n" +
            "                                  }\n" +
            "\n" +
            "                                  finalOutridgeGames {\n" +
            "                                    outridgeGames {\n" +
            "                                      resultId\n" +
            "                                      name\n" +
            "                                      odd\n" +
            "                                    }\n" +
            "                                    maxRows\n" +
            "                                  }\n" +
            "        }\n" +
            "        items {\n" +
            "          title\n" +
            "          mergeNavigation\n" +
            "          showCount\n" +
            "          children {\n" +
            "            id\n" +
            "            templateName\n" +
            "            order\n" +
            "            type\n" +
            "            navigation {\n" +
            "              competetionId\n" +
            "              id\n" +
            "              count\n" +
            "              name\n" +
            "              type\n" +
            "              sport {\n" +
            "                type\n" +
            "                id\n" +
            "                name {\n" +
            "                  value\n" +
            "                }\n" +
            "              }\n" +
            "            }\n" +
            "         }\n" +
            "          activeChildren {\n" +
            "            type\n" +
            "            id\n" +
            "            templateName\n" +
            "            order\n" +
            "            payload {\n" +
            "              fixtures {\n" +
            "                    fixtureId\n" +
            "                      name\n" +
            "                       stage\n" +
            "                        startTime\n" +
            "                              sport {\n" +
            "                              id\n" +
            "                              name\n" +
            "                              }\n" +
            "                                competition {\n" +
            "                                  sportId\n" +
            "                                  type\n" +
            "                                  id\n" +
            "                                  name\n" +
            "                                }\n" +
            "                                participateContentList {\n" +
            "                                  participateId\n" +
            "                                  imageURL\n" +
            "                                  name\n" +
            "                                  }\n" +
            "                                  finalGameContentList{\n" +
            "                                    key\n" +
            "                                    value{\n" +
            "                                      gameId\n" +
            "                                      sixPackKey\n" +
            "                                      content\n" +
            "                                      resultList {\n" +
            "                                        resultId\n" +
            "                                        name\n" +
            "                                        nameResult\n" +
            "                                        odd\n" +
            "                                        visibility\n" +
            "                                      }\n" +
            "\n" +
            "                                      gridGroupingId\n" +
            "                                      spread\n" +
            "                                      grouping {\n" +
            "                                        gridGroups\n" +
            "                                      }\n" +
            "\n" +
            "                                    }\n" +
            "\n" +
            "                                  }\n" +
            "\n" +
            "                                  finalOptionMarkets{\n" +
            "                                    key\n" +
            "                                    value{\n" +
            "                                      index\n" +
            "                                      optionNames\n" +
            "                                      optionMarketName\n" +
            "                                      optionMarketId\n" +
            "                                      options {\n" +
            "                                        optionid\n" +
            "                                        optionSourceName\n" +
            "                                        optionName\n" +
            "                                        optionPriceAmericanOdds\n" +
            "                                        optionPriceDenominator\n" +
            "                                       optionPriceId\n" +
            "                                        optionPriceNumerator\n" +
            "                                        optionOdds\n" +
            "                                      }\n" +
            "                                    }\n" +
            "                                  }\n" +
            "\n" +
            "                                  finalOutridgeGames {\n" +
            "                                    outridgeGames {\n" +
            "                                      resultId\n" +
            "                                      name\n" +
            "                                      odd\n" +
            "                                    }\n" +
            "                                    maxRows\n" +
            "                                  }\n" +
            "         \n" +
            "                }\n" +
            "                                marketGroups {\n" +
            "                              sportId\n" +
            "                              groups {\n" +
            "                                id\n" +
            "                                name\n" +
            "                                optionNames\n" +
            "                              }\n" +
            "                              sixPackGroups {\n" +
            "                                id\n" +
            "                                name\n" +
            "                                optionNames\n" +
            "                              }\n" +
            "                            }\n" +
            "                            navigation {\n" +
            "          id\n" +
            "          competetionId\n" +
            "          name\n" +
            "          type\n" +
            "          sport {\n" +
            "            id\n" +
            "            name {\n" +
            "              value\n" +
            "            }\n" +
            "          }\n" +
            "          region {\n" +
            "            id\n" +
            "            name {\n" +
            "              value\n" +
            "            }\n" +
            "          }\n" +
            "          count\n" +
            "        }\n" +
            "           \n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "        primaryActiveNavigation\n" +
            "        navigation {\n" +
            "          competetionId\n" +
            "          id\n" +
            "          name\n" +
            "          type\n" +
            "          sport {\n" +
            "            id\n" +
            "            name {\n" +
            "              value\n" +
            "            }\n" +
            "          }\n" +
            "          region {\n" +
            "            id\n" +
            "            name {\n" +
            "              value\n" +
            "            }\n" +
            "          }\n" +
            "          count\n" +
            "        }\n" +
            "        marketGroups {\n" +
            "          sportId\n" +
            "          groups {\n" +
            "            id\n" +
            "            name\n" +
            "            optionNames\n" +
            "         }\n" +
            "          sixPackGroups {\n" +
            "            id\n" +
            "            name\n" +
            "            optionNames\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}\n"

}