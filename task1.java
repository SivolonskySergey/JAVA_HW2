// Задание 1.
// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.

// Входная строка:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"


public class task1 {
    public static void main(String[] args) {
        String rawStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String clearStr = rawStr.replace("{", "")
                                .replace("}", "")
                                .replace("\"", "");
        StringBuilder resultStr = new StringBuilder("select * from students where ");
        String[] commaSeparate = clearStr.split(",");
        for(int i = 0; i < commaSeparate.length; i++) {
            String[] strKeyValue = commaSeparate[i].split(":");
            String key = strKeyValue[0].trim();
            String value = strKeyValue[1].trim();
            if(!value.equals("null")) {
                resultStr.append(key + " = " + "\"" + value + "\"");
                if (i < commaSeparate.length - 2) {
                    resultStr.append(" and ");
                }
            }
        }
        System.out.println(resultStr);
    }
}