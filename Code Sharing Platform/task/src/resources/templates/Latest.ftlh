<html>
  <head>
     <title>Latest</title>
  </head>
  <body>
  <table>
      <#list latestList as snippet>
        <pre id="code_snippet">${snippet.code}</pre>
        <br>
        <span id="load_date">${snippet.date}</span>
      </#list>
  </table>

  </body>
</html>