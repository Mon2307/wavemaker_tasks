<html>
<head>
  <link rel="stylesheet" href="src/main/webapp/style.css">
  <style>
  body{
  align-content:center;
  }
  form {
  border: 3px solid #f1f1f1;
  }
  input[type=submit]  {
    width: 15%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
  }
  input[type=reset] {
   padding: 10px 12px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
  }
  </style>
</head>
<body>

<form action="get" id="form1" style="background-color:ADD8E6; width: 40%;align-items: center;padding:5%;margin-left:25%;">
  <label for="first"
  style="font-family: 'Trebuchet MS', sans-serif;
  font-width:bold;

   margin: 8px 0;
   display: inline-block;
   box-sizing: border-box;" >First number:</label>

  <input type="text"  name="first" style="font-size:bold;  font-family: 'Trebuchet MS', sans-serif;"><br><br>
  <label for="second" style="font-family: 'Trebuchet MS', sans-serif;
                        font-width:bold;

                         margin: 8px 0;
                         display: inline-block;
                         box-sizing: border-box;">Second number:</label>
    <input type="text" name="second"><br>
    <br>
    <p style=" font-family: 'Trebuchet MS', sans-serif;">Select an Operation:</p>
    <input type="submit" name="operator" value="+" style="margin:2px">
     <input type="submit" name="operator" value="-">
   <input type="submit"name="operator" value="*">
     <input type="submit" name="operator" value="/">
     <br>
     <input type="reset">

</form>

</body>
</html>
