package task;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WebAddressParser {
    //набор приватных членов
    private String url;
    //указывает паттерн url адреса, разбиваем url на группы с помощью метода паттерн и мэтчер,
    //группы отделяются друг от друга скобками
    //группа начинает считаться от 1, а не от нуля
    //1 группа, схема//2 группа, логин
    //3 группа, пароль
    //4 группа, хост
    //5 группа, порт
    //6 группа, url путь
    //7 группа, параметры
    //8 группа, якорь
    private Pattern pattern = Pattern.compile("(https?|ftp|file):(//(([a-zA-Z0-9_]+)(:([a-zA-Z0-9_]+))@)?([a-zA-Z0-9_|.]+)*(:([0-9{4}]+))?)?(\\/([a-zA-Z0-9_|/]+))*(\\?([a-zA-Z0-9_|=&]+))*(\\#([a-zA-Zа-яА-Я0-9_]+))?");

    //конструктор
    public WebAddressParser(String url){
        this.url = url;
        if(isValid()){
            this.url = url;
        } else {
            this.url = "";
        }
    }

    //методы, собираем первый метчер, который будет сравнивать паттерн с правильным url
    public boolean isValid(){
        Matcher matcher = pattern.matcher(this.url);
        return matcher.matches();
    }

    //нужго сравнить первую группу с правильной первой группой, если верно, то записывает ее
    public String getScheme(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(1) != null)
            return matcher.group(1);
        else
            return "";
    }

    public String getLogin(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(4) != null)
            return matcher.group(4);
        else
            return "";
    }

    public String getPassword(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(6) != null)
            return matcher.group(6);
        else
            return "";
    }

    public String getHost(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(7) != null)
            return matcher.group(7);
        else
            return "";
    }

    public String getPort(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(9) != null)
            return matcher.group(9);
        else
            return "";
    }

    public String getUrl(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(11) != null)
            return matcher.group(11);
        else
            return "";
    }

    public HashMap <String, String> getParameters(){
        HashMap <String, String> parameters = new HashMap<>();
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(13) != null){
            String[] params = (matcher.group(13)).split("&|=");
            for(int i = 0; i < params.length; i+=2){
                parameters.put(params[i], params[i+1]);
            }
            return parameters;
        }
        else
            return parameters;
    }

    public String getFragment(){
        Matcher matcher = pattern.matcher(this.url);
        if(matcher.find() && matcher.group(15) != null)
            return matcher.group(15);
        else
            return "";
    }
}