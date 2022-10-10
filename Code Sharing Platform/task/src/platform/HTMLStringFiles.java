package platform;

public class HTMLStringFiles {
    static final String THEN_ADD_SNIPPET = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre id=\"code_snippet\">\n";
    static final String THEN_ADD_DATE = "</pre>\n" +
            "<span id=\"load_date\">";
    static final String END = "</span>\n" +
            "</body>\n" +
            "</html>";
    static final String HTML_FORM = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<title>Create</title>\n" +
            "<head>\n" +
            "<script>\n" +
            "function send() {\n" +
            "let object = {\n" +
            "'code': document.getElementById('code_snippet').value\n" +
            "};\n" +
            "let json = JSON.stringify(object);\n" +
            "let xhr = new XMLHttpRequest();\n" +
            "xhr.open('POST', '/api/code/new', false)\n" +
            "xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
            "xhr.send(json);\n" +
            "if (xhr.status == 200) {\n" +
            "alert(\"Success!\");\n" +
            "}\n" +
            "}\n" +
            "</script>\n" +
            "</head>\n" +
            "<body>\n" +
            "<textarea id='code_snippet'></textarea>\n" +
            "<button id='send_snippet' type='submit' onclick='send()'>Submit</button>\n" +

            "</body>\n" +
            "</html>\n";

}
