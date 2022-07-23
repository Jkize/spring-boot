<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="resources/css/style.css" rel="stylesheet" />

    <style>
      html,
      body {
        margin-left: 15px;
        margin-right: 15px;
        padding: 0px;
        font-family: Verdana, Arial, Helvetica, sans-serif;
      }

      table {
        border-collapse: collapse;
        border-bottom: 1px solid gray;
        font-family: Tahoma, Verdana, Segoe, sans-serif;
        width: 72%;
      }

      th {
        border-bottom: 1px solid gray;
        background: none repeat scroll 0 0 #09c332;
        padding: 10px;
        color: #ffffff;
      }

      tr {
        border-top: 1px solid gray;
        text-align: center;
      }

      tr:nth-child(even) {
        background: #ffffff;
      }
      tr:nth-child(odd) {
        background: #bbbbbb;
      }

      #wrapper {
        width: 100%;
        margin-top: 0px;
      }
      #header {
        width: 70%;
        background: #09c332;
        margin-top: 0px;
        padding: 15px 0px 15px 15px;
      }
      #header h2 {
        width: 100%;
        margin: auto;
        color: #ffffff;
      }
      #container {
        width: 100%;
        margin: auto;
      }
      #container h3 {
        color: #000;
      }
      #container #content {
        margin-top: 20px;
      }

      .add-button {
        border: 1px solid #666;
        border-radius: 5px;
        padding: 4px;
        font-size: 12px;
        font-weight: bold;
        width: 120px;
        padding: 5px 10px;

        margin-bottom: 15px;
        background: #cccccc;
      }
    </style>

    <link rel="stylesheet" type="text/css" media="screen" />
  </head>
  <body>
    <h1>Hello WOrld</h1>

    <div id="wrapper">
      <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
      </div>
    </div>

    <div id="container">
      <div id="content">
        <table>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>

          <c:forEach var="tempCustomer" items="${customers}">
            <tr>
              <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
