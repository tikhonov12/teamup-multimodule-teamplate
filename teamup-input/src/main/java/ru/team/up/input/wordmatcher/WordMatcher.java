package ru.team.up.input.wordmatcher;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author Pavel Kondrashov on 23.10.2021
 */
@Component
public class WordMatcher {
    private final Pattern badWords = Pattern.compile("(?iu)\b(\n" +
            "(у|[нз]а|(хитро|не)?вз?[ыьъ]|с[ьъ]|(и|ра)[зс]ъ?|(о[тб]|под)[ьъ]?|(.\\B)+?[оаеи])?-?" +
            "([её]б(?!о[рй])|и[пб][ае][тц]).*?|\n" +
            "(н[иеа]|([дп]|верт)о|ра[зс]|з?а|с(ме)?|о(т|дно)?|апч)?-?ху([яйиеёю]|ли(?!ган)).*?|\n" +
            "(в[зы]|(три|два|четыре)жды|(н|сук)а)?-?бл(я(?!(х|ш[кн]|мб)[ауеыио]).*?|[еэ][дт]ь?)|\n" +
            "(ра[сз]|[зн]а|[со]|вы?|п(ере|р[оие]|од)|и[зс]ъ?|[ао]т)?п[иеё]зд.*?|\n" +
            "(за)?п[ие]д[аое]?р([оа]м|(ас)?(ну.*?|и(ли)?[нщктл]ь?)?|(о(ч[еи])?|ас)?к(ой)|юг)[ауеы]?|\n" +
            "манд([ауеыи](л(и[сзщ])?[ауеиы])?|ой|[ао]вошь?(е?к[ауе])?|юк(ов|[ауи])?)|\n" +
            "муд([яаио].*?|е?н([ьюия]|ей))|\n" +
            "мля([тд]ь)?|лять|([нз]а|по)х|\n" +
            "м[ао]л[ао]фь([яию]|[еёо]й)\n" +
            ")\b", Pattern.CASE_INSENSITIVE);

    private final Pattern unnecessaryWords = Pattern.compile("(?iu)\\b(\n" +
            "([уyu]|[нзnz3][аa]|(хитро|не)?[вvwb][зz3]?[ыьъi]|[сsc][ьъ']|(и|[рpr][аa4])[зсzs]ъ?|" +
            "([оo0][тбtb6]|[пp][оo0][дd9])[ьъ']?|(.\\B)+?[оаеиeo])?-?([еёe][бb6](?!о[рй])|и[пб][ае][тц]).*?|\n" +
            "([нn][иеаaie]|([дпdp]|[вv][еe3][рpr][тt])[оo0]|[рpr][аa][зсzc3]|[з3z]?[аa]|с(ме)?|[оo0]" +
            "([тt]|дно)?|апч)?-?[хxh][уuy]([яйиеёюuie]|ли(?!ган)).*?|\n" +
            "([вvw][зы3z]|(три|два|четыре)жды|(н|[сc][уuy][кk])[аa])?-?[бb6][лl]([яy]" +
            "(?!(х|ш[кн]|мб)[ауеыио]).*?|[еэe][дтdt][ь']?)|\n" +
            "([рp][аa][сзc3z]|[знzn][аa]|[соsc]|[вv][ыi]?|[пp]([еe][рpr][еe]|[рrp][оиioеe]|[оo0][дd])" +
            "|и[зс]ъ?|[аоao][тt])?[пpn][иеёieu][зz3][дd9].*?|\n" +
            "([зz3][аa])?[пp][иеieu][дd][аоеaoe]?[рrp](ну.*?|[оаoa][мm]|([аa][сcs])?([иiu]([лl][иiu])?" +
            "[нщктлtlsn]ь?)?|([оo](ч[еиei])?|[аa][сcs])?[кk]([оo]й)?|[юu][гg])[ауеыauyei]?|\n" +
            "[мm][аa][нnh][дd]([ауеыayueiи]([лl]([иi][сзc3щ])?[ауеыauyei])?|[оo][йi]|[аоao][вvwb][оo]" +
            "(ш|sh)[ь']?([e]?[кk][ауеayue])?|юк(ов|[ауи])?)|\n" +
            "[мm][уuy][дd6]([яyаиоaiuo0].*?|[еe]?[нhn]([ьюия'uiya]|ей))|\n" +
            "мля([тд]ь)?|лять|([нз]а|по)х|\n" +
            "м[ао]л[ао]фь([яию]|[её]й)\n" +
            ")\\b", Pattern.CASE_INSENSITIVE);

    public boolean detectBadWords(String text) {
        return badWords.matcher(text).find();
    }

    public boolean detectUnnecessaryWords(String text) {
        return unnecessaryWords.matcher(text).find();
    }
}
